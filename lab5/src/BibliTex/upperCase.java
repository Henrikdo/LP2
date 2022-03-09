package BibliTex;

public class upperCase implements AlgoritmoTransformacao{
	/**
	 * Classe transformadora que irá transformar a string
	 * a string em uppercase.
	 * 
	 * @author Henrique Dias - 120210069
	 */
	private String nome;
	
	/**
	 * Constrói a string que é o nome da operacao.
	 */
	public upperCase(){
		this.nome = "upperCase";
	}
	
	/**
	 * Transforma todas as letras da string em uma letra maiúscula
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
