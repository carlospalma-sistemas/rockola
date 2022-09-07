package com.rockola.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * index.html              /
 * listageneros.html       /generos
 * formgeneros.html        /generos/form/{id}
 * 
 */

@Controller
public class GenerosController {
    
    @GetMapping("/")
    public String cargarIndex() {
        return "index";
    }
    
    @GetMapping("/generos")
    public String cargarListaGeneros() {
        return "listageneros";
    }
    
    @GetMapping("/generos/form")
    public String cargarFormGeneros() {
        return "formgeneros";
    }
}
