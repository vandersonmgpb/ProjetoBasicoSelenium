package br.pb.fcoaraujo.tests;

import org.junit.Assert;
import org.junit.Test;

import br.pb.fcoaraujo.core.BaseTest;
import br.pb.fcoaraujo.core.Propriedades;
import br.pb.fcoaraujo.pages.ContasPage;
import br.pb.fcoaraujo.pages.MenuPage;

public class RemoverMovimentacaoContaTest extends BaseTest{
	
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void testExcluirContaComMovimentacao() {
		menuPage.acessarTelaListarConta();
		
		contasPage.clicarExcluirConta(Propriedades.NOME_CONTA_ALTERADA);
		
		Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());
	}

}
