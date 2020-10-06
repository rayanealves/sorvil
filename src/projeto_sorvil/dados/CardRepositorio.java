package projeto_sorvil.dados;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import projeto_sorvil.model.Card;
import projeto_sorvil.model.Livro;
import projeto_sorvil.model.Usuario;

public class CardRepositorio implements RepositorioCards{
	
	private final ArrayList<Card> cards = new ArrayList<>();
        

        @Override
	public boolean adicionar(Card card) {		
		return this.cards.add(card);		
	}
	
      
        @Override
	public Card buscar(int indice) {
		return this.cards.get(indice);
	}
	
        @Override
	public boolean apagar(Card card) {
		return this.cards.remove(card);
	}

        @Override
        public List<Card> listar() {
            return cards;    }

        @Override
        public List<Card> listar(Usuario usuario) {
            return cards.stream()
                    .filter(card-> card.getUsuario().equals(usuario))
                    .collect(Collectors.toList());
        }

        @Override
        public List<Card> listar(Livro livro) {
            return cards.stream()
                    .filter(card-> card.getLivro().equals(livro))
                    .collect(Collectors.toList());
        }

         @Override
         public List<Card> listar(String titulo) {
            return cards.stream()
                    .filter(card-> card.getTitulo().equals(titulo))
                    .collect(Collectors.toList());
        }

    
	
	

	

	
	
	

}
