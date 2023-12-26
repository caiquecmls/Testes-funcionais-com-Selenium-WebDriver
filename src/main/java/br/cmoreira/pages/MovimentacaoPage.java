package br.cmoreira.pages;

import static br.cmoreira.core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import br.cmoreira.core.BasePage;
import br.cmoreira.core.DriverFactory;

public class MovimentacaoPage extends BasePage {

	public void setDataMovimentacao(String data) {
		Escrever("data_transacao", data);
	}

	public void setDataPagamento(String data) {
		Escrever("data_pagamento", data);
	}

	public void setDescricao(String descricao) {
		Escrever("descricao", descricao);
	}

	public void setInteressado(String interessado) {
		Escrever("interessado", interessado);
	}

	public void setValor(String valor) {
		Escrever("valor", valor);
	}

	public void setConta(String conta) {
	    WebElement elementoSelect = DriverFactory.getDriver().findElement(By.xpath("//select[@id='conta']"));
		Select select = new Select(elementoSelect);
		select.selectByVisibleText(conta);
	}

	// public void Salvar() {
	// ClicarBotao(By.xpath("//div[@class='btn-group']/button"));
	// }	

	public String obterMensagemSucesso() {
		return ObterTexto(By.xpath("//div[@class='alert alert-success']"));
	}

	public List<String> obterErros(){
		List<WebElement> erros = getDriver().findElements(By.xpath("//div[@class='alert alert-danger']//li"));
		List<String> retorno = new ArrayList<String>(); 
		for (WebElement erro : erros) {
			retorno.add(erro.getText());
		}
		return retorno;
	}
}
