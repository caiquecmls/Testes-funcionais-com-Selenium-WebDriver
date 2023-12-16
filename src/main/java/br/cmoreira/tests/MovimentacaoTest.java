package br.cmoreira.tests;

import org.junit.Assert;
import org.junit.Test;
import br.cmoreira.core.BaseTest;
import br.cmoreira.pages.MenuPage;
import br.cmoreira.pages.MovimentacaoPage;



public class MovimentacaoTest extends BaseTest{
	
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movimentacaoPage = new MovimentacaoPage();
	
	@Test
	public void InserirMovimentacao() {
		menuPage.acessarTelaCriarMovimentacao();
		movimentacaoPage.setDataMovimentacao("14/12/2023");
		movimentacaoPage.setDataPagamento("15/12/2023");
		movimentacaoPage.setDescricao("HEHEHEHE");
		movimentacaoPage.setInteressado("Banco");
		movimentacaoPage.setValor("180");
		//movimentacaoPage.selecionarConta(2);
		movimentacaoPage.SelecionarCombo("conta", "conta 1");		
		movimentacaoPage.ClicarBotaoPeloNome("Salvar");
		Assert.assertEquals("Movimentação adicionada com sucesso!", movimentacaoPage.obterMensagemSucesso());
		
	}
}
