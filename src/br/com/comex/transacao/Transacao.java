package br.com.comex.transacao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.comex.factory.ConnectionFactory;

public class Transacao {
	
	private List<Command> comandos;
	
	public Transacao(List<Command> comandos) {
	    this.comandos = comandos;
	  }
	
	public void processaComandos() throws Exception {
		Connection conexao = new ConnectionFactory().getConnection();
		
		try {
			conexao.setAutoCommit(false);
			
			for (Command comandoDaVez : comandos) {
		        comandoDaVez.execute();;
		      }
			conexao.commit();
		} catch (SQLException e) {
		      conexao.rollback();
	    } finally {
	      conexao.close();
	    }
		
	}
	
}
