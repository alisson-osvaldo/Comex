package br.com.comex.main;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.comex.factory.ConnectionFactory;

public class MainTestaConexao {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("Conexão efetuada com sucesso");
		connection.close();
		
	}
}
