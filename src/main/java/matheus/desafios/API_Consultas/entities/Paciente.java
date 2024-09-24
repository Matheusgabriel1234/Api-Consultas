package matheus.desafios.API_Consultas.entities;

import java.time.LocalDate;
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



@Table(name = "tb_pacientes")
@Entity
public class Paciente {

	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotNull(message = "O nome do paciente deve ser especificado")
private String name;
@NotNull(message = "O email do paciente não deve ser nulo")
private String email;
@NotNull(message = "o telefone do paciente não deve ser nulo")
private String telephone;
@NotNull(message = "A data de nascimento do paciente deve ser especificada")
private LocalDate birthDate;
@NotNull(message = "O paciente deverá passar seu endereço")
private String adress;
@NotNull(message = "O documento do Paciente deve ser passado")
private String document;
@JsonIgnore
@OneToMany(mappedBy = "paciente")
private List<Consulta> consultas;





public Paciente(Long id, String name, String email, String telephone, LocalDate birthDate, String adress,
		String document, List<Consulta> consultas) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.telephone = telephone;
	this.birthDate = birthDate;
	this.adress = adress;
	this.document = document;
	this.consultas = consultas;
}
public Paciente() {
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}
public LocalDate getBirthDate() {
	return birthDate;
}
public void setBirthDate(LocalDate birthDate) {
	this.birthDate = birthDate;
}
public String getAdress() {
	return adress;
}
public void setAdress(String adress) {
	this.adress = adress;
}





public String getDocument() {
	return document;
}
public void setDocument(String document) {
	this.document = document;
}
public List<Consulta> getConsultas() {
	return consultas;
}
public void setConsultas(List<Consulta> consultas) {
	this.consultas = consultas;
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
	Paciente other = (Paciente) obj;
	return Objects.equals(id, other.id);
}






}
