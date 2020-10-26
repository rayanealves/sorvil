/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_sorvil.dados;

import java.util.List;
import projeto_sorvil.model.Editora;

/**
 *
 * @author Rayan
 */
public interface IrepositorioEditora {
    
    public boolean adicionar (Editora editora);
    
    public Editora buscar(int indice);
    
    public boolean idExiste(String id);
    
    public boolean apagar (Editora editora);
    
    public List<Editora> listar();
}
