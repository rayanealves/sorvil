package projeto_sorvil.exceptions;

public class NaoExisteException extends Exception{
	private static final long serialVersionUID = -7579257249288556574L;
	private Object objeto;
        private String nome;

    
	
	public NaoExisteException(Object obj) {
		super("Elemento n�o existente");
		this.objeto = obj;
	}
        
        public NaoExisteException(String nome) {
		super(nome + " não existente no sistema");
		this.nome = nome;
	}

	public Object getObjeto() {
		return objeto;
	}

	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}
        
        public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
