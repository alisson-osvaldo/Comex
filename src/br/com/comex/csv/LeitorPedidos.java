package br.com.comex.csv;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import oracle.jdbc.driver.json.parser.JsonParserImpl;


public class LeitorPedidos {
	
	
	public List<PedidoCsv> lerPedidosCsv() throws FileNotFoundException{
		List<PedidoCsv> pedidos = new ArrayList<PedidoCsv>();
		
		InputStream inputStrem = new FileInputStream("pedidos.csv");
		Scanner scanner = new Scanner(inputStrem);
		
		scanner.nextLine();
		
		while (scanner.hasNextLine()) {	
			String linha = scanner.nextLine();
			
			String[] valores = linha.split(",");
			
			String categoria = valores[0];
			String produto = valores[1];
			String preco = valores[2];
			String quantidade = valores[3];
			String data = valores[4];
			String cliente = valores[5];
			
			PedidoCsv pedido =  new PedidoCsv(categoria, produto, cliente, preco, quantidade, data);
			
			pedidos.add(pedido);
					
		}	
		//System.out.println("total de pedidos: " + pedidos.size());
		return pedidos;		
	}	
	
		
}
