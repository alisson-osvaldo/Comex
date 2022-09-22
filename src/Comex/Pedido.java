package Comex;

public class Pedido {
	
	private int id;
	private String data;
	private Cliente cliente;
	private static int cont = 1;
	
	public Pedido (String data, Cliente cliente) {
		this.id = cont++;
		this.data = data;
		this.cliente = cliente;
	}
	
	public int getId() {
		return id;
	}
	public String getData() {
		return data;
	}
	public Cliente getCliente() {
		return cliente;
	}

	@Override
	public String toString() {
		return "\nPedido: "
				+ "\n id= " + id 
				+ "\n data= " + data 
				+ "\n " + cliente + "\n\n";
	}

	
	

}
