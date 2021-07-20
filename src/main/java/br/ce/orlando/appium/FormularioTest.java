package br.ce.orlando.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FormularioTest {
	
	private AndroidDriver<MobileElement> driver;
	
	@Before
	public void inicializarAppium() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP, "I:/Repositório/TestesSoftware/appium/src/main/resources/CTAppium_1_2.apk");
		
		driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
		
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		
		//escrever nome
	    MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
	    campoNome.sendKeys("Orlando");
	    
	    //checar nome escrito
	    String text = campoNome.getText();
	    Assert.assertEquals("Orlando", text);
	    
	}

	
	@Test
	public void deveInteragirCombo() throws MalformedURLException {
	
	    //clicar no combo
	    driver.findElement(MobileBy.AccessibilityId("console")).click();
	    
	    //selecionar opcao desejada
	    driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='XBox One']")).click();
	    
	    //verificar opcao selecionada
	    String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
	    Assert.assertEquals("XBox One", text);
	    
	}
	
	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {
		
	    //Verificar status dos elementos
		MobileElement check = driver.findElement(By.className("android.widget.CheckBox"));
	    MobileElement switc = driver.findElement(MobileBy.AccessibilityId("switch"));
	    
	    Assert.assertTrue(check.getAttribute("checked").equals("false"));
	    Assert.assertTrue(switc.getAttribute("checked").equals("true"));
	    
	    //clicar nos elementos
	    check.click();
	    switc.click();
	    
	    //verificar estados alterados
	    Assert.assertTrue(check.getAttribute("checked").equals("false"));
	    Assert.assertTrue(switc.getAttribute("checked").equals("true"));
	    
	}
	
	@Test
	public void deveRealizarDesafio() throws MalformedURLException {
		
		//Preencher campos 
		driver.findElement(MobileBy.AccessibilityId("nome")).sendKeys("Orlando");
	    driver.findElement(By.className("android.widget.CheckBox")).click();
	    driver.findElement(MobileBy.AccessibilityId("switch")).click();
	    driver.findElement(MobileBy.AccessibilityId("console")).click();
	    driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='XBox One']")).click();
	   
	    //Salvar
	    driver.findElement(By.xpath("//android.widget.TextView[@text='SALVAR']")).click();
	    	    
	    //Validando cadastro no resultado final
	    MobileElement nome = driver.findElement(By.xpath("//android.widget.TextView[@text='Nome: Orlando']"));
	    Assert.assertEquals("Nome: Orlando", nome.getText());
	    
	    MobileElement combo = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
	    Assert.assertEquals("Console: xone", combo.getText());
	    
	    MobileElement switc = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
	    Assert.assertTrue(switc.getText().endsWith("Off"));
	    
	    MobileElement check = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
	    Assert.assertTrue(check.getText().endsWith("Marcado"));
	    
	}
}
