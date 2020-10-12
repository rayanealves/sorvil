package projeto_sorvil.controller;

import projeto_sorvil.model.Livro;
import projeto_sorvil.model.Usuario;

import java.util.List;
import java.util.UUID;

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
    		else {
    			return repositorioUsuarios.adicionar(user);
    		}
    		 
    	}
    	else {
            return false;
    	}
    }
    
    
    public boolean  editarNome(Usuario user, String nome) {
    	
    	if(user != null & nome != null & !nome.equals("")) {
    		if (repositorioUsuarios.buscar(user.getLogin()) == user & repositorioUsuarios.buscarPeloNome(nome) == null) {
    			repositorioUsuarios.editarNome(user, nome);
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    	else {
    		return false;
    	}
    			
	}
	
	public boolean editarLogin(Usuario user, String login) {
    	
		if(user != null & login != null & !login.equals("") ) {
    		if (repositorioUsuarios.buscar(user.getLogin()) == user & repositorioUsuarios.buscar(login) == null) {
    			repositorioUsuarios.editarLogin(user, login);
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    	else {
    		return false;
    	}
    	
	}
	
	public boolean editarSenha(Usuario user, String senha) {
		
		if(user != null & senha != null & !senha.equals("")) {
    		if (repositorioUsuarios.buscar(user.getLogin()) == user ) {
    			repositorioUsuarios.editarLogin(user, senha);
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    	else {
    		return false;
    	}
	}
	
	
	public Usuario buscar(String login) {
		if(!login.equals(null)  & !login.equals("") ) {
			return repositorioUsuarios.buscar(login);
		}
		return null;
	}

    public List<Usuario> listar() {
        return repositorioUsuarios.listar();
    }
    
    public List<Livro> listarLivros(Usuario user) {
    	
    	if(user != null) {
    		if(repositorioUsuarios.getUsuarios().contains(user)){
    			return repositorioUsuarios.listarLivros(user);
    		}
    	}
    	return null;
    }
    
    private boolean confereID(String id) {
    	return this.repositorioUsuarios.idExiste(id);
	}
    
	@SuppressWarnings("unused")
	private String novoID(){
        String id = UUID.randomUUID().toString();
        if(this.confereID(id)){
            return novoID();
        }
            return id;
 
    }

	
	
	
	
	
	
	
	

}
