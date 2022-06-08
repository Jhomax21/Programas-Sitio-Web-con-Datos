package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProducto")
	private int idProducto;

	@NotEmpty(message = "Debe ingresar un nombre")
	@Size(min = 1, message = "El nombre debe tener como mínimo 1 caracter")
	@Size(max = 10, message = "El nombre debe tener como máximo 10 caracteres")
	// Acepta letras del alfabeto y espacios
	@Pattern(regexp = "^[a-zA-Z0-9\\s]+$", message = "Debe ingresar datos alfanuméricos")
	// Para que no acepte solo números
	@Pattern(regexp = "(?!^\\d+$)^.+$", message = "No debe ingresar solo números")
	// Para que no acepte solo espacios
	@Pattern(regexp = "^(?!\\s*$)[-a-zA-Z0-9_:,.\\s]{1,100}$", message = "No debe ingresar solo espacios")
	private String nombreProducto;

	@Column(name = "cantidadProducto")
	@NotNull(message = "Debe ingresar la cantidad de existencias del producto")
	@DecimalMax("500.00")
	@DecimalMin("1.00")
	private Double cantidadProducto;

	@Column(name = "precioUnitProducto")
	@NotNull(message = "Debe ingresar el precio unitario del producto")
	@DecimalMax("500.00")
	@DecimalMin("1.00")
	private Double precioUnitProducto;

	@Transient
	private double precioProducto;

	@ManyToOne
	@JoinColumn(name = "idAlmacen")
	private Almacen almacen;

	@ManyToOne
	@JoinColumn(name = "idCliente")
	private Cliente cliente;

	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Producto(int idProducto, String nombreProducto, Double cantidadProducto, Double precioUnitProducto,
			double precioProducto, Almacen almacen, Cliente cliente) {
		super();
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.cantidadProducto = cantidadProducto;
		this.precioUnitProducto = precioUnitProducto;
		this.precioProducto = precioProducto;
		this.almacen = almacen;
		this.cliente = cliente;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Double getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(Double cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	public Double getPrecioUnitProducto() {
		return precioUnitProducto;
	}

	public void setPrecioUnitProducto(Double precioUnitProducto) {
		this.precioUnitProducto = precioUnitProducto;
	}

	public double getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}

	public Almacen getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
