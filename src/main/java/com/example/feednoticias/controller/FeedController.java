package com.example.feednoticias.controller;

import com.example.feednoticias.model.Noticia;
import com.example.feednoticias.service.FeedService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class FeedController {
    FeedService service;

    public FeedController(FeedService service){
        this.service = service;
    }

    @GetMapping(value = {"/", "/noticias"})
    public String getNoticias(Model model){
        List<Noticia> noticiaList = service.findAll();
        model.addAttribute("noticiaslist", noticiaList);

        return "index";

    }

    @GetMapping("/cadastrar")
    public String cadastrar(Model model){
        Noticia n = new Noticia();
        model.addAttribute("noticia", n);

        return "cadastrar";

    }

    @PostMapping("/salvar")
    public String doSalvar(@ModelAttribute @Valid Noticia noticia, Errors errors){
        if(errors.hasErrors()){
            return "cadastrar";
        }else{
            service.insert(noticia);
            return "redirect:/";
        }

    }
}
