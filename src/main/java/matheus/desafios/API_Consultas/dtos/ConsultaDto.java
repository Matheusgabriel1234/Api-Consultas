package matheus.desafios.API_Consultas.dtos;

import java.time.LocalDateTime;



import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotNull;




public class ConsultaDto {


private Long pacientId;
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
@NotNull(message = "A data da consulta não pode estar vazia")
private LocalDateTime time;
private Long doctorId;



public ConsultaDto(Long pacientId, Long doctorId, LocalDateTime time) {
    if (pacientId == null || doctorId == null) {
        throw new IllegalArgumentException("Pacient ID e Doctor ID não podem ser nulos");
    }
    this.pacientId = pacientId;
    this.doctorId = doctorId;
    this.time = time;
  
}

public Long getPacientId() {
	return pacientId;
}
public void setPacientId(Long pacientId) {
	this.pacientId = pacientId;
}
public LocalDateTime getTime() {
	return time;
}
public void setTime(LocalDateTime time) {
	this.time = time;
}
public Long getDoctorId() {
	return doctorId;
}
public void setDoctorId(Long doctorId) {
	this.doctorId = doctorId;
}






}
