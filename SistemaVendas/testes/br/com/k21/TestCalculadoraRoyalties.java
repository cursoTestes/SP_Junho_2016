package br.com.k21;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import br.com.k21.dao.VendaRepository;
import br.com.k21.modelo.Venda;

public class TestCalculadoraRoyalties {

	VendaRepository vendaRepository;
	
	CalculadoraComissao calculadoraComissao;
	
	@Before
	public void inicializaMocks(){
		vendaRepository = mock(VendaRepository.class);
		calculadoraComissao = mock(CalculadoraComissao.class);
	}
	
	@Test
	public void calcularMesSemVendas() {
		BigDecimal valorEsperado = new BigDecimal("0.0");
		valorEsperado.setScale(2, RoundingMode.HALF_UP);
		int mes = 1;
		int ano = 2016;
		when(vendaRepository.
				obterVendasPorMesEAno
				(anyInt(), anyInt())).thenReturn(new ArrayList<Venda>());
		
		CalculadoraRoyalties calculadora = 
			new CalculadoraRoyalties(vendaRepository, calculadoraComissao);
		
		
		BigDecimal valorRetornado = 
			calculadora.calcular(mes, ano);

		assertEquals(valorEsperado, valorRetornado);
	}

	@Test
	public void calcularMesCom1Venda() {
		BigDecimal valorEsperado = new BigDecimal("190.000");
		valorEsperado.setScale(2, RoundingMode.HALF_UP);
		int mes = 2;
		int ano = 2016;
		
		ArrayList<Venda> vendas = new ArrayList<Venda>();
		Venda venda = new Venda(0, 1, mes, ano, new BigDecimal("1000.00"));
		vendas.add(venda);
		
		when(vendaRepository
			.obterVendasPorMesEAno(anyInt(), anyInt())).thenReturn(vendas);

		when(calculadoraComissao.calcularComissao(any(BigDecimal.class)))
			.thenReturn(new BigDecimal("50.00"));		
		
		CalculadoraRoyalties calculadora = 
			new CalculadoraRoyalties(vendaRepository, calculadoraComissao);
		
		BigDecimal valorRetornado = 
			calculadora.calcular(mes, ano);

		assertEquals(valorEsperado, valorRetornado);
	}
	
	@Test
	public void calcularMesCom2Vendas() {
		BigDecimal valorEsperado = new BigDecimal("2400.000");
		valorEsperado.setScale(2, RoundingMode.HALF_UP);
		int mes = 3;
		int ano = 2016;
		
		ArrayList<Venda> vendas = new ArrayList<Venda>();
		Venda venda = new Venda(0, 1, mes, ano, new BigDecimal("1000.00"));
		Venda venda2 = new Venda(1, 2, mes, ano, new BigDecimal("11000.00"));

		vendas.add(venda);
		vendas.add(venda2);
		when(vendaRepository
				.obterVendasPorMesEAno(anyInt(), anyInt())).thenReturn(vendas);

			when(calculadoraComissao.calcularComissao(any(BigDecimal.class)))
				.thenReturn(new BigDecimal("0.00"));		
			
		CalculadoraRoyalties calculadora = 
				new CalculadoraRoyalties(vendaRepository, calculadoraComissao);
		
		BigDecimal valorRetornado = 
			calculadora.calcular(mes, ano);

		assertEquals(valorEsperado, valorRetornado);
		
		verify(calculadoraComissao,times(2)).calcularComissao(any(BigDecimal.class));
	}
}
