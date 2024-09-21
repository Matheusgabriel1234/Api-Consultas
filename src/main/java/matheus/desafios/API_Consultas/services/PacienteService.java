package matheus.desafios.API_Consultas.services;

import java.util.List;

import org.apache.catalina.startup.Tomcat.ExistingStandardWrapper;
import org.springframework.stereotype.Service;

import matheus.desafios.API_Consultas.entities.Paciente;
import matheus.desafios.API_Consultas.exceptions.DocumenteAlreadyRegistred;
import matheus.desafios.API_Consultas.exceptions.EmailAlreadyExistsException;
import matheus.desafios.API_Consultas.exceptions.IdNotFoundException;
import matheus.desafios.API_Consultas.repository.PacientRepository;


@Service
public class PacienteService {

private PacientRepository repo;

public PacienteService(PacientRepository repo) {
this.repo = repo;
}

public List<Paciente> getAll(){
return repo.findAll();
}

public Paciente getById(Long id){
Paciente obj = repo.findById(id).orElseThrow(()-> new IdNotFoundException("O paciente com o id:" + id + "não existe"));
return obj;
}



public Paciente create(Paciente paciente) {
if(repo.existsByDocument(paciente.getDocument())) {
	throw new DocumenteAlreadyRegistred("O documento: " + paciente.getDocument() + "ja existe" );
}

if(repo.existsByEmail(paciente.getEmail())) {
	throw new EmailAlreadyExistsException("O email" + paciente.getEmail() + "ja existe");
}
return repo.save(paciente);	
}

public Paciente update(Long id,Paciente paciente) {
Paciente existingPaciente = repo.findById(id).orElseThrow(()-> new IdNotFoundException("O paciente com o id: " + paciente.getId() + " não foi encontrada" ));
if(existingPaciente != null) {
existingPaciente.setName(paciente.getName());
existingPaciente.setEmail(paciente.getEmail());
existingPaciente.setBirthDate(paciente.getBirthDate());
existingPaciente.setTelephone(paciente.getTelephone());


if(repo.existsByEmail(paciente.getEmail())) {
	throw new EmailAlreadyExistsException("O email" + paciente.getEmail() + "ja existe");
}

return existingPaciente;
}

return null;
}

public void delete(Long id) {
repo.deleteById(id);
}








}

