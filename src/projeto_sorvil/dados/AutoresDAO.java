package projeto_sorvil.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import projeto_sorvil.model.Autor;

public class AutoresDAO {
	
	public static AutorRepositorio lerDoArquivo() {
        AutorRepositorio instanciaLocal = null;

		    File in = new File("src/autores.dat");
		    FileInputStream fis;
		    ObjectInputStream ois = null;
		    ArrayList<Autor> aut = new ArrayList<>();
		    
            try {
		      fis = new FileInputStream(in);
		      ois = new ObjectInputStream(fis);
		      Object o = ois.readObject();
		      instanciaLocal = (AutorRepositorio) o;
		    } catch (IOException | ClassNotFoundException e) {
		      instanciaLocal = new AutorRepositorio(aut);
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
   
   public void salvarArquivo(AutorRepositorio instance) {
	    if (instance == null) {
	      return;
	    }
	    File out = new File("src/autores.dat");
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
