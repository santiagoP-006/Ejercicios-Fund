package ejerciciosTienda;

import java.util.ArrayList;
import java.util.Scanner;

public class Tienda {
	private static ArrayList<Productos> listaProductos =new ArrayList();
	private static Scanner teclado =new Scanner (System.in);
	
	public static void main(String[] args) {
		
		Tipo tipo1 =new Tipo (true, 19);
		Fecha fecha1 =new Fecha (2025, 05, 10);
		Productos producto1 =new Productos(875, "Jamon", tipo1, fecha1);
	
		Tipo tipo2 =new Tipo (true, 19);
		Fecha fecha2 =new Fecha (2025, 05, 11);
		Productos producto2 =new Productos (785, "Queso", tipo2, fecha2);	
	
		Tipo tipo3 =new Tipo (false, 19);
		Productos producto3 = new Productos (7711, "Parlante", tipo3, null);
		
		listaProductos.add(producto1);
		listaProductos.add(producto2);
		listaProductos.add(producto3);
		
		buscar();
	}
	
	public static void buscar () {
		
		System.out.print("Entre el codigo del producto: ");
		int codigo = teclado.nextInt();
		
		for (Productos productos : listaProductos) {
			if (productos.getCodigo() == codigo ) {
				System.out.println("Datos producto: "+ productos);
			}
		
		}
		
	}
	
}
