package co.com.jrojas.test.springRestAngular.persistencia.interfaces;

import java.util.List;
import co.com.jrojas.test.springRestAngular.model.Profesor;

public interface ProfesorDAOInterface {

	public boolean insert(Profesor profesor);
	public boolean update(Profesor profesor);
	public Profesor get(Long identificacion);
	public boolean delete(Long codigo);
	public List<Profesor> findAll();
	
}