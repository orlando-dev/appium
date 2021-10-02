package br.ce.orlando.appium.core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {
	
	@Rule
	public TestName testName = new TestName();
	
	@AfterClass
	public static void finalizaClasse() {
		DriverFactory.killDriver();
	}
	
	@After
	public void tearDown() {
		gerarScreenShot();
		DriverFactory.getDriver().resetApp();
	}
	
	public void gerarScreenShot() {
		try {
			File imageEvidence = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(imageEvidence, new File("target/screenshots/"+testName.getMethodName()+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void esperar(int tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
	}
}
