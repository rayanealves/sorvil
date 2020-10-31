package projeto_sorvil.dados;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import projeto_sorvil.model.MeuLivro;
import projeto_sorvil.model.Usuario;

public class UsuarioRepositorio implements IrepositorioUsuario, Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5084589120456372224L;
	private ArrayList<Usuario> usuarios = new ArrayList<>();
	private static UsuarioRepositorio instancia;
        private static final String ROTA = "src/usuarios.dat";
	
	
	public UsuarioRepositorio(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
		
	public static UsuarioRepositorio getInstancia() {
        if (instancia == null) {
            instancia = (UsuarioRepositorio) DAO.lerDoArquivo(ROTA);
            if(instancia == null){
                ArrayList<Usuario> novoArq = new ArrayList<>();
                instancia = new UsuarioRepositorio(novoArq);
            }
        }
        return instancia;
    }
	
        @Override
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

        @Override
	public boolean adicionar(Usuario user) {
		boolean retorno = usuarios.add(user);
                DAO.salvarArquivo(instancia, ROTA);
		return retorno;
		
	}

        @Override
	public boolean remover(Usuario user) {
			
		boolean retorno = usuarios.remove(user);
                DAO.salvarArquivo(instancia, ROTA);
                return retorno;
                        
	}
	
        @Override
	public void editarNome(Usuario user, String nome) {
		 user.setNome(nome);
		 DAO.salvarArquivo(instancia, ROTA);
	}
	
        @Override
	public void editarLogin(Usuario user, String login) {
		 user.setLogin(login);
		 DAO.salvarArquivo(instancia, ROTA);
	}
	
        @Override
	public void editarSenha(Usuario user, String senha) {
		 user.setSenha(senha);
		 DAO.salvarArquivo(instancia, ROTA);
	}
	
        @Override
	public Usuario buscar(String login) {
		
		for(int i=0; i < usuarios.size() ; i++) { 
			if(usuarios.get(i).getLogin().equals(login)) {
				return usuarios.get(i);
			}

		}		
		return null;	
	}
	
        @Override
	public Usuario buscarPeloNome(String nome) {
		
		for(int i=0; i < usuarios.size() ; i++) { 
			if(usuarios.get(i).getNome().compareToIgnoreCase(nome) < 2) {
				return usuarios.get(i);
			}

		}		
		return null;	
		
	}
	
        @Override
	public List<Usuario> listar() {
		return usuarios.subList(0, usuarios.size());
	}
	

        @Override
	public ArrayList<MeuLivro> listarLivros(Usuario user) {
		return usuarios.get(usuarios.indexOf(user)).getEstante();
	}
	
	
        @Override
	public boolean cpfExiste(String cpf){            
           boolean existe = false;
           
           for(Usuario usuario: usuarios ){
               if(usuario.getCPF().equals(cpf)){
                   existe = true;
               }
           }
           return existe;
    }
	
        @Override
    	public boolean adicionarLivro(Usuario user, MeuLivro livroUser) {
    		int index = usuarios.indexOf(user);
    		user.adicionarLivro(livroUser);
    		if(index > -1){
                usuarios.add(index, user);
       		 	DAO.salvarArquivo(instancia, ROTA);
                return true;
            }
    		
    		return false;	
    	}
	
	
        @Override
    	public boolean removerLivro(Usuario user, MeuLivro livroUser) {
    		int index = usuarios.indexOf(user);
    		user.removerLivro(livroUser);
    		if(index > -1){
                usuarios.add(index, user);
       		 	DAO.salvarArquivo(instancia, ROTA);
                return true;
            }
    		
    		return false;	
    	}
	
	
	
}
