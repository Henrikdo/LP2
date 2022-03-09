package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import BibliTex.ConverteInterrogacoesParaPontos;

class ConverteInterrogacoesParaPontos_teste {

private ConverteInterrogacoesParaPontos cipp;
	
	@BeforeEach
	 void iniciaconverteinterrogacoesparapontos() {
		cipp = new ConverteInterrogacoesParaPontos();
	}
	
	@Test
	void transforma_teste() {
		assertEquals((cipp.transforma("oi, como vc vai?")),"oi, como vc vai.");
	}
	@Test
	void transforma_nulo() {
		try{
			cipp.transforma(null);
			fail("Era esperado uma exceção");
		}catch (NullPointerException nulo) {
			//Tentativa de transformar parametro nulo.
		}
	}

}
