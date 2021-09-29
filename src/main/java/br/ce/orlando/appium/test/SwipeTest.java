package br.ce.orlando.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.orlando.appium.core.BaseTest;
import br.ce.orlando.appium.page.MenuPage;

public class SwipeTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	
	@Test
	public void deveRealizarSwipe() {
		//acessar menu
		menu.acessarSwipe();
		
		//verificar texto 'a esquerda'
		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));
		
		//swipe para a direita
		menu.swipeRight();
		
		//verificar o texto "E veja se"
		Assert.assertTrue(menu.existeElementoPorTexto("E veja se"));
		
		//clicar botao direita
		menu.clicarPorTexto("›");
		
		
		//verificar texto "Chegar ate o fim"
		Assert.assertTrue(menu.existeElementoPorTexto("Chegar até o fim!"));
		
		//swipe esquerda
		menu.swipeLeft();
		
		//clicar botao esquerda
		menu.clicarPorTexto("‹");
		
		//verificar texto 'a esquerda'
		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));
	}
}
