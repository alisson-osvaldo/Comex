package br.com.comex.csv;

import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.List;

public class MontanteTotalVendas {
	
	public void calculoTotalVendas(List<PedidoCsv> pedidosCsv) throws FileNotFoundException {
		
		double total = 0;
		
		for (PedidoCsv pedido : pedidosCsv) {		
			try {
				total += pedido.ValorTotal(Integer.parseInt(pedido.getQuantidade()), Double.parseDouble(pedido.getPreco()));	
			} catch (NumberFormatException e) {
				System.out.println("Erro não é permitido caracter: " + e);
			}
				
		}
		System.err.println("\nMontante de vendas: " + NumberFormat.getCurrencyInstance().format(total));

	}

}
