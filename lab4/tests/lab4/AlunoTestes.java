package lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class AlunoTestes {
	/**
	 * Testes com a classe Aluno
	 * @author Henrique Dias - 120210069
	 */
	
	/**
	 * testa o construtor.
	 */
	@Test
	void test() {
		new Aluno("250", "Kledinho" , "Computa��o");
	}
	/**
	 * testa o construtor com a matricula nula
	 * 
	 */
	@Test
	void test_matriculanula() {
		try{
			new Aluno(null, "Kledinho" , "Computa��o");
			fail("Era esperado uma exce��o");
		}catch (NullPointerException nulo) {
			// tentativa de matricula nula
		}
		new Aluno("250", "Kledinho" , "Computa��o");
	}
	/**
	 * testa o construtor com o nome nulo
	 * 
	 */
	@Test
	void test_nomenulo() {
		try{
			new Aluno("250", null , "Computa��o");
			fail("Era esperado uma exce��o");
		}catch (NullPointerException nulo) {
			// tentativa de nome nulo.
		}
		new Aluno("250", "Kledinho" , "Computa��o");
	}
	/**
	 * testa o construtor com o curso nulo
	 * 
	 */
	@Test
	void test_cursonulo() {
		try{
			new Aluno("250", "Kledinho" , null);
			fail("Era esperado uma exce��o");
		}catch (NullPointerException nulo) {
			// tentativa de curso nulo
		}
		new Aluno("250", "Kledinho" , "Computa��o");
	}
	
	@Test
	void ToString() {
		Aluno aluno = new Aluno("250", "Kledinho" , "Computa��o");
		assertEquals(aluno.toString(),"250 - Kledinho - Computa��o");
	}

}
