package edu.ifma.lbd.service;

import java.util.List;

import edu.ifma.lbd.dao.FreteRepositorio;
import edu.ifma.lbd.modelo.Cliente;
import edu.ifma.lbd.modelo.Frete;

public class FreteService {
	private final FreteRepositorio dao;

	public FreteService(FreteRepositorio freteRepositorio) {
		this.dao = freteRepositorio;
	}

	public Frete salva(Frete frete) throws Exception {
		return dao.salvaOuAtualiza(frete);
	}

	public List<Frete> buscarTodosFretePorUsuario(Cliente cliente) {
		return dao.buscarFretePorUsuario(cliente);
	}
}
