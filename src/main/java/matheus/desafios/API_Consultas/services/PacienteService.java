package matheus.desafios.API_Consultas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import matheus.desafios.API_Consultas.entities.Paciente;
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
Paciente obj = repo.findById(id).orElseThrow(()-> new RuntimeException("Ocorreu um erro"));
return obj;
}



public Paciente create(Paciente paciente) {
return repo.save(paciente);	
}

public Paciente update(Long id,Paciente paciente) {
Paciente existingPaciente = repo.findById(id).orElseThrow(()-> new RuntimeException("Ocorreu um erro"));

if(existingPaciente != null) {
existingPaciente.setName(paciente.getName());
existingPaciente.setEmail(paciente.getEmail());
existingPaciente.setBirthDate(paciente.getBirthDate());
existingPaciente.setTelephone(paciente.getTelephone());
return existingPaciente;
}

return null;
}

public void delete(Long id) {
repo.deleteById(id);
}








}

