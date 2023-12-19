package br.cmoreira.pages;

import org.openqa.selenium.WebElement;

import br.cmoreira.core.BasePage;

public class SaldoPage extends BasePage{
	
	public String obterSaldoConta(String conta) {
		return obterCelula("Conta", conta, "Saldo", "tabelaSaldo").getText();
	}
}
