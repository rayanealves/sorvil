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
            if(editora != null){
                return editora.getNome().equals(this.getNome());
            }
            return false;
	}
	
        @Override
	public String toString() {
		return this.nome;
	}
}
