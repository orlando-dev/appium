package br.ce.orlando.appium.page;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;

import br.ce.orlando.appium.core.BasePage;
import br.ce.orlando.appium.core.DSL;
import br.ce.orlando.appium.core.DriverFactory;

public class MenuPage extends BasePage{
	
//	@Before
//	public void inicializarAppium() throws MalformedURLException{
//		//selcionar formulario
//		clicarPorTexto("Formulário");
//	}

	public void acessarFormulario() {
		clicarPorTexto("Formulário");
	}
	
	
}
