package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Product;
import pe.edu.upc.service.IProductService;

@Named
@SessionScoped
public class ProductController implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private IProductService pService;
	private Product product;
	private String mensaje = "";
	List<Product> listProducts;
	
	@PostConstruct
	public void init() {
		this.listProducts = new ArrayList<Product>();
		this.product = new Product();
		this.list();
	}
	
	public void list() {
		try {
			listProducts = pService.list();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public String newProduct() {
		this.setProduct(new Product());
		return "product.xhtml";

	}
	
	public void cleanProduct() {
		this.init();
	}
	
	
	public void insert() {
		try {

			pService.insert(product);
			this.init();
			
			mensaje = "Se registró correctamente";			
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	
	public void delete(Product pro) {
		try {
			pService.delete(pro.getIdProduct());
			list();
		} catch (Exception e) {
			e.getMessage();
			mensaje = "No se puede eliminar";
		}
	}
	
	public void findByName() {
		try {
			if (product.getNombre().isEmpty()) {
				this.list();
			} else {
				listProducts = this.pService.finByName(this.getProduct());
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void funcion() {
		listProducts = this.pService.list();
	}
	
	//modificar
	
	public String preUpdate(Product pr) {
		this.setProduct(pr);
		return "modifyProduct.xhtml";
	}
	
	public void update() {
		try {
			pService.update(this.product);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public List<Product> getListProducts() {
		return listProducts;
	}

	public void setListProducts(List<Product> listProducts) {
		this.listProducts = listProducts;
	}
		
}
