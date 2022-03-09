package lab4;

public class Aluno {
	/**
	 * @author Henrique Dias - 120210069
	 * classe que faz o objeto aluno
	 */
	private String matricula;
	private String nome;
	private String curso;
	
	/**
	 * construtor dos valores de matricula , nome e curso.
	 * 
	 * @param matricula matricula do aluno.
	 * @param nome nome do aluno.
	 * @param curso curso do aluno.
	 */
	public Aluno(String matricula, String nome, String curso){
		if(matricula.equals(null)|matricula.isBlank()) {
			throw new IllegalArgumentException("Matricula vazia ou nula");
		}
		this.matricula = matricula.trim();
		if(nome.equals(null)|nome.isBlank()) {
			throw new IllegalArgumentException("Matricula vazia ou nula");
		}
		this.nome = nome.trim();
		if(curso.equals(null)|curso.isBlank()) {
			throw new IllegalArgumentException("Matricula vazia ou nula");
		}
		this.curso = curso.trim();
	}
	
	/**
	 * retorna uma string contendo as informações do aluno.
	 */
	@Override
	public String toString() {
		String string = matricula +" - "+ nome + " - " + curso;
		return string;
	}
	
	/**retorna um hashcode da matricula.
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}
	/**
	 * retorna uma booleana se um objeto for igual a o outro
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
	
	
	
	
}
