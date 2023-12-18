package br.cmoreira.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import br.cmoreira.core.BaseTest;
import br.cmoreira.pages.ContasPage;
import br.cmoreira.pages.MenuPage;

public class ContaTest extends BaseTest{

	MenuPage page = new MenuPage();
	ContasPage pageConta = new ContasPage();
	
	@Test
	public void testInserirConta() {
		page.acessarTelaInserirConta();
		pageConta.setNome("conta 1");
		pageConta.salvar();
		Assert.assertEquals("Conta adicionada com sucesso!", pageConta.obterMensagemSucesso());
	}
	
	@Test
	public void testAlterarConta() {
		page.acessarTelaListarConta();
		pageConta.clicarAlterarConta("conta alterada");
		pageConta.setNome("conta alterada 1");
		pageConta.salvar();
		Assert.assertEquals("Conta alterada com sucesso!", pageConta.obterMensagemSucesso());
	}
	
	@Test
	public void testInserirContaComMesmoNome() {
		page.acessarTelaInserirConta();
		pageConta.setNome("conta 1");
		pageConta.salvar();
		Assert.assertEquals("Já existe uma conta com esse nome!", pageConta.obterMensagemErro());
	}
	
	@Test
	public void testRemoverContaComMovimentacao() {
		page.acessarTelaListarConta();
		//pageConta.excluirConta(1);
		pageConta.clicarExcluirConta("conta 1");	
		Assert.assertEquals("Conta em uso na movimentações", pageConta.obterMensagemErro());
	}
}
