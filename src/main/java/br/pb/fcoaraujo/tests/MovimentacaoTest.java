package br.pb.fcoaraujo.tests;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.pb.fcoaraujo.core.BaseTest;
import br.pb.fcoaraujo.pages.MenuPage;
import br.pb.fcoaraujo.pages.MovimentacaoPage;
import net.bytebuddy.implementation.auxiliary.MethodCallProxy.AssignableSignatureCall;

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
		
		Assert.assertEquals("Movimenta��o adicionada com sucesso!", movPage.obterMensagemSucesso());
	}
	
	@Test
	public void testCamposObrigatorios() {
		menuPage.acessarTelaInserirMovimentacao();
		
		movPage.salvar();
		movPage.obterErros();
		List<String> erros = movPage.obterErros();
//		Assert.assertEquals("Data da Movimenta��o � obrigat�rio", erros.get(0));
//		Assert.assertTrue(erros.contains("Data da Movimenta��o � obrigat�rio"));
		Assert.assertTrue(erros.containsAll(Arrays.asList(
			    "Data da Movimenta��o � obrigat�rio",
			    "Data do pagamento � obrigat�rio",
			    "Descri��o � obrigat�rio",
			    "Interessado � obrigat�rio",
			    "Valor � obrigat�rio",
			    "Valor deve ser um n�mero")));
		Assert.assertEquals(6, erros.size());
		
	}
}
