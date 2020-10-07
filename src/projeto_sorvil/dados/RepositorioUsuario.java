package projeto_sorvil.dados;

import java.util.List;

import projeto_sorvil.model.Livro;
import projeto_sorvil.model.Usuario;

public interface RepositorioUsuario {
	
	
	public boolean adicionarUsuario(Usuario user);

	public boolean removerUsuario(Usuario user);
	
	public void editarNomeUsuario(Usuario user, String nome);
	
	public void editarLoginUsuario(Usuario user, String login);
	
	public void editarSenhaUsuario(Usuario user, String senha);

	public Usuario buscarUsuario(int index);
	
	public List<Usuario> listarUsuarios();
	
	public List<Livro> listarLivros(Usuario user);
	
	
	

}
