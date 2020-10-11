/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_sorvil.controller;

import projeto_sorvil.dados.EditoraRepositorio;
import projeto_sorvil.dados.RepositorioEditora;

/**
 *
 * @author Rayan
 */
public class ControladorEditora {
    
    private RepositorioEditora respositorioEditora;
    private static ControladorEditora instance;
    
    public static ControladorEditora getInstance() {
        if (instance == null) {
            instance = new ControladorEditora();
        }
        return instance;
    }
    
    private ControladorEditora(){
        this.respositorioEditora = EditoraRepositorio.getInstance();
    }
    
    private boolean confereID(String id){
        return this.respositorioEditora.idExiste(id);
    }
}
