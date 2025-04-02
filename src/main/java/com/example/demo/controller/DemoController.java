package com.example.demo.controller;

import com.example.demo.model.Actor;
import com.example.demo.service.SakilaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DemoController {
    private SakilaService actorService;

    @Autowired
    public DemoController(SakilaService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/prueba")
    public String prueba(Model model) {
        return "prueba";
    }


    @GetMapping("/")
    public String demo(Model model) {
        model.addAttribute("mensaje", "¡Hola, bienvenido a la aplicación!");
        // Devuelve el nombre de la vista, por ejemplo, "hola.html" en src/main/resources/templates
        model.addAttribute("nombre", "Juan");
        return "hola";
    }

    @GetMapping("/hola")
    public String hola(Model model) {
        model.addAttribute("usuario","Pepe");
        return "nuevavista";
    }

    @GetMapping("/actores")
    public String actores(Model model) {
        List<Actor> actores=actorService.findAll();
        model.addAttribute("actores", actores);
        return "actores";
    }
    @GetMapping("/actores/nuevo")
    public String nuevoActor() {

        return "nuevo_actor";
    }

    @PostMapping("/actores/nuevo")
    public String guardarActor(Actor actor) {
        actorService.save(actor);
        return "redirect:/actores";
    }

    @GetMapping("/films")
    public String films(Model model) {
        model.addAttribute("films", actorService.getAllFilms());
        return "films";
    }




}
