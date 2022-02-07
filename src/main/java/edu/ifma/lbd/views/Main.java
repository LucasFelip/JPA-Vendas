package edu.ifma.lbd.views;

import edu.ifma.lbd.modelo.*;
import edu.ifma.lbd.service.*;
import javax.persistence.*;

public class Main {

	public static void main(String[] args) throws Exception {	
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("lab05_jpa-test");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		//Entidades
		Cliente cliente = new Cliente();
		Cidade cidade = new Cidade();
		Frete frete = new Frete();
		
		//Dados
		cliente.setNome("Lucas");
		cliente.setEndereco("Rua 16");
		cliente.setTelefone("988525278");
		
		cidade.setNome("São Luís");
		cidade.setUf("MA");
		cidade.setTaxa(10);

		frete.setDescricao("Celular");
		frete.setPeso(50);
		frete.setValcr((50*10)+10);
		frete.setCidade(cidade);
		frete.setCliente(cliente);
		
		cliente.adiciona(frete);
		cidade.adiciona(frete);
		
		ClienteService clienteServ = new ClienteService();
		CidadeService cidadeServ = new CidadeService();
		FreteService freteServ = new FreteService();
		
		clienteServ.salva(cliente);
		cidadeServ.salva(cidade);
		freteServ.salva(frete);
		
		manager.persist(cidade);
		manager.persist(cliente);
		manager.persist(frete);

		transacao.commit();

		manager.close();
		factory.close();
		
	}
}
