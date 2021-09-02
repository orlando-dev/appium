package br.ce.orlando.appium.test;

import static br.ce.orlando.appium.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.orlando.appium.core.BaseTest;
import br.ce.orlando.appium.page.FormularioPage;
import br.ce.orlando.appium.page.MenuPage;

public class FormularioTest extends BaseTest {
		
	private MenuPage menu = new MenuPage();
	private FormularioPage page = new FormularioPage();
	
	@Before
	public void inicializarAppium() throws MalformedURLException, InterruptedException {
		
		Thread.sleep(1000);
		menu.acessarFormulario();
		Thread.sleep(1000);
	}
	
	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		page.escreverNome("Orlando");
		
	    assertEquals("Orlando", page.obterNome());

	}

	
	@Test
	public void deveInteragirCombo() throws MalformedURLException, InterruptedException {
		
	    page.selecionarCombo("XBox One");
	   
		
		Assert.assertEquals("XBox One", page.obterValorCombo());
	    
	}
	
	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {
		
	    Assert.assertFalse(page.isCheckMarcado());
	    Assert.assertTrue(page.isSwitchMarcado());
	    
	    page.clicarCheck();
	    page.clicarSwitch();
	    
	    Assert.assertTrue(page.isCheckMarcado());
	    Assert.assertFalse(page.isSwitchMarcado());
	    
	}
	
	@Test
	public void deveRealizarCadastro() throws MalformedURLException, InterruptedException {
		
		page.escreverNome("Orlando");
		page.clicarCheck();
		page.clicarSwitch();
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='XBox One]'")));
		page.selecionarCombo("XBox One");
	   
	    page.salvar();
	    
	    Assert.assertEquals("Nome: Orlando", page.obterNomeCadastrado());
	    
	    Assert.assertEquals("Console: xone", page.obterConsoleCadastrado());
	    
	    Assert.assertTrue(page.obterCheckCadastrado().endsWith("Off"));
	    
	    Assert.assertTrue(page.obterSwitchCadastrado().endsWith("Marcado"));
	    
	}
}
