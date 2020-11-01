 
package projeto_sorvil.model;

import java.io.Serializable;

public class MeuLivro implements Serializable{

    private static final long serialVersionUID = 1955524342716143140L;
    private Nota nota;
    private Status status;
    private boolean favorito;
    private Livro livro;
    
    public MeuLivro(Livro livro) {
    	this.favorito = false;
        this.status = Status.EM_BRANCO;
        this.nota = Nota.SEM_NOTA;
        this.livro = livro;
    }
    
    
    
    public Status getStatus(){
        return this.status;
    }
    
    public void setStatus(Status status) {
		this.status = status;
	}

	public boolean getFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }
    
    public Livro getLivro() {
        return livro;
    }
    
    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    
    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

	@Override
	public String toString() {
		return "====================\n" + livro.toString() + "\n Nota: " + nota
                        + " | Status: " + status + "\nFavorito: "
                        + favorito + "\n====================";
	}


	public boolean equals(MeuLivro outro) {
		if (outro == null) {
				return false;
		} 
		else return this.livro.equals(outro.getLivro());
	}
    
	
    
    
}
