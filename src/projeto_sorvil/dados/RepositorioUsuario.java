package projeto_sorvil.dados;

import java.util.List;

import projeto_sorvil.model.Livro;
import projeto_sorvil.model.Usuario;

public interface RepositorioUsuario {
	
	
	public boolean adicionar(Usuario user);

	public boolean remover(Usuario user);
	
	public void editarNome(Usuario user, String nome);
	
	public void editarLogin(Usuario user, String login);
	
	public void editarSenha(Usuario user, String senha);

	public Usuario buscar(String login);
	
	public List<Usuario> listar();
	
	public List<Livro> listarLivros(Usuario user);
	
	public boolean idExiste(String id);
	
	

}
