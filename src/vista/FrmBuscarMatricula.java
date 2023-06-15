package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ArregloMatricula;
import entidad.Matricula;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class FrmBuscarMatricula extends JFrame implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNumeroMatricula;
	private JTextField txtBuscarNumeroMatricula;
	private JButton btnEnviarDatos;
	private JTable tblMatricula;
	private JScrollPane scrollPane;
	
	//Clase para asignar un modelo a la tabla
	DefaultTableModel model = new DefaultTableModel();
	//Instanciar objeto
	ArregloMatricula arregloMat = new ArregloMatricula();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmBuscarMatricula frame = new FrmBuscarMatricula();
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
	public FrmBuscarMatricula() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 578, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Buscar Matricula");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 542, 30);
		contentPane.add(lblNewLabel);
		
		lblNumeroMatricula = new JLabel("N\u00FAmero Matricula");
		lblNumeroMatricula.setBounds(10, 52, 121, 14);
		contentPane.add(lblNumeroMatricula);
		
		txtBuscarNumeroMatricula = new JTextField();
		txtBuscarNumeroMatricula.addKeyListener(this);
		txtBuscarNumeroMatricula.setBounds(141, 49, 288, 20);
		contentPane.add(txtBuscarNumeroMatricula);
		txtBuscarNumeroMatricula.setColumns(10);
		
		btnEnviarDatos = new JButton("Enviar Datos");
		btnEnviarDatos.addActionListener(this);
		btnEnviarDatos.setBounds(439, 48, 113, 23);
		contentPane.add(btnEnviarDatos);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 77, 542, 153);
		contentPane.add(scrollPane);
		
		tblMatricula = new JTable();
		tblMatricula.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblMatricula);
		
		//Agregar columnas a la tabla
		model.addColumn("Número");
		model.addColumn("Cod-Alumno");
		model.addColumn("Cod-Curso");
		model.addColumn("Hora");
		model.addColumn("Fecha");
		//Asignar el modelo a la tabla
		tblMatricula.setModel(model);
	}
	
	public void consultar(int numMatri) {
		model.setRowCount(0);
		for (int i = 0; i < arregloMat.tamanio(); i++) {
			Matricula m = arregloMat.obtener(i);
			if(m.getNumMatricula() == numMatri -1) {
				Object fila [] = {m.getNumMatricula(),
								  m.getCodAlumno(),
								  m.getCodCurso(),
								  m.getHora(),
								  m.getFecha(),		
							};
				model.addRow(fila);
			}
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEnviarDatos) {
			actionPerformedBtnEnviarDatos(e);
		}
	}
	protected void actionPerformedBtnEnviarDatos(ActionEvent e) {
		int fila;
		String numMatri;
		fila = tblMatricula.getSelectedRow();
		numMatri = tblMatricula.getValueAt(fila, 0).toString();
		
		FrmRetiro.txtNumeroMatricula.setText(numMatri);
		dispose();
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtBuscarNumeroMatricula) {
			keyReleasedTextField(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTextField(KeyEvent e) {
		int buscarNumeroMatricula;
		buscarNumeroMatricula = getBuscarNumeroMatricula();
		consultar(buscarNumeroMatricula);
	}

	private int getBuscarNumeroMatricula() {
		int numMatri = -1;
		numMatri = Integer.parseInt(txtBuscarNumeroMatricula.getText());
		return numMatri;
	}
}
