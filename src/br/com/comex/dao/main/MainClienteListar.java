package br.com.comex.dao.main;

import java.sql.Connection;
import java.util.List;

import br.com.comex.dao.ClienteDAO;
import br.com.comex.factory.ConnectionFactory;
import br.com.comex.modelo.Cliente;


public class MainClienteListar {

	public static void main(String[] args) {
		
		try(Connection connection = new ConnectionFactory().getConnection()){
			ClienteDAO clienteDAO = new ClienteDAO(connection);
			List<Cliente> listaDeClientes = clienteDAO.listarTodos();
			listaDeClientes.stream().forEach(lp -> System.out.println(lp));
			connection.close();	
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
