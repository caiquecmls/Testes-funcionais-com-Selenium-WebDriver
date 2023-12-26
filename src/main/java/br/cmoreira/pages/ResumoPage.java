package br.cmoreira.pages;

import org.junit.Test;
import org.openqa.selenium.By;

import br.cmoreira.core.BasePage;

public class ResumoPage extends BasePage{
	
	
	//public void excluirMovimentacao(int posicao) {
	//	ClicarBotao(By.xpath("(//*[@class=\"glyphicon glyphicon-remove-circle\"])["+posicao+"]"));
	//}
	
	public void excluirMovimentacao(){
		ClicarBotao(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']"));
	}
	
	
	public String obterMensagemSucesso() {
		return obterMensagemSucesso("//*[@class=\"alert alert-success\"]");
	}
}
