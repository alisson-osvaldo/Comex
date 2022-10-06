package br.com.comex.main;

import java.util.ArrayList;

import br.com.comex.modelo.Categoria;
import br.com.comex.modelo.Categoria.Status;


public class MainCategoria {
	public static ArrayList<Categoria> categorias = new ArrayList<Categoria>();
	public static boolean chave;
	
	public static void main(String[] args) {
	    
		Categoria c1 = new Categoria("Informática", Status.ATIVA);
		categorias.add(c1);
		Categoria c2 = new Categoria("Móveis", Status.INATIVA);
		categorias.add(c2);
		Categoria c3 = new Categoria("Livros", Status.ATIVA);
		categorias.add(c3);
		
		
		//Valores inválidos testes exception 
		//Categoria c4 = new Categoria(0, "Informática", Status.ATIVA);
		//Categoria c4 = new Categoria(4, "T.I", Status.ATIVA);
		//Categoria c4 = new Categoria(4, "Informática", Status.PENDENTE);
		//Categoria c4 = new Categoria(4, "Informática", null);
		
		if (chave == false) {
			System.out.println(categorias);
		}else {
			chave = false;
		}	
	}
	
	
	public static Categoria vincularCategoria(String nomec) {
		
		for(Categoria categoriaCadastrada : categorias) {
			if(categoriaCadastrada.getNome().equals(nomec)) {
				return categoriaCadastrada;
			}
		}
		return null;
	}
	
	
	
	
}
