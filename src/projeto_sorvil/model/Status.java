
package projeto_sorvil.model;

public enum Status {
    LIDO("Lido"), LENDO("Lendo"), QUERO_LER("Quero ler"), ABANDONADO("Abandonei"), EM_BRANCO("EM_BRANCO");
    
 
    Status(String nome){
        this.status = nome;
    }
    String status; 
    
    public String getStatus(){
        return this.status;
    }
    
}
