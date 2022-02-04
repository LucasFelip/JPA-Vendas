package edu.ifma.lbd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.ifma.lbd.controller.Conexao;
import edu.ifma.lbd.modelo.Frete;

public class FreteDAO {
	
	public void add(Frete e) throws Exception {
		Connection conn = Conexao.abrir();
		PreparedStatement ps = conn.prepareStatement("insert into Frete (descricao, peso, valcr) values (?,?,?)");
		ps.setString(1, e.getDescricao());
		ps.setFloat(2, e.getPeso());
		ps.setFloat(3, e.getValcr());
		ps.execute();
		ps.close();
	}

	public void update(Frete e) throws Exception {
		Connection conn = Conexao.abrir();
		PreparedStatement ps = conn.prepareStatement("update Frete set descricao=?, peso=?, valcr=? where id=?");
		ps.setString(1, e.getDescricao());
		ps.setFloat(2, e.getPeso());
		ps.setFloat(3, e.getValcr());
		ps.setInt(4, e.getCodigo_frete());
		ps.execute();
		ps.close();
	}

	public void delete(Frete e) throws Exception {
		Connection conn = Conexao.abrir();
		PreparedStatement ps = conn.prepareStatement("delete from Frete where id=?");
		ps.setInt(1, e.getCodigo_frete());
		ps.execute();
		ps.close();
	}

	public Frete find(Integer id) throws Exception {
		Connection conn = Conexao.abrir();
		PreparedStatement ps = conn.prepareStatement("select descricao, peso, valcr from Frete where id=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (!rs.next())
			return null;
		Frete e = new Frete();
		e.setDescricao(rs.getString("descricao"));
		e.setPeso(rs.getFloat("peso"));
		e.setValcr(rs.getInt("valcr"));
		ps.execute();
		ps.close();
		return e;
	}

	public List<Frete> listPage(int first, int amount) throws Exception {
		Connection conn = Conexao.abrir();
		PreparedStatement ps = conn.prepareStatement("select descricao, peso, valcr from Frete limit ?,?");
		ps.setInt(1, first);
		ps.setInt(2, amount);
		ResultSet rs = ps.executeQuery();
		List<Frete> list = new ArrayList<Frete>();
		while (rs.next()) {
			Frete e = new Frete();
			e.setDescricao((rs.getString("descricao")));
			e.setPeso((rs.getFloat("peso")));
			e.setValcr((rs.getFloat("valcr")));
			list.add(e);
		}
		return list;
	}
}
