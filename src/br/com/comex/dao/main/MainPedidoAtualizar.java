package br.com.comex.dao.main;

import java.sql.Connection;

import br.com.comex.dao.PedidoDAO;
import br.com.comex.factory.ConnectionFactory;
import br.com.comex.modelo.Pedido;


public class MainPedidoAtualizar {

	public static void main(String[] args) {
		
		Pedido atualizarPedido = new Pedido( 9, "10/01/1998", 9);
		
		try(Connection connection = new ConnectionFactory().getConnection()){
			PedidoDAO pedidoDAO = new PedidoDAO(connection);
			pedidoDAO.altera(atualizarPedido);
			connection.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(atualizarPedido);
	}

}


