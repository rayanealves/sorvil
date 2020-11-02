
package projeto_sorvil.exceptions;


public class CampoNaoPreenchidoException extends Exception{
   
	private Object objeto;
        private String nome;

    
	
	public CampoNaoPreenchidoException(Object obj) {
		super("Você precisa preencher todos os campos");
		this.objeto = obj;
	}
        

	public Object getObjeto() {
		return objeto;
	}

	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}
        
      
    }

   
