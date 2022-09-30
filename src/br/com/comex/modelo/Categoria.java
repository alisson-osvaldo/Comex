package br.com.comex.modelo;

import br.com.minhas_exececoes.ComexException;

public class Categoria {
	
	private int id;
	private String nome;
	private Status status = Status.ATIVA;
	private static int count = 1;
	
	public Categoria(int id, String nome, Status status) {
		
		if (id <= 0) {
			throw new IllegalArgumentException("Error: Id igual ou menor que 0 !!!"); 
		} 
		if(nome.length() <= 3) {
			throw new IllegalArgumentException("Error: nome com menos de 3 carácteres !!! \n:");
		} 
		
		
		if(status == null || status != Status.ATIVA && status != Status.INATIVA){
			throw new ComexException("Testando ComexException: \n Error: Status:"  + status + " é inválido !!!");
		}
		
				
		if (!nome.substring(0, 1).matches("[A-Z]*")) {
			throw new IllegalArgumentException("Nome não pode inicializar com números: " + nome); 
		}
		
		if (id != count) {
			throw new IllegalArgumentException("O id informado é diferente do próximo id "); 
		}
		
		this.id = id;
		this.nome = nome;
		this.status = status;	
		
			
	}
	
	public Categoria(String nome, Status status) {
		this.id = count++;
		this.nome = nome;
		this.status = status;
	}
	
	public enum Status{
		//Status PENDENTE é apenas para teste de uma EXCEPTION
		ATIVA, INATIVA, PENDENTE
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\n Categoria " + this.nome + "(" + this.id + "-" + this.status + ")";
	}
	
}
