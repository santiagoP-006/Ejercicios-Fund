package ejerciciosTienda;

public class Tipo {
    private boolean perecedero;
    private int iva;

    // Constructor
    public Tipo(boolean perecedero, int iva) {
        this.perecedero = perecedero;
        this.iva = iva;
    }

    public boolean isPerecedero() {
        return perecedero;
    }

    public void setPerecedero(boolean perecedero) {
        this.perecedero = perecedero;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    @Override
    public String toString() {
        return "Perecedero: " + (perecedero ? "Sí" : "No") + ". iva: " + this.iva + "%";
    }
}
