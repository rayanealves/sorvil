package projeto_sorvil.controller;

import projeto_sorvil.model.Card;
import projeto_sorvil.model.Editora;
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
    
    
  
    
    public boolean novaEditora(Editora editora) {
		return controladorEditora.novaEditora(editora);
	}

	public boolean deleteEditora(Usuario usuario, Editora editora) {
		return controladorEditora.deleteEditora(usuario, editora);
	}

	public Editora buscarEditora(String nome) {
		return controladorEditora.buscarEditora(nome);
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
    
}
