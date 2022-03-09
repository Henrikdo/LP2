package BibliTex;

public class cleanSpaces implements AlgoritmoTransformacao{
	/**
	 * Classe transformadora que ir� remover quaiser espa�os da string fornecida.
	 * 
	 * @author Henrique Dias - 120210069
	 */
	private String nome;
	
	/**
	 * constr�i o nome da opera��o.
	 */
	public cleanSpaces(){
		this.nome = "cleanSpaces";
	}
	
	/**
	 * transforma a string de modo a remover os espa�os.
	 * @return string transfomada.
	 */
	public String transforma(String texto) {
		String string = texto.replace(" ","");
		return string;
	}
	
	/**
	 * retorna o nome construido.
	 */
	@Override
	public String getNome() {
		return this.nome;
	}

}
