package matheus.desafios.API_Consultas.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_consultas")
public class Consulta {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@ManyToOne
@JoinColumn(name = "doctor_id")
private Doctor doctor;

@ManyToOne
@JoinColumn(name = "paciente_id")
private Paciente paciente;

private LocalDateTime dataConsulta;






public Consulta() {
	
}

public Consulta(Long id, Doctor doctor, Paciente paciente, LocalDateTime dataConsulta) {
	super();
	this.id = id;
	this.doctor = doctor;
	this.paciente = paciente;
	this.dataConsulta = dataConsulta;
	
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Doctor getDoctor() {
	return doctor;
}

public void setDoctor(Doctor doctor) {
	this.doctor = doctor;
}

public Paciente getPaciente() {
	return paciente;
}

public void setPaciente(Paciente paciente) {
	this.paciente = paciente;
}

public LocalDateTime getDataConsulta() {
	return dataConsulta;
}

public void setDataConsulta(LocalDateTime dataConsulta) {
	this.dataConsulta = dataConsulta;
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
	Consulta other = (Consulta) obj;
	return Objects.equals(id, other.id);
}





}
