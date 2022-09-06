package com.rockola.controladores;

import com.rockola.entidades.GeneroMusical;
import com.rockola.servicios.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorPrincipal {
    
    @Autowired
    private GeneroService servicioGenero;
    
    @GetMapping("/")
    public String cargarIndex() {
        return "index";
    }
    
    @GetMapping("/listageneros")
    public String cargarListaGeneros(Model model) {
        model.addAttribute("listageneros", servicioGenero.consultarGeneros());
        return "listageneros";
    }
    
    @GetMapping("/generos")
    public String cargarFormGeneros(Model model) {
        GeneroMusical genero = new GeneroMusical();
        model.addAttribute("genero", genero);
        return "formgeneros";
    }
    
    @GetMapping("/generos/{id}")
    public String cargarFormGeneros(Model model, @PathVariable int id) {
        model.addAttribute("genero", servicioGenero.consultarGeneros(id));
        return "formgeneros";
    }
    
    @PostMapping("/generos")
    public String guardarGenero(@ModelAttribute("genero") GeneroMusical genero) {
        servicioGenero.crearNuevoGenero(genero);
        return "redirect:/listageneros";
    }
}
