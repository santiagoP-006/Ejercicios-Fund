package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

public class VistaListaPacientes extends JFrame {
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public JTable table;
    public DefaultTableModel modelo;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VistaListaPacientes frame = new VistaListaPacientes();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public VistaListaPacientes() {
        initGUI();
    }
    
    public void initGUI() {
        setTitle("LISTA DE PACIENTES");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 564, 339);
        contentPane.add(scrollPane);
        
        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 12));
        modelo = new DefaultTableModel(
            new Object[][] {},
            new String[] {"ID", "Nombre", "Teléfono"}
        );
        table.setModel(modelo);
        scrollPane.setViewportView(table);
    }
}
