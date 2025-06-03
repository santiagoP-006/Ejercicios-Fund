package modelo.dao;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import modelo.dto.Paciente;

public class PacienteDao implements ICrud{
    private ArrayList<Paciente> lista;
    private ObjectInputStream entrada;
    private ObjectOutputStream salida;
    private String archivo;
    
    public PacienteDao() {
        this.archivo = "paciente";
        File file = new File(archivo);
        if(file.isFile()) {
            try {
                this.entrada = new ObjectInputStream(new FileInputStream(archivo));
                this.lista = (ArrayList<Paciente>) entrada.readObject();
                this.entrada.close();
            } catch(Exception e) {
                System.out.println(e.getMessage());
                lista = new ArrayList<>();
                guardar(); 
            }
        } else {
            lista = new ArrayList<>();
        }
    }
    
    /**
     * Guarda en la capa de persistencia la lista 
     */
    public void guardar() {
        try {
            this.salida = new ObjectOutputStream(new FileOutputStream(archivo));
            this.salida.writeObject(lista);
            this.salida.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public boolean create(Object object) {
        // TODO Auto-generated method stub
        lista.add((Paciente) object);
        guardar();
        return true;
    }
    
    @Override
    public Object read(Object object) {
        // TODO Auto-generated method stub
        for (Paciente paciente : lista) {
            if(paciente.getId().equalsIgnoreCase(((Paciente) object).getId()))
                return paciente;
        }
        return null;
    }
    
    @Override
    public Object update(int index, Object object) {
        // TODO Auto-generated method stub
        lista.set(index, (Paciente) object);
        guardar();
        return true;
    }
    
    @Override
    public boolean delete(Object object) {
        // TODO Auto-generated method stub
        lista.remove(object);
        guardar();
        return true;
    }
    
    @Override
    public int buscarIndex(Object object) {
        // TODO Auto-generated method stub
        return lista.indexOf(object);
    }
    
    @Override
    public List<Paciente> readAll() { // CORREGIDO: List<Paciente> en lugar de List
        // TODO Auto-generated method stub
        return lista;
    }
}