package br.com.biblioteca.api.service;

import br.com.biblioteca.api.model.Livro;
import br.com.biblioteca.api.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    LivroRepository livroRepository;

    public void criarLivro (Livro livro) {
        livroRepository.save(livro);
    }

    public List<Livro> listarTodososLivros() {
        return  livroRepository.findAll();
    }

    public void deletarLivroPorId(Long id) {
        livroRepository.deleteById(id);
    }

    public Optional<Livro> BuscarlivroPorId(Long id) {
        return livroRepository.findById(id);
    }

    public void atualizarLivroPorId(Long id, Livro livro){
        Optional<Livro> LivroDoBancoDeDados = BuscarlivroPorId(id);

        if (LivroDoBancoDeDados.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não existe no banco de dados");
        }

        Livro livroEditado = LivroDoBancoDeDados.get();

        livroEditado.setAutor(livro.getAutor());
        livroEditado.setData(livro.getData());
        livroEditado.setTitulo(livro.getTitulo());

        livroRepository.save(livroEditado);
    }
}
