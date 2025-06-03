package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;
import modelo.dao.CitaDao;
import modelo.dao.PacienteDao;
import modelo.dao.MedicoDao;
import modelo.dto.Cita;
import modelo.dto.Paciente;
import modelo.dto.Medico;
import vista.VistaCita;

public class ControladorCita implements ActionListener{
    private VistaCita vista;
    private CitaDao modeloCita;
    private PacienteDao modeloPaciente;
    private MedicoDao modeloMedico;
    private Cita cita;
    private Paciente paciente;
    private Medico medico;
    
    
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public ControladorCita(VistaCita vista) {
        this.vista = vista;
        this.modeloCita = new CitaDao();
        this.modeloPaciente = new PacienteDao();
        this.modeloMedico = new MedicoDao();
        
        this.vista.btnBuscar.addActionListener(this);
        this.vista.btnBuscarPaciente.addActionListener(this);
        this.vista.btnBuscarMedico.addActionListener(this);
        this.vista.btnRegistrar.addActionListener(this);
        this.vista.btnModificar.addActionListener(this);
        this.vista.btnBorrar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnBuscar) {
            buscarCita();
        } else if (e.getSource() == vista.btnBuscarPaciente) {
            buscarPaciente();
        } else if (e.getSource() == vista.btnBuscarMedico) {
            buscarMedico();
        } else if (e.getSource() == vista.btnRegistrar) {
            registrar();
        } else if (e.getSource() == vista.btnModificar) {
            modificar();
        } else if (e.getSource() == vista.btnBorrar) {
            borrar();
        }
    }
    
    private void buscarCita() {
        if (vista.tFId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Ingrese el ID de la cita");
            return;
        }
        
        Cita buscar = new Cita();
        buscar.setId(vista.tFId.getText());
        cita = (Cita) modeloCita.read(buscar);
        
        if (cita != null) {
            
            String fechaString = cita.getFecha().format(formatter);
            vista.setFecha(fechaString);
            
            vista.tFIdPaciente.setText(cita.getPaciente().getId());
            vista.tFNombrePaciente.setText(cita.getPaciente().getNombre());
            vista.tFIdMedico.setText(cita.getMedico().getId());
            vista.tFNombreMedico.setText(cita.getMedico().getNombre());
            paciente = cita.getPaciente();
            medico = cita.getMedico();
        } else {
            JOptionPane.showMessageDialog(vista, "Cita no encontrada");
            limpiar();
        }
    }
    
    private void buscarPaciente() {
        if (vista.tFIdPaciente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Ingrese el ID del paciente");
            return;
        }
        
        Paciente buscar = new Paciente();
        buscar.setId(vista.tFIdPaciente.getText());
        paciente = (Paciente) modeloPaciente.read(buscar);
        
        if (paciente != null) {
            vista.tFNombrePaciente.setText(paciente.getNombre());
        } else {
            JOptionPane.showMessageDialog(vista, "Paciente no encontrado");
            vista.tFNombrePaciente.setText("");
        }
    }
    
    private void buscarMedico() {
        if (vista.tFIdMedico.getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Ingrese el ID del médico");
            return;
        }
        
        Medico buscar = new Medico();
        buscar.setId(vista.tFIdMedico.getText());
        medico = (Medico) modeloMedico.read(buscar);
        
        if (medico != null) {
            vista.tFNombreMedico.setText(medico.getNombre());
        } else {
            JOptionPane.showMessageDialog(vista, "Médico no encontrado");
            vista.tFNombreMedico.setText("");
        }
    }
    
    private void registrar() {
        if (validarCampos()) {
            cita = new Cita();
            cita.setId(vista.tFId.getText());
            
           
            LocalDate fechaCita = convertirStringAFecha(vista.getFecha());
            if (fechaCita != null) {
                cita.setFecha(fechaCita);
                cita.setPaciente(paciente);
                cita.setMedico(medico);
                
                if (modeloCita.create(cita)) {
                    JOptionPane.showMessageDialog(vista, "Cita registrada exitosamente");
                    limpiar();
                }
            }
        }
    }
    
    private void modificar() {
        if (cita != null && validarCampos()) {
            int index = modeloCita.buscarIndex(cita);
            if (index != -1) {
         
                LocalDate fechaCita = convertirStringAFecha(vista.getFecha());
                if (fechaCita != null) {
                    cita.setFecha(fechaCita);
                    cita.setPaciente(paciente);
                    cita.setMedico(medico);
                    
                    modeloCita.update(index, cita);
                    JOptionPane.showMessageDialog(vista, "Cita modificada exitosamente");
                    limpiar();
                }
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Busque una cita primero");
        }
    }
    
    private void borrar() {
        if (cita != null) {
            int confirmacion = JOptionPane.showConfirmDialog(vista, 
                "¿Está seguro de eliminar esta cita?", 
                "Confirmar eliminación", 
                JOptionPane.YES_NO_OPTION);
                
            if (confirmacion == JOptionPane.YES_OPTION) {
                modeloCita.delete(cita);
                JOptionPane.showMessageDialog(vista, "Cita eliminada exitosamente");
                limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Busque una cita primero");
        }
    }
    
    private boolean validarCampos() {
        if (vista.tFId.getText().isEmpty() || 
            vista.getFecha().isEmpty() ||
            vista.getFecha().equals("dd/mm/aaaa") ||
            paciente == null || 
            medico == null) {
            JOptionPane.showMessageDialog(vista, "Complete todos los campos y busque paciente y médico");
            return false;
        }
        
    
        if (convertirStringAFecha(vista.getFecha()) == null) {
            return false;
        }
        
        return true;
    }
    
    private void limpiar() {
        vista.tFId.setText("");
        vista.limpiarFecha();
        vista.tFIdPaciente.setText("");
        vista.tFNombrePaciente.setText("");
        vista.tFIdMedico.setText("");
        vista.tFNombreMedico.setText("");
        cita = null;
        paciente = null;
        medico = null;
    }
    
    
    private LocalDate convertirStringAFecha(String fechaString) {
        try {
            return LocalDate.parse(fechaString, formatter);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(vista, 
                "Formato de fecha incorrecto. Use: dd/mm/aaaa\nEjemplo: 15/03/2024");
            return null;
        }
    }
}