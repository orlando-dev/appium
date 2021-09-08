package br.ce.orlando.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.orlando.appium.core.BaseTest;
import br.ce.orlando.appium.page.AlertaPage;
import br.ce.orlando.appium.page.MenuPage;


public class AlertTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AlertaPage page = new AlertaPage();
	
	@Before
	public void setup() {
		menu.acessarAlertas();
	}
	
	@Test
	public void deveConfirmarAlerta() {
		//acessar menu Alerta
//		menu.acessarAlertas();
//		
		//clicar em alerta confirm
		page.clicarAlertaConfirm();
		
		//verificar os textos
		Assert.assertEquals("Info", page.obterTituloAlerta());
		Assert.assertEquals("Confirma a operação?", page.obterMensagemAlerta());
		
		//confirmar alerta
		page.confirmar();
		
		//verificar nova mensagem
		page.esperar(1000);
		Assert.assertEquals("Confirmado", page.obterMensagemAlerta());
		
		//sair
		page.sair();
	}
	
	@Test
	public void deveClicarForaAlerta() {
		//clicar alerta simples
		page.clicarAlertaSimples();
		
		//clicar fora da caixa
		page.clicarForaCaixa();
		
		//verificar que a mensagem não está presente
		Assert.assertFalse(page.existeElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));
	}
}
