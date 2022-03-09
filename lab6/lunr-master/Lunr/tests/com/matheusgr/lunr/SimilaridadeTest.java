package com.matheusgr.lunr;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.matheusgr.similaridade.SimilaridadeService;

class SimilaridadeTest extends BaseTest {
	
	/**
	 * Testa a similaridade dos documentos.
	 */
	@Test
	void test() {
		assertEquals(similaridadeController.similaridade(JAVA_ID,HTML_ID),0);
	}

}
