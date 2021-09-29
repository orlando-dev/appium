package br.ce.orlando.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.orlando.appium.core.BaseTest;
import br.ce.orlando.appium.page.MenuPage;
import br.ce.orlando.appium.page.SwipeListPage;

public class SwipeElementTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private SwipeListPage page = new SwipeListPage();
	@Test
	public void deveResolverDesafioSwip() {
		menu.acessarSwipeList();
		
		page.swipeElementRight("Op��o 1");
		
		page.clicarBotaoMais();
		
		Assert.assertTrue(page.existeElementoPorTexto("Op��o 1 (+)"));
		
		page.swipeElementRight("Op��o 4");
		
		page.clicarPorTexto("(-)");
		
		Assert.assertTrue(page.existeElementoPorTexto("Op��o 4 (-)"));
		
		page.swipeElementLeft("Op��o 5 (-)");
		
		Assert.assertTrue(page.existeElementoPorTexto("Op��o 5"));
		
	}
}
