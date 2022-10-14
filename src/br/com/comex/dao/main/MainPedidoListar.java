package br.com.comex.dao.main;

import java.sql.Connection;
import java.util.List;

import br.com.comex.dao.PedidoDAO;
import br.com.comex.factory.ConnectionFactory;
import br.com.comex.modelo.Pedido;


public class MainPedidoListar {

	public static void main(String[] args) {
		
		try(Connection connection = new ConnectionFactory().getConnection()){
			PedidoDAO pedidoDao = new PedidoDAO(connection);
			List<Pedido> listaDePedidos = pedidoDao.listarTodos();
			listaDePedidos.stream().forEach(lp -> System.out.println(lp));
			connection.close();	
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
