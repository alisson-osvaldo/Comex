package br.com.comex.transacao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.comex.factory.ConnectionFactory;

public class Transacao {
	
	private int _cliente_id;
	private BigDecimal valorTransacao;
	
	public Transacao(int cliente_id, BigDecimal valorTransacao) {
		this._cliente_id = cliente_id;
		this.valorTransacao = valorTransacao;
	}
		
	public void executa() throws SQLException {
		String sqlUpdate = "UPDATE comex.conta SET valor = valor + ? WHERE cliente_id = ?";
		
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection connection = factory.getConnection()) { 
			connection.setAutoCommit(false);
			
			try(PreparedStatement stm = connection.prepareStatement(sqlUpdate)) {
				stm.setBigDecimal(1, this.valorTransacao);
				stm.setInt(2, this._cliente_id);
				stm.executeQuery();
				stm.close();
				connection.commit();
				connection.close();
				System.out.println("Transação executada com sucesso");
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO");
				connection.rollback();
			}
			
		}
	}
	
	public void inserirConta() throws SQLException {
		String sqlInsert = "INSERT INTO comex.conta (cliente_id, valor) VALUES (?, ?)";
			
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection connection = factory.getConnection()) { 
			connection.setAutoCommit(false);
			
			try(PreparedStatement stm = connection.prepareStatement(sqlInsert)) {
				stm.setInt(1, _cliente_id);
				stm.setBigDecimal(2, this.valorTransacao);
				stm.executeQuery();
				stm.close();
				connection.commit();
				connection.close();
				System.out.println("Inserção executada com sucesso");
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO");
				connection.rollback();
			}
			
		}
	}

	@Override
	public String toString() {
		return "Transacao\n"
				+ " cliente_id= " + _cliente_id 
				+ "\n valorTransacao = R$" + valorTransacao;
	}
	
	
}
