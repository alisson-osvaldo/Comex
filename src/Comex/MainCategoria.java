package Comex;

import java.util.ArrayList;


public class MainCategoria {
	private static ArrayList<Categoria> categorias = new ArrayList<Categoria>();
	public static boolean chave;
	
	public static void main(String[] args) {
	    
		Categoria c1 = new Categoria();
		Categoria c2 = new Categoria();
		Categoria c3 = new Categoria();
		
		c1.setNome("Informática");
		
		c2.setNome("Móveis");
		c2.setStatus("INATIVA");
		
		c3.setId(3);
		c3.setNome("Livros");
		
		
		categorias.add(c1);
		categorias.add(c2);
		categorias.add(c3);

		
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
