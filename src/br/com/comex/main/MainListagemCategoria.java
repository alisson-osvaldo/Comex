package br.com.comex.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.comex.factory.ConnectionFactory;


public class MainListagemCategoria {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory factory = new ConnectionFactory();
		try(Connection connection = factory.getConnection()) {
			
			String sql = "SELECT ID, NOME, STATUS FROM COMEX.CATEGORIA";
			
			try(PreparedStatement pstm = connection.prepareStatement(sql)){
				pstm.execute();
				
				try(ResultSet rst = pstm.executeQuery()){
					System.out.println("\nCATEGORIA: ");
					while(rst.next()) {
						System.out.printf("%s %s %s\n", rst.getString("ID"), rst.getString("NOME"), rst.getString("STATUS"));

					}
					rst.close();
					pstm.close();
					connection.close();
				}
			}
		}
				

	}
}
