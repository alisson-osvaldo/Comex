package br.com.comex.dao.main;

import java.sql.Connection;

import br.com.comex.dao.ClienteDAO;
import br.com.comex.factory.ConnectionFactory;
import br.com.comex.modelo.Cliente;


public class MainClienteAtualizar {

	public static void main(String[] args) {
		
		Cliente atualizarCliente = new Cliente(14, "Eliezer", "23.587.789-12", "(09)03217-8521", "Rua MMM", "456", "Casa", "Rua do limoeiro", "Campo Largo", br.com.comex.modelo.Cliente.Estados.PR);
		
		try(Connection connection = new ConnectionFactory().getConnection()){
			ClienteDAO clienteDAO = new ClienteDAO(connection);
			clienteDAO.altera(atualizarCliente);
			connection.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(atualizarCliente);

	}

}
