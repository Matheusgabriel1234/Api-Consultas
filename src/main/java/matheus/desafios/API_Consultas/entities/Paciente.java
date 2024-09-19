package matheus.desafios.API_Consultas.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Table(name = "tb_pacientes")
@Entity
public class Paciente {

	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String name;
private String email;
private String telephone;
private LocalDate birthDate;
private String adress;
public Paciente(Long id, String name, String email, String telephone, LocalDate birthDate, String adress) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.telephone = telephone;
	this.birthDate = birthDate;
	this.adress = adress;
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






}
