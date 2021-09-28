package br.ce.orlando.appium.page;

import org.openqa.selenium.By;

import br.ce.orlando.appium.core.BasePage;
import br.ce.orlando.appium.core.DriverFactory;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;

public class CliquesPage extends BasePage {
	
	public void cliqueLongo() {
		new TouchAction<>(DriverFactory.getDriver())
			.longPress(ElementOption.element(DriverFactory.getDriver()
				.findElement(By.xpath("//*[@text='Clique Longo']")))).perform();
	}
	
	public void cliqueDuplo() {
		clicarPorTexto("Clique duplo");
		clicarPorTexto("Clique duplo");
	}
	
	public String obterTextoCampo() {//entre parenteses ele vai buscar todos
		return DriverFactory.getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
	}
	
}
