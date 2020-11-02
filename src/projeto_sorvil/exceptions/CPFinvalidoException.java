/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_sorvil.exceptions;


public class CPFinvalidoException extends Exception{
    /**
	 * 
	 */
	private static final long serialVersionUID = 8106249242645718877L;
	private Object objeto;
    
    public CPFinvalidoException(Object obj) {
        super("Formato Invalido");
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
		return "CPF Invalido!";
	}
}
