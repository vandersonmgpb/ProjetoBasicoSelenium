package br.pb.fcoaraujo.core;

public class Propriedades {
	
	public static boolean FECHAR_BROWSER = false;
	
	public static Browsers browser = Browsers.FIREFOX;
	
	public static String NOME_CONTA_ALTERADA = "Conta Alterada " + System.nanoTime();
	
	public enum Browsers {
		CHROME,
		FIREFOX,
	}

}
