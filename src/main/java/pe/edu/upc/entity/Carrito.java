package pe.edu.upc.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Carrito")
public class Carrito implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCarrito;
	@Column(name = "precioTotal", nullable = false, length = 10)
	private int precioTotal;
	@ManyToOne
	@JoinColumn(name = "idProduct", nullable = false)
	private Product product;

	public Carrito() {
		super();
		// TODO Auto-generated constructor stub
	}	

	public Carrito(int idCarrito, int precioTotal, Product product) {
		super();
		this.idCarrito = idCarrito;
		this.precioTotal = precioTotal;
		this.product = product;
	}

	public int getIdCarrito() {
		return idCarrito;
	}

	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}	

	public int getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(int precioTotal) {
		this.precioTotal = precioTotal;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCarrito, precioTotal, product);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carrito other = (Carrito) obj;
		return idCarrito == other.idCarrito && precioTotal == other.precioTotal
				&& Objects.equals(product, other.product);
	}	
	
	
}
