package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Almacen")
public class Almacen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAlmacen")
	private int idAlmacen;

	@Column(name = "nombreAlmacen")
	@NotEmpty(message = "Debe ingresar un nombre")
	@Size(min = 1, message = "El nombre debe tener como mínimo 1 caracter")
	@Size(max = 10, message = "El nombre debe tener como máximo 10 caracteres")
	// Acepta letras del alfabeto y espacios
	@Pattern(regexp = "^[a-zA-Z0-9\\s]+$", message = "Debe ingresar datos alfanuméricos")
	// Para que no acepte solo números
	@Pattern(regexp = "(?!^\\d+$)^.+$", message = "No debe ingresar solo números")
	// Para que no acepte solo espacios
	@Pattern(regexp = "^(?!\\s*$)[-a-zA-Z0-9_:,.\\s]{1,100}$", message = "No debe ingresar solo espacios")
	private String nombreAlmacen;

	@Column(name = "descripcionAlmacen")
	@NotEmpty(message = "Debe ingresar un la descripción del almacen")
	@Size(min = 1, message = "La descripción debe tener como mínimo 1 caracter")
	@Size(max = 30, message = "El nombre debe tener como máximo 30 caracteres")
	// Acepta letras del alfabeto y espacios
	@Pattern(regexp = "^[a-zA-Z0-9\\s]+$", message = "Debe ingresar datos alfanuméricos")
	// Para que no acepte solo números
	@Pattern(regexp = "(?!^\\d+$)^.+$", message = "No debe ingresar solo números")
	// Para que no acepte solo espacios
	@Pattern(regexp = "^(?!\\s*$)[-a-zA-Z0-9_:,.\\s]{1,100}$", message = "No debe ingresar solo espacios")
	private String descripcionAlmacen;

	@Column(name = "direccionAlmacen")
	@NotEmpty(message = "Debe ingresar la dirección del almacén")
	@Size(min = 1, message = "La dirección debe tener como mínimo 1 caracter")
	@Size(max = 30, message = "La dirección debe tener como máximo 30 caracteres")
	// Acepta letras del alfabeto y espacios
	@Pattern(regexp = "^[a-zA-Z0-9\\s]+$", message = "Debe ingresar datos alfanuméricos")
	// Para que no acepte solo números
	@Pattern(regexp = "(?!^\\d+$)^.+$", message = "No debe ingresar solo números")
	// Para que no acepte solo espacios
	@Pattern(regexp = "^(?!\\s*$)[-a-zA-Z0-9_:,.\\s]{1,100}$", message = "No debe ingresar solo espacios")
	private String direccionAlmacen;

	public Almacen() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Almacen(int idAlmacen, String nombreAlmacen, String descripcionAlmacen, String direccionAlmacen) {
		super();
		this.idAlmacen = idAlmacen;
		this.nombreAlmacen = nombreAlmacen;
		this.descripcionAlmacen = descripcionAlmacen;
		this.direccionAlmacen = direccionAlmacen;
	}

	public int getIdAlmacen() {
		return idAlmacen;
	}

	public void setIdAlmacen(int idAlmacen) {
		this.idAlmacen = idAlmacen;
	}

	public String getNombreAlmacen() {
		return nombreAlmacen;
	}

	public void setNombreAlmacen(String nombreAlmacen) {
		this.nombreAlmacen = nombreAlmacen;
	}

	public String getDescripcionAlmacen() {
		return descripcionAlmacen;
	}

	public void setDescripcionAlmacen(String descripcionAlmacen) {
		this.descripcionAlmacen = descripcionAlmacen;
	}

	public String getDireccionAlmacen() {
		return direccionAlmacen;
	}

	public void setDireccionAlmacen(String direccionAlmacen) {
		this.direccionAlmacen = direccionAlmacen;
	}

}
