package br.com.comex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.comex.modelo.Pedido;

public class PedidoDAO {
	private Connection connection;
	
	public PedidoDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void inserir(Pedido novoPedido) throws SQLException {
		String sql = "INSERT INTO comex.pedido (data, cliente_id) VALUES (?, ?)";
		
		try(PreparedStatement stm = connection.prepareStatement(sql)) {
			connection.setAutoCommit(false);
			
			try(PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.setString(1, novoPedido.getData());
				pstm.setInt(2, novoPedido.getCliente_id());
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
	
	public List<Pedido> listarTodos() throws SQLException {
		List<Pedido> pedidos = new ArrayList<Pedido>();
		
		String sql = "SELECT id, data, cliente_id FROM comex.pedido";
	
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			pstm.execute();
			
			try(ResultSet rst = pstm.getResultSet()){
				while(rst.next()) {
					Pedido pedido = new Pedido(rst.getInt("id"), rst.getDate("data").toString(), rst.getInt("cliente_id"));
					pedidos.add(pedido);
				}
				rst.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			pstm.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return pedidos;
	}
	
	public void altera(Pedido pedidoParaAlterar) throws SQLException {
		String sql = "UPDATE comex.pedido p SET p.data = ?, p.cliente_id = ? WHERE p.id = ?";
			
		try(PreparedStatement stm = connection.prepareStatement(sql)) {
			connection.setAutoCommit(false);
			
			Date dataFormatada = new SimpleDateFormat("dd/MM/yyyy").parse(pedidoParaAlterar.getData());
			
			stm.setDate(1, new java.sql.Date(dataFormatada.getTime()));
			stm.setInt(2, pedidoParaAlterar.getCliente_id());
			stm.setInt(3, pedidoParaAlterar.getId());
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
		String sql = "DELETE FROM comex.pedido where id = ?";
		
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
