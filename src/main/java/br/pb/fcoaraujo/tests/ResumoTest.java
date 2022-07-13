package br.pb.fcoaraujo.tests;


import static br.pb.fcoaraujo.core.DriverFactory.getDriver;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.pb.fcoaraujo.core.BaseTest;
import br.pb.fcoaraujo.core.DriverFactory;
import br.pb.fcoaraujo.pages.MenuPage;
import br.pb.fcoaraujo.pages.ResumoPage;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResumoTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private ResumoPage resumoPage = new ResumoPage();
	
	@Test
	public void test1ExcluirMovimentacao() {
		menuPage.acessarTelaResumo();
		
		resumoPage.excluirMovimentacao();
		
		Assert.assertEquals("Movimentação removida com sucesso!", 
				resumoPage.obterMensagemSucesso());
	}
	
//	@Test(expected = NoSuchElementException.class)
	@Test
	public void test2ResumoMensal() {
		menuPage.acessarTelaResumo();
		
		Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
		List<WebElement> elementosEncontrados = 
				DriverFactory.getDriver().findElements(By.xpath(".//*[@id='tabelaExtrato']/tbody/tr"));
		Assert.assertEquals(0, elementosEncontrados.size());
	}

}
