package pe.edu.upeu.lp2clase02g1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upeu.lp2clase02g1.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{
	
}
