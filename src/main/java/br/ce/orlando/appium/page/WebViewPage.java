package br.ce.orlando.appium.page;

import static br.ce.orlando.appium.core.DriverFactory.getDriver;

import java.util.Set;

import org.openqa.selenium.By;

import br.ce.orlando.appium.core.BasePage;

public class WebViewPage extends BasePage {
	
	public void entrarContextoWeb() {
		Set<String> contextHandles = getDriver().getContextHandles();
		for(String valor: contextHandles) {
			System.out.println(valor);
		}
		//Entra no contexto Web[1]
		getDriver().context((String) contextHandles.toArray()[1]);
	}
	
	public void sairContextoWeb() {
		//Sai do contexto web para entrar no app nativo[0]
		getDriver().context((String) getDriver().getContextHandles().toArray()[0]);
	}
	
	public void setEmail(String email) {
		getDriver().findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(email);
		
		//versão mais recente não tem mais a busca por id, 
		//mas tem uma saída utilizando o xpath
//		getDriver().findElement(By.id("email")).sendKeys(valor);
	}
	
	public void setSenha(String senha) {
		getDriver().findElement(By.xpath("//*[@id=\"senha\"]")).sendKeys(senha);
	}
	
	public void entrar() {
		clicar(By.xpath("//button[@type='submit']"));
	}
	
	public String getMensagem() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
}
