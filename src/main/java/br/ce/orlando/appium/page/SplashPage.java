package br.ce.orlando.appium.page;

import static br.ce.orlando.appium.core.DriverFactory.getDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.orlando.appium.core.BasePage;

public class SplashPage extends BasePage {
	
	public boolean isTelaSplashVisivel(){
		return existeElementoPorTexto("Splash!");
	}
	
	public void aguardarSplashSumir(){
		getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='Splash!']")));
	}
}
