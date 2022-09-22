package Comex;

import java.text.NumberFormat;

public class Produto {
	
	private int id;
	private String nome;
	private String descricao;
	private double precoUnitario;
	private int quantidadeEmEstoque;
	private Categoria categoria;
	
	
	public double valorTotalEstoque() {
		double total = this.getQuantidadeEmEstoque() * this.getPrecoUnitario();
		NumberFormat.getCurrencyInstance().format(total);
		return total;
	}
	
	public String calculaImposto(){	
		return NumberFormat.getCurrencyInstance().format(getPrecoUnitario() * 0.4);
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	/*@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", precoUnitario=" + precoUnitario
				+ ", quantidadeEmEstoque=" + quantidadeEmEstoque + ", categoria=" + categoria + ", valorTotalEstoque()="
				+ valorTotalEstoque() + "]";
	}*/
	
	
}
