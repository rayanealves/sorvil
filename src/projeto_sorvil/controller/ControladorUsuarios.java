package projeto_sorvil.controller;

import projeto_sorvil.model.Usuario;

import java.util.List;
import java.util.UUID;

import projeto_sorvil.dados.CardRepositorio;
import projeto_sorvil.dados.RepositorioUsuario;

public class ControladorUsuarios {
	

    private RepositorioUsuario repositorioUsuarios;
    private static ControladorUsuarios instancia = null;
	
    public ControladorUsuarios() {
    	if (instancia == null) {
            instancia = new ControladorUsuarios();
        }
    }
    
    public static ControladorUsuarios getInstancia() {
        if (instancia == null) {
            instancia = new ControladorUsuarios();
        }
        return instancia;
    }	
	
    public boolean adicionar(Usuario user) {
    	if(user != null) {
    		if (repositorioUsuarios.buscar(user.getLogin()) == user) {
    			return false;
    		}
    		 
    	}
    	else {
            return false;
    	}
    	return repositorioUsuarios.adicionar(user);
    	
    }
    
    public boolean remover(Usuario user) {
    	if(user != null) {
    		if (repositorioUsuarios.buscar(user.getLogin()) == user) {
    			return false;
    		}
    		 
    	}
    	else {
            return false;
    	}
    	return repositorioUsuarios.adicionar(user);
    }

    public List<Usuario> listar() {
        return repositorioUsuarios.listar();
    }
	
    private boolean confereID(String id) {
    	return this.repositorioUsuarios.idExiste(id);
	}
    
   
	private String novoID(){
        String id = UUID.randomUUID().toString();
        if(this.confereID(id)){
            return novoID();
        }
            return id;
 
    }

	
	
	
	
	
	
	
	

}
