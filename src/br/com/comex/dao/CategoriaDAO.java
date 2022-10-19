package br.com.comex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.comex.modelo.Categoria;
import br.com.comex.modelo.Categoria.Status;

public class CategoriaDAO {
private Connection connection;
	
	public CategoriaDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void inserir(Categoria novaCategoria) throws SQLException {
		String sql = "INSERT INTO comex.categoria (nome, status) VALUES ( ?, ?)";
	
		try(PreparedStatement stm = connection.prepareStatement(sql)) {
			connection.setAutoCommit(false);
			
			try(PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.setString(1, novaCategoria.getNome());
				pstm.setString(2, novaCategoria.getStatus().toString());
				pstm.execute();
				pstm.close();
				connection.commit();
				connection.close();
			}catch (Exception e) {
				e.printStackTrace();
				connection.rollback();
				System.out.println("ROLLBACK EXECUTADO");
			}
		}
	}
	
	public List<Categoria> listarTodos() throws SQLException {
		List<Categoria> categorias = new ArrayList<Categoria>();
		
		String sql = "SELECT * FROM comex.categoria";
	
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			pstm.execute();
			
			try(ResultSet rst = pstm.getResultSet()){
				while(rst.next()) {
					String status = rst.getString("status");
					Categoria categoria = new Categoria(rst.getString("nome"),Status.valueOf(status));
					categorias.add(categoria);
				}
				rst.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			pstm.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return categorias;
	}
	
	public void altera(Categoria categoriaParaAlterar) throws SQLException {
		String sql = "UPDATE comex.categoria c SET c.nome = ?, c.status = ? WHERE c.id = ?";
			
		try(PreparedStatement stm = connection.prepareStatement(sql)) {
			connection.setAutoCommit(false);
		
			stm.setString(1, categoriaParaAlterar.getNome());
			stm.setString(2, categoriaParaAlterar.getStatus().toString());
			stm.setInt(3, categoriaParaAlterar.getId());
			stm.execute();
			stm.close();
			connection.commit();
			connection.close();
		}catch (Exception e) {
			e.printStackTrace();
			connection.rollback();
			System.out.println("ROLLBACK EXECUTADO");
		}
	}
	
	public void excluirCategoriasInativas() throws SQLException {
		String sql = "DELETE FROM COMEX.CATEGORIA WHERE STATUS = ?";
		
		try(PreparedStatement stm = connection.prepareStatement(sql)) {
			connection.setAutoCommit(false);
			stm.setString(1, "INATIVA");
			stm.execute();
			stm.close();
			connection.commit();
			connection.close();
		}catch (Exception e) {
			e.printStackTrace();
			connection.rollback();
			System.out.println("ROLLBACK EXECUTADO");
		}
	}
	
	public void excluir(Integer id) throws SQLException {
		String sql = "DELETE FROM comex.categoria where id = ?";
		
		try(PreparedStatement stm = connection.prepareStatement(sql)) {
			connection.setAutoCommit(false);
			stm.setInt(1, id);
			stm.execute();
			stm.close();
			connection.commit();
			connection.close();
		}catch (Exception e) {
			e.printStackTrace();
			connection.rollback();
			System.out.println("ROLLBACK EXECUTADO");
		}
	}
	
}
