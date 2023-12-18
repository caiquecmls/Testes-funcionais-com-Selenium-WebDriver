package br.cmoreira.tests;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import br.cmoreira.core.BaseTest;
import br.cmoreira.pages.MenuPage;
import br.cmoreira.pages.MovimentacaoPage;
import br.cmoreira.utils.DataUtils;



public class MovimentacaoTest extends BaseTest{
	
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movimentacaoPage = new MovimentacaoPage();
	private DataUtils data = new DataUtils();
	
	
	@Test
	public void testInserirMovimentacao() {
		menuPage.acessarTelaCriarMovimentacao();
		movimentacaoPage.setDataMovimentacao(data.formatarData(new java.util.Date()));
		movimentacaoPage.setDataPagamento("15/12/2023");
		movimentacaoPage.setDescricao("HEHEHEHE");
		movimentacaoPage.setInteressado("Banco");
		movimentacaoPage.setValor("180");
		//movimentacaoPage.selecionarConta(2);
		movimentacaoPage.SelecionarCombo("conta", "conta 1");		
		movimentacaoPage.ClicarBotaoPeloNome("Salvar");
		Assert.assertEquals("Movimentação adicionada com sucesso!", movimentacaoPage.obterMensagemSucesso());
	}
	
	@Test
	public void testCamposObrigatoriosMovimentacao() {
		menuPage.acessarTelaCriarMovimentacao();
		movimentacaoPage.ClicarBotaoPeloNome("Salvar");
		List<String> erros = movimentacaoPage.obterErros();
		Assert.assertTrue(erros.containsAll(Arrays.asList(			
				"Data da Movimentação é obrigatório",
				"Data do pagamento é obrigatório",
				"Descrição é obrigatório",
				"Interessado é obrigatório",
				"Valor é obrigatório",
				"Valor deve ser um número"
				)));
		Assert.assertEquals(6,erros.size());
	}
	
	@Test
	public void testInserirMovimentacaoFutura() {
		menuPage.acessarTelaCriarMovimentacao();
		movimentacaoPage.setDataMovimentacao(data.formatarData(data.obterDataComDiferencaDias(1)));
		movimentacaoPage.setDataPagamento("19/12/2023");
		movimentacaoPage.setDescricao("HEHEHEHE");
		movimentacaoPage.setInteressado("Banco");
		movimentacaoPage.setValor("180");
		//movimentacaoPage.selecionarConta(2);
		movimentacaoPage.SelecionarCombo("conta", "conta 1");		
		movimentacaoPage.ClicarBotaoPeloNome("Salvar");
		Assert.assertEquals("Data da Movimentação deve ser menor ou igual à data atual", movimentacaoPage.obterMensagemErro("//div[@class='alert alert-danger']"));
	}
	
}
