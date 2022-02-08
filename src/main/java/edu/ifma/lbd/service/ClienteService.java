package edu.ifma.lbd.service;

import java.util.*;

import edu.ifma.lbd.dao.ClienteRepositorio;
import edu.ifma.lbd.modelo.Cliente;

public class ClienteService {
	private final ClienteRepositorio dao;

	public ClienteService(ClienteRepositorio clienteRepositorio) {
		this.dao = clienteRepositorio;
	}

	public Cliente salva(Cliente cliente) throws Exception {
		return dao.salvaOuAtualiza(cliente);
	}
	
	public List<Cliente> buscarPorNome(String cliente) {
		return dao.buscaPor(cliente);
	}
}
