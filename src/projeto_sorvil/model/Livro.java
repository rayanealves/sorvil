package projeto_sorvil.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Livro {
	private String nome;
	private String id;
	private Editora editora;
	private Autor autor;
	private ArrayList <Genero> genero = new ArrayList<>();
	private int numPaginas;
	private int edicao;
	private LocalDate anoPubli;
	
	public Livro(String nome, String id, Editora editora, Autor autor, ArrayList<Genero> genero, int numPaginas,
			int edicao,LocalDate anoP ) {
		
		this.nome = nome;
		this.id = id;
		this.editora = editora;
		this.autor = autor;
		this.genero = genero;
		this.numPaginas = numPaginas;
		this.edicao = edicao;
		this.anoPubli = anoP;
	}
        
        public Livro() {
		
	}

	public LocalDate getAnoPubli() {
		return anoPubli;
	}

	public void setAnoPubli(LocalDate anoPubli) {
		this.anoPubli = anoPubli;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public ArrayList<Genero> getGenero() {
		return genero;
	}

	public void setGenero(ArrayList<Genero> genero) {
		this.genero = genero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
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
	
	public boolean equals(Livro livro) {
            if(livro != null){
                return this.nome.equals(livro.getNome())
                        && livro.getAutor().equals(this.autor);
            }
            return false;
	}

	
        @Override
	public String toString() {
		return "Nome: " + nome + "\nID: " + id + "\nEditora: " + editora + "\nAutor: " + autor + "\nGenero:" + genero
				+ "\nPaginas: " + numPaginas + "\nEdi��o: " + edicao + " " + this.getAnoPubli();
	}

    
    
	
	
}
