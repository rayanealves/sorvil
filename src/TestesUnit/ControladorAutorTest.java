package testesunit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import projeto_sorvil.controller.ControladorAutor;
import projeto_sorvil.model.Autor;

class ControladorAutorTest {

	

	@Test
	void testNovoAutor() {
		ControladorAutor contAut = new ControladorAutor();
		Autor autor1 = new Autor("Ariano", "Suassuna", "01");
		boolean adicionado = contAut.novoAutor(autor1);
		assertTrue(adicionado);
		boolean naoAdicionado = contAut.novoAutor(autor1);
		assertFalse(naoAdicionado);
	}

	@Test
	void testBuscarPorNome() {
		ControladorAutor contAut = new ControladorAutor();
		Autor autor2 = new Autor("Mario", "de Andrade", "02");
		contAut.novoAutor(autor2);
		Autor encontrado = contAut.buscarPorNome("Mario");
		assertEquals(autor2, encontrado);
	}
	
	@Test
	void testDelete() {
		ControladorAutor contAut = new ControladorAutor();
		Autor autor2 = new Autor("Mario", "de Andrade", "02");
		Autor autor3 = new Autor("Monteiro", "Lobato", "03");
		Autor autor4 = new Autor("Felipe", "Neto", "04");
		Autor autor1 = new Autor("Ariano", "Suassuna", "01");
		contAut.novoAutor(autor2);
		contAut.novoAutor(autor3);
		contAut.novoAutor(autor4);
		contAut.novoAutor(autor1);
		boolean deletado = contAut.delete(autor2, 0);
		assertTrue(deletado);
		boolean n_del = contAut.delete(autor2, 0);
		assertFalse(n_del);
		
	}

}
