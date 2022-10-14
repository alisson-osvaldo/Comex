package br.com.comex.dao.main;

import java.sql.Connection;

import br.com.comex.dao.CategoriaDAO;
import br.com.comex.factory.ConnectionFactory;
import br.com.comex.modelo.Categoria;
import br.com.comex.modelo.Categoria.Status;

public class MainCategoriaAtualizar {

	public static void main(String[] args) {
		
		Categoria atualizaCategoria = new Categoria("Carro", Status.INATIVA, 90);
		
		try(Connection connection = new ConnectionFactory().getConnection()){
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			categoriaDAO.altera(atualizaCategoria);
			connection.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(atualizaCategoria);
		
	}

}
