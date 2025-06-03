package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaPrincipal;
import vista.VistaPaciente;
import vista.VistaMedico;
import vista.VistaCita;
import vista.VistaListaPacientes;
import vista.VistaListaMedicos;
import vista.VistaListaCitas;

public class ControladorPrincipal implements ActionListener {
    private VistaPrincipal vista;
    
    public ControladorPrincipal(VistaPrincipal vista) {
        this.vista = vista;
        
        
        this.vista.btnPacientes.addActionListener(this);
        this.vista.btnMedicos.addActionListener(this);
        this.vista.btnCitas.addActionListener(this);
        this.vista.btnListaPacientes.addActionListener(this);
        this.vista.btnListaMedicos.addActionListener(this);
        this.vista.btnListaCitas.addActionListener(this);
        this.vista.btnSalir.addActionListener(this);
        
        this.vista.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnPacientes) {
            abrirVentanaPacientes();
        } else if (e.getSource() == vista.btnMedicos) {
            abrirVentanaMedicos();
        } else if (e.getSource() == vista.btnCitas) {
            abrirVentanaCitas();
        } else if (e.getSource() == vista.btnListaPacientes) {
            abrirListaPacientes();
        } else if (e.getSource() == vista.btnListaMedicos) {
            abrirListaMedicos();
        } else if (e.getSource() == vista.btnListaCitas) {
            abrirListaCitas();
        } else if (e.getSource() == vista.btnSalir) {
            salir();
        }
    }
    
    private void abrirVentanaPacientes() {
        try {
            VistaPaciente vistaPaciente = new VistaPaciente();
            new ControladorPaciente(vistaPaciente);
            vistaPaciente.setVisible(true);
        } catch (Exception e) {
            System.err.println("Error al abrir ventana de pacientes: " + e.getMessage());
            e.printStackTrace();
            // Mostrar mensaje de error al usuario
            javax.swing.JOptionPane.showMessageDialog(vista, "Error al abrir la ventana de pacientes.\nDetalle: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void abrirVentanaMedicos() {
        try {
            VistaMedico vistaMedico = new VistaMedico();
            new ControladorMedico(vistaMedico);
            vistaMedico.setVisible(true);
        } catch (Exception e) {
            System.err.println("Error al abrir ventana de médicos: " + e.getMessage());
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog (vista, "Error al abrir la ventana de médicos.\nDetalle: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void abrirVentanaCitas() {
        try {
            VistaCita vistaCita = new VistaCita();
            new ControladorCita(vistaCita);
            vistaCita.setVisible(true);
        } catch (Exception e) {
            System.err.println("Error al abrir ventana de citas: " + e.getMessage());
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(vista,"Error al abrir la ventana de citas.\nDetalle: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void abrirListaPacientes() {
        try {
            VistaListaPacientes vistaLista = new VistaListaPacientes();
            new ControladorListaPacientes(vistaLista);
            vistaLista.setVisible(true);
        } catch (Exception e) {
            System.err.println("Error al abrir lista de pacientes: " + e.getMessage());
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(vista, "Error al abrir la lista de pacientes.\nDetalle: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void abrirListaMedicos() {
        try {
            VistaListaMedicos vistaLista = new VistaListaMedicos();
            new ControladorListaMedicos(vistaLista);
            vistaLista.setVisible(true);
        } catch (Exception e) {
            System.err.println("Error al abrir lista de médicos: " + e.getMessage());
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(vista, "Error al abrir la lista de médicos.\nDetalle: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void abrirListaCitas() {
        try {
            VistaListaCitas vistaLista = new VistaListaCitas();
            new ControladorListaCitas(vistaLista);
            vistaLista.setVisible(true);
        } catch (Exception e) {
            System.err.println("Error al abrir lista de citas: " + e.getMessage());
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(vista, "Error al abrir la lista de citas.\nDetalle: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void salir() {
        int confirmacion = javax.swing.JOptionPane.showConfirmDialog (vista, "¿Está seguro que desea salir?", "Confirmar salida", javax.swing.JOptionPane.YES_NO_OPTION);
           
            if (confirmacion == javax.swing.JOptionPane.YES_OPTION) {
                System.exit(0);
            }
    }

}