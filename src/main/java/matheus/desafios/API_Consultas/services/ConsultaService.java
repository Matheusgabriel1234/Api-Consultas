package matheus.desafios.API_Consultas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matheus.desafios.API_Consultas.dtos.ConsultaDto;
import matheus.desafios.API_Consultas.entities.Consulta;
import matheus.desafios.API_Consultas.entities.Doctor;
import matheus.desafios.API_Consultas.entities.Paciente;
import matheus.desafios.API_Consultas.repository.ConsultaRepository;
import matheus.desafios.API_Consultas.repository.DoctorRepository;
import matheus.desafios.API_Consultas.repository.PacientRepository;
import matheus.desafios.API_Consultas.repository.ProntuarioRepository;


@Service
public class ConsultaService {

@Autowired
private ConsultaRepository repo;

@Autowired
private DoctorRepository doctorRepo;

@Autowired
private PacientRepository pacientRepo;



public ConsultaService(ConsultaRepository repo, DoctorRepository doctorRepo, PacientRepository pacientRepo) {
	super();
	this.repo = repo;
	this.doctorRepo = doctorRepo;
	this.pacientRepo = pacientRepo;
}

public List<Consulta> getAll(){
return repo.findAll();
}

public Consulta getById(Long id){
Consulta obj = repo.findById(id).orElseThrow(()-> new RuntimeException("Ocorreu um erro"));
return obj;
}



public Consulta create(ConsultaDto consultaDto) {
Paciente paciente = pacientRepo.findById(consultaDto.getPacientId()).orElseThrow(()-> new RuntimeException("Paciente não encontrado"));

Doctor doctor = doctorRepo.findById(consultaDto.getDoctorId()).orElseThrow(()-> new RuntimeException("Doutor não encontrado"));

Consulta consulta = new Consulta();
consulta.setPaciente(paciente);
consulta.setDoctor(doctor);
consulta.setDataConsulta(consultaDto.getTime());
;

return repo.save(consulta);	
}

public Consulta update(Long id,Consulta consulta) {
Consulta existingConsulta = repo.findById(id).orElseThrow(()-> new RuntimeException("Ocorreu um erro"));

if(existingConsulta != null) {
existingConsulta.setDoctor(consulta.getDoctor());
existingConsulta.setPaciente(consulta.getPaciente());
existingConsulta.setDataConsulta(consulta.getDataConsulta());
return repo.save(existingConsulta);
}

return null;
}

public void delete(Long id) {
repo.deleteById(id);
}








}

