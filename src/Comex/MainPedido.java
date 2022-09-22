package Comex;

import java.util.ArrayList;

public class MainPedido {
	private static ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	public static boolean chave;
	
	public static void main(String[] args) {		
		
		//Inicializando
		MainCliente.chave = true;
		MainCliente.main(args);
		
		Cliente c1 = MainCliente.buscarCliente("Ana");
		Cliente c2 = MainCliente.buscarCliente("Eli");
		Cliente c3 = MainCliente.buscarCliente("Gabi");
		
		Pedido p1 = new Pedido("10/09/2022", c1);
		pedidos.add(p1);
		
		Pedido p2 = new Pedido("10/01/2020", c2);
		pedidos.add(p2);
		
		Pedido p3 = new Pedido("05/12/1990", c3);
		pedidos.add(p3);
		
		if (chave == false) {
			System.out.println(pedidos);
		}else {
			chave = false;
		}
			
	}
	
	public static Pedido BuscarPedido(int idPedido) {
		for(Pedido pedidoCadastrado : pedidos) {
			if(pedidoCadastrado.getId() == idPedido) {
				return pedidoCadastrado;
			}
		}
		return null;
	}

}
