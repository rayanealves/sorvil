package projeto_sorvil.controller;


import java.util.List;
import java.util.UUID;
import projeto_sorvil.dados.AutorRepositorio;
import projeto_sorvil.dados.IrepositorioAutor;
import projeto_sorvil.exceptions.NaoExisteException;
import projeto_sorvil.model.Autor;


public class ControladorAutor {
	
	private IrepositorioAutor repositorioAutores;
	private static ControladorAutor instance;
        
        public static ControladorAutor getInstance() {
        if (instance == null) {
            instance = new ControladorAutor();
        }
        return instance;
    }
         public ControladorAutor() {
        this.repositorioAutores = AutorRepositorio.getInstance();
    }
	
	private boolean confereID(String id){
        return this.repositorioAutores.idExiste(id);
    }
    
    private String novoID(){
        String idProvi = UUID.randomUUID().toString();
        if(this.confereID(idProvi)){
            return novoID();
        }
        else{
            return idProvi;
        }
    }
    
    public boolean novoAutor(Autor autor){
     
            autor.setId(this.novoID());
            if(!this.repositorioAutores.listar().contains(autor)){
                return this.repositorioAutores.adicionar(autor);
            }
            return false;
        }
    
    
    public Autor bucarPorNome(String nome){
    	
        List<Autor> resultado = this.repositorioAutores.listarAutoresPorNome(nome);
        Autor saida = null;
        if(resultado.size() == 1){
            saida = resultado.get(0);
        }
    	return saida;
    }
    
   
    
  
    
    public boolean delete(Autor autor) throws NaoExisteException {
    	
		if(this.repositorioAutores.autorExiste(autor)) {
    		return this.repositorioAutores.apagar(autor);
    	}
    	else {
    		throw new NaoExisteException(autor);
    	}
    }
    
  
	
	
}
