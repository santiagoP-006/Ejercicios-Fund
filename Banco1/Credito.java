package Banco1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Credito extends Cuenta implements IDepositar {
    private double cupo;
    private String fechaUltimaCompra;
    private double valorUltimaCompra;

    public Credito(String numeroProducto, int añoApertura, Titular titular, double cupo) {
        super(numeroProducto, añoApertura, 0.0, titular);
        if (cupo <= 0) {
            this.cupo = 1;
        } else {
            this.cupo = cupo;
        }
        this.fechaUltimaCompra = "N/A";
        this.valorUltimaCompra = 0.0;
    }

    public double getCupo() { return cupo; }
    public String getFechaUltimaCompra() { return fechaUltimaCompra; }
    public double getValorUltimaCompra() { return valorUltimaCompra; }
    public double getCupoDisponible() { return this.cupo - getSaldo(); }

    @Override
    public String getTipoProducto() { return "Credito"; }

    @Override
    public void depositar(double monto) {
        if (monto <= 0) {
            System.out.println("Error Pago Credito: Monto debe ser positivo en tarjeta " + getNumeroProducto());
            return;
        }
        double deudaActual = getSaldo();
        if (monto >= deudaActual) {
             System.out.println("Pago OK: Cubriendo deuda total (" + deudaActual + ") con " + monto + " en tarjeta " + getNumeroProducto());
             setSaldo(0);
        } else {
             setSaldo(deudaActual - monto);
             System.out.println("Pago OK: Abono de " + monto + " en tarjeta " + getNumeroProducto() + ". Deuda restante: " + getSaldo());
        }
    }

    public void realizarCompra(double monto) {
         if (monto <= 0) {
            System.out.println("Error Compra Credito: Monto debe ser positivo en tarjeta " + getNumeroProducto());
            return;
         }
         double cupoDisp = getCupoDisponible();
         if (monto <= cupoDisp) {
             setSaldo(getSaldo() + monto);
             this.valorUltimaCompra = monto;
             this.fechaUltimaCompra = LocalDate.now().format(DateTimeFormatter.ISO_DATE);
             System.out.println("Compra OK: " + monto + " con tarjeta " + getNumeroProducto() + ". Deuda: " + getSaldo() + ". Cupo Disp: " + getCupoDisponible());
         } else {
             System.out.println("Error Compra Credito: Monto ("+ monto +") excede cupo disponible (" + cupoDisp + ") en tarjeta " + getNumeroProducto());
         }
    }

    @Override
    public void retirar(double monto) {
        System.out.println("Error Retiro Credito: Operacion 'retirar' no aplicable a Tarjeta " + getNumeroProducto() + ". Usar 'realizarCompra'.");
    }

    @Override
    public String toString() {
         return getTipoProducto() + " [Num=" + getNumeroProducto() + ", Deuda=" + getSaldo() + ", CupoDisp=" + getCupoDisponible() + ", Titular=" + titular.getNombre() + "]";
     }
}