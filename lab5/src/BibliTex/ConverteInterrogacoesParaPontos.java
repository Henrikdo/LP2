package BibliTex;

public class ConverteInterrogacoesParaPontos implements AlgoritmoTransformacao {
	/**
	 * Classe transformadora que irá converter interrogações para pontos.
	 * 
	 * @author Henrique Dias - 120210069
	 */
	private String nome;
	
	/**
	 * Constrói o nome da operação
	 */
	public ConverteInterrogacoesParaPontos (){
		this.nome = "InterrogaPraPontos";
	}
	
	/**
	 * Transforma qualquer interrogação presente na string em ponto.
	 * @return string transformada
	 */
	@Override
	public String transforma(String texto) {
		String string = texto.replace("?",".");
		return string;

	}
	
	/**
	 * Retorna o nome construido
	 */
	@Override
	public String getNome() {
		
		return this.nome;
	}
}
