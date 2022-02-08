package edu.ifma.lbd.dao;

import java.util.List;

import javax.persistence.EntityManager;

import edu.ifma.lbd.modelo.*;

public class FreteRepositorio {
	private final EntityManager manager;
	private DAOGenerico<Frete> daoGenerico;

	public FreteRepositorio(EntityManager manager) {
		this.manager = manager;
		daoGenerico = new DAOGenerico<Frete>(manager);
	}

	public Frete buscaPor(Integer id) {
		return daoGenerico.buscaPorId(Frete.class, id);
	}

	public List<Frete> buscarFretePorUsuario(Cliente cliente) {
		return this.manager.createQuery("from Frete f where f.cliente = :clienteID", Frete.class)
				.setParameter("clienteID", cliente)
				.getResultList();
	}

	public Frete salvaOuAtualiza(Frete frete) {
		return daoGenerico.salvaOuAtualiza(frete);
	}

	public void remove(Frete frete) {
		daoGenerico.remove(frete);
	}
}
