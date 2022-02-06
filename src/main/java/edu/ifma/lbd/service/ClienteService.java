package edu.ifma.lbd.service;

import javax.persistence.EntityManager;

import edu.ifma.lbd.dao.ClienteDAO;
import edu.ifma.lbd.modelo.Cliente;
import edu.ifma.lbd.util.EMFactory;

public class ClienteService {
	private final ClienteDAO dao;
	private final EntityManager manager;

	public ClienteService() {
		this.manager = new EMFactory().getEntityManager();
		this.dao = new ClienteDAO(manager);
	}
	
	public Cliente salva(Cliente cliente) throws Exception {
		manager.getTransaction().begin();
		cliente = dao.salvaOuAtualiza(cliente);
		manager.getTransaction().commit();
		return cliente;		
	}
}
