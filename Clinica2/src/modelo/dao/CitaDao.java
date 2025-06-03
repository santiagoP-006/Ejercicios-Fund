package modelo.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import modelo.dto.Cita;

public class CitaDao implements ICrud{
    private ArrayList<Cita> lista;
    private ObjectInputStream entrada;
    private ObjectOutputStream salida;
    private String archivo;
    
    public CitaDao() {
        this.archivo = "cita";
        File file = new File(archivo);
        if(file.isFile()) {
            try {
                this.entrada = new ObjectInputStream(new FileInputStream(archivo));
                this.lista = (ArrayList<Cita>) entrada.readObject();
                this.entrada.close();
            } catch(Exception e) {
                System.out.println(e.getMessage());
                lista = new ArrayList<>();
                guardar();
            }
        } else {
            lista = new ArrayList<>();
            guardar();  
        }
    }
    
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
        lista.add((Cita) object);
        guardar();
        return true;
    }
    
    @Override
    public Object read(Object object) {
        for (Cita cita : lista) {
            if(cita.getId().equalsIgnoreCase(((Cita) object).getId()))
                return cita;
        }
        return null;
    }
    
    @Override
    public Object update(int index, Object object) {
        lista.set(index, (Cita) object);
        guardar();
        return true;
    }
    
    @Override
    public boolean delete(Object object) {
        lista.remove(object);
        guardar();
        return true;
    }
    
    @Override
    public int buscarIndex(Object object) {
        return lista.indexOf(object);
    }
    
    @Override
    public List<Cita> readAll() {  
        return lista;
    }
}