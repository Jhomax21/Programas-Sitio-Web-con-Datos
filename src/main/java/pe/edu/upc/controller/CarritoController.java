package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Carrito;
import pe.edu.upc.entity.Product;
import pe.edu.upc.service.ICarritoService;
import pe.edu.upc.service.IProductService;

@Named
@SessionScoped
public class CarritoController implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private IProductService pS;
	@Inject
	private ICarritoService cS;
	private Product product;
	private Carrito carrito;
	private List<Product> listProduct;
	private List<Carrito> listCarrito;
	
	@PostConstruct
	public void init() {
		carrito = new Carrito();
		this.carrito.setProduct(new Product());
		listProduct = new ArrayList<Product>();
		listCarrito = new ArrayList<Carrito>();
		this.listProducto();
		this.listaCarrito();
	}
	
	public void listaCarrito() {
		try {
			listCarrito = cS.list();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listProducto() {
		try {
			listProduct = pS.list();
		} catch (Exception e) {
			e.getMessage();
		}
	}	

	public String newCarrito() {
		this.setCarrito(new Carrito());
		return "Carrito.xhtml";
	}
	
	public void cleanCarrito() {
		this.init();
	}

	public void insert() {
		try {
			cS.insert(carrito);
			this.init();
			cleanCarrito();
			System.out.println("Se registro el carrito completamente");
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void delete(Carrito carr) {
		try {
			cS.delete(carr.getIdCarrito());
			this.listaCarrito();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error al eliminar empleador en el controlador");
		}
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Carrito getCarrito() {
		return carrito;
	}

	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}

	public List<Product> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}

	public List<Carrito> getListCarrito() {
		return listCarrito;
	}

	public void setListCarrito(List<Carrito> listCarrito) {
		this.listCarrito = listCarrito;
	}

}
