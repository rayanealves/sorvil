package projeto_sorvil.controller;

import java.util.List;
import java.util.UUID;

import projeto_sorvil.dados.RepositorioUsuario;
import projeto_sorvil.dados.UsuarioRepositorio;
import projeto_sorvil.model.MeuLivro;
import projeto_sorvil.model.Usuario;

public class ControladorUsuarios {
	

    private RepositorioUsuario repositorioUsuarios;
    private static ControladorUsuarios instancia = null;
	
    public ControladorUsuarios() {
    	this.repositorioUsuarios = UsuarioRepositorio.getInstancia();
    }
    
    public static ControladorUsuarios getInstancia() {
        if (instancia == null) {
            instancia = new ControladorUsuarios();
        }
        return instancia;
    }	
	
    public boolean adicionar(Usuario user) {
    	if(user != null) {
    		user.setId(this.novoID());
    		if (user.equals(repositorioUsuarios.buscar(user.getLogin()))) {
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
    			return repositorioUsuarios.remover(user);
    		}
    		else {
    			return false;
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
	

	
	public boolean adicionarLivro(Usuario user, MeuLivro userLivro){
		
		if(userLivro != null) {
    		if (user.buscarLivro(userLivro.getLivro().getNome()) == userLivro) {
    			return false;
    		}
    		user.adicionarLivro(userLivro);
    		return true;
    	}
    	else {
            return false;
    	}

	}
	
	
	public boolean removerLivro(Usuario user, MeuLivro userLivro){
		
		if(userLivro != null) {
    		if (user.buscarLivro(userLivro.getLivro().getNome()) == userLivro) {
    			user.removerLivro(userLivro);
        		return true;
    		}
    		return false;
    	}
    	else {
            return false;
    	}

	}
	
	public MeuLivro buscarLivroUsuario(Usuario user,String nome) {
		if(!nome.equals(null)  & !nome.equals("") & user != null) {
			return user.buscarLivro(nome);
		}
		return null;
	}
	

    public List<Usuario> listar() {
        return repositorioUsuarios.listar();
    }
    
    public List<MeuLivro> listarLivrosUsuario(Usuario user) {
    	
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
    

	private String novoID(){
        String id = UUID.randomUUID().toString();
        if(this.confereID(id)){
            return novoID();
        }
            return id;
 
    }

	
	
	
	
	
	
	
	

}
