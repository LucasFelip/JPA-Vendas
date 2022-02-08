package edu.ifma.lbd.dao;

import javax.persistence.EntityManager;
import java.util.List;

import edu.ifma.lbd.modelo.*;

public class ClienteRepositorio {
	private final EntityManager manager;
	private DAOGenerico<Cliente> daoGenerico;

	public ClienteRepositorio(EntityManager manager) {
		this.manager = manager;
		daoGenerico = new DAOGenerico<Cliente>(manager);
	}

	public Cliente buscaPor(Integer id) {
		return daoGenerico.buscaPorId(Cliente.class, id);
	}

	public List<Cliente> buscaPor(String nome) {
		return this.manager.createQuery("from Cliente c where c.nome like :nome", Cliente.class)
				.setParameter("nome", nome.toLowerCase() + "%").getResultList();
	}

	public Cliente salvaOuAtualiza(Cliente cliente) {
		return daoGenerico.salvaOuAtualiza(cliente);
	}

	public void remove(Cliente cliente) {
		daoGenerico.remove(cliente);
	}
}
