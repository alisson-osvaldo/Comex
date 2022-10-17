package br.com.comex.transacao;

import java.sql.Connection;

import br.com.comex.dao.ProdutoDAO;
import br.com.comex.modelo.Produto;
import br.com.comex.modelo.Produto.Tipo;

public class InsereProdutoCommand implements Command {
	
	private String nome;
	private String descricao;
	private double precoUnitario;
	private int quantidadeEmEstoque;
	private Tipo tipo;
	private int categoriaId;

	private ProdutoDAO produtoDao;
	
	public InsereProdutoCommand(String nome, String descricao, double precoUnitario, int quantidadeEmEstoque, Tipo tipo, int categoriaId, Connection conexao) {
		this.nome = nome;
		this.descricao = descricao;
		this.precoUnitario = precoUnitario;
		this.quantidadeEmEstoque = quantidadeEmEstoque;
		this.tipo = tipo;
		this.categoriaId = categoriaId;
		
		this.produtoDao = new ProdutoDAO(conexao);
	}
	
	public void execute() throws Exception {
		Produto novoProduto = new Produto(nome, descricao, precoUnitario, quantidadeEmEstoque, categoriaId, tipo);
		produtoDao.inserir(novoProduto);
	}

}
