package br.com.k21;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculadoraComissao {

	public BigDecimal calcularComissao(BigDecimal valorVenda){
		if (valorVenda.intValue() > 10000) {
			BigDecimal result = valorVenda.multiply(new BigDecimal("0.06"));
			result.setScale(2, RoundingMode.HALF_EVEN);
			return result;
		} else {
			BigDecimal result = valorVenda.multiply(new BigDecimal("0.05"));
			result.setScale(2, RoundingMode.HALF_EVEN);
			return result;
		}
	}
}
