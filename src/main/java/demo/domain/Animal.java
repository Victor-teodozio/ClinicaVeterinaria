package demo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import demo.domain.enums.TipoSexo;

@Entity
public class Animal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer idade;
	private Integer sex;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "especie_id")
	private Especie especie;
	
	@ManyToOne
	@JoinColumn(name = "estado_id")
	private Cliente cliente;
	
	@OneToMany(mappedBy = "animal")
	private List<Consulta> consultas = new ArrayList<>();
	
	public Animal(Integer id, String nome, Integer idade, TipoSexo sex, Especie especie, Cliente cliente) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.sex = sex.getCodigo();
		this.especie = especie;
		this.cliente = cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public TipoSexo getTipoSexo() {
		return TipoSexo.toEnum(sex);
	}

	public void setTipoSexo(TipoSexo sex) {
		this.sex = sex.getCodigo();
	}

	public Especie getEspecie() {
		return especie;
	}

	public void setEspecie(Especie especie) {
		this.especie = especie;
	}

	public Integer getId() {
		return id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}	
	
}
