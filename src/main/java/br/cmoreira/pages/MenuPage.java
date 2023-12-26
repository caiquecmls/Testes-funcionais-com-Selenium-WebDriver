package br.cmoreira.pages;
import br.cmoreira.core.BasePage;

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
		ClicarLink("Criar Movimenta��o");
	}
	
	public void acessarTelaResumo() {
		ClicarLink("Resumo Mensal");
	}
	
	public void acessarTelaHome() {
		ClicarLink("Home");
	}
}
