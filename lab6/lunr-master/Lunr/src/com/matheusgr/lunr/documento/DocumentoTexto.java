package com.matheusgr.lunr.documento;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import biblitex.TransformaTexto;

/**
 * Documento de texto simples. Não precisa de tratamento complexos nem tem
 * metadados próprios.
 */
class DocumentoTexto extends DocumentoOriginal {



	/**
	 * Construtor padrão do documento de texto.
	 * @param id ID do documento.
	 * @param txt Texto do documento.
	 */
	public DocumentoTexto(String id, String txt) {
		super(id, txt);
		this.limpo = (new TransformaTexto()).transforma(TransformaTexto.Algoritmos.clean, txt).strip();
	}

	@Override
	public double metricaTextoUtil() {
		return super.metricaTextoUtil();
	}

	@Override
	public String getId() {
		return super.getId();
	}

	@Override
	public String[] getTexto() {
		return super.getTexto();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DocumentoTexto other = (DocumentoTexto) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		return "===" + this.id + System.lineSeparator() + this.limpo;
	}

	@Override
	public Map<String, String> getMetadados() {
		if (this.metadados != null) {
			return this.metadados;
		}
		this.metadados = new HashMap<String, String>();
		this.metadados.put("LINHAS", "" + this.original.chars().filter((value) -> '\n' == value).count());
		this.metadados.put("TAMANHO", "" + this.limpo.length());
		this.metadados.put("METADATADATE", "" + System.currentTimeMillis());
		this.metadados.put("TIPO", "" + "txt");
		return this.metadados;
	}

}
