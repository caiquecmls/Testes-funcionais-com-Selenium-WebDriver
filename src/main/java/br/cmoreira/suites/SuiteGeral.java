package br.cmoreira.suites;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.cmoreira.core.DriverFactory;
import br.cmoreira.pages.LoginPage;
import br.cmoreira.tests.ContaTest;
import br.cmoreira.tests.MovimentacaoTest;
import br.cmoreira.tests.RemoverMovimentacaoContaTest;
import br.cmoreira.tests.ResumoTest;
import br.cmoreira.tests.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	RemoverMovimentacaoContaTest.class,
	SaldoTest.class,
	ResumoTest.class
})
public class SuiteGeral {
	
	private static LoginPage page = new LoginPage();
	
	@BeforeClass
	public static void inicializa() {
		page.acessarTelaInicial();
		page.setEmail("caique@mls.com.br");
		page.setSenha("caique@mls.com.br");
		page.entrar();
	}
	
	@AfterClass
	public static void finaliza() {
		DriverFactory.killDriver();
	}
	

}