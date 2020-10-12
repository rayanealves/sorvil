package projeto_sorvil.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import projeto_sorvil.model.Editora;

public class EditorasDAO {
	
	public static EditoraRepositorio lerDoArquivo() {
        
		EditoraRepositorio instanciaLocal = null;
		    File in = new File("src/editoras.dat");
		    FileInputStream fis;
		    ObjectInputStream ois = null;
		    ArrayList<Editora> edt = new ArrayList<>();
		    
            try {
		      fis = new FileInputStream(in);
		      ois = new ObjectInputStream(fis);
		      Object o = ois.readObject();
		      instanciaLocal = (EditoraRepositorio) o;
		    } catch (IOException | ClassNotFoundException e) {
		      instanciaLocal = new EditoraRepositorio(edt);
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
   
   public void salvarArquivo(EditoraRepositorio instance) {
	    if (instance == null) {
	      return;
	    }
	    File out = new File("src/editoras.dat");
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
