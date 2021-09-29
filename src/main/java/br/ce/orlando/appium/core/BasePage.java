package br.ce.orlando.appium.core;

import static br.ce.orlando.appium.core.DriverFactory.getDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage {
	
	
	public void escrever(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);
	}
	
	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public void clicar(By by) {
		getDriver().findElement(by).click();
	}
	
	public void clicarPorTexto(String texto) {
		clicar(By.xpath("//*[@text='"+texto+"']"));
	}
	
	public void selecionarCombo(By by, String valor) throws InterruptedException {
		getDriver().findElement(by).click();
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='"+valor+"']")));
		clicarPorTexto(valor);
	}
	
	public boolean isCheckMarcado(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals("true");
	}
	
//	public boolean existeElementoPorTexto(String texto) {
//		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='"+texto+"']")));
//		List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='"+texto+"']"));
//		return elementos.size() > 0;
//	}
	
	public boolean existeElementoPorTexto(String texto) {
		List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='"+texto+"']"));
		return elementos.size() > 0;
	}
	
	public String obterTituloAlerta() {
		return obterTexto(By.id("android:id/alertTitle"));
	}
	
	public String obterMensagemAlerta() {
		return obterTexto(By.id("android:id/message"));
	}
	
//	public void tap(int x, int y) {
//		TouchAction touchAction = new TouchAction(DriverFactory.getDriver());
//		touchAction.tap(PointOption.point(x, y)).perform();
//	}
	public void tap(int x, int y) {
		new TouchAction<>(getDriver()).tap(PointOption.point(new Point(x, y))).perform();
	}
	
	public void esperar(int tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void scrollDown() {
		scroll(0.9, 0.1);
	}
	
	public void scrollUp() {
		scroll(0.1, 0.9);
	}
	
	public void swipeLeft() {
		swipe(0.1, 0.9);
	}
	
	public void swipeRight() {
		swipe(0.9, 0.1);
	}
	
	public void scroll(double inicio, double fim) {
		Dimension size = getDriver().manage().window().getSize();
		
		int x = size.width / 2;
		
		int start_y = (int) (size.height * inicio);
		int end_y = (int) (size.height * fim);
		
//		TouchAction dragNDrop = new TouchAction(getDriver())
//				.press(PointOption.point(x,start_y))
//				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
//				.moveTo(PointOption.point(x, end_y))
//				.release();
//				dragNDrop.perform();
		
		new TouchAction<>(getDriver())
		.press(PointOption.point(new Point(x, start_y)))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
		.moveTo(PointOption.point(new Point(x, end_y)))
		.release()
		.perform();
	}
	
	public void swipe(double inicio, double fim) {
		Dimension size = getDriver().manage().window().getSize();
		
		int y = size.height / 2;
		
		int start_x = (int) (size.width * inicio);
		int end_x = (int) (size.width * fim);
		
		new TouchAction<>(getDriver())
		.press(PointOption.point(new Point(start_x, y)))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
		.moveTo(PointOption.point(new Point(end_x, y)))
		.release()
		.perform();
	}
	
	public void swipeElement(MobileElement element, double inicio, double fim) {
		int y  = element.getLocation().y + (element.getSize().height / 2);
		
		int start_x = (int) (element.getSize().width * inicio);
		int end_x = (int) (element.getSize().width * fim);
		
		new TouchAction<>(getDriver())
		.press(PointOption.point(new Point(start_x, y)))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
		.moveTo(PointOption.point(new Point(end_x, y)))
		.release()
		.perform();
	}
	
	public void cliqueLongo(By by) {
		new TouchAction<>(DriverFactory.getDriver())
			.longPress(PointOption.point(DriverFactory.getDriver()
			.findElement(by).getCenter()))
			.perform();
	}
	
}
