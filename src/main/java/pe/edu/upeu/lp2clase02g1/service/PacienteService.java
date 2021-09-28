package pe.edu.upeu.lp2clase02g1.service;

import java.util.List;

import pe.edu.upeu.lp2clase02g1.model.Paciente;


public interface PacienteService {
	Paciente create(Paciente p);
	Paciente update(Paciente p);
	void delete(Long id);
	Paciente read(Long id);
	List<Paciente> readAll();
}
