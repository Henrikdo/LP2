package lab4;

import java.util.*;

public class ControleAlunos {
	/**
	 * classe controladora , sistema que vai armazenar os dados e fornecer informações.
	 * 
	 * @author Henrique Dias - 120210069.
	 */
	private HashMap<String, Aluno> Alunos;
	private HashMap<String, Grupo> grupos;
	private ArrayList<String> alunosRespond;
	
	
	/**
	 * construtor dos mapas e listas.
	 */
	public ControleAlunos() {
		this.Alunos = new HashMap<>();
		this.grupos = new HashMap<>();
		this.alunosRespond = new ArrayList<String>();
	}
	/**
	 * cria um objeto aluno e cadastra
	 *  no HashMap Alunos usando a matricula como chave.
	 * @param matricula matricula do aluno.
	 * @param nome nome do aluno.
	 * @param curso curso do aluno.
	 * @return "cadastro realizado" se o cadastro for realizado com sucesso ou
	 * "Matricula ja cadastrada" se o aluno ja estiver cadastrado no sistema.
	 */
	public String cadastraAluno(String matricula, String nome, String curso) {
		if(consultaMatricula(matricula) == false) {
			Aluno aluno = new Aluno(matricula , nome, curso);
			this.Alunos.put(matricula, aluno);
			return "CADASTRO REALIZADO!";
		}
		
		return "MATRÍCULA JÁ CADASTRADA!";
	}
	
	/**
	 * retorna uma string contendo informações sobre o aluno em questão.
	 * @param matricula
	 * @return
	 */
	public String exibeAluno(String matricula) {
		if(matricula.equals(null)||matricula.isBlank()) {
			throw new IllegalArgumentException("MATRICULA VAZIA OU NULA");
		}
		if(consultaMatricula(matricula)==true) {
			return "Aluno: " + getAluno(matricula);
		}
		return "Aluno não cadastrado";
	}
	
	/**
	 * pega o aluno pela chave(matricula) do mesmo armazenado
	 * em Alunos converte em string e retorna as informações.
	 * @param matricula matricula do aluno.
	 * @return string contendo as informações do aluno.
	 */
	public String getAluno(String matricula) {
		String string = this.Alunos.get(matricula).toString();
		return string;
	}
	/**
	 * consulta a matricula do aluno no hashmap para verificar
	 * se o mesmo se encontra cadastrado ou não.
	 * @param matricula matricula do aluno
	 * @return true se o aluno estiver cadastrado e false se não estiver cadastrado.
	 */
	public boolean consultaMatricula(String matricula) {
		return this.Alunos.containsKey(matricula);
	}
	/**
	 * Cria o objeto grupo e adiciona no HashMap Grupos.
	 * Se o grupo ja estiver cadastrado o cadastro não é realizado.
	 * O grupo pode ou não ter um limite de pessoas , se for fornecido
	 * tamanho 0 o grupo não tem limite , ja se for qualquer outro valor maior que 0 
	 * o grupo tem limite.
	 * @param nomeGrupo nome do grupo a ser cadastrado.
	 * @param tamanho 
	 * @return string contendo a informação se o grupo foi cadastrado com sucesso
	 * ou se o grupo ja existe no sistema.
	 */
	public String cadastraGrupo(String nomeGrupo, int tamanho) {
		String nome = nomeGrupo.toLowerCase();
		if(!verificaGrupo(nomeGrupo)) {
			Grupo grupo = new Grupo(nomeGrupo,tamanho);
			this.grupos.put(nome, grupo);
			return "CADASTRO REALIZADO!";
		}
		return "GRUPO JÁ CADASTRADO!";
	}
	/**
	 * verifica se o grupo ja existe no sistema.
	 * 
	 * @param nomeGrupo nome do grupo a ser verificado
	 * @return true se ja existir no sistema ou false se não existir no sistema.
	 */
	public boolean verificaGrupo(String nomeGrupo) {
		String nome = nomeGrupo.toLowerCase();
		return this.grupos.containsKey(nome);
	}
	/**
	 * adiciona um aluno existente no HashMap Alunos a um 
	 * grupo existente no HashMap grupos.
	 * @param matricula matricula do aluno em questão.
	 * @param grupo grupo a ser adicionado.
	 * @return uma string contendo informações sobre o cadastro.
	 */
	public String alocaAluno(String matricula, String grupo) {
		if(grupo.equals(null)) {
			throw new IllegalArgumentException("GRUPO NULO");
		}
		if(matricula.equals(null)) {
			throw new IllegalArgumentException("Matricula Nula");
		}
		String nomeGrupo = grupo.toLowerCase();
		if(this.Alunos.containsKey(matricula) == false) {
			return "Aluno não cadastrado";
		}
		if(this.grupos.containsKey(nomeGrupo) == false) {
			return "Grupo não cadastrado";
		}
		if(verificaPertinencia(grupo,matricula)) {
			return "Aluno já alocado no grupo";
		}
		Grupo grupo1 = this.grupos.get(nomeGrupo);
		return grupo1.adicionaAluno(matricula,this.Alunos.get(matricula));
		
	}
	
	/**
	 * Registra um aluno presente no HashMap Alunos no ArrayList alunosRespond.
	 * @param matricula matricula do aluno a ser adicionado.
	 * @return String contendo informações sobre o cadastro.
	 */
	public String registraAluno(String matricula) {
		if(matricula.equals(null)||matricula.isBlank()) {
			throw new IllegalArgumentException("MATRICULA VAZIA OU NULA");
		}
		if(consultaMatricula(matricula)) {
			alunosRespond.add(getAluno(matricula));
			return "ALUNO REGISTRADO!";
		}
		return "Aluno não cadastrado";
	}
	/**
	 * imprime uma string contendo todos os alunos armazenados
	 * no ArrayList alunosRespond.
	 * @return uma string contendo todos os alunos armazenados.
	 */
	public String imprimeAlunos() {
		if(alunosRespond.size() > 0 ) {
			String string = "";
			for(int i = 0 ; i < alunosRespond.size();i++) {
				int num = i+1;
				string += (num +". " + alunosRespond.get(i) + "\n");
				
			}
			return string;
		}
		return "Nenhum aluno registrado";
		
	}
	/**
	 * checa a quais grupos o aluno pertence.
	 * @param matricula matricula do aluno em questão.
	 * @return retorna uma string contendo os grupos que o aluno pertence.
	 */
	public String checarGrupos(String matricula){
		List<String> grupos = List.copyOf(this.grupos.keySet());
		String checagem = "Grupos:\n";
		if(matricula.equals(null)||matricula.isBlank()) {
			throw new IllegalArgumentException("MATRICULA VAZIA OU NULA");
		}
		if(this.grupos.size() > 0) {
			for(int i = 0 ; i < this.grupos.size(); i++) {
				String grupo = this.grupos.get(grupos.get(i)).toString().toLowerCase();
				ArrayList<String> alunos = this.grupos.get(grupo).getKeys();
				int num = i + 1;
				if(alunos.contains(matricula)) {
					checagem += (num + " - " + grupo + "\n");
				}
			}
			if(checagem.equals("Grupos:\n")) {
				return "Aluno não pertence a nenhum grupo";
			}
			return checagem;
		}
		
		return "Não existe nenhum grupo";
	}
	/**
	 * verifica a pertinencia do aluno ao respectivo grupo.
	 * @param grupo grupo a ser verificado.
	 * @param matricula
	 * @return false se o grupo não existir , true se o aluno existir no grupo , false
	 * se o aluno não existir no grupo.
	 */
	public boolean verificaPertinencia(String grupo, String matricula) {
		if(grupo.equals(null)||grupo.isBlank()) {
			throw new NullPointerException("NOME DO GRUPO VAZIO OU NULO");
		}
		if(matricula.equals(null)||matricula.isBlank()) {
			throw new NullPointerException("MATRICULA VAZIA OU NULA");
		}
		if(!verificaGrupo(grupo)) {
			return false;
		}
		String nomeGrupo = grupo.toLowerCase();
		return this.grupos.get(nomeGrupo).verificaAluno(matricula);
	}
	
}
