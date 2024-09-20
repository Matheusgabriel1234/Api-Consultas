package matheus.desafios.API_Consultas.dtos;

import java.util.List;

import matheus.desafios.API_Consultas.entities.Consulta;

public class DoctorDTO {
private String name;
private String crm;
private String email;
private String telephone;
private Long especialidadeId;
private List<Consulta> consulta;
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
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}
public Long getEspecialidadeId() {
	return especialidadeId;
}

public List<Consulta> getConsulta() {
	return consulta;
}
public void setConsulta(List<Consulta> consulta) {
	this.consulta = consulta;
}
public void setEspecialidadeId(Long especialidadeId) {
	this.especialidadeId = especialidadeId;
}
   

	

}
