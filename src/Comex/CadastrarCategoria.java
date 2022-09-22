package Comex;

import java.util.ArrayList;

public class CadastrarCategoria {

	private static ArrayList<Categoria> categorias = new ArrayList<Categoria>();
	

	public static void main(String[] args) {
	    
		Categoria informatica = new Categoria();
		Categoria moveis 	  = new Categoria();
		Categoria livros      = new Categoria();
		
		informatica.setId(1);
		informatica.setNome("Informática");
		
		moveis.setId(2);
		moveis.setNome("Móveis");
		moveis.setStatus("INATIVA");
		
		livros.setId(3);
		livros.setNome("Livros");
		
		
		categorias.add(informatica);
		categorias.add(moveis);
		categorias.add(livros);
			
			
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
