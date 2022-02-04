package edu.ifma.lbd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.ifma.lbd.controller.Conexao;
import edu.ifma.lbd.modelo.Cliente;

public class ClienteDAO {

	public void add(Cliente e) throws Exception {
		Connection conn = Conexao.abrir();
		PreparedStatement ps = conn.prepareStatement("insert into Cliente (nome, endereco, telefone) values (?,?,?)");
		ps.setString(1, e.getNome());
		ps.setString(2, e.getEndereco());
		ps.setString(3, e.getTelefone());
		ps.execute();
		ps.close();
	}

	public void update(Cliente e) throws Exception {
		Connection conn = Conexao.abrir();
		PreparedStatement ps = conn.prepareStatement("update Cliente set nome=?, endereco=?, telefone=? where id=?");
		ps.setString(1, e.getNome());
		ps.setString(2, e.getEndereco());
		ps.setString(3, e.getTelefone());
		ps.setInt(4, e.getCodigo_cliente());
		ps.execute();
		ps.close();
	}

	public void delete(Cliente e) throws Exception {
		Connection conn = Conexao.abrir();
		PreparedStatement ps = conn.prepareStatement("delete from Cliente where id=?");
		ps.setInt(1, e.getCodigo_cliente());
		ps.execute();
		ps.close();
	}

	public Cliente find(Integer id) throws Exception {
		Connection conn = Conexao.abrir();
		PreparedStatement ps = conn.prepareStatement("select nome, endereco, telefone from Cliente where id=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (!rs.next())
			return null;
		Cliente e = new Cliente();
		e.setNome(rs.getString("nome"));
		e.setEndereco(rs.getString("endereco"));
		e.setTelefone(rs.getString("telefone"));
		ps.execute();
		ps.close();
		return e;
	}

	public List<Cliente> listPage(int first, int amount) throws Exception {
		Connection conn = Conexao.abrir();
		PreparedStatement ps = conn.prepareStatement("select nome, endereco, telefone from Cliente limit ?,?");
		ps.setInt(1, first);
		ps.setInt(2, amount);
		ResultSet rs = ps.executeQuery();
		List<Cliente> list = new ArrayList<Cliente>();
		while (rs.next()) {
			Cliente e = new Cliente();
			e.setNome((rs.getString("nome")));
			e.setEndereco((rs.getString("endereco")));
			e.setTelefone((rs.getString("telefone")));
			list.add(e);
		}
		return list;
	}
}
