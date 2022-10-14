package br.com.comex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.comex.modelo.Cliente;
import br.com.comex.modelo.Cliente.Estados;


public class ClienteDAO {
	
	private Connection connection;
	
	public ClienteDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void inserir(Cliente novoCliente) throws SQLException {
		String sql = "INSERT INTO comex.cliente (nome, cpf, telefone, rua, numero, complemento, bairro, cidade, uf) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
		try(PreparedStatement stm = connection.prepareStatement(sql)) {
			connection.setAutoCommit(false);
			
			try(PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.setString(1, novoCliente.getNome());
				pstm.setString(2, novoCliente.getCpf());
				pstm.setString(3, novoCliente.getTelefone());
				pstm.setString(4, novoCliente.getRua());
				pstm.setString(5, novoCliente.getNumero());
				pstm.setString(6, novoCliente.getComplemento());
				pstm.setString(7, novoCliente.getBairro());
				pstm.setString(8, novoCliente.getCidade());
				pstm.setString(9, novoCliente.getEstado().toString());
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
	
	public List<Cliente> listarTodos() throws SQLException {
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		String sql = "SELECT id, nome, cpf, telefone, rua, numero, complemento, bairro, cidade, uf FROM comex.cliente";
	
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			pstm.execute();
			
			try(ResultSet rst = pstm.getResultSet()){
				while(rst.next()) {
					String uf = rst.getString("uf");
					Cliente cliente = new Cliente(rst.getInt("id"), rst.getString("nome"), rst.getString("cpf"), rst.getString("telefone"), rst.getString("rua"), rst.getString("numero"), rst.getString("complemento"), rst.getString("bairro"), rst.getString("cidade"), Estados.valueOf(uf));
					clientes.add(cliente);
				}
				rst.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			pstm.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return clientes;
	}
	
	public void altera(Cliente clienteParaAlterar) throws SQLException {
		String sql = "UPDATE comex.cliente c SET c.id = ?, c.nome = ?, c.cpf = ?, c.telefone = ?, c.rua = ?, c.numero = ?, c.complemento = ?, c.bairro = ?, c.cidade = ?, c.uf = ? WHERE c.id = ?";
			
		try(PreparedStatement stm = connection.prepareStatement(sql)) {
			connection.setAutoCommit(false);
			stm.setInt(1, clienteParaAlterar.getId());
			stm.setString(2, clienteParaAlterar.getNome());
			stm.setString(3, clienteParaAlterar.getCpf());
			stm.setString(4, clienteParaAlterar.getTelefone());
			stm.setString(5, clienteParaAlterar.getRua());
			stm.setString(6, clienteParaAlterar.getNumero());
			stm.setString(7, clienteParaAlterar.getComplemento());
			stm.setString(8, clienteParaAlterar.getBairro());
			stm.setString(9, clienteParaAlterar.getCidade());
			stm.setString(10, clienteParaAlterar.getEstado().toString());
			stm.setInt(11, clienteParaAlterar.getId());
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
		String sql = "DELETE FROM comex.cliente where id = ?";
		
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
