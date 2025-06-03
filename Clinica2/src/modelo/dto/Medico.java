package modelo.dto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Medico implements Serializable{
	private String id;
    private String nombre;
    private String telefono;
    private String especialidad;
    private List<Cita> agenda = new ArrayList<>();
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String getEspecialidad() {
        return especialidad;
    }
    
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    public List<Cita> getAgenda() {
        return agenda;
    }
    
    public void setAgenda(List<Cita> agenda) {
        this.agenda = agenda;
    }
}
