package ejerciciosTienda;

import java.util.ArrayList;
import java.util.Scanner;

public class Tienda {
	private static ArrayList<Productos> listaProductos =new ArrayList();
	private static Scanner teclado =new Scanner (System.in);
	
	public static void main(String[] args) {
		
		Tipo tipo1 =new Tipo (true, 19);
		Fecha fecha1 =new Fecha (2025, 05, 10);
		Productos producto1 =new Productos(875, "Jamon", tipo1, fecha1, 15000, 19, 01);
	
		Tipo tipo2 =new Tipo (true, 19);
		Fecha fecha2 =new Fecha (2025, 05, 11);
		Productos producto2 =new Productos (785, "Queso", tipo2, fecha2, 11000, 19, 03);	
	
		Tipo tipo3 =new Tipo (false, 19);
		Productos producto3 = new Productos (7711, "Parlante", tipo3, null, 180000, 10, 10);
		
		listaProductos.add(producto1);
		listaProductos.add(producto2);
		listaProductos.add(producto3);
		
		buscarProducto();
	}
	
	public static void buscarProducto() {
	    System.out.print("Entre el codigo del producto: ");
	    int codigo = teclado.nextInt();
	    
	    boolean encontrado = false;
	    
	    for (Productos productos : listaProductos) {
	        if (productos.getCodigo() == codigo) {
	            encontrado = true;
	            System.out.println("Datos producto: " + productos);
	            if (productos.getTipo().isPerecedero()) {
	                System.out.println("Es perecedero");
	            } else {
	                System.out.println("No es perecedero");
	            }
	        }
	    }
	    
	    if (!encontrado) {
	        System.out.println("Producto no encontrado");
	    }
	}
	
}
