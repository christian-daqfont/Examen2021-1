package pe.edu.upeu.lp2clase02g1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "paciente")
public class Paciente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String dni;
	private String nombres;
	private String apellidos;
	private String direccion;
	private String telefono;
}
