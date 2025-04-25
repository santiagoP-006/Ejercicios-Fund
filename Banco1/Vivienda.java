package Banco1;

public class Vivienda extends Cuenta implements IDepositar {
    private double precioVivienda;
    private String tipoVivienda;

    public Vivienda(String numeroProducto, int añoApertura, double saldoInicial, Titular titular, double precioVivienda, String tipoVivienda) {
        super(numeroProducto, añoApertura, saldoInicial, titular);
        if (precioVivienda <= 0) { this.precioVivienda = 1; }
        else { this.precioVivienda = precioVivienda; }
        this.tipoVivienda = tipoVivienda;
        if (getSaldo() > this.precioVivienda) {
             System.out.println("Advertencia Vivienda: Saldo inicial excede precio. Ajustando a " + this.precioVivienda);
             setSaldo(this.precioVivienda);
        }
    }

    public double getPrecioVivienda() { return precioVivienda; }
    public String getTipoVivienda() { return tipoVivienda; }

    @Override
    public String getTipoProducto() { return "Vivienda"; }

    @Override
    public void depositar(double monto) {
        if (monto <= 0) {
             System.out.println("Error Deposito Vivienda: Monto debe ser positivo en cta " + getNumeroProducto());
             return;
        }
        double saldoFuturo = getSaldo() + monto;
        if (saldoFuturo <= this.precioVivienda) {
            super.depositar(monto);
        } else {
            System.out.println("Error Deposito Vivienda: Monto excede precio (" + precioVivienda + ") en cta " + getNumeroProducto() + ". Saldo: " + getSaldo() + ", Intento: " + monto);
        }
    }

    @Override
    public void retirar(double monto) {
        System.out.println("Error Retiro Vivienda: Operacion no permitida en cta " + getNumeroProducto());
    }
}