package br.ce.orlando.appium.page;

import org.openqa.selenium.By;

import br.ce.orlando.appium.core.BasePage;
import br.ce.orlando.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class FormularioPage extends BasePage{
	
	 public void escreverNome(String nome) {
		escrever(MobileBy.AccessibilityId("nome"), nome);
	}
	
	public String obterNome() {
		return obterTexto(MobileBy.AccessibilityId("nome"));
	}
	
	public void selecionarCombo(String valor) throws InterruptedException {
		selecionarCombo(MobileBy.AccessibilityId("console"), valor);
	}
	
	public String obterValorCombo() {
		return obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
	}
	
	public void clicarCheck() {
		clicar(By.className("android.widget.CheckBox"));
	}
	
	public void clicarSwitch() {
		clicar(MobileBy.AccessibilityId("switch"));
	}
	
	public boolean isCheckMarcado() {
		return isCheckMarcado(By.className("android.widget.CheckBox"));
	}
	
	public boolean isSwitchMarcado() {
		return isCheckMarcado(MobileBy.AccessibilityId("switch"));
	}
	
//	public void clicarSeekbar(double posicao) {
//		MobileElement seek = DriverFactory.getDriver().findElement(MobileBy.AccessibilityId("slid"));
//		int y = seek.getLocation().y + (seek.getSize().height / 2);
//		System.out.println("PosicaoSeek Y " + y);
//		
//		int x = (int) (seek.getLocation().x + (seek.getSize().width * posicao));
//		System.out.println("PosicaoSeek X " + x);
//		
//		tap(x,y);
//	}
	
	public void clicarSeekBar(double posicao) {

		MobileElement seek = DriverFactory.getDriver().findElement(MobileBy.AccessibilityId("slid"));

		int delta = 37;

		int xInicial = seek.getLocation().x + delta;
		int x = (int) (xInicial + (seek.getSize().width-2*delta)*posicao);
		System.out.println("PosicaoSeek X " + x);

		int y = (seek.getLocation().y) + (seek.getSize().height/2);
		System.out.println("PosicaoSeek Y " + y);
		
		tap(x, y);

		}
	
	public void salvar() {
		clicarPorTexto("SALVAR");
	}
	
	public String obterNomeCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome: ')]"));
	}
	
	public String obterConsoleCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
	}
	
	public String obterCheckCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
	}
	
	public String obterSwitchCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
	}
	
}
