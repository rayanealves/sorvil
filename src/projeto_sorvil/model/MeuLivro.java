
package projeto_sorvil.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class MeuLivro extends Livro{
    
    private int nota;
    private Status status;
    
    public MeuLivro(String nome, String id,
            Editora editora, Autor autor,
            ArrayList<Genero> genero, int numPaginas,
            int edicao, LocalDate anoP, Status status, int nota) {
        super(nome, id, editora, autor, genero, numPaginas, edicao, anoP);
        
        this.status = status;
        this.nota = nota;
    }
    
    public MeuLivro(String nome, String id,
            Editora editora, Autor autor,
            ArrayList<Genero> genero, int numPaginas,
            int edicao, LocalDate anoP) {
        super(nome, id, editora, autor, genero, numPaginas, edicao, anoP);
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
    
    
}
