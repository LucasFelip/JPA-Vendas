package edu.ifma.lbd.mains;

import edu.ifma.lbd.modelo.*;
import edu.ifma.lbd.dao.*;
import javax.persistence.*;

public class MainCliente {
	public static void main(String[] args) {	
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("lab05_jpa_transporte");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		FreteRepositorio freteRep = new FreteRepositorio(manager);

		Cliente cliente = new Cliente();
		Cidade cidade = new Cidade();
		Frete frete = new Frete();
		float valfx = 10;
		
		cliente.setNome("Lucas Felipe");
		cliente.setEndereco("Travessa da pedreira");
		cliente.setTelefone("98988525278");	
		manager.persist(cliente);
		
		cidade.setNome("São Luís");
		cidade.setTaxa(40);
		cidade.setUf("MA");
		manager.persist(cidade);
		
		frete.setDescricao("Celular");
		frete.setPeso(22);
		frete.setValcr((frete.getPeso() * valfx) + cidade.getTaxa());
		frete.setCidade(cidade);
		frete.setCliente(cliente);
		manager.persist(frete);
		
		cidade.adiciona(frete);
		manager.persist(cidade);
		
		cliente.adiciona(frete);
		manager.persist(cliente);
		
		System.err.print(freteRep.buscarFretePorUsuario(cliente));
		
		transacao.commit();

		manager.close();
		factory.close();	
	}
}
