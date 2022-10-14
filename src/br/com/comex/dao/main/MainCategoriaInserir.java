package br.com.comex.dao.main;

import java.sql.Connection;

import br.com.comex.dao.CategoriaDAO;
import br.com.comex.factory.ConnectionFactory;
import br.com.comex.modelo.Categoria;
import br.com.comex.modelo.Categoria.Status;

public class MainCategoriaInserir {

	public static void main(String[] args) {
		
		Categoria novaCategoria = new Categoria("Informática", Status.ATIVA);
		
		try(Connection connection = new ConnectionFactory().getConnection()){
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			categoriaDAO.inserir(novaCategoria);
			connection.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(novaCategoria);
		
	}

}
