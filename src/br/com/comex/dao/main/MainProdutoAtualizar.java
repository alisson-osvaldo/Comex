package br.com.comex.dao.main;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.comex.dao.ProdutoDAO;
import br.com.comex.factory.ConnectionFactory;
import br.com.comex.modelo.Produto;
import br.com.comex.modelo.Produto.Tipo;

public class MainProdutoAtualizar {

	public static void main(String[] args) throws SQLException {
		
		Produto atualizarProduto = new Produto(50, "TecladoTeste", "Teclado REDRAGON", 700.50, 1, 90, Tipo.ISENTO);
		
		try(Connection connection = new ConnectionFactory().getConnection()){
			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
			produtoDAO.altera(atualizarProduto);
			connection.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(atualizarProduto);
	}

}
