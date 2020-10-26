package projeto_sorvil.dados;

import java.util.List;

import projeto_sorvil.model.Autor;



public interface IrepositorioAutor {
	
	boolean adicionar(Autor autor);
    
	public Autor buscar(int indice);
	
	public Autor buscar(Autor autor);
	
	public boolean apagar(Autor autor);
        
    public List<Autor> listar();
    
    public boolean idExiste(String id);
        
    public List<Autor> listarPrimeiroNome(String nome);
}
