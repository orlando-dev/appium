package br.ce.orlando.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.orlando.appium.core.BaseTest;
import br.ce.orlando.appium.page.AbasPage;
import br.ce.orlando.appium.page.MenuPage;

public class AbasTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	public AbasPage page = new AbasPage();
	
	@Test
	public void deveInteragirComAbas() {
		//acessar menu abas
		menu.acessarAbas();
		
		//verificar que esta na aba 1
		Assert.assertTrue(page.isAba1());
		//acessar aba 2
		page.selecionarAba2();
		
		//verificar que está na aba 2
		Assert.assertTrue(page.isAba2());
	}
}
