package co.com.jrojas.test.springRestAngular.model;

public class DatosClases {

	private Clase clase;
	private Alumno alumno;

	public DatosClases(Clase clase, Alumno alumno) {
		this.clase = clase;
		this.alumno = alumno;
	}
	
	public Clase getClase() {
		return clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
}