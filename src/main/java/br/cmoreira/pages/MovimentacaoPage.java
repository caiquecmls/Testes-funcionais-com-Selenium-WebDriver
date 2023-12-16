package br.cmoreira.pages;

import org.openqa.selenium.By;

import br.cmoreira.core.BasePage;

public class MovimentacaoPage extends BasePage{
	
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
	
	public void selecionarConta(int conta) {
		ClicarBotao(By.xpath("//*[@id='conta']/option["+conta+"]"));
	}
	
	//public void Salvar() {
	//	ClicarBotao(By.xpath("//div[@class='btn-group']/button"));
	//}
	
	public String obterMensagemSucesso() {
		return ObterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
}
