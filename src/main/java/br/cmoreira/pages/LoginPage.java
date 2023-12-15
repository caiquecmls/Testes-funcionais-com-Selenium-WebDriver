package br.cmoreira.pages;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;

import br.cmoreira.core.BasePage;
import br.cmoreira.core.DriverFactory;

//caique@mls.com.br
//caique@mls.com.br
//https://seubarriga.wcaquino.me/logout

public class LoginPage extends BasePage{
	
	public void acessarTelaInicial() {
		DriverFactory.getDriver().get("https://seubarriga.wcaquino.me/logout");//acessar o site	
		
	}
	
	public void setEmail(String email){
		Escrever("email", email);
	}
	
	public void setSenha(String senha) {
		Escrever("senha", senha);
	}
	
	public void entrar() {
		ClicarBotao(By.xpath("//button[.='Entrar']"));
	}
}
