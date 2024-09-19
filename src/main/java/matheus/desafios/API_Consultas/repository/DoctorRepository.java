package matheus.desafios.API_Consultas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import matheus.desafios.API_Consultas.entities.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
