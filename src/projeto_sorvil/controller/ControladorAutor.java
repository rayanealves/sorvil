package projeto_sorvil.controller;

import java.util.UUID;

import projeto_sorvil.dados.AutorRepositorio;
import projeto_sorvil.dados.RepositorioAutor;
import projeto_sorvil.model.Autor;


public class ControladorAutor {
	
	private RepositorioAutor repositorioAutores;
	private static ControladorAutor instance;
	
	public ControladorAutor() {
		this.repositorioAutores = AutorRepositorio.getInstance();
	}
	
	public static ControladorAutor getInstance() {
		if(instance == null) {
			instance = new ControladorAutor();
		}
		return instance;
	}
	
	private boolean confereID(String id){
        return this.repositorioAutores.idExiste(id);
    }
    
    private String novoID(){
        String idProvi = UUID.randomUUID().toString();
        if(this.confereID(idProvi)){
            return novoID();
        }
        else{
            return idProvi;
        }
    }
    
    public boolean novoAutor(Autor autor){
        if (autor != null){
            autor.setId(this.novoID());
            if(!this.repositorioAutores.listar().contains(autor)){
                return this.repositorioAutores.adicionar(autor);
            }
        }
        return false;
    }
    
    public Autor buscarPorNome(String nome){
        Autor autor = null;
        if (nome != null){
            for(Autor aut : this.repositorioAutores.listar()){
                if(aut.getNome().equals(nome)){
                    autor = aut;
                }
            }
        }
        return autor;
    }
    
    public boolean delete(Autor autor, int nLivros) {
    	if(autor != null && nLivros < 1) {
    		return this.repositorioAutores.apagar(autor);
    	}
    	return false;
    }
    
  
	
	
}
