package br.com.k21;

import org.fluentlenium.adapter.FluentTest;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class CadastroDeUtilizadorInterfaceTest extends FluentTest {
	
	@Override
	public WebDriver getDefaultDriver() {
		return new ChromeDriver();
	}
	
	@Test
	public void comprarModerninha() {
		
		abrirPaginaCadastro();
		
		click("#buy-btn");
		
		selecionarOperadoraClaroEUmaModerninha();
		
		realizarLogin();
		
		
		executeScript("$('#paymentMethod_booklet').click();");
		
		Assert.assertEquals("Tarifa de boleto = R$ 1,00", findFirst("#bookletTax").getText());
		
		Assert.assertEquals("719,80", findFirst("#cartTotalAmount").getText());
		
		click("#continueToPayment");
		
		Assert.assertEquals("Aguardando confirmação do pagamento.", 
				findFirst("#successMessage").getText());
		
		//729.521.571-97
		
	
	}

	private void selecionarOperadoraClaroEUmaModerninha() {
		fillSelect("#network-operator").withValue("1");
		
		click("#reader-qtd-button");
	}

	private void realizarLogin() {
		fill("#email-input").with("bolonha@mailinator.com");
		
		click("#continue");
		
		fill("#password-input").with("PS654321");
		
		click("#continue");

	}

	private void abrirPaginaCadastro() {
		goTo("https://pagseguro.uol.com.br/");
	}
	
}
