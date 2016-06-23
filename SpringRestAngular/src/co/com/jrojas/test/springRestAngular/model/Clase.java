package co.com.jrojas.test.springRestAngular.model;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import co.com.jrojas.test.springRestAngular.model.util.DiasSemana;

public class Clase {
	
	private Integer codigo;
	@JsonFormat(pattern = "HH:mm")
	private Date horaIni;
	@JsonFormat(pattern = "HH:mm")
	private Date horaFin;
	private Boolean estado;
	private Integer curso;
	private Long profesor;
	private Long profesorAux;
	private DiasSemana diasSemana;
	
	private ArrayList<DatosClases> alumnosDeClase;

	public Clase() {
	}
	
	public Clase(Integer codigo, String dia, Date horaIni, Date horaFin, Boolean estado, Integer curso, Long profesor,
			Long profesorAux) {
		super();
		this.codigo = codigo;
		if (this.diasSemana == null) {
			this.diasSemana = new DiasSemana();
		}
		this.diasSemana.setDBToEntity(dia);
		this.horaIni = horaIni;
		this.horaFin = horaFin;
		this.estado = estado;
		this.curso = curso;
		this.profesor = profesor;
		this.profesorAux = profesorAux;
	}



	public Clase(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getHoraIni() {
		return horaIni;
	}

	public void setHoraIni(Date horaIni) {
		this.horaIni = horaIni;
	}

	public Date getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Integer getCurso() {
		return curso;
	}

	public void setCurso(Integer curso) {
		this.curso = curso;
	}

	public Long getProfesor() {
		return profesor;
	}

	public void setProfesor(Long profesor) {
		this.profesor = profesor;
	}

	public Long getProfesorAux() {
		return profesorAux;
	}

	public void setProfesorAux(Long profesorAux) {
		this.profesorAux = profesorAux;
	}

	public DiasSemana getDiasSemana() {
		return diasSemana;
	}

	public void setDiasSemana(DiasSemana diasSemana) {
		this.diasSemana = diasSemana;
	}

	public ArrayList<DatosClases> getAlumnosDeClase() {
		return alumnosDeClase;
	}

	public void setAlumnosDeClase(ArrayList<DatosClases> alumnosDeClase) {
		this.alumnosDeClase = alumnosDeClase;
	}
}