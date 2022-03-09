package BibliTex;

public class ConsoleLogger implements Logador {
	/**
	 * classe logger possui o metodo log que irá imprimir uma string contendo 
	 * o metodo e a operacao usados sempre que um metodo for usado.
	 * @author User Henrique Dias - 120210069.
	 */
	@Override
	public void log(String metodo, String operacao) {
		
		System.out.println("[" + metodo + "]" +" "+operacao);
	
	}	
	
}
