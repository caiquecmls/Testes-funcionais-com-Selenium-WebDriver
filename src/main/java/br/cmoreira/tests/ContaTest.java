package br.cmoreira.tests;

import org.junit.Assert;
import org.junit.Test;

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
}
