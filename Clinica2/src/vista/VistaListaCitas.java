package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

public class VistaListaCitas extends JFrame {
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public JTable table;
    public DefaultTableModel modelo;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VistaListaCitas frame = new VistaListaCitas();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public VistaListaCitas() {
        initGUI();
    }
    
    public void initGUI() {
        setTitle("LISTA DE CITAS");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 764, 339);
        contentPane.add(scrollPane);
        
        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 12));
        modelo = new DefaultTableModel(
            new Object[][] {},
            new String[] {"ID Cita", "Fecha", "Paciente", "Médico", "Especialidad"}
        );
        table.setModel(modelo);
        scrollPane.setViewportView(table);
    }
}
