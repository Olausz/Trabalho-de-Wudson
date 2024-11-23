package br.com.biblioteca.api.controller;

import br.com.biblioteca.api.model.Livro;
import br.com.biblioteca.api.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<Livro>> findAll() {
        List<Livro> livros = livroService.findAll();
        return ResponseEntity.ok(livros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Long id) {
        return livroService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Livro> create(@RequestBody Livro livro) {
        Livro savedLivro = livroService.save(livro);
        return ResponseEntity.ok(savedLivro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> update(@PathVariable Long id, @RequestBody Livro livro) {
        return livroService.findById(id)
                .map(existingLivro -> {
                    livro.setId(existingLivro.getId());
                    Livro updatedLivro = livroService.save(livro);
                    return ResponseEntity.ok(updatedLivro);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (livroService.findById(id).isPresent()) {
            livroService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return Respons
        