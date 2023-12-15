package br.cmoreira.core;

import static br.cmoreira.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	
	
	public void Escrever(String id_campo, String texto) {
		getDriver().findElement(By.id(id_campo)).sendKeys(texto);
	}
	
	public String ObterValorCampo(String id_campo) {
		return getDriver().findElement(By.id(id_campo)).getAttribute("value");
	}
	
	public void ClicarRadioButton(String id_campo) {
		getDriver().findElement(By.id(id_campo)).click();
	}
	
	public void ClicarBotao(By by) {
		getDriver().findElement(by).click();
	}
	
	
	//href="/addConta"
	
	public void ClicarRadioButtonNew(String name_campo) {
		getDriver().findElement(By.name(name_campo)).click();
	}
	
	public boolean IsRadioMarcado(String id) {
		return getDriver().findElement(By.id(id)).isSelected();
	}
	
	public void ClicarCheckbox(String id_campo) {
		getDriver().findElement(By.id(id_campo)).click();
	}
	
	public boolean IsCheckboxMarcado(String id) {
		return getDriver().findElement(By.id(id)).isSelected();
	}
	
	public void SelecionarCombo(String id_campo, String TextoCampo){
	    WebElement elemento = getDriver().findElement(By.id(id_campo));
	    Select combo = new Select(elemento);
	    combo.selectByVisibleText(TextoCampo);
	}
	
	public String ObterValorCombo(String id_campo) {
	    WebElement elemento = getDriver().findElement(By.id(id_campo));
	    Select combo = new Select(elemento);
	    return combo.getFirstSelectedOption().getText();
	}
	
	
	public void ClicarBotao(String id_campo) {
		getDriver().findElement(By.id(id_campo)).click();
	}
	
	public void ClicarLink(String textoLink) {
		getDriver().findElement(By.linkText(textoLink)).click();
	}
	
	public String ObterTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public String ObterTexto(String id) {
		return ObterTexto(By.id(id));
	}
	
	public String alertaObterTextoEAceita() {
		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;
	}
	
	public Object executarJS(String cmd, Object... param) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		return js.executeScript(cmd, param);
	}
	
	/************** Tabela *********************/
	
	public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela) {
		
		//encontrar a coluna do registro
		WebElement tabela = getDriver().findElement(By.xpath("//*[@id='elementosForm:tableUsuarios']"));
	    int idColuna = obterIndiceColuna(colunaBusca, tabela);
	    
	    //encontrar a linha do registro
	    int idLinha = obterIndiceLinha(valor, tabela, idColuna);
	    
		//procurar coluna do botao
		int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);
	    
	    WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
	    celula.findElement(By.xpath(".//input")).click();
	    
	}

	protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
		int idLinha = -1;
		for (int i = 0; i < linhas.size(); i++) {	
			if (linhas.get(i).getText().equals(valor)) {
				idLinha = i+1;
				break;
			}
		}
		return idLinha;
	}

	protected int obterIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;
		for (int i = 0; i < colunas.size(); i++) {	
			if (colunas.get(i).getText().equals(coluna)) {
				idColuna = i+1;
				break;
			}
		}
		return idColuna;
	}

}
