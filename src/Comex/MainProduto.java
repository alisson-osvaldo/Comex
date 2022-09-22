package Comex;

import java.util.ArrayList;

public class MainProduto {
	private static ArrayList<Produto> produtos = new ArrayList<Produto>();
	public static boolean chave;
	
	public static void main(String[] args){
		
		//Inicializando
		MainCategoria.chave = true;
		MainCategoria.main(args);
		
		Produto p1 = new Produto();
		ProdutoInsento p2 = new ProdutoInsento();
		Produto p3 = new Produto();
		
		p1.setNome("Notebook Samsung");
		p1.setPrecoUnitario(3523.00);
		p1.setQuantidadeEmEstoque(5);
		p1.setCategoria(MainCategoria.vincularCategoria("Informática"));
		produtos.add(p1);
		
		p2.setNome("Clean Architecture");
		p2.setPrecoUnitario(102.90);
		p2.setQuantidadeEmEstoque(2);
		p2.setCategoria(MainCategoria.vincularCategoria("Livros"));
		produtos.add(p2);
		
		p3.setNome("Monitor Dell 27");
		p3.setPrecoUnitario(1889.00);
		p3.setQuantidadeEmEstoque(3);
		p3.setCategoria(MainCategoria.vincularCategoria("Informática"));
		produtos.add(p3);
		
				
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
