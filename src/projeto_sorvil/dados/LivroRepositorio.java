
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
            instance = new LivroRepositorio();
        }
        return instance;
    }
    
    private final ArrayList<Livro> livros = new ArrayList<>();
    
    
    @Override
    public boolean adicionar (Livro livro){
        return this.livros.add(livro);
    }
    
    
    @Override
    public Livro buscar(int indice) {
	return this.livros.get(indice);
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
    public boolean apagar (Livro livro){
        return this.livros.remove(livro);
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
    
    
    
}
