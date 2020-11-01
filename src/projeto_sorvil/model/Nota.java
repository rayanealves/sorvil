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
    SEM_NOTA(0), X(1), XX(2), XXX(3), XXXX(4), XXXXX(5);
    public int nota;
    
    Nota(int n){
       this.nota = n; 
    }
}
