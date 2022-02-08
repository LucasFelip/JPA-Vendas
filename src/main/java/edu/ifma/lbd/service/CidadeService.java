package edu.ifma.lbd.service;

import edu.ifma.lbd.dao.CidadeRepositorio;
import edu.ifma.lbd.modelo.Cidade;

public class CidadeService {
	private final CidadeRepositorio dao;
	
	public CidadeService(CidadeRepositorio cidadeRepositorio) {
		this.dao = cidadeRepositorio;
	}
	
	public Cidade salva(Cidade cidade) throws Exception {
		return dao.salvaOuAtualiza(cidade);		
	}
}
