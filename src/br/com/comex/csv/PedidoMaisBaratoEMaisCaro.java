package br.com.comex.csv;

import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.List;

public class PedidoMaisBaratoEMaisCaro {
	
	public void calculoPedidoMaisBaratoEMaisCaro() throws FileNotFoundException {
		
		LeitorPedidosCsv leitorPedidoCsv = new LeitorPedidosCsv();
		List<PedidoCsv> pedidosCsv = leitorPedidoCsv.lerPedidosCsv();
		
		double menor = Integer.MAX_VALUE;
		double maior = Integer.MIN_VALUE;
		String menorProduto = "";
		String maiorProduto = "";
		
		for (PedidoCsv pedido : pedidosCsv) {
			try {
				int qtd = Integer.parseInt(pedido.getQuantidade());
				double preco = Double.parseDouble(pedido.getPreco());
				
				if (preco > maior) {
					maiorProduto = pedido.getProduto();
					maior = preco * qtd;	
				}
				if (preco < menor) {
					menorProduto = pedido.getProduto();
					menor = preco * qtd;;
				}
			} catch (NumberFormatException e) {
				System.out.println("Erro não é permitido caracter: " + e);
			}
		}
		System.out.println("\n");
		System.out.println("Pedido mais barato: " + NumberFormat.getCurrencyInstance().format(menor)  + " (" + menorProduto + ")");
		System.out.println("Pedido mais caro: " + NumberFormat.getCurrencyInstance().format(maior) + " (" + maiorProduto + ")");


	}
			
	
	
}
