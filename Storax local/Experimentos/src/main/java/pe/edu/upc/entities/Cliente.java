package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCliente")
	private int idCliente;

	@Column(name = "dniCliente")
	// Para que solo valide números
	@Pattern(regexp = "^[0-9]*$", message = "Solo debe ingresar números")
	@Size(min = 8, max = 8, message = "El DNI debe contener 8 caracteres")
	@NotEmpty(message = "Debe ingresar el DNI del cliente")
	private String dniCliente;

	@Column(name = "nombreCliente")
	@NotEmpty(message = "Debe ingresar el nombre del cliente")
	@Size(min = 1, message = "El nombre debe tener como mínimo 1 caracter")
	@Size(max = 10, message = "El nombre debe tener como máximo 10 caracteres")
	@Pattern(regexp = "^[A-Za-z]*$", message = "Debe ingresar datos alfabéticos")
	private String nombreCliente;

	@Column(name = "apellidoCliente")
	@NotEmpty(message = "Debe ingresar el apellido del cliente")
	@Size(min = 1, message = "El apellido debe tener como mínimo 1 caracter")
	@Size(max = 10, message = "El apellido debe tener como máximo 10 caracteres")
	@Pattern(regexp = "^[A-Za-z]*$", message = "Debe ingresar datos alfabéticos")
	private String apellidoCliente;

	@Column(name = "correoCliente")
	@NotEmpty(message = "Debe ingresar el correo del cliente")
	@Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}", message = "Debe ingresar un correo válido")
	private String correoCliente;

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(int idCliente, String dniCliente, String nombreCliente, String apellidoCliente,
			String correoCliente) {
		super();
		this.idCliente = idCliente;
		this.dniCliente = dniCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.correoCliente = correoCliente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public String getCorreoCliente() {
		return correoCliente;
	}

	public void setCorreoCliente(String correoCliente) {
		this.correoCliente = correoCliente;
	}

}
