package co.com.jrojas.test.springRestAngular.persistencia.interfaces;

import java.util.List;

import co.com.jrojas.test.springRestAngular.model.TipoIdentificacion;


public interface TiposIdentificacionDAOInterface {

	public boolean insert(TipoIdentificacion tiposIdentificacion);
	public boolean update(TipoIdentificacion tiposIdentificacion);
	public TipoIdentificacion get(int identificacion);
	public boolean delete(int idSeguroMedico);
	public List<TipoIdentificacion> findAll();
	
}