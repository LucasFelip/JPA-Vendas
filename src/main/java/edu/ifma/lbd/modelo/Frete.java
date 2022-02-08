package edu.ifma.lbd.modelo;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "frete")
public class Frete implements Entidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_frete")
	private Integer id;

	@Column(name = "descrição", nullable = false)
	private String descricao;

	@Column(name = "peso", nullable = false)
	private float peso;

	@Column(name = "valcr", nullable = false)
	private float valcr;

	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "cidade_id", nullable = false)
	private Cidade cidade;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Frete frete = (Frete) o;
        return Objects.equals(id, frete.id);
    }

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
