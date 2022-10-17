package br.com.comex.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.comex.factory.ConnectionFactory;

public class MainRemocaoCategoria {

	public static void main(String[] args) throws SQLException {
		
		String sql = "DELETE FROM COMEX.CATEGORIA WHERE STATUS = ?";
		
		ConnectionFactory factory = new ConnectionFactory();
		try(Connection connection = factory.getConnection()) {
			connection.setAutoCommit(false);
			
			try (PreparedStatement stm = connection.prepareStatement(sql)) {
				stm.setString(1, "INATIVA");
				stm.execute();
				connection.commit();
				stm.close();
				System.out.println("Categoria Deletada com sucesso!");
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO");
				connection.rollback();
			}
			connection.close();
		}

	}

}
