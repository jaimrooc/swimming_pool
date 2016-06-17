package co.com.jrojas.test.springRestAngular.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import co.com.jrojas.test.springRestAngular.model.Profesor;
import co.com.jrojas.test.springRestAngular.persistencia.interfaces.ProfesorDAOInterface;

public class ProfesorDAO implements ProfesorDAOInterface {
	
	// JDBC driver name and database URL
   static final String JDBC_DRIVER = "org.postgresql.Driver";  
   static final String DB_URL = "jdbc:postgresql://localhost:5432/swimming_class";

   //  Database credentials
   static final String USER = "postgres";
   static final String PASS = "Admin123*";
	
	@Override
	public boolean insert(Profesor profesor) {
		Connection con = null;
	    PreparedStatement pst = null;
		try {
			Class.forName(JDBC_DRIVER);
	        con = DriverManager.getConnection(DB_URL,USER,PASS);
	        String query = ""
	        		+ " INSERT INTO PROFESORES ("
	        		+ " 	identificacion,"
	        		+ " 	tipo_identificacion,"
	        		+ "		nombre,"
	        		+ "		apellido_primero,"
	        		+ " 	apellido_segundo,"
	        		+ " 	fecha_nacimiento)"
	        		+ " VALUES"
	        		+ " 	(?,?,?,?,?,?)";
			
	        pst = con.prepareStatement(query);
	        pst.setLong(1, profesor.getIdentificacion());
	        pst.setLong(2, profesor.getTipoIdentificacion() == null ? 1 : profesor.getTipoIdentificacion());
	        pst.setString(3, profesor.getNombre());
	        pst.setString(4, profesor.getApellidoPrimero());
	        pst.setString(5, profesor.getApellidoSegundo());
	        pst.setDate(6,  new java.sql.Date(profesor.getFechaNacimiento().getTime()));
	        if (pst.executeUpdate() == 1) {
	        	return true;
	        } else {
	        	return false;
	        }
	        
		} catch (Exception e) {
			e.printStackTrace();
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
		return false;
	}

	@Override
	public boolean update(Profesor profesor) {

		Connection con = null;
	    PreparedStatement pst = null;
		try {
			Class.forName(JDBC_DRIVER);
	        con = DriverManager.getConnection(DB_URL,USER,PASS);
	        String query = ""
	        		+ " UPDATE PROFESORES SET "
	        		+ " 	tipo_identificacion = ?, "
	        		+ "		nombre = ?,"
	        		+ "		apellido_primero = ?,"
	        		+ " 	apellido_segundo = ?,"
	        		+ " 	fecha_nacimiento  = ?"
	        		+ " WHERE "
	        		+ " 	identificacion = ?";
			
	        pst = con.prepareStatement(query);

	        pst.setLong(1, profesor.getTipoIdentificacion() == null ? 1 : profesor.getTipoIdentificacion());
	        pst.setString(2, profesor.getNombre());
	        pst.setString(3, profesor.getApellidoPrimero());
	        pst.setString(4, profesor.getApellidoSegundo());
	        pst.setDate(5,  new java.sql.Date(profesor.getFechaNacimiento().getTime()));
	        pst.setLong(6, profesor.getIdentificacion());
	        
	        if (pst.executeUpdate() == 1) {
	        	return true;
	        } else {
	        	return false;
	        }
	        
		} catch (Exception e) {
			e.printStackTrace();
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
		return false;
	
	}

	@Override
	public Profesor get(Long identificacion) {
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
	        		+ " 	PROFESORES "
	        		+ " WHERE"
	        		+ " 	identificacion = ?";

	        pst = con.prepareStatement(query);
	        pst.setLong(1, identificacion);
	        rs = pst.executeQuery();
	        
	        while (rs.next()) {
	        	Profesor profesor = new Profesor(
	        			identificacion, 
	        			rs.getString("nombre"), 
	        			rs.getString("ape_p"), 
	        			rs.getString("ape_s"),
	        			rs.getDate("fecha_nac"), 
	        			rs.getLong("tip_id"));
	        	return profesor;
            }
	    } catch (Exception ex) {
	        System.out.println(ex);
	        return null;
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
	public boolean delete(Long identificacion) {
		Connection con = null;
	    PreparedStatement pst = null;
		try {
			Class.forName(JDBC_DRIVER);
	        con = DriverManager.getConnection(DB_URL,USER,PASS);
	        String query = ""
	        		+ " DELETE FROM PROFESORES WHERE identificacion = ?";
			
	        pst = con.prepareStatement(query);

	        pst.setLong(1, identificacion);
	        
	        if (pst.executeUpdate() == 1) {
	        	return true;
	        } else {
	        	return false;
	        }
	        
		} catch (Exception e) {
			e.printStackTrace();
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
		return false;
	}

	@Override
	public List<Profesor> findAll() {
		Connection con = null;
	    PreparedStatement pst = null;
	    ResultSet rs = null;

	    try {
	    	Class.forName(JDBC_DRIVER);
	        con = DriverManager.getConnection(DB_URL,USER,PASS);
	        ArrayList<Profesor> listaProfesors = new ArrayList<>();	    	
	        String query = ""
	        		+ " SELECT"
	        		+ " 	identificacion AS id,"
	        		+ " 	tipo_identificacion AS tip_id,"
	        		+ "		nombre AS nombre,"
	        		+ "		apellido_primero AS ape_p,"
	        		+ " 	apellido_segundo AS ape_s,"
	        		+ " 	fecha_nacimiento AS fecha_nac"
	        		+ " FROM"
	        		+ " 	PROFESORES ";
	        
	        pst = con.prepareStatement(query);
	        rs = pst.executeQuery();
	        
	        while (rs.next()) {
	        	listaProfesors.add(new Profesor(
	        			rs.getLong("id"), 
	        			rs.getString("nombre"), 
	        			rs.getString("ape_p"), 
	        			rs.getString("ape_s"),
	        			rs.getDate("fecha_nac"), 
	        			rs.getLong("tip_id")));
            }
	        return listaProfesors;
	    } catch (Exception ex) {
	        System.out.println(ex);
	        return null;
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