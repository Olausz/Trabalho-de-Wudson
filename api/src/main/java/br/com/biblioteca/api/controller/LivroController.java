package br.com.biblioteca.api.controller;

import br.com.biblioteca.api.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    LivroService livroService;

}
