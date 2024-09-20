package matheus.desafios.API_Consultas.dtos;



public class ProntuarioDTO {

private String descricao;
private Long consultaId;





public ProntuarioDTO(String descricao, Long consultaId) {
	if(consultaId == null) {
		throw new RuntimeException("Consulta dont must be null");
	}
	this.descricao = descricao;
	this.consultaId = consultaId;
}
public String getDescricao() {
	return descricao;
}
public void setDescricao(String descricao) {
	this.descricao = descricao;
}
public Long getConsultaId() {
	return consultaId;
}
public void setConsultaId(Long consultaId) {
	this.consultaId = consultaId;
}


}
