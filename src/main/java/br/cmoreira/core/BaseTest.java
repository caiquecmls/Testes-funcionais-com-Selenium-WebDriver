package br.cmoreira.core;
import static br.cmoreira.core.DriverFactory.killDriver;
import java.io.File;
import java.io.IOException;
import static br.cmoreira.core.DriverFactory.getDriver;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.ScreenshotException;

import br.cmoreira.pages.LoginPage;

public class BaseTest{
	
	private LoginPage page = new LoginPage();
	
	@Rule
	public TestName testName = new TestName();
	
	
	@Before
	public void inicializa() {
		page.acessarTelaInicial();
		page.setEmail("caique@mls.com.br");
		page.setSenha("caique@mls.com.br");
		page.entrar();
	}

	@After
	public void finaliza() throws IOException {
		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" + File.separator +
				testName.getMethodName() + ".jpg"));
		
		if(Propriedades.FECHAR_BROWSER) {
			killDriver();
		}
	}
}