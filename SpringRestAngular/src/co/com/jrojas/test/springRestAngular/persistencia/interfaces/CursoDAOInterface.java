package co.com.jrojas.test.springRestAngular.persistencia.interfaces;

import java.util.List;

import co.com.jrojas.test.springRestAngular.model.Curso;
import co.com.jrojas.test.springRestAngular.model.exceptions.BussinessException;;

public interface CursoDAOInterface {

	public boolean insert(Curso curso) throws BussinessException;;
	public boolean update(Curso curso) throws BussinessException;;
	public Curso get(int codigo) throws BussinessException;;
	public boolean delete(int codigo) throws BussinessException;;
	public List<Curso> findAll() throws BussinessException;;
	
}