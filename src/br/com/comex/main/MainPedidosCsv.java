package br.com.comex.main;

import java.io.FileNotFoundException;
import java.util.List;

import br.com.comex.csv.LeitorPedidosCsv;
import br.com.comex.csv.MontanteTotalVendas;
import br.com.comex.csv.PedidoCsv;
import br.com.comex.csv.PedidoMaisBaratoEMaisCaro;
import br.com.comex.csv.TotalCategorias;
import br.com.comex.csv.TotalProdutosVendidos;

public class MainPedidosCsv {

	public static void main(String[] args) throws FileNotFoundException {
		
		LeitorPedidosCsv leitorPedidoCsv = new LeitorPedidosCsv();
		List<PedidoCsv> pedidosCsv = leitorPedidoCsv.lerPedidosCsv();
		System.out.println("total de pedidos: " + pedidosCsv.size() + "\n"); 
		
		
		TotalProdutosVendidos totalProdutosVendidos = new TotalProdutosVendidos();
		totalProdutosVendidos.calcularTotalProdutosVendidos(); 
		
		TotalCategorias totalCategorias = new TotalCategorias();
		totalCategorias.calcularTotalCategoriasDistintas(); 
		
		MontanteTotalVendas montanteTotalVendas = new MontanteTotalVendas();
		montanteTotalVendas.calculoTotalVendas();
		
		PedidoMaisBaratoEMaisCaro pedidoMaisBaratoEMaisCaro = new PedidoMaisBaratoEMaisCaro();
		pedidoMaisBaratoEMaisCaro.calculoPedidoMaisBaratoEMaisCaro();
		
		
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
