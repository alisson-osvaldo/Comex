package br.com.comex.transacao;

import java.math.BigDecimal;
import java.sql.SQLException;


public class MainTransacao {
	
	public static void main(String[] args) throws SQLException {
		
		try {
			Transacao novaTransacao = new Transacao(32, new BigDecimal("50"));
			novaTransacao.executa();
			System.out.println("\n" + novaTransacao);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
