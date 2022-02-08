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
		return this.manager.createQuery("select frete.descrição, f.peso, f.valcr from frete f where f.cidade_id = :clienteID", Frete.class)
				.setParameter("clientID", cliente.getId()).getResultList();
	}

	public Frete salvaOuAtualiza(Frete frete) {
		return daoGenerico.salvaOuAtualiza(frete);
	}

	public void remove(Frete frete) {
		daoGenerico.remove(frete);
	}
}
