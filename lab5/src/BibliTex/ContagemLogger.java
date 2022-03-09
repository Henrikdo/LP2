package BibliTex;

import java.util.*;

public class ContagemLogger implements Logador {
	/**
	 * Classe logger que quando for invocado irá imprimir uma string contendo cada operacao usada e a
	 * quantidade de vezes que foi usada.
	 */
	private HashSet<String> metodos;
	private ArrayList<String> metodos_invocados;
	
	/**
	 * constroi um hashset para armazenar os metodos que foram usados
	 * de forma a não repetir-los.
	 * 
	 * constroi um arraylist de forma a facilitar a contagem.
	 */
	public ContagemLogger() {
		this.metodos = new HashSet<>();
		this.metodos_invocados = new ArrayList<>();
	}

	/**
	 * irá adicionar o metodo usado no hashset e no arraylist.
	 */
	@Override
	public void log(String metodo, String operacao) {
		metodos_invocados.add(metodo);	
		metodos.add(metodo);
	}
	
	/**
	 * conta quantas vezes o metodo foi repetido na lista e faz uma string 
	 * contendo o metodo e a quantidade de  vezes que foi repetido
	 * @return retorna a string que foi feita com base nos metodos usados.
	 */
	public String contador() {
		String string = "";
		for(String m : metodos) {
			int contador = 0;
			for(int i = 0;i < metodos_invocados.size();i++) {
				if(metodos_invocados.get(i).equals(m)) {
					contador += 1;
				}
			}
			
			string += m + " " +"-"+ " " + contador+"\n";
		}
		return string.trim();
	}
	
	/**
	 * retorna a string gerada pelo metodo contador().
	 */
	@Override
	public String toString() {
		
		return contador();
	}
}
