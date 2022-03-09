package BibliTex;

public class ConverteInterrogacoesParaPontos implements AlgoritmoTransformacao {
	/**
	 * Classe transformadora que ir� converter interroga��es para pontos.
	 * 
	 * @author Henrique Dias - 120210069
	 */
	private String nome;
	
	/**
	 * Constr�i o nome da opera��o
	 */
	public ConverteInterrogacoesParaPontos (){
		this.nome = "InterrogaPraPontos";
	}
	
	/**
	 * Transforma qualquer interroga��o presente na string em ponto.
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
