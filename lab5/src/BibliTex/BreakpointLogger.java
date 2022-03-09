package BibliTex;

public class BreakpointLogger implements Logador {
	/**
	 * Logger que quando o metodo fornecido for chamado
	 * imprime uma string contendo este metodo. 
	 *
	 */
	
	private String metodo;
	
	/**
	 * construtor , constrói a string do metodo que foi definido.
	 * @param metodo
	 */
	public BreakpointLogger(String metodo) {
		this.metodo = metodo;
	}
	/**
	 * 
	 * imprime a string se o metodo invocado for o definido.
	 */
	@Override
	public void log(String metodo, String operacao) {
		if(metodo.equals(this.metodo)) {
			System.out.println("[INVOCADO - "+ metodo+"]");
		}
	}

}
