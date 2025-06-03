package controlador;

import java.util.List;
import modelo.dao.CitaDao;
import modelo.dto.Cita;
import vista.VistaListaCitas;

public class ControladorListaCitas  {
	 private VistaListaCitas vista;
	    private CitaDao modelo;
	    
	    public ControladorListaCitas(VistaListaCitas vista) {
	        this.vista = vista;
	        this.modelo = new CitaDao();
	        cargarDatos();
	    }
	    
	    private void cargarDatos() {
	        List<Cita> lista = modelo.readAll();
	        vista.modelo.setRowCount(0);
	        
	        for (Cita cita : lista) {
	            Object[] fila = {
	                cita.getId(),
	                cita.getFecha().toString(),
	                cita.getPaciente().getNombre(),
	                cita.getMedico().getNombre(),
	                cita.getMedico().getEspecialidad()
	            };
	            vista.modelo.addRow(fila);
	        }
	    }
}
