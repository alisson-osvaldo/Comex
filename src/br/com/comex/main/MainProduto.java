package br.com.comex.main;

import java.util.ArrayList;

import br.com.comex.modelo.Produto;
import br.com.comex.modelo.ProdutoInsento;

public class MainProduto {
	private static ArrayList<Produto> produtos = new ArrayList<Produto>();
	public static boolean chave;
	
	public static void main(String[] args){
		
		//Inicializando
		MainCategoria.chave = true;
		MainCategoria.main(args);
		
		/*!!!!!! ATENÇÂO:para cadastrar um produto aqui lembre de comentar todos os testes de exceptions na MainCategoria !!!!!!*/
		
		Produto p1 = new Produto(1, "Notebook Samsung", 3523.00, 5, MainCategoria.vincularCategoria("Informática"));
		produtos.add(p1);
		ProdutoInsento p2 = new ProdutoInsento(2, "Clean Architecture", 102.90, 2, MainCategoria.vincularCategoria("Móveis"));
		produtos.add(p2);
		Produto p3 = new Produto(3, "Monitor Dell 27", 1889.00, 3, MainCategoria.vincularCategoria("Informática"));
		produtos.add(p3);
		//ProdutoInsento p5 = new ProdutoInsento();

	
		
		//Valores inválidos testes exception IllegalArgumentException 
		//Produto p4 = new Produto(0, "Notebook Samsung", 3523.00, 1, MainCategoria.vincularCategoria("Informática"));
		
		//Produto p4 = new Produto(4, "Not", 3523.00, 1, MainCategoria.vincularCategoria("Informática"));

		//Produto p4 = new Produto(4, "Notebook Samsung", 0, 1, MainCategoria.vincularCategoria("Informática"));		
				
		//Produto p4 = new Produto(4, "Notebook Samsung", 3523.00, 1, null);
		
		//Teste exception ProdutoInsento
		//ProdutoInsento p5 = new ProdutoInsento(5, "T.I", 102.90, 2, MainCategoria.vincularCategoria("Móveis"));
		
		if (chave == false) {
			System.out.println(produtos);
		} else {
			chave = false;
		}
		
			
		
		
	}
	
	public static Produto BuscarProduto(int idProduto) {
		for(Produto produtoCadastrado : produtos) {
			if(produtoCadastrado.getId() == idProduto) {
				return produtoCadastrado;
			}
		}
		return null;
	}
	

	
}
