package projeto_sorvil.model;

import java.io.Serializable;
import java.util.Objects;

public class Autor implements Comparable<Autor>, Serializable {
	

	private static final long serialVersionUID = -3427491444864579533L;
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
        final Autor other = (Autor) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

	
	private String nome;
	private String id;
	
	public Autor(String nome, String id) {
		
		this.nome = nome;
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

	

	public String getId() {
		return id;
	}
	
	
	

	public void setId(String id) {
            if (id != null){
                this.id = id;
            }
	}
	
        @Override
	public String toString() {
		return this.getNome();
	}

		@Override
		public int compareTo(Autor o) {
			
			return this.nome.compareToIgnoreCase(o.getNome());
		}
	
	

}
