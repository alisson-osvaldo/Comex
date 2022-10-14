package br.com.comex.dao.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.comex.dao.ProdutoDAO;
import br.com.comex.factory.ConnectionFactory;
import br.com.comex.modelo.Produto;


public class MainProdutoListar {

	public static void main(String[] args) throws SQLException {
		
		try(Connection connection = new ConnectionFactory().getConnection()){
			ProdutoDAO produtoDao = new ProdutoDAO(connection);
			List<Produto> listaDeProdutos = produtoDao.listarTodos();
			listaDeProdutos.stream().forEach(lp -> System.out.println(lp));
			connection.close();	
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
