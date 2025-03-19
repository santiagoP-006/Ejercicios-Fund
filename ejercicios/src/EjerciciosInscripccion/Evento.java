package EjerciciosInscripccion;

import java.util.ArrayList;

public class Evento {
	
	private static ArrayList<Estudiante> listaEstudiantes =new ArrayList();
	private static ArrayList<Proyecto> listaInscripciones = new ArrayList();
	
	public static void main(String[] args) {
		
		Codigo codigo1= new Codigo (123, 'z');
		Fecha fecha1= new Fecha (2006, 05, 8);
		Nombre nombre1= new Nombre ("Santiago", "Patino");
		Estudiante estudiante1= new Estudiante (codigo1, 10328, fecha1, nombre1);
		Proyecto proyecto1= new Proyecto("Pendulo: ", "Medir cuanto....");
		
		Codigo codigo2= new Codigo (121, 'c');
		Fecha fecha2= new Fecha (2006, 10, 15);
		Nombre nombre2= new Nombre ("Valentina", "Sepulveda");
		Estudiante estudiante2= new Estudiante (codigo2, 10222, fecha2, nombre2);
		Proyecto proyecto2= new Proyecto ("Balanza: ", "Determinar...");
		
		Codigo codigo3= new Codigo (666, 'd');
		Fecha fecha3= new Fecha (2006, 06, 1);
		Nombre nombre3= new Nombre ("Malu", "Barwick");
		Estudiante estudiante3= new Estudiante (codigo3, 10222, fecha3, nombre3);
		Proyecto proyecto3= new Proyecto ("Motor: ", "Demostrar...");
		
		listaEstudiantes.add(estudiante1);
		listaEstudiantes.add(estudiante2);
		listaEstudiantes.add(estudiante3);
		
		listaInscripciones.add(proyecto1);
		listaInscripciones.add(proyecto2);
		listaInscripciones.add(proyecto3);
		
		mostrar();

	}
	public static void mostrar() {
		
		System.out.println("Lista estudiantes y proyectos: ");
		
		for (Estudiante estudiante : listaEstudiantes) {
			System.out.println(estudiante);
		}
		for (Proyecto proyecto : listaInscripciones) {
			System.out.println (proyecto);
		}
	}
}
