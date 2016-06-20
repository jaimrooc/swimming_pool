package co.com.jrojas.test.springRestAngular.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import co.com.jrojas.test.springRestAngular.model.Alumno;
import co.com.jrojas.test.springRestAngular.model.exceptions.BussinessException;
import co.com.jrojas.test.springRestAngular.model.exceptions.BussinessMessage;
import co.com.jrojas.test.springRestAngular.persistencia.interfaces.AlumnoDAOInterface;

public class AlumnoDAO implements AlumnoDAOInterface {
	
	// JDBC driver name and database URL
   static final String JDBC_DRIVER = "org.postgresql.Driver";  
   static final String DB_URL = "jdbc:postgresql://localhost:5432/swimming_class";

   //  Database credentials
   static final String USER = "postgres";
   static final String PASS = "Admin123*";
	
	@Override
	public boolean insert(Alumno alumno) throws BussinessException {
		Connection con = null;
	    PreparedStatement pst = null;
		try {
			Class.forName(JDBC_DRIVER);
	        con = DriverManager.getConnection(DB_URL,USER,PASS);
	        String query = ""
	        		+ " INSERT INTO ALUMNOS ("
	        		+ " 	identificacion,"
	        		+ " 	tipo_identificacion,"
	        		+ "		nombre,"
	        		+ "		apellido_primero,"
	        		+ " 	apellido_segundo,"
	        		+ " 	fecha_nacimiento)"
	        		+ " VALUES"
	        		+ " 	(?,?,?,?,?,?)";
			
	        pst = con.prepareStatement(query);
	        pst.setLong(1, alumno.getIdentificacion());
	        pst.setLong(2, alumno.getTipoIdentificacion() == null ? 1 : alumno.getTipoIdentificacion());
	        pst.setString(3, alumno.getNombre());
	        pst.setString(4, alumno.getApellidoPrimero());
	        pst.setString(5, alumno.getApellidoSegundo());
	        pst.setDate(6,  new java.sql.Date(alumno.getFechaNacimiento().getTime()));
	        if (pst.executeUpdate() == 1) {
	        	return true;
	        } else {
	        	return false;
	        }
	        
		} catch (Exception e) {
			throw new BussinessException(new BussinessMessage(null, e.toString()));
		} finally {
			// finally block used to close resources
			try {
				if (pst != null)
					con.close();
			} catch (Exception se) {
				System.out.println(se);
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception se) {
				System.out.println(se);
			}
		}
	}

	@Override
	public boolean update(Alumno alumno) throws BussinessException {

		Connection con = null;
	    PreparedStatement pst = null;
		try {
			Class.forName(JDBC_DRIVER);
	        con = DriverManager.getConnection(DB_URL,USER,PASS);
	        String query = ""
	        		+ " UPDATE ALUMNOS SET "
	        		+ " 	tipo_identificacion = ?, "
	        		+ "		nombre = ?,"
	        		+ "		apellido_primero = ?,"
	        		+ " 	apellido_segundo = ?,"
	        		+ " 	fecha_nacimiento  = ?"
	        		+ " WHERE "
	        		+ " 	identificacion = ?";
			
	        pst = con.prepareStatement(query);

	        pst.setLong(1, alumno.getTipoIdentificacion() == null ? 1 : alumno.getTipoIdentificacion());
	        pst.setString(2, alumno.getNombre());
	        pst.setString(3, alumno.getApellidoPrimero());
	        pst.setString(4, alumno.getApellidoSegundo());
	        pst.setDate(5,  new java.sql.Date(alumno.getFechaNacimiento().getTime()));
	        pst.setLong(6, alumno.getIdentificacion());
	        
	        if (pst.executeUpdate() == 1) {
	        	return true;
	        } else {
	        	return false;
	        }
	        
		} catch (Exception e) {
			throw new BussinessException(new BussinessMessage(null, e.toString()));
		} finally {
			// finally block used to close resources
			try {
				if (pst != null)
					con.close();
			} catch (Exception se) {
				System.out.println(se);
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception se) {
				System.out.println(se);
			}
		}
	}

	@Override
	public Alumno get(Long identificacion) throws BussinessException {
		Connection con = null;
	    PreparedStatement pst = null;
	    ResultSet rs = null;

	    try {
	    	Class.forName(JDBC_DRIVER);
	        con = DriverManager.getConnection(DB_URL,USER,PASS);
	        String query = ""
	        		+ " SELECT"
	        		+ " 	identificacion AS id,"
	        		+ " 	tipo_identificacion AS tip_id,"
	        		+ "		nombre AS nombre,"
	        		+ "		apellido_primero AS ape_p,"
	        		+ " 	apellido_segundo AS ape_s,"
	        		+ " 	fecha_nacimiento AS fecha_nac"
	        		+ " FROM"
	        		+ " 	ALUMNOS "
	        		+ " WHERE"
	        		+ " 	identificacion = ?";

	        pst = con.prepareStatement(query);
	        pst.setLong(1, identificacion);
	        rs = pst.executeQuery();
	        
	        while (rs.next()) {
	        	Alumno alumno = new Alumno(
	        			identificacion, 
	        			rs.getString("nombre"), 
	        			rs.getString("ape_p"), 
	        			rs.getString("ape_s"),
	        			rs.getDate("fecha_nac"), 
	        			rs.getLong("tip_id"));
	        	return alumno;
            }
	    } catch (Exception ex) {
	    	throw new BussinessException(new BussinessMessage(null, ex.toString()));
	    } finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (pst != null) {
	                pst.close();
	            }
	            if (con != null) {
	                con.close();
	            }
	        } catch (Exception ex) {
	            System.out.println("Al cerrar conexiones: " + ex);
	            return null;
	        }
	    }
		return null;
	}

	@Override
	public boolean delete(Long idSeguroMedico) throws BussinessException {
		Connection con = null;
	    PreparedStatement pst = null;
		try {
			Class.forName(JDBC_DRIVER);
	        con = DriverManager.getConnection(DB_URL,USER,PASS);
	        String query = ""
	        		+ " DELETE FROM ALUMNOS WHERE identificacion = ?";
			
	        pst = con.prepareStatement(query);

	        pst.setLong(1, idSeguroMedico);
	        
	        if (pst.executeUpdate() == 1) {
	        	return true;
	        } else {
	        	return false;
	        }
	        
		} catch (Exception e) {
			throw new BussinessException(new BussinessMessage(null, e.toString()));
		} finally {
			try {
				if (pst != null)
					con.close();
			} catch (Exception se) {
				System.out.println(se);
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception se) {
				System.out.println(se);
			}
		}
	}

	@Override
	public List<Alumno> findAll() throws BussinessException {
		Connection con = null;
	    PreparedStatement pst = null;
	    ResultSet rs = null;

	    try {
	    	Class.forName(JDBC_DRIVER);
	        con = DriverManager.getConnection(DB_URL,USER,PASS);
	        ArrayList<Alumno> listaAlumnos = new ArrayList<>();	    	
	        String query = ""
	        		+ " SELECT"
	        		+ " 	identificacion AS id,"
	        		+ " 	tipo_identificacion AS tip_id,"
	        		+ "		nombre AS nombre,"
	        		+ "		apellido_primero AS ape_p,"
	        		+ " 	apellido_segundo AS ape_s,"
	        		+ " 	fecha_nacimiento AS fecha_nac"
	        		+ " FROM"
	        		+ " 	ALUMNOS ";
	        
	        pst = con.prepareStatement(query);
	        rs = pst.executeQuery();
	        
	        while (rs.next()) {
	        	listaAlumnos.add(new Alumno(
	        			rs.getLong("id"), 
	        			rs.getString("nombre"), 
	        			rs.getString("ape_p"), 
	        			rs.getString("ape_s"),
	        			rs.getDate("fecha_nac"), 
	        			rs.getLong("tip_id")));
            }
	        return listaAlumnos;
	    } catch (Exception ex) {
	    	throw new BussinessException(new BussinessMessage(null, ex.toString()));
	    } finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (pst != null) {
	                pst.close();
	            }
	            if (con != null) {
	                con.close();
	            }
	        } catch (Exception ex) {
	            System.out.println("Al cerrar conexiones: " + ex);
	            return null;
	        }
	    }
	}
}