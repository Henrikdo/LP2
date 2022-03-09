package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import BibliTex.lowerCase;

class lowerCase_teste {

	private lowerCase lc;
	
	@BeforeEach
	 void inicialowerCase() {
		lc = new lowerCase();
	}
	
	@Test
	void transforma_teste() {
		assertEquals((lc.transforma("OI, COMO VC VAI?")),"oi, como vc vai?");
	}
	@Test
	void transforma_nulo() {
		try{
			lc.transforma(null);
			fail("Era esperado uma exceção");
		}catch (NullPointerException nulo) {
			//Tentativa de transformar parametro nulo.
		}
	}

}
