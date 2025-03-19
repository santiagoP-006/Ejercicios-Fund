package EjerciciosInscripccion;

public class Estudiante {
	private Codigo codigo;
	private int id;
	private Fecha fecha;
	private Nombre nombre;
	
	public Estudiante(Codigo codigo, int id, Fecha fecha, Nombre nombre) {
		super();
		this.codigo = codigo;
		this.id = id;
		this.fecha = fecha;
		this.nombre = nombre;
	}

	public Codigo getCodigo() {
		return codigo;
	}

	public void setCodigo(Codigo codigo) {
		this.codigo = codigo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Fecha getFecha() {
		return fecha;
	}

	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}

	public Nombre getNombre() {
		return nombre;
	}

	public void setNombre(Nombre nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Estudiante: " + this.nombre +"/ F.Nacimiento: "+ this.fecha+ "/ identificacion: "+this.id+ " codigo: "+this.codigo;
	}
	
}
