package EjerciciosInscripccion;

public class Inscripcion {
	
	private Fecha fecha;
	private Programa programa;
	
	public Inscripcion(Fecha fecha, Programa programa) {
		super();
		this.fecha = fecha;
		this.programa = programa;
	}

	public Fecha getFecha() {
		return fecha;
	}

	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}

	public Programa getPrograma() {
		return programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}

	@Override
	public String toString() {
		return "Inscripcion: " + fecha + ", programa:" + programa ;
	}
	
}
