package projeto_sorvil.controller;

import projeto_sorvil.model.Usuario;

import java.util.List;

import projeto_sorvil.dados.RepositorioUsuario;

public class ControladorUsuarios {
	

    private RepositorioUsuario repositorioUsuarios;
    private static ControladorUsuarios instancia;
	
    
    public static ControladorUsuarios getInstancia() {
        if (instancia == null) {
            instancia = new ControladorUsuarios();
        }
        return instancia;
    }
	
	
    public void adicionar(Usuario user) {
    	if(user != null) {
    		repositorioUsuarios.buscar(user.getId();
    		
    		
    	}
    	else {
            repositorioUsuarios.adicionar(user);

    	}
    }

    public List<Usuario> listar() {
        return repositorioUsuarios.listar();
    }
	
	
	
	
	
	
	
	
	
	
	
	

}
