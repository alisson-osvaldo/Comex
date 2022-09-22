package Comex;

public class Categoria {
	
	private int id;
	private String nome;
	private String status;
	private static int count = 1;
	
	public Categoria() {
		this.status = "ATIVA";
		this.id = count++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\n Categoria " + this.nome + "(" + this.id + "-" + this.status + ")";
	}
	
}
