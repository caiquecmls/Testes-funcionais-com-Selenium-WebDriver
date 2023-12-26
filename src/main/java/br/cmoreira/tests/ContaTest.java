package br.cmoreira.tests;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import br.cmoreira.core.BaseTest;
import br.cmoreira.core.Propriedades;
import br.cmoreira.pages.ContasPage;
import br.cmoreira.pages.MenuPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //serve para executar por ordem alfabética
public class ContaTest extends BaseTest{

	MenuPage page = new MenuPage();
	ContasPage pageConta = new ContasPage();
	
	@Test
	public void test1_InserirConta() {
		page.acessarTelaInserirConta();
		pageConta.setNome("conta 2");
		pageConta.salvar();
		Assert.assertEquals("Conta adicionada com sucesso!", pageConta.obterMensagemSucesso());
	}
	
	@Test
	public void test2_AlterarConta() {
		page.acessarTelaListarConta();
		pageConta.clicarAlterarConta("conta 2");
		pageConta.setNome(Propriedades.NOME_CONTA_ALTERADA);
		pageConta.salvar();
		Assert.assertEquals("Conta alterada com sucesso!", pageConta.obterMensagemSucesso());
	}
	
	@Test
	public void test3_InserirContaComMesmoNome() {
		page.acessarTelaInserirConta();
		pageConta.setNome(Propriedades.NOME_CONTA_ALTERADA);
		pageConta.salvar();
		Assert.assertEquals("Já existe uma conta com esse nome!", pageConta.obterMensagemErro());
	}
}
