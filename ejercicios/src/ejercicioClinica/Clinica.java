package ejercicioClinica;

import java.util.ArrayList;
import java.util.Scanner;

public class Clinica {
	
	private static ArrayList<Cita> listaCitas =new ArrayList();
	private static Scanner teclado =new Scanner (System.in);
	
	public static void main(String[] args) {
		
		Fecha fecha1 = new Fecha (16, 03, "6:30 pm");
		Paciente paciente1 = new Paciente (13400, "Pedro Capo", "Cra 7#153", 3120888);
		Disponibilidad disponibilidad1= new Disponibilidad(03, 10);
		Medico medico1 = new Medico (001, "Patito Juan", fecha1, disponibilidad1);
		Registro registro1 = new Registro("Cabeza inflamada", "1 dolex ");
		Cita cita1 = new Cita (fecha1, paciente1, medico1, "Duele cabeza", registro1);
		
		Fecha fecha2= new Fecha (17, 04, "5:30 pm");
		Paciente paciente2= new Paciente (1450, "JuanCho", "Calle 74 #13-14", 3012244);
		Disponibilidad disponibilidad2 = new Disponibilidad (04, 10);
		Medico medico2 = new Medico (002, "Pulga aventurera", fecha2, disponibilidad2);
		Registro registro2= new Registro ("Barriga inflamada", "Aromatica");
		Cita cita2 = new Cita (fecha2, paciente2, medico2, "Barrga inflamada", registro2);
		
		listaCitas.add(cita1);
		listaCitas.add(cita2);
		
		buscar();
	}
	public static void buscar() {
		System.out.print("Entre el la identificacion: ");
		int codigo = teclado.nextInt();
		
		for (Cita cita : listaCitas) {
			if (cita.getPaciente().getId() == codigo) {
				System.out.println("Info: "+ cita);
			} else {
				System.out.println("Usuario no tiene citas");
			}
		}
	}
	
}
