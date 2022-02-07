package edu.ifma.lbd.modelo;

import java.util.*;
import javax.persistence.*;

@Entity
public class Cliente implements Entidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String nome;
	String endereco;
	String telefone;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private Set<Frete> fretes = new LinkedHashSet<>();

	public Integer getId() {
		return id;
	}

	public void setCodigo_cliente(Integer id) {
		this.id = id;
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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Cliente cliente = (Cliente) o;
		return Objects.equals(id, cliente.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public void adiciona(Frete frete) {
		fretes.add(frete);
	}
}
