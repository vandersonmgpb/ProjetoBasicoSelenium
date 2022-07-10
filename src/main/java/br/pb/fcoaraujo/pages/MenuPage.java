package br.pb.fcoaraujo.pages;

import br.pb.fcoaraujo.core.BasePage;

public class MenuPage extends BasePage {
	
	public void acessarTelaInserirConta() {
		clicarlink("Contas");
		clicarlink("Adicionar");
	}
	
	public void acessarTelaListarConta() {
		clicarlink("Contas");
		clicarlink("Listar");
	}

}
