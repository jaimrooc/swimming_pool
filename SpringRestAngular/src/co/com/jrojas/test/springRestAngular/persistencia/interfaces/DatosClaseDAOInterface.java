package co.com.jrojas.test.springRestAngular.persistencia.interfaces;

import java.util.List;

import co.com.jrojas.test.springRestAngular.model.DatosClases;
import co.com.jrojas.test.springRestAngular.model.WrapperDatosClaseLite;
import co.com.jrojas.test.springRestAngular.model.exceptions.BussinessException;;

public interface DatosClaseDAOInterface {

	public boolean insert(DatosClases configCursos) throws BussinessException;
	public boolean insertarLista(WrapperDatosClaseLite  datosClases) throws BussinessException;
	public boolean update(DatosClases configCursos) throws BussinessException;
	public DatosClases get(int codigo) throws BussinessException;
	public boolean delete(int codigo) throws BussinessException;
	public List<DatosClases> findAll() throws BussinessException;
	public List<DatosClases> findAllByClass(int codigo) throws BussinessException;
	
}