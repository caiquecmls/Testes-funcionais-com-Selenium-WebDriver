package br.cmoreira.tests;

import org.junit.Assert;
import org.junit.Test;
import br.cmoreira.core.BaseTest;
import br.cmoreira.core.Propriedades;
import br.cmoreira.pages.ContasPage;
import br.cmoreira.pages.MenuPage;

public class RemoverMovimentacaoContaTest extends BaseTest{
	MenuPage menuPage = new MenuPage();
	ContasPage pageConta = new ContasPage();
	
	@Test
	public void testRemoverContaComMovimentacao() throws InterruptedException {
		menuPage.acessarTelaListarConta();
		pageConta.clicarExcluirConta(Propriedades.NOME_CONTA_ALTERADA);	
		System.out.println(Propriedades.NOME_CONTA_ALTERADA);
		Assert.assertEquals("Conta em uso na movimentações", pageConta.obterMensagemErro());
	}
}
