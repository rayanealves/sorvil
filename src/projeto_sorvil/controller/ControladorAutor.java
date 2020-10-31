package projeto_sorvil.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import projeto_sorvil.dados.AutorRepositorio;
import projeto_sorvil.dados.IrepositorioAutor;
import projeto_sorvil.exceptions.JaExisteException;
import projeto_sorvil.exceptions.NaoExisteException;
import projeto_sorvil.model.Autor;


public class ControladorAutor {
	
	private IrepositorioAutor repositorioAutores;
	private static ControladorAutor instance;
	
	
	private  String[] separarNome(String nome){
		String[] nomeSeparado = nome.split(" ");
		return nomeSeparado;
	}
	
	private String juntarSobrenome(String[] nomeSep) {
		String sobrenome = "";
		for (int i = 1; i < nomeSep.length; i++) {
			sobrenome += nomeSep[i] + " ";
		}
		return sobrenome;
	}
	
	
	public ControladorAutor() {
		this.repositorioAutores = AutorRepositorio.getInstance();
	}
	
	public static ControladorAutor getInstance() {
		if(instance == null) {
			instance = new ControladorAutor();
		}
		return instance;
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
    
    public boolean novoAutor(Autor autor) throws JaExisteException{
     
            autor.setId(this.novoID());
            if(!this.repositorioAutores.listar().contains(autor)){
                return this.repositorioAutores.adicionar(autor);
            }
            else {
            	throw new JaExisteException(autor);
            }
        }
    
    
    public Autor bucarPorNome(String nome) throws NaoExisteException {
    	
        List<Autor> resultado = this.repositorioAutores.listarAutoresPorNome(nome);
        Autor saida;
        if(resultado.size() > 0){
            saida = (Autor)resultado.stream()
                    .filter(autor -> autor.getNome().equalsIgnoreCase(nome))
                    .limit(1)
                    .collect(Collectors.toList());
        }
        else{
            throw new NaoExisteException(nome);
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
