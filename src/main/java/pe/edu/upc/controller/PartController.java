package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Motor;
import pe.edu.upc.entity.Part;
import pe.edu.upc.service.IMotorService;
import pe.edu.upc.service.IPartService;

@Named
@SessionScoped
public class PartController implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private IMotorService mS;
	@Inject
	private IPartService pS;
	private Motor motor;
	private Part part;
	private List<Motor> listMotors;
	private List<Part> listParts;

	@PostConstruct
	public void init() {
		motor = new Motor();
		part = new Part();
		listMotors = new ArrayList<>();
		listParts = new ArrayList<>();
		this.listMotor();
		this.listPart();
	}

	// metodos
	public String newPart() {
		this.setPart(new Part());
		return "part.xhtml";
	}

	public void insert() {
		try {

			pS.insert(part);
			cleanPart();
			this.listPart();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void delete(Part part) {
		try {
			pS.delete(part.getIdPart());
			listPart();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listPart() {
		try {
			listParts = pS.list();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listMotor() {
		try {
			listMotors = mS.list();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void cleanPart() {
		this.init();
	}

	

//get y set
	public Motor getMotor() {
		return motor;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	public List<Motor> getListMotors() {
		return listMotors;
	}

	public void setListMotors(List<Motor> listMotors) {
		this.listMotors = listMotors;
	}

	public List<Part> getListParts() {
		return listParts;
	}

	public void setListParts(List<Part> listParts) {
		this.listParts = listParts;
	}

}
