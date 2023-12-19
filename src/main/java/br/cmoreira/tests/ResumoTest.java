package br.cmoreira.tests;

import org.junit.Assert;
import org.junit.Test;

import br.cmoreira.core.BaseTest;
import br.cmoreira.pages.MenuPage;
import br.cmoreira.pages.ResumoPage;

public class ResumoTest extends BaseTest{
	
	MenuPage menuPage = new MenuPage();
	ResumoPage resumoPage = new ResumoPage();
	
	@Test
	public void testRemoverMovimentacao() {
		menuPage.acessarTelaResumo();
		resumoPage.excluirMovimentacao(1);	
		Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());
	}
}
