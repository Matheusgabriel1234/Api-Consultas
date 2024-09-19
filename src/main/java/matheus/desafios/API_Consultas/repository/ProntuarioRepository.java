package matheus.desafios.API_Consultas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import matheus.desafios.API_Consultas.entities.Prontuario;

public interface ProntuarioRepository extends JpaRepository<Prontuario, Long>{

}
