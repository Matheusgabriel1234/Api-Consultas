package matheus.desafios.API_Consultas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import matheus.desafios.API_Consultas.entities.Especialidade;
import matheus.desafios.API_Consultas.repository.EspecialidadeRepository;



@Service
public class EspecialidadeService {

private EspecialidadeRepository repo;

public EspecialidadeService(EspecialidadeRepository repo) {
this.repo = repo;
}

public List<Especialidade> getAll(){
return repo.findAll();
}

public Especialidade getById(Long id){
Especialidade obj = repo.findById(id).orElseThrow(()-> new RuntimeException("Ocorreu um erro"));
return obj;
}



public Especialidade create(Especialidade especialidade) {
return repo.save(especialidade);	
}

public Especialidade update(Long id,Especialidade especialidade) {
Especialidade existingEspecialidade = repo.findById(id).orElseThrow(()-> new RuntimeException("Ocorreu um erro"));

if(existingEspecialidade != null) {
existingEspecialidade.setNome(especialidade.getNome());


return existingEspecialidade;
}

return null;
}

public void delete(Long id) {
repo.deleteById(id);
}








}

