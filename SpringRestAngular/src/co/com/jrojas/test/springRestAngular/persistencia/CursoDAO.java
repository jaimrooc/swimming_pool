package co.com.jrojas.test.springRestAngular.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import co.com.jrojas.test.springRestAngular.model.ConfigCursos;
import co.com.jrojas.test.springRestAngular.model.Curso;
import co.com.jrojas.test.springRestAngular.model.exceptions.BussinessException;
import co.com.jrojas.test.springRestAngular.model.exceptions.BussinessMessage;
import co.com.jrojas.test.springRestAngular.persistencia.interfaces.CursoDAOInterface;

public class CursoDAO implements CursoDAOInterface {
	
	// JDBC driver name and database URL
   static final String JDBC_DRIVER = "org.postgresql.Driver";  
   static final String DB_URL = "jdbc:postgresql://localhost:5432/swimming_class";

   //  Database credentials
   static final String USER = "postgres";
   static final String PASS = "Admin123*";
	
	@Override
	public boolean insert(Curso curso) throws BussinessException {
		Connection con = null;
	    PreparedStatement pst = null;
		try {
			Class.forName(JDBC_DRIVER);
	        con = DriverManager.getConnection(DB_URL,USER,PASS);
	        String query = ""
	        		+ " INSERT INTO CURSOS ("
	        		+ " 	codigo			,"
	        		+ " 	nombre			,"
	        		+ "		anhio			,"
	        		+ "		numero_curso	,"
	        		+ " 	fecha_inicio	,"
	        		+ " 	fecha_fin		,"
	        		+ "		config_cursos	,"
	        		+ " 	estado			)"
	        		+ " VALUES"
	        		+ " 	(?,?,?,?,?,?,?,?)";
			
	        pst = con.prepareStatement(query);
	        pst.setInt(1, curso.getCodigo());
	        pst.setString(2, curso.getNombre());
	        pst.setLong(3, curso.getAnhio());
	        pst.setLong(4, curso.getNumeroCurso());
	        pst.setDate(5,  new java.sql.Date(curso.getFechaInicio().getTime()));
	        pst.setDate(6,  new java.sql.Date(curso.getFechaFin().getTime()));
	        pst.setInt(7,  curso.getConfigCursos().getCodigo());
	        pst.setBoolean(8, curso.getEstado() == null ? true : curso.getEstado());
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
	public boolean update(Curso curso) throws BussinessException {

		Connection con = null;
	    PreparedStatement pst = null;
		try {
			Class.forName(JDBC_DRIVER);
	        con = DriverManager.getConnection(DB_URL,USER,PASS);
	        String query = ""
	        		
	        		+ " UPDATE CURSOS SET "
	        		+ "		nombre			= ?,"
	        		+ "		anhio			= ?,"
	        		+ " 	numero_curso	= ?,"
	        		+ " 	fecha_inicio	= ?,"
	        		+ "		fecha_fin		= ?,"
	        		+ "		config_cursos	= ?,"
	        		+ "		estado			= ?"
	        		+ " WHERE "
	        		+ " 	codigo = ?";
			
	        pst = con.prepareStatement(query);

	        pst.setString(1, curso.getNombre());
	        pst.setLong(2, curso.getAnhio());
	        pst.setLong(3, curso.getNumeroCurso());
	        pst.setDate(4, new java.sql.Date(curso.getFechaInicio().getTime()));
	        pst.setDate(5, new java.sql.Date(curso.getFechaFin().getTime()));
	        pst.setInt(6, curso.getConfigCursos().getCodigo());
	        pst.setBoolean(7, curso.getEstado() == null ? true : curso.getEstado());
	        pst.setInt(8, curso.getCodigo());
	        
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
	public Curso get(int codigo) throws BussinessException {
		Connection con = null;
	    PreparedStatement pst = null;
	    ResultSet rs = null;

	    try {
	    	Class.forName(JDBC_DRIVER);
	        con = DriverManager.getConnection(DB_URL,USER,PASS);
	        String query = ""
	        		+ " SELECT"
	        		+ " 	cu.codigo			 AS cod,"
	        		+ " 	cu.nombre			 AS nom,"
	        		+ "		cu.anhio			 AS anhio,"
	        		+ "		cu.numero_curso	 	 AS num_cur,"
	        		+ " 	cu.fecha_inicio	 	 AS f_ini,"
	        		+ " 	cu.fecha_fin		 AS f_fin,"
	        		+ "		cu.config_cursos	 AS con_cur,"
	        		+ " 	cu.estado			 AS est,"
	        		+ "		cc.codigo			 AS cc_cod,"
	        		+ " 	cc.descripcion		 AS cc_desc,"
	        		+ "		cc.minutos_de_clase	 AS cc_m_d_c,"
	        		+ "		cc.nro_max_alumnos	 AS cc_max_al,"
	        		+ " 	cc.nro_min_alumnos	 AS cc_min_al,"
	        		+ " 	cc.cantidad_clases	 AS cc_cc,"
	        		+ "		cc.estado            AS cc_est"
	        		+ " FROM"
	        		+ " 	CURSOS cu "
	        		+ " INNER JOIN CONFIG_CURSOS cc ON"
	        		+ "		cc.codigo = cu.config_cursos"
	        		+ " WHERE"
	        		+ " 	cu.codigo = ?";

	        pst = con.prepareStatement(query);
	        pst.setLong(1, codigo);
	        rs = pst.executeQuery();
	        
	        while (rs.next()) {
				Curso curso = new Curso(
						codigo, 
						rs.getString("nom"), 
						rs.getInt("anhio"), 
						rs.getInt("num_cur"),
						rs.getDate("f_ini"), 
						rs.getDate("f_fin"),
						rs.getBoolean("est"), 
						new ConfigCursos(rs.getInt("cc_cod"), rs.getString("cc_desc"), rs.getInt("cc_m_d_c"), rs.getInt("cc_max_al"), rs.getInt("cc_min_al"), rs.getInt("cc_cc"), rs.getBoolean("est"))
						
						);
	        	return curso;
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
	        		+ " DELETE FROM CURSOS WHERE codigo = ?";
			
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
	public List<Curso> findAll() throws BussinessException {
		Connection con = null;
	    PreparedStatement pst = null;
	    ResultSet rs = null;

	    try {
	    	Class.forName(JDBC_DRIVER);
	        con = DriverManager.getConnection(DB_URL,USER,PASS);
	        ArrayList<Curso> listaCursos = new ArrayList<>();
	        String query = ""
	        		+ " SELECT"
	        		+ " 	cu.codigo			 AS cod,"
	        		+ " 	cu.nombre			 AS nom,"
	        		+ "		cu.anhio			 AS anhio,"
	        		+ "		cu.numero_curso	 	 AS num_cur,"
	        		+ " 	cu.fecha_inicio	 	 AS f_ini,"
	        		+ " 	cu.fecha_fin		 AS f_fin,"
	        		+ "		cu.config_cursos	 AS con_cur,"
	        		+ " 	cu.estado			 AS est,"
	        		+ "		cc.codigo			 AS cc_cod,"
	        		+ " 	cc.descripcion		 AS cc_desc,"
	        		+ "		cc.minutos_de_clase	 AS cc_m_d_c,"
	        		+ "		cc.nro_max_alumnos	 AS cc_max_al,"
	        		+ " 	cc.nro_min_alumnos	 AS cc_min_al,"
	        		+ " 	cc.cantidad_clases	 AS cc_cc,"
	        		+ "		cc.estado            AS cc_est"
	        		+ " FROM"
	        		+ " 	CURSOS cu "
	        		+ " INNER JOIN CONFIG_CURSOS cc ON"
	        		+ "		cc.codigo = cu.config_cursos";
	        
	        pst = con.prepareStatement(query);
	        rs = pst.executeQuery();
	        
	        while (rs.next()) {
	        	listaCursos.add(new Curso(
						rs.getInt("cod"), 
						rs.getString("nom"), 
						rs.getInt("anhio"), 
						rs.getInt("num_cur"),
						rs.getDate("f_ini"), 
						rs.getDate("f_fin"),
						rs.getBoolean("est"), 
						new ConfigCursos(rs.getInt("cc_cod"), rs.getString("cc_desc"), rs.getInt("cc_m_d_c"), rs.getInt("cc_max_al"), rs.getInt("cc_min_al"), rs.getInt("cc_cc"), rs.getBoolean("est"))));
            }
	        return listaCursos;
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