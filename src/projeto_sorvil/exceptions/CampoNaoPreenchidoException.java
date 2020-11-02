/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_sorvil.exceptions;

/**
 *
 * @author usuario
 */
public class CampoNaoPreenchidoException extends Exception{
   
	private Object objeto;
        private String nome;

    
	
	public CampoNaoPreenchidoException(Object obj) {
		super("Você precisa preencher todos os campos");
		this.objeto = obj;
	}
        
        public CampoNaoPreenchidoException(String nome) {
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
