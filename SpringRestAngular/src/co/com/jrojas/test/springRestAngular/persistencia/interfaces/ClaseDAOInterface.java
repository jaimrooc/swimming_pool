package co.com.jrojas.test.springRestAngular.persistencia.interfaces;

import java.util.List;

import co.com.jrojas.test.springRestAngular.model.Clase;
import co.com.jrojas.test.springRestAngular.model.exceptions.BussinessException;;

public interface ClaseDAOInterface {

	public boolean insert(Clase clase) throws BussinessException;;
	public boolean update(Clase clase) throws BussinessException;;
	public Clase get(int codigo) throws BussinessException;;
	public boolean delete(int codigo) throws BussinessException;;
	public List<Clase> findAll() throws BussinessException;;
	
}