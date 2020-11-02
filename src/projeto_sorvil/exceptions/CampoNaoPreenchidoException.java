
package projeto_sorvil.exceptions;


public class CampoNaoPreenchidoException extends Exception{
   
	/**
	 * 
	 */
	private static final long serialVersionUID = -2131041155663819460L;
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


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
        
      
    }

   
