package br.com.comex.dao.main;

import java.sql.Connection;

import br.com.comex.dao.ItemPedidoDAO;
import br.com.comex.factory.ConnectionFactory;
import br.com.comex.modelo.ItemPedido;
import br.com.comex.modelo.ItemPedido.Desconto;



public class MainItemPedidoAtualizar {

	public static void main(String[] args) {
		
		ItemPedido atualizarItemPedido = new ItemPedido(28, 150.50, 1, 50, 9, 10.8, Desconto.QUANTIDADE);
		
		try(Connection connection = new ConnectionFactory().getConnection()){
			ItemPedidoDAO itemPedidoDAO = new ItemPedidoDAO(connection);
			itemPedidoDAO.altera(atualizarItemPedido);
			connection.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(atualizarItemPedido);
	}

}
