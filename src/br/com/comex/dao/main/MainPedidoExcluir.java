package br.com.comex.dao.main;

import java.sql.Connection;

import br.com.comex.dao.PedidoDAO;
import br.com.comex.factory.ConnectionFactory;

public class MainPedidoExcluir {

	public static void main(String[] args) {
		
		try(Connection connection = new ConnectionFactory().getConnection()){
			PedidoDAO pedidoDAO = new PedidoDAO(connection);
			pedidoDAO.excluir(11);
			connection.close();
			System.out.println("Pedido Deletado com sucesso!");
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
