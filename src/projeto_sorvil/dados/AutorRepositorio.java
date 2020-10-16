package projeto_sorvil.dados;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import projeto_sorvil.model.Autor;


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
	
	public List<Autor> listarPrimeiroNome(String nome) {
         return autores.stream()
                 .filter(autor-> autor.getNome().equals(nome))
                 .collect(Collectors.toList());
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
