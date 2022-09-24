package CalculadoraValorTotal;

import Comex.ItemPedido;
import Comex.MainCategoria;
import Comex.Produto;

public class MainCalculadoraValorTotal {

	public static void main(String[] args){
		
		//Produto
		Produto p1 = new Produto();
	
		p1.setNome("Notebook Samsung");
		p1.setPrecoUnitario(3523.00);
		p1.setQuantidadeEmEstoque(5);
		p1.setCategoria(MainCategoria.vincularCategoria("Informática"));
		
		p1.calcula(p1.getPrecoUnitario(), p1.getQuantidadeEmEstoque());
		
		
		//ItemPedido		
		ItemPedido p2 = new ItemPedido(10.0, 2, p1, null, 0, null);
		p2.calcula(p2.getPrecoUnitario(), p2.getQuantidade());
		
		
	}
	
}
