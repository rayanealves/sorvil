package projeto_sorvil.model;

import java.io.Serializable;
import java.util.Objects;


public class Livro implements Serializable{

	private static final long serialVersionUID = -1617802494947681773L;
	private String nome;
	private String ISBN;
	private Editora editora;
	private Autor autor;
	private Genero genero;
	private int numPaginas;
	private int edicao;
	//private LocalDate anoPubli;
        private int anoPubli;
	
	public Livro(String nome, String isbn, Editora editora, Autor autor, Genero genero, int numPaginas,
			int edicao,int anoP ) {
		
		this.nome = nome;
		this.ISBN = isbn;
		this.editora = editora;
		this.autor = autor;
		this.genero = genero;
		this.numPaginas = numPaginas;
		this.edicao = edicao;
		this.anoPubli = anoP;
	}
        
        public Livro() {
		
	}
        
        public int getAnoPubli() {
            return anoPubli;
        }

    
        public void setAnoPubli(int anoPubli) {
            this.anoPubli = anoPubli;
        }

	/*public LocalDate getAnoPubli() {
		return anoPubli;
	}

	public void setAnoPubli(LocalDate anoPubli) {
		this.anoPubli = anoPubli;
	}*/

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String isbn) {
		this.ISBN = isbn;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.ISBN == null) ? 0 : this.ISBN.hashCode());
		return result;
	}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Livro other = (Livro) obj;
        return Objects.equals(this.ISBN, other.ISBN);
    }

	
	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}
	
        @Override
	public String toString() {
		return " Nome: " + nome + "\n ID: " + ISBN + "\n Editora: " + editora + "\n Autor: " + autor + "\n Genero:" + genero
			+ "\n Paginas: " + numPaginas + "\n Editora: " + edicao + " " + this.getAnoPubli();
	}	
	
}
