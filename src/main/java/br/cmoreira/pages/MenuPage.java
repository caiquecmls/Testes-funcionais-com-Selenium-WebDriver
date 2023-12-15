package br.cmoreira.pages;

import org.openqa.selenium.By;

import br.cmoreira.core.BasePage;
import br.cmoreira.core.DriverFactory;

public class MenuPage extends BasePage{
	
	public void acessarTelaInserirConta() {
		ClicarLink("Contas");
		ClicarLink("Adicionar");
	}

}
