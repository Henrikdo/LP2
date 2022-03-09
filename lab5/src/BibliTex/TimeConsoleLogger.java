package BibliTex;

public class TimeConsoleLogger implements Logador {
	/**
	 * classe logger que irá imprimir uma stirng com o metodo usado e o tempo em ms
	 * 
	 * @author Henrique Dias - 120210069
	 */
	
	/**
	 * metodo log que irá pegar o tempo atual em milisegundos e imprimir uma string com
	 * base nisso
	 */
	@Override
	public void log(String metodo, String operacao) {
		long tempo = (System.currentTimeMillis() / 1000000000)/100; 
		System.out.println("[" + metodo +" - "+ tempo+"ms"+"]" +" "+operacao);

	}

}
