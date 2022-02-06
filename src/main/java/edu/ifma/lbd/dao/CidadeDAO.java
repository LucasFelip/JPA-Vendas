package edu.ifma.lbd.dao;

import java.util.List;
import javax.persistence.EntityManager;

import edu.ifma.lbd.modelo.Cidade;

public class CidadeDAO {
	private final EntityManager manager;
	private final DAOGenerico<Cidade> daoGenerico;

	public CidadeDAO(EntityManager manager) {
		this.manager = manager;
		this.daoGenerico = new DAOGenerico<Cidade>(manager);
	}

	public Cidade buscaPor(Integer id) {
		return daoGenerico.buscaPorId(Cidade.class, id);
	}

	public Cidade salvaOuAtualiza(Cidade cidade) {
		return daoGenerico.salvaOuAtualiza(cidade);
	}

	public void remover(Cidade cidade) {
		daoGenerico.remove(cidade);
	}

	public List<Cidade> porNome(String nome) {
		return this.manager.createQuery("from Cidade where upper(nome) like :nome", Cidade.class)
				.setParameter("nome", "%" + nome.toUpperCase() + "%").getResultList();
	}
}
