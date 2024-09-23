package matheus.desafios.API_Consultas.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import matheus.desafios.API_Consultas.entities.Consulta;
import matheus.desafios.API_Consultas.entities.Doctor;

public interface ConsultaRepository extends JpaRepository<Consulta, Long>{

public Boolean existsByDoctorAndDataConsulta(Doctor doctor,LocalDateTime dataConsulta);
}
