package ejerciciosTienda;

public class Productos {
	private int codigo;
	private String descripccion;
	private Tipo tipo;
	private Fecha fecha;
	private int precio;
	private int porcentajeIva;
	private int cantidad;
	//constructor
	public Productos(int codigo, String descripccion, Tipo tipo, Fecha fecha, int precio, int porcentajeIva, int cantidad) {
		super();
		this.codigo = codigo;
		this.descripccion = descripccion;
		this.tipo = tipo;
		this.fecha = fecha;
		this.precio = precio;
		this.porcentajeIva = porcentajeIva;
		this.cantidad = cantidad;
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
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public double getPorcentajeIva() {
		return porcentajeIva;
	}
	public void setPorcentajeIva(int porcentajeIva) {
		this.porcentajeIva = porcentajeIva;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
	precio = precio + (precio*porcentajeIva/100);		
		return "codigo: " + codigo + ", descripccion:" + descripccion + ", tipo:" + tipo + ", fecha:" + fecha + ", precio:" + precio + ", porcentaje Iva:" + porcentajeIva + ", cantidad: " + cantidad;
	}
	
}
