package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import BibliTex.AlgoritmoTransformacao;
import BibliTex.ConsoleLogger;
import BibliTex.ConverteExclamacoesParaPontos;
import BibliTex.TransformaTexto;

import org.junit.jupiter.api.BeforeEach;

class TransformaTexto_teste {
	private TransformaTexto tt;
	@BeforeEach
	 void iniciatransforma() {
		tt = new TransformaTexto();
	}

	@Test
	 void iniciatransforma_comlogger() {
		ConsoleLogger cl = new ConsoleLogger();
		tt = new TransformaTexto(cl);
	}
	
	@Test
	 void transforma_opcaoinexistente() {
		
		assertEquals((tt.transforma("Kled", "oi, como vc vai?")),"Operacao não cadastrada");
	}
	
	
	@Test
	 void contatransformacao_teste() {
		tt.transforma("Kled", "oi, como vc vai?");
		tt.transforma("CaMeLcAsEfY", "oi, como vc vai?");
		tt.transforma("clean", "vixe. m,ari.a");
		
		assertEquals((tt.contaTransformacao()),2);
	}
	@Test
	 void contatransformacao_teste_nenhumatransformacao() {
		assertEquals((tt.contaTransformacao()),0);
	}
	
	@Test
	 void historico_teste() {
		tt.transforma("Kled", "oi, como vc vai?");
		tt.transforma("clean", "vixe. m,ari.a");
		tt.transforma("CaMeLcAsEfY", "oi, como vc vai?");
		assertEquals((tt.historico(1)),"oi, como vc vai? CaMeLcAsEfY -> Oi, CoMo vC VaI?");
		assertEquals((tt.historico(0)),"vixe. m,ari.a clean -> vixe maria");
	}
	@Test
	 void historico_vazio() {
		assertEquals((tt.historico(1)),"Esse historico não existe");
		assertEquals((tt.historico(0)),"Esse historico não existe");
	}
	

	@Test
	 void listarOriginais_teste() {
		tt.transforma("Kled", "oi, como vc vai?");
		tt.transforma("clean", "vixe. m,ari.a");
		tt.transforma("CaMeLcAsEfY", "oi, como vc vai?");
		assertEquals((tt.listarOriginais()),"vixe. m,ari.a\noi, como vc vai?");
	}
	@Test
	 void listarOriginais_vazio() {
		assertEquals((tt.listarOriginais()),"Lista vazia");
	}
	
	@Test
	 void listarTransformacoes_teste() {
		assertEquals((tt.listarTransformacoes()),"CaMeLcAsEfY\nclean\ncleanSpaces\nInterrogaPraPontos\nlowerCase\nupperCase");
	}
	
	
	@Test
	 void cadastrarTransformacaos_teste() {
		assertEquals((tt.listarTransformacoes()),"CaMeLcAsEfY\nclean\ncleanSpaces\nInterrogaPraPontos\nlowerCase\nupperCase");
		AlgoritmoTransformacao meuAlgoritmo = new ConverteExclamacoesParaPontos();
		tt.cadastraTransformacao("ExclamaPraPontos", meuAlgoritmo);
		assertEquals((tt.listarTransformacoes()),"CaMeLcAsEfY\nclean\ncleanSpaces\nExclamaPraPontos\nInterrogaPraPontos\nlowerCase\nupperCase");
		assertEquals((tt.transforma("ExclamaPraPontos", "me ajiude!!!!")),"me ajiude....");
		
	}
	
	
	@Test
	void cadastrarTransformacao_nulo() {
		AlgoritmoTransformacao meuAlgoritmo = new ConverteExclamacoesParaPontos();
		try{
			tt.cadastraTransformacao(null,null);
			fail("Era esperado uma exceção");
		}catch (NullPointerException nulo) {
			//Tentativa de cadastrar parametro nulo.
		}
		try{
			tt.cadastraTransformacao("ExclamaParaPontos",null);
			fail("Era esperado uma exceção");
		}catch (NullPointerException nulo) {
			//Tentativa de cadastrar parametro nulo.
		}
		try{
			tt.cadastraTransformacao(null,meuAlgoritmo);
			fail("Era esperado uma exceção");
		}catch (NullPointerException nulo) {
			//Tentativa de cadastrar parametro nulo.
		}
	}
	
	@Test
	 void transforma_opcaonula() {
		
		assertEquals((tt.transforma(null, "oi, como vc vai?")),"Operacao não cadastrada");
	}
	@Test
	 void transforma_camelcasefy() {
		
		assertEquals((tt.transforma("CaMeLcAsEfY", "oi, como vc vai?")),"Oi, CoMo vC VaI?");
	}
	@Test
	 void transforma_camelcasefy_vazio() {
		
		assertEquals((tt.transforma("CaMeLcAsEfY", "")),"");
	}
	
	
	@Test
	 void transforma_clean() {
		
		assertEquals((tt.transforma("clean", "oi, como vc vai?")),"oi como vc vai");
	}
	@Test
	 void transforma_clean_vazio() {
		
		assertEquals((tt.transforma("clean", "")),"");
	}
	
	
	@Test
	 void transforma_cleanSpaces() {
		
		assertEquals((tt.transforma("cleanSpaces", "oi, como vc vai?")),"oi,comovcvai?");
	}
	@Test
	 void transforma_cleanSpaces_vazio() {
		
		assertEquals((tt.transforma("cleanSpaces", "")),"");
	}
	
	
	@Test
	 void transforma_upperCase() {
		
		assertEquals((tt.transforma("upperCase", "oi, como vc vai?")),"OI, COMO VC VAI?");
	}
	@Test
	 void transforma_upperCase_vazio() {
		
		assertEquals((tt.transforma("upperCase", "")),"");
	}
	
	
	@Test
	 void transforma_lowerCase() {
		
		assertEquals((tt.transforma("lowerCase", "OI, COMO VC VAI?")),"oi, como vc vai?");
	}
	@Test
	 void transforma_lowerCase_vazio() {
		
		assertEquals((tt.transforma("lowerCase", "")),"");
	}
	
	@Test
	 void transforma_InterrogaPraPontos() {
		
		assertEquals((tt.transforma("InterrogaPraPontos", "oi, como vc vai?")),"oi, como vc vai.");
	}
	@Test
	 void transforma_InterrogaPraPontosy_vazio() {
		
		assertEquals((tt.transforma("InterrogaPraPontos", "")),"");
	}
	
}
