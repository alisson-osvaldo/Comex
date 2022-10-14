package br.com.comex.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.comex.factory.ConnectionFactory;


public class MainAtualizacaoCategoria {
	
	public static void main(String[] args) throws SQLException {
		
		String sql = "UPDATE COMEX.CATEGORIA C SET C.NOME = ? WHERE C.NOME = ?";
		
		ConnectionFactory factory = new ConnectionFactory();
		try(Connection connection = factory.getConnection()) {
			connection.setAutoCommit(false);
			
			try(PreparedStatement stm = connection.prepareStatement(sql)) {
				adicionarVariavel("LIVROS TÉCNICOS", "LIVROS", stm);
				connection.commit();
				stm.close();
				System.out.println("Categotia atualizada com sucesso!");
			}catch (Exception e) {
				e.printStackTrace();
				connection.rollback();
				System.out.println("ROLLBACK EXECUTADO");
			}
			connection.close();
		}

	}
	
	private static void adicionarVariavel(String novoNome, String nomeAtual,PreparedStatement stm) throws SQLException {
		stm.setString(1, novoNome);
		stm.setString(2, nomeAtual);
		stm.executeUpdate();
	}
	
	
	
}
