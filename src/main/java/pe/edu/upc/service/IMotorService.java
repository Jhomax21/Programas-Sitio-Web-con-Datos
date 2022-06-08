package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Motor;

public interface IMotorService {
	public void insert(Motor motor);

	public List<Motor> list();

	public void delete(int idMotor);

	public List<Motor> finByName(Motor motor);

}
