package br.com.comex.modelo;

import java.text.NumberFormat;

import CalculadoraValorTotal.CalculadoraValorTotal;
import CalculadoraValorTotal.ValorTotal;

public class ItemPedido extends CalculadoraValorTotal implements ValorTotal {
	
	private int id;
	private double precoUnitario; //Esse cara deve receber o valor na data do pedido
	private int quantidade;
	private Produto produto; //Produto em que foi comprado
	private Pedido pedido; //Esse cara vai receber o id do pedido 
	private double desconto;
	private String tipoDeDesconto;
	private static int count = 1;
	
	public ItemPedido(double precoUnitario, int quantidade, Produto produto, Pedido pedido, double desconto, String tipoDeDesconto) {
		this.id = count++; 
		this.precoUnitario = precoUnitario; 
		this.quantidade = quantidade;
		this.produto = produto;
		this.pedido = pedido;
		this.desconto = desconto;
		this.tipoDeDesconto = tipoDeDesconto;
		
	}
	
	public int getId() {
		return id;
	}
	public double getPrecoUnitario() {
		return precoUnitario;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public Produto getProduto() {
		return produto;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public double getDesconto() {
		return desconto;
	}
	public String getTipoDeDesconto() {
		return tipoDeDesconto;
	}
	
	public double totalSemDesconto() {
		double total = this.getPrecoUnitario() * this.quantidade;
		NumberFormat.getCurrencyInstance().format(total);
		return total;
	}
	
	public double calculoDesconto(){
		double total;
		double totalSemDesconto = this.totalSemDesconto();
		
		if (this.tipoDeDesconto == "QUANTIDADE" && this.quantidade > 10) {
			total = this.desconto + (totalSemDesconto * 0.1);
			NumberFormat.getCurrencyInstance().format(total);
			return total;
		} else if (this.tipoDeDesconto == "PROMOCAO") {
			total = this.desconto + (totalSemDesconto * 0.2);
			NumberFormat.getCurrencyInstance().format(total);
			return total;
		} else {
			total = 0;
			return total;
		}		
	}
	
	public double precoComDesconto() {
		double total = this.totalSemDesconto() - this.calculoDesconto();
		NumberFormat.getCurrencyInstance().format(total);
		return total;
	}
	

	
	@Override
	public String toString() {
		return "\n ------------------ ItemPedido: ------------------\n"
				+ "\n id= " + id  
				+ "\n\n Preço Unitário: " + precoUnitario
				+"\n\n quantidade= " + quantidade 
				+ "\n " + produto 
				+ "\n " + pedido
				+ "\n desconto= " + desconto 
				+ "\n tipoDeDesconto= " + tipoDeDesconto 
				+ "\n preco total sem descontos:" + totalSemDesconto() 
				+ "\n calcula desconto: " + calculoDesconto() 
				+ "\n Preco Total com Descontos:" + precoComDesconto() + "\n\n";
	}
	
	
	
	

}
