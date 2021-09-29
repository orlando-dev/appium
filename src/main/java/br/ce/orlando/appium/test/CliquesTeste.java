package br.ce.orlando.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.ce.orlando.appium.core.BaseTest;
import br.ce.orlando.appium.page.CliquesPage;
import br.ce.orlando.appium.page.MenuPage;

public class CliquesTeste extends BaseTest {
	
	private static MenuPage menu = new MenuPage();
	private CliquesPage page = new CliquesPage();
	
	@BeforeClass
	public void setup() {
		menu.acessarCliques();
	}
	
	@Test
	public void deveRealizarCliqueLongo() {
		
		//clique longo
		page.cliqueLongo();
		
		//verificar texto
		Assert.assertEquals("Clique Longo", page.obterTextoCampo());
		
		
	}
	
	@Test
	public void deveRealizarCliqueDuplo() {
		//clique longo
		page.cliqueDuplo();
		
		//verificar texto
		Assert.assertEquals("Duplo Clique", page.obterTextoCampo());
		
		
	}
}
