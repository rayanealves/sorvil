package projeto_sorvil.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Card {
	private String id;
	private String titulo;
	private String texto;
	private Usuario usuario;
	private Livro livro;
	private LocalDateTime dataHora;
	private boolean publico;
	private int pagina;
	
	public Card(String titulo, String id, String texto, Usuario usuario, Livro livro, LocalDateTime dataHora, boolean publico,
			int pagina) {
		
		this.titulo = titulo;
		this.id = id;
		this.texto = texto;
		this.usuario = usuario;
		this.livro = livro;
		this.dataHora = dataHora;
		this.publico = publico;
		this.pagina = pagina;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public boolean isPublico() {
		return publico;
	}

	public void setPublico(boolean publico) {
		this.publico = publico;
	}

	public int getPagina() {
		return pagina;
	}

	public void setPagina(int pagina) {
		this.pagina = pagina;
	}
	
	public boolean equals(Card card) {
		if (card != null && card.getId() == this.id && 
				card.getDataHora() == this.dataHora && card.getUsuario() == this.usuario ) {
			return true;
		}
		return false;
	}

	public String toString() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		return this.livro.getNome() + "\n" + this.getTitulo() + "\n" + this.getTexto() + "\n" 
		+ "Pagina: " + this.getPagina() + "\n" + formatter.format(dataHora) ;
	}
	
	
	
	
}
