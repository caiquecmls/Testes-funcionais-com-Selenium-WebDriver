package br.cmoreira.pages;

import org.openqa.selenium.By;
import br.cmoreira.core.BasePage;


public class ContasPage extends BasePage{
	
	public void setNome(String nome) {
		Escrever("nome", nome);
	}
	
	public void salvar() {
		ClicarBotao(By.xpath("//button[.='Salvar']"));
	}
	
	public String obterMensagemSucesso() {
		return ObterTexto(By.xpath("//div[@class='alert alert-success']"));
	}

	public void clicarAlterarConta(String string) {
		obterCelula("Conta", string, "Ações", "tabelaContas")
		.findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();
	}

	public String obterMensagemErro() {
		return ObterTexto(By.xpath("//div[@class='alert alert-danger']"));
	}
	
	//public void excluirConta(int linhaBotao) {
	//	clicarBotaoTabela("Conta", "conta 1", "Ações", "tabelaContas", ("(//*[@class=\"glyphicon glyphicon-remove-circle\"])["+linhaBotao+"]"));
	//}
	

	public void clicarExcluirConta(String string) {
		obterCelula("Conta", string, "Ações", "tabelaContas").findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();
	}
}
