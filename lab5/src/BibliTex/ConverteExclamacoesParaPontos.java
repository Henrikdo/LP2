package BibliTex;

public class ConverteExclamacoesParaPontos implements AlgoritmoTransformacao {
	/**
	 * Classe transformadora que ir� converter cada exclama��o em um ponto.
	 * 
	 * @author Henrique Dias - 120210069
	 */

	private String nome;
	
	/**
	 * constr�i o nome da operacao
	 */
	public ConverteExclamacoesParaPontos (){
		this.nome = "ExclamaPraPontos";
	}
	/**
	 * transforma as exclama��es da string em pontos.
	 * 
	 * @return string transformada.
	 */
	@Override
	public String transforma(String texto) {
		String string = texto.replace("!",".");
		return string;
	}

	/**
	 * retorna o nome da operacao.
	 */
	@Override
	public String getNome() {
		return this.nome;
	}

}
