package br.ce.orlando.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.orlando.appium.core.BaseTest;
import br.ce.orlando.appium.page.AccordionPage;
import br.ce.orlando.appium.page.MenuPage;

public class AccordionTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AccordionPage page = new AccordionPage();
	@Test
	public void deveInteragirComAccordion() throws InterruptedException {
		//acessar menu
		menu.acessarAccordion();
		
		//clicar opcao 1
		page.selecionarOpcao1();
		
		//verificar texto da opcao 1
		Thread.sleep(1000);
		Assert.assertEquals("Esta é a descrição da opção 1", page.obterValorOpcao1());
		
	}
}
