package br.com.comex.main;

import br.com.comex.modelo.ItemPedido;
import br.com.comex.modelo.Produto;

public class MainCalculadoraValorTotal {

	public static void main(String[] args){
		
		//Inicializando
		MainCategoria.chave = true;
		MainCategoria.main(args);

		//Produto
		Produto p1 = new Produto(1, "Notebook Samsung", 3523.00, 5, MainCategoria.vincularCategoria("Informática"));
		
		p1.calcula(p1.getPrecoUnitario(), p1.getQuantidadeEmEstoque());
		
		
		//ItemPedido		
		ItemPedido p2 = new ItemPedido(10.0, 2, p1, null, 0, null);
		p2.calcula(p2.getPrecoUnitario(), p2.getQuantidade());
		
		
	}
	
}
