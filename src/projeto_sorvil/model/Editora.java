package projeto_sorvil.model;

import java.io.Serializable;

public class Editora implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4061835516033978330L;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	
        @Override
	public String toString() {
		return this.nome;
	}

    
}
