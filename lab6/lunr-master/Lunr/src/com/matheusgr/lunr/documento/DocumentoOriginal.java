package com.matheusgr.lunr.documento;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import biblitex.TransformaTexto;

public abstract class DocumentoOriginal implements Documento {
	/**
	 * @author Henrique Dias - 120210069
	 * 
	 * Superclasse responsavel por fornecer a herança para as 
	 * subclasses.
	 * 
	 * ps: antes de mais nada queria informar que não completei o lab (-_-).
	 * não foi implementado a busca avançada e a similaridade não esta "completa".
	 */
	protected String id;
	protected String original;
	protected String limpo;
	protected Map<String, String> metadados;
	private String[] split;
	
	public DocumentoOriginal(String id, String original){
		this.id = id;
		this.original = original;
	}
	@Override
	public double metricaTextoUtil() {
		long extractedSize = (new TransformaTexto()).transforma(TransformaTexto.Algoritmos.cleanSpaces, this.limpo)
				.length();
		return (1.0 * extractedSize) / this.original.length();
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public String[] getTexto() {
		if (this.split == null) {
			this.split = (new TransformaTexto()).transforma(TransformaTexto.Algoritmos.cleanLines, this.limpo)
					.split(" ");
			Arrays.sort(this.split);
		}
		return this.split;
	}
	@Override
	public abstract Map<String, String> getMetadados();
		
	
}
