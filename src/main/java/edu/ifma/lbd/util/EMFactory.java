package edu.ifma.lbd.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFactory {

	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("lab05_jpa-test");

	public EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

	public void close() {
		factory.close();
	}
}
