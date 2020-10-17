package projeto_sorvil.dados;

import java.util.ArrayList;
import java.util.List;

import projeto_sorvil.model.MeuLivro;
import projeto_sorvil.model.Usuario;

public interface RepositorioUsuario {
	
	
	public ArrayList<Usuario> getUsuarios();
	
	public boolean adicionar(Usuario user);

	public boolean remover(Usuario user);
	
	public void editarNome(Usuario user, String nome);
	
	public void editarLogin(Usuario user, String login);
	
	public void editarSenha(Usuario user, String senha);

	public Usuario buscar(String login);
	
	public Usuario buscarPeloNome(String nome);
	
	public List<Usuario> listar();
	
	public List<MeuLivro> listarLivros(Usuario user);
	
	public boolean idExiste(String id);
	
	

}
