package br.ce.orlando.appium.test;

import org.junit.Test;

import br.ce.orlando.appium.core.BaseTest;
import br.ce.orlando.appium.page.MenuPage;
import br.ce.orlando.appium.page.SplashPage;

public class SplashTest extends BaseTest{
	
	private MenuPage menu = new MenuPage();
	private SplashPage page = new SplashPage();
	
	@Test
	public void deveAguardarSplashSumir() throws InterruptedException {
		//acessar menu splash
		menu.acessarSplash();
		
		//verificar que o splash esta sendo exibido
		page.isTelaSplashVisivel();
		
		//aguardar saida do splash
		page.aguardarSplashSumir();
		
		//verificar que o formulario esta aparecendo
		page.existeElementoPorTexto("Formulário");
		
	}
}
