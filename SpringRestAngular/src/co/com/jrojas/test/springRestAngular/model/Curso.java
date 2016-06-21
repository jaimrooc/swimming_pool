package co.com.jrojas.test.springRestAngular.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Curso {

	private Integer codigo;
	private String nombre;
	private Integer anhio;
	private Integer numeroCurso;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date fechaInicio;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date fechaFin;
	private Boolean estado;
	private ConfigCursos configCursos;

	public Curso() {
	}

	public Curso(Integer codigo) {
		this.codigo = codigo;
	}

	public Curso(Integer codigo, String nombre, Integer anhio, Integer numeroCurso, Date fechaInicio, Date fechaFin,
			Boolean estado, ConfigCursos configCursos) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.anhio = anhio;
		this.numeroCurso = numeroCurso;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estado = estado;
		this.configCursos = configCursos;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getAnhio() {
		return anhio;
	}

	public void setAnhio(Integer anhio) {
		this.anhio = anhio;
	}

	public Integer getNumeroCurso() {
		return numeroCurso;
	}

	public void setNumeroCurso(Integer numeroCurso) {
		this.numeroCurso = numeroCurso;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public ConfigCursos getConfigCursos() {
		return configCursos;
	}

	public void setConfigCursos(ConfigCursos configCursos) {
		this.configCursos = configCursos;
	}
}