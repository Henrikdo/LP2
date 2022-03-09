package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import BibliTex.CaMeLcAsEfY;

class CamelCaseFy_teste {
	private CaMeLcAsEfY ccf;
	
	@BeforeEach
	 void iniciacamelCaseFy() {
		ccf = new CaMeLcAsEfY();
	}
	
	@Test
	void transforma_teste() {
		assertEquals((ccf.transforma("oi, como vc vai?")),"Oi, CoMo vC VaI?");
	}
	@Test
	void transforma_nulo() {
		try{
			ccf.transforma(null);
			fail("Era esperado uma exceção");
		}catch (NullPointerException nulo) {
			//Tentativa de transformar parametro nulo.
		}
	}
}
