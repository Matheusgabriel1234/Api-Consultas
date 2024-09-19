package matheus.desafios.API_Consultas.dtos;

import java.time.LocalDateTime;



public class ConsultaDto {

private Long pacientId;
private LocalDateTime time;
private Long doctorId;


public ConsultaDto(Long pacientId, Long doctorId, LocalDateTime time) {
    if (pacientId == null || doctorId == null) {
        throw new IllegalArgumentException("Pacient ID and Doctor ID cannot be null");
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
