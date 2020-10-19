package projeto_sorvil.gui;

import projeto_sorvil.model.Card;
import projeto_sorvil.model.Livro;
import projeto_sorvil.model.MeuLivro;
import projeto_sorvil.model.Usuario;

public class Fachada {
	
	private static Usuario usuarioLogado = null;
	private static MeuLivro onLivro = null;
	private static Livro livroBuscado = null;
	private static Card onCard =null;
	
	
	
	public static Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	public static void setUsuarioLogado(Usuario usuarioLogado) {
		Fachada.usuarioLogado = usuarioLogado;
	}
	public static MeuLivro getOnLivro() {
		return onLivro;
	}
	public static void setOnLivro(MeuLivro onLivro) {
		Fachada.onLivro = onLivro;
	}
	public static Livro getLivroBuscado() {
		return livroBuscado;
	}
	public static void setLivroBuscado(Livro livroBuscado) {
		Fachada.livroBuscado = livroBuscado;
	}
	public static Card getOnCard() {
		return onCard;
	}
	public static void setOnCard(Card onCard) {
		Fachada.onCard = onCard;
	}
	
	
	
	

}
