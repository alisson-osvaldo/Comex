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
	private String estado;
	private static int cont = 1;
	
	public Cliente (String nome, String cpf, String telefone, String rua, String numero,
					String complemento, String bairro, String cidade, String estado) {
		
		this.id = cont++;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		
		if (id <= 0) {
			throw new IllegalArgumentException("Error: Id deve ser maior que zero !!!"); 
		} else if (nome.length() <= 5) {
			throw new IllegalArgumentException("Error: nome deve ter mais que 5 caracteres !!! \n:");
		} else if(cpf.length() < 11 || cpf.length() > 16) {
			throw new IllegalArgumentException("Error: CPF deve ter entre 11 e 14 carácteres !!! \n:");
		}else if(telefone != null) {
			if (telefone.length() < 11 || telefone.length() > 14) {
				throw new IllegalArgumentException("Error: Telefone deve ter entre 11 e 16 carácteres !!! \n:");
			}
		}else if (rua.length() <= 5) {
			throw new IllegalArgumentException("Error: rua deve ter mais que 5 caracteres !!! \n:");
		} else if (numero.length() < 1) {
			throw new IllegalArgumentException("Error: número deve ter mais que 1 caracteres !!! \n:");
		} else if (bairro.length() < 1) {
			throw new IllegalArgumentException("Error: Bairro deve ter mais que 1 caracteres !!! \n:");
		} else if (cidade.length() < 1) {
			throw new IllegalArgumentException("Error: Cidade deve ter mais que 1 caracteres !!! \n:");
		} else if (estado.length() < 2 || estado.length() > 2) {
			throw new IllegalArgumentException("Error: Estado deve ter 2 caracteres !!! \n:");
		}
		
			
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
	public String getEstado() {
		return estado;
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
