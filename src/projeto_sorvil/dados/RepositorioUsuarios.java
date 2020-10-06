package projeto_sorvil.sistema.dados;

import java.util.ArrayList;

import projeto_sorvil.sistema.model.Usuario;

public class RepositorioUsuarios {
	

	private static ArrayList<Usuario> usuarios;
	
	
	public RepositorioUsuarios(ArrayList<Usuario> usuarios) {
		
		
	}
	
	
	public static void adicionarUsuario(Usuario user) {
		
		usuarios.add(user);
	}

	public static void removerUsuario(Usuario user) {
			
			usuarios.remove(user);
	}
	
	public static void editarUsuario(Usuario user, int atributo) {
		
		switch (atributo) {
		
			case 1: //nome
				
				
				break;
			
			case 2: //login
				
				
				break;
				
			case 3: //senha
				
				
				break;
			
			default:
				System.out.println();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
