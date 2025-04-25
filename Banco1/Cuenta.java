package Banco1;

public abstract class Cuenta {
    private String numeroProducto;
    private int añoApertura;
    private double saldo;
    protected Titular titular;

    public Cuenta(String numeroProducto, int añoApertura, double saldoInicial, Titular titular) {
        this.numeroProducto = numeroProducto;
        this.añoApertura = añoApertura;
        this.saldo = saldoInicial >= 0 ? saldoInicial : 0;
        this.titular = titular;
    }

    public String getNumeroProducto() { return numeroProducto; }
    public int getAñoApertura() { return añoApertura; }
    public double getSaldo() { return saldo; }
    public Titular getTitular() { return titular; }
    protected void setSaldo(double saldo) { this.saldo = saldo; }

    public abstract String getTipoProducto();

    public void depositar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
            System.out.println("Deposito OK: " + monto + " en cta " + numeroProducto + ". Saldo: " + this.saldo);
        } else {
            System.out.println("Error Deposito: Monto debe ser positivo en cta " + numeroProducto);
        }
    }

    public void retirar(double monto) {
        if (monto <= 0) {
            System.out.println("Error Retiro: Monto debe ser positivo en cta " + numeroProducto);
        } else if (this.saldo >= monto) {
            this.saldo -= monto;
            System.out.println("Retiro OK: " + monto + " de cta " + numeroProducto + ". Saldo: " + this.saldo);
        } else {
            System.out.println("Error Retiro: Saldo insuficiente en cta " + numeroProducto + " (Saldo: " + this.saldo + ", Intento: " + monto + ")");
        }
    }

    @Override
    public String toString() {
        String nombreTitular = (titular != null) ? titular.getNombre() : "N/A";
        return getTipoProducto() + " [Num=" + numeroProducto + ", Saldo=" + saldo + ", Titular=" + nombreTitular + "]";
    }
}