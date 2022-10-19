package br.com.comex.dao.main;

import java.sql.Connection;

import br.com.comex.dao.CategoriaDAO;
import br.com.comex.factory.ConnectionFactory;

public class MainCategoriaExcluirCategoriasInativas {
	
	public static void main(String[] args) {
		try(Connection connection = new ConnectionFactory().getConnection()){
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			categoriaDAO.excluirCategoriasInativas();
			connection.close();
			System.out.println("Categorias INATIVAS Deletadas com sucesso!");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
