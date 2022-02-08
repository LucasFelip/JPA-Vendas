package edu.ifma.lbd.dao;

import javax.persistence.EntityManager;
import java.util.List;

import edu.ifma.lbd.modelo.*;

public class CidadeRepositorio {
	private final EntityManager manager;
	private DAOGenerico<Cidade> daoGenerico;

	public CidadeRepositorio(EntityManager manager) {
		this.manager = manager;
		daoGenerico = new DAOGenerico<Cidade>(manager);
	}

	public Cidade buscaPor(Integer id) {
		return daoGenerico.buscaPorId(Cidade.class, id);
	}

	public List<Cidade> buscaPor(String nome) {
		return this.manager.createQuery("from cidade " + "where upper(nome) like :nome", Cidade.class)
				.setParameter("nome", nome.toUpperCase() + "%").getResultList();
	}

	public Cidade salvaOuAtualiza(Cidade cidade) {
		return daoGenerico.salvaOuAtualiza(cidade);
	}

	public void remove(Cidade cidade) {
		daoGenerico.remove(cidade);
	}

}
