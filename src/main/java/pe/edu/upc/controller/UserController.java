package pe.edu.upc.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.User;
import pe.edu.upc.service.IUserService;

@Named
@ViewScoped
public class UserController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IUserService uService;
	private User user;
	
	@PostConstruct
	public void init() {
		FacesContext context = FacesContext.getCurrentInstance();
		User us = (User) context.getExternalContext().getSessionMap().get("user");
		setUser(us);
		us.getCustomer();
	}
	
	//modificar
	
		public String preUpdate(User userr) {
			this.setUser(userr);
			return "modifyUser.xhtml";
		}
		
		public void update() {
			try {
				uService.update(this.user);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
