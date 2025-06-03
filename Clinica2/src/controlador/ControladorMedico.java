package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.dao.MedicoDao;
import modelo.dto.Medico;
import vista.VistaMedico;

public class ControladorMedico implements ActionListener{
	private VistaMedico vista;
    private MedicoDao modelo;
    private Medico medico;
    
    public ControladorMedico(VistaMedico vista) {
        this.vista = vista;
        this.modelo = new MedicoDao();
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
            JOptionPane.showMessageDialog(vista, "Ingrese el ID del médico");
            return;
        }
        
        Medico buscar = new Medico();
        buscar.setId(vista.tFId.getText());
        medico = (Medico) modelo.read(buscar);
        
        if (medico != null) {
            vista.tFNombre.setText(medico.getNombre());
            vista.tFTelefono.setText(medico.getTelefono());
            vista.cBEspecialidad.setSelectedItem(medico.getEspecialidad());
        } else {
            JOptionPane.showMessageDialog(vista, "Médico no encontrado");
            limpiar();
        }
    }
    
    private void registrar() {
        if (validarCampos()) {
            medico = new Medico();
            medico.setId(vista.tFId.getText());
            medico.setNombre(vista.tFNombre.getText());
            medico.setTelefono(vista.tFTelefono.getText());
            medico.setEspecialidad((String) vista.cBEspecialidad.getSelectedItem());
            
            if (modelo.create(medico)) {
                JOptionPane.showMessageDialog(vista, "Médico registrado exitosamente");
                limpiar();
            }
        }
    }
    
    private void modificar() {
        if (medico != null && validarCampos()) {
            int index = modelo.buscarIndex(medico);
            if (index != -1) {
                medico.setNombre(vista.tFNombre.getText());
                medico.setTelefono(vista.tFTelefono.getText());
                medico.setEspecialidad((String) vista.cBEspecialidad.getSelectedItem());
                modelo.update(index, medico);
                JOptionPane.showMessageDialog(vista, "Médico modificado exitosamente");
                limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Busque un médico primero");
        }
    }
    
    private void borrar() {
        if (medico != null) {
            int confirmacion = JOptionPane.showConfirmDialog(vista, 
                "¿Está seguro de eliminar este médico?", 
                "Confirmar eliminación", 
                JOptionPane.YES_NO_OPTION);
                
            if (confirmacion == JOptionPane.YES_OPTION) {
                modelo.delete(medico);
                JOptionPane.showMessageDialog(vista, "Médico eliminado exitosamente");
                limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Busque un médico primero");
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
        vista.cBEspecialidad.setSelectedIndex(0);
        medico = null;
    }
}
