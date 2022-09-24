package CalculadoraValorTotal;

public abstract class CalculadoraValorTotal {

	private double total;

	public double calcula(double valorUnitario, int quantidade) {
		this.total = valorUnitario * quantidade;
		System.out.println("\nValor Total: " + total);
		return total;
	}

}
