package co.com.jrojas.test.springRestAngular.persistencia.interfaces;

import java.util.List;
import co.com.jrojas.test.springRestAngular.model.Profesor;
import co.com.jrojas.test.springRestAngular.model.exceptions.BussinessException;

public interface ProfesorDAOInterface {

	public boolean insert(Profesor profesor) throws BussinessException;;
	public boolean update(Profesor profesor) throws BussinessException;;
	public Profesor get(Long identificacion) throws BussinessException;;
	public boolean delete(Long codigo) throws BussinessException;;
	public List<Profesor> findAll() throws BussinessException;;
	
}