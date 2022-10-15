package br.com.comex.transacao;

import java.math.BigDecimal;
import java.sql.SQLException;


public class MainInserirConta {

	public static void main(String[] args) throws SQLException {
		//Inserir uma conta no BD para teste
		inserirConta();
		
	}
		
	public static void inserirConta() throws SQLException {
		Transacao novaConta = new Transacao(32, new BigDecimal("500"));
		novaConta.inserirConta();
	}
	
}
