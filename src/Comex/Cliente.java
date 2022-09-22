package Comex;

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
