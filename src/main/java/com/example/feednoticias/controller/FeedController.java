package com.example.feednoticias.controller;

import com.example.feednoticias.model.Noticia;
import com.example.feednoticias.service.FeedService;
import org.aspectj.weaver.ast.Not;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
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

    /*@GetMapping("/preencher")
    public void doComentar(HttpServletResponse response) throws IOException {
        Noticia n = service.findById(1L);
        for(int i = 0; i<5; i++){
            n.addComentario("comentário " + i);
        }
        service.update(n);
        response.getWriter().println("Ok");


    }

    @PostMapping("/comentar")
    public String doComentar(@ModelAttribute @Valid Noticia noticia){

    }

     */
}


