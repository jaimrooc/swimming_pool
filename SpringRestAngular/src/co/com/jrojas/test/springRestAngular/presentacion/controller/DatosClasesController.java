package co.com.jrojas.test.springRestAngular.presentacion.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.jrojas.test.springRestAngular.model.Alumno;
import co.com.jrojas.test.springRestAngular.model.Clase;
import co.com.jrojas.test.springRestAngular.model.DatosClases;
import co.com.jrojas.test.springRestAngular.model.WrapperDatosClaseLite;
import co.com.jrojas.test.springRestAngular.model.exceptions.BussinessException;
import co.com.jrojas.test.springRestAngular.model.exceptions.BussinessMessage;
import co.com.jrojas.test.springRestAngular.persistencia.AlumnoDAO;
import co.com.jrojas.test.springRestAngular.persistencia.DatosClaseDAO;
import co.com.jrojas.test.springRestAngular.presentacion.json.interfaces.InterfaceJsonTransformer;

@Controller
public class DatosClasesController {
	
	@Autowired
    private InterfaceJsonTransformer jsonTransformer;
	
	@Autowired
	private DatosClaseDAO datosClaseDAO;
	@Autowired
	private AlumnoDAO alumnoDAO;
	
	@RequestMapping(value = "/DatosClases/{codigo}", method=RequestMethod.GET, produces = "application/json")
	public void leer(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("codigo") Integer codigo) throws IOException {
		try {
			DatosClases datosClases = datosClaseDAO.get(codigo);
            String jsonSalida=jsonTransformer.toJson(datosClases);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonSalida);
        }  catch (BussinessException ex) {
            List<BussinessMessage> bussinessMessage = ex.getBussinessMessages();
            String jsonSalida = jsonTransformer.toJson(bussinessMessage);
            
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            try {
                httpServletResponse.getWriter().println(jsonSalida);
            } catch (IOException ex1) {
                Logger.getLogger(TipoIdentificacionController.class.getName()).log(Level.SEVERE, null, ex1);
            }
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
	
	@RequestMapping(value = "/DatosClases", method=RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public void insertar(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) {
		try {
			DatosClases datosClases = (DatosClases) jsonTransformer.fromJson(jsonEntrada, DatosClases.class);
            datosClaseDAO.insert(datosClases);
            String jsonSalida=jsonTransformer.toJson(datosClases);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonSalida);
        }  catch (BussinessException ex) {
            List<BussinessMessage> bussinessMessage = ex.getBussinessMessages();
            String jsonSalida = jsonTransformer.toJson(bussinessMessage);
            
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            try {
                httpServletResponse.getWriter().println(jsonSalida);
            } catch (IOException ex1) {
                Logger.getLogger(TipoIdentificacionController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (Exception ex) {

        	// Cuando existen metodos personalizados del negocio
        	// httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        	
        	System.out.println("En metodo insertar: " + ex);
        	httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
	}
	
	@RequestMapping(value = "/DatosClases/list{codigo}", method=RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public void insertarLista(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) {
		try {
			WrapperDatosClaseLite datosClases = (WrapperDatosClaseLite) jsonTransformer.fromJson(jsonEntrada, WrapperDatosClaseLite.class);
			
			datosClaseDAO.delete(datosClases.getClase());
            
			datosClaseDAO.insertarLista(datosClases);
            String jsonSalida=jsonTransformer.toJson(datosClases);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonSalida);
        }  catch (BussinessException ex) {
            List<BussinessMessage> bussinessMessage = ex.getBussinessMessages();
            String jsonSalida = jsonTransformer.toJson(bussinessMessage);
            
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            try {
                httpServletResponse.getWriter().println(jsonSalida);
            } catch (IOException ex1) {
                Logger.getLogger(TipoIdentificacionController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (Exception ex) {
        	System.out.println("En metodo insertar: " + ex);
        	httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
	}
	
	@RequestMapping(value = "/DatosClases", method = RequestMethod.GET, produces = "application/json")
	public void findAll(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		try {
			List<DatosClases> segurosMedicos = datosClaseDAO.findAll();
			String jsonSalida = jsonTransformer.toJson(segurosMedicos);
			
			httpServletResponse.setStatus(HttpServletResponse.SC_OK);
			httpServletResponse.setContentType("application/json; charset=UTF-8");
			httpServletResponse.getWriter().println(jsonSalida);
		}  catch (BussinessException ex) {
            List<BussinessMessage> bussinessMessage = ex.getBussinessMessages();
            String jsonSalida = jsonTransformer.toJson(bussinessMessage);
            
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            try {
                httpServletResponse.getWriter().println(jsonSalida);
            } catch (IOException ex1) {
                Logger.getLogger(TipoIdentificacionController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }  catch (Exception ex) {
			httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/DatosClases/list/{codigo}", method = RequestMethod.GET, produces = "application/json")
	public void findAllAlumnosClase(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("codigo") int codigo) {
		try {
			List<Alumno> segurosMedicos = alumnoDAO.alumnosPorCurso(codigo);
			String jsonSalida = jsonTransformer.toJson(segurosMedicos);
			
			httpServletResponse.setStatus(HttpServletResponse.SC_OK);
			httpServletResponse.setContentType("application/json; charset=UTF-8");
			httpServletResponse.getWriter().println(jsonSalida);
		}  catch (BussinessException ex) {
            List<BussinessMessage> bussinessMessage = ex.getBussinessMessages();
            String jsonSalida = jsonTransformer.toJson(bussinessMessage);
            
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            try {
                httpServletResponse.getWriter().println(jsonSalida);
            } catch (IOException ex1) {
                Logger.getLogger(TipoIdentificacionController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }  catch (Exception ex) {
			httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/DatosClases/{codigo}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public void update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada, @PathVariable("codigo") int codigo) {
		try {
			DatosClases datosClases = (DatosClases) jsonTransformer.fromJson(jsonEntrada, DatosClases.class);
	        datosClaseDAO.update(datosClases);
	        String jsonSalida = jsonTransformer.toJson(datosClases);
	        
	        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
	        httpServletResponse.setContentType("application/json; charset=UTF-8");
	        httpServletResponse.getWriter().println(jsonSalida);
        }  catch (BussinessException ex) {
            List<BussinessMessage> bussinessMessage = ex.getBussinessMessages();
            String jsonSalida = jsonTransformer.toJson(bussinessMessage);
            
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            try {
                httpServletResponse.getWriter().println(jsonSalida);
            } catch (IOException ex1) {
                Logger.getLogger(TipoIdentificacionController.class.getName()).log(Level.SEVERE, null, ex1);
            }
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
	
	@RequestMapping(value = "/DatosClases/{codigo}", method = RequestMethod.DELETE, produces = "application/json")
	public void delete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("codigo") int codigo) {
		try {
			datosClaseDAO.delete(codigo);
			httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
		}  catch (BussinessException ex) {
            List<BussinessMessage> bussinessMessage = ex.getBussinessMessages();
            String jsonSalida = jsonTransformer.toJson(bussinessMessage);
            
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            try {
                httpServletResponse.getWriter().println(jsonSalida);
            } catch (IOException ex1) {
                Logger.getLogger(TipoIdentificacionController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (Exception ex) {
			httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}  
}