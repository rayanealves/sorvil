package projeto_sorvil.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class DAO {
	
	public static Object lerDoArquivo(String caminho) {
        Object instanciaLocal = null;

		    File arquivoIn = new File(caminho);
		    FileInputStream lerArquivo;
		    ObjectInputStream lerObjeto = null;
		    
		    
            try {
		      lerArquivo = new FileInputStream(arquivoIn);
		      lerObjeto = new ObjectInputStream(lerArquivo);
		      Object o = lerObjeto.readObject();
		      instanciaLocal = o;
		    } catch (IOException | ClassNotFoundException e) {
		      instanciaLocal = null;
		    } finally {
		      if (lerObjeto != null) {
		        try {
                     
		          lerObjeto.close();
		        } catch (IOException e) {
		        }
		      }
		    }

		    return instanciaLocal;
		  
   }
   
   public static void salvarArquivo(Object instance, String caminho) {
	    if (instance == null) {
	      return;
	    }
	    File arquivoOut = new File(caminho);
	    FileOutputStream gravarArquivo;
	    ObjectOutputStream gravarObjeto = null;

	    try {
	      gravarArquivo = new FileOutputStream(arquivoOut);
	      gravarObjeto = new ObjectOutputStream(gravarArquivo);
	      gravarObjeto.writeObject(instance);
	    } catch (IOException e) {
	    } finally {
	      if (gravarObjeto != null) {
	        try {
	          gravarObjeto.close();
	        } catch (IOException e) {
	          }
	      }
	    }
	  }


}
