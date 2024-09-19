package matheus.desafios.API_Consultas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import matheus.desafios.API_Consultas.entities.Especialidade;

public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long> {

}
