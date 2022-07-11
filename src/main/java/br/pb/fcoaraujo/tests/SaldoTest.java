package br.pb.fcoaraujo.tests;

import org.junit.Assert;
import org.junit.Test;

import br.pb.fcoaraujo.core.BaseTest;
import br.pb.fcoaraujo.core.Propriedades;
import br.pb.fcoaraujo.pages.HomePage;
import br.pb.fcoaraujo.pages.MenuPage;

public class SaldoTest extends BaseTest {
	HomePage page = new HomePage();
	MenuPage menu = new MenuPage();
	
	@Test
	public void testSaldoConta() {
		menu.acessarTelaPrincipal();
		Assert.assertEquals("500.00", page.obterSaldoConta(Propriedades.NOME_CONTA_ALTERADA));
	}

}
