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
}
