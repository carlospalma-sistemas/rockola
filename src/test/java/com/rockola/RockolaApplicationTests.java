package com.rockola;

import com.rockola.entidades.GeneroMusical;
import com.rockola.servicios.GeneroService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RockolaApplicationTests {

    @Autowired
    private GeneroService servicio;
    
    @Test
    @Disabled
    void verificarSiSeGuardaUnGeneroNuevo() {
        GeneroMusical g = new GeneroMusical("Salsa", "salsa", true);
        GeneroMusical guardado = servicio.crearNuevoGenero(g);
        Assertions.assertTrue(guardado != null, "ERROR, no se pudo guardar nuevo genero");
    }

    @Test
    @Disabled
    void verificarSiSeActualizaUnGenero() {
        GeneroMusical g = new GeneroMusical("Cumbia", "cumbia", true);
        GeneroMusical guardado = servicio.crearNuevoGenero(g);
        guardado.setCarpeta("cumbiaspegaditas");
        guardado.setHab(false);
        GeneroMusical actualizado = servicio.actualizarGenero(guardado);
        Assertions.assertTrue(actualizado.getCarpeta().equals("cumbiaspegaditas") , "ERROR, no se pudo actualizar genero");
        Assertions.assertTrue(actualizado.isHab() == false , "ERROR, no se pudo actualizar genero");
    }
}
