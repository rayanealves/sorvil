package projeto_sorvil.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import projeto_sorvil.model.Card;

public class CardsDAO {
	
	public static CardRepositorio lerDoArquivo() {
        CardRepositorio instanciaLocal = null;

		    File in = new File("src/cards.dat");
		    FileInputStream fis;
		    ObjectInputStream ois = null;
		    ArrayList<Card> cds = new ArrayList<>();
		    
                   try {
		      fis = new FileInputStream(in);
		      ois = new ObjectInputStream(fis);
		      Object o = ois.readObject();
		      instanciaLocal = (CardRepositorio) o;
		    } catch (IOException | ClassNotFoundException e) {
		      instanciaLocal = new CardRepositorio(cds);
		    } finally {
		      if (ois != null) {
		        try {
		          ois.close();
		        } catch (IOException e) {
		        }
		      }
		    }

		    return instanciaLocal;
		  
   }
   
   public static void salvarArquivo(CardRepositorio instance) {
	    if (instance == null) {
	      return;
	    }
	    File out = new File("src/cards.dat");
	    FileOutputStream fos;
	    ObjectOutputStream oos = null;

	    try {
	      fos = new FileOutputStream(out);
	      oos = new ObjectOutputStream(fos);
	      oos.writeObject(instance);
	    } catch (IOException e) {
	    } finally {
	      if (oos != null) {
	        try {
	          oos.close();
	        } catch (IOException e) {
	          }
	      }
	    }
	  }


}
