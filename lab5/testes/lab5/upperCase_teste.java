package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import BibliTex.upperCase;

class upperCase_teste {

private upperCase uc;
	
	@BeforeEach
	 void iniciaupperCase() {
		uc = new upperCase();
	}
	
	@Test
	void transforma_teste() {
		assertEquals((uc.transforma("oi, como vc vai?")),"OI, COMO VC VAI?");
	}
	@Test
	void transforma_nulo() {
		try{
			uc.transforma(null);
			fail("Era esperado uma exceção");
		}catch (NullPointerException nulo) {
			//Tentativa de transformar parametro nulo.
		}
	}
}
