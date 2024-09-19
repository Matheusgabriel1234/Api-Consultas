package matheus.desafios.API_Consultas.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_prontuario")
public class Prontuario {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


private String descricao;



public Prontuario(Long id, String descricao) {
	super();
	this.id = id;

	this.descricao = descricao;
}

public Prontuario() {
	super();
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}



public String getDescricao() {
	return descricao;
}

public void setDescricao(String descricao) {
	this.descricao = descricao;
}








}
