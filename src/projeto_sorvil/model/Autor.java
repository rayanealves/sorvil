package projeto_sorvil.model;

import java.io.Serializable;

public class Autor implements Comparable<Autor>, Serializable {
	

	private static final long serialVersionUID = -3427491444864579533L;
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
		return result;
	}

	
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
            if(nome != null){
                this.nome = nome;
            }
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
            if(sobrenome != null){
                this.sobrenome = sobrenome;
            }
	}

	public String getId() {
		return id;
	}
	
	
	public boolean equals(Autor autor) {
		return autor != null && autor.getNome().equals(this.getNome())
                        && autor.getSobrenome().equals(this.getSobrenome());
	}

	public void setId(String id) {
            if (id != null){
                this.id = id;
            }
	}
	
        @Override
	public String toString() {
		return this.getNome() + " " + this.getSobrenome();
	}

		@Override
		public int compareTo(Autor o) {
			
			return this.nome.compareToIgnoreCase(o.getNome());
		}
	
	

}
