package co.com.jrojas.test.springRestAngular.model;

public class TipoIdentificacion {

	private int codigo;
	private String descripcion;

	public TipoIdentificacion() {
	}

	public TipoIdentificacion(int codigo) {
		this.codigo = codigo;
	}
	
	public TipoIdentificacion(int codigo, String descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
