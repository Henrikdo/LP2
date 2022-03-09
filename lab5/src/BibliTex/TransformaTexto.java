package BibliTex;

import java.util.*;

public class TransformaTexto{
	/**
	 * Classe transforma texto, esta classe funcionará como um controlador
	 * de modo que irá controlar as operacoes de transformacoes textuais
	 * a serem usadas e as operacoes que trabalham com os dados armazenados.
	 * 
	 * @author Henrique Dias - 120210069
	 */
	private HashMap<String, AlgoritmoTransformacao> transformacoes;
	private ArrayList<String> historico;
	private ArrayList<String> Originals;
	private Logador logger;
		
	/**
	 * Construtor 1
	 * 
	 * irá construir as formas de armazenamento e cadastrar
	 * as operacoes que vem por padrao no sistema.
	 * 
	 * este construtor é chamado quando nenhum parametro é passado.
	 */
	public TransformaTexto() {
		this.transformacoes = new HashMap<>();
		this.historico = new ArrayList<>();
		this.Originals = new ArrayList<>();

		cadastraTransformacoesPadroes();

	}
	
	/**
	 * Construtor 2
	 * 
	 * irá construir as formas de armazenamento e cadastrar
	 * as operacoes que vem por padrao no sistema.
	 * 
	 * este construtor é chamado quando um logger é passado como parametro.
	 * @param l logger que o usuário quer adicionar
	 */
	public TransformaTexto(Logador l) {
		this.transformacoes = new HashMap<>();
		this.historico = new ArrayList<>();
		this.Originals = new ArrayList<>();
		
		this.logger = l;
		
		cadastraTransformacoesPadroes();
	}
	
	/**
	 * recebe os parametros referentes a operacao a ser usada
	 * e o texto a ser transformado.
	 * 
	 * se a operacao passada estiver cadastrada no mapa transformacoes
	 * a classe é chamada para transformar o texto.
	 * 
	 * se a operacao não tiver cadastrada uma mensagem é retornada reportando isso.
	 * 
	 * @param operacao operacao desejada
	 * @param texto texto a ser transformado
	 * @return string transformada 
	 */
	public String transforma(String operacao, String texto) {
		if(!this.transformacoes.containsKey(operacao)) {
			return "Operacao não cadastrada";
		}
		String opcao = operacao;
		for(String op : this.transformacoes.keySet()) {
			if(operacao.toLowerCase().equals(op.toLowerCase())) {
				opcao = op;
			}
		}
		String string = this.transformacoes.get(opcao).transforma(texto);
		this.historico.add(texto+" "+operacao+" -> "+ string);
		Originals.add(texto);
		
		if(this.logger != null) {
			this.logger.log("transforma",operacao);
		}
		return string;
	}


	/**
	 * conta as vezes que o usuário transformou algum texto.
	 * 
	 * esse metodo funciona com base na lista Originals que armazena todas
	 * as strings originais que foram transformadas, retornando o tamanho dessa lista.
	 * 
	 * @return vezes que um texto foi transformado.
	 */
	public int contaTransformacao() {
			if(this.logger != null) {
				this.logger.log("contaTransformacao","");
			}
		return this.Originals.size();
	}
	
	/**
	 * retorna uma parte do historico de acordo com o index passado.
	 * 
	 * essa parte é uma string contendo a string original a operacao usada e a string final transformada.
	 * @param index
	 * @return string contendo as informaçoes do que foi feito com a string.
	 * 
	 * se o index fornecido for inválido um aviso é retornado.
	 */
	public String historico (int index) {
		
		if(index > this.historico.size() || index < 0 || this.historico.size() == 0) {
			return "Esse historico não existe";
		}
		
		if(this.logger != null) {
			this.logger.log("historico",String.valueOf(index));
		}
		String string = this.historico.get(index);
		return string.trim();
	}

	
	/**
	 * retorna a lista originals de forma a não repetir a mesma string , 
	 * por isso é transformada em um hashset antes de ser trabalhada.
	 * 
	 * depois faz uma string contendo todos os textos originais e retorna ela.
	 * 
	 * @return string contendo todos os textos originais.
	 * 
	 * se a lisa estiver vazia um aviso é retornado no lugar.
	 */
	public String listarOriginais(){
		if(Originals.size() == 0) {
			return "Lista vazia";
		}
		 HashSet<String> hashSet = new HashSet<>(Originals);
		 String string = "";
		 for(String s : hashSet) {
			 string += s + "\n";
		 }
		 return string.trim();
	}
	
	/**
	 * faz uma string listando todas as transformações cadastradas no sistema
	 * em ordem alfabética.
	 * @return retorna a string construida.
	 * 
	 */
	public String listarTransformacoes() {
		 ArrayList<String> keys = new ArrayList<>(this.transformacoes.keySet());
		 Collections.sort(keys, String.CASE_INSENSITIVE_ORDER);
		 String string = "";
		 for(String transformacao : keys) {
			 string += (transformacao + "\n");
		 }
		 return string.trim();
	}
	
	/**
	 * Cadastra uma transformação no sistema , adicionando o algoritmo e o nome da operacao no hashmap transformacoes.
	 * se um dos parametros for nulo o programa joga uma exceção e para de rodar.
	 * 
	 * @param transformacao nome da operacao.
	 * @param algoritmo algoritmo da operacao.
	 */
	public void cadastraTransformacao(String transformacao, AlgoritmoTransformacao algoritmo) {
		if(transformacao.equals(null)||algoritmo.equals(null)) {
			throw new NullPointerException("Parametro Nulo");
		}
		
		this.transformacoes.put(transformacao, algoritmo);
	}
	
	/**
	 * cria e cadastra as operacoes padrão do sistema.
	 */
	public void cadastraTransformacoesPadroes() {
		CaMeLcAsEfY ccf = new CaMeLcAsEfY();
		clean clean = new clean();
		upperCase uc = new upperCase();
		cleanSpaces cs = new cleanSpaces();
		lowerCase lc = new lowerCase();
		ConverteInterrogacoesParaPontos ccip = new ConverteInterrogacoesParaPontos();
		this.transformacoes.put(ccip.getNome(), ccip);
		this.transformacoes.put(ccf.getNome(), ccf );
		this.transformacoes.put(clean.getNome(), clean);
		this.transformacoes.put(uc.getNome(), uc);
		this.transformacoes.put(cs.getNome(), cs);
		this.transformacoes.put(lc.getNome(), lc);
	}
}	
