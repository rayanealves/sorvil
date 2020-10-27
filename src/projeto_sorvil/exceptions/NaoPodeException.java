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
public class NaoPodeException extends Exception{
    
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7162052118898576922L;
	private Object objeto;
	
	public NaoPodeException(Object obj) {
		super("Você não pode fazer isso");
		this.objeto = obj;
	}

	public Object getObjeto() {
		return objeto;
	}

	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}

}
