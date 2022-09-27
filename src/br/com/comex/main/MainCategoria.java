package br.com.comex.main;

import java.util.ArrayList;

import br.com.comex.modelo.Categoria;
import enums.StatusCategoria;


public class MainCategoria {
	private static ArrayList<Categoria> categorias = new ArrayList<Categoria>();
	public static boolean chave;
	
	public static void main(String[] args) {
	    
		Categoria c1 = new Categoria(1, "Informática", StatusCategoria.ATIVA);
		categorias.add(c1);
		Categoria c2 = new Categoria(2, "Móveis", StatusCategoria.INATIVA);
		categorias.add(c2);
		Categoria c3 = new Categoria(3, "Livros", StatusCategoria.ATIVA);
		categorias.add(c3);
		
		
		//Valores inválidos teste exception IllegalArgumentException 
		//Categoria c4 = new Categoria(0, "informática", StatusCategoria.PENDENTE);
		
		//Categoria c4 = new Categoria(4, "T.I", StatusCategoria.PENDENTE);
	
		//Categoria c4 = new Categoria(4, "informática", StatusCategoria.PENDENTE);
		
		
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
		//throw new IllegalArgumentException("Categoria não encontrada");
		return null;
	}
	
	
	
	
}
