package br.pb.fcoaraujo.tests;

import org.junit.Assert;
import org.junit.Test;

import br.pb.fcoaraujo.core.BaseTest;
import br.pb.fcoaraujo.pages.MenuPage;
import br.pb.fcoaraujo.pages.MovimentacaoPage;

public class MovimentacaoTest extends BaseTest{
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage = new MovimentacaoPage();
		
	@Test
	public void testInserirMovimentacao() {
		menuPage.acessarTelaInserirMovimentacao();
		
		movPage.setDataMovimentacao("10/07/2022");
		movPage.setDataPagamento("10/07/2022");
		movPage.setDescricao("Movimentacao do Teste");
		movPage.setInteressado("Interessado Qualquer");
		movPage.setValor("500");
		movPage.setConta("Conta do Teste Alterada");
		movPage.setStatusPago();
		movPage.salvar();
		
		Assert.assertEquals("Movimentação adicionada com sucesso!", movPage.obterMensagemSucesso());
	}
}
