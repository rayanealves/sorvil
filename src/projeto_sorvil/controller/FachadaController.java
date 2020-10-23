package projeto_sorvil.controller;

import java.util.List;

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
    
    
    
    public void novoUsuario(Usuario user){
        boolean adicionar = this.controladorUsuario.adicionar(user);
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
	
	public boolean novoAutor(Autor autor) {
		return controladorAutor.novoAutor(autor);
	}

	public Autor bucarAutorPorNome(String nome) {
		return controladorAutor.bucarPorNome(nome);
	}

	public List<Autor> buscarAutorPrimeiroNome(String nome) {
		return controladorAutor.buscarPrimeiroNome(nome);
	}

	public Autor buscarAutorSobrenome(List<Autor> autoresPorNome, String sobrenome) {
		return controladorAutor.buscarSobrenome(autoresPorNome, sobrenome);
	}

	public boolean deleteAutor(Autor autor, int nLivros) {
		return controladorAutor.delete(autor, nLivros);
	}

	public boolean novoCard(Card card) {
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

	public boolean deleteCard(Usuario usuario, Card card) {
		return controladorCards.deleteCard(usuario, card);
	}

	public Card buscarCardPorTitulo(String titulo) {
		return controladorCards.buscarPorTitulo(titulo);
	}

	public Card buscarCard(Card card) {
		return controladorCards.buscar(card);
	}

	public boolean editarCard(Card card, Usuario usuario, String texto) {
		return controladorCards.editar(card, usuario, texto);
	}

	public void tornarCardPublico(Card card) {
		controladorCards.tornarPublico(card);
	}

	public void tornarCardPrivado(Card card) {
		controladorCards.tornarPrivado(card);
	}

	public boolean novaEditora(Editora editora) {
		return controladorEditora.novaEditora(editora);
	}

	public boolean deleteEditora(Usuario usuario, Editora editora) {
		return controladorEditora.deleteEditora(usuario, editora);
	}

	public Editora buscarEditora(String nome) {
		return controladorEditora.buscarEditora(nome);
	}

	public boolean novoLivro(Livro livro) {
		return controladorLivro.novoLivro(livro);
	}

	public boolean deleteLivro(Usuario usuario, Livro livro) {
		return controladorLivro.deleteLivro(usuario, livro);
	}

	public void alterarGenero(Usuario usuario, Livro livro, Genero generoDel, Genero generoAdd) {
		controladorLivro.alterarGenero(usuario, livro, generoDel, generoAdd);
	}

	public void alterarEditora(Usuario usuario, Livro livro, Editora editora) {
		controladorLivro.alterarEditora(usuario, livro, editora);
	}

	public Livro buscarLivro(String nome) {
		return controladorLivro.buscarLivro(nome);
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

	public boolean adicionarUsuario(Usuario user) {
		return controladorUsuario.adicionar(user);
	}

	public boolean removerUsuario(Usuario user) {
		return controladorUsuario.remover(user);
	}

	public boolean editarNomeUsuario(Usuario user, String nome) {
		return controladorUsuario.editarNome(user, nome);
	}

	public boolean editarLoginUsuario(Usuario user, String login) {
		return controladorUsuario.editarLogin(user, login);
	}

	public boolean editarSenhaUsuario(Usuario user, String senha) {
		return controladorUsuario.editarSenha(user, senha);
	}

	public Usuario buscarUsuario(String login) {
		return controladorUsuario.buscar(login);
	}

	public boolean adicionarLivroUsuario(Usuario user, MeuLivro userLivro) {
		return controladorUsuario.adicionarLivro(user, userLivro);
	}

	public boolean removerLivroUsuario(Usuario user, MeuLivro userLivro) {
		return controladorUsuario.removerLivro(user, userLivro);
	}

	public MeuLivro buscarLivroUsuario(Usuario user, String nome) {
		return controladorUsuario.buscarLivroUsuario(user, nome);
	}

	public List<Usuario> listarUsuario() {
		return controladorUsuario.listar();
	}

	public List<MeuLivro> listarLivrosUsuario(Usuario user) {
		return controladorUsuario.listarLivrosUsuario(user);
	}
    
}
