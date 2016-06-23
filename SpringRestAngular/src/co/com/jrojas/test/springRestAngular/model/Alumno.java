package co.com.jrojas.test.springRestAngular.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Alumno {

	private Long identificacion;
	private String nombre;
	private String apellidoPrimero;
	private String apellidoSegundo;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date fechaNacimiento;
	private Long tipoIdentificacion;

	public Alumno() {
	}
	
	public Alumno(Long identificacion, String nombre, String apellidoPrimero, String apellidoSegundo,
			Date fechaNacimiento, Long tipoIdentificacion) {
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.apellidoPrimero = apellidoPrimero;
		this.apellidoSegundo = apellidoSegundo;
		this.fechaNacimiento = fechaNacimiento;
		this.tipoIdentificacion = tipoIdentificacion;
	}
	
	public Alumno(Map mapa) {
		try {
			this.identificacion = Long.parseLong(mapa.get("identificacion").toString());
			this.nombre = mapa.get("nombre").toString();
			this.apellidoPrimero = mapa.get("apellidoPrimero").toString();
			this.apellidoSegundo = mapa.get("apellidoSegundo").toString();
			this.fechaNacimiento = new SimpleDateFormat("yyyy-MM-dd").parse(mapa.get("fechaNacimiento").toString());
			this.tipoIdentificacion = Long.parseLong(mapa.get("tipoIdentificacion").toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Alumno(Long identificacion) {
		this.identificacion = identificacion;
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
