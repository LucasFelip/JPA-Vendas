package edu.ifma.lbd.modelo;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "cidade")
public class Cidade implements Entidade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_cidade")
	private Integer id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "uf")
	private String uf;

	@Column(name = "taxa")
	private float taxa;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	@Column(name = "frete")
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

	public void adiciona(Frete e) {
		fretes.add(e);
	}
}
