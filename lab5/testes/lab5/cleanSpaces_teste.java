package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import BibliTex.cleanSpaces;

class cleanSpaces_teste {

private cleanSpaces cs;
	
	@BeforeEach
	 void iniciacleanSpaces() {
		cs = new cleanSpaces();
	}
	
	@Test
	void transforma_teste() {
		assertEquals((cs.transforma("oi, como vc vai?")),"oi,comovcvai?");
	}
	@Test
	void transforma_nulo() {
		try{
			cs.transforma(null);
			fail("Era esperado uma exceção");
		}catch (NullPointerException nulo) {
			//Tentativa de transformar parametro nulo.
		}
	}

}
