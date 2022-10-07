package br.com.comex.csv;

import java.io.FileNotFoundException;
import java.util.List;

public class TotalProdutosVendidos {

	
	public void calcularTotalProdutosVendidos(List<PedidoCsv> pedidosCsv) throws FileNotFoundException {
		
		int soma = 0;
		
		for (PedidoCsv pedido : pedidosCsv) { 
			try {
				int quantidade = Integer.parseInt(pedido.getQuantidade());
				soma +=  quantidade;
			}catch (NumberFormatException e) {
				System.out.println("Erro não é permitido caracter: " + e);
			}
			
		}
		System.out.println("Total de produtos vendidos: " + soma + "\n");

	}
		
		
			
}
