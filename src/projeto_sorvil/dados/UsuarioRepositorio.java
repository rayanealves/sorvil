package projeto_sorvil.dados;

import java.util.ArrayList;
import java.util.List;

import projeto_sorvil.model.*;

public class UsuarioRepositorio implements RepositorioUsuario {
	

	private static ArrayList<Usuario> usuarios = new ArrayList<>();
	
	
	
        @Override
	public boolean adicionarUsuario(Usuario user) {
		
		return usuarios.add(user);
	}

        @Override
	public boolean removerUsuario(Usuario user) {
			
			return usuarios.remove(user);
	}
	
        @Override
	public void editarNomeUsuario(Usuario user, String nome) {
		
		 user.setNome(nome);
	}
	
        @Override
	public void editarLoginUsuario(Usuario user, String login) {
		
		 user.setLogin(login);
	}
	
        @Override
	public void editarSenhaUsuario(Usuario user, String senha) {
		
		 user.setSenha(senha);
	}
	
        @Override
	public Usuario buscarUsuario(int index) {
		
		return usuarios.get(index);
	}
	
	
        @Override
	public List<Usuario> listarUsuarios() {
		return usuarios.subList(0, usuarios.size());
	}
	
        @Override
	public List<Livro> listarLivros(Usuario user) {
		return user.getEstante().subList(0 , user.getEstante().size() );
	}
	
	
	
	
	
	
	
	
	
	
	
}
