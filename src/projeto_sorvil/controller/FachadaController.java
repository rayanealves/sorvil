package projeto_sorvil.controller;

import java.util.ArrayList;
import java.util.List;

import projeto_sorvil.exceptions.JaExisteException;
import projeto_sorvil.exceptions.NaoExisteException;
import projeto_sorvil.exceptions.NaoPodeException;
import projeto_sorvil.model.Autor;
import projeto_sorvil.model.Card;
import projeto_sorvil.model.Editora;
import projeto_sorvil.model.Genero;
import projeto_sorvil.model.Livro;
import projeto_sorvil.model.MeuLivro;
import projeto_sorvil.model.Usuario;


public class FachadaController {
	
	private static Usuario usuarioLogado = null;
	private static MeuLivro onLivro = null;
	private static Livro livroBuscado = null;
	private static Card onCard =null;
	private static Editora onEditora =null;
    private ControladorAutor controladorAutor;
    private ControladorCards controladorCards;
    private ControladorEditora controladorEditora;
    private ControladorLivro controladorLivro;
    @SuppressWarnings("unused")
	private ControladorUsuarios controladorUsuario;
    private static FachadaController instance;
    
    private FachadaController(){
        this.controladorAutor = ControladorAutor.getInstance();
        this.controladorCards = ControladorCards.getInstance();
        this.controladorEditora = ControladorEditora.getInstance();
        this.controladorLivro = ControladorLivro.getInstance();
        this.controladorUsuario = ControladorUsuarios.getInstancia();
    }
    
    public static FachadaController getInstance() {
        if (instance == null) {
            instance = new FachadaController();
        }
        return instance;
    }
    
	
	
	public static Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	public static void setUsuarioLogado(Usuario usuarioLogado) {
		FachadaController.usuarioLogado = usuarioLogado;
	}
	public static MeuLivro getOnLivro() {
		return onLivro;
	}
	public static void setOnLivro(MeuLivro onLivro) {
		FachadaController.onLivro = onLivro;
	}
	public static Livro getLivroBuscado() {
		return livroBuscado;
	}
	public static void setLivroBuscado(Livro livroBuscado) {
		FachadaController.livroBuscado = livroBuscado;
	}
	public static Card getOnCard() {
		return onCard;
	}
	public static void setOnCard(Card onCard) {
		FachadaController.onCard = onCard;
	}

	public static Editora getOnEditora() {
		return onEditora;
	}

	public static void setOnEditora(Editora onEditora) {
		FachadaController.onEditora = onEditora;
	}
	
	public boolean novoAutor(Autor autor) throws JaExisteException {
		return controladorAutor.novoAutor(autor);
	}

	public Autor bucarAutorPorNome(String nome) throws NaoExisteException {
		return controladorAutor.bucarPorNome(nome);
	}

	public List<Autor> buscarAutorPrimeiroNome(String nome) throws NaoExisteException {
		return controladorAutor.buscarPrimeiroNome(nome);
	}

	public Autor buscarAutorSobrenome(List<Autor> autoresPorNome, String sobrenome) {
		return controladorAutor.buscarSobrenome(autoresPorNome, sobrenome);
	}

	public boolean deleteAutor(Autor autor) throws NaoExisteException, NaoPodeException {
		if(this.listarPorAutor(autor).size() > 0) {
			return controladorAutor.delete(autor);
		}
		else {
			throw new NaoPodeException(autor);
		}
		
	}

	public boolean novoCard(Card card) throws JaExisteException {
		return controladorCards.novoCard(card);
	}

	public List<Card> listarCardsPublicos() {
		return controladorCards.listarCardsPublicos();
	}

	public List<Card> listarCardsPublicosLivro(Livro livro) {
		return controladorCards.listarCardsPublicosLivro(livro);
	}

	public List<Card> listarCardsPublicosUsuario(Usuario usuario) {
		return controladorCards.listarCardsPublicosUsuario(usuario);
	}

	public List<Card> listarCardsUsuario(Usuario usuario) {
		return controladorCards.listarCardsUsuario(usuario);
	}

	public List<Card> listarCardsLivroUsuario(Usuario usuario, Livro livro) {
		return controladorCards.listarCardsLivroUsuario(usuario, livro);
	}

	public boolean deleteCard(Usuario usuario, Card card) throws NaoPodeException {
		return controladorCards.deleteCard(usuario, card);
	}

	public Card buscarCardPorTitulo(String titulo) throws NaoExisteException {
		return controladorCards.buscarPorTitulo(titulo);
	}

	public Card buscarCard(Card card) throws NaoExisteException {
		return controladorCards.buscar(card);
	}

	public boolean editarCard(Card card, Usuario usuario, String texto) {
		return controladorCards.editar(card, usuario, texto);
	}

	public void tornarCardPublico(Card card) throws NaoExisteException {
		controladorCards.tornarPublico(card);
	}

	public void tornarCardPrivado(Card card) throws NaoExisteException {
		controladorCards.tornarPrivado(card);
	}

	public boolean novaEditora(Editora editora) throws JaExisteException {
		return controladorEditora.novaEditora(editora);
	}

	public boolean deleteEditora(Usuario usuario, Editora editora) throws NaoPodeException {
		return controladorEditora.deleteEditora(usuario, editora);
	}

	public Editora buscarEditora(String nome) throws NaoExisteException {
		return controladorEditora.buscarEditora(nome);
	}

	public boolean novoLivro(Livro livro) throws JaExisteException {
		return controladorLivro.novoLivro(livro);
	}

	public boolean deleteLivro(Usuario usuario, Livro livro) throws NaoPodeException {
		return controladorLivro.deleteLivro(usuario, livro);
	}

	public void alterarGenero(Usuario usuario, Livro livro, Genero generoAdd) throws NaoPodeException {
		controladorLivro.alterarGenero(usuario, livro, generoAdd);
	}

	public void alterarEditora(Usuario usuario, Livro livro, Editora editora) throws NaoPodeException {
		controladorLivro.alterarEditora(usuario, livro, editora);
	}

	public static Livro buscarLivro(String nome) throws NaoPodeException {
		return ControladorLivro.getInstance().buscarLivro(nome);
	}

	public List<Livro> listarPorEditora(Editora editora) {
		return controladorLivro.listarPorEditora(editora);
	}

	public List<Livro> listarPorAutor(Autor autor) {
		return controladorLivro.listarPorAutor(autor);
	}

	public List<Livro> listarPorGenero(Genero genero) {
		return controladorLivro.listarPorGenero(genero);
	}

<<<<<<< HEAD
	public boolean adicionarUsuario(Usuario user) throws JaExisteException {
		return controladorUsuario.adicionar(user);
	}

	public boolean removerUsuario(Usuario user) throws NaoPodeException {
		return controladorUsuario.remover(user);
=======
	public static boolean adicionarUsuario(Usuario user) {
		return ControladorUsuarios.getInstancia().adicionar(user);
	}

	public static boolean removerUsuario(Usuario user) {
		return ControladorUsuarios.getInstancia().remover(user);
>>>>>>> d67718a85693628502ec7c1fd34f369e64c7155e
	}

	public static boolean editarNomeUsuario(Usuario user, String nome) throws NaoPodeException {
		return ControladorUsuarios.getInstancia().editarNome(user, nome);
	}

	public static boolean editarLoginUsuario(Usuario user, String login) throws NaoPodeException, JaExisteException {
		return ControladorUsuarios.getInstancia().editarLogin(user, login);
	}

	public static boolean editarSenhaUsuario(Usuario user, String senha) throws NaoPodeException {
		return ControladorUsuarios.getInstancia().editarSenha(user, senha);
	}

	public static Usuario buscarUsuario(String login) throws Exception {
		return ControladorUsuarios.getInstancia().buscar(login);
	}

	public static boolean adicionarLivroUsuario(Usuario user, MeuLivro userLivro) {
		return ControladorUsuarios.getInstancia().adicionarLivroUsuario(user, userLivro);
	}

	public static boolean removerLivroUsuario(Usuario user, MeuLivro userLivro) {
		return ControladorUsuarios.getInstancia().removerLivroUsuario(user, userLivro);
	}

	public MeuLivro buscarLivroUsuario(Usuario user, String nome) {
		return ControladorUsuarios.getInstancia().buscarLivroUsuario(user, nome);
	}

	public List<Usuario> listarUsuario() {
		return ControladorUsuarios.getInstancia().listar();
	}

	public static ArrayList<MeuLivro> listarLivrosUsuario(Usuario user) {
		return ControladorUsuarios.getInstancia().listarLivrosUsuario(user);
	}
    
}
