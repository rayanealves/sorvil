package projeto_sorvil.dados;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import projeto_sorvil.model.Autor;


public class AutorRepositorio implements IrepositorioAutor, Serializable {
	
	
	private static final long serialVersionUID = -1917041256616276329L;
	private ArrayList<Autor> autores;
	private static AutorRepositorio instance;
        private static final String ROTA = "src/autores.dat";
	
	public AutorRepositorio(ArrayList<Autor> aut) {
		autores = aut;
	}
	
	public static AutorRepositorio getInstance() {
		if(instance == null) {
			instance = (AutorRepositorio)DAO.lerDoArquivo(ROTA);
                        if (instance == null){
                            ArrayList<Autor> novoRep = new ArrayList<>(); 
                            instance = new AutorRepositorio(novoRep);
                        }
		}
		return instance;
	}
	
	
		

	@Override
	public boolean adicionar(Autor autor) {
		boolean retorno = autores.add(autor);
                System.out.println("aqui");
                DAO.salvarArquivo(instance, ROTA);
                System.out.println(retorno);
                System.out.println(instance.listar());
                return retorno;
	}

	@Override
	public Autor buscar(int indice) {
		return autores.get(indice);
	}
	
        @Override
	public Autor buscar(Autor autor) {
		return this.buscar(autores.indexOf(autor));
	}

	@Override
	public boolean apagar(Autor autor) {
		boolean retorno = autores.remove(autor);
                DAO.salvarArquivo(instance, ROTA);
                return retorno;
	}

	@Override
	public List<Autor> listar() {
		return autores;
	}
	
        @Override
	public List<Autor> listarPrimeiroNome(String nome) {
         return autores.stream()
                 .filter(autor-> autor.getNome().equalsIgnoreCase(nome))
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

	@Override
	public boolean autorExiste(Autor autor) {
		return this.autores.contains(autor);
	}

}
