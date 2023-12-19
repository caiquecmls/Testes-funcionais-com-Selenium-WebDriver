package br.cmoreira.tests;

import org.junit.Assert;
import org.junit.Test;

import br.cmoreira.core.BaseTest;
import br.cmoreira.pages.MenuPage;
import br.cmoreira.pages.SaldoPage;

public class SaldoTest extends BaseTest{
	
	private MenuPage menuPage = new MenuPage();
	private SaldoPage saldoPage = new SaldoPage();
	
	@Test
	public void testVerificarSaldo() {
		menuPage.acessarTelaHome();
		Assert.assertEquals("180.00", saldoPage.obterSaldoConta("conta 2"));
	}
}
