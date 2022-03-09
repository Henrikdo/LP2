package lab4;

import java.util.*;

public class Grupo {
	/**
	 * classe que faz o objeto Grupo
	 * @author Henrique Dias - 120210069
	 */
	private String nomeGrupo;
	private int tamanho;
	private HashMap<String,Aluno> alunosGrupo;
	private boolean existeTamanho = false;
	
	/**
	 * construtor dos valores de nome do grupo ,tamanho do grupo e do arraylist
	 * alunosGrupo do objeto Grupo.
	 * 
	 * @param nomegrupo nome do grupo
	 * @param tamanho tamanho do grupo.
	 */
	public Grupo(String nomegrupo, int tamanho) {
		if(nomegrupo.equals(null)) {
			throw new NullPointerException("Nome nulo");
		}
		nomegrupo = nomegrupo.trim();
		this.nomeGrupo = nomegrupo;
		this.tamanho = tamanho;
		if(tamanho > 0) {
			this.existeTamanho = true;
		}
		this.alunosGrupo = new HashMap<>();
	}
	
	/**
	 * adiciona um aluno ao ArrayList AlunosGrupo
	 * se o grupo não estiver cheio ou não possuir limite.
	 * @param matricula matricula do aluno.
	 * @param aluno aluno em questão.
	 * @return uma string contendo informações do cadastro.
	 */
	public String adicionaAluno(String matricula, Aluno aluno) {
		if(existeTamanho && tamanho != alunosGrupo.size()) {	
			this.alunosGrupo.put(matricula, aluno);
			return "ALUNO ALOCADO";
		}
		else if(existeTamanho && tamanho == alunosGrupo.size()) {
			return "GRUPO CHEIO";
		}
		if(!existeTamanho) {
			this.alunosGrupo.put(matricula ,aluno);	
			return "ALUNO ALOCADO";
		}	
		return "ALUNO ALOCADO";
	}
	/**
	 * verifica se o aluno ja pertence ao ArrayList.
	 * @param matricula matricula do aluno.
	 * @return true se pertencer ou false se não pertencer.
	 */
	public boolean verificaAluno(String matricula) {
		if(alunosGrupo.containsKey(matricula)) {
			return true;
		}
		return false;
	}
	/**
	 * pega o nome do grupo e retorna como String.
	 * @return string contendo o nome do grupo.
	 */
	public String getNome() {
		return this.nomeGrupo;
	}
	/**
	 * pega as chaves do hashmap e tranforma em um arraylist ,
	 * depois retorna esse Arraylist.
	 * @return Arraylist contendo as chaves do hashmap.
	 */
	public ArrayList<String> getKeys(){
		ArrayList<String> lista = new ArrayList<String>(this.alunosGrupo.keySet());
		return lista;
	}
	/**
	 * pega um aluno do grupo e fornece uma string contendo suas informações
	 * baseado na sua matricula.
	 * @param matricula matricula do aluno.
	 * @return string com suas informações.
	 */
	public String getAluno(String matricula) {
		return this.alunosGrupo.get(matricula).toString();
	}
	
	/**
	 * retorna uma string contendo o nome do Grupo.
	 */
	@Override
	public String toString() {
		return this.nomeGrupo;
	}
	/**
	 * retorna um hashcode do nome do grupo.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeGrupo == null) ? 0 : nomeGrupo.hashCode());
		return result;
	}
	/**
	 * retorna true
	 * se um objeto for igual ao outro ou 
	 * false se não for.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		if (nomeGrupo == null) {
			if (other.nomeGrupo != null)
				return false;
		} else if (!nomeGrupo.equals(other.nomeGrupo))
			return false;
		return true;
	}
	
}
