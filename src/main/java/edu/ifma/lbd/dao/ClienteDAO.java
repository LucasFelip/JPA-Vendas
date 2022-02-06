package edu.ifma.lbd.dao;

import java.util.List;
import javax.persistence.EntityManager;

import edu.ifma.lbd.modelo.Cliente;

public class ClienteDAO {

	private final EntityManager manager;
	private DAOGenerico<Cliente> daoGenerico;

	public ClienteDAO(EntityManager manager) {
		this.manager = manager;
		daoGenerico = new DAOGenerico<Cliente>(manager);
	}

	public Cliente buscaPor(Integer id) {
		return daoGenerico.buscaPorId(Cliente.class, id);
	}

	public List<Cliente> buscaPor(String nome) {
		return this.manager.createQuery("from Cliente " + "where upper(nome) like :nome", Cliente.class)
				.setParameter("nome", nome.toUpperCase() + "%").getResultList();
	}

	public Cliente salvaOuAtualiza(Cliente cliente) {
		return daoGenerico.salvaOuAtualiza(cliente);
	}

	public void remove(Cliente cliente) {
		daoGenerico.remove(cliente);
	}
}
