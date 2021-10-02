package br.ce.orlando.appium.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.ce.orlando.appium.core.BaseTest;
import br.ce.orlando.appium.page.MenuPage;
import br.ce.orlando.appium.page.WebViewPage;

public class WebViewTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private WebViewPage page = new WebViewPage();
	
	@Test
	public void deveFazerLogin() {
		//acessarMenu
		menu.acessarSeuBarrigaHibrido();
		esperar(3000);
		page.entrarContextoWeb();
		
		//preencher email
		page.setEmail("beach@park");
		
		//senha
		page.setSenha("onda");
		
		//entrar
		page.entrar();
		
		//verificar
		Assert.assertEquals("Bem vindo, BeachPark!", page.getMensagem());
	}
	
	@After
	public void tearDown() {
		page.sairContextoWeb();
	}
}
