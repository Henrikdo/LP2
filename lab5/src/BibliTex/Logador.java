package BibliTex;

public interface Logador {
	/**
	 * Interfacer das classes que vão ser os loggers.
	 * @author Henrique Dias - 120210069
	 * @param metodo
	 * @param operacao
	 */
	
	/**
	 * metodo que vai imprimir o log da forma que for definida na classe.
	 * @param metodo metodo a ser imprimido.
	 * @param operacao operacao que foi usada.
	 */
	public void log(String metodo , String operacao);
}
