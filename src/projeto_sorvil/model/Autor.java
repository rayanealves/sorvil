package projeto_sorvil.model;

public class Autor {
	private String nome;
	private String sobrenome;
	private String id;
	
	public Autor(String nome, String sobrenome, String id) {
		
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getId() {
		return id;
	}
	
	
	public boolean equals(Autor autor) {
		if(autor != null && autor.getNome() == this.getNome() && autor.getSobrenome() == this.getSobrenome()
				&& autor.getId() == this.getId()) {
			return true;
		}
		return false;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String toString() {
		return this.getNome() + " " + this.getSobrenome();
	}
	
	

}
