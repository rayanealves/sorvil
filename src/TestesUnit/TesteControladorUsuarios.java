
package TestesUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import projeto_sorvil.controller.ControladorUsuarios;
import projeto_sorvil.model.Usuario;

/**
 * @author BelialStroke
 *
 */
class TesteControladorUsuarios {



	
	@Test
	final void testAdicionar() {
		LocalDate horadecadastro = LocalDate.now();
		Usuario user1 = new Usuario("joao", "aleatorio1", "joaojogador", "frefireebomdemais", false, horadecadastro); 
		Usuario user2 = new Usuario("maria", "aleatorio2", "mariajogador", "frefireebomdemais", false, horadecadastro);
		
		assertTrue(ControladorUsuarios.getInstancia().adicionar(user1));
		assertTrue(ControladorUsuarios.getInstancia().adicionar(user2));
		
	}

	
	@Test
	final void testRemover() {
		LocalDate horadecadastro = LocalDate.now();
		Usuario user1 = new Usuario("joao", "aleatorio1", "joaojogador", "frefireebomdemais", false, horadecadastro); 
		Usuario user2 = new Usuario("maria", "aleatorio2", "mariajogador", "frefireebomdemais", false, horadecadastro);
		ControladorUsuarios.getInstancia().adicionar(user1);
		ControladorUsuarios.getInstancia().adicionar(user2);
		
		
		assertTrue(ControladorUsuarios.getInstancia().remover(user1));
		assertTrue(ControladorUsuarios.getInstancia().remover(user2));
	}

	
	@Test
	final void testEditarNome() {
		LocalDate horadecadastro = LocalDate.now();
		Usuario user1 = new Usuario("joao", "aleatorio1", "joaojogador", "frefireebomdemais", false, horadecadastro); 
		Usuario user2 = new Usuario("maria", "aleatorio2", "mariajogador", "frefireebomdemais", false, horadecadastro);
		ControladorUsuarios.getInstancia().adicionar(user1);
		ControladorUsuarios.getInstancia().adicionar(user2);
		
		assertTrue(ControladorUsuarios.getInstancia().remover(user1));
		assertTrue(ControladorUsuarios.getInstancia().remover(user2));
		
	}

	@Test
	final void testEditarLogin() {
		
	}

	
	@Test
	final void testEditarSenha() {
	
	}

	
	@Test
	final void testBuscar() {
		
	}

	
	@Test
	final void testListar() {
	
	}

	
	@Test
	final void testListarLivros() {
	
	}
	
}
