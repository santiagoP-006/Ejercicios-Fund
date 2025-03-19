package ejerciciosTienda;

public class Fecha {
	private int anio;
	private int mes;
	private int dia;
	
	//constructor
	
	public Fecha(int anio, int mes, int dia) {
		super();
		this.anio = anio;
		this.mes = mes;
		this.dia = dia;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	@Override
	public String toString() {
		return this.dia + "/" + this.mes + "/" + this.anio;
	}

}
