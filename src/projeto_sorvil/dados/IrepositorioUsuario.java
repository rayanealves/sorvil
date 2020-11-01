package projeto_sorvil.dados;

import java.util.ArrayList;
import java.util.List;

import projeto_sorvil.model.MeuLivro;
import projeto_sorvil.model.Usuario;

public interface IrepositorioUsuario {
	
	
	public ArrayList<Usuario> getUsuarios();
	
	public boolean adicionar(Usuario user);

	public boolean remover(Usuario user);
	
	public void editarNome(Usuario user, String nome);
	
	public void editarLogin(Usuario user, String login);
	
	public void editarSenha(Usuario user, String senha);

	public Usuario buscar(String login);
	
	public Usuario buscarPeloNome(String nome);
	
	public List<Usuario> listar();
	
	public ArrayList<MeuLivro> listarLivros(Usuario user);
	
	public boolean cpfExiste(String id);
	
	public boolean adicionarLivro(Usuario user, MeuLivro livroUser);

	public boolean removerLivro(Usuario user, MeuLivro livroUser);

	public boolean atualizarLivro(Usuario user, MeuLivro userLivro);

}
