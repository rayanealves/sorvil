package projeto_sorvil.controller;

import java.util.List;
import java.util.UUID;

import projeto_sorvil.dados.IrepositorioUsuario;
import projeto_sorvil.dados.UsuarioRepositorio;
import projeto_sorvil.exceptions.JaExisteException;
import projeto_sorvil.exceptions.NaoPodeException;
import projeto_sorvil.model.MeuLivro;
import projeto_sorvil.model.Usuario;

public class ControladorUsuarios {
	

    private IrepositorioUsuario repositorioUsuarios;
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
	
    public boolean adicionar(Usuario user) throws JaExisteException {
    	if(user != null) {
    		user.setId(this.novoID());
    		if (user.equals(repositorioUsuarios.buscar(user.getLogin()))) {
    			throw new JaExisteException(user);
    		}
    		 
    	}
    	else {
            return false;
    	}
    	return repositorioUsuarios.adicionar(user);
    	
    }
    
    public boolean remover(Usuario user) throws NaoPodeException {
    	if(user != null) {
    		if (repositorioUsuarios.buscar(user.getLogin()) == user) {
    			return repositorioUsuarios.remover(user);
    		}
    		else {
    			throw new NaoPodeException(user);
    		}
    		 
    	}
    	else {
            return false;
    	}
    }
    
    
    public boolean  editarNome(Usuario user, String nome) throws NaoPodeException {
    	
    	if(user != null & nome != null & !nome.equals("")) {
    		if (repositorioUsuarios.buscar(user.getLogin()) == user) {
    			repositorioUsuarios.editarNome(user, nome);
    			return true;
    		}
    		else {
    			throw new NaoPodeException(user);
    		}
    	}
    	else {
    		return false;
    	}
    			
	}
	
	public boolean editarLogin(Usuario user, String login) throws NaoPodeException, JaExisteException {
    	
		if(user != null & login != null & !login.equals("") ) {
    		if (repositorioUsuarios.buscar(user.getLogin()) == user) {
                    if(repositorioUsuarios.buscar(login) == null){
                        repositorioUsuarios.editarLogin(user, login);
    			return true;
                    }
                    else{
                        throw new JaExisteException(login);
                    }
    			
    		}
    		else {
    			throw new NaoPodeException(user);
    		}
    	}
    	else {
    		return false;
    	}
    	
	}
	
	public boolean editarSenha(Usuario user, String senha) throws NaoPodeException {
		
		if(user != null & senha != null & !senha.equals("")) {
    		if (repositorioUsuarios.buscar(user.getLogin()) == user ) {
    			repositorioUsuarios.editarLogin(user, senha);
    			return true;
    		}
    		else {
    			throw new NaoPodeException(user);
    		}
    	}
    	else {
    		return false;
    	}
	}
	
	
	public Usuario buscar(String login) throws Exception {
            Usuario encontrado = null;
		if(!login.equals(null)  & !login.equals("") ) {
			encontrado = repositorioUsuarios.buscar(login);
                        if(encontrado != null){
                            return encontrado;
                        }
                        else throw NaoPodeException(login);
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

    private Exception NaoPodeException(String login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	
	
	
	
	
	
	
	

}
