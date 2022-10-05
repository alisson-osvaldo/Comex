package br.com.comex.main;

import java.io.FileNotFoundException;
import java.util.List;

import br.com.comex.csv.LeitorPedidosCsv;
import br.com.comex.csv.PedidoCsv;

public class MainLeitorPedidosCsv {

	public static void main(String[] args) throws FileNotFoundException {
		LeitorPedidosCsv leitorPedidoCsv = new LeitorPedidosCsv();
		List<PedidoCsv> pedidosCsv = leitorPedidoCsv.lerPedidosCsv();
		
		System.out.println("total de pedidos: " + pedidosCsv.size()); 
		

	}

}
