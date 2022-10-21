package br.com.comex.modelo;

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
	private Tipo tipo;
	private int categoria_id;
	private static int count = 1;
	
	
	public Produto(int id, String nome, double precoUnitario, int quantidadeEmEstoque, Categoria categoria) {
		
		if (id <= 0) {
			throw new IllegalArgumentException("Error: Id deve ser maior que zero !!!"); 
		} 
		if (nome.length() <= 5) {
			throw new IllegalArgumentException("Error: nome deve ter mais que 5 caracteres !!! \n:");
		} 
		if (precoUnitario <= 0) {
			throw new IllegalArgumentException("Error: Preço Unitário igual ou menor que 0 !!!"); 
		} 
		if (quantidadeEmEstoque <= 0) {
			throw new IllegalArgumentException("Error: Quantidade em Estoque deve ser maior que zero !!!"); 
		} 
		if (categoria == null ){
			throw new IllegalArgumentException("Error: Categoria não pode ser NULL !!!"); 
		} 
		
		if (!nome.substring(0, 1).matches("[A-Z]*")) {
			throw new IllegalArgumentException("Nome não pode inicializar com números: " + nome); 
		}
		
		if (id != count) {
			throw new IllegalArgumentException("O id informado é diferente do próximo id "); 
		}
		
		this.id = id;
		this.nome = nome;
		this.precoUnitario = precoUnitario;
		this.quantidadeEmEstoque = quantidadeEmEstoque;
		this.categoria = categoria;
	}
	
	public Produto(String nome, double precoUnitario, int quantidadeEmEstoque, Categoria categoria) {
		this.id = count++;
		this.nome = nome;
		this.precoUnitario = precoUnitario;
		this.quantidadeEmEstoque = quantidadeEmEstoque;
		this.categoria = categoria;
		
		if (nome.length() <= 5) {
			throw new IllegalArgumentException("Error: nome deve ter mais que 5 caracteres !!! \n:");
		} 
		if (precoUnitario <= 0) {
			throw new IllegalArgumentException("Error: Preço Unitário igual ou menor que 0 !!!"); 
		} 
		if (quantidadeEmEstoque <= 0) {
			throw new IllegalArgumentException("Error: Quantidade em Estoque deve ser maior que zero !!!"); 
		} 
		if (categoria == null ){
			throw new IllegalArgumentException("Error: Categoria não pode ser NULL !!!"); 
		} 
		
		if (!nome.substring(0, 1).matches("[A-Z]*")) {
			throw new IllegalArgumentException("Nome não pode inicializar com números: " + nome); 
		}
	}
	
	public Produto(String nome, String descricao, double precoUnitario, int quantidadeEmEstoque, int categoria_id, Tipo tipo) {
		this.nome = nome;
		this.descricao = descricao;
		this.precoUnitario = precoUnitario;
		this.quantidadeEmEstoque = quantidadeEmEstoque;
		this.categoria_id = categoria_id;
		this.tipo = tipo;
	}
	
	public Produto(int id, String nome, String descricao, double precoUnitario, int quantidadeEmEstoque, int categoria_id, Tipo tipo) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.precoUnitario = precoUnitario;
		this.quantidadeEmEstoque = quantidadeEmEstoque;
		this.categoria_id = categoria_id;
		this.tipo = tipo;
	}
	
	public enum Tipo{
		ISENTO, NAO_ISENTO
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	public Tipo getTipo() {
		return tipo;
	}
	
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	public int getCategoria_id() {
		return categoria_id;
	}
	
	public void setCategoria_id(int categoria_id) {
		this.categoria_id = categoria_id;
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
				//+ " Id: " + id + " \n"
				+ " Nome: " + nome + " \n"
				+ " Descrição: " + descricao + " \n"
				+ " Preço unitario: " + precoUnitario + " \n"
				+ " Quantidade no estoque: " + quantidadeEmEstoque + " \n"
				//+ " Categoria: " + categoria.getNome()+ " \n"
				+ " Categoria_id: " + categoria_id + " \n"
				+ " Tipo: " + tipo + "\n"
				+ " Valor Total em Estoque: " + valorTotalEstoque() + " \n"
				+ " Imposto: " + calculaImposto() + "\n \n";
	}

}
