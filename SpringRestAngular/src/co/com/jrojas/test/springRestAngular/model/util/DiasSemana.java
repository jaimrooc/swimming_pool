package co.com.jrojas.test.springRestAngular.model.util;

public class DiasSemana {
	
	private boolean lunes;
	private boolean martes;
	private boolean miercoles;
	private boolean jueves;
	private boolean viernes;
	private boolean sabado;
	private boolean domingo;

	public boolean isLunes() {
		return lunes;
	}

	public void setLunes(boolean lunes) {
		this.lunes = lunes;
	}

	public boolean isMartes() {
		return martes;
	}

	public void setMartes(boolean martes) {
		this.martes = martes;
	}

	public boolean isMiercoles() {
		return miercoles;
	}

	public void setMiercoles(boolean miercoles) {
		this.miercoles = miercoles;
	}

	public boolean isJueves() {
		return jueves;
	}

	public void setJueves(boolean jueves) {
		this.jueves = jueves;
	}

	public boolean isViernes() {
		return viernes;
	}

	public void setViernes(boolean viernes) {
		this.viernes = viernes;
	}

	public boolean isSabado() {
		return sabado;
	}

	public void setSabado(boolean sabado) {
		this.sabado = sabado;
	}

	public boolean isDomingo() {
		return domingo;
	}

	public void setDomingo(boolean domingo) {
		this.domingo = domingo;
	}
	
	public String entityToDB() {
		String diasSemana = "";
		
		if (lunes) {
			diasSemana += Constants.STRING_LUNES;
		} if (martes) {
			if (!diasSemana.isEmpty()) {
				diasSemana += Constants.SEPARADOR;
			}
			diasSemana += Constants.STRING_MARTES;
		} if (miercoles) {
			if (!diasSemana.isEmpty()) {
				diasSemana += Constants.SEPARADOR;
			}
			diasSemana += Constants.STRING_MIERCOLES;
		} if (jueves) {
			if (!diasSemana.isEmpty()) {
				diasSemana += Constants.SEPARADOR;
			}
			diasSemana += Constants.STRING_JUEVES;
		} if (viernes) {
			if (!diasSemana.isEmpty()) {
				diasSemana += Constants.SEPARADOR;
			}
			diasSemana += Constants.STRING_VIERNES;
		} if (sabado) {
			if (!diasSemana.isEmpty()) {
				diasSemana += Constants.SEPARADOR;
			}
			diasSemana += Constants.STRING_SABADO;
		} if (domingo) {
			if (!diasSemana.isEmpty()) {
				diasSemana += Constants.SEPARADOR;
			}
			diasSemana += Constants.STRING_DOMINGO;
		}
		return diasSemana;
	}
	
	public void setDBToEntity(String dias) {
		for (String dia : dias.split(Constants.SEPARADOR)) {
			if (dia.equals(Constants.STRING_LUNES)) {
				this.lunes = true;
			} else if (dia.equals(Constants.STRING_MARTES)) {
				this.martes = true;
			} else if (dia.equals(Constants.STRING_MIERCOLES)) {
				this.miercoles = true;
			} else if (dia.equals(Constants.STRING_JUEVES)) {
				this.jueves = true;
			} else if (dia.equals(Constants.STRING_VIERNES)) {
				this.viernes = true;
			} else if (dia.equals(Constants.STRING_SABADO)) {
				this.sabado = true;
			} else if (dia.equals(Constants.STRING_DOMINGO)) {
				this.domingo = true;
			}
		}
	}
}