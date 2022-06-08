package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IMotorDao;
import pe.edu.upc.entity.Motor;
import pe.edu.upc.service.IMotorService;

@Named
@RequestScoped
public class MotorServiceImpl implements IMotorService, Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private IMotorDao mD;

	@Override
	public void insert(Motor motor) {
		mD.insert(motor);
	}

	@Override
	public List<Motor> list() {
		// TODO Auto-generated method stub
		return mD.list();
	}

	@Override
	public void delete(int idMotor) {
		mD.delete(idMotor);
	}

	@Override
	public List<Motor> finByName(Motor motor) {
		// TODO Auto-generated method stub
		return mD.finByName(motor);
	}

}
