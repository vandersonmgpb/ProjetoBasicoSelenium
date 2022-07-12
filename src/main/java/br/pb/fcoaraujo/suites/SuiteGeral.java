package br.pb.fcoaraujo.suites;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.pb.fcoaraujo.core.DriverFactory;
import br.pb.fcoaraujo.pages.LoginPage;
import br.pb.fcoaraujo.tests.ContaTest;
import br.pb.fcoaraujo.tests.MovimentacaoTest;
import br.pb.fcoaraujo.tests.RemoverMovimentacaoContaTest;
import br.pb.fcoaraujo.tests.ResumoTest;
import br.pb.fcoaraujo.tests.SaldoTest;

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
	public static void inicializa(){
		page.acessarTelaInicial();
		
		page.setEmail("wagner@costa");
		page.setSenha("123456");
		page.entrar();
	}
	
	@AfterClass
	public static void finaliza(){
		DriverFactory.killDriver();
	}
}
