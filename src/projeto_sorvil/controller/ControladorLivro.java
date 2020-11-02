/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_sorvil.controller;

import java.util.List;
import java.util.stream.Collectors;

import projeto_sorvil.dados.IrepositorioLivro;
import projeto_sorvil.dados.LivroRepositorio;
import projeto_sorvil.exceptions.ISBNInvalidoException;
import projeto_sorvil.exceptions.JaExisteException;
import projeto_sorvil.exceptions.NaoPodeException;
import projeto_sorvil.model.Autor;
import projeto_sorvil.model.Editora;
import projeto_sorvil.model.Genero;
import projeto_sorvil.model.Livro;
import projeto_sorvil.model.Usuario;

public class ControladorLivro {
    
    private IrepositorioLivro repositorioLivro;
    private static ControladorLivro instance;
    
    public static ControladorLivro getInstance() {
        if (instance == null) {
            instance = new ControladorLivro();
        }
        return instance;
    }
    
    private ControladorLivro(){
        this.repositorioLivro = LivroRepositorio.getInstance();
    }
    
   
    
    public boolean novoLivro(Livro livro) throws JaExisteException, ISBNInvalidoException{
        if(livro != null){
            if(!livro.getISBN().equals("")){
                    if(!this.repositorioLivro.listar().contains(livro)){
                        return this.repositorioLivro.adicionar(livro); 
                    }
                    else{
                        throw new JaExisteException(livro);
                    }
            }
            else{
                throw new ISBNInvalidoException(livro.getISBN());
            }
            
        }
        
        return false;
    }
    
    public boolean deleteLivro(Usuario usuario, Livro livro) throws NaoPodeException{
        if(livro != null ){
            if (this.repositorioLivro.listar().contains(livro) && usuario.isAdmin()){
                return this.repositorioLivro.apagar(livro);
            }
            else{
                throw new NaoPodeException(usuario);
            }
        }
        return false;
    }
    
    public void alterarGenero(Usuario usuario, Livro livro, Genero generoAdd) throws NaoPodeException  {
       
        if(usuario.isAdmin()){
            this.repositorioLivro.alterarGenero(livro, generoAdd);
        }
        else{
            throw new NaoPodeException(usuario);
        }
        
    }


    
    public void alterarEditora (Usuario usuario, Livro livro, Editora editora) throws NaoPodeException{
        if(livro != null && editora != null) {
            if(usuario.isAdmin() == true){
                repositorioLivro.alterarEditora(livro, editora);
            }
            else{
                throw new NaoPodeException(usuario);
            }
        }
    }
    
    public List<Livro> buscarLivro(String nome) throws NaoPodeException{
        
        List<Livro> livrosNome = null;
        if (nome != null){
           livrosNome = this.repositorioLivro.listar()
                   .stream()
                   .filter(liv-> liv.getNome().toLowerCase().contains(nome.toLowerCase()))
                   .collect(Collectors.toList());   
           
            
        }
        if(livrosNome != null){
                return livrosNome;
            }
        
        else{
            throw new NaoPodeException(nome);
        }
        
    }
    
     public List<Livro> listarLivros () {
            return this.repositorioLivro.listar();
    }
    public List<Livro> listarPorEditora (Editora editora) {
        if (editora != null){
            return this.repositorioLivro.listar(editora);
        }
        return null;
    }
    
    public List<Livro> listarPorAutor (Autor autor){
        if (autor != null) {
            return this.repositorioLivro.listar(autor);
        }
        return null;
    }
    
    public List<Livro> listarPorGenero (Genero genero){
        if (genero != null) {
            return this.repositorioLivro.listar(genero);
        }
        return null;
    }
    
}
