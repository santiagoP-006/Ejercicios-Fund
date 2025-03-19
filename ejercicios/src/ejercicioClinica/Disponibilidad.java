package ejercicioClinica;

import java.time.LocalDate;

public class Disponibilidad {
	private int mes;
	private int dia;
	private LocalDate hora;
	
	public Disponibilidad(int mes, int dia) {
		super();
		this.mes = mes;
		this.dia = dia;
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

	public LocalDate getHora() {
		return hora;
	}

	public void setHora(LocalDate hora) {
		this.hora = hora;
	}

	@Override
	public String toString() {
		return "Disponibilidad [mes=" + mes + ", dia=" + dia ;
	}
	
}
