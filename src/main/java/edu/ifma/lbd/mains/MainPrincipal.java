package edu.ifma.lbd.mains;

import edu.ifma.lbd.modelo.*;
import edu.ifma.lbd.service.*;
import edu.ifma.lbd.dao.*;

import java.util.*;

import javax.persistence.*;

public class MainPrincipal {
	static Scanner read;
	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("lab05_jpa_transporte");
	static EntityManager manager = factory.createEntityManager();

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {
		read = new Scanner(System.in);
		int opcao = 0;
		System.out.print("\n\n	Aluno: Lucas Felipe \n\n hibernate.show_sql está configuado para 'false'\n apenas para melhor visualizar a 'interface do sistema' \n\n");
		do {
			System.out.print(
					"	 --- MENU --- \n	 1 - Inserir \n	 2 - Buscar Frete por Cliente \n	 0 - Sair \n	 Escolha uma opção: ");
			opcao = read.nextInt();

			switch (opcao) {
			case 0:
				System.out.print("\n\n Finalizado.... \n\n");
				break;

			case 1:
				inserir();
				break;

			case 2:
				buscarFretePorCliente();
				break;

			default:
				System.out.print("\n\n Escolha uma opção válida.... \n\n");
				break;
			}
		} while (opcao != 0);
		manager.close();
		factory.close();
	}

	public static void inserir() {
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();

		Cliente cliente = new Cliente();
		Cidade cidade = new Cidade();
		Frete frete = new Frete();
		
		float valfx = 10, valcr, x;
		
		read = new Scanner(System.in);
		System.out.println("\n	Inserindo.... ");
		System.out.println("\n	....Cliente ");
		System.out.print("	Nome: "); cliente.setNome(read.next());
		read = new Scanner(System.in);
		System.out.print("	Endereço: "); cliente.setEndereco(read.nextLine());
		read = new Scanner(System.in);
		System.out.print("	Telefone: "); cliente.setTelefone(read.nextLine());
		manager.persist(cliente);

		System.out.println("\n\n	....Cidade ");
		System.out.print("	Nome: "); cidade.setNome(read.next());
		read = new Scanner(System.in);
		System.out.print("	UF: "); cidade.setUf(read.nextLine());
		read = new Scanner(System.in);
		System.out.print("	Taxa: "); cidade.setTaxa(read.nextFloat());
		manager.persist(cidade);

		System.out.println("\n\n	....Frete ");
		System.out.print("	Quantos fretes deseja cadastrar: ");
		x = read.nextInt();
		for (int i = 0; i < x; i++) {
			System.out.print("	Descrição: "); frete.setDescricao(read.next());
			read = new Scanner(System.in);
			System.out.print("	Peso: "); frete.setPeso(read.nextFloat());
			read = new Scanner(System.in);
			valcr = (frete.getPeso() * valfx) + cidade.getTaxa();
			frete.setValcr(valcr);
			System.out.println("	Valor: " + valcr);
			frete.setCidade(cidade);
			frete.setCliente(cliente);
			manager.persist(frete);

			cliente.adiciona(frete);
			manager.persist(cliente);

			cidade.adiciona(frete);
			manager.persist(cidade);
		}
		transacao.commit();
		System.out.println("\n\n\n");
	}

	public static void buscarFretePorCliente() {
		String nome;
		System.out.println("\n	Buscando.... ");
		read = new Scanner(System.in);
		System.out.print("	Digite um nome: "); nome = read.nextLine();
		
		FreteRepositorio freteRep = new FreteRepositorio(manager);
		FreteService freteSer = new FreteService(freteRep);

		ClienteRepositorio clienteRep = new ClienteRepositorio(manager);
		ClienteService clienteSer = new ClienteService(clienteRep);
		
		List<Cliente> clienteBusca = clienteSer.buscarPorNome(nome);
		List<Frete> freteBusca;
		for (int i = 0; i < clienteBusca.size(); i++) {
			freteBusca = freteSer.buscarTodosFretePorUsuario(clienteBusca.get(i));
			for (int y = 0; y < freteBusca.size(); y++) {
				System.out.println("\n	Nome: " + freteBusca.get(y).getCliente().getNome());
				System.out.println("	Cidade: " + freteBusca.get(y).getCidade().getNome());
				System.out.println("	Descrição: " + freteBusca.get(y).getDescricao());
				System.out.println("	Peso: " + freteBusca.get(y).getPeso());
				System.out.println("	Valor: " + freteBusca.get(y).getValcr());
			}
		}
		System.out.println("\n\n\n");
	}
}