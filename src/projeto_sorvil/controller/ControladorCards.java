
package projeto_sorvil.controller;

import projeto_sorvil.dados.CardRepositorio;

public class ControladorCards {
    
    private CardRepositorio repositorioCards;

    public ControladorCards() {
        this.repositorioCards = CardRepositorio.getInstance();
    }

    
}
