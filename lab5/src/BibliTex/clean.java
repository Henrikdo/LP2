package BibliTex;

public class clean implements AlgoritmoTransformacao{
	/**
	 * @author Henrique Dias - 120210069
	 * Classe  transformadora clean que ir� tranformar o texto
	 * de forma a remover quaisquer sinais de pontua��o.
	 */
	private String nome;
	
	/**
	 * Construtor
	 * constr�i uma string contendo o nome da operacao.
	 */
	public clean(){
		this.nome = "clean";
	}
	
	/**
	 * transforma a string de modo a remover 
	 * os sinais de pontua��o
	 * @return string transformada
	 */
	@Override
	public String transforma(String texto) {
		String string = texto.replaceAll("[-+�`.^:,~;?!><*&�%$#@!()=]","");
		return string;
	}

	/** 
	 * retorna o nome que foi construido.
	 */
	@Override
	public String getNome() {
		return this.nome;
	}
}
