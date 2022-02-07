package edu.ifma.lbd.modelo;

import java.util.*;
import javax.persistence.*;

@Entity
public class Cidade implements Entidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String nome;
	String uf;
	float taxa;

	@OneToMany(mappedBy = "cidade", cascade = CascadeType.ALL)
	private Set<Frete> fretes = new LinkedHashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Cidade cidade = (Cidade) o;
		return Objects.equals(id, cidade.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public void adiciona(Frete frete) {
		fretes.add(frete);
	}
}
