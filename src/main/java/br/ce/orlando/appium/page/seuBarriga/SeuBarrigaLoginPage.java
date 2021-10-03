package br.ce.orlando.appium.page.seuBarriga;

import org.openqa.selenium.By;

import br.ce.orlando.appium.core.BasePage;

public class SeuBarrigaLoginPage extends BasePage {
	
	public void setEmail(String email) {
		escrever(By.xpath("//*[@text='Nome']"), email);
	}
	
	public void setSenha(String senha) {
		escrever(By.xpath("//*[@text='Senha']"), senha);
	}
	
	public void entrar(){
		clicarPorTexto("ENTRAR");
	}
}
