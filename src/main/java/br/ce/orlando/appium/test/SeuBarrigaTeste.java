package br.ce.orlando.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.orlando.appium.core.BaseTest;
import br.ce.orlando.appium.page.MenuPage;
import br.ce.orlando.appium.page.seuBarriga.SeuBarrigaContasPage;
import br.ce.orlando.appium.page.seuBarriga.SeuBarrigaLoginPage;
import br.ce.orlando.appium.page.seuBarriga.SeuBarrigaMenuPage;

public class SeuBarrigaTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private SeuBarrigaLoginPage loginPage = new SeuBarrigaLoginPage();
	private SeuBarrigaMenuPage menuSB = new SeuBarrigaMenuPage();
	private SeuBarrigaContasPage contas = new SeuBarrigaContasPage();
	
	@Before
	public void setup() {
		menu.acessarSeuBarrigaNativo();
		loginPage.setEmail("beach@park");
		loginPage.setSenha("onda");
		loginPage.entrar();
	}
	
	@Test
	public void deveInserirConta() {
		//entrar em contas
		menuSB.acessarContas();
		
		
		//digitar nome conta
		contas.setConta("Conta de Teste");
		
		//salvar
		contas.salvar();
		
		//verificar mensagem
		Assert.assertTrue(contas.existeElementoPorTexto("Conta adicionada com sucesso"));
	}
	
}
