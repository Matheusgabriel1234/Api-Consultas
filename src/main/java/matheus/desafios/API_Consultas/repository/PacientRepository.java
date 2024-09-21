package matheus.desafios.API_Consultas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import matheus.desafios.API_Consultas.entities.Paciente;

public interface PacientRepository extends JpaRepository<Paciente, Long> {

public Boolean existsByDocument(String document);

public Boolean existsByEmail(String email);

}
