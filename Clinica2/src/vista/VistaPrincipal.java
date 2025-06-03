package vista;

import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class VistaPrincipal extends JFrame {
    private static final long serialVersionUID = 1L;

    private static final Color GRIS_OSCURO = new Color(52, 52, 52);
    private static final Color GRIS_CLARO = new Color(245, 245, 245);
    private static final Color BLANCO = Color.WHITE;

    public JButton btnPacientes;
    public JButton btnMedicos;
    public JButton btnCitas;
    public JButton btnListaPacientes;
    public JButton btnListaMedicos;
    public JButton btnListaCitas;
    public JButton btnSalir;

    private JPanel panelContenido;

    public static void main(String[] args) {
        try {
        	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        EventQueue.invokeLater(() -> {
            try {
                VistaPrincipal frame = new VistaPrincipal();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public VistaPrincipal() {
        inicializarVentana();
        crearInterfaz();
        centrarVentana();
    }

    private void inicializarVentana() {
        setTitle("Sistema Clínica Buena Piel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setMinimumSize(new Dimension(700, 500));
        getContentPane().setBackground(BLANCO);
    }

    private void crearInterfaz() {
        setLayout(new BorderLayout());

        add(crearHeader(), BorderLayout.NORTH);
        add(crearPanelLateral(), BorderLayout.WEST);
        panelContenido = crearPanelContenido();
        add(panelContenido, BorderLayout.CENTER);
    }

    private JPanel crearHeader() {
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(BLANCO);
        header.setPreferredSize(new Dimension(0, 60));
        header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(230, 230, 230)));

        JLabel titulo = new JLabel("  Sistema Clínica Buena Piel");
        titulo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        titulo.setForeground(GRIS_OSCURO);
        header.add(titulo, BorderLayout.WEST);

        return header;
    }

    private JPanel crearPanelLateral() {
        JPanel panelLateral = new JPanel();
        panelLateral.setLayout(new BoxLayout(panelLateral, BoxLayout.Y_AXIS));
        panelLateral.setBackground(GRIS_CLARO);
        panelLateral.setPreferredSize(new Dimension(200, 0));
        panelLateral.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(230, 230, 230)));

        panelLateral.add(Box.createVerticalStrut(30));

        panelLateral.add(crearTituloSeccion("GESTIÓN DE DATOS"));
        btnPacientes = crearBotonSimple("Pacientes");
        btnMedicos = crearBotonSimple("Médicos");
        btnCitas = crearBotonSimple("Citas");

        panelLateral.add(btnPacientes);
        panelLateral.add(Box.createVerticalStrut(5));
        panelLateral.add(btnMedicos);
        panelLateral.add(Box.createVerticalStrut(5));
        panelLateral.add(btnCitas);
        panelLateral.add(Box.createVerticalStrut(30));

        panelLateral.add(crearTituloSeccion("INFORMES"));
        btnListaPacientes = crearBotonSimple("Lista Pacientes");
        btnListaMedicos = crearBotonSimple("Lista Médicos");
        btnListaCitas = crearBotonSimple("Lista Citas");

        panelLateral.add(btnListaPacientes);
        panelLateral.add(Box.createVerticalStrut(5));
        panelLateral.add(btnListaMedicos);
        panelLateral.add(Box.createVerticalStrut(5));
        panelLateral.add(btnListaCitas);

        panelLateral.add(Box.createVerticalGlue());

        btnSalir = crearBotonSalir();
        panelLateral.add(btnSalir);
        panelLateral.add(Box.createVerticalStrut(20));

        return panelLateral;
    }

    private JButton crearBotonSimple(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        boton.setForeground(GRIS_OSCURO);
        boton.setBackground(GRIS_CLARO);
        boton.setBorder(new EmptyBorder(10, 20, 10, 20));
        boton.setFocusPainted(false);
        boton.setAlignmentX(Component.LEFT_ALIGNMENT);
        boton.setMaximumSize(new Dimension(160, 35));
       
        return boton;
    }

    private JButton crearBotonSalir() {
        JButton boton = new JButton("Salir");
        boton.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        boton.setForeground(Color.WHITE);
        boton.setBackground(new Color(220, 53, 69)); // rojo tipo "danger"
        boton.setBorder(new EmptyBorder(8, 20, 8, 20));
        boton.setFocusPainted(false);
        boton.setAlignmentX(Component.LEFT_ALIGNMENT);
        boton.setMaximumSize(new Dimension(160, 30));
        return boton;
    }

    private JLabel crearTituloSeccion(String texto) {
        JLabel titulo = new JLabel(texto);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 11));
        titulo.setForeground(new Color(120, 120, 120));
        titulo.setBorder(new EmptyBorder(0, 20, 8, 0));
        titulo.setAlignmentX(Component.LEFT_ALIGNMENT);
        return titulo;
    }

    private JPanel crearPanelContenido() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(BLANCO);
        panel.setBorder(new EmptyBorder(40, 40, 40, 40));

        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.setBackground(BLANCO);

        JLabel lblPrincipal = new JLabel("Bienvenido");
        lblPrincipal.setFont(new Font("Segoe UI Light", Font.PLAIN, 32));
        lblPrincipal.setForeground(GRIS_OSCURO);
        lblPrincipal.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblSecundario = new JLabel("Seleccione una opción del menú");
        lblSecundario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSecundario.setForeground(new Color(140, 140, 140));
        lblSecundario.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelCentral.add(Box.createVerticalGlue());
        panelCentral.add(lblPrincipal);
        panelCentral.add(Box.createVerticalStrut(10));
        panelCentral.add(lblSecundario);
        panelCentral.add(Box.createVerticalGlue());

        panel.add(panelCentral, BorderLayout.CENTER);
        return panel;
    }

    public void actualizarContenido(JPanel nuevoContenido) {
        panelContenido.removeAll();
        panelContenido.add(nuevoContenido, BorderLayout.CENTER);
        panelContenido.revalidate();
        panelContenido.repaint();
    }

    public JPanel getPanelContenido() {
        return panelContenido;
    }

    private void centrarVentana() {
        setLocationRelativeTo(null);
    }
}
