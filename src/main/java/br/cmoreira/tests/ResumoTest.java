package br.cmoreira.tests;

import static br.cmoreira.core.DriverFactory.getDriver;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.cmoreira.core.BaseTest;
import br.cmoreira.core.DriverFactory;
import br.cmoreira.pages.MenuPage;
import br.cmoreira.pages.ResumoPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //serve para executar por ordem alfabética
public class ResumoTest extends BaseTest {

	MenuPage menuPage = new MenuPage();
	ResumoPage resumoPage = new ResumoPage();

	@Test
	public void test1_RemoverMovimentacao() {
		menuPage.acessarTelaResumo();
		resumoPage.excluirMovimentacao();
		Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());
	}

	@Test
	public void test2_ResumoMensal() { 
		menuPage.acessarTelaResumo();
		Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
		WebElement tabelaExtrato = DriverFactory.getDriver().findElement(By.xpath("//*[@id=\"tabelaExtrato\"]/tbody"));
		Assert.assertTrue(tabelaExtrato.findElements(By.tagName("tr")).isEmpty());
		
	}
}
