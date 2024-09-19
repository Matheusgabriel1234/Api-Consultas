package matheus.desafios.API_Consultas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matheus.desafios.API_Consultas.dtos.DoctorDTO;
import matheus.desafios.API_Consultas.entities.Doctor;
import matheus.desafios.API_Consultas.entities.Especialidade;
import matheus.desafios.API_Consultas.repository.DoctorRepository;
import matheus.desafios.API_Consultas.repository.EspecialidadeRepository;
import matheus.desafios.API_Consultas.repository.PacientRepository;


@Service
public class DoctorService {

@Autowired
private DoctorRepository repo;

@Autowired
private EspecialidadeRepository especialityRepo;





public DoctorService(DoctorRepository repo, EspecialidadeRepository especialityRepo) {
	super();
	this.repo = repo;
	this.especialityRepo = especialityRepo;
}

public List<Doctor> getAll(){
return repo.findAll();
}

public Doctor getById(Long id){
Doctor obj = repo.findById(id).orElseThrow(()-> new RuntimeException("Doutor(a) não encontrado(a)"));
return obj;
}



public Doctor create(DoctorDTO doctorDto) {
Especialidade especialidade = especialityRepo.findById(doctorDto.getEspecialidadeId()).orElseThrow(()-> new RuntimeException("Especialidade não encontrada"));

Doctor doctor = new Doctor();
doctor.setName(doctorDto.getName());
doctor.setCrm(doctorDto.getCrm());
doctor.setTelefone(doctorDto.getTelefone());
doctor.setEmail(doctorDto.getEmail());
doctor.setEspecialidade(especialidade);

return repo.save(doctor);	
}

public Doctor update(Long id,Doctor doctor) {
Doctor existingDoctor = repo.findById(id).orElseThrow(()-> new RuntimeException("Ocorreu um erro"));

if(existingDoctor != null) {
existingDoctor.setName(doctor.getName());
existingDoctor.setEmail(doctor.getEmail());
existingDoctor.setCrm(doctor.getCrm());
existingDoctor.setTelefone(doctor.getTelefone());


return existingDoctor;
}

return null;
}

public void delete(Long id) {
repo.deleteById(id);
}








}

