package br.com.comex.dao.main;

import java.sql.Connection;

import br.com.comex.dao.PedidoDAO;
import br.com.comex.factory.ConnectionFactory;
import br.com.comex.modelo.Pedido;

public class MainPedidoInserir {

	public static void main(String[] args) {
		
		Pedido novoPedido = new Pedido("20/09/2020", 9);
		
		try(Connection connection = new ConnectionFactory().getConnection()){
			PedidoDAO pedidoDAO = new PedidoDAO(connection);
			pedidoDAO.inserir(novoPedido);
			connection.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(novoPedido);
	}

}
