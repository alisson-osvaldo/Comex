package Comex;

public class Categoria {
	
	private int id;
	private String nome;
	private StatusCategoria status;
	private static int count = 1;
	
	public Categoria() {
		this.status = StatusCategoria.ATIVA;
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

	public StatusCategoria getStatus() {
		return status;
	}

	public void setStatus(StatusCategoria status) {
		this.status = status;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\n Categoria " + this.nome + "(" + this.id + "-" + this.status + ")";
	}
	
}
