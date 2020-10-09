
package projeto_sorvil.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import projeto_sorvil.dados.CardRepositorio;
import projeto_sorvil.dados.RepositorioCards;
import projeto_sorvil.model.Card;
import projeto_sorvil.model.Livro;
import projeto_sorvil.model.Usuario;

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
    
    private boolean confereID(String id){
        return this.repositorioCards.idExiste(id);
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
    
    public boolean novoCard(Card card){
        if (card != null){
            card.setId(this.novoID());
            if(!this.repositorioCards.listar().contains(card)){
                return this.repositorioCards.adicionar(card);
            }
        }
        return false;
    }
    
    public List<Card> listarCardsPublicos(){
        return  this.repositorioCards.listar().stream()
                .filter(card -> card.isPublico() == true)
                .collect(Collectors.toList());
    }
    
    public List<Card> listarCardsPublicosLivro(Livro livro){
        return  this.repositorioCards.listar(livro).stream()
                .filter(card -> card.isPublico() == true)
                .collect(Collectors.toList());
    }
    
    public List<Card> listarCardsPublicosUsuario(Usuario usuario){
        return  this.repositorioCards.listar(usuario).stream()
                .filter(card -> card.isPublico() == true)
                .collect(Collectors.toList());
    }
    
    public List<Card> listarCardsUsuario(Usuario usuario){
        return  this.repositorioCards.listar(usuario);
    }
    
    public List<Card> listarCardsLivroUsuario(Usuario usuario, Livro livro){
        return  this.repositorioCards.listar(usuario)
                .stream()
                .filter(card -> card.getLivro().equals(livro))
                .collect(Collectors.toList());
    }
    
    
    
    
    
    
    
    
    




    
}
