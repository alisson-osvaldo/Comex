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
		} 
		if(nome.length() <= 3) {
			throw new IllegalArgumentException("Error: nome com menos de 3 carácteres !!! \n:");
		} 
		if(status != StatusCategoria.ATIVA && status != StatusCategoria.INATIVA){
			throw new ComexException("Testando ComexException: \n Error: Status:"  + status + "é inválido !!!");
		}
		
		if (!nome.substring(0, 1).matches("[A-Z]*")) {
			throw new IllegalArgumentException("Nome não pode inicializar com números: " + nome); 
		}
		
		this.id = id;
		this.nome = nome;
		this.status = status;	
		
			
	}
	
	public Categoria(String nome, StatusCategoria status) {
		this.id = count++;
		this.nome = nome;
		this.status = StatusCategoria.ATIVA;
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
