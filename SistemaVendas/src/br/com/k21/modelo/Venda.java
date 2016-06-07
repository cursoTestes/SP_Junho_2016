package br.com.k21.modelo;

import java.math.BigDecimal;

public class Venda {

	  public Venda(int id, int vendedor, int mes, int ano, BigDecimal valorVenda)
      {
          idVenda = id;
          idVendedor = vendedor;
          mesVenda = mes;
          anoVenda = ano;
          valor = valorVenda;
      }

      private  int idVenda ;
      private  int idVendedor; 
      private  int mesVenda ;
      private  int anoVenda ;
      private  BigDecimal valor ;
	
      
    public int getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}
	public int getIdVendedor() {
		return idVendedor;
	}
	public void setIdVendedor(int idVendedor) {
		this.idVendedor = idVendedor;
	}
	public int getMesVenda() {
		return mesVenda;
	}
	public void setMesVenda(int mesVenda) {
		this.mesVenda = mesVenda;
	}
	public int getAnoVenda() {
		return anoVenda;
	}
	public void setAnoVenda(int anoVenda) {
		this.anoVenda = anoVenda;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
    
      
}
