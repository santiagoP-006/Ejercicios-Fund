package controlador;

import java.util.List;
import modelo.dao.MedicoDao;
import modelo.dto.Medico;
import vista.VistaListaMedicos;

public class ControladorListaMedicos {
	 private VistaListaMedicos vista;
	    private MedicoDao modelo;
	    
	    public ControladorListaMedicos(VistaListaMedicos vista) {
	        this.vista = vista;
	        this.modelo = new MedicoDao();
	        cargarDatos();
	    }
	    
	    private void cargarDatos() {
	        List<Medico> lista = modelo.readAll();
	        vista.modelo.setRowCount(0);
	        
	        for (Medico medico : lista) {
	            Object[] fila = {
	                medico.getId(),
	                medico.getNombre(),
	                medico.getTelefono(),
	                medico.getEspecialidad()
	            };
	            vista.modelo.addRow(fila);
	        }
	    }
}
