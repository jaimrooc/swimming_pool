package co.com.jrojas.test.springRestAngular.persistencia.interfaces;

import java.util.List;

import co.com.jrojas.test.springRestAngular.model.TipoIdentificacion;
import co.com.jrojas.test.springRestAngular.model.exceptions.BussinessException;


public interface TiposIdentificacionDAOInterface {

	public boolean insert(TipoIdentificacion tiposIdentificacion) throws BussinessException;;
	public boolean update(TipoIdentificacion tiposIdentificacion) throws BussinessException;;
	public TipoIdentificacion get(int identificacion) throws BussinessException;;
	public boolean delete(int idSeguroMedico) throws BussinessException;;
	public List<TipoIdentificacion> findAll() throws BussinessException;;
	
}