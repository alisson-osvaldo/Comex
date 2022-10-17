package br.com.comex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.comex.modelo.ItemPedido;
import br.com.comex.modelo.ItemPedido.Desconto;
import br.com.comex.modelo.Produto;
import br.com.comex.modelo.Produto.Tipo;

public class ItemPedidoDAO {

	private Connection connection;
	
	public ItemPedidoDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void inserir(ItemPedido novoItemPedido) throws SQLException {
		String sql = "INSERT INTO comex.item_pedido (preco_unitario, quantidade, produto_id, pedido_id, desconto, tipo_desconto) VALUES (?, ?, ?, ?, ?, ?)";
		
		try(PreparedStatement stm = connection.prepareStatement(sql)) {
			connection.setAutoCommit(false);
			
			try(PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.setDouble(1, novoItemPedido.getPrecoUnitario());
				pstm.setInt(2, novoItemPedido.getQuantidade());
				pstm.setInt(3, novoItemPedido.getProdutoId());
				pstm.setInt(4, novoItemPedido.getPedidoId());
				pstm.setDouble(5, novoItemPedido.getDesconto());
				pstm.setString(6, novoItemPedido.getTipoDeDesconto().toString());
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
	
	public Produto buscarPorId(int id) throws SQLException{
		String sql = "SELECT * FROM comex.produto where id = ?";
		
		try(PreparedStatement stm = this.connection.prepareStatement(sql)) {
			stm.setInt(1, id);
			
			try(ResultSet rst = stm.executeQuery() ) {
				Produto produto = null;
				if (rst.next()) {
					produto = this.PopulaProduto(rst);
				}
				return produto;
			}		
		}	
	}
	
	private Produto PopulaProduto(ResultSet rst) throws SQLException{
		String tipo = rst.getString("tipo");
		Produto produto = new Produto(
				rst.getInt("id"),
				rst.getString("nome"),
				rst.getString("descricao"),
				rst.getDouble("preco_unitario"), 
				rst.getInt("quantidade_estoque"), 
				rst.getInt("categoria_id"), 
				Tipo.valueOf(tipo));
		
				produto.setId(rst.getInt("id"));
				return produto;
	}
	
	public List<ItemPedido> listarTodos() throws SQLException {
		List<ItemPedido> itemPedidos = new ArrayList<ItemPedido>();
		
		String sql = "SELECT * FROM comex.item_pedido";
	
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			pstm.execute();
			
			try(ResultSet rst = pstm.getResultSet()){
				while(rst.next()) {
					String TipoDesconto = rst.getString("tipo_desconto");
					ItemPedido itemPedido = new ItemPedido(rst.getInt("id"), rst.getDouble("preco_unitario"), rst.getInt("quantidade"), rst.getInt("produto_id"), rst.getInt("pedido_id"), rst.getDouble("desconto"), Desconto.valueOf(TipoDesconto));
					itemPedidos.add(itemPedido);
				}
				rst.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			pstm.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return itemPedidos;
	}
	
	public void altera(ItemPedido itemPedidoParaAlterar) throws SQLException {
		String sql = "UPDATE comex.item_pedido SET preco_unitario=?,quantidade=?,produto_id=?,pedido_id=?,desconto=?,tipo_desconto=?"
				+ " WHERE id=?";
			
		try(PreparedStatement stm = connection.prepareStatement(sql)) {
			connection.setAutoCommit(false);
			
			stm.setDouble(1, itemPedidoParaAlterar.getPrecoUnitario());
			stm.setInt(2, itemPedidoParaAlterar.getQuantidade());
			stm.setInt(3, itemPedidoParaAlterar.getProdutoId());
			stm.setInt(4, itemPedidoParaAlterar.getPedidoId());
			stm.setDouble(5, itemPedidoParaAlterar.getDesconto());
			stm.setString(6, itemPedidoParaAlterar.getTipoDeDesconto().toString());
			stm.setInt(7, itemPedidoParaAlterar.getId());
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
		String sql = "DELETE FROM comex.item_pedido where id = ?";
		
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
