package br.cmoreira.tests;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import br.cmoreira.core.BaseTest;
import br.cmoreira.core.Propriedades;
import br.cmoreira.pages.MenuPage;
import br.cmoreira.pages.MovimentacaoPage;
import br.cmoreira.utils.DataUtils;


@FixMethodOrder(MethodSorters.NAME_ASCENDING) //serve para executar por ordem alfabética
public class MovimentacaoTest extends BaseTest{
	
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movimentacaoPage = new MovimentacaoPage();
	private DataUtils data = new DataUtils();
	
	
	@Test
	public void test1_InserirMovimentacao() {
		menuPage.acessarTelaCriarMovimentacao();
		movimentacaoPage.setDataMovimentacao(data.formatarData(new java.util.Date()));
		movimentacaoPage.setDataPagamento(data.formatarData(new java.util.Date()));
		movimentacaoPage.setDescricao("Movimentação do Teste");
		movimentacaoPage.setInteressado("Interessado Qualquer");
		movimentacaoPage.setValor("180");
		movimentacaoPage.setConta(Propriedades.NOME_CONTA_ALTERADA);
		movimentacaoPage.ClicarRadioButton("status_pago");
		movimentacaoPage.ClicarBotaoPeloNome("Salvar");
		Assert.assertEquals("Movimentação adicionada com sucesso!", movimentacaoPage.obterMensagemSucesso());
	}
	
	@Test
	public void test2_CamposObrigatoriosMovimentacao() {
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
	public void test3_InserirMovimentacaoFutura() {
		menuPage.acessarTelaCriarMovimentacao();
		movimentacaoPage.setDataMovimentacao(data.formatarData(data.obterDataComDiferencaDias(1)));
		movimentacaoPage.setDataPagamento(data.formatarData(new java.util.Date()));
		movimentacaoPage.setDescricao("Movimentação do Teste");
		movimentacaoPage.setInteressado("Interessado Qualquer");
		movimentacaoPage.setValor("180");
		movimentacaoPage.setConta(Propriedades.NOME_CONTA_ALTERADA);	
		movimentacaoPage.ClicarBotaoPeloNome("Salvar");
		Assert.assertEquals("Data da Movimentação deve ser menor ou igual à data atual", movimentacaoPage.obterMensagemErro("//div[@class='alert alert-danger']"));
	}
	
	
}
