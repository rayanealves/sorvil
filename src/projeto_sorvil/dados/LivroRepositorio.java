
package projeto_sorvil.dados;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import projeto_sorvil.model.Autor;
import projeto_sorvil.model.Editora;
import projeto_sorvil.model.Genero;
import projeto_sorvil.model.Livro;
import projeto_sorvil.model.Usuario;


public class LivroRepositorio implements IrepositorioLivro, Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 771305092283466252L;
	private static LivroRepositorio instance;
        private static final String ROTA = "src/livros.dat";
    
    public static IrepositorioLivro getInstance() {
        if (instance == null) {
            instance = (LivroRepositorio) DAO.lerDoArquivo(ROTA);
             if(instance == null){
                ArrayList<Livro> novoArq = new ArrayList<>();
                instance = new LivroRepositorio(novoArq);
            }
        }
        return instance;
    }
    
    private ArrayList<Livro> livros = new ArrayList<>();
    
    public LivroRepositorio(ArrayList<Livro> livros) {
		this.livros = livros;
	}
    
    @Override
    public boolean adicionar (Livro livro){
        boolean retorno = this.livros.add(livro);
        DAO.salvarArquivo(instance, ROTA);
        return retorno;
        
    }
    
    @Override
    public Livro buscar(int indice) {
	return this.livros.get(indice);
    }
    
    @Override
    public Livro buscar (Livro livro){
        return this.buscar(this.livros.indexOf(livro));
    }
    
    @Override
    public boolean idExiste(String id){
        boolean existe = false;
        for(Livro livro : livros){
            if(livro.getId().equals(id)){
                existe = true;
            }
        }
        return existe;
    }
    
    @Override
    public boolean apagar(Livro livro){
        boolean retorno = this.livros.remove(livro);
        DAO.salvarArquivo(instance, ROTA);
        return retorno;
    }
    
   
      
    @Override
    public List<Livro> listar(){
        return livros;
    }
    
    @Override
    public List<Livro> listar(Autor autor) {
        return livros.stream()
            .filter(livro-> livro.getAutor().equals(autor))
            .collect(Collectors.toList());
    }
    
    @Override
    public List<Livro> listar(Editora editora) {
        return livros.stream()
            .filter(livro-> livro.getEditora().equals(editora))
            .collect(Collectors.toList());
    }
    
    @Override
    public List<Livro> listar(Genero genero) {
        return livros.stream()
            .filter(livro-> livro.getGenero().equals(genero))
            .collect(Collectors.toList());
    }
    
    @Override
    public void alterarEditora(Livro livro, Editora editora) {
       this.buscar(livro).setEditora(editora);
       DAO.salvarArquivo(instance, ROTA);
    }
    
}
