
package projeto_sorvil.controller;

import projeto_sorvil.dados.CardRepositorio;
import projeto_sorvil.dados.RepositorioCards;

public class ControladorCards {
    
    private RepositorioCards repositorioCards;
    private static ControladorCards instance;
    
    public static ControladorCards getInstance() {
        if (instance == null) {
            instance = new ControladorCards();
        }
        return instance;
    }
    
    private ControladorCards() {
        this.repositorioCards = CardRepositorio.getInstance();
    }
    

    




    
}
