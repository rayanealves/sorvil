/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_sorvil.dados;

import java.util.ArrayList;
import java.util.List;
import projeto_sorvil.model.Editora;


/**
 *
 * @author Rayan
 */
public class EditoraRepositorio implements RepositorioEditora {
    
    private static EditoraRepositorio instance;
    
    public static RepositorioEditora getInstance() {
        if (instance == null) {
            instance = EditorasDAO.lerDoArquivo();
        }
        return instance;
    }
    
    private ArrayList<Editora> editoras = new ArrayList<>();
    
    public EditoraRepositorio(ArrayList<Editora> editoras){
    	this.editoras = editoras;
    }
    
    
    @Override
    public boolean adicionar (Editora editora){
        return this.editoras.add(editora);
    }
    
    @Override
    public Editora buscar(int indice) {
	return this.editoras.get(indice);
    }
    
    @Override
    public boolean idExiste(String id){
        boolean existe = false;
        for(Editora editora : editoras){
            if(editora.getId().equals(id)){
                existe = true;
            }
        }
        return existe;
    }
    
    @Override
    public boolean apagar (Editora editora){
        return this.editoras.remove(editora);
    }
    
    @Override
    public List<Editora> listar(){
        return editoras;
    }
}
