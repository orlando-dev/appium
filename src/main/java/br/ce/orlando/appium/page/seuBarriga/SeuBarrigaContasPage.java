package br.ce.orlando.appium.page.seuBarriga;

import org.openqa.selenium.By;

import br.ce.orlando.appium.core.BasePage;

public class SeuBarrigaContasPage extends BasePage {
	
	public void setConta(String nome) {
		escrever(By.xpath("//*[@text='Conta']"), nome);
	}
	
	public void salvar() {
		clicarPorTexto("SALVAR");
	}
}
