package ejerciciosTienda;

public class Productos {
	private int codigo;
	private String descripccion;
	private Tipo tipo;
	private Fecha fecha;
	
	//constructor
	
	public Productos(int codigo, String descripccion, Tipo tipo, Fecha fecha) {
		super();
		this.codigo = codigo;
		this.descripccion = descripccion;
		this.tipo = tipo;
		this.fecha = fecha;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripccion() {
		return descripccion;
	}

	public void setDescripccion(String descripccion) {
		this.descripccion = descripccion;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Fecha getFecha() {
		return fecha;
	}

	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Codigo:" + this.codigo + ", Descripccion: " + this.descripccion + ", Perecedero: " + this.tipo + ", Fecha vencimiento: " + this.fecha;
	}
	
	
	
}
