package br.com.comex.main;

import java.io.FileNotFoundException;
import java.util.List;

import br.com.comex.csv.LeitorPedidosCsv;
import br.com.comex.csv.PedidoCsv;
import br.com.comex.csv.TotalCategorias;
import br.com.comex.csv.TotalProdutosVendidos;

public class MainLeitorPedidosCsv {

	public static void main(String[] args) throws FileNotFoundException {
		
		LeitorPedidosCsv leitorPedidoCsv = new LeitorPedidosCsv();
		List<PedidoCsv> pedidosCsv = leitorPedidoCsv.lerPedidosCsv();
		System.out.println("total de pedidos: " + pedidosCsv.size() + "\n"); 
		
		
		TotalProdutosVendidos totalProdutosVendidos = new TotalProdutosVendidos();
		System.out.println("Total de produtos vendidos: " + totalProdutosVendidos.calcularTotalProdutosVendidos() + "\n"); 
		
		TotalCategorias totalCategorias = new TotalCategorias();
		System.out.println("Total de categorias: " + totalCategorias.CalcularTotalCategoriasDistintas()); 
		
		
		
//		for (PedidoCsv pedido : pedidosCsv) { 
//			System.out.println(
//					"\n\n-------------------------------------------"
//					+ "\nCategora : " + pedido.getCategoria() 
//					+ "\n	Produto: " + pedido.getProduto()
//					+ "\n	Cliente: " + pedido.getCliente()
//					+ "\n	Preço : " + pedido.getPreco()
//					+ "\n Quantidade: " + pedido.getQuantidade()
//					+ "\n	Data: " + pedido.getData()
//					);
//		}
		
			
	}
}
