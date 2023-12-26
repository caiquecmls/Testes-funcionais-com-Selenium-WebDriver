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


@FixMethodOrder(MethodSorters.NAME_ASCENDING) //serve para executar por ordem alfab�tica
public class MovimentacaoTest extends BaseTest{
	
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movimentacaoPage = new MovimentacaoPage();
	private DataUtils data = new DataUtils();
	
	
	@Test
	public void test1_InserirMovimentacao() {
		menuPage.acessarTelaCriarMovimentacao();
		movimentacaoPage.setDataMovimentacao(data.formatarData(new java.util.Date()));
		movimentacaoPage.setDataPagamento(data.formatarData(new java.util.Date()));
		movimentacaoPage.setDescricao("Movimenta��o do Teste");
		movimentacaoPage.setInteressado("Interessado Qualquer");
		movimentacaoPage.setValor("180");
		movimentacaoPage.setConta(Propriedades.NOME_CONTA_ALTERADA);
		movimentacaoPage.ClicarRadioButton("status_pago");
		movimentacaoPage.ClicarBotaoPeloNome("Salvar");
		Assert.assertEquals("Movimenta��o adicionada com sucesso!", movimentacaoPage.obterMensagemSucesso());
	}
	
	@Test
	public void test2_CamposObrigatoriosMovimentacao() {
		menuPage.acessarTelaCriarMovimentacao();
		movimentacaoPage.ClicarBotaoPeloNome("Salvar");
		List<String> erros = movimentacaoPage.obterErros();
		Assert.assertTrue(erros.containsAll(Arrays.asList(			
				"Data da Movimenta��o � obrigat�rio",
				"Data do pagamento � obrigat�rio",
				"Descri��o � obrigat�rio",
				"Interessado � obrigat�rio",
				"Valor � obrigat�rio",
				"Valor deve ser um n�mero"
				)));
		Assert.assertEquals(6,erros.size());
	}
	
	@Test
	public void test3_InserirMovimentacaoFutura() {
		menuPage.acessarTelaCriarMovimentacao();
		movimentacaoPage.setDataMovimentacao(data.formatarData(data.obterDataComDiferencaDias(1)));
		movimentacaoPage.setDataPagamento(data.formatarData(new java.util.Date()));
		movimentacaoPage.setDescricao("Movimenta��o do Teste");
		movimentacaoPage.setInteressado("Interessado Qualquer");
		movimentacaoPage.setValor("180");
		movimentacaoPage.setConta(Propriedades.NOME_CONTA_ALTERADA);	
		movimentacaoPage.ClicarBotaoPeloNome("Salvar");
		Assert.assertEquals("Data da Movimenta��o deve ser menor ou igual � data atual", movimentacaoPage.obterMensagemErro("//div[@class='alert alert-danger']"));
	}
	
	
}
