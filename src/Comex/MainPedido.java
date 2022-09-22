package Comex;

import java.util.ArrayList;

public class MainPedido {

	public static void main(String[] args) {
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		
		ClienteController.main(args);
		
		Cliente c1 = ClienteController.buscarCliente("Ana");
		Cliente c2 = ClienteController.buscarCliente("Eli");
		Cliente c3 = ClienteController.buscarCliente("Gabi");
		
		Pedido p1 = new Pedido("10/09/2022", c1);
		pedidos.add(p1);
		
		Pedido p2 = new Pedido("10/09/2022", c2);
		pedidos.add(p2);
		
		Pedido p3 = new Pedido("10/09/2022", c3);
		pedidos.add(p3);
		
		System.out.println(pedidos);
	}

}
