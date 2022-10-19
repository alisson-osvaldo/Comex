package br.com.comex.ws;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.comex.dao.CategoriaDAO;
import br.com.comex.dao.ClienteDAO;
import br.com.comex.dao.ProdutoDAO;
import br.com.comex.factory.ConnectionFactory;
import br.com.comex.modelo.Categoria;
import br.com.comex.modelo.Categoria.Status;
import br.com.comex.modelo.Cliente;
import br.com.comex.modelo.Cliente.Estados;
import br.com.comex.modelo.Produto;


@WebService
public class ComexWS {
	
	@WebMethod(operationName="listarCategorias")
	@WebResult(name="categoria")
	public List<Categoria> getCategorias() throws SQLException{	
		List<Categoria> listaDeCategorias = new ArrayList<Categoria>();
		
		try(Connection connection = new ConnectionFactory().getConnection()){
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			listaDeCategorias = categoriaDAO.listarTodos();
			connection.close();	
		}catch (Exception e) {
			e.printStackTrace();
		}
		return listaDeCategorias;	
	}
	
	
	@WebMethod(operationName="CadastrarCategoria") 
	@WebResult(name="categoria")
	public Categoria adicionarCategoria(@WebParam(name = "nome")String nome) throws SQLException {
		Categoria categoria = new Categoria();
		
		try(Connection connection = new ConnectionFactory().getConnection()){
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			categoria.setNome(nome);
			categoria.setStatus(Status.ATIVA);
			categoriaDAO.inserir(categoria);
			connection.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return categoria;
	}
	
	
	@WebMethod(operationName="TodosOsClientes")
	@WebResult(name="cliente")
	public List<Cliente> listarClientes()throws SQLException{
		List<Cliente> listaDeClientes = new ArrayList<Cliente>();
		
		try(Connection connection = new ConnectionFactory().getConnection()){
			ClienteDAO clienteDAO = new ClienteDAO(connection);
			listaDeClientes = clienteDAO.listarTodos();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return listaDeClientes;	
	}
	
	
	@WebMethod(operationName="CadastrarCliente") 
	@WebResult(name="cliente")
	public Cliente adicionarCliente(
			@WebParam(name = "nome")String nome, 
			@WebParam(name = "cpf")String cpf,
			@WebParam(name = "telefone")String telefone,
			@WebParam(name = "rua")String rua,
			@WebParam(name = "numero")String numero,
			@WebParam(name = "complemento")String complemento,
			@WebParam(name = "bairro")String bairro,
			@WebParam(name = "cidade")String cidade,
			@WebParam(name = "uf")String uf)throws SQLException {
		
		Cliente cliente = new Cliente();
		
		try(Connection connection = new ConnectionFactory().getConnection()){
			ClienteDAO clienteDAO = new ClienteDAO(connection);
			cliente.setNome(nome);
			cliente.setCpf(cpf);
			cliente.setTelefone(telefone);
			cliente.setRua(rua);
			cliente.setNumero(numero);
			cliente.setComplemento(complemento);
			cliente.setBairro(bairro);
			cliente.setCidade(cidade);
			String estado = uf;
			cliente.setEstado(Estados.valueOf(estado));
			clienteDAO.inserir(cliente);
			connection.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return cliente;
	}
	
	
	@WebMethod(operationName="TodosOsProdutos")
	@WebResult(name="produto")
	public List<Produto> listarProdutos()throws SQLException{
		List<Produto> listaDeProdutos = new ArrayList<Produto>();
		
		try(Connection connection = new ConnectionFactory().getConnection()){
			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
			listaDeProdutos = produtoDAO.listarTodos();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return listaDeProdutos;	
	}
	
}








