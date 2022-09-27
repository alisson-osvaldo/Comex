package br.com.comex.main;
import java.util.ArrayList;

import br.com.comex.modelo.Cliente;


public class MainCliente {
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	public static boolean chave;
	
	public static void main(String[] args) {
		
		Cliente c1 = new Cliente("Analura", "1234567891223", null, "Rua YYY", "123", "Apartamento", "Santa clara", "Curitiba","PR");
		clientes.add(c1);
		
		Cliente c2 = new Cliente("Eliezer", "12358778912234", "9090321785214", "Rua MMM", "456", "Casa", "Rua do limoeiro", "Campo Largo","PR");
		clientes.add(c2);
		
		Cliente c3 = new Cliente("Gabriela", "1999967891223", "9958874365874", "Rua TTT", "789", "Apartamento", "Alto da glória", "Pato branco","PR");
		clientes.add(c3);
		
		
		if (chave == false) {
			System.out.println(clientes);
		}else {
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
