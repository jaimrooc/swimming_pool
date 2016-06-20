package co.com.jrojas.test.springRestAngular.persistencia.interfaces;

import java.util.List;

import co.com.jrojas.test.springRestAngular.model.ConfigCursos;
import co.com.jrojas.test.springRestAngular.model.exceptions.BussinessException;;

public interface ConfigCursosDAOInterface {

	public boolean insert(ConfigCursos configCursos) throws BussinessException;;
	public boolean update(ConfigCursos configCursos) throws BussinessException;;
	public ConfigCursos get(int codigo) throws BussinessException;;
	public boolean delete(int codigo) throws BussinessException;;
	public List<ConfigCursos> findAll() throws BussinessException;;
	
}