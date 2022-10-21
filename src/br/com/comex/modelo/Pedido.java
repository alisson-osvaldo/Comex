package br.com.comex.modelo;

public class Pedido {
	
	private int id;
	private String data;
	private Cliente cliente;
	private int cliente_id;
	private static int cont = 1;
	
	public Pedido (String data, Cliente cliente) {
		this.id = cont++;
		this.data = data;
		this.cliente = cliente;
	}
	
	public Pedido (String data, int cliente_id) {
		this.data = data;
		this.cliente_id = cliente_id;
	}
	
	public Pedido (int id, String data, int cliente_id) {
		this.id = id;
		this.data = data;
		this.cliente_id = cliente_id;
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
	public int getCliente_id() {
		return cliente_id;
	}

	@Override
	public String toString() {
		return "\nPedido: "
				//+ "\n id= " + id 
				+ "\n data= " + data 
				//+ "\n " + cliente + "\n"
				+ "\n Cliente_id: " + cliente_id + "\n\n";
	}

	
	

}
