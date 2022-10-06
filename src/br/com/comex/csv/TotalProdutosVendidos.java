package br.com.comex.csv;

import java.io.FileNotFoundException;
import java.util.List;

public class TotalProdutosVendidos {

	
	public int calcularTotalProdutosVendidos() throws FileNotFoundException {
		LeitorPedidosCsv leitorPedidoCsv = new LeitorPedidosCsv();
		List<PedidoCsv> pedidosCsv = leitorPedidoCsv.lerPedidosCsv();
		
		int soma = 0;
		
		for (PedidoCsv pedido : pedidosCsv) { 
			try {
				int quantidade = Integer.parseInt(pedido.getQuantidade());
				soma +=  quantidade;
			}catch (NumberFormatException e) {
				System.out.println("Erro não é permitido caracter: " + e);
			}
			
		}
		return soma;
	}
		
		
			
}
