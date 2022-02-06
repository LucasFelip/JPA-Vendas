package edu.ifma.lbd.service;

import javax.persistence.EntityManager;

import edu.ifma.lbd.dao.CidadeDAO;
import edu.ifma.lbd.modelo.Cidade;
import edu.ifma.lbd.util.EMFactory;

public class CidadeService {
	private final CidadeDAO dao;
	private final EntityManager manager;
	
	public CidadeService() {
		this.manager = new EMFactory().getEntityManager();
		this.dao = new CidadeDAO(manager);
	}
	
	public Cidade salva(Cidade cidade) throws Exception {
		manager.getTransaction().begin();
		cidade = dao.salvaOuAtualiza(cidade);
		manager.getTransaction().commit();
		return cidade;		
	}
}
