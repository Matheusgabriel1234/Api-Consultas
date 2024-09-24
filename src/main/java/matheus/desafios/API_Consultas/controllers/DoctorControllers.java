package matheus.desafios.API_Consultas.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import matheus.desafios.API_Consultas.dtos.DoctorDTO;
import matheus.desafios.API_Consultas.entities.Doctor;
import matheus.desafios.API_Consultas.services.DoctorService;

@RestController
@RequestMapping("/api/doctors")
public class DoctorControllers {
	
private DoctorService service;

public DoctorControllers(DoctorService service) {
	super();
	this.service = service;
}

@GetMapping
public ResponseEntity<List<Doctor>> getAll(){
List<Doctor> obj = service.getAll();
return new ResponseEntity<>(obj,HttpStatus.OK);
}

@GetMapping("/{id}")
public ResponseEntity<Doctor> getByid(@PathVariable Long id){
Doctor obj = service.getById(id);
return new ResponseEntity<>(obj,HttpStatus.OK);
}

@PostMapping
public ResponseEntity<Doctor> create(@Valid @RequestBody DoctorDTO doctor){
Doctor obj = service.create(doctor);
return new ResponseEntity<>(obj,HttpStatus.CREATED);
}

@PutMapping("/{id}")
public ResponseEntity<Doctor> update(@Valid @PathVariable Long id,@RequestBody Doctor doctor){
Doctor obj = service.update(id, doctor);
return new ResponseEntity<>(obj,HttpStatus.ACCEPTED);
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> delete(@PathVariable Long id){
service.delete(id);
return ResponseEntity.noContent().build();
}



}
