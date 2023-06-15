package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ArregloRetiro;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

public class FrmRetiro extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblFecha;
	private JTextField txtFecha;
	private JLabel lblHora;
	private JTextField txtHora;
	private JTable tblRetiro;
	private JScrollPane scrollPane;

	ArregloRetiro arregloRet = new ArregloRetiro();
	// Clase para asignar un modelo a la tabla
	DefaultTableModel model = new DefaultTableModel();
	// Fecha
	Date fecha = new Date();
	// Formatos
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");// Fecha
	SimpleDateFormat sdfHora = new SimpleDateFormat("hh:mm a");// Hora

	private JButton btnNuevo;
	private JButton btnAdicionar;
	private JLabel lblNumeroRetiro;
	private JTextField txtNumeroRetiro;
	private JLabel lblRegistroRetiro;
	private JLabel lblNumeroMatricula;
	public static JTextField txtNumeroMatricula;
	private JButton btnBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRetiro frame = new FrmRetiro();
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
	public FrmRetiro() {
		setTitle("Registro | Retiro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 538, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 86, 46, 14);
		contentPane.add(lblFecha);

		txtFecha = new JTextField();
		txtFecha.setBounds(66, 83, 86, 20);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);

		lblHora = new JLabel("Hora");
		lblHora.setBounds(10, 114, 46, 14);
		contentPane.add(lblHora);

		txtHora = new JTextField();
		txtHora.setBounds(66, 111, 86, 20);
		contentPane.add(txtHora);
		txtHora.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 139, 502, 266);
		contentPane.add(scrollPane);

		tblRetiro = new JTable();
		tblRetiro.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblRetiro);
		// Agregar columnas a la tabla
		model.addColumn("Retiro");
		model.addColumn("Matrícula");
		model.addColumn("Fecha");
		model.addColumn("Horas");
		// Asignar el modelo a la tabla
		tblRetiro.setModel(model);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(10, 416, 89, 23);
		contentPane.add(btnNuevo);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(109, 416, 89, 23);
		contentPane.add(btnAdicionar);

		lblNumeroRetiro = new JLabel("N\u00FAmero Retiro");
		lblNumeroRetiro.setBounds(316, 83, 100, 14);
		contentPane.add(lblNumeroRetiro);

		txtNumeroRetiro = new JTextField();
		txtNumeroRetiro.setEditable(false);
		txtNumeroRetiro.setBounds(426, 80, 86, 20);
		contentPane.add(txtNumeroRetiro);
		txtNumeroRetiro.setColumns(10);

		lblRegistroRetiro = new JLabel("REGISTRO RETIRO");
		lblRegistroRetiro.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblRegistroRetiro.setOpaque(true);
		lblRegistroRetiro.setBackground(Color.BLACK);
		lblRegistroRetiro.setForeground(Color.WHITE);
		lblRegistroRetiro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroRetiro.setBounds(10, 11, 502, 58);
		contentPane.add(lblRegistroRetiro);

		// Imprimir fecha
		txtFecha.setText(sdf.format(fecha));
		txtHora.setText(sdfHora.format(fecha));

		lblNumeroMatricula = new JLabel("Numero Matricula");
		lblNumeroMatricula.setBounds(196, 114, 109, 14);
		contentPane.add(lblNumeroMatricula);

		txtNumeroMatricula = new JTextField();
		txtNumeroMatricula.setBounds(316, 111, 86, 20);
		contentPane.add(txtNumeroMatricula);
		txtNumeroMatricula.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(423, 110, 89, 23);
		contentPane.add(btnBuscar);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == btnNuevo) {
			do_btnNuevo_actionPerformed(e);
		}
	}

	protected void do_btnNuevo_actionPerformed(ActionEvent e) {
		nuevoRetiro();
	}

	private void nuevoRetiro() {
		txtNumeroRetiro.setText("" + arregloRet.generarCodigo());

	}

	protected void actionPerformedBtnBuscar(ActionEvent e) {
		FrmBuscarMatricula ma = new FrmBuscarMatricula();
		ma.setVisible(true);
		ma.setLocationRelativeTo(this);
	}

	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		try {
			adicionar();
		} catch (Exception x) {
			mensajeError("Error de ingreso");
		}
	}

	private void adicionar() {	
	}

	private void mensajeError(String mensj) {
		JOptionPane.showMessageDialog(this, mensj, "Error", 0);
	}
}
