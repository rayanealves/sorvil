
package projeto_sorvil.dados;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import projeto_sorvil.model.Autor;
import projeto_sorvil.model.Editora;
import projeto_sorvil.model.Genero;
import projeto_sorvil.model.Livro;


public class LivroRepositorio implements RepositorioLivro {

    private static LivroRepositorio instance;
    
    public static RepositorioLivro getInstance() {
        if (instance == null) {
            instance = LivrosDAO.lerDoArquivo();
        }
        return instance;
    }
    
    private ArrayList<Livro> livros = new ArrayList<>();
    
    public LivroRepositorio(ArrayList<Livro> livros) {
		this.livros = livros;
	}
    
    @Override
    public boolean adicionar (Livro livro){
        return this.livros.add(livro);
    }
    
    @Override
    public boolean adicionar (Livro livro, Genero genero){
        return this.buscar(livro).getGenero().add(genero);
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
        return this.livros.remove(livro);
    }
    
    @Override
    public boolean apagar(Livro livro, Genero genero){
        return this.buscar(livro).getGenero().remove(genero);  
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
            .filter(livro-> livro.getGenero().contains(genero))
            .collect(Collectors.toList());
    }
    
    @Override
    public void alterarEditora(Livro livro, Editora editora) {
       this.buscar(livro).setEditora(editora);
    }
    
}
