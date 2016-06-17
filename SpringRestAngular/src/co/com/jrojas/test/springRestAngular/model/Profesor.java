package co.com.jrojas.test.springRestAngular.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Profesor {

	private Long identificacion;
	private String nombre;
	private String apellidoPrimero;
	private String apellidoSegundo;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date fechaNacimiento;
	private Long tipoIdentificacion;

	public Profesor() {
	}
	
	public Profesor(Long identificacion, String nombre, String apellidoPrimero, String apellidoSegundo,
			Date fechaNacimiento, Long tipoIdentificacion) {
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.apellidoPrimero = apellidoPrimero;
		this.apellidoSegundo = apellidoSegundo;
		this.fechaNacimiento = fechaNacimiento;
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public Long getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(Long identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPrimero() {
		return apellidoPrimero;
	}

	public void setApellidoPrimero(String apellidoPrimero) {
		this.apellidoPrimero = apellidoPrimero;
	}

	public String getApellidoSegundo() {
		return apellidoSegundo;
	}

	public void setApellidoSegundo(String apellidoSegundo) {
		this.apellidoSegundo = apellidoSegundo;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Long getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(Long tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}
}
