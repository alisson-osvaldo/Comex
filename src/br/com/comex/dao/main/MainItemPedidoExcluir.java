package br.com.comex.dao.main;

import java.sql.Connection;

import br.com.comex.dao.ItemPedidoDAO;
import br.com.comex.factory.ConnectionFactory;

public class MainItemPedidoExcluir {

	public static void main(String[] args) {
		
		try(Connection connection = new ConnectionFactory().getConnection()){
			ItemPedidoDAO itemPedidoDAO = new ItemPedidoDAO(connection);
			itemPedidoDAO.excluir(9);
			connection.close();
			System.out.println("Pedido Deletado com sucesso!");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
