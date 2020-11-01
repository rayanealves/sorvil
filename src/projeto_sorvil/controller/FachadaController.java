package projeto_sorvil.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import projeto_sorvil.exceptions.CPFinvalidoExeption;

import projeto_sorvil.exceptions.JaExisteException;
import projeto_sorvil.exceptions.NaoExisteException;
import projeto_sorvil.exceptions.NaoPodeException;
import projeto_sorvil.gui.TelaAdicionarLivroController;
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
    	
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	public void setUsuarioLogado(Usuario usuarioLogado) {
		FachadaController.usuarioLogado = usuarioLogado;
	}
	public MeuLivro getOnLivro() {
		return onLivro;
	}
	public void setOnLivro(MeuLivro onLivro) {
		FachadaController.onLivro = onLivro;
	}
	public  Livro getLivroBuscado() {
		return livroBuscado;
	}
	public void setLivroBuscado(Livro livroBuscado) {
		FachadaController.livroBuscado = livroBuscado;
	}
	public Card getOnCard() {
		return onCard;
	}
	public void setOnCard(Card onCard) {
		FachadaController.onCard = onCard;
	}

	public Editora getOnEditora() {
		return onEditora;
	}

	public void setOnEditora(Editora onEditora) {
		FachadaController.onEditora = onEditora;
	}
	
	public boolean novoAutor(Autor autor) throws JaExisteException {
		return controladorAutor.novoAutor(autor);
	}
        
	public Autor novoAutorNome(String autor){
        Autor novoAutor = FachadaController.getInstance().bucarAutorPorNome(autor);
        	
                if(novoAutor == null){
                    novoAutor = new Autor(autor, null);
                    controladorAutor.novoAutor(novoAutor);
                }
       
        return novoAutor;
	}

	public Autor bucarAutorPorNome(String nome) {
		return controladorAutor.bucarPorNome(nome);
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

	public Editora novaEditoraNome(String nome){
      
          Editora novaEditora = FachadaController.getInstance().buscarEditora(nome); 
     
          if(novaEditora == null){
                novaEditora = new Editora(nome, null);
                FachadaController.getInstance().novaEditora(novaEditora);
          }
        
       	return novaEditora;
	}
        
    public List<Livro> listarLivros () {
            return FachadaController.getInstance().controladorLivro.listarLivros();
    }
        
    public boolean novaEditora(Editora editora){
        try {
            return controladorEditora.novaEditora(editora);
       } catch (JaExisteException ex) {
            Logger.getLogger(FachadaController.class.getName()).log(Level.SEVERE, null, ex);
       }
       return false;
	}

	public boolean deleteEditora(Usuario usuario, Editora editora) throws NaoPodeException {
		return controladorEditora.deleteEditora(usuario, editora);
	}

	public Editora buscarEditora(String nome)  {
         
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

	public Livro buscarLivro(String nome) throws NaoPodeException {
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
	
	public boolean adicionarUsuario(Usuario user) throws JaExisteException, CPFinvalidoExeption {
		return controladorUsuario.adicionar(user);
	}

	public boolean removerUsuario(Usuario user) throws NaoPodeException {
		return controladorUsuario.remover(user);

	}

	public boolean editarNomeUsuario(Usuario user, String nome) throws NaoPodeException {
		return controladorUsuario.editarNome(user, nome);
	}

	public boolean editarLoginUsuario(Usuario user, String login) throws NaoPodeException, JaExisteException {
		return controladorUsuario.editarLogin(user, login);
	}

	public boolean editarSenhaUsuario(Usuario user, String senha) throws NaoPodeException {
		return controladorUsuario.editarSenha(user, senha);
	}

	public Usuario buscarUsuario(String login) throws NaoExisteException {
		return controladorUsuario.buscar(login);
	}

	public boolean adicionarLivroUsuario(Usuario user, MeuLivro userLivro) throws JaExisteException {
		return controladorUsuario.adicionarLivroUsuario(user, userLivro);
	}

	public boolean removerLivroUsuario(Usuario user, MeuLivro userLivro) throws NaoExisteException {
		return controladorUsuario.removerLivroUsuario(user, userLivro);
	}

	public MeuLivro buscarLivroUsuario(Usuario user, String nome) throws NaoExisteException {
		return controladorUsuario.buscarLivroUsuario(user, nome);
	}

	public List<Usuario> listarUsuario() {
		return controladorUsuario.listar();
	}

	public ArrayList<MeuLivro> listarLivrosUsuario(Usuario user) {
		return controladorUsuario.listarLivrosUsuario(user);
	}
    
}
