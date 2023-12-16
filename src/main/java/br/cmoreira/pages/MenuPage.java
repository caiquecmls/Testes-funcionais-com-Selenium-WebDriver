package br.cmoreira.pages;

import org.openqa.selenium.By;

import br.cmoreira.core.BasePage;
import br.cmoreira.core.DriverFactory;

public class MenuPage extends BasePage{
	
	public void acessarTelaInserirConta() {
		ClicarLink("Contas");
		ClicarLink("Adicionar");
	}

	
	public void acessarTelaListarConta() {
		ClicarLink("Contas");
		ClicarLink("Listar");
	}
	
	public void acessarTelaCriarMovimentacao() {
		ClicarLink("Criar Movimentação");
	}
}
