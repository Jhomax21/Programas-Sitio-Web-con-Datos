package pe.edu.upc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Motor")
public class Motor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMotor;

	@Column(name = "nameMotor", nullable = false, length = 50)
	private String nameMotor;

	private Date manufacturingDateMotor;

	public Motor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Motor(int idMotor, String nameMotor, Date manufacturingDateMotor) {
		super();
		this.idMotor = idMotor;
		this.nameMotor = nameMotor;
		this.manufacturingDateMotor = manufacturingDateMotor;
	}

	public int getIdMotor() {
		return idMotor;
	}

	public void setIdMotor(int idMotor) {
		this.idMotor = idMotor;
	}

	public String getNameMotor() {
		return nameMotor;
	}

	public void setNameMotor(String nameMotor) {
		this.nameMotor = nameMotor;
	}

	public Date getManufacturingDateMotor() {
		return manufacturingDateMotor;
	}

	public void setManufacturingDateMotor(Date manufacturingDateMotor) {
		this.manufacturingDateMotor = manufacturingDateMotor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idMotor;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Motor other = (Motor) obj;
		if (idMotor != other.idMotor)
			return false;
		return true;
	}

}
