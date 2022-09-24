package Comex;

import java.text.NumberFormat;

import CalculadoraValorTotal.CalculadoraValorTotal;
import CalculadoraValorTotal.ValorTotal;


public class Produto extends CalculadoraValorTotal implements ValorTotal{
	
	private int id;
	private String nome;
	private String descricao;
	private double precoUnitario;
	private int quantidadeEmEstoque;
	private Categoria categoria;
	private static int count = 1;
	
	
	public Produto() {
		this.id = count++;
	}
	
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	public int getQuantidadeEmEstoque() {
		return quantidadeEmEstoque;
	}
	public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public double valorTotalEstoque() {
		double total = this.getQuantidadeEmEstoque() * this.getPrecoUnitario();
		NumberFormat.getCurrencyInstance().format(total);
		return total;
	}
	
	public String calculaImposto(){	
		return NumberFormat.getCurrencyInstance().format(getPrecoUnitario() * 0.4);
	}
	
	@Override
	public String toString() {
		return "\n Produto: \n" 
				+ " Id: " + id + " \n"
				+ " Nome: " + nome + " \n"
				+ " Descrição: " + descricao + " \n"
				+ " Preço unitario: " + precoUnitario + " \n"
				+ " Quantidade no estoque: " + quantidadeEmEstoque + " \n"
				+ " Categoria: " + categoria.getNome()+ " \n"
				+ " Valor Total em Estoque: " + valorTotalEstoque() + " \n"
				+ " Imposto: " + calculaImposto() + "\n \n";
	}











		
	
	
}
