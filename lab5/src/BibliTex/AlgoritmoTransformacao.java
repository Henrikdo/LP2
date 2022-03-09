package BibliTex;

public interface AlgoritmoTransformacao {
	/**
	 *  interface com os metodos das classes que irão trabalhar como 
	 *  transformadoras de texto.
	 *  
	 * @author User Henrique Dias - 120210069
	 * @param texto as ser transformado
	 * @return texto transformado com base na operacao.
	 */
	public String transforma(String texto);
	/**
	 * retorna o nome da operacao.
	 * @return nome da operacao.
	 */
    public String getNome();
}
