package br.ce.orlando.appium.page;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;

import br.ce.orlando.appium.core.DSL;
import br.ce.orlando.appium.core.DriverFactory;

public class MenuPage {
	private DSL dsl = new DSL();
	
	@Before
	public void inicializarAppium() throws MalformedURLException{
		//selcionar formulario
		dsl.clicarPorTexto("Formulário");
	}
	
	@After
	public void tearDown() {
		DriverFactory.killDriver();
	}

	public void acessarFormulario() {
		dsl.clicarPorTexto("Formulário");
	}
	
	
}
