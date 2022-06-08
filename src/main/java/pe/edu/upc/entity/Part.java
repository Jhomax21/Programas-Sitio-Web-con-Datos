package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Part ")
public class Part implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPart;
	@Column(name = "descriptionPart", nullable = false, length = 45)
	private String descriptionPart;
	@ManyToOne
	@JoinColumn(name = "idMotor", nullable = false)
	private Motor motor;
	
	public Part(int idPart, String descriptionPart, Motor motor) {
		super();
		this.idPart = idPart;
		this.descriptionPart = descriptionPart;
		this.motor = motor;
	}
	public Part() {
		super();
	}
	public int getIdPart() {
		return idPart;
	}
	public void setIdPart(int idPart) {
		this.idPart = idPart;
	}
	public String getDescriptionPart() {
		return descriptionPart;
	}
	public void setDescriptionPart(String descriptionPart) {
		this.descriptionPart = descriptionPart;
	}
	public Motor getMotor() {
		return motor;
	}
	public void setMotor(Motor motor) {
		this.motor = motor;
	}
}
