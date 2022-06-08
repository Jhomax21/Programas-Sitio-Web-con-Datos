package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.User;
import pe.edu.upc.entity.UserRol;
import pe.edu.upc.service.IRolService;

@Named
@ViewScoped
public class MasterController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private IRolService rS;

	public void verificarSesion() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			User us = (User) context.getExternalContext().getSessionMap().get("user");

			if (us == null) {
				context.getExternalContext().redirect("index.xhtml");
			} else {
				// verificacion de roles
				String viewId = context.getViewRoot().getViewId();
				boolean rpta = this.verificarMenu(viewId);

				if (!rpta) {
					context.getExternalContext().redirect("./403.xhtml");
				}
			}
		} catch (Exception e) {

		}
	}

	public boolean verificarMenu(String viewId) throws Exception {
		FacesContext context = FacesContext.getCurrentInstance();
		User us = (User) context.getExternalContext().getSessionMap().get("user");

		List<UserRol> roles = rS.findUserRolesByUser(us);

		String rol = "";
		switch (viewId) {
		case "/Pago.xhtml":
			rol = "USER";
			break;

		case "/listCarrito.xhtml":
			rol = "USER";
			break;
		case "/Carrito.xhtml":
			rol = "USER";
			break;
		case "/product.xhtml":
			rol = "ADMIN";
			break;
		case "/listProduct.xhtml":
			rol = "ADMIN";
			break;
		case "/Cuenta.xhtml":
			rol = "ADMIN,USER";
			break;
		case "/modifyProduct.xhtml":
			rol = "ADMIN";
			break;
		case "/userProduct.xhtml":
			rol = "USER";
			break;
		case "/panel.xhtml":
			rol = "ADMIN,USER";
			break;

		default:
			break;
		}

		String arreglo[] = rol.split(",");

		int[] iarr = { 0 };
		roles.forEach(r -> {
			for (String x : arreglo) {
				if (r.getRol().getType().equals(x)) {
					iarr[0]++;
				}
			}
		});

		// System.out.println(iarr[0]);
		if (iarr[0] == 0) {
			return false;
		}
		return true;
	}

	public void cerrarSesion() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}
}
