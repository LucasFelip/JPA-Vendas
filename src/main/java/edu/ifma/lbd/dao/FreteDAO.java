package edu.ifma.lbd.dao;

import javax.persistence.EntityManager;
import java.util.List;

import edu.ifma.lbd.modelo.Frete;

public class FreteDAO {
	private final EntityManager manager;
	private DAOGenerico<Frete> daoGenerico;

	public FreteDAO(EntityManager manager) {
		this.manager = manager;
		this.daoGenerico = new DAOGenerico<Frete>(manager);
	}

	public Frete buscaPor(Integer id) {
		return daoGenerico.buscaPorId(Frete.class, id);
	}

	public List<Frete> porNome(String nome) {
		return this.manager.createQuery("from Frete where upper(nome) like :nome", Frete.class)
				.setParameter("nome", "%" + nome.toUpperCase() + "%").getResultList();
	}

	public Frete salvaOuAtualiza(Frete frete) {
		return daoGenerico.salvaOuAtualiza(frete);
	}

	public void remover(Frete frete) {
		daoGenerico.remove(frete);
	}
}
