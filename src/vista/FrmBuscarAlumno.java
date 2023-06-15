package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ArregloAlumno;
import entidad.Alumno;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmBuscarAlumno extends JFrame implements KeyListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtBuscarApellido;
	private JButton btnEnviarDatos;
	private JTable tblAlumno;
	private JScrollPane scrollPane;
	
	//Clase para asignar un modelo a la tabla
	DefaultTableModel model = new DefaultTableModel();
	//Instanciar objeto
	ArregloAlumno arregloAl = new ArregloAlumno();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmBuscarAlumno frame = new FrmBuscarAlumno();
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
	public FrmBuscarAlumno() {
		setTitle("Buscar Alumno");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 570, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("BUSCAR ALUMNO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel.setBackground(SystemColor.desktop);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 534, 27);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Apellido :");
		lblNewLabel_1.setBounds(10, 49, 55, 14);
		contentPane.add(lblNewLabel_1);
		
		txtBuscarApellido = new JTextField();
		txtBuscarApellido.addKeyListener(this);
		txtBuscarApellido.setBounds(75, 46, 345, 20);
		contentPane.add(txtBuscarApellido);
		txtBuscarApellido.setColumns(10);
		
		btnEnviarDatos = new JButton("Enviar Datos");
		btnEnviarDatos.addActionListener(this);
		btnEnviarDatos.setBounds(430, 45, 114, 23);
		contentPane.add(btnEnviarDatos);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 74, 534, 176);
		contentPane.add(scrollPane);
		
		tblAlumno = new JTable();
		tblAlumno.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblAlumno);
		//Agregar columnas a la tabla
			model.addColumn("Código");
			model.addColumn("Nombre");
			model.addColumn("Apellidos");
			model.addColumn("DNI");
			model.addColumn("Edad");
			model.addColumn("Celular");
			model.addColumn("Estado");
		//Asignar el modelo a la tabla
			tblAlumno.setModel(model);
	}
	
	public void consultar(String buscarApellido) {
		//Limpiar la tabla
		model.setRowCount(0);
		//Bucle
		for (int i = 0; i < arregloAl.tamanio(); i++) {
			Alumno a = arregloAl.obtener(i);			
				if(a.getApellidos().toLowerCase().startsWith(buscarApellido.toLowerCase()) && a.getEstado()== 0) {
					Object fila [] = { a.getCodAlumno(),
									   a.getNombres(),
									   a.getApellidos(),
									   a.getDni(),
									   a.getEdad(),
									   a.getCelular(),
									   a.getEstado(),							
									};
					model.addRow(fila);						 
			}
		}
	}
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtBuscarApellido) {
			do_txtBuscarApellido_keyReleased(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void do_txtBuscarApellido_keyReleased(KeyEvent e) {
		String buscarApellido;
		buscarApellido = getBuscarApellido();
		consultar(buscarApellido);
	}

	private String getBuscarApellido() {		
		String ape = null;
		ape = txtBuscarApellido.getText();
		return ape;
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEnviarDatos) {
			do_btnEnviarDatos_actionPerformed(e);
		}
	}
	
	protected void do_btnEnviarDatos_actionPerformed(ActionEvent e) {
		//Variable
		int fila;
		String cod, nomb, ape, dni, edad;
		//Obtener la posición de la fila seleccionada
		fila = tblAlumno.getSelectedRow();
		//Obtener los valores de la fila seleccionada
		cod = tblAlumno.getValueAt(fila, 0).toString();
		nomb = tblAlumno.getValueAt(fila, 1).toString();
		ape = tblAlumno.getValueAt(fila, 2).toString();
		dni = tblAlumno.getValueAt(fila, 3).toString();
		edad = tblAlumno.getValueAt(fila, 4).toString();
		//Mostrar los valores en las cajas de texto
		FrmMatricula.txtCodigo.setText(cod);
		FrmMatricula.txtNombreAlumno.setText(nomb);
		FrmMatricula.txtApellidos.setText(ape);
		FrmMatricula.txtDni.setText(dni);
		FrmMatricula.txtEdad.setText(edad);
		//Cerrar ventana
		dispose();
		
	}
}
