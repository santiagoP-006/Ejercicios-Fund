package ejerciciosTienda;

public class Tipo {
	private boolean tipo;
	private int iva;
	
	//constructor
	
	public Tipo(boolean tipo, int iva) {
		super();
		this.tipo = tipo;
		this.iva = iva;
	}

	public boolean isTipo() {
		return tipo;
	}

	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	@Override
	public String toString() {
		return "Perecedero: " + this.tipo + ", iva: " + this.iva;
	}
	
	
}
