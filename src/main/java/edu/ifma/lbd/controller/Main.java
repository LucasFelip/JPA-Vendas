package edu.ifma.lbd.controller;

import java.util.List;
import java.util.Scanner;

import edu.ifma.lbd.dao.CidadeDAO;
import edu.ifma.lbd.dao.ClienteDAO;
import edu.ifma.lbd.dao.FreteDAO;
import edu.ifma.lbd.modelo.Cidade;
import edu.ifma.lbd.modelo.Cliente;
import edu.ifma.lbd.modelo.Frete;

public class Main {
	
	private static Scanner read;
	private static List<Frete> f;

	public static void main(String[] args) {
		read = new Scanner(System.in);
		
		Cliente cli = new Cliente();
		ClienteDAO cliDAO = new ClienteDAO();
		
		Cidade cid = new Cidade();
		CidadeDAO cidDAO = new CidadeDAO();
		
		f = null;
		FreteDAO freDAO = new FreteDAO();
		
		int i = 0, y;

		String nomeCli, endCli, telCli, nomeCid, ufCid, desFre;
		float taxCid, pesoFre, valFre;
		
		do{
			System.out.print(" *** --- MENU --- *** \n 1 - Inserir \n 2 - Buscar por frete \n 3 - Listar por frete \n 0 - Sair \n Escolha uma opção: "); i = read.nextInt();
			System.out.print("\n\n\n");
			
			switch(i) {
				case 0:
					System.out.print("** Finalizando.... **");
					break;
					
				case 1:
					System.out.print("** Inserindo Cliente **");
					System.out.print("\n Nome: "); nomeCli = read.next();
					System.out.print("\n Endereço: "); endCli = read.next();
					System.out.print("\n Telefone: "); telCli = read.next();
					
					System.out.print("** Inserindo Cidade **");
					System.out.print("\n Nome: "); nomeCid = read.next();
					System.out.print("\n Uf: "); ufCid = read.next();
					System.out.print("\n Taxa: "); taxCid = read.nextFloat();
					
					cli.setNome(nomeCli);
					cli.setEndereco(endCli);
					cli.setTelefone(telCli);
					
					cid.setNome(nomeCid);
					cid.setUf(ufCid);
					cid.setTaxa(taxCid);
					
					System.out.print("\n Quantos fretes deseja cadastrar: "); y = read.nextInt();
					
					for(int x = 0; x < y; x++) {
						System.out.print("\n");
						System.out.print("** Inserindo Frete **");
						System.out.print("\n Descrição: "); desFre = read.next();
						System.out.print("\n Peso: "); pesoFre = read.nextFloat();
						
						valFre = (pesoFre * 10) + taxCid;
						f.get(x).setDescricao(desFre);
						f.get(x).setPeso(pesoFre);
						f.get(x).setValcr(valFre);
						f.get(x).setCidade(cid);
						f.get(x).setCliente(cli);
					}
					cli.setFrete(f);
					cid.setFrete(f);
					break;
					
				case 2:
					break;
				case 3:
					break;
				default:
					break;
			}		
		}while(i != 0);
	}
}
