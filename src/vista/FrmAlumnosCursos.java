package vista;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class FrmAlumnosCursos extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnConsultar;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAlumnosCursos frame = new FrmAlumnosCursos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmAlumnosCursos() {
		setTitle("Alumnos y cursos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 441, 291);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.addActionListener(this);
		textField.setBounds(10, 11, 214, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(234, 9, 89, 23);
		contentPane.add(btnConsultar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 414, 208);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(333, 9, 91, 23);
		contentPane.add(btnCerrar);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			do_btnCerrar_actionPerformed(e);
		}
		if (e.getSource() == textField) {
			do_textField_actionPerformed(e);
		}
	}
	protected void do_textField_actionPerformed(ActionEvent e) {
		
		
		
	}
	protected void do_btnCerrar_actionPerformed(ActionEvent e) {

			dispose();
	}
}
