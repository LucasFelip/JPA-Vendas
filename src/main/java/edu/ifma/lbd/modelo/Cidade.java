package edu.ifma.lbd.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cidade {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	int codigo_cidade;
	String nome;
	String uf;
	float taxa;
	
	@OneToMany(mappedBy="cidade", fetch=FetchType.LAZY)
	private List<Frete> frete;
	
	public List<Frete> getFrete() {
		return frete;
	}

	public void setFrete(List<Frete> frete) {
		this.frete = frete;
	}

	public int getCodigo_cidade() {
		return codigo_cidade;
	}
	
	public void setCodigo_cidade(int codigo_cidade) {
		this.codigo_cidade = codigo_cidade;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getUf() {
		return uf;
	}
	
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public float getTaxa() {
		return taxa;
	}
	
	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}
}
