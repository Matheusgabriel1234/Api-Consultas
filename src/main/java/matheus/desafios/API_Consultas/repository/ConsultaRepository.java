package matheus.desafios.API_Consultas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import matheus.desafios.API_Consultas.entities.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long>{

}
