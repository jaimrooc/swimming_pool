package co.com.jrojas.test.springRestAngular.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import co.com.jrojas.test.springRestAngular.model.TipoIdentificacion;
import co.com.jrojas.test.springRestAngular.persistencia.interfaces.TiposIdentificacionDAOInterface;

public class TiposIdentificacionDAO implements TiposIdentificacionDAOInterface {
	
	// JDBC driver name and database URL
   static final String JDBC_DRIVER = "org.postgresql.Driver";  
   static final String DB_URL = "jdbc:postgresql://localhost:5432/swimming_class";

   //  Database credentials
   static final String USER = "postgres";
   static final String PASS = "Admin123*";
	
	@Override
	public boolean insert(TipoIdentificacion tipoIdentificacion) {
		Connection con = null;
	    PreparedStatement pst = null;
		try {
			Class.forName(JDBC_DRIVER);
	        con = DriverManager.getConnection(DB_URL,USER,PASS);
	        String query = ""
	        		+ " INSERT INTO TIPOS_IDENTIFICACION ("
	        		+ " 	codigo,"
	        		+ " 	descripcion)"
	        		+ " VALUES"
	        		+ " 	(?,?)";
			
	        pst = con.prepareStatement(query);
	        pst.setLong(1, tipoIdentificacion.getCodigo());
	        pst.setString(2, tipoIdentificacion.getDescripcion());
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
	public boolean update(TipoIdentificacion tipoIdentificacion) {
		Connection con = null;
	    PreparedStatement pst = null;
		try {
			Class.forName(JDBC_DRIVER);
	        con = DriverManager.getConnection(DB_URL,USER,PASS);
	        String query = ""
	        		+ " UPDATE TIPOS_IDENTIFICACION SET "
	        		+ " 	descripcion = ?"
	        		+ " WHERE "
	        		+ " 	codigo = ?";
			
	        pst = con.prepareStatement(query);

	        pst.setString(1, tipoIdentificacion.getDescripcion());
	        pst.setInt(2, tipoIdentificacion.getCodigo());
	        
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
	public TipoIdentificacion get(int identificacion) {
		Connection con = null;
	    PreparedStatement pst = null;
	    ResultSet rs = null;

	    try {
	    	Class.forName(JDBC_DRIVER);
	        con = DriverManager.getConnection(DB_URL,USER,PASS);
	        String query = ""
	        		+ " SELECT"
	        		+ " 	descripcion AS desc"
	        		+ " FROM"
	        		+ " 	TIPOS_IDENTIFICACION "
	        		+ " WHERE"
	        		+ " 	codigo = ?";

	        pst = con.prepareStatement(query);
	        pst.setLong(1, identificacion);
	        rs = pst.executeQuery();
	        
	        while (rs.next()) {
	        	TipoIdentificacion tipoIdentificacion = new TipoIdentificacion(
	        			identificacion, 
	        			rs.getString("desc"));
	        	return tipoIdentificacion;
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
	public boolean delete(int idSeguroMedico) {
		Connection con = null;
	    PreparedStatement pst = null;
		try {
			Class.forName(JDBC_DRIVER);
	        con = DriverManager.getConnection(DB_URL,USER,PASS);
	        String query = ""
	        		+ " DELETE FROM TIPOS_IDENTIFICACION WHERE codigo = ?";
			
	        pst = con.prepareStatement(query);

	        pst.setLong(1, idSeguroMedico);
	        
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
	public List<TipoIdentificacion> findAll() {
		Connection con = null;
	    PreparedStatement pst = null;
	    ResultSet rs = null;

	    try {
	    	Class.forName(JDBC_DRIVER);
	        con = DriverManager.getConnection(DB_URL,USER,PASS);
	        ArrayList<TipoIdentificacion> listaTipoIdentificacion = new ArrayList<>();	    	
	        String query = ""
	        		+ " SELECT"
	        		+ " 	codigo AS codigo,"
	        		+ " 	descripcion AS desc"
	        		+ " FROM"
	        		+ " 	TIPOS_IDENTIFICACION ";
	        
	        pst = con.prepareStatement(query);
	        rs = pst.executeQuery();
	        
	        while (rs.next()) {
	        	listaTipoIdentificacion.add(new TipoIdentificacion(
	        			rs.getInt("codigo"), 
	        			rs.getString("desc")));
            }
	        return listaTipoIdentificacion;
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