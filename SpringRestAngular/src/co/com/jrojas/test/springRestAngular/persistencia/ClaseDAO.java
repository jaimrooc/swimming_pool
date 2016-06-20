package co.com.jrojas.test.springRestAngular.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import co.com.jrojas.test.springRestAngular.model.Clase;
import co.com.jrojas.test.springRestAngular.model.exceptions.BussinessException;
import co.com.jrojas.test.springRestAngular.model.exceptions.BussinessMessage;
import co.com.jrojas.test.springRestAngular.persistencia.interfaces.ClaseDAOInterface;

public class ClaseDAO implements ClaseDAOInterface {
	
	// JDBC driver name and database URL
   static final String JDBC_DRIVER = "org.postgresql.Driver";  
   static final String DB_URL = "jdbc:postgresql://localhost:5432/swimming_class";

   //  Database credentials
   static final String USER = "postgres";
   static final String PASS = "Admin123*";
	
	@Override
	public boolean insert(Clase clase) throws BussinessException {
		Connection con = null;
	    PreparedStatement pst = null;
		try {
			Class.forName(JDBC_DRIVER);
	        con = DriverManager.getConnection(DB_URL,USER,PASS);
	        String query = ""
	        		+ " INSERT INTO CLASES ("
	        		+ " 	codigo		,"
	        		+ " 	curso		,"
	        		+ "		profesor	,"
	        		+ "		profesor_aux,"
	        		+ " 	dia			,"
	        		+ " 	hora_ini	,"
	        		+ "		hora_fin	,"
	        		+ " 	estado		)"
	        		+ " VALUES"
	        		+ " 	(?,?,?,?,?,?,?,?)";
			
	        pst = con.prepareStatement(query);
	        pst.setInt(1, clase.getCodigo());
	        pst.setInt(2, clase.getCurso());
	        pst.setLong(3, clase.getProfesor());
	        pst.setLong(4, clase.getProfesorAux());
	        pst.setString(5, clase.getDia());
	        pst.setDate(6,  new java.sql.Date(clase.getHoraIni().getTime()));
	        pst.setDate(7, new java.sql.Date(clase.getHoraFin().getTime()));
	        pst.setBoolean(8, clase.getEstado() == null ? true : clase.getEstado());
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
	public boolean update(Clase clase) throws BussinessException {

		Connection con = null;
	    PreparedStatement pst = null;
		try {
			Class.forName(JDBC_DRIVER);
	        con = DriverManager.getConnection(DB_URL,USER,PASS);
	        String query = ""
	        		
	        		+ " UPDATE CLASES SET "
	        		+ " 	curso		= ?,"
	        		+ "		profesor	= ?,"
	        		+ "		profesor_aux= ?,"
	        		+ " 	dia			= ?,"
	        		+ " 	hora_ini	= ?,"
	        		+ "		hora_fin	= ?,"
	        		+ "		estado = ?"
	        		+ " WHERE "
	        		+ " 	codigo = ?";
			
	        pst = con.prepareStatement(query);

	        pst.setInt(1, clase.getCurso());
	        pst.setLong(2, clase.getProfesor());
	        pst.setLong(3, clase.getProfesorAux());
	        pst.setString(4, clase.getDia());
	        pst.setDate(5,  new java.sql.Date(clase.getHoraIni().getTime()));
	        pst.setDate(6, new java.sql.Date(clase.getHoraFin().getTime()));
	        pst.setBoolean(7, clase.getEstado() == null ? true : clase.getEstado());
	        pst.setInt(8, clase.getCodigo());
	        
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
	public Clase get(int codigo) throws BussinessException {
		Connection con = null;
	    PreparedStatement pst = null;
	    ResultSet rs = null;

	    try {
	    	Class.forName(JDBC_DRIVER);
	        con = DriverManager.getConnection(DB_URL,USER,PASS);
	        String query = ""
	        		+ " SELECT"
	        		+ " 	codigo		 AS cod,"
	        		+ " 	curso		 AS cur,"
	        		+ "		profesor	 AS prof,"
	        		+ "		profesor_aux AS prof_aux,"
	        		+ " 	dia			 AS dia,"
	        		+ " 	hora_ini	 AS hr_ini,"
	        		+ "		hora_fin	 AS hr_fin,"
	        		+ " 	estado		 AS est"
	        		+ " FROM"
	        		+ " 	CLASES "
	        		+ " WHERE"
	        		+ " 	codigo = ?";

	        pst = con.prepareStatement(query);
	        pst.setLong(1, codigo);
	        rs = pst.executeQuery();
	        
	        while (rs.next()) {
				Clase alumno = new Clase(
						codigo, 
						rs.getString("dia"), 
						rs.getDate("hr_ini"), 
						rs.getDate("hr_fin"),
						rs.getBoolean("est"),
						rs.getInt("cur"),
						rs.getLong("prof"), 
						rs.getLong("prof_aux"));
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
	        		+ " DELETE FROM CLASES WHERE codigo = ?";
			
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
	public List<Clase> findAll() throws BussinessException {
		Connection con = null;
	    PreparedStatement pst = null;
	    ResultSet rs = null;

	    try {
	    	Class.forName(JDBC_DRIVER);
	        con = DriverManager.getConnection(DB_URL,USER,PASS);
	        ArrayList<Clase> listaAlumnos = new ArrayList<>();
	        String query = ""
	        		+ " SELECT"
	        		+ " 	codigo		 AS cod,"
	        		+ " 	curso		 AS cur,"
	        		+ "		profesor	 AS prof,"
	        		+ "		profesor_aux AS prof_aux,"
	        		+ " 	dia			 AS dia,"
	        		+ " 	hora_ini	 AS hr_ini,"
	        		+ "		hora_fin	 AS hr_fin,"
	        		+ " 	estado		 AS est"
	        		+ " FROM"
	        		+ " 	CLASES ";
	        
	        pst = con.prepareStatement(query);
	        rs = pst.executeQuery();
	        
	        while (rs.next()) {
	        	listaAlumnos.add(new Clase(
						rs.getInt("cod"), 
						rs.getString("dia"), 
						rs.getDate("hr_ini"), 
						rs.getDate("hr_fin"),
						rs.getBoolean("est"),
						rs.getInt("cur"),
						rs.getLong("prof"), 
						rs.getLong("prof_aux")));
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