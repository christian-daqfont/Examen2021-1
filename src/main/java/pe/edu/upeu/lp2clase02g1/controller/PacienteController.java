package pe.edu.upeu.lp2clase02g1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.lp2clase02g1.model.Paciente;
import pe.edu.upeu.lp2clase02g1.serviceImpl.PacienteServiceImpl;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {
	@Autowired
	private PacienteServiceImpl pacienteservice;
	
	@PostMapping("/create")
	public ResponseEntity<Paciente> save(@RequestBody Paciente paci){
		try {
			Paciente al = pacienteservice.create(new Paciente(paci.getId(),paci.getDni(),paci.getNombres(),paci.getApellidos(),paci.getDireccion(),paci.getTelefono()));
			return new ResponseEntity<>(al, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/")
	public ResponseEntity<List<Paciente>> getPaciente(){
		try {
			List<Paciente> list = new ArrayList<>();
			list = pacienteservice.readAll();
			if(list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/read/{id}")
	public ResponseEntity<Paciente> getUser(@PathVariable("id") long id){
		Paciente Paciente = pacienteservice.read(id);
			if(Paciente.getId()>0) {
				return new ResponseEntity<>(Paciente, HttpStatus.OK);
			}else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id){
		try {
			pacienteservice.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Paciente> update(@RequestBody Paciente pa, @PathVariable("id") long id){
		try {
			Paciente ul = pacienteservice.read(id);
			if(ul.getId()>0) {
				ul.setDni(pa.getDni());
				ul.setNombres(pa.getNombres());
				ul.setApellidos(pa.getApellidos());
				ul.setDireccion(pa.getDireccion());
				ul.setTelefono(pa.getTelefono());
				return new ResponseEntity<>(pacienteservice.create(ul),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
