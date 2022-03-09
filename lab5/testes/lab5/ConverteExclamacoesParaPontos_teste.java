package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import BibliTex.ConverteExclamacoesParaPontos;


class ConverteExclamacoesParaPontos_teste {

	private ConverteExclamacoesParaPontos cepp;
	
	@BeforeEach
	 void iniciaConverteExclamacoesParaPontos() {
		cepp = new ConverteExclamacoesParaPontos();
	}
	
	@Test
	void transforma_teste() {
		assertEquals((cepp.transforma("oi,como vc vai!")),"oi,como vc vai.");
	}
	@Test
	void transforma_nulo() {
		try{
			cepp.transforma(null);
			fail("Era esperado uma exceção");
		}catch (NullPointerException nulo) {
			//Tentativa de transformar parametro nulo.
		}
	}
}
