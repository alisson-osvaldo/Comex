package br.com.comex.csv;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TotalCategorias {

	public void calcularTotalCategoriasDistintas() throws FileNotFoundException {
		LeitorPedidosCsv leitorPedidoCsv = new LeitorPedidosCsv();
		List<PedidoCsv> pedidosCsv = leitorPedidoCsv.lerPedidosCsv();
		
			//O Set é uma coleção de objetos únicos, portanto, quando se adiciona elementos repetidos nele esses elementos são automaticamente descartados.
			Set<String> set = new HashSet<String>(); 
			
			for (PedidoCsv pedido : pedidosCsv) {
				String categoria = pedido.getCategoria();
				set.add(categoria);
			}
			System.out.println("Total de categorias: " + set.size()); 

	}
	
}
