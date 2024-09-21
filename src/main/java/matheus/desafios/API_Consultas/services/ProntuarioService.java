package matheus.desafios.API_Consultas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matheus.desafios.API_Consultas.dtos.ProntuarioDTO;
import matheus.desafios.API_Consultas.entities.Prontuario;
import matheus.desafios.API_Consultas.exceptions.IdNotFoundException;
import matheus.desafios.API_Consultas.entities.Consulta;
import matheus.desafios.API_Consultas.repository.ProntuarioRepository;
import matheus.desafios.API_Consultas.repository.ConsultaRepository;

@Service
public class ProntuarioService {

@Autowired
private ProntuarioRepository repo;

@Autowired
private ConsultaRepository consultaRepo;





public ProntuarioService(ProntuarioRepository repo, ConsultaRepository consultaRepo) {
	super();
	this.repo = repo;
	this.consultaRepo = consultaRepo;
}

public List<Prontuario> getAll(){
return repo.findAll();
}

public Prontuario getById(Long id){
Prontuario obj = repo.findById(id).orElseThrow(()-> new IdNotFoundException("O prontuario com id: " + id + " não existe"));
return obj;
}



public Prontuario create(ProntuarioDTO prontuarioDto) {
Consulta consulta = consultaRepo.findById(prontuarioDto.getConsultaId()).orElseThrow(()-> new IdNotFoundException("A consulta com o id: " + prontuarioDto.getConsultaId() + " não existe"));

Prontuario prontuario = new Prontuario();
prontuario.setDescricao(prontuarioDto.getDescricao());
prontuario.setConsulta(consulta);

consulta.setProntuario(prontuario);
return repo.save(prontuario);	
}

public Prontuario update(Long id,Prontuario prontuario) {
Prontuario existingProntuario = repo.findById(id).orElseThrow(()-> new IdNotFoundException("O prontuario com o id:" + prontuario.getId() + " não existe"));

if(existingProntuario != null) {
existingProntuario.setDescricao(prontuario.getDescricao());
return existingProntuario;
}

return null;
}

public void delete(Long id) {
repo.deleteById(id);
}








}

