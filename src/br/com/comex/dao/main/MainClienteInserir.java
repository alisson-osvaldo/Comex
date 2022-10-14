package br.com.comex.dao.main;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.comex.dao.ClienteDAO;
import br.com.comex.factory.ConnectionFactory;
import br.com.comex.modelo.Cliente;
import br.com.comex.modelo.Cliente.Estados;

public class MainClienteInserir {

	public static void main(String[] args) throws SQLException {
		
		Cliente novoCliente = new Cliente("Analura3", "823.457.791-30", "(99)5887-4365", "Rua YYY", "123", "Apartamento", "Santa clara", "Curitiba" , Estados.PR);

		try(Connection connection = new ConnectionFactory().getConnection()){
			ClienteDAO clienteDAO = new ClienteDAO(connection);
			clienteDAO.inserir(novoCliente);
			connection.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(novoCliente);
		
	}

}
