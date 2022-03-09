package BibliTex;

public class CaMeLcAsEfY implements AlgoritmoTransformacao{
	/**
	 * @author User - Henrique Dias - 120210069
	 * 
	 * Classe transformadora de texto que irá fazer com que a cada caractere presente
	 * numa posição par fique em upper case.
	 */
	
	private String nome;
	
	/**
	 * construtor do nome do metodo
	 */
	public CaMeLcAsEfY(){
		this.nome = "CaMeLcAsEfY";
	}
	
	@Override
	/**
	 *  tranforma o texto de forma que ada caractere presente
	 *  numa posição par fique em upper case.
	 *  @return string transformada
	 */
	public String transforma(String texto) {
		if(texto.equals(null)) {
			throw new NullPointerException("PARAMETRO NULO!");
		}
		String string = "";
		for(int i = 0 ; i < texto.length();i++) {
			if(i % 2 == 0) {
				string += String.valueOf(texto.charAt(i)).toUpperCase();
			}
			else {
				string += String.valueOf(texto.charAt(i));
			}
		}

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
