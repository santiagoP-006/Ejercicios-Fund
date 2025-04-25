package Banco1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ahorro extends Cuenta implements IDepositar, IRetirar {
    private String fechaUltimoRetiro;
    private double valorUltimoRetiro;

    public Ahorro(String numeroProducto, int añoApertura, double saldoInicial, Titular titular) {
        super(numeroProducto, añoApertura, saldoInicial, titular);
        this.fechaUltimoRetiro = "N/A";
        this.valorUltimoRetiro = 0.0;
    }

    public String getFechaUltimoRetiro() { return fechaUltimoRetiro; }
    public double getValorUltimoRetiro() { return valorUltimoRetiro; }

    @Override
    public String getTipoProducto() { return "Ahorro"; }

    @Override
    public void retirar(double monto) {
        double saldoAntes = getSaldo();
        super.retirar(monto);
        if (getSaldo() < saldoAntes && monto > 0) {
            this.valorUltimoRetiro = monto;
            this.fechaUltimoRetiro = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);
            System.out.println(" -> Info Ahorro actualizada.");
        }
    }

    @Override
    public void depositar(double monto) {
        super.depositar(monto);
    }
}
