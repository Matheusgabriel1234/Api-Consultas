package matheus.desafios.API_Consultas.entities;

import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_doctors")
public class Doctor {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String name;
private String crm;
private String email;
private String telefone;


@ManyToOne
@JoinColumn(name = "especialidade_id")
private Especialidade especialidade;

@JsonIgnore
@OneToMany(mappedBy = "doctor")
private List<Consulta> consultas;



public Doctor(Long id, String name, String crm, String email, String telefone, Especialidade especialidade,
		List<Consulta> consultas) {
	super();
	this.id = id;
	this.name = name;
	this.crm = crm;
	this.email = email;
	this.telefone = telefone;
	this.especialidade = especialidade;
	this.consultas = consultas;
}
public Doctor() {
	super();
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCrm() {
	return crm;
}
public void setCrm(String crm) {
	this.crm = crm;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getTelefone() {
	return telefone;
}
public void setTelefone(String telefone) {
	this.telefone = telefone;
}



public List<Consulta> getConsultas() {
	return consultas;
}
public void setConsultas(List<Consulta> consultas) {
	this.consultas = consultas;
}
public Especialidade getEspecialidade() {
	return especialidade;
}
public void setEspecialidade(Especialidade especialidade) {
	this.especialidade = especialidade;
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
	Doctor other = (Doctor) obj;
	return Objects.equals(id, other.id);
}


}
