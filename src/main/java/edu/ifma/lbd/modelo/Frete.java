package edu.ifma.lbd.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Frete {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	int codigo_frete;
	String descricao;
	float peso;
	float valcr;
	
	@ManyToOne
	private Cliente cliente;
	
	@ManyToOne
	private Cidade cidade;

	public int getCodigo_frete() {
		return codigo_frete;
	}

	public void setCodigo_frete(int codigo_frete) {
		this.codigo_frete = codigo_frete;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getValcr() {
		return valcr;
	}

	public void setValcr(float valcr) {
		this.valcr = valcr;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	
}
