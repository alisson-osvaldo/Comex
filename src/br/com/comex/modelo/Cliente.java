package br.com.comex.modelo;

public class Cliente {
	
	private int id;
	private String nome;
	private String cpf;
	private String telefone;
	private String rua;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private Estados estado;
	private static int cont = 1;
	
	public Cliente (String nome, String cpf, String telefone, String rua, String numero,
					String complemento, String bairro, String cidade, Estados estado) {
		
		this.id = cont++;
		this.nome = nome;
		this.cpf = cpf.replaceAll("\\s+",""); //Remove os espaços
		this.telefone = telefone;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		
		if (id <= 0) {
			throw new IllegalArgumentException("Error: Id deve ser maior que zero !!!"); 
		} 
		if (nome.length() <= 5) {
			throw new IllegalArgumentException("Error: nome deve ter mais que 5 caracteres !!! \n:");
		} 
		if(cpf.length() < 11 || cpf.length() > 16) {
			throw new IllegalArgumentException("Error: CPF deve ter entre 11 e 14 carácteres !!! \n:");
		}
		if(telefone != null) {
			if (telefone.length() < 11 || telefone.length() > 14) {
				throw new IllegalArgumentException("Error: Telefone deve ter entre 11 e 16 carácteres !!! \n:");
			}
		}
		if (rua.length() <= 5) {
			throw new IllegalArgumentException("Error: rua deve ter mais que 5 caracteres !!! \n:");
		} 
		if (numero.length() <= 1) {
			throw new IllegalArgumentException("Error: número deve ter mais que 1 caracteres !!! \n:");
		} 
		if (bairro.length() <= 1) {
			throw new IllegalArgumentException("Error: Bairro deve ter mais que 1 caracteres !!! \n:");
		} 
		if (cidade.length() <= 1) {
			throw new IllegalArgumentException("Error: Cidade deve ter mais que 1 caracteres !!! \n:");
		} 
		
		if (estado == null || estado.toString().length() < 2 || estado.toString().length() > 2) {
			throw new IllegalArgumentException("Error: Estado deve ter 2 caracteres e não pode ser NULL!!! \n:");
		}
		
		if (!nome.substring(0, 1).matches("[A-Z]*")) {
			throw new IllegalArgumentException("Nome não pode inicializar com números: " + nome); 
		}
		
		//CPF
		String formatcpf = cpf.replaceAll("\\.",""); //remove .
		formatcpf = formatcpf.replaceAll("-", "");   //remove -
		formatcpf = formatcpf.replaceAll("\\s+",""); //remove os espaços
		if (!formatcpf.matches("[0-9]+")) {          //verifica se tem valores diferentes de numéricos 
			throw new IllegalArgumentException("CPF não pode ter Letras: " + cpf);
			
		}
		
		//Telefone
		if(telefone != null) {
			String formatTelefone = telefone.replaceAll("\\(",""); 
			formatTelefone = formatTelefone.replaceAll("\\)","");  
			formatTelefone = formatTelefone.replaceAll("-", "");   
			formatTelefone = formatTelefone.replaceAll("\\s+",""); 
			if (!formatTelefone.matches("[0-9]+")) {               
				throw new IllegalArgumentException("Número de telefone não pode inicializar com Letras: " + telefone);
				
			}
		}

		
	}
	
	public enum Estados {
		AC, AL, AP, AM, BA, CE, DF, ES, GO, MA, MT, MS, MG, PA, PB,
		PR , PE, PI, RJ, RN, RS, RO, RR, SC, SP, SE, TO, TESTE;
	}
	

	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public String getRua() {
		return rua;
	}
	public String getNumero() {
		return numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public Estados getEstado() {
		return estado;
	}
	public static int getCont() {
		return cont;
	}


	@Override
	public String toString() {
		return "\nCliente: " + 
				"\n id= " + id + 
				"\n nome= " + nome + 
				"\n cpf=" + cpf + 
				"\n telefone=" + telefone + 
				"\n rua=" + rua +
				"\n numero=" + numero + 
				"\n complemento=" + complemento + 
				"\n bairro=" + bairro + 
				"\n cidade=" + cidade +
				"\n estado=" + estado + "\n\n";
	}
	
	
}
