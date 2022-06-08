package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Motor;
import pe.edu.upc.service.IMotorService;

@Named
@RequestScoped
public class MotorController implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private IMotorService mService;
	private Motor motor;
	private String mensaje = "";
	List<Motor> listMotors;

	@PostConstruct
	public void init() {
		this.listMotors = new ArrayList<Motor>();
		this.motor = new Motor();
		this.list();
	}

	// metodos
	public String newMotor() {
		this.setMotor(new Motor());
		return "motor.xhtml";

	}

	public void insert() {
		try {

			mService.insert(motor);
			// cleanMotor();
			mensaje = "Se registró correctamente";

			// this.list();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void list() {
		try {
			listMotors = mService.list();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void cleanMotor() {
		this.init();
	}

	public void delete(Motor mo) {
		try {
			mService.delete(mo.getIdMotor());
			list();
		} catch (Exception e) {
			e.getMessage();
			mensaje = "No se puede eliminar";
		}
	}

	public void findByName() {
		try {
			if (motor.getNameMotor().isEmpty()) {
				this.list();
			} else {
				listMotors = this.mService.finByName(this.getMotor());
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// get y set
	public Motor getMotor() {
		return motor;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	public List<Motor> getListMotors() {
		return listMotors;
	}

	public void setListMotors(List<Motor> listMotors) {
		this.listMotors = listMotors;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
