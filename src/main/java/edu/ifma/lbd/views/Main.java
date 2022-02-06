package edu.ifma.lbd.views;

import java.util.Scanner;

import javax.persistence.*;

import edu.ifma.lbd.modelo.Cidade;
import edu.ifma.lbd.modelo.Cliente;
import edu.ifma.lbd.modelo.Frete;

public class Main {

	private static Scanner read;

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("lab05_jpa-test");
		EntityManager manager = factory.createEntityManager();
		
		Cliente cliente = new Cliente();
		Frete frete = new Frete();
		Cidade cidade = new Cidade();

		/*EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		
		cliente.setNome(nome_cli);
		cliente.setEndereco(end);
		cliente.setTelefone(telef);
		
		cidade.setNome("São Luís");
		cidade.setUf("Maranhão");
		cidade.setTaxa(10);

		frete.setDescricao("Celular");
		frete.setPeso(50);
		frete.setValcr((5010)+10);
		frete.setCidade(cidade);
		frete.setCliente(cliente);
		
		manager.persist(cliente);
		manager.persist(cidade);
		manager.persist(frete);

		transacao.commit();

		manager.close();
		factory.close();*/
		
		 read = new Scanner(System.in); 
		 int opcao = 0, quant_frete = 0;
		 String nome_cid, nome_cli, desc, uf, end, telef;
		 float tax, peso, valcr;
		 
		 do { 
			 System.out.print(" --- MENU --- \n 1 - Inserir Dados \n 0 - Sair\n Escolha uma opcao: ");
			 opcao = read.nextInt();
		  
			 switch(opcao){ 
			 	case 0: 
			 		System.out.print("\n Finalizando.... \n\n"); 
			 		break;
		  
				case 1: 
					System.out.print("\n  Inserindo.... \n");
					System.out.print("\n  Cliente.... \n"); 
					System.out.print(" Nome: "); nome_cli = read.next();
					System.out.print(" Endereço: "); end = read.nextLine();
					System.out.print(" Telefone: "); telef = read.nextLine();
					
					System.out.print("\n  Cidade.... \n");
					System.out.print(" Nome: "); nome_cid = read.nextLine();
					System.out.print(" UF: "); uf = read.nextLine();
					System.out.print(" Taxa: ");  tax = read.nextFloat();
					
					System.out.print(" Quantos fretes deseja cadastrar: "); quant_frete = read.nextInt();
					System.out.print("\n  Frete.... \n");
					for(int i = 0; i < quant_frete; i++) {
						System.out.print(" Descrição: "); desc = read.nextLine();
						System.out.print(" Peso: "); peso = read.nextFloat(); 
						valcr = ((peso*10) + tax);
						System.out.print(" Valor: " + valcr + "\n"); 
					}
					break;
		  
				case 2: 
					System.out.print("\n"); 
					break;
		  
				default: 
					System.out.print("\n Escolhar uma opção válida.... \n\n"); 
					break;
			 }
		 }while(opcao != 0);
	}
}
