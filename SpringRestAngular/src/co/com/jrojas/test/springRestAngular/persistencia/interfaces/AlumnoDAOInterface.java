package co.com.jrojas.test.springRestAngular.persistencia.interfaces;

import java.util.List;

import co.com.jrojas.test.springRestAngular.model.Alumno;

public interface AlumnoDAOInterface {

	public boolean insert(Alumno alumno);
	public boolean update(Alumno alumno);
	public Alumno get(Long identificacion);
	public boolean delete(Long idSeguroMedico);
	public List<Alumno> findAll();
	
}