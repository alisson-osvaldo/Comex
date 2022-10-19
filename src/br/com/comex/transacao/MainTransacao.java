package br.com.comex.transacao;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.comex.factory.ConnectionFactory;
import br.com.comex.modelo.Produto.Tipo;


public class MainTransacao {
	
	public static void main(String[] args) throws SQLException {
		
		try(Connection connection = new ConnectionFactory().getConnection()){
			InsereProdutoCommand insereProduto = new InsereProdutoCommand("Command22", "Testando", 550.50, 2, Tipo.ISENTO, 128, connection);
			insereProduto.execute();
			connection.close();
		}catch (Exception e) {
			e.printStackTrace();
		}			
		
	}
	
}
