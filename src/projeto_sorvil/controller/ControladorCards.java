
package projeto_sorvil.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import projeto_sorvil.dados.CardRepositorio;
import projeto_sorvil.dados.IrepositorioCards;
import projeto_sorvil.exceptions.JaExisteException;
import projeto_sorvil.exceptions.NaoExisteException;
import projeto_sorvil.exceptions.NaoPodeException;
import projeto_sorvil.model.Card;
import projeto_sorvil.model.Livro;
import projeto_sorvil.model.Usuario;


public class ControladorCards {
    
    private IrepositorioCards repositorioCards;
    private static ControladorCards instance;
    
    public static ControladorCards getInstance() {
        if (instance == null) {
            instance = new ControladorCards();
        }
        return instance;
    }
    
    public ControladorCards() {
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
    
    public boolean novoCard(Card card) throws JaExisteException, NaoPodeException{
        if (card != null){
            card.setId(this.novoID());
            if(!card.getTitulo().equals("")){
                if(!this.repositorioCards.listar().contains(card)){
                    return this.repositorioCards.adicionar(card);
                }
                else{
                    throw new JaExisteException(card);
                }   
            }
            else {
                throw new NaoPodeException(card);
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
    
    public boolean deleteCard(Usuario usuario, Card card) throws NaoPodeException{
        if(card != null ){
            if (usuario.equals(card.getUsuario()) || usuario.isAdmin() == true){
                return this.repositorioCards.apagar(card);
            }
            else{
                throw new NaoPodeException(card);
            }
        }
        return false;
    }
    
    
    public Card buscarPorTitulo(String titulo) throws NaoExisteException{
        Card card = null;
        if (titulo != null){
            for(Card crd : this.repositorioCards.listar()){
                if(crd.getTitulo().equalsIgnoreCase(titulo)){
                    card = crd;
                }
            }
            if (card != null){
                return card;
            }
            else{
                throw new NaoExisteException(card);
            }
        }
        return card;
    }
    
    public Card buscar(Card card) throws NaoExisteException {
    	Card encontrado;
        if(card != null) {
    		encontrado = this.repositorioCards.buscar(card);
                if(encontrado != null){
                    return encontrado;
                }
                else{
                    throw new NaoExisteException(card);
                }
    	}
    	return null;
    }
    
    public boolean editar(Card card, Usuario usuario, String texto) {
    	if(texto.equals("") && card.getUsuario().equals(usuario)) {
    		this.repositorioCards.editar(card, texto);
    		return true;
    	}
    	return false;
    }
    
    public void tornarPublico(Card card) throws NaoExisteException {
    	this.buscar(card).setPublico(true);
    }
    
    public void tornarPrivado(Card card) throws NaoExisteException {
    	this.buscar(card).setPublico(false);
    }
    
    
    
    
    
    




    
}
