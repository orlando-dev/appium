package br.ce.orlando.appium.page;

import br.ce.orlando.appium.core.BasePage;

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
