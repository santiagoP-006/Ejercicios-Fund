package Banco1;
	
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Corriente extends Cuenta implements IDepositar, IRetirar {
    private String fechaUltimoMovimiento;
    private double valorUltimoMovimiento;
    private String tipoOperacion;

    public Corriente(String numeroProducto, int añoApertura, double saldoInicial, Titular titular) {
        super(numeroProducto, añoApertura, saldoInicial, titular);
        this.fechaUltimoMovimiento = "N/A";
        this.valorUltimoMovimiento = 0.0;
        this.tipoOperacion = "N/A";
    }

    public String getFechaUltimoMovimiento() { return fechaUltimoMovimiento; }
    public double getValorUltimoMovimiento() { return valorUltimoMovimiento; }
    public String getTipoOperacion() { return tipoOperacion; }

    @Override
    public String getTipoProducto() { return "Corriente"; }

    private void actualizarUltimoMovimiento(String tipo, double valor) {
         this.fechaUltimoMovimiento = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
         this.valorUltimoMovimiento = valor;
         this.tipoOperacion = tipo;
         System.out.println(" -> Info Corriente actualizada.");
    }

    @Override
    public void depositar(double monto) {
        double saldoAntes = getSaldo();
        super.depositar(monto);
        if (getSaldo() > saldoAntes && monto > 0) {
             actualizarUltimoMovimiento("Deposito", monto);
        }
    }

    @Override
    public void retirar(double monto) {
        double saldoAntes = getSaldo();
        super.retirar(monto);
        if (getSaldo() < saldoAntes && monto > 0) {
             actualizarUltimoMovimiento("Retiro", monto);
        }
    }
}