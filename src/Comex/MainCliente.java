package Comex;
import java.util.ArrayList;


public class MainCliente {
	
	public static void main(String[] args) {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		Cliente c1 = new Cliente("Ana", "111", "9090123", "Rua Y", "123", "Apartamento", "Santa clara", "Curitiba","PR");
		clientes.add(c1);
		
		Cliente c2 = new Cliente("Eli", "222", "9090321", "Rua M", "456", "Casa", "Rua do limoeiro", "Campo Largo","PR");
		clientes.add(c2);
		
		Cliente c3 = new Cliente("Gabi", "333", "9958874", "Rua X", "789", "Apartamento", "Alto da glória", "Pato branco","PR");
		clientes.add(c3);
		
		System.out.println(clientes);
		
	}
		
}
