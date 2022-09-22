package Comex;

import java.util.ArrayList;

public class MainProduto {
	
	public static void main(String[] args) {
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		
		CadastrarCategoria.main(args);
		
		Produto p1 = new Produto();
		ProdutoInsento p2 = new ProdutoInsento();
		Produto p3 = new Produto();
		
		p1.setId(1);
		p1.setNome("Notebook Samsung");
		p1.setPrecoUnitario(3523.00);
		p1.setQuantidadeEmEstoque(5);
		p1.setCategoria(CadastrarCategoria.vincularCategoria("Informática"));
		produtos.add(p1);
		
		p2.setId(2);;
		p2.setNome("Clean Architecture");
		p2.setPrecoUnitario(102.90);
		p2.setQuantidadeEmEstoque(2);
		p2.setCategoria(CadastrarCategoria.vincularCategoria("Livros"));
		produtos.add(p2);
		
		p3.setId(3);
		p3.setNome("Monitor Dell 27");
		p3.setPrecoUnitario(1889.00);
		p3.setQuantidadeEmEstoque(3);
		p3.setCategoria(CadastrarCategoria.vincularCategoria("Informática"));
		produtos.add(p3);
		
				
		
		System.out.println(produtos);
		
		
	}
}
