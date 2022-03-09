package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import BibliTex.clean;

class clean_teste {

private clean c;
	
	@BeforeEach
	 void iniciaclean() {
		c = new clean();
	}
	
	@Test
	void transforma_teste() {
		assertEquals((c.transforma("oi, como vc vai?")),"oi como vc vai");
		assertEquals((c.transforma("oi, còmo` ávc vai?")),"oi còmo ávc vai");
	}
	@Test
	void transforma_nulo() {
		try{
			c.transforma(null);
			fail("Era esperado uma exceção");
		}catch (NullPointerException nulo) {
			//Tentativa de transformar parametro nulo.
		}
	}

}
