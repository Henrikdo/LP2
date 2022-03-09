package lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControleTestes {
	/**
	 * Testes para a classe de controle de alunos.
	 * 
	 * @author Henrique Dias - 120210069
	 */
	private ControleAlunos controleteste;
	
	/**
	 * testa os construtores dos mapas e cadastra alunos no sistema antes de cada teste.
	 */
	@BeforeEach
	 void iniciacontrole() {
		controleteste = new ControleAlunos();
		controleteste.cadastraAluno("250", "Gabriel Reyes", "Computação");
		controleteste.cadastraAluno("202", "Angela Ziegler", "Medicina");
		controleteste.cadastraAluno("200", "Lili Camposh", "Computação");
		controleteste.cadastraAluno("201", "Torbjorn Lindholm", "Engenharia Mecanica");
	}
	
	/**
	 * 
	 * Testa o caso do metodo cadastraAluno da matricula do aluno ser a mesma de um aluno ja cadastrado.
	 */
	@Test
	 void cadastraAluno_MatriculaRepetida() {
		assertEquals(controleteste.cadastraAluno("250", "Kled", "Fidado"),"MATRÍCULA JÁ CADASTRADA!");
		assertEquals(controleteste.consultaMatricula("220"),false);
	}
	/**
	 * Testa o cadastro de um aluno do metodo cadastraAluno.
	 * 
	 */
	@Test
	 void cadastraAluno() {
		assertEquals(controleteste.cadastraAluno("220", "Kled", "Fidado"),"CADASTRO REALIZADO!");
		assertEquals(controleteste.consultaMatricula("220"),true);
	}
	
	/**
	 * Testa o metodo exibeAluno com uma matricula ja cadastrada.
	 */
	@Test
	 void exibeAluno() {
		assertEquals(controleteste.exibeAluno("250"),"Aluno: 250 - Gabriel Reyes - Computação");
	}
	/**
	 * Testa o metodo exibeAluno com um parametro nulo.
	 * espera-se uma exceção.
	 */
	 void exibeAluno_null() {
		try{
			controleteste.exibeAluno(null);
			fail("Era esperada uma exceção");
		}catch (IllegalArgumentException vazio){
			//matricula vazia detectada.
		}
			
	}
	/**
	 * Testa o metodo exibeAluno se a matricula não existir.
	 */
	@Test
	 void exibeAluno_Inexistente() {
		assertEquals(controleteste.exibeAluno("25"),"Aluno não cadastrado");
	}
	/**
	 * Testa o metodo getAluno com uma matricula ja cadastrada.
	 * O metodo só funciona se o aluno existir , ja que é usado apenas por exibeAluno().
	 */
	@Test
	 void getAluno() {
		assertEquals(controleteste.exibeAluno("250"),"Aluno: 250 - Gabriel Reyes - Computação");
	}
	
	/**
	 * testa o metodo consultaMatricula.
	 */
	@Test
	 void consultaMatricula() {
		assertEquals(controleteste.consultaMatricula("250"),true);
		assertEquals(controleteste.consultaMatricula("25"),false);
	}
	/**
	 * os testes a seguir testam o metodo cadastraGrupo() junto com o verificaGrupo() para ver se o mesmo 
	 * esta cadastrando o grupo corretamente com, sem restrição e quando o grupo ja existir.
	 */
	@Test
	 void cadastraGrupo() {
		assertEquals(controleteste.cadastraGrupo("Programação OO",0),"CADASTRO REALIZADO!");
		assertEquals(controleteste.verificaGrupo("Programação OO"),true);
	}
	@Test
	 void cadastraGrupo_Restricao() {
		assertEquals(controleteste.cadastraGrupo("Listas",2),"CADASTRO REALIZADO!");
		assertEquals(controleteste.verificaGrupo("Listas"),true);
	}
	@Test
	 void cadastraGrupo_Repetido() {
		assertEquals(controleteste.cadastraGrupo("Listas",2),"CADASTRO REALIZADO!");
		assertEquals(controleteste.cadastraGrupo("Listas",2),"GRUPO JÁ CADASTRADO!");
		assertEquals(controleteste.verificaGrupo("Listas"),true);
	}
	@Test
	 void cadastraGrupo_Restricao_Repetido() {
		assertEquals(controleteste.cadastraGrupo("Listas",2),"CADASTRO REALIZADO!");
		assertEquals(controleteste.cadastraGrupo("Listas",0),"GRUPO JÁ CADASTRADO!");
		assertEquals(controleteste.verificaGrupo("Listas"),true);
	}
	
	/**
	 * O teste a seguir testa o metodo alocaAluno() , criando um grupo e alocando alunos a ele ,
	 * enquanto verifica se o grupo existe e se os alunos pertencem a esse grupo.
	 */
	@Test
	void alocaAluno() {
		assertEquals(controleteste.cadastraGrupo("Programação OO",0),"CADASTRO REALIZADO!");
		assertEquals(controleteste.alocaAluno("200","Programação OO"),"ALUNO ALOCADO");
		assertEquals(controleteste.alocaAluno("202","Programação OO"),"ALUNO ALOCADO");
		assertEquals(controleteste.alocaAluno("202", "Programação OO"),"Aluno já alocado no grupo");
		assertEquals(controleteste.verificaGrupo("Programação OO"),true);
		assertEquals(controleteste.verificaPertinencia("Programação OO", "200"),true);
		assertEquals(controleteste.verificaPertinencia("Programação OO", "202"),true);
	}
	/**
	 * testa o metodo alocaAluno quando o aluno não existe , é esperado um aviso e que o aluno 
	 * não seja alocado.
	 */
	@Test
	void alocaAluno_AlunoInexistente() {
		assertEquals(controleteste.cadastraGrupo("Programação OO",0),"CADASTRO REALIZADO!");
		assertEquals(controleteste.alocaAluno("100","Programação OO"),"Aluno não cadastrado");
		assertEquals(controleteste.verificaPertinencia("Programação OO", "100"),false);
	}
	/**
	 * testa o metodo alocaAluno num grupo restrito com tamanho limite de 1 , 
	 * apos primeiro aluno ser cadastrado o proximo
	 * não deve ser cadastrado e deve aparecer um aviso.
	 */
	@Test
	void alocaAluno_gruporestrito() {
		assertEquals(controleteste.cadastraGrupo("Listas",1),"CADASTRO REALIZADO!");
		assertEquals(controleteste.alocaAluno("250","Listas"),"ALUNO ALOCADO");
		assertEquals(controleteste.alocaAluno("202","Listas"),"GRUPO CHEIO");
		assertEquals(controleteste.verificaPertinencia("Listas", "250"),true);
		assertEquals(controleteste.verificaPertinencia("Listas", "202"),false);
		
	}
	/**
	 * testa o metodo alocaAluno quando o grupo não existe, espera-se um
	 * aviso dizendo que o grupo não foi cadastrado.
	 */
	@Test
	void alocaAluno_grupoinexistente() {
		assertEquals(controleteste.alocaAluno("250","Listas"),"Grupo não cadastrado");
	}
	/**
	 * testa o metodo verificaPertinencia , cadastrando um grupo e verificando
	 * se o aluno pertence ao grupo, espera-se true se pertencer ou false se não pertencer.
	 */
	@Test
	 void verificaPertinencia() {
		controleteste.cadastraGrupo("Listas",0);
		controleteste.alocaAluno("250","Listas");
		assertEquals(controleteste.verificaPertinencia("Listas","250"),true);
		assertEquals(controleteste.verificaPertinencia("Listas","202"),false);
	}
	/**
	 * testa a pertinencia a um grupo inexistente , se o grupo não existir retorna false.
	 */
	@Test
	 void verificaPertinencia_grupoinexistente() {
		assertEquals(controleteste.verificaPertinencia("Listas","200"),false);

	}
	/**
	 * testa a pertinencia de um aluno inexistente a um grupo existente, se essas
	 * condições forem atendidas deve retornar false.
	 */
	@Test
	 void verificaPertinencia_alunoinexistente() {
		controleteste.cadastraGrupo("Listas",0);
		assertEquals(controleteste.verificaPertinencia("Listas","100"),false);

	}
	/**
	 * testa o metodo com o parametro grupo nulo, expera-se uma exceção.
	 */
	@Test
	 void verificaPertinencia_gruponulo() {
		try{
			controleteste.verificaPertinencia(null,"250");
			fail("Era esperada uma exceção");
		}catch (NullPointerException vazio){
			//matricula vazia detectada.
		}

	}
	/**
	 * testa o metodo com o parametro aluno nulo, expera-se uma exceção.
	 */
	@Test
	 void verificaPertinencia_alunonulo() {
		controleteste.cadastraGrupo("Listas",0);
		try{
			controleteste.verificaPertinencia("Listas",null);
			fail("Era esperada uma exceção");
		}catch (NullPointerException vazio){
			//matricula vazia detectada.
		}

	}
	/**
	 * testa o metodo checarGrupo quando o aluno tem grupo.
	 */
	@Test
	 void checarGrupo_alunosemgrupo() {
		controleteste.cadastraGrupo("Listas",0);
		assertEquals(controleteste.checarGrupos("202"),"Aluno não pertence a nenhum grupo");
	}
	/**
	 * testa o metodo checarGrupo quando o não aluno tem grupo.
	 */
	@Test
	 void checarGrupo_alunocomgrupo() {
		controleteste.cadastraGrupo("Listas",0);
		controleteste.cadastraGrupo("Programação OO",0);
		controleteste.alocaAluno("250","Listas");
		controleteste.alocaAluno("250","Programação OO");
		assertEquals(controleteste.checarGrupos("250"),"Grupos:\n1 - programação oo\n2 - listas\n");
	}
	/**
	 * testa o metodo checarGrupo quando não existe nenhum grupo.
	 */
	@Test
	 void checarGrupo_semgrupo() {
		assertEquals(controleteste.checarGrupos("202"),"Não existe nenhum grupo");
	}
	/**
	 * testa o metodo checarGrupo quando o parametro matricula é nulo.
	 */
	@Test
	 void checarGrupo_matriculanula() {

		try{
			controleteste.checarGrupos(null);
			fail("Era esperada uma exceção");
		}catch (NullPointerException vazio){
			//matricula vazia detectada.
		}
	}
	/**
	 * testa o metodo registraAluno , onde é passado uma matricula
	 * e o aluno é registrado no grupo dos que responderam.
	 */
	@Test
	 void registraAluno() {
		assertEquals(controleteste.registraAluno("250"),"ALUNO REGISTRADO!");
	}
	/**
	 * testa o metodo quando é tentado registrar um aluno que não existe.
	 */
	@Test
	 void registraAluno_alunoinexistente() {
		assertEquals(controleteste.registraAluno("100"),"Aluno não cadastrado");
	}
	/**
	 * testa o metodo quando o parametro matricula é passado como nulo.
	 */
	@Test
	 void registraAluno_null() {
		try{
			controleteste.registraAluno(null);
			fail("Era esperada uma exceção");
		}catch (NullPointerException vazio){
			//matricula vazia detectada.
		}
	}
	/**
	 * testa o metodo imprimeAlunos verificando se o mesmo
	 * imprime os alunos que estão registrados no arraylist alunosRespond.
	 * 
	 */
	@Test
	 void imprimeAlunos() {
		controleteste.registraAluno("250");
		controleteste.registraAluno("202");
		assertEquals(controleteste.imprimeAlunos(),"1. 250 - Gabriel Reyes - Computação\n2. 202 - Angela Ziegler - Medicina\n");
		
	}
	/**
	 * testa o metodo quando nenhum aluno foi registrado.
	 */
	@Test
	 void imprimeAlunos_vazio() {
		assertEquals(controleteste.imprimeAlunos(),"Nenhum aluno registrado");
	}
	
		
}
