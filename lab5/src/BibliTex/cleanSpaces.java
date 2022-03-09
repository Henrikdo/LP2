package BibliTex;

public class cleanSpaces implements AlgoritmoTransformacao{
	/**
	 * Classe transformadora que irá remover quaiser espaços da string fornecida.
	 * 
	 * @author Henrique Dias - 120210069
	 */
	private String nome;
	
	/**
	 * constrói o nome da operação.
	 */
	public cleanSpaces(){
		this.nome = "cleanSpaces";
	}
	
	/**
	 * transforma a string de modo a remover os espaços.
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
