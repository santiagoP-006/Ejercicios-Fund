package Banco1;

public class mani {

    public static void main(String[] args) {

        System.out.println("=== Iniciando Simulación Bancaria ===");

        // 1. Crear la instancia de la Financiera
        Financiera miBanco = new Financiera();

        // 2. Crear Titulares
        System.out.println("\n--- Creando Titulares ---");
        Titular titular1 = new Titular("1001", "Ana García", "ana.garcia@email.com");
        Titular titular2 = new Titular("1002", "Luis Martínez", "luis.martinez@email.com");
        Titular titular3 = new Titular("1003", "Sofía Rodríguez", "sofia.r@email.com");
        System.out.println("Titulares creados: " + titular1.getNombre() + ", " + titular2.getNombre() + ", " + titular3.getNombre());

        // 3. Crear Cuentas de diferentes tipos
        System.out.println("\n--- Creando Cuentas ---");
        miBanco.crearCuentaAhorro("AH-001", 2022, 500.0, titular1);
        miBanco.crearCuentaCorriente("CC-001", 2023, 1200.0, titular2);
        miBanco.crearCuentaCredito("TC-001", 2021, titular1, 2500.0); 
        miBanco.crearCuentaVivienda("VV-001", 2024, 10000.0, titular3, 150000.0, "Apartamento");
        miBanco.crearCuentaAhorro("AH-002", 2024, 150.0, titular3);  

        // 4. Mostrar estado inicial de las cuentas
        System.out.println("Estado Inicial de las Cuentas: ");
        miBanco.mostrarTodasCuentas();

        // 5. Realizar Operaciones
        System.out.println("\n--- Realizando Operaciones ---");

        // Depósitos
        System.out.println("\n* Depósitos:");
        miBanco.realizarDeposito("AH-001", 250.50); 
        miBanco.realizarDeposito("CC-001", 300.00); 
        miBanco.realizarDeposito("VV-001", 5000.00); 
        miBanco.realizarDeposito("TC-001", 100.00); 
        miBanco.realizarDeposito("AH-001", -50.00);
        miBanco.realizarDeposito("XX-999", 100.00); 

        // Retiros
        System.out.println("\n* Retiros:");
        miBanco.realizarRetiro("AH-001", 100.00); 
        miBanco.realizarRetiro("CC-001", 2000.00); 
        miBanco.realizarRetiro("CC-001", 500.00); 
        miBanco.realizarRetiro("VV-001", 50.00); 
        miBanco.realizarRetiro("TC-001", 50.00); 
        miBanco.realizarRetiro("XX-999", 100.00); 
        
        // Compras con Tarjeta de Crédito
        System.out.println("\n* Compras con Crédito:");
        miBanco.realizarCompraCredito("AB-001", 800.00); 
        miBanco.realizarCompraCredito("CD-001", 2000.00); 
        miBanco.realizarCompraCredito("AH-001", 50.00); 
        miBanco.realizarCompraCredito("XX-999", 100.00); 

        // 6. Mostrar estado final de las cuentas
        System.out.println("Estado Final de las Cuentas ---");
        miBanco.mostrarTodasCuentas();

        // 7. Mostrar reportes específicos
        System.out.println("\n--- Reportes Específicos ---");
        miBanco.mostrarCuentasAhorro(); 
        
 
    }
}