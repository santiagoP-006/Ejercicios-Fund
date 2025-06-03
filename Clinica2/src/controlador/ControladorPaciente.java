package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.dao.PacienteDao;
import modelo.dto.Paciente;
import vista.VistaPaciente;

public class ControladorPaciente implements ActionListener {
	private VistaPaciente vista;
    private PacienteDao modelo;
    private Paciente paciente;
    
    public ControladorPaciente(VistaPaciente vista) {
        this.vista = vista;
        this.modelo = new PacienteDao();
        this.vista.btnBuscar.addActionListener(this);
        this.vista.btnRegistrar.addActionListener(this);
        this.vista.btnModificar.addActionListener(this);
        this.vista.btnBorrar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnBuscar) {
            buscar();
        } else if (e.getSource() == vista.btnRegistrar) {
            registrar();
        } else if (e.getSource() == vista.btnModificar) {
            modificar();
        } else if (e.getSource() == vista.btnBorrar) {
            borrar();
        }
    }
    
    private void buscar() {
        if (vista.tFId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Ingrese el ID del paciente");
            return;
        }
        
        Paciente buscar = new Paciente();
        buscar.setId(vista.tFId.getText());
        paciente = (Paciente) modelo.read(buscar);
        
        if (paciente != null) {
            vista.tFNombre.setText(paciente.getNombre());
            vista.tFTelefono.setText(paciente.getTelefono());
        } else {
            JOptionPane.showMessageDialog(vista, "Paciente no encontrado");
            limpiar();
        }
    }
    
    private void registrar() {
        if (validarCampos()) {
            paciente = new Paciente();
            paciente.setId(vista.tFId.getText());
            paciente.setNombre(vista.tFNombre.getText());
            paciente.setTelefono(vista.tFTelefono.getText());
            
            if (modelo.create(paciente)) {
                JOptionPane.showMessageDialog(vista, "Paciente registrado exitosamente");
                limpiar();
            }
        }
    }
    
    private void modificar() {
        if (paciente != null && validarCampos()) {
            int index = modelo.buscarIndex(paciente);
            if (index != -1) {
                paciente.setNombre(vista.tFNombre.getText());
                paciente.setTelefono(vista.tFTelefono.getText());
                modelo.update(index, paciente);
                JOptionPane.showMessageDialog(vista, "Paciente modificado exitosamente");
                limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Busque un paciente primero");
        }
    }
    
    private void borrar() {
        if (paciente != null) {
            int confirmacion = JOptionPane.showConfirmDialog(vista, 
                "¿Está seguro de eliminar este paciente?", 
                "Confirmar eliminación", 
                JOptionPane.YES_NO_OPTION);
                
            if (confirmacion == JOptionPane.YES_OPTION) {
                modelo.delete(paciente);
                JOptionPane.showMessageDialog(vista, "Paciente eliminado exitosamente");
                limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Busque un paciente primero");
        }
    }
    
    private boolean validarCampos() {
        if (vista.tFId.getText().isEmpty() || 
            vista.tFNombre.getText().isEmpty() || 
            vista.tFTelefono.getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Complete todos los campos");
            return false;
        }
        return true;
    }
    
    private void limpiar() {
        vista.tFId.setText("");
        vista.tFNombre.setText("");
        vista.tFTelefono.setText("");
        paciente = null;
    }
}
