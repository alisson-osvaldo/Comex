package br.com.comex.dao.main;

import java.sql.Connection;
import java.util.List;

import br.com.comex.dao.ItemPedidoDAO;
import br.com.comex.factory.ConnectionFactory;
import br.com.comex.modelo.ItemPedido;


public class MainItemPedidoListar {

	public static void main(String[] args) {

		try(Connection connection = new ConnectionFactory().getConnection()){
			ItemPedidoDAO itemPedidoDAO = new ItemPedidoDAO(connection);
			List<ItemPedido> listaDeItemPedidos = itemPedidoDAO.listarTodos();
			listaDeItemPedidos.stream().forEach(lp -> System.out.println(lp));
			connection.close();	
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
