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


import matheus.desafios.API_Consultas.dtos.ConsultaDto;
import matheus.desafios.API_Consultas.entities.Consulta;
import matheus.desafios.API_Consultas.services.ConsultaService;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaControllers {
	
private ConsultaService service;

public ConsultaControllers(ConsultaService service) {
	super();
	this.service = service;
}

@GetMapping
public ResponseEntity<List<Consulta>> getAll(){
List<Consulta> obj = service.getAll();
return new ResponseEntity<>(obj,HttpStatus.OK);
}

@GetMapping("/{id}")
public ResponseEntity<Consulta> getByid(@PathVariable Long id){
Consulta obj = service.getById(id);
return new ResponseEntity<>(obj,HttpStatus.OK);
}

@PostMapping
public ResponseEntity<Consulta> create(@RequestBody ConsultaDto consulta){
Consulta obj = service.create(consulta);
return new ResponseEntity<>(obj,HttpStatus.CREATED);
}

@PutMapping("/{id}")
public ResponseEntity<Consulta> update(@PathVariable Long id,@RequestBody Consulta consulta){
Consulta obj = service.update(id, consulta);
return new ResponseEntity<>(obj,HttpStatus.ACCEPTED);
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> delete(@PathVariable Long id){
service.delete(id);
return ResponseEntity.noContent().build();
}



}
