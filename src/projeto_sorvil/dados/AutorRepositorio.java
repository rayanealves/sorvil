package projeto_sorvil.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import projeto_sorvil.model.Autor;
import projeto_sorvil.model.Card;

public class AutorRepositorio implements RepositorioAutor {
	
	private ArrayList<Autor> autores;
	private static AutorRepositorio instance;
	
	public AutorRepositorio(ArrayList<Autor> autores) {
		this.autores = autores;
	}
	
	public static AutorRepositorio getInstance() {
		if(instance == null) {
			instance = AutoresDAO.lerDoArquivo();
		}
		return instance;
	}
	
	
		

	@Override
	public boolean adicionar(Autor autor) {
		return this.autores.add(autor);
	}

	@Override
	public Autor buscar(int indice) {
		return this.autores.get(indice);
	}
	
	public Autor buscar(Autor autor) {
		return this.buscar(this.autores.indexOf(autor));
	}

	@Override
	public boolean apagar(Autor autor) {
		return this.autores.remove(autor);
	}

	@Override
	public List<Autor> listar() {
		return this.autores;
	}
	
	 @Override
     public boolean idExiste(String id){
         boolean existe = false;
         for(Autor autor : autores){
             if(autor.getId().equals(id)){
                 existe = true;
             }
         }
         return existe;
     }

}
