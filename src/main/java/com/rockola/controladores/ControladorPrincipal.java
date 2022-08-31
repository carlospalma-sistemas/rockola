package com.rockola.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorPrincipal {
    
    @GetMapping("/")
    public String cargarIndex() {
        return "index";
    }
    
    @GetMapping("/generos")
    public String cargarListaGeneros() {
        return "listageneros";
    }
}
