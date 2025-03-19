package ejercicioClinica;

public class Medico {
	private int id;
	private String nombre;
	private Fecha fecha;
	private Disponibilidad disponible;
	
	public Medico(int id, String nombre, Fecha fecha, Disponibilidad disponible) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.disponible = disponible;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Fecha getFecha() {
		return fecha;
	}

	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}

	public Disponibilidad getDisponible() {
		return disponible;
	}

	public void setDisponible(Disponibilidad disponible) {
		this.disponible = disponible;
	}

	@Override
	public String toString() {
		return "Medico [id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + ", disponible=" + disponible + "]";
	}
	
}
