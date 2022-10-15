package br.com.comex.main;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.comex.factory.ConnectionFactory;

public class MainTestaConexao {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("Conexão efetuada com sucesso");
		connection.close();
		
		
		//MainTestaConexao.testaPollConexao();
			
	}
	
	public static void testaPollConexao() throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		System.out.println("\n\n\nTeste Pool de Conexões: ");
		for (int i = 0; i < 20; i++) {
			connectionFactory.getConnection();
			System.out.println("Conexão de numero: " + i);
		}
	}
	
}
