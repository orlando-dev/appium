package br.ce.orlando.appium.page;

import br.ce.orlando.appium.core.BasePage;

public class MenuPage extends BasePage{
	
	public void acessarFormulario() {
		clicarPorTexto("Formul�rio");
	}
	
	public void acessarSplash() {
		clicarPorTexto("Splash");
	}
}
