package projeto_sorvil.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import projeto_sorvil.model.Usuario;

public class UsuariosDAO {
	
	
	public static UsuarioRepositorio lerDoArquivo() {
        UsuarioRepositorio instancia = null;

		    File in = new File("src/usuarios.dat");
		    FileInputStream fis;
		    ObjectInputStream ois = null;
		    ArrayList<Usuario> cds = new ArrayList<>();
		    
                   try {
		      fis = new FileInputStream(in);
		      ois = new ObjectInputStream(fis);
		      Object o = ois.readObject();
		      instancia = (UsuarioRepositorio) o;
		    } catch (IOException | ClassNotFoundException e) {
		      instancia = new UsuarioRepositorio(cds);
		    } finally {
		      if (ois != null) {
		        try {
		          ois.close();
		        } catch (IOException e) {
		        }
		      }
		    }

		    return instancia;
		  
   }
   
   public void salvarArquivo(UsuarioRepositorio instancia) {
	    if (instancia == null) {
	      return;
	    }
	    File out = new File("src/usuario.dat");
	    FileOutputStream fos;
	    ObjectOutputStream oos = null;

	    try {
	      fos = new FileOutputStream(out);
	      oos = new ObjectOutputStream(fos);
	      oos.writeObject(instancia);
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
	


