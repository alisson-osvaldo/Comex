package Comex;

public class ProdutoInsento extends Produto{

	@Override
	public String calculaImposto() {
		// TODO Auto-generated method stub
		String valor = super.calculaImposto();
		valor = "0";
		return valor;
	}
	
	
	
}
