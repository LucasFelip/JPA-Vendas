package edu.ifma.lbd.service;

import javax.persistence.EntityManager;

import edu.ifma.lbd.dao.FreteDAO;
import edu.ifma.lbd.modelo.Frete;
import edu.ifma.lbd.util.EMFactory;

public class FreteService {
	private final FreteDAO dao;
	private final EntityManager manager;

	public FreteService() {
		this.manager = new EMFactory().getEntityManager();
		this.dao = new FreteDAO(manager);
	}
	
	public Frete salva(Frete frete) throws Exception {
		manager.getTransaction().begin();
		frete = dao.salvaOuAtualiza(frete);
		manager.getTransaction().commit();
		return frete;		
	}
}
