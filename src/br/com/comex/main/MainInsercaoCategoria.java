package br.com.comex.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.comex.factory.ConnectionFactory;
import br.com.comex.modelo.Categoria.Status;

public class MainInsercaoCategoria {

	public static void main(String[] args) throws SQLException {
	
		String sql = "INSERT INTO COMEX.CATEGORIA (NOME, STATUS) VALUES (?, ?)";
		
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection connection = factory.getConnection()) { 
			connection.setAutoCommit(false);
			
			try(PreparedStatement stm = connection.prepareStatement(sql)) {
				adicionarVariavel("INFORMÁTICA", Status.ATIVA.toString(), stm);
				adicionarVariavel("MÓVEIS", Status.INATIVA.toString(), stm);
				adicionarVariavel("LIVROS", Status.ATIVA.toString(), stm);
				
				connection.commit();
				stm.close();
				System.out.println("Categoria Inserida com sucesso!");
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO");
				connection.rollback();
			}
			connection.close();
		}	
	}
	
	private static void adicionarVariavel(String nome, String status, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, status);
		stm.execute();
	}
	
}
