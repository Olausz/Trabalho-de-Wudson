package br.com.biblioteca.api.controller;

import br.com.biblioteca.api.model.Livro;
import br.com.biblioteca.api.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarLivro(@RequestBody Livro livro) {
        livroService.criarLivro(livro);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Livro> listarTodososLivros() {
        return livroService.listarTodososLivros();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarLivroPorId(@PathVariable Long id) {
        livroService.deletarLivroPorId(id);
    }

    public Optional<Livro> BuscarlivroPorId(@PathVariable Long id) {
        return livroService.BuscarlivroPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarLivroPorId(@PathVariable Long id, @RequestBody Livro livro) {
        livroService.atualizarLivroPorId(id, livro);
    }
}
        