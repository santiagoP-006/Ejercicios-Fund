package ejercicioClinica;

public class Fecha {
	private int dia;
	private int mes;
	private String hora;
	
	public Fecha(int dia, int mes, String hora) {
		super();
		this.dia = dia;
		this.mes = mes;
		this.hora = hora;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	@Override
	public String toString() {
		return "Fecha [dia=" + dia + ", mes=" + mes + ", hora=" + hora + "]";
	}
	
	
	
}
