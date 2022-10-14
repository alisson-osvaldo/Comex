package br.com.comex.dao.main;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.comex.dao.ProdutoDAO;
import br.com.comex.factory.ConnectionFactory;

public class MainProdutoExcluir {

	public static void main(String[] args) throws SQLException {
		
		try(Connection connection = new ConnectionFactory().getConnection()){
			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
			produtoDAO.excluir(49);
			connection.close();
			System.out.println("Produto Deletado com sucesso!");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
