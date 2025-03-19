package EjerciciosInscripccion;

public class Programa {
	private int codProg;
	private int nombreProg;
	
	public Programa(int codProg, int nombreProg) {
		super();
		this.codProg = codProg;
		this.nombreProg = nombreProg;
	}

	public int getCodProg() {
		return codProg;
	}

	public void setCodProg(int codProg) {
		this.codProg = codProg;
	}

	public int getNombreProg() {
		return nombreProg;
	}

	public void setNombreProg(int nombreProg) {
		this.nombreProg = nombreProg;
	}

	@Override
	public String toString() {
		return "Programa: " + codProg + " " + nombreProg;
	}

}
