package br.com.comex.dao.main;

import java.sql.Connection;

import br.com.comex.dao.ClienteDAO;
import br.com.comex.factory.ConnectionFactory;

public class MainClienteExcluir {

	public static void main(String[] args) {
		
		try(Connection connection = new ConnectionFactory().getConnection()){
			ClienteDAO clienteDAO = new ClienteDAO(connection);
			clienteDAO.excluir(11);
			connection.close();
			System.out.println("Cliente Deletado com sucesso!");
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
