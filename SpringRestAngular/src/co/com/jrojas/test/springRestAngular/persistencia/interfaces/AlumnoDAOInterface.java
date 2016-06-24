package co.com.jrojas.test.springRestAngular.persistencia.interfaces;

import java.util.List;

import co.com.jrojas.test.springRestAngular.model.Alumno;
import co.com.jrojas.test.springRestAngular.model.exceptions.BussinessException;

public interface AlumnoDAOInterface {

	public boolean insert(Alumno alumno) throws BussinessException;;
	public boolean update(Alumno alumno) throws BussinessException;;
	public Alumno get(Long identificacion) throws BussinessException;;
	public boolean delete(Long idSeguroMedico) throws BussinessException;;
	public List<Alumno> findAll() throws BussinessException;;
	public List<Alumno> alumnosPorCurso(int codigo) throws BussinessException;;
}