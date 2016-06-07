package br.com.k21;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Assert;
import org.junit.Test;

public class TestCalculadoraComissao {
	
	
	
	@Test
	public void testa6porcento() {
		BigDecimal valorVenda = new BigDecimal("100000");
		valorVenda.setScale(2, RoundingMode.HALF_EVEN);
		BigDecimal valorEsperado = new BigDecimal("6000.00");
		valorEsperado.setScale(2, RoundingMode.HALF_EVEN);
		CalculadoraComissao calculadora = 
			new CalculadoraComissao();
		
		BigDecimal valorCalculado = calculadora
			.calcularComissao(valorVenda);
		
		assertEquals(valorEsperado, valorCalculado);
	}
	
	@Test
	public void testa6porcentoDecimal(){
		BigDecimal valorVenda = new BigDecimal("10001");
		valorVenda.setScale(2, RoundingMode.HALF_EVEN);
		BigDecimal valorEsperado = new BigDecimal("600.06");
		valorEsperado.setScale(2, RoundingMode.HALF_EVEN);
		
		CalculadoraComissao calculadora = new CalculadoraComissao();
		
		BigDecimal valorCalculado = calculadora
				.calcularComissao(valorVenda);
		
		assertEquals(valorEsperado, valorCalculado);
	}
	
	@Test
	public void testa5porcento() {
		BigDecimal valorVenda = new BigDecimal("5000");
		valorVenda.setScale(2, RoundingMode.HALF_EVEN);
		BigDecimal valorEsperado = new BigDecimal("250.00");
		valorEsperado.setScale(2, RoundingMode.HALF_EVEN);
		CalculadoraComissao calculadora = 
			new CalculadoraComissao();
		
		BigDecimal valorCalculado = calculadora
			.calcularComissao(valorVenda);
		
		assertEquals(valorEsperado, valorCalculado);

	}
	
	@Test
	public void testa5porcentoDecimal() {
		BigDecimal valorVenda = new BigDecimal("10000");
		valorVenda.setScale(2, RoundingMode.HALF_EVEN);
		BigDecimal valorEsperado = new BigDecimal("500.00");
		valorEsperado.setScale(2, RoundingMode.HALF_EVEN);
		CalculadoraComissao calculadora = 
			new CalculadoraComissao();
		
		BigDecimal valorCalculado = calculadora
			.calcularComissao(valorVenda);
		
		assertEquals(valorEsperado, valorCalculado);

	}

	
}
