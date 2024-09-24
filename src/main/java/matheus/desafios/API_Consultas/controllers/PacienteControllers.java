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
import matheus.desafios.API_Consultas.entities.Paciente;
import matheus.desafios.API_Consultas.services.PacienteService;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteControllers {
	
private PacienteService service;

public PacienteControllers(PacienteService service) {
	super();
	this.service = service;
}

@GetMapping
public ResponseEntity<List<Paciente>> getAll(){
List<Paciente> obj = service.getAll();
return new ResponseEntity<>(obj,HttpStatus.OK);
}

@GetMapping("/{id}")
public ResponseEntity<Paciente> getByid(@PathVariable Long id){
Paciente obj = service.getById(id);
return new ResponseEntity<>(obj,HttpStatus.OK);
}

@PostMapping
public ResponseEntity<Paciente> create(@Valid @RequestBody Paciente paciente){
Paciente obj = service.create(paciente);
return new ResponseEntity<>(obj,HttpStatus.CREATED);
}

@PutMapping("/{id}")
public ResponseEntity<Paciente> update(@Valid @PathVariable Long id,@RequestBody Paciente paciente){
Paciente obj = service.update(id, paciente);
return new ResponseEntity<>(obj,HttpStatus.ACCEPTED);
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> delete(@PathVariable Long id){
service.delete(id);
return ResponseEntity.noContent().build();
}



}
