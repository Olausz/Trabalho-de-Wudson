package br.com.biblioteca.api.service;

import br.com.biblioteca.api.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    @Autowired
    LivroRepository livroRepository;
}
