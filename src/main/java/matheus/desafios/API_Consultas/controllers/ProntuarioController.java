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


import matheus.desafios.API_Consultas.dtos.ProntuarioDTO;
import matheus.desafios.API_Consultas.entities.Prontuario;
import matheus.desafios.API_Consultas.services.ProntuarioService;

@RestController
@RequestMapping("/api/prontuarios")
public class ProntuarioController {
	
private ProntuarioService service;

public ProntuarioController(ProntuarioService service) {
	super();
	this.service = service;
}

@GetMapping
public ResponseEntity<List<Prontuario>> getAll(){
List<Prontuario> obj = service.getAll();
return new ResponseEntity<>(obj,HttpStatus.OK);
}

@GetMapping("/{id}")
public ResponseEntity<Prontuario> getByid(@PathVariable Long id){
Prontuario obj = service.getById(id);
return new ResponseEntity<>(obj,HttpStatus.OK);
}

@PostMapping
public ResponseEntity<Prontuario> create(@RequestBody ProntuarioDTO prontuario){
Prontuario obj = service.create(prontuario);
return new ResponseEntity<>(obj,HttpStatus.CREATED);
}

@PutMapping("/{id}")
public ResponseEntity<matheus.desafios.API_Consultas.entities.Prontuario> update(@PathVariable Long id,@RequestBody Prontuario prontuario){
Prontuario obj = service.update(id, prontuario);
return new ResponseEntity<>(obj,HttpStatus.ACCEPTED);
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> delete(@PathVariable Long id){
service.delete(id);
return ResponseEntity.noContent().build();
}



}
