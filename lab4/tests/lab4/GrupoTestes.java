package lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GrupoTestes {
	/**
	 * testa a classe Grupo.
	 * 
	 * @author Henrique Dias - 120210069
	 */
	
	/**
	 * testa o construtor.
	 */
	@Test
	void GrupoTest() {
		new Grupo("Passione", 0);
	}
	/**
	 * 
	 * testa o construtor com o parametro nome nulo.
	 */
	@Test
	void GrupoTest_Nulo() {
		try{
			new Grupo(null,0);
			fail("Era esperado uma exceção");
		} catch (NullPointerException vazio) {
			// tentativa de nome nulo
		}
	}

}
