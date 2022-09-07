package com.rockola;

import com.rockola.entidades.GeneroMusical;
import com.rockola.servicios.GeneroService;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

@SpringBootTest
class GenerosUnitTests {

    @Autowired
    private GeneroService servicio;
    
    @Test
    @Disabled("Registro ya creado")
    void verificarSiSeGuardaUnGeneroNuevo() {
        GeneroMusical g = new GeneroMusical("Salsa", "salsa", true);
        Assertions.assertDoesNotThrow(() -> {
            servicio.crearNuevoGenero(g);
        }, "No se pudo crear un nuevo género musical");
    }

    @Test
    void verificarSiNoSeGuardaUnGeneroRepetido() {
        GeneroMusical g = new GeneroMusical("Rock en español", "rock", true);
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
            servicio.crearNuevoGenero(g);
        }, "No se generó excepción desde la base de datos.");
    }
    
    @Test
    void verificarSiNoSeGuardaGeneroInvalido() {
        GeneroMusical g = new GeneroMusical(null, null, false);
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
            servicio.crearNuevoGenero(g);
        }, "No se generó excepción desde la base de datos.");
    }
    
    @Test
    void verificarSiSeCarganTodosLosGeneros() {
        List<GeneroMusical> lista = servicio.consultarGeneros();
        Assertions.assertTrue(lista.size() > 0, "No se cargaron los géneros musicales");
    }
    
    @Test
    void verificarSiSeCargaUnGeneroExistentePorId() {
        GeneroMusical g = servicio.consultarGeneros(1);
        Assertions.assertNotNull(g, "No se cargó género existente");
    }
    
    @Test
    void verificarSiSeCargaUnGeneroExistentePorCriterio() {
        List<GeneroMusical> lista = servicio.consultarGeneros("rock");
        Assertions.assertTrue(lista.size() > 0, "No se cargaron géneros existentes");
    }
    
    @Test
    void verificarSiNoSeCargaUnGeneroNoExistentePorId() {
        GeneroMusical g = servicio.consultarGeneros(10000000);
        Assertions.assertNull(g, "Se cargó género inexistente");
    }
    
}
