package br.ce.orlando.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.orlando.appium.core.BaseTest;
import br.ce.orlando.appium.page.DragDropPage;
import br.ce.orlando.appium.page.MenuPage;

public class DragNDropTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private DragDropPage page = new DragDropPage();
	
	private String[] estadoInicial = new String[]{"Esta", 
			"� uma lista", 
			"Drag em Drop!", 
			"Fa�a um clique longo,", 
			"e arraste para", 
			"qualquer local desejado.",
	};
	
	private String[] estadoIntermediario = new String[]{ 
			"� uma lista", 
			"Drag em Drop!", 
			"Fa�a um clique longo,", 
			"e arraste para",
			"Esta",
			"qualquer local desejado.",
	};
	
	private String[] estadoFinal = new String[]{ 
			"Fa�a um clique longo,",
			"� uma lista", 
			"Drag em Drop!", 
			"e arraste para",
			"Esta",
			"qualquer local desejado.",
	};
	
	@Test
	public void deveEfetuarDragNDrop() {
		//acessar menu
		menu.acessarDragAndDrop();
		
		menu.esperar(1000);
		Assert.assertArrayEquals(estadoInicial, page.obterLista());
		
		page.arrastar("Esta", "e arraste para");
		
		Assert.assertArrayEquals(estadoIntermediario, page.obterLista());
		
		page.arrastar("Fa�a um clique longo,", "� uma lista");

		Assert.assertArrayEquals(estadoFinal, page.obterLista());
	}
}
