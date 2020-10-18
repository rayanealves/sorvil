
package projeto_sorvil.model;

public enum Status {
    LIDO("Lido"), LENDO("Lendo"), QUERO_LER("Quero ler"), ABANDONADO("Abandonei");
    
 
    Status(String nome){
        this.status = nome;
    }
    String status; 
    
    public String getStatus(){
        return this.status;
    }
}
