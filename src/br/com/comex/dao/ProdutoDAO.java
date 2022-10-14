package br.com.comex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.comex.modelo.Produto;
import br.com.comex.modelo.Produto.Tipo;

public class ProdutoDAO {
	
	private Connection connection;
	
	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void inserir(Produto novoProduto) throws SQLException {
		String sql = "INSERT INTO comex.produto (nome, descricao, preco_unitario, quantidade_estoque, categoria_id, tipo) VALUES (?, ?, ?, ?, ?, ?)";
		
		try(PreparedStatement stm = connection.prepareStatement(sql)) {
			connection.setAutoCommit(false);
			
			try(PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.setString(1, novoProduto.getNome());
				pstm.setString(2, novoProduto.getDescricao());
				pstm.setDouble(3, novoProduto.getPrecoUnitario());
				pstm.setInt(4, novoProduto.getQuantidadeEmEstoque());
				pstm.setInt(5, novoProduto.getCategoria_id());
				pstm.setString(6, novoProduto.getTipo().toString());
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
	
	public List<Produto> listarTodos() throws SQLException {
		List<Produto> produtos = new ArrayList<Produto>();
		
		String sql = "SELECT id, nome, descricao, preco_unitario, quantidade_estoque, categoria_id, tipo FROM comex.produto";
	
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			pstm.execute();
			
			try(ResultSet rst = pstm.getResultSet()){
				while(rst.next()) {
					String tipo = rst.getString("tipo");
					Produto produto = new Produto(rst.getInt("id"), rst.getString("nome"), rst.getString("descricao"), rst.getDouble("preco_unitario"), rst.getInt("quantidade_estoque"), rst.getInt("categoria_id"), Tipo.valueOf(tipo));
					produtos.add(produto);
				}
				rst.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			pstm.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return produtos;
	}
	
	public void altera(Produto produtoParaAlterar) throws SQLException {
		String sql = "UPDATE comex.produto p SET p.nome = ?, p.descricao = ?, p.preco_unitario = ?, p.quantidade_estoque = ?, p.categoria_id = ?, p.tipo = ? WHERE p.id = ?";
			
		try(PreparedStatement stm = connection.prepareStatement(sql)) {
			connection.setAutoCommit(false);
			
			stm.setString(1, produtoParaAlterar.getNome());
			stm.setString(2, produtoParaAlterar.getDescricao());
			stm.setDouble(3, produtoParaAlterar.getPrecoUnitario());
			stm.setInt(4, produtoParaAlterar.getQuantidadeEmEstoque());
			stm.setInt(5, produtoParaAlterar.getCategoria_id());
			stm.setString(6, produtoParaAlterar.getTipo().toString());
			stm.setInt(7, produtoParaAlterar.getId());
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
		String sql = "DELETE FROM comex.produto where id = ?";
		
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
