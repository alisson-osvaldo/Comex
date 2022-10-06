package br.com.comex.csv;

import java.io.FileNotFoundException;
import java.util.List;

import br.com.comex.main.MainCategoria;
import br.com.comex.main.MainCliente;
import br.com.comex.main.MainPedido;
import br.com.comex.main.MainProduto;
import br.com.comex.modelo.Categoria;
import br.com.comex.modelo.Categoria.Status;
import br.com.comex.modelo.Cliente.Estados;
import br.com.comex.modelo.Pedido;
import br.com.comex.modelo.Cliente;
import br.com.comex.modelo.Produto;

public class PedidoCsvParaPedido {

	public static void main(String[] args) throws FileNotFoundException {
		
		LeitorPedidosCsv leitorPedidoCsv = new LeitorPedidosCsv();
		List<PedidoCsv> pedidosCsv = leitorPedidoCsv.lerPedidosCsv();
		
		
		for (PedidoCsv pedido : pedidosCsv) { 
			
			Categoria c = new Categoria(pedido.getCategoria(), Status.ATIVA);
			MainCategoria.categorias.add(c);
			
			Produto p = new Produto(pedido.getProduto(), Double.parseDouble(pedido.getPreco()), Integer.parseInt(pedido.getQuantidade()), MainCategoria.vincularCategoria(pedido.getCategoria()));
			MainProduto.produtos.add(p);
			
			Cliente cl = new Cliente(pedido.getCliente() + "****", "823.457.791- 23", null, "Rua TTT", "456", "Casa", "Rua do limoeiro", "Campo Largo", Estados.PR);
			MainCliente.clientes.add(cl);
			
			Pedido newPedido = new Pedido(pedido.getData(), cl);
			MainPedido.pedidos.add(newPedido);
		
		}
		System.out.println("\n----------------------------------------------------------------------------");
		System.out.println("\nCATEGORIA: " + MainCategoria.categorias);
		System.out.println("\n----------------------------------------------------------------------------");
		System.out.println("\nPRODUTO: " + MainProduto.produtos);
		System.out.println("\n----------------------------------------------------------------------------");
		System.out.println("\nCLIENTE: " + MainCliente.clientes);
		System.out.println("\n----------------------------------------------------------------------------");
		System.out.println("\nPEDIDO: " + MainPedido.pedidos);
	}

}
