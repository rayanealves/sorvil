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
        if (autor != null){
            autor.setId(this.novoID());
            if(!this.repositorioAutores.listar().contains(autor)){
                return this.repositorioAutores.adicionar(autor);
            }
            else {
            	throw new JaExisteException(autor);
            }
        }
        return false;
    }
    
    public Autor bucarPorNome(String nome) {
    	String[] nomeCompleto = this.separarNome(nome);
    	ArrayList<Autor> autoresPorNome = (ArrayList<Autor>) this.buscarPrimeiroNome(nomeCompleto[0]);
    	if(autoresPorNome.size() < 2 && this.juntarSobrenome(nomeCompleto) == "") {
    		return autoresPorNome.get(0);
    	}
    	Autor correto = this.buscarSobrenome(autoresPorNome, this.juntarSobrenome(nomeCompleto));
    	return correto;
    	
    }
    
    public List<Autor> buscarPrimeiroNome(String nome){
        return this.repositorioAutores.listarPrimeiroNome(nome);
    }
    
    public Autor buscarSobrenome(List<Autor> autoresPorNome, String sobrenome){
    
    	return (Autor) autoresPorNome.stream()
    			.filter(autor-> autor.getSobrenome().compareToIgnoreCase(sobrenome) < 2)
    			.collect(Collectors.toList());
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
