package br.ce.orlando.appium.page;

import org.openqa.selenium.By;

import br.ce.orlando.appium.core.BasePage;

public class AccordionPage extends BasePage {
	
	public void selecionarOpcao1() {
		clicarPorTexto("Opção 1");
	}
	
	public String obterValorOpcao1() {
		return obterTexto(By.xpath("//*[@text='Opção 1']/../../following-sibling::android.view.ViewGroup//android.widget.TextView"));
	}
}
