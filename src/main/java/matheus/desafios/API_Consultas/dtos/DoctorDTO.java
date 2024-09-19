package matheus.desafios.API_Consultas.dtos;

public class DoctorDTO {
private String name;
private String crm;
private String email;
private String telefone;
private Long especialidadeId;
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
public Long getEspecialidadeId() {
	return especialidadeId;
}
public void setEspecialidadeId(Long especialidadeId) {
	this.especialidadeId = especialidadeId;
}
   

	

}
