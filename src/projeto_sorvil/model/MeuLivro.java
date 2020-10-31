
package projeto_sorvil.model;

import java.io.Serializable;

public class MeuLivro implements Serializable{

    private static final long serialVersionUID = 1955524342716143140L;
    private int nota;
    private Status status;

    public void setStatus(Status status) {
        this.status = status;
    }
    private boolean favorito = false;
    private Livro livro;
    
    public MeuLivro(Livro livro, Status status, int nota) {
        
        this.status = status;
        this.nota = nota;
        this.livro = livro;
    }
    
    public int getNota(){
        return this.nota;
    }
    
    public void setNota(int nota){
        this.nota = nota;
    }
    
    public Status getStatus(){
        return this.status;
    }


    public boolean isFavorito() {
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

	@Override
	public String toString() {
		return  livro.toString() + "\n nota=" + nota + ", status=" + status + "\n, favorito=" + favorito;
	}
    
    
    
}
