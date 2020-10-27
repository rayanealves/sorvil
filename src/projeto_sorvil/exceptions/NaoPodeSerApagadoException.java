package projeto_sorvil.exceptions;

public class NaoPodeSerApagadoException extends Exception {



	private static final long serialVersionUID = 3337620851656674074L;

	
	
	private Object objeto;
	
	public NaoPodeSerApagadoException(Object obj) {
		super("Elemento não pode ser apagado");
		this.objeto = obj;
	}

	public Object getObjeto() {
		return objeto;
	}

	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}

}
