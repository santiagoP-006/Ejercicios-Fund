package controlador;

import java.util.List;
import modelo.dao.PacienteDao;
import modelo.dto.Paciente;
import vista.VistaListaPacientes;

public class ControladorListaPacientes {
	private VistaListaPacientes vista;
    private PacienteDao modelo;
    
    public ControladorListaPacientes(VistaListaPacientes vista) {
        this.vista = vista;
        this.modelo = new PacienteDao();
        cargarDatos();
    }
    
    private void cargarDatos() {
        List<Paciente> lista = modelo.readAll();
        vista.modelo.setRowCount(0);
        
        for (Paciente paciente : lista) {
            Object[] fila = {
                paciente.getId(),
                paciente.getNombre(),
                paciente.getTelefono()
            };
            vista.modelo.addRow(fila);
        }
    }
}
