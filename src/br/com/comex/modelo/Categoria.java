package br.com.comex.modelo;

import Exececoes.ComexException;
import enums.StatusCategoria;

public class Categoria {
	
	private int id;
	private String nome;
	private StatusCategoria status;
	private static int count = 1;
	
	public Categoria(int id, String nome, StatusCategoria status) {
		
		if (id <= 0) {
			throw new IllegalArgumentException("Error: Id igual ou menor que 0 !!!"); 
		} else if(nome.length() <= 3) {
			throw new IllegalArgumentException("Error: nome com menos de 3 carácteres !!! \n:");
		} else if(status != StatusCategoria.ATIVA && status != StatusCategoria.INATIVA){
			throw new ComexException("Testando ComexException: \n Error: Status:"  + status + "é inválido !!!");
		}
		
		//this.id = count++;
		//this.status = StatusCategoria.ATIVA;
		this.id = id;
		this.nome = nome;
		this.status = status;	
		
			
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
