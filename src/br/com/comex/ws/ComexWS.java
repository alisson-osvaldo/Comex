package br.com.comex.ws;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import br.com.comex.dao.CategoriaDAO;
import br.com.comex.factory.ConnectionFactory;
import br.com.comex.modelo.Categoria;

@WebService
public class ComexWS {
	
	public List<Categoria> getCategorias() throws SQLException{	
		List<Categoria> listaDeCategorias = new ArrayList<Categoria>();
		
		try(Connection connection = new ConnectionFactory().getConnection()){
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			listaDeCategorias = categoriaDAO.listarTodos();
			listaDeCategorias.stream().forEach(lp -> System.out.println(lp));
			connection.close();	
		}catch (Exception e) {
			e.printStackTrace();
		}
		return listaDeCategorias;
		
	}

}
