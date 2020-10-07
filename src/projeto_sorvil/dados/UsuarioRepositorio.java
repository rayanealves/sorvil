package projeto_sorvil.dados;

import java.util.ArrayList;
import java.util.List;

import projeto_sorvil.model.*;

public class UsuarioRepositorio implements RepositorioUsuario {
	

	private static ArrayList<Usuario> usuarios = new ArrayList<>();
	
	
	
	public boolean adicionarUsuario(Usuario user) {
		
		return usuarios.add(user);
	}

	public boolean removerUsuario(Usuario user) {
			
			return usuarios.remove(user);
	}
	
	public void editarNomeUsuario(Usuario user, String nome) {
		
		 user.setNome(nome);
	}
	
	public void editarLoginUsuario(Usuario user, String login) {
		
		 user.setLogin(login);
	}
	
	public void editarSenhaUsuario(Usuario user, String senha) {
		
		 user.setSenha(senha);
	}
	
	public Usuario buscarUsuario(int index) {
		
		return usuarios.get(index);
	}
	
	
	public List<Usuario> listarUsuarios() {
		return usuarios.subList(0, usuarios.size());
	}
	
	public List<Livro> listarLivros(Usuario user) {
		return user.getEstante().subList(0 , user.getEstante().size() );
	}
	
	
	
	
	
	
	
	
	
	
	
}
