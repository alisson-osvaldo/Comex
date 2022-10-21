package br.com.comex.transacao;

import java.sql.Connection;

import br.com.comex.factory.ConnectionFactory;
import br.com.comex.modelo.Produto.Tipo;


public class MainTransacao {
	
	public static void main(String[] args) throws Exception {	
		try(Connection connection = new ConnectionFactory().getConnection()){
			InsereProdutoCommand insereProduto = new InsereProdutoCommand("testando", "Testando", 550.50, 2, Tipo.ISENTO, 128, connection);
			Transacao transacao = new Transacao(insereProduto);
			transacao.processaComandos();
			connection.close();
		}catch (Exception e) {
			e.printStackTrace();
		}				
	}	
}
