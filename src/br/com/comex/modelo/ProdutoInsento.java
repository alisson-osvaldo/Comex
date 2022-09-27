package br.com.comex.modelo;

public class ProdutoInsento extends Produto{

	public ProdutoInsento(int id, String nome, double precoUnitario, int quantidadeEmEstoque,
			Categoria categoria) {
		super(id, nome, precoUnitario, quantidadeEmEstoque, categoria);
	}

	@Override
	public String calculaImposto() {
		String valor = super.calculaImposto();
		valor = "0";
		return valor;
	}
	
	
	
}
