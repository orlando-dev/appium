package br.ce.orlando.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FormularioTest {
	
	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP, "I:/Repositório/TestesSoftware/appium/src/main/resources/CTAppium_1_2.apk");
				
		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //selecionar formulario
	    List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
	    elementosEncontrados.get(1).click();

//	    for(MobileElement elemento: elementosEncontrados) {
//	    	System.out.println(elemento.getText());
//	    }
	    
	    //escrever nome
	    MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
	    campoNome.sendKeys("Orlando");
	    
	    //checar nome escrito
	    String text = campoNome.getText();
	    Assert.assertEquals("Orlando", text);
	    driver.quit();
	}
	
	@Test
	public void deveInteragirCombo() throws MalformedURLException {
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP, "I:/Repositório/TestesSoftware/appium/src/main/resources/CTAppium_1_2.apk");
				
		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //selecionar formulario
		driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
		
	    //clicar no combo
	    driver.findElement(MobileBy.AccessibilityId("console")).click();
	    
	    //selecionar opcao desejada
	    driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='XBox One']")).click();
	    
	    //verificar opcao selecionada
	    String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
	    Assert.assertEquals("XBox One", text);
	    driver.quit();
	}
	
	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP, "I:/Repositório/TestesSoftware/appium/src/main/resources/CTAppium_1_2.apk");
				
		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //selecionar formulario
		driver.findElement(By.xpath("//*[@text='Formulário']")).click();
		
	    //Verificar status dos elementos
		MobileElement check = driver.findElement(By.className("android.widget.CheckBox"));
	    MobileElement switc = driver.findElement(MobileBy.AccessibilityId("switch"));
	    
	    Assert.assertTrue(check.getAttribute("checked").equals("false"));
	    Assert.assertTrue(switc.getAttribute("checked").equals("true"));
	    
	    //clicar nos elementos
	    check.click();
	    switc.click();
	    
	    //verificar estados alterados
	    Assert.assertFalse(check.getAttribute("checked").equals("false"));
	    Assert.assertFalse(switc.getAttribute("checked").equals("true"));
	    
	    driver.quit();
	}
}
