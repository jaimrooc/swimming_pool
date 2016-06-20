package co.com.jrojas.test.springRestAngular.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import co.com.jrojas.test.springRestAngular.model.ConfigCursos;
import co.com.jrojas.test.springRestAngular.model.exceptions.BussinessException;
import co.com.jrojas.test.springRestAngular.model.exceptions.BussinessMessage;
import co.com.jrojas.test.springRestAngular.persistencia.interfaces.ConfigCursosDAOInterface;

public class ConfigCursosDAO implements ConfigCursosDAOInterface {
	
	// JDBC driver name and database URL
   static final String JDBC_DRIVER = "org.postgresql.Driver";  
   static final String DB_URL = "jdbc:postgresql://localhost:5432/swimming_class";

   //  Database credentials
   static final String USER = "postgres";
   static final String PASS = "Admin123*";
	
	@Override
	public boolean insert(ConfigCursos configCursos) throws BussinessException {
		Connection con = null;
	    PreparedStatement pst = null;
		try {
			Class.forName(JDBC_DRIVER);
	        con = DriverManager.getConnection(DB_URL,USER,PASS);
	        String query = ""
	        		+ " INSERT INTO CONFIG_CURSOS ("
	        		+ " 	codigo,"
	        		+ " 	descripcion,"
	        		+ "		minutos_de_clase,"
	        		+ "		nro_max_alumnos,"
	        		+ " 	nro_min_alumnos,"
	        		+ " 	cantidad_clases,"
	        		+ "		estado)"
	        		+ " VALUES"
	        		+ " 	(?,?,?,?,?,?,?)";
			
	        pst = con.prepareStatement(query);
	        pst.setInt(1, configCursos.getCodigo());
	        pst.setString(2, configCursos.getDescripcion());
	        pst.setInt(3, configCursos.getMinutosDeClase());
	        pst.setInt(4, configCursos.getNroMaxAlumnos());
	        pst.setInt(5, configCursos.getNroMinAlumnos());
	        pst.setInt(6, configCursos.getCantidadClases());
	        pst.setBoolean(7, configCursos.getEstado() == null ? true : configCursos.getEstado());
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
	public boolean update(ConfigCursos configCursos) throws BussinessException {

		Connection con = null;
	    PreparedStatement pst = null;
		try {
			Class.forName(JDBC_DRIVER);
	        con = DriverManager.getConnection(DB_URL,USER,PASS);
	        String query = ""
	        		+ " UPDATE CONFIG_CURSOS SET "
	        		+ " 	descripcion = ?,"
	        		+ "		minutos_de_clase = ?,"
	        		+ "		nro_max_alumnos = ?,"
	        		+ " 	nro_min_alumnos = ?,"
	        		+ " 	cantidad_clases = ?,"
	        		+ "		estado = ?"
	        		+ " WHERE "
	        		+ " 	codigo = ?";
			
	        pst = con.prepareStatement(query);

	        pst.setString(1, configCursos.getDescripcion());
	        pst.setInt(2, configCursos.getMinutosDeClase());
	        pst.setInt(3, configCursos.getNroMaxAlumnos());
	        pst.setInt(4, configCursos.getNroMinAlumnos());
	        pst.setInt(5,  configCursos.getCantidadClases());
	        pst.setBoolean(6, configCursos.getEstado());
	        pst.setInt(7, configCursos.getCodigo());
	        
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
	public ConfigCursos get(int codigo) throws BussinessException {
		Connection con = null;
	    PreparedStatement pst = null;
	    ResultSet rs = null;

	    try {
	    	Class.forName(JDBC_DRIVER);
	        con = DriverManager.getConnection(DB_URL,USER,PASS);
	        String query = ""
	        		+ " SELECT"
	        		+ "		codigo 			 AS cod,"
	        		+ " 	descripcion 	 AS des,"
	        		+ " 	minutos_de_clase AS min_clas,"
	        		+ "		nro_max_alumnos  AS max_alm,"
	        		+ "		nro_min_alumnos  AS min_alm,"
	        		+ " 	cantidad_clases  AS can_clas,"
	        		+ " 	estado 			 AS est"
	        		+ " FROM"
	        		+ " 	CONFIG_CURSOS "
	        		+ " WHERE"
	        		+ " 	codigo = ?";

	        pst = con.prepareStatement(query);
	        pst.setLong(1, codigo);
	        rs = pst.executeQuery();
	        
	        while (rs.next()) {
				ConfigCursos alumno = new ConfigCursos(
						rs.getInt("cod"), 
						rs.getString("des"),
						rs.getInt("min_clas"), 
						rs.getInt("max_alm"),
						rs.getInt("min_alm"), 
						rs.getInt("can_clas"), 
						rs.getBoolean("est"));
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
	public boolean delete(int codigo) throws BussinessException {
		Connection con = null;
	    PreparedStatement pst = null;
		try {
			Class.forName(JDBC_DRIVER);
	        con = DriverManager.getConnection(DB_URL,USER,PASS);
	        String query = ""
	        		+ " DELETE FROM CONFIG_CURSOS WHERE codigo = ?";
			
	        pst = con.prepareStatement(query);
	        pst.setLong(1, codigo);
	        
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
	public List<ConfigCursos> findAll() throws BussinessException {
		Connection con = null;
	    PreparedStatement pst = null;
	    ResultSet rs = null;

	    try {
	    	Class.forName(JDBC_DRIVER);
	        con = DriverManager.getConnection(DB_URL,USER,PASS);
	        ArrayList<ConfigCursos> listaAlumnos = new ArrayList<>();
	        String query = ""
	        		+ " SELECT"
	        		+ "		codigo 			 AS cod,"
	        		+ " 	descripcion 	 AS des,"
	        		+ " 	minutos_de_clase AS min_clas,"
	        		+ "		nro_max_alumnos  AS max_alm,"
	        		+ "		nro_min_alumnos  AS min_alm,"
	        		+ " 	cantidad_clases  AS can_clas,"
	        		+ " 	estado 			 AS est"
	        		+ " FROM"
	        		+ " 	CONFIG_CURSOS ";
	        
	        pst = con.prepareStatement(query);
	        rs = pst.executeQuery();
	        
	        while (rs.next()) {
	        	listaAlumnos.add(new ConfigCursos(
						rs.getInt("cod"), 
						rs.getString("des"),
						rs.getInt("min_clas"), 
						rs.getInt("max_alm"),
						rs.getInt("min_alm"), 
						rs.getInt("can_clas"), 
						rs.getBoolean("est")));
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