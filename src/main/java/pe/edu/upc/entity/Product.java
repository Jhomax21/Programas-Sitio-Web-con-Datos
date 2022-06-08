package pe.edu.upc.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProduct;

	@Column(name = "codigo", nullable = false, length = 50)
	private String codigo;

	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;

	@Column(name = "cantidad_mercancia", nullable = false, length = 50)
	private int cantidad_mercancia;

	@Column(name = "precio_unitario", nullable = false, length = 50)
	private int precio_unitario;
	
	@Column(name = "descripcion_producto", nullable = false, length = 50)
	private String descripcion_producto;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}	

	public Product(int idProduct, String codigo, String nombre, int cantidad_mercancia, int precio_unitario,
			String descripcion_producto) {
		super();
		this.idProduct = idProduct;
		this.codigo = codigo;
		this.nombre = nombre;
		this.cantidad_mercancia = cantidad_mercancia;
		this.precio_unitario = precio_unitario;
		this.descripcion_producto = descripcion_producto;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad_mercancia() {
		return cantidad_mercancia;
	}

	public void setCantidad_mercancia(int cantidad_mercancia) {
		this.cantidad_mercancia = cantidad_mercancia;
	}

	public int getPrecio_unitario() {
		return precio_unitario;
	}

	public void setPrecio_unitario(int precio_unitario) {
		this.precio_unitario = precio_unitario;
	}

	public String getDescripcion_producto() {
		return descripcion_producto;
	}

	public void setDescripcion_producto(String descripcion_producto) {
		this.descripcion_producto = descripcion_producto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidad_mercancia, codigo, descripcion_producto, idProduct, nombre, precio_unitario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(cantidad_mercancia, other.cantidad_mercancia) && Objects.equals(codigo, other.codigo)
				&& Objects.equals(descripcion_producto, other.descripcion_producto) && idProduct == other.idProduct
				&& Objects.equals(nombre, other.nombre) && Objects.equals(precio_unitario, other.precio_unitario);
	}
	
	
}
