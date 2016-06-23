package co.com.jrojas.test.springRestAngular.model;

public class DatosClases {

	private Integer codigo;
	private Clase clase;
	private Alumno alumno;

	public DatosClases(int codigo, Clase clase, Alumno alumno) {
		this.codigo = codigo;
		this.clase = clase;
		this.alumno = alumno;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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