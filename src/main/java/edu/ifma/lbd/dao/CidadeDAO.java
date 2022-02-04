package edu.ifma.lbd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.ifma.lbd.controller.Conexao;
import edu.ifma.lbd.modelo.Cidade;

public class CidadeDAO {

	public void add(Cidade e) throws Exception {
		Connection conn = Conexao.abrir();
		PreparedStatement ps = conn.prepareStatement("insert into Cidade (nome, uf, taxa) values (?,?,?)");
		ps.setString(1, e.getNome());
		ps.setString(2, e.getUf());
		ps.setFloat(3, e.getTaxa());
		ps.execute();
		ps.close();
	}

	public void update(Cidade e) throws Exception {
		Connection conn = Conexao.abrir();
		PreparedStatement ps = conn.prepareStatement("update Cidade set nome=?, uf=?, taxa=? where id=?");
		ps.setString(1, e.getNome());
		ps.setString(2, e.getUf());
		ps.setFloat(3, e.getTaxa());
		ps.setInt(4, e.getCodigo_cidade());
		ps.execute();
		ps.close();
	}

	public void delete(Cidade e) throws Exception {
		Connection conn = Conexao.abrir();
		PreparedStatement ps = conn.prepareStatement("delete from Cidade where id=?");
		ps.setInt(1, e.getCodigo_cidade());
		ps.execute();
		ps.close();
	}

	public Cidade find(Integer id) throws Exception {
		Connection conn = Conexao.abrir();
		PreparedStatement ps = conn.prepareStatement("select nome, uf, taxa from Cidade where id=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (!rs.next())
			return null;
		Cidade e = new Cidade();
		e.setNome(rs.getString("nome"));
		e.setUf(rs.getString("uf"));
		e.setTaxa(rs.getInt("taxa"));
		ps.execute();
		ps.close();
		return e;
	}

	public List<Cidade> listPage(int first, int amount) throws Exception {
		Connection conn = Conexao.abrir();
		PreparedStatement ps = conn.prepareStatement("select nome, uf, taxa from Cidade limit ?,?");
		ps.setInt(1, first);
		ps.setInt(2, amount);
		ResultSet rs = ps.executeQuery();
		List<Cidade> list = new ArrayList<Cidade>();
		while (rs.next()) {
			Cidade e = new Cidade();
			e.setNome((rs.getString("nome")));
			e.setUf((rs.getString("uf")));
			e.setTaxa((rs.getFloat("taxa")));
			list.add(e);
		}
		return list;
	}
}
