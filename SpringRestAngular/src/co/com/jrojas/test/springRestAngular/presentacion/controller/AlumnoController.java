package co.com.jrojas.test.springRestAngular.presentacion.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.com.jrojas.test.springRestAngular.model.Alumno;
import co.com.jrojas.test.springRestAngular.persistencia.AlumnoDAO;
import co.com.jrojas.test.springRestAngular.presentacion.json.interfaces.InterfaceJsonTransformer;

@Controller
public class AlumnoController {
	
	@Autowired
    private InterfaceJsonTransformer jsonTransformer;
	
	@Autowired
	private AlumnoDAO alumnoDAO;
	
	@RequestMapping(value = "/Alumno/{identificacion}", method=RequestMethod.GET, produces = "application/json")
	public void leer(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("identificacion") Long identificacion) throws IOException {
		try {
			Alumno alumno = alumnoDAO.get(identificacion);
            String jsonSalida=jsonTransformer.toJson(alumno);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonSalida);
        } catch (Exception ex) {
        	// Cuando existen metodos personalizados del negocio
        	// httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        	
        	System.out.println("En metodo Leer: " + ex);
        	httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        	httpServletResponse.setContentType("text/plain; charset=UTF-8");
        	try {
        	    ex.printStackTrace(httpServletResponse.getWriter());
        	} catch (IOException ex1) {
        	    System.out.println(ex1);
        	}
        }
	}
	
	@RequestMapping(value = "/Alumno", method=RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public void insertar(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) {
		try {
            Alumno alumno = (Alumno) jsonTransformer.fromJson(jsonEntrada, Alumno.class);
            alumnoDAO.insert(alumno);
            String jsonSalida=jsonTransformer.toJson(alumno);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonSalida);
        } catch (Exception ex) {

        	// Cuando existen metodos personalizados del negocio
        	// httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        	
        	System.out.println("En metodo insertar: " + ex);
        	httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
	}
	
	@RequestMapping(value = "/Alumno", method = RequestMethod.GET, produces = "application/json")
	public void findAll(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		try {
			List<Alumno> segurosMedicos = alumnoDAO.findAll();
			String jsonSalida = jsonTransformer.toJson(segurosMedicos);
			
			httpServletResponse.setStatus(HttpServletResponse.SC_OK);
			httpServletResponse.setContentType("application/json; charset=UTF-8");
			httpServletResponse.getWriter().println(jsonSalida);
		}  catch (Exception ex) {
			httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/Alumno/{identificacion}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public void update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada, @PathVariable("identificacion") Long identificacion) {
		try {
			Alumno alumno = (Alumno) jsonTransformer.fromJson(jsonEntrada, Alumno.class);
	        alumnoDAO.update(alumno);
	        String jsonSalida = jsonTransformer.toJson(alumno);
	        
	        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
	        httpServletResponse.setContentType("application/json; charset=UTF-8");
	        httpServletResponse.getWriter().println(jsonSalida);
        } catch (Exception ex) {
        	httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        	httpServletResponse.setContentType("text/plain; charset=UTF-8");
        	try {
        		ex.printStackTrace(httpServletResponse.getWriter());
    		} catch (IOException ex1) {
    			System.out.println(ex1);
			}
    	}
	}
	
	@RequestMapping(value = "/Alumno/{identificacion}", method = RequestMethod.DELETE, produces = "application/json")
	public void delete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("identificacion") Long identificacion) {
		try {
			alumnoDAO.delete(identificacion);
			httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
		} catch (Exception ex) {
			httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}  
}