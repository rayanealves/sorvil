/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_sorvil.dados;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import projeto_sorvil.model.Editora;
import projeto_sorvil.model.Usuario;


/**
 *
 * @author Rayan
 */
public class EditoraRepositorio implements RepositorioEditora, Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -3143520935641433330L;
	private static EditoraRepositorio instance;
        private static final String ROTA = "src/editoras.dat";
    
    public static RepositorioEditora getInstance() {
        if (instance == null) {
            instance = (EditoraRepositorio)DAO.lerDoArquivo(ROTA);
             if(instance == null){
                ArrayList<Editora> novoArq = new ArrayList<>();
                instance = new EditoraRepositorio(novoArq);
            }
        }
        return instance;
    }
    
    private ArrayList<Editora> editoras = new ArrayList<>();
    
    public EditoraRepositorio(ArrayList<Editora> editoras){
    	this.editoras = editoras;
    }
    
    
    @Override
    public boolean adicionar (Editora editora){
        boolean retorno = this.editoras.add(editora);
        DAO.salvarArquivo(instance, ROTA);
        return retorno;
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
        boolean retorno = this.editoras.remove(editora);
        DAO.salvarArquivo(instance, ROTA);
        return retorno;
    }
    
    @Override
    public List<Editora> listar(){
        return editoras;
    }
}
