/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_sorvil.model;

/**
 *
 * @author usuario
 */
public enum Nota {
    SEM_NOTA(0 , " "), X(1,"X"), XX(2, "XX"), XXX(3, "XXX"), XXXX(4, "XXXX"), XXXXX(5, "");
    
	public int nota;
    public String snota;
    
    Nota(int n, String s){
       this.nota = n; 
       this.snota = s;
    }
    
    
    public String getSnota(){
        return this.snota;
    }
}
