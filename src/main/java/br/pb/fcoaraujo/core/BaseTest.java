package br.pb.fcoaraujo.core;

import static br.pb.fcoaraujo.core.DriverFactory.getDriver;
import static br.pb.fcoaraujo.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;

import br.pb.fcoaraujo.pages.LoginPage;

public class BaseTest {
	private LoginPage page = new LoginPage();
	
	@Rule
	public TestName testName = new TestName();
	
	@Before
	public void inicializa() {
		page.acessarTelaInicial();
		
		page.setEmail("contachaves@test");
		page.setSenha("0123");
		page.entrar();
		
	}
	
	@After
	public void finaliza() throws IOException  {
		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		Files.copy(arquivo, new File("target" + File.separator + "screenshot" +
				File.separator + testName.getMethodName() + ".jpg"));
		
		if(Propriedades.FECHAR_BROWSER) {
			killDriver();
		}
	}

}


