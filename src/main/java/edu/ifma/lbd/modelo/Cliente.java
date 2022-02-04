package edu.ifma.lbd.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	int codigo_cliente;
	String nome;
	String endereco;
	String telefone;
	
	@OneToMany(mappedBy="cliente", fetch=FetchType.LAZY)
	private List<Frete> frete;
	
	public List<Frete> getFrete() {
		return frete;
	}

	public void setFrete(List<Frete> frete) {
		this.frete = frete;
	}

	public int getCodigo_cliente() {
		return codigo_cliente;
	}
	
	public void setCodigo_cliente(int codigo_cliente) {
		this.codigo_cliente = codigo_cliente;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
