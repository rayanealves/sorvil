/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_sorvil.controller;

import java.util.UUID;
import projeto_sorvil.dados.EditoraRepositorio;
import projeto_sorvil.dados.IrepositorioEditora;
import projeto_sorvil.model.Editora;
import projeto_sorvil.model.Usuario;
import projeto_sorvil.exceptions.JaExisteException;
import projeto_sorvil.exceptions.NaoExisteException;
import projeto_sorvil.exceptions.NaoPodeException;

/**
 *
 * @author Rayan
 */
public class ControladorEditora {
    
    private IrepositorioEditora respositorioEditora;
    private static ControladorEditora instance;
    
    public static ControladorEditora getInstance() {
        if (instance == null) {
            instance = new ControladorEditora();
        }
        return instance;
    }
    
    public ControladorEditora(){
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
    
   public boolean novaEditora(Editora editora) throws JaExisteException{
        if(editora != null){
            editora.setId(this.novoID());
            if(!this.respositorioEditora.listar().contains(editora)){
               return this.respositorioEditora.adicionar(editora); 
            }
            else{
                throw new JaExisteException(editora);
            }
        }
        
        return false;
    }
    
    public boolean deleteEditora(Usuario usuario, Editora editora) throws NaoPodeException{
        if(editora != null ){
            if (!this.respositorioEditora.listar().contains(editora) && usuario.isAdmin() == true){
                return this.respositorioEditora.apagar(editora);
            }
            else{
                throw new NaoPodeException(usuario);
            }
        }
        return false;
    }
    
    public Editora buscarEditora(String nome){
        Editora editora = null;
        if (nome != null){
            for(Editora edt : this.respositorioEditora.listar()){
                if(edt.getNome().equalsIgnoreCase(nome)){
                    editora = edt;
                }
            }
            if( editora != null){
                return editora;
            }
            
        }
        return editora;
    }
}
