package lab4;

import java.util.Scanner;


public class Menu {
	/**
	 * Classe menu.
	 * @author Henrique Dias - 120210069
	 * 
	 */
	

	public static void main(String[] args){
		ControleAlunos controle1 = new ControleAlunos();
		Scanner sc = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(sc);
			comando(escolha, controle1, sc);
		}
	}
	
	/**
	 * Exibe o menu de op��es , onde o scanner recebe a op��o e retorna em forma de uppercase,
	 * para evitar erros.
	 * @param scanner da entrada
	 * @return a op��o em uppercase.
	 */
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" + 
						"(C)adastrar Aluno\n" + 
						"(E)xibir Aluno\n" + 
						"(N)ovo Grupo\n" + 
						"(A)locar Aluno no Grupo ou (P)ertin�ncia a Grupos\n" + 
						"(R)egistrar Aluno que Respondeu\n" + 
						"(I)mprimir Alunos que Responderam\n" + 
						"(O)lha� quais Grupos o Aluno T�.\n" +
						"(S)im, quero Fechar o Programa!\n"+
						"\n" + 
						"Op��o> ");
		return scanner.next().toUpperCase();
	}
	/**
	 * 
	 * comandos para chamar os metodos , cada comando equivale a um metodo
	 * se o comando n�o existir sera avisado que a op��o � invalida.
	 * @param opcao escolhida/ metodo escolhido
	 * @param controle / classe ControleAlunos que fazer as opera��es.
	 * @param scanner da entrada.
	 */
	private static void comando(String opcao, ControleAlunos controle, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraAluno(controle,scanner);
			break;
		case "E":
			exibeAluno(controle,scanner);
			break;
		case "N":
			novoGrupo(controle, scanner);
			break;
		case "A":
			alocarAluno(controle,scanner);
			break;
		case "R":
			registrarAlunoRes(controle, scanner);
			break;
		case "I":
			imprimirAlunosRes(controle,scanner);
			break;
		case "P":
			verificarAlunogrupo(controle,scanner);
			break;
		case "O":
			checarGrupos(controle, scanner);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("Op��o inv�lida!");
		}
	}
	/**
	 * sai do sistema parando a execu��o.
	 */
	private static void sai() {
		System.out.println("Dojyaaaaan! o/");
		System.exit(0);
		
	}
	/**
	 * entrada , esta entrada sera usada por os metodos , retornando a entrada  e jogando
	 * uma exce��o se a entrada for nula.
	 * @param sc , scanner da entrada
	 * @return entrada em string.
	 */
	private static String Entrada(Scanner sc) {
		String entrada = sc.nextLine().trim();
		if(entrada == null||entrada.isBlank()) {
			throw new IllegalArgumentException("ENTRADA NULA OU VAZIA!");
		}
		return entrada;
	}
	/**
	 * 
	 * verifica a pertinencia do aluno no grupo desejado.
	 * @param controle classe controladora(sistema).
	 * @param scanner scanner da entrada.
	 */
	private static void verificarAlunogrupo(ControleAlunos controle, Scanner scanner) {
		System.out.print("Grupo: ");
		String grupo = scanner.nextLine()+Entrada(scanner);
		if(!controle.verificaGrupo(grupo)) {
			System.out.println("GRUPO N�O CADASTRADO!");
			return;
		}
		System.out.print("Matricula: ");
		String matricula = Entrada(scanner);
		String string = "ALUNO N�O PERTENCE AO GRUPO";
		if(controle.verificaPertinencia(grupo, matricula)) {
			string = "ALUNO PERTENCE AO GRUPO!";
		}
		
		System.out.println(string);
	}
	/**
	 * imprime os alunos que foram registrado como tendo
	 * respondido as perguntas
	 * @param controle classe controladora(sistema).
	 * @param scanner scanner da entrada.
	 */
	private static void imprimirAlunosRes(ControleAlunos controle,Scanner scanner) {
		System.out.println(controle.imprimeAlunos());
	}
	
	/**
	 * registra os alunos que responderam.
	 * 
	 * @param controle classe controladora(sistema).
	 * @param scanner scanner da entrada
	 */
	private static void registrarAlunoRes(ControleAlunos controle, Scanner scanner) {
		System.out.print("Matricula: ");
		String matricula = scanner.nextLine() + Entrada(scanner);
		System.out.println(controle.registraAluno(matricula));
		
	}
	/**
	 * aloca o aluno desejado no grupo desejado.
	 * @param controle classe controladora(sistema).
	 * @param scanner scanner da entrada.
	 */
	private static void alocarAluno(ControleAlunos controle, Scanner scanner) {
		System.out.print("Matricula: ");
		String matricula = scanner.nextLine() + Entrada(scanner);
		System.out.print("Grupo: ");
		String grupo = Entrada(scanner);
		System.out.println(controle.alocaAluno(matricula, grupo));
		
	}
	/**
	 * cria um grupo de estudos no sistema
	 * usando o nome do grupo e o tamanho,
	 * se o tamanho for menor que 0 � dado como invalido e
	 * o programa retorna ao menu.
	 * @param controle classe controladora(sistema).
	 * @param scanner scanner da entrada.
	 */
	private static void novoGrupo(ControleAlunos controle, Scanner scanner) {
		System.out.print("Grupo: ");
		String grupo = scanner.nextLine() + Entrada(scanner).toLowerCase();
		System.out.print("Tamanho: ");
		int tamanho = scanner.nextInt();
		if(tamanho < 0 ) {
			System.out.println("Tamanho inv�lido!");
			return;
		}
		System.out.println(controle.cadastraGrupo(grupo, tamanho));
		
	}
	/**
	 * imprime uma string contendo o aluno em quest�o e suas informa��es.
	 * @param controle classe controladora(sistema).
	 * @param scanner scanner da entrada.
	 */
	private static void exibeAluno(ControleAlunos controle,Scanner scanner) {
		System.out.print("\nMatricula: ");
		String matricula = scanner.nextLine() + Entrada(scanner);
		System.out.println(controle.exibeAluno(matricula));
		
	}
	/**
	 * cadastra o aluno desejado no sistema.
	 * @param controle classe controladora (sistema).
	 * @param scanner scanner da entrada.
	 */
	private static void cadastraAluno(ControleAlunos controle, Scanner scanner) {
		System.out.print("\nMatricula: ");
		String matricula = scanner.nextLine() + Entrada(scanner);
		System.out.print("\nNome: ");
		String nome = Entrada(scanner);
		System.out.print("\nCurso: ");
		String curso = Entrada(scanner);
		System.out.println(controle.cadastraAluno(matricula,nome,curso));
		
	}
	/**
	 * checa a quais grupos o aluno pertence no sistema.
	 * @param controle classe controladora(sistema).
	 * @param scanner scanner da entrada.
	 */ 
	private static void checarGrupos(ControleAlunos controle, Scanner scanner) {
		System.out.print("\nMatricula: ");
		String matricula = scanner.nextLine() + Entrada(scanner);
		System.out.println(controle.checarGrupos(matricula));
		
	}	

}
