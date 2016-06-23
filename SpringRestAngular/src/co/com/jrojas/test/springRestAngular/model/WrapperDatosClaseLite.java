package co.com.jrojas.test.springRestAngular.model;

import java.util.ArrayList;

public class WrapperDatosClaseLite {

	private int clase;
	private ArrayList<Long> alumnos;

	public int getClase() {
		return clase;
	}

	public void setClase(int clase) {
		this.clase = clase;
	}

	public ArrayList<Long> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Long> alumnos) {
		this.alumnos = alumnos;
	}
}