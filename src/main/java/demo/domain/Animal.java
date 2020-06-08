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

import demo.domain.enums.TipoSexo;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	public Animal() {
		
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
