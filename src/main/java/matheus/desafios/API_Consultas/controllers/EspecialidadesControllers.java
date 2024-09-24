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
import matheus.desafios.API_Consultas.entities.Especialidade;
import matheus.desafios.API_Consultas.services.EspecialidadeService;

@RestController
@RequestMapping("/api/especialidades")
public class EspecialidadesControllers {
	
private EspecialidadeService service;

public EspecialidadesControllers(EspecialidadeService service) {
	super();
	this.service = service;
}

@GetMapping
public ResponseEntity<List<Especialidade>> getAll(){
List<Especialidade> obj = service.getAll();
return new ResponseEntity<>(obj,HttpStatus.OK);
}

@GetMapping("/{id}")
public ResponseEntity<Especialidade> getByid(@PathVariable Long id){
Especialidade obj = service.getById(id);
return new ResponseEntity<>(obj,HttpStatus.OK);
}

@PostMapping
public ResponseEntity<Especialidade> create(@Valid @RequestBody Especialidade especialidade){
Especialidade obj = service.create(especialidade);
return new ResponseEntity<>(obj,HttpStatus.CREATED);
}

@PutMapping("/{id}")
public ResponseEntity<Especialidade> update( @Valid  @PathVariable Long id,@RequestBody Especialidade especialidade){
Especialidade obj = service.update(id, especialidade);
return new ResponseEntity<>(obj,HttpStatus.ACCEPTED);
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> delete(@PathVariable Long id){
service.delete(id);
return ResponseEntity.noContent().build();
}



}
