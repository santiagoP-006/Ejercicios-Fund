package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VistaPaciente extends JFrame{
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    
    public JTextField tFId;
    public JTextField tFNombre;
    public JTextField tFTelefono;
    public JButton btnBuscar;
    public JButton btnRegistrar;
    public JButton btnModificar;
    public JButton btnBorrar;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VistaPaciente frame = new VistaPaciente();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public VistaPaciente() {
        initGUI();
    }
    
    public void initGUI() {
        setTitle("DATOS DEL PACIENTE");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblId = new JLabel("ID");
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblId.setBounds(10, 11, 55, 19);
        contentPane.add(lblId);
        
        tFId = new JTextField();
        tFId.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tFId.setBounds(117, 10, 86, 20);
        contentPane.add(tFId);
        tFId.setColumns(10);
        
        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNombre.setBounds(10, 41, 107, 19);
        contentPane.add(lblNombre);
        
        tFNombre = new JTextField();
        tFNombre.setBounds(117, 41, 189, 20);
        contentPane.add(tFNombre);
        tFNombre.setColumns(20);
        
        JLabel lblTelefono = new JLabel("Teléfono");
        lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblTelefono.setBounds(10, 71, 107, 19);
        contentPane.add(lblTelefono);
        
        tFTelefono = new JTextField();
        tFTelefono.setBounds(117, 71, 189, 20);
        contentPane.add(tFTelefono);
        tFTelefono.setColumns(20);
        
        btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnBuscar.setBounds(213, 9, 89, 23);
        contentPane.add(btnBuscar);
        
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnRegistrar.setBounds(10, 120, 89, 23);
        contentPane.add(btnRegistrar);
        
        btnModificar = new JButton("Modificar");
        btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnModificar.setBounds(117, 120, 89, 23);
        contentPane.add(btnModificar);
        
        btnBorrar = new JButton("Borrar");
        btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnBorrar.setBounds(217, 120, 89, 23);
        contentPane.add(btnBorrar);
    }
}
