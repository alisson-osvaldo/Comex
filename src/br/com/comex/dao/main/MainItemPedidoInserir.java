package br.com.comex.dao.main;

import java.sql.Connection;

import br.com.comex.dao.ItemPedidoDAO;
import br.com.comex.factory.ConnectionFactory;
import br.com.comex.modelo.ItemPedido;
import br.com.comex.modelo.ItemPedido.Desconto;


public class MainItemPedidoInserir {

	public static void main(String[] args) {
		
		int produto_id = 50;
		
		try(Connection connection = new ConnectionFactory().getConnection()){
			ItemPedidoDAO itemProdutoDAO = new ItemPedidoDAO(connection);
			Double precoUnitario = itemProdutoDAO.buscarPorId(produto_id).getPrecoUnitario(); 
			
			ItemPedido novoItemPedido = new ItemPedido(precoUnitario, 2, produto_id, 9, 10, Desconto.PROMOCAO);
			
			itemProdutoDAO.inserir(novoItemPedido);
			connection.close();
			System.out.println(novoItemPedido);
		}catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
