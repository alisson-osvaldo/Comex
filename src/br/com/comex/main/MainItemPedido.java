package br.com.comex.main;

import java.util.ArrayList;

import br.com.comex.modelo.ItemPedido;

public class MainItemPedido {

	public static void main(String[] args) {
		ArrayList<ItemPedido> Items = new ArrayList<ItemPedido>();
		
		//Inicializando 
		MainProduto.chave = true;
		MainProduto.main(args);
		
		MainPedido.chave = true;
		MainPedido.main(args);	
		
		ItemPedido p1 = new ItemPedido( 
				MainProduto.BuscarProduto(1).getPrecoUnitario(), 
				2, 
				MainProduto.BuscarProduto(1), 
				MainPedido.BuscarPedido(1), 
				10, 
				"PROMOCAO");
		Items.add(p1);
		
		ItemPedido p2 = new ItemPedido( 
				MainProduto.BuscarProduto(2).getPrecoUnitario(), 
				0, 
				MainProduto.BuscarProduto(2), 
				MainPedido.BuscarPedido(2), 
				0, 
				"NEMHUM");
		Items.add(p2);
		
		ItemPedido p3 = new ItemPedido( 
				MainProduto.BuscarProduto(3).getPrecoUnitario(), 
				12, 
				MainProduto.BuscarProduto(3), 
				MainPedido.BuscarPedido(3), 
				100, 
				"QUANTIDADE");
		Items.add(p3);
		
		System.out.println(Items);
				
	}
	
	

}
