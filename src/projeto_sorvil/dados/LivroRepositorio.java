/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_sorvil.dados;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import projeto_sorvil.model.Autor;
import projeto_sorvil.model.Editora;
import projeto_sorvil.model.Genero;
import projeto_sorvil.model.Livro;

/**
 *
 * @author Rayan
 */
public class LivroRepositorio implements RepositorioLivro {
    
    private final ArrayList<Livro> livro = new ArrayList<>();
    
    
    @Override
    public boolean adicionar (Livro livro){
        return this.livro.add(livro);
    }
    
    
    @Override
    public Livro buscar(int indice) {
	return this.livro.get(indice);
    }  //dúvida nesse
    
    @Override
    public boolean apagar (Livro livro){
        return this.livro.remove(livro);
    }
    
    @Override
    public List<Livro> listar(){
        return livro;
    }
    
    @Override
    public List<Livro> listar(Autor autor) {
        return livro.stream()
            .filter(livro-> livro.getAutor().equals(autor))
            .collect(Collectors.toList());
    }
    
    @Override
    public List<Livro> listar(Editora editora) {
        return livro.stream()
            .filter(livro-> livro.getEditora().equals(editora))
            .collect(Collectors.toList());
    }
    
    @Override
    public List<Livro> listar(Genero genero) {
        return livro.stream()
            .filter(livro-> livro.getGenero().equals(genero))
            .collect(Collectors.toList());
    }
    
}
