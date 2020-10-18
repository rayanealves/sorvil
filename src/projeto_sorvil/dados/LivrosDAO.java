package projeto_sorvil.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


import projeto_sorvil.model.Livro;

public class LivrosDAO {
	
	public static LivroRepositorio lerDoArquivo() {
        
		LivroRepositorio instanciaLocal = null;
		    File in = new File("src/livros.dat");
		    FileInputStream fis;
		    ObjectInputStream ois = null;
		    ArrayList<Livro> lvr = new ArrayList<>();
		    
            try {
		      fis = new FileInputStream(in);
		      ois = new ObjectInputStream(fis);
		      Object o = ois.readObject();
		      instanciaLocal = (LivroRepositorio) o;
		    } catch (IOException | ClassNotFoundException e) {
		      instanciaLocal = new LivroRepositorio(lvr);
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
   
   public static void salvarArquivo(EditoraRepositorio instance) {
	    if (instance == null) {
	      return;
	    }
	    File out = new File("src/livros.dat");
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
