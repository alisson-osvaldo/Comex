package br.com.comex.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "admin");
		} catch (SQLException e) {
			System.out.println("Erro na conexão!!!");
			throw new RuntimeException(e);
		}		
	}
}
