
package projeto_sorvil.model;

public enum Status {
    LIDO("Lido"), LENDO("Lendo"), QUERO_LER("Quero ler"), ABANDONADO("Abandonei"), EM_BRANCO("EM_BRANCO");
    
	
	String status; 
 
    Status(String nome){
        this.status = nome;
    }
    
    public String getStatus(){
        return this.status;
    }
    
}
