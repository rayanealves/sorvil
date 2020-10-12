/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_sorvil.dados;

import java.util.List;
import projeto_sorvil.model.Autor;
import projeto_sorvil.model.Editora;
import projeto_sorvil.model.Genero;
import projeto_sorvil.model.Livro;

/**
 *
 * @author Rayan
 */
public interface RepositorioLivro {
    
    public boolean adicionar (Livro livro);
    
    public Livro buscar(int indice);
    
    public Livro buscar (Livro livro);
    
    public boolean apagar (Livro livro);
    
    public boolean apagar (Livro livro, Genero genero);
    
    public List<Livro> listar();
     
    public List<Livro> listar(Autor autor);
     
    public List<Livro> listar(Editora editora);
     
    public List<Livro> listar(Genero genero);
     
    public boolean idExiste(String id);
}
