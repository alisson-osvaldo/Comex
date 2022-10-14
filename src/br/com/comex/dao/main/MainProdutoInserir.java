package br.com.comex.dao.main;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.comex.dao.ProdutoDAO;
import br.com.comex.factory.ConnectionFactory;
import br.com.comex.modelo.Produto;
import br.com.comex.modelo.Produto.Tipo;

public class MainProdutoInserir {

	public static void main(String[] args) throws SQLException {
		
		Produto novoProduto = new Produto("Teclado1", "Teclado gamer", 550.50, 2, 90, Tipo.ISENTO);
		
		try(Connection connection = new ConnectionFactory().getConnection()){
			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
			produtoDAO.inserir(novoProduto);
			connection.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(novoProduto);
		
	}

}
