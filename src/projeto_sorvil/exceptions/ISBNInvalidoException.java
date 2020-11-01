/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_sorvil.exceptions;


public class ISBNInvalidoException extends Exception{
    private Object objeto;
    
    public ISBNInvalidoException(String obj) {
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
		return "ISBN Invalido!";
	}
}
