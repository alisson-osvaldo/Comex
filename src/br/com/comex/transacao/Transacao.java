package br.com.comex.transacao;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.comex.factory.ConnectionFactory;

public class Transacao {
	
	//private List<Command> comandos;
	Command comando;
	
	public Transacao(InsereProdutoCommand insereProduto) {
	    this.comando = insereProduto;
	  }
	
	public void processaComandos() throws Exception {
		Connection conexao = new ConnectionFactory().getConnection();
		
		try {
			conexao.setAutoCommit(false);
		    comando.execute();;
			conexao.commit();
		} catch (SQLException e) {
		      conexao.rollback();
	    } finally {
	      conexao.close();
	    }
		
	}
	
}
