package Banco1;

public class Titular {
	 private String id;
	 private String nombre;
	 private String correoElectronico;

	 // Constructor
	 public Titular(String id, String nombre, String correoElectronico) {
	       this.id = id;
	       this.nombre = nombre;
	       this.correoElectronico = correoElectronico;
	    }

	    // Getters
	    public String getId() {
	        return id;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public String getCorreoElectronico() {
	        return correoElectronico;
	    }

	    @Override
	    public String toString() {
	        return "Titular [id=" + id + ", nombre=" + nombre + ", correoElectronico=" + correoElectronico + "]";
	    }
}
