package co.com.jrojas.test.springRestAngular.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import co.com.jrojas.test.springRestAngular.model.Alumno;
import co.com.jrojas.test.springRestAngular.model.Clase;
import co.com.jrojas.test.springRestAngular.model.DatosClases;
import co.com.jrojas.test.springRestAngular.model.WrapperDatosClaseLite;
import co.com.jrojas.test.springRestAngular.model.exceptions.BussinessException;
import co.com.jrojas.test.springRestAngular.model.exceptions.BussinessMessage;
import co.com.jrojas.test.springRestAngular.persistencia.interfaces.DatosClaseDAOInterface;

public class DatosClaseDAO implements DatosClaseDAOInterface {
	
	// JDBC driver name and database URL
   static final String JDBC_DRIVER = "org.postgresql.Driver";  
   static final String DB_URL = "jdbc:postgresql://localhost:5432/swimming_class";

   //  Database credentials
   static final String USER = "postgres";
   static final String PASS = "Admin123*";
	
   
   
   @Override
	public boolean insertarLista(WrapperDatosClaseLite clase) throws BussinessException {
		Connection con = null;
	    PreparedStatement pst = null;
		try {
			Class.forName(JDBC_DRIVER);
	        con = DriverManager.getConnection(DB_URL,USER,PASS);
	        String query = ""
	        		+ " INSERT INTO DATOS_CLASES ("
	        		+ " 	codigo,"
	        		+ " 	alumno,"
	        		+ "		clase)"
	        		+ " VALUES"
	        		+ " 	(?,?,?)";
			boolean insertoTodos = false;
			
			int codigo = 1;
	        for (Long identificacionAlumno : clase.getAlumnos()) {
				
		        pst = con.prepareStatement(query);
		        pst.setInt(1, codigo);
		        pst.setLong(2, identificacionAlumno);
		        pst.setInt(3, clase.getClase());
		        if (pst.executeUpdate() == 1) {
		        	insertoTodos = insertoTodos && true;
		        } else {
		        	insertoTodos = insertoTodos && false;
		        }
		        codigo++;
	        }
	        
	        
	        if (insertoTodos) {
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
	public boolean insert(DatosClases datosClases) throws BussinessException {
		Connection con = null;
	    PreparedStatement pst = null;
		try {
			Class.forName(JDBC_DRIVER);
	        con = DriverManager.getConnection(DB_URL,USER,PASS);
	        String query = ""
	        		+ " INSERT INTO DATOS_CLASES ("
	        		+ " 	codigo,"
	        		+ " 	alumno,"
	        		+ "		clase)"
	        		+ " VALUES"
	        		+ " 	(?,?,?)";
			
	        pst = con.prepareStatement(query);
	        pst.setInt(1, datosClases.getCodigo());
	        pst.setLong(2, datosClases.getAlumno().getIdentificacion());
	        pst.setInt(3, datosClases.getClase().getCodigo());
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
	public boolean update(DatosClases datosClase) throws BussinessException {

		Connection con = null;
	    PreparedStatement pst = null;
		try {
			Class.forName(JDBC_DRIVER);
	        con = DriverManager.getConnection(DB_URL,USER,PASS);
	        String query = ""
	        		+ " UPDATE DATOS_CLASES SET "
	        		+ " 	alumno = ?,"
	        		+ "		clase = ?"
	        		+ " WHERE "
	        		+ " 	codigo = ?";
			
	        pst = con.prepareStatement(query);

	        pst.setLong(1, datosClase.getAlumno().getIdentificacion());
	        pst.setInt(2, datosClase.getClase().getCodigo());
	        pst.setInt(3, datosClase.getCodigo());
	        
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
	public DatosClases get(int codigo) throws BussinessException {
		Connection con = null;
	    PreparedStatement pst = null;
	    ResultSet rs = null;

	    try {
	    	Class.forName(JDBC_DRIVER);
	        con = DriverManager.getConnection(DB_URL,USER,PASS);
	        String query = ""
	        		+ " SELECT"
	        		+ "		codigo 			 AS cod,"
	        		+ " 	alumno		 	 AS alu,"
	        		+ " 	clase			 AS cla"
	        		+ " FROM"
	        		+ " 	DATOS_CLASES "
	        		+ " WHERE"
	        		+ " 	codigo = ?";

	        pst = con.prepareStatement(query);
	        pst.setLong(1, codigo);
	        rs = pst.executeQuery();
	        
	        while (rs.next()) {
				DatosClases alumno = new DatosClases(
						rs.getInt("cod"),
						new Clase(rs.getInt("cla")),
						new Alumno(rs.getLong("alu")));
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
	        		+ " DELETE FROM DATOS_CLASES WHERE codigo = ?";
			
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
	public List<DatosClases> findAll() throws BussinessException {
		Connection con = null;
	    PreparedStatement pst = null;
	    ResultSet rs = null;

	    try {
	    	Class.forName(JDBC_DRIVER);
	        con = DriverManager.getConnection(DB_URL,USER,PASS);
	        ArrayList<DatosClases> listaAlumnos = new ArrayList<>();
	        String query = ""
	        		+ " SELECT"
	        		+ "		codigo 			 AS cod,"
	        		+ " 	alumno		 	 AS alu,"
	        		+ " 	clase			 AS cla"
	        		+ " FROM"
	        		+ " 	DATOS_CLASES ";
	        
	        pst = con.prepareStatement(query);
	        rs = pst.executeQuery();
	        
	        while (rs.next()) {
	        	listaAlumnos.add(new DatosClases(
						rs.getInt("cod"),
						new Clase(rs.getInt("cla")),
						new Alumno(rs.getLong("alu"))));
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