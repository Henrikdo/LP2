package BibliTex;

public class upperCase implements AlgoritmoTransformacao{
	/**
	 * Classe transformadora que ir� transformar a string
	 * a string em uppercase.
	 * 
	 * @author Henrique Dias - 120210069
	 */
	private String nome;
	
	/**
	 * Constr�i a string que � o nome da operacao.
	 */
	public upperCase(){
		this.nome = "upperCase";
	}
	
	/**
	 * Transforma todas as letras da string em uma letra mai�scula
	 * 
	 * @return retorna a string transformada.
	 */
	@Override
	public String transforma(String texto) {
		String string = texto.toUpperCase();
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
