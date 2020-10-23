package projeto_sorvil.exceptions;

public class JaExisteException extends Exception {
	

private static final long serialVersionUID = -3040088524270012847L;
private Object objeto;
    
    public JaExisteException(Object obj) {
        super("Elemento já existe");
        this.objeto = obj;        
    }

	public Object getObjeto() {
		return objeto;
	}

	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}
    
	@Override
	public String toString() {
		return "JaExisteException [objeto=" + objeto + "]";
	}

}
