package co.com.jrojas.test.springRestAngular.model;

public class ConfigCursos {

	private Integer codigo;
	private String descripcion;
	private Integer minutosDeClase;
	private Integer nroMaxAlumnos;
	private Integer nroMinAlumnos;
	private Integer cantidadClases;
	private Boolean estado;

	public ConfigCursos() {
	}
	
	public ConfigCursos(Integer codigo, String descripcion, Integer minutosDeClase, Integer nroMaxAlumnos,
			Integer nroMinAlumnos, Integer cantidadClases, Boolean estado) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.minutosDeClase = minutosDeClase;
		this.nroMaxAlumnos = nroMaxAlumnos;
		this.nroMinAlumnos = nroMinAlumnos;
		this.cantidadClases = cantidadClases;
		this.estado = estado;
	}

	public ConfigCursos(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getMinutosDeClase() {
		return minutosDeClase;
	}

	public void setMinutosDeClase(Integer minutosDeClase) {
		this.minutosDeClase = minutosDeClase;
	}

	public Integer getNroMaxAlumnos() {
		return nroMaxAlumnos;
	}

	public void setNroMaxAlumnos(Integer nroMaxAlumnos) {
		this.nroMaxAlumnos = nroMaxAlumnos;
	}

	public Integer getNroMinAlumnos() {
		return nroMinAlumnos;
	}

	public void setNroMinAlumnos(Integer nroMinAlumnos) {
		this.nroMinAlumnos = nroMinAlumnos;
	}

	public Integer getCantidadClases() {
		return cantidadClases;
	}

	public void setCantidadClases(Integer cantidadClases) {
		this.cantidadClases = cantidadClases;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
}
