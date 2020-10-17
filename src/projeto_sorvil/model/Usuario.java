package projeto_sorvil.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Usuario implements Serializable{
	private String nome;
	private String id;
	private String login;
	private String senha;
	private boolean admin;
	private LocalDate dataCadastro;
	private ArrayList <MeuLivro> estante;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		
		return result;
	}

	

	public Usuario(String nome, String id, String login, String senha, boolean admin, LocalDate dataCadastro) {
		this.nome = nome;
                this.id = id;
		this.login = login;
		this.senha = senha;
		this.admin = admin;
		this.dataCadastro = dataCadastro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public ArrayList<MeuLivro> getEstante() {
		return estante;
	}

	public void setEstante(ArrayList<MeuLivro> estante) {
		this.estante = estante;
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean equals(Usuario usuario) {
		return usuario != null && usuario.getLogin().equals(this.login)
                        && usuario.getDataCadastro().equals(this.dataCadastro)
                        && usuario.getNome().equals(this.nome);
	}
        
	
	public MeuLivro buscarLivro(String nome) {
		for(int i=0; i < estante.size() ; i++) { 
			if(estante.get(i).getNome().equals(nome)) {
				return estante.get(i);
			}

		}		
		return null;	
	}
	
	public void adicionarLivro(MeuLivro livroUser) {
		
		estante.add(livroUser);		
		
	}
	

	public void removerLivro(MeuLivro livroUser) {
		
		estante.remove(livroUser);		
		
	}
	

	
	
}
