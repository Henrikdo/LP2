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
		controleteste.cadastraAluno("250", "Gabriel Reyes", "Computa��o");
		controleteste.cadastraAluno("202", "Angela Ziegler", "Medicina");
		controleteste.cadastraAluno("200", "Lili Camposh", "Computa��o");
		controleteste.cadastraAluno("201", "Torbjorn Lindholm", "Engenharia Mecanica");
	}
	
	/**
	 * 
	 * Testa o caso do metodo cadastraAluno da matricula do aluno ser a mesma de um aluno ja cadastrado.
	 */
	@Test
	 void cadastraAluno_MatriculaRepetida() {
		assertEquals(controleteste.cadastraAluno("250", "Kled", "Fidado"),"MATR�CULA J� CADASTRADA!");
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
		assertEquals(controleteste.exibeAluno("250"),"Aluno: 250 - Gabriel Reyes - Computa��o");
	}
	/**
	 * Testa o metodo exibeAluno com um parametro nulo.
	 * espera-se uma exce��o.
	 */
	 void exibeAluno_null() {
		try{
			controleteste.exibeAluno(null);
			fail("Era esperada uma exce��o");
		}catch (IllegalArgumentException vazio){
			//matricula vazia detectada.
		}
			
	}
	/**
	 * Testa o metodo exibeAluno se a matricula n�o existir.
	 */
	@Test
	 void exibeAluno_Inexistente() {
		assertEquals(controleteste.exibeAluno("25"),"Aluno n�o cadastrado");
	}
	/**
	 * Testa o metodo getAluno com uma matricula ja cadastrada.
	 * O metodo s� funciona se o aluno existir , ja que � usado apenas por exibeAluno().
	 */
	@Test
	 void getAluno() {
		assertEquals(controleteste.exibeAluno("250"),"Aluno: 250 - Gabriel Reyes - Computa��o");
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
	 * esta cadastrando o grupo corretamente com, sem restri��o e quando o grupo ja existir.
	 */
	@Test
	 void cadastraGrupo() {
		assertEquals(controleteste.cadastraGrupo("Programa��o OO",0),"CADASTRO REALIZADO!");
		assertEquals(controleteste.verificaGrupo("Programa��o OO"),true);
	}
	@Test
	 void cadastraGrupo_Restricao() {
		assertEquals(controleteste.cadastraGrupo("Listas",2),"CADASTRO REALIZADO!");
		assertEquals(controleteste.verificaGrupo("Listas"),true);
	}
	@Test
	 void cadastraGrupo_Repetido() {
		assertEquals(controleteste.cadastraGrupo("Listas",2),"CADASTRO REALIZADO!");
		assertEquals(controleteste.cadastraGrupo("Listas",2),"GRUPO J� CADASTRADO!");
		assertEquals(controleteste.verificaGrupo("Listas"),true);
	}
	@Test
	 void cadastraGrupo_Restricao_Repetido() {
		assertEquals(controleteste.cadastraGrupo("Listas",2),"CADASTRO REALIZADO!");
		assertEquals(controleteste.cadastraGrupo("Listas",0),"GRUPO J� CADASTRADO!");
		assertEquals(controleteste.verificaGrupo("Listas"),true);
	}
	
	/**
	 * O teste a seguir testa o metodo alocaAluno() , criando um grupo e alocando alunos a ele ,
	 * enquanto verifica se o grupo existe e se os alunos pertencem a esse grupo.
	 */
	@Test
	void alocaAluno() {
		assertEquals(controleteste.cadastraGrupo("Programa��o OO",0),"CADASTRO REALIZADO!");
		assertEquals(controleteste.alocaAluno("200","Programa��o OO"),"ALUNO ALOCADO");
		assertEquals(controleteste.alocaAluno("202","Programa��o OO"),"ALUNO ALOCADO");
		assertEquals(controleteste.alocaAluno("202", "Programa��o OO"),"Aluno j� alocado no grupo");
		assertEquals(controleteste.verificaGrupo("Programa��o OO"),true);
		assertEquals(controleteste.verificaPertinencia("Programa��o OO", "200"),true);
		assertEquals(controleteste.verificaPertinencia("Programa��o OO", "202"),true);
	}
	/**
	 * testa o metodo alocaAluno quando o aluno n�o existe , � esperado um aviso e que o aluno 
	 * n�o seja alocado.
	 */
	@Test
	void alocaAluno_AlunoInexistente() {
		assertEquals(controleteste.cadastraGrupo("Programa��o OO",0),"CADASTRO REALIZADO!");
		assertEquals(controleteste.alocaAluno("100","Programa��o OO"),"Aluno n�o cadastrado");
		assertEquals(controleteste.verificaPertinencia("Programa��o OO", "100"),false);
	}
	/**
	 * testa o metodo alocaAluno num grupo restrito com tamanho limite de 1 , 
	 * apos primeiro aluno ser cadastrado o proximo
	 * n�o deve ser cadastrado e deve aparecer um aviso.
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
	 * testa o metodo alocaAluno quando o grupo n�o existe, espera-se um
	 * aviso dizendo que o grupo n�o foi cadastrado.
	 */
	@Test
	void alocaAluno_grupoinexistente() {
		assertEquals(controleteste.alocaAluno("250","Listas"),"Grupo n�o cadastrado");
	}
	/**
	 * testa o metodo verificaPertinencia , cadastrando um grupo e verificando
	 * se o aluno pertence ao grupo, espera-se true se pertencer ou false se n�o pertencer.
	 */
	@Test
	 void verificaPertinencia() {
		controleteste.cadastraGrupo("Listas",0);
		controleteste.alocaAluno("250","Listas");
		assertEquals(controleteste.verificaPertinencia("Listas","250"),true);
		assertEquals(controleteste.verificaPertinencia("Listas","202"),false);
	}
	/**
	 * testa a pertinencia a um grupo inexistente , se o grupo n�o existir retorna false.
	 */
	@Test
	 void verificaPertinencia_grupoinexistente() {
		assertEquals(controleteste.verificaPertinencia("Listas","200"),false);

	}
	/**
	 * testa a pertinencia de um aluno inexistente a um grupo existente, se essas
	 * condi��es forem atendidas deve retornar false.
	 */
	@Test
	 void verificaPertinencia_alunoinexistente() {
		controleteste.cadastraGrupo("Listas",0);
		assertEquals(controleteste.verificaPertinencia("Listas","100"),false);

	}
	/**
	 * testa o metodo com o parametro grupo nulo, expera-se uma exce��o.
	 */
	@Test
	 void verificaPertinencia_gruponulo() {
		try{
			controleteste.verificaPertinencia(null,"250");
			fail("Era esperada uma exce��o");
		}catch (NullPointerException vazio){
			//matricula vazia detectada.
		}

	}
	/**
	 * testa o metodo com o parametro aluno nulo, expera-se uma exce��o.
	 */
	@Test
	 void verificaPertinencia_alunonulo() {
		controleteste.cadastraGrupo("Listas",0);
		try{
			controleteste.verificaPertinencia("Listas",null);
			fail("Era esperada uma exce��o");
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
		assertEquals(controleteste.checarGrupos("202"),"Aluno n�o pertence a nenhum grupo");
	}
	/**
	 * testa o metodo checarGrupo quando o n�o aluno tem grupo.
	 */
	@Test
	 void checarGrupo_alunocomgrupo() {
		controleteste.cadastraGrupo("Listas",0);
		controleteste.cadastraGrupo("Programa��o OO",0);
		controleteste.alocaAluno("250","Listas");
		controleteste.alocaAluno("250","Programa��o OO");
		assertEquals(controleteste.checarGrupos("250"),"Grupos:\n1 - programa��o oo\n2 - listas\n");
	}
	/**
	 * testa o metodo checarGrupo quando n�o existe nenhum grupo.
	 */
	@Test
	 void checarGrupo_semgrupo() {
		assertEquals(controleteste.checarGrupos("202"),"N�o existe nenhum grupo");
	}
	/**
	 * testa o metodo checarGrupo quando o parametro matricula � nulo.
	 */
	@Test
	 void checarGrupo_matriculanula() {

		try{
			controleteste.checarGrupos(null);
			fail("Era esperada uma exce��o");
		}catch (NullPointerException vazio){
			//matricula vazia detectada.
		}
	}
	/**
	 * testa o metodo registraAluno , onde � passado uma matricula
	 * e o aluno � registrado no grupo dos que responderam.
	 */
	@Test
	 void registraAluno() {
		assertEquals(controleteste.registraAluno("250"),"ALUNO REGISTRADO!");
	}
	/**
	 * testa o metodo quando � tentado registrar um aluno que n�o existe.
	 */
	@Test
	 void registraAluno_alunoinexistente() {
		assertEquals(controleteste.registraAluno("100"),"Aluno n�o cadastrado");
	}
	/**
	 * testa o metodo quando o parametro matricula � passado como nulo.
	 */
	@Test
	 void registraAluno_null() {
		try{
			controleteste.registraAluno(null);
			fail("Era esperada uma exce��o");
		}catch (NullPointerException vazio){
			//matricula vazia detectada.
		}
	}
	/**
	 * testa o metodo imprimeAlunos verificando se o mesmo
	 * imprime os alunos que est�o registrados no arraylist alunosRespond.
	 * 
	 */
	@Test
	 void imprimeAlunos() {
		controleteste.registraAluno("250");
		controleteste.registraAluno("202");
		assertEquals(controleteste.imprimeAlunos(),"1. 250 - Gabriel Reyes - Computa��o\n2. 202 - Angela Ziegler - Medicina\n");
		
	}
	/**
	 * testa o metodo quando nenhum aluno foi registrado.
	 */
	@Test
	 void imprimeAlunos_vazio() {
		assertEquals(controleteste.imprimeAlunos(),"Nenhum aluno registrado");
	}
	
		
}
