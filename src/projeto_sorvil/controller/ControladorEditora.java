/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_sorvil.controller;

import java.util.UUID;
import projeto_sorvil.dados.EditoraRepositorio;
import projeto_sorvil.dados.RepositorioEditora;
import projeto_sorvil.model.Editora;
import projeto_sorvil.model.Usuario;

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
    
    private String novoID(){
        String idProvi = UUID.randomUUID().toString();
        if(this.confereID(idProvi)){
            return novoID();
        }
        else{
            return idProvi;
        }
    }
    
    private boolean novaEditora(Editora editora){
        if(editora != null){
            editora.setId(this.novoID());
            if(!this.respositorioEditora.listar().contains(editora)){
               return this.respositorioEditora.adicionar(editora); 
            }
        }
        
        return false;
    }
    
    public boolean deleteEditora(Usuario usuario, Editora editora){
        if(editora != null ){
            if (!this.respositorioEditora.listar().contains(editora) && usuario.isAdmin() == true){
                return this.respositorioEditora.apagar(editora);
            }    
        }
        return false;
    }
    
    public Editora buscarEditora(String nome){
        Editora editora = null;
        if (nome != null){
            for(Editora edt : this.respositorioEditora.listar()){
                if(edt.getNome().equals(nome)){
                    editora = edt;
                }
            }
        }
        return editora;
    }
}
