package br.com.comex.main;
import java.util.ArrayList;

import br.com.comex.modelo.Cliente;
import br.com.comex.modelo.Cliente.Estados;

public class MainCliente {
	public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	public static boolean chave;
	
	public static void main(String[] args) {
			
		Cliente c1 = new Cliente("Analura", "823.457.791- 23", null, "Rua YYY", "123", "Apartamento", "Santa clara", "Curitiba" , Estados.PR);
		clientes.add(c1);
		
		Cliente c2 = new Cliente("Eliezer", "23.587.789-12", "(09)03217-8521", "Rua MMM", "456", "Casa", "Rua do limoeiro", "Campo Largo", br.com.comex.modelo.Cliente.Estados.PR);
		clientes.add(c2);
		
		Cliente c3 = new Cliente("Gabriela", "199.996.789-12", "(99)5887-4365", "Rua TTT", "789", "Apartamento", "Alto da glória", "Pato branco",Estados.PR);
		clientes.add(c3);
		
		
		
		//Testes exceptions 
		//Cliente c4 = new Cliente("Ana", "823.457.791- 23", null, "Rua YYY", "123", "Apartamento", "Santa clara", "Curitiba" , Estados.AP);
		//Cliente c4 = new Cliente("Analura", "823.791-23", null, "Rua YYY", "123", "Apartamento", "Santa clara", "Curitiba" , Estados.AP);
		//Cliente c4 = new Cliente("Analura", "AAA.457.791- 23", null, "Rua YYY", "52", "Apartamento", "Santa clara", "Curitiba" , Estados.AP);
		//Cliente c4 = new Cliente("Analura", "823.457.791- 23", "03217-852", "Rua YYY", "123", "Apartamento", "Santa clara", "Curitiba" , Estados.AP);
		//Cliente c4 = new Cliente("Analura", "123.457.791- 23", "(41)995A-9854", "Rua YYY", "52", "Apartamento", "Santa clara", "Curitiba" , Estados.AP);
		//Cliente c4 = new Cliente("Analura", "823.457.791- 23", null, "Rua", "123", "Apartamento", "Santa clara", "Curitiba" , Estados.AP);
		//Cliente c4 = new Cliente("Analura", "823.457.791- 23", null, "Rua YYY", "2", "Apartamento", "Santa clara", "Curitiba" , Estados.AP);
		//Cliente c4 = new Cliente("Analura", "823.457.791- 23", null, "Rua YYY", "82", "Apartamento", "S", "Curitiba" , Estados.AP);
		//Cliente c4 = new Cliente("Analura", "823.457.791- 23", null, "Rua YYY", "52", "Apartamento", "Santa clara", "C" , Estados.AP);
		//Cliente c4 = new Cliente("Analura", "823.457.791- 23", null, "Rua YYY", "52", "Apartamento", "Santa clara", "Curitiba" , Estados.TESTE);
		
		
		if (chave == false) {
			System.out.println(clientes);
		} else {
			chave = false;
		}
				
		
	}
	
	public static Cliente buscarCliente(String nomec) {
		for(Cliente clienteCadastrada : clientes) {
			if(clienteCadastrada.getNome().equals(nomec)) {
				return clienteCadastrada;
			}
		}
		return null;
	}
		
}
