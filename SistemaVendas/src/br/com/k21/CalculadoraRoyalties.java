package br.com.k21;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import br.com.k21.dao.VendaRepository;
import br.com.k21.modelo.Venda;

public class CalculadoraRoyalties {

	private VendaRepository vendasRepository;
	private CalculadoraComissao calculadoraComissao;
	
	public CalculadoraRoyalties(VendaRepository vendaRepository,
			CalculadoraComissao calculadoraComissao) {
		this.vendasRepository = vendaRepository;
		this.calculadoraComissao = calculadoraComissao;
	}
	
	public BigDecimal calcular(int mes, int ano) {
		List<Venda> vendasDoMes = vendasRepository.obterVendasPorMesEAno(mes, ano);
		BigDecimal totalDeComissoes = new BigDecimal(0);
		BigDecimal totalDeVendas = new BigDecimal(0);
		
		for(Venda venda : vendasDoMes) {
			totalDeVendas =
					totalDeVendas.add(venda.getValor());
			totalDeComissoes = new BigDecimal(0);
	//				totalDeComissoes.add(calculadoraComissao.calcularComissao(venda.getValor()));
		}
		
		BigDecimal royalty = totalDeVendas//
				.subtract(totalDeComissoes)//
				.multiply(new BigDecimal("0.2"));
		
		royalty.setScale(2, RoundingMode.HALF_UP);

		return royalty;
		
		
	}

}
