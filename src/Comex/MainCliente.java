package Comex;
import java.util.ArrayList;


public class MainCliente {
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	public static boolean chave;
	
	public static void main(String[] args) {
		
		Cliente c1 = new Cliente("Ana", "111", "9090123", "Rua Y", "123", "Apartamento", "Santa clara", "Curitiba","PR");
		clientes.add(c1);
		
		Cliente c2 = new Cliente("Eli", "222", "9090321", "Rua M", "456", "Casa", "Rua do limoeiro", "Campo Largo","PR");
		clientes.add(c2);
		
		Cliente c3 = new Cliente("Gabi", "333", "9958874", "Rua X", "789", "Apartamento", "Alto da glória", "Pato branco","PR");
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
