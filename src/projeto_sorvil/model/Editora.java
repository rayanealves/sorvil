package projeto_sorvil.model;

public class Editora {
	private String nome;
	private String id;
	
	public Editora(String nome, String id) {
		this.nome = nome;
		this.id = id;
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
	
	public boolean equals(Editora editora) {
		return editora != null && editora.getNome().equals(this.getNome()) && 
                        editora.getId().equals(this.getId());
	}
	
        @Override
	public String toString() {
		return this.nome;
	}
}
