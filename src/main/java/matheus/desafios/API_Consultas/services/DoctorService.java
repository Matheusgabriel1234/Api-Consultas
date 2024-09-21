package matheus.desafios.API_Consultas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matheus.desafios.API_Consultas.dtos.DoctorDTO;
import matheus.desafios.API_Consultas.entities.Doctor;
import matheus.desafios.API_Consultas.entities.Especialidade;
import matheus.desafios.API_Consultas.exceptions.CrmAlreadyRegistred;
import matheus.desafios.API_Consultas.exceptions.EmailAlreadyExistsException;
import matheus.desafios.API_Consultas.exceptions.IdNotFoundException;
import matheus.desafios.API_Consultas.repository.DoctorRepository;
import matheus.desafios.API_Consultas.repository.EspecialidadeRepository;

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
Doctor obj = repo.findById(id).orElseThrow(()-> new IdNotFoundException("O id: " + id + " não existe "));
return obj;
}



public Doctor create(DoctorDTO doctorDto) {
Especialidade especialidade = especialityRepo.findById(doctorDto.getEspecialidadeId()).orElseThrow(()-> new IdNotFoundException("A especialidade com o id: " + doctorDto.getEspecialidadeId() + "não existe"));

if(repo.existsByEmail(doctorDto.getEmail())) {
	throw new EmailAlreadyExistsException("O email: " + doctorDto.getEmail() + " ja foi registrado");
}

if(repo.existsByCrm(doctorDto.getCrm())) {
	throw new CrmAlreadyRegistred("O crm: " + doctorDto.getCrm() + " ja foi registrado" );
}

Doctor doctor = new Doctor();
doctor.setName(doctorDto.getName());
doctor.setCrm(doctorDto.getCrm());
doctor.setTelefone(doctorDto.getTelephone());
doctor.setEmail(doctorDto.getEmail());
doctor.setEspecialidade(especialidade);

return repo.save(doctor);	
}

public Doctor update(Long id,Doctor doctor) {
Doctor existingDoctor = repo.findById(id).orElseThrow(()-> new IdNotFoundException("o id: " + id + "não esta registrado no banco de dados"));

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

