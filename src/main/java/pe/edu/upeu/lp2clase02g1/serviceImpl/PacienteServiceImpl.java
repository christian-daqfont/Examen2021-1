package pe.edu.upeu.lp2clase02g1.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.lp2clase02g1.model.Paciente;
import pe.edu.upeu.lp2clase02g1.repository.PacienteRepository;
import pe.edu.upeu.lp2clase02g1.service.PacienteService;



@Service
public class PacienteServiceImpl implements PacienteService {
	
	@Autowired
	private PacienteRepository pacienterepository;
	
	@Override
	public Paciente create(Paciente p) {
		// TODO Auto-generated method stub
		return pacienterepository.save(p);
	}

	@Override
	public Paciente update(Paciente p) {
		// TODO Auto-generated method stub
		return pacienterepository.save(p);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		pacienterepository.deleteById(id);
	}

	@Override
	public Paciente read(Long id) {
		// TODO Auto-generated method stub
		return pacienterepository.findById(id).get();
	}

	@Override
	public List<Paciente> readAll() {
		// TODO Auto-generated method stub
		return pacienterepository.findAll();
	}

}


