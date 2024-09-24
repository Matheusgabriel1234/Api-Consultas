package matheus.desafios.API_Consultas.entities;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_especiality")
public class Especialidade {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotNull(message = "A especialidade deve ter um nome")
private String nome;


@JsonIgnore
@OneToMany(mappedBy = "especialidade")
private List<Doctor> doctor;



public Especialidade(Long id, String nome, List<Doctor> doctor) {
	super();
	this.id = id;
	this.nome = nome;
	this.doctor = doctor;
}

public Especialidade() {
	
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}





public List<Doctor> getDoctor() {
	return doctor;
}

public void setDoctor(List<Doctor> doctor) {
	this.doctor = doctor;
}

@Override
public int hashCode() {
	return Objects.hash(id);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Especialidade other = (Especialidade) obj;
	return Objects.equals(id, other.id);
}


}
