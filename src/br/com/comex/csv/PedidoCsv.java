package br.com.comex.csv;

import java.io.FileNotFoundException;

public class PedidoCsv {
	
	private String categoria;
    private String produto;
    private String cliente;

    private String preco;
    private String quantidade;

    private String data;

    public PedidoCsv(String categoria, String produto, String cliente, String preco, String quantidade, String data) {
        this.categoria = categoria;
        this.produto = produto;
        this.cliente = cliente;
        this.preco = preco;
        this.quantidade = quantidade;
        this.data = data;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getProduto() {
        return produto;
    }

    public String getCliente() {
        return cliente;
    }

    public String getPreco() {
        return preco;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public String getData() {
        return data;
    }
    
	public double ValorTotal(int qtd, double preco) throws FileNotFoundException {
		double multiplicacao = 0;
		return multiplicacao = qtd * preco;			
	}

    @Override
    public String toString() {
        return "Pedido{" +
                "categoria='" + categoria + '\'' +
                ", produto='" + produto + '\'' +
                ", cliente='" + cliente + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                ", data=" + data +
                '}';
    }

}
