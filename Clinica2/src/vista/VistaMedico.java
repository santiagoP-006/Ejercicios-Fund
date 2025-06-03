package vista;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VistaMedico extends JFrame{
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    
    public JTextField tFId;
    public JTextField tFNombre;
    public JTextField tFTelefono;
    public JComboBox<String> cBEspecialidad;
    public JButton btnBuscar;
    public JButton btnRegistrar;
    public JButton btnModificar;
    public JButton btnBorrar;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VistaMedico frame = new VistaMedico();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public VistaMedico() {
        initGUI();
    }
    
    public void initGUI() {
        setTitle("DATOS DEL MÉDICO");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 350);
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
        
        JLabel lblEspecialidad = new JLabel("Especialidad");
        lblEspecialidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblEspecialidad.setBounds(10, 101, 107, 19);
        contentPane.add(lblEspecialidad);
        
        cBEspecialidad = new JComboBox<>();
        cBEspecialidad.setModel(new DefaultComboBoxModel<>(new String[] {
            "Dermatología", "Cirugía Plástica", "Medicina Estética", 
            "Oncología Dermatológica", "Dermatología Pediátrica"
        }));
        cBEspecialidad.setBounds(117, 101, 189, 22);
        contentPane.add(cBEspecialidad);
        
        btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnBuscar.setBounds(213, 9, 89, 23);
        contentPane.add(btnBuscar);
        
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnRegistrar.setBounds(10, 150, 89, 23);
        contentPane.add(btnRegistrar);
        
        btnModificar = new JButton("Modificar");
        btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnModificar.setBounds(117, 150, 89, 23);
        contentPane.add(btnModificar);
        
        btnBorrar = new JButton("Borrar");
        btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnBorrar.setBounds(217, 150, 89, 23);
        contentPane.add(btnBorrar);
    }
}
