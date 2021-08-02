package br.ce.orlando.appium;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.ce.orlando.appium.core.DSL;
import br.ce.orlando.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;

public class FormularioTest {
	
	private DSL dsl = new DSL();
	
	@Before
	public void inicializarAppium() throws MalformedURLException, InterruptedException {
		
		Thread.sleep(1000);
		dsl.clicarPorTexto("Formulário");
	}
	
	@After
	public void tearDown() {
		DriverFactory.killDriver();
	}
	
	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		//escrever nome
	    dsl.escrever(MobileBy.AccessibilityId("nome"), "Orlando");
		
	    //checar nome escrito
	    assertEquals("Orlando", dsl.obterTexto(MobileBy.AccessibilityId("nome")));

	}

	
	@Test
	public void deveInteragirCombo() throws MalformedURLException {
		
	    //clicar no combo
		dsl.selecionarCombo(MobileBy.AccessibilityId("console"), "XBox One");
	   
		
		//verificar opcao selecionada
	    String text = dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
	    Assert.assertEquals("XBox One", text);
	    
	}
	
	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {
		
	    //Verificar status dos elementos
		Assert.assertFalse(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
	    Assert.assertTrue(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));
	    
	    //clicar nos elementos
	    dsl.clicar(By.className("android.widget.CheckBox"));
	    dsl.clicar(MobileBy.AccessibilityId("switch"));
	    
	    //verificar estados alterados
	    Assert.assertTrue(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
	    Assert.assertFalse(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));
	    
	}
	
	@Test
	public void deveRealizarCadastro() throws MalformedURLException {
		
		//Preencher campos 
		dsl.escrever(MobileBy.AccessibilityId("nome"), "Orlando");
		dsl.clicar(By.className("android.widget.CheckBox"));
	    dsl.clicar(MobileBy.AccessibilityId("switch"));
	    dsl.selecionarCombo(MobileBy.AccessibilityId("console"), "XBox One");
	   
	    //Salvar
	    dsl.clicarPorTexto("SALVAR");
	    	    
	    //Validando cadastro no resultado final
	    Assert.assertEquals("Nome: Orlando", dsl.obterTexto(By.xpath("//android.widget.TextView[@text='Nome: Orlando']")));
	    
	    Assert.assertEquals("Console: xone", dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]")));
	    
	    Assert.assertTrue(dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]")).endsWith("Off"));
	    
	    Assert.assertTrue(dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]")).endsWith("Marcado"));
	    
	}
}
