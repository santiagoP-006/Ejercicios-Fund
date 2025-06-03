package vista;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VistaCita extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    
    public JTextField tFId;
    public JTextField tFIdPaciente;
    public JTextField tFNombrePaciente;
    public JTextField tFIdMedico;
    public JTextField tFNombreMedico;
    public JTextField tFFecha; 
    public JButton btnBuscarPaciente;
    public JButton btnBuscarMedico;
    public JButton btnRegistrar;
    public JButton btnModificar;
    public JButton btnBorrar;
    public JButton btnBuscar;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VistaCita frame = new VistaCita();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public VistaCita() {
        initGUI();
    }
    
    public void initGUI() {
        setTitle("DATOS DE LA CITA");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblId = new JLabel("ID Cita");
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblId.setBounds(10, 11, 80, 19);
        contentPane.add(lblId);
        
        tFId = new JTextField();
        tFId.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tFId.setBounds(100, 10, 86, 20);
        contentPane.add(tFId);
        tFId.setColumns(10);
        
        btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnBuscar.setBounds(200, 9, 89, 23);
        contentPane.add(btnBuscar);
        
        JLabel lblFecha = new JLabel("Fecha");
        lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblFecha.setBounds(10, 41, 80, 19);
        contentPane.add(lblFecha);
        
        
        tFFecha = new JTextField();
        tFFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tFFecha.setBounds(100, 41, 150, 20);
        tFFecha.setText(""); 
        contentPane.add(tFFecha);
        tFFecha.setColumns(10);
        
    
        JLabel lblFormatoFecha = new JLabel("(dd/mm/aaaa)");
        lblFormatoFecha.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblFormatoFecha.setBounds(260, 44, 80, 14);
        contentPane.add(lblFormatoFecha);
        
        JLabel lblIdPaciente = new JLabel("ID Paciente");
        lblIdPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblIdPaciente.setBounds(10, 80, 80, 19);
        contentPane.add(lblIdPaciente);
        
        tFIdPaciente = new JTextField();
        tFIdPaciente.setBounds(100, 80, 86, 20);
        contentPane.add(tFIdPaciente);
        tFIdPaciente.setColumns(10);
        
        btnBuscarPaciente = new JButton("Buscar");
        btnBuscarPaciente.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnBuscarPaciente.setBounds(200, 79, 70, 23);
        contentPane.add(btnBuscarPaciente);
        
        JLabel lblNombrePaciente = new JLabel("Nombre");
        lblNombrePaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNombrePaciente.setBounds(10, 110, 80, 19);
        contentPane.add(lblNombrePaciente);
        
        tFNombrePaciente = new JTextField();
        tFNombrePaciente.setBounds(100, 110, 200, 20);
        tFNombrePaciente.setEditable(false);
        contentPane.add(tFNombrePaciente);
        tFNombrePaciente.setColumns(20);
        
        JLabel lblIdMedico = new JLabel("ID Médico");
        lblIdMedico.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblIdMedico.setBounds(10, 150, 80, 19);
        contentPane.add(lblIdMedico);
        
        tFIdMedico = new JTextField();
        tFIdMedico.setBounds(100, 150, 86, 20);
        contentPane.add(tFIdMedico);
        tFIdMedico.setColumns(10);
        
        btnBuscarMedico = new JButton("Buscar");
        btnBuscarMedico.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnBuscarMedico.setBounds(200, 149, 70, 23);
        contentPane.add(btnBuscarMedico);
        
        JLabel lblNombreMedico = new JLabel("Nombre");
        lblNombreMedico.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNombreMedico.setBounds(10, 180, 80, 19);
        contentPane.add(lblNombreMedico);
        
        tFNombreMedico = new JTextField();
        tFNombreMedico.setBounds(100, 180, 200, 20);
        tFNombreMedico.setEditable(false);
        contentPane.add(tFNombreMedico);
        tFNombreMedico.setColumns(20);
        
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnRegistrar.setBounds(50, 230, 89, 23);
        contentPane.add(btnRegistrar);
        
        btnModificar = new JButton("Modificar");
        btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnModificar.setBounds(150, 230, 89, 23);
        contentPane.add(btnModificar);
        
        btnBorrar = new JButton("Borrar");
        btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnBorrar.setBounds(250, 230, 89, 23);
        contentPane.add(btnBorrar);
    }
    
 
    public String getFecha() {
        return tFFecha.getText();
    }
    
   
    public void setFecha(String fecha) {
        tFFecha.setText(fecha);
    }
    
    public void limpiarFecha() {
        tFFecha.setText("");
    }
}