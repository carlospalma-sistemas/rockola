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
    @Disabled("Registro creado y probado")
    void verificarSiSeGuardaUnGeneroNuevo() {
        GeneroMusical g = new GeneroMusical("Salsa", "salsa", true);
        Assertions.assertDoesNotThrow(()-> {
            servicio.crearNuevoGenero(g);
        }, "No se pudo crear un nueva género");
    }

    @Test
    void verificarSiSeActualizaUnGenero() {
        
    }
}
