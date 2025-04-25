package Banco1;


import java.util.ArrayList;
import java.util.List;

 
public class Financiera {

    private List<Cuenta> cuentas;
   
    public Financiera() {
        this.cuentas = new ArrayList<>();
    }

    private Cuenta buscarCuenta(String numeroProducto) {
        if (numeroProducto == null || numeroProducto.trim().isEmpty()) {
            return null; 
        }
        for (Cuenta c : cuentas) {
            
            if (c.getNumeroProducto() != null && c.getNumeroProducto().equalsIgnoreCase(numeroProducto)) {
                return c;
            }
        }
        return null; 
    }

    private boolean agregarNuevaCuenta(Cuenta nuevaCuenta) {
        
         if (nuevaCuenta == null || nuevaCuenta.getNumeroProducto() == null) {
             System.out.println("Error interno: Intento de agregar cuenta inválida o sin número.");
             return false;
         }

         this.cuentas.add(nuevaCuenta);
         System.out.println("Cuenta " + nuevaCuenta.getTipoProducto() + " creada: " + nuevaCuenta.getNumeroProducto());
         return true;
    }

 
    public boolean crearCuentaAhorro(String n, int a, double s, Titular t) {
        // Validación mínima del titular
        if (t == null) { System.out.println("Error Ahorro: Titular no puede ser null."); return false; }
        Ahorro cuenta = new Ahorro(n, a, s, t);
        return agregarNuevaCuenta(cuenta);
    }

  
    public boolean crearCuentaCorriente(String n, int a, double s, Titular t) {
        if (t == null) { System.out.println("Error Corriente: Titular no puede ser null."); return false; }
        Corriente cuenta = new Corriente(n, a, s, t);
        return agregarNuevaCuenta(cuenta);
    }

  
    public boolean crearCuentaVivienda(String n, int a, double s, Titular t, double p, String tipo) {
      
        if (t == null) { System.out.println("Error Vivienda: Titular no puede ser null."); return false; }
        if (p <= 0) { System.out.println("Error Vivienda: Precio vivienda debe ser > 0."); return false; }
        if (tipo == null || tipo.trim().isEmpty()) { System.out.println("Error Vivienda: Tipo vivienda requerido."); return false; }

        Vivienda cuenta = new Vivienda(n, a, s, t, p, tipo);
        return agregarNuevaCuenta(cuenta);
    }

    public boolean crearCuentaCredito(String n, int a, Titular t, double cupo) {
        if (t == null) { System.out.println("Error Credito: Titular no puede ser null."); return false; }
        if (cupo <= 0) { System.out.println("Error Credito: Cupo debe ser > 0."); return false; }

        Credito cuenta = new Credito(n, a, t, cupo);
        return agregarNuevaCuenta(cuenta);
    }

    public void realizarDeposito(String numeroProducto, double monto) {
        Cuenta cuenta = buscarCuenta(numeroProducto);
        if (cuenta == null) {
             System.out.println("Error Operacion: Cuenta " + numeroProducto + " NO ENCONTRADA para depósito.");
             return;
        }
      
        System.out.print("Operacion Deposito en " + numeroProducto + ": "); 
        cuenta.depositar(monto);
    }

  
    public void realizarRetiro(String numeroProducto, double monto) {
        Cuenta cuenta = buscarCuenta(numeroProducto);
        if (cuenta == null) {
             System.out.println("Error Operacion: Cuenta " + numeroProducto + " NO ENCONTRADA para retiro.");
             return; 
        }
    
        System.out.print("Operacion Retiro en " + numeroProducto + ": "); 
        cuenta.retirar(monto);
    }

     public void realizarCompraCredito(String numeroProducto, double monto) {
         Cuenta cuenta = buscarCuenta(numeroProducto);
         if (cuenta == null) {
              System.out.println("Error Operacion: Tarjeta " + numeroProducto + " NO ENCONTRADA.");
              return; 
         }

    
         if (cuenta instanceof Credito) {
             Credito tarjeta = (Credito) cuenta;
             System.out.print("Operacion Compra con " + numeroProducto + ": "); // Mensaje previo
             tarjeta.realizarCompra(monto); // Llama al método específico (void)
         } else {
             
             System.out.println("Error Operacion: Cuenta " + numeroProducto + " encontrada, pero NO es una Tarjeta de Crédito.");
         }
     }

    public void mostrarTodasCuentas() {
        System.out.println("\n--- Reporte Todas las Cuentas (Simple) ---");
        if (this.cuentas.isEmpty()) {
            System.out.println("No hay cuentas registradas.");
            return;
        }

     
        System.out.println("Tipo - Numero - Año - Titular - Saldo/Deuda");
       

        // Imprimir Datos de cada cuenta
        for (Cuenta cuenta : this.cuentas) {
            System.out.print(cuenta.getTipoProducto());
            System.out.print(" - ");
            System.out.print(cuenta.getNumeroProducto());
            System.out.print(" - ");
            System.out.print(cuenta.getAñoApertura());
            System.out.print(" - ");
            System.out.print(cuenta.getTitular() != null ? cuenta.getTitular().getNombre() : "N/A");
            System.out.print(" - ");
            System.out.print(cuenta.getSaldo());
            System.out.println();
        }
        
    }


    public void mostrarCuentasAhorro() {
        System.out.println("Reporte Cuentas de Ahorro ");
        boolean found = false;

 
        for (Cuenta cuenta : this.cuentas) {
            if (cuenta instanceof Ahorro) {
                found = true;
                Ahorro ahorro = (Ahorro) cuenta; // Cast seguro

       
                String fechaRetiro = ahorro.getFechaUltimoRetiro() != null ? ahorro.getFechaUltimoRetiro() : "N/A";

               
                System.out.print(ahorro.getTipoProducto());
                System.out.print(" - ");
                System.out.print(ahorro.getNumeroProducto());
                System.out.print(" - ");
                System.out.print(ahorro.getTitular() != null ? ahorro.getTitular().getNombre() : "N/A");
                System.out.print(" - ");
                System.out.print(fechaRetiro);
                System.out.print(" - ");
                System.out.print(ahorro.getValorUltimoRetiro());
                System.out.print(" - ");
                System.out.print(ahorro.getSaldo());
                System.out.println(); 
            }
        }

        if (!found) {
            System.out.println("No se encontraron cuentas de Ahorro.");
        }
        
    }
}