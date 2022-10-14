package br.com.comex.dao.main;

import java.sql.Connection;
import java.util.List;

import br.com.comex.dao.CategoriaDAO;
import br.com.comex.factory.ConnectionFactory;
import br.com.comex.modelo.Categoria;


public class MainCategoriaListar {

	public static void main(String[] args) {

		try(Connection connection = new ConnectionFactory().getConnection()){
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			List<Categoria> listaDeCategorias = categoriaDAO.listarTodos();
			listaDeCategorias.stream().forEach(lp -> System.out.println(lp));
			connection.close();	
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
