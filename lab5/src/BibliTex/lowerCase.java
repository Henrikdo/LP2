package BibliTex;

public class lowerCase implements AlgoritmoTransformacao{
	/**
	 * Classe transformadora que ir� converter a string para lowercase.
	 * 
	 * @author Henrique Dias - 120210069
	 */
	private String nome;
	
	/**
	 * construtor do nome da operacao.
	 */
	public lowerCase(){
		this.nome = "lowerCase";
	}
	/**
	 * transforma a string em uma string contendo apenas letras min�sculas.
	 * @return string em lowercase.
	 */
	@Override
	public String transforma(String texto) {
		String string = texto.toLowerCase();
		return string;
	}

	@Override
	public String getNome() {
		return this.nome;
	}

}
