package vista;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ArregloMatricula;
import entidad.Matricula;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class FrmMatricula extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtNumeroMatricula;
	private JPanel panel;
	private JLabel lblCodigo;
	public static JTextField txtCodigo;
	private JLabel lblNombre;
	public static JTextField txtNombreAlumno;
	private JButton btnBuscarAlumno;
	private JLabel lblDNI;
	public static JTextField txtDni;
	private JLabel lblApellido;
	public static JTextField txtApellidos;
	private JLabel lblEdad;
	public static JTextField txtEdad;
	private JPanel panel_1;
	private JLabel lblCodigoCurso;
	public static JTextField txtCodigoCurso;
	private JLabel lblAsignatura;
	public static JTextField txtAsignatura;
	private JLabel lblNewLabel_2;
	public static JTextField txtCreditos;
	private JLabel lblNewLabel_3;
	public static JTextField txtCiclo;
	private JLabel lblNewLabel_4;
	public static JTextField txtHoras;
	private JButton btnBuscarCurso;
	private JButton btnNuevo;

	ArregloMatricula arregloMat = new ArregloMatricula();
	private JTable tblMatricula;
	private JScrollPane scrollPane;

	// Modelo para la tabla
	DefaultTableModel model = new DefaultTableModel();
	private JLabel lblNewLabel_5;
	private JTextField txtFecha;
	private JLabel lblNewLabel_6;
	private JTextField txtHora;
	// Fecha
	Date fecha = new Date();
	// Para 2 formatos
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");// Fecha
	SimpleDateFormat sdfHora = new SimpleDateFormat("hh:mm a");// Hora
	private JButton btnAdicionar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMatricula frame = new FrmMatricula();
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
	public FrmMatricula() {
		setTitle("Registro | Matr\u00EDcula");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 589, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("REGISTRO MATRICULA");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(SystemColor.desktop);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 602, 39);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("N\u00FAmero Matr\u00EDcula");
		lblNewLabel_1.setBounds(365, 64, 108, 14);
		contentPane.add(lblNewLabel_1);

		txtNumeroMatricula = new JTextField();
		txtNumeroMatricula.setEnabled(false);
		txtNumeroMatricula.setBounds(483, 61, 86, 20);
		contentPane.add(txtNumeroMatricula);
		txtNumeroMatricula.setColumns(10);

		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos del Alumno", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 94, 553, 79);
		contentPane.add(panel);
		panel.setLayout(null);

		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setBounds(10, 21, 46, 14);
		panel.add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(66, 18, 67, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);

		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 49, 46, 14);
		panel.add(lblNombre);

		txtNombreAlumno = new JTextField();
		txtNombreAlumno.setEditable(false);
		txtNombreAlumno.setBounds(66, 49, 152, 20);
		panel.add(txtNombreAlumno);
		txtNombreAlumno.setColumns(10);

		btnBuscarAlumno = new JButton("Buscar");
		btnBuscarAlumno.addActionListener(this);
		btnBuscarAlumno.setBounds(143, 17, 75, 23);
		panel.add(btnBuscarAlumno);

		lblDNI = new JLabel("DNI");
		lblDNI.setBounds(249, 21, 46, 14);
		panel.add(lblDNI);

		txtDni = new JTextField();
		txtDni.setEditable(false);
		txtDni.setBounds(305, 18, 86, 20);
		panel.add(txtDni);
		txtDni.setColumns(10);

		lblApellido = new JLabel("Apellidos");
		lblApellido.setBounds(249, 49, 56, 14);
		panel.add(lblApellido);

		txtApellidos = new JTextField();
		txtApellidos.setEditable(false);
		txtApellidos.setBounds(305, 46, 238, 20);
		panel.add(txtApellidos);
		txtApellidos.setColumns(10);

		lblEdad = new JLabel("Edad");
		lblEdad.setBounds(401, 21, 46, 14);
		panel.add(lblEdad);

		txtEdad = new JTextField();
		txtEdad.setEditable(false);
		txtEdad.setBounds(457, 18, 86, 20);
		panel.add(txtEdad);
		txtEdad.setColumns(10);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Datos del Cuso", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 184, 553, 79);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		lblCodigoCurso = new JLabel("C\u00F3digo");
		lblCodigoCurso.setBounds(10, 21, 46, 14);
		panel_1.add(lblCodigoCurso);

		txtCodigoCurso = new JTextField();
		txtCodigoCurso.setEditable(false);
		txtCodigoCurso.setBounds(66, 18, 73, 20);
		panel_1.add(txtCodigoCurso);
		txtCodigoCurso.setColumns(10);

		lblAsignatura = new JLabel("Asignatura");
		lblAsignatura.setBounds(10, 54, 65, 14);
		panel_1.add(lblAsignatura);

		txtAsignatura = new JTextField();
		txtAsignatura.setEditable(false);
		txtAsignatura.setBounds(76, 51, 222, 20);
		panel_1.add(txtAsignatura);
		txtAsignatura.setColumns(10);

		lblNewLabel_2 = new JLabel("Cr\u00E9ditos");
		lblNewLabel_2.setBounds(238, 21, 60, 14);
		panel_1.add(lblNewLabel_2);

		txtCreditos = new JTextField();
		txtCreditos.setEditable(false);
		txtCreditos.setBounds(298, 18, 86, 20);
		panel_1.add(txtCreditos);
		txtCreditos.setColumns(10);

		lblNewLabel_3 = new JLabel("Ciclo");
		lblNewLabel_3.setBounds(308, 54, 46, 14);
		panel_1.add(lblNewLabel_3);

		txtCiclo = new JTextField();
		txtCiclo.setEditable(false);
		txtCiclo.setBounds(369, 51, 86, 20);
		panel_1.add(txtCiclo);
		txtCiclo.setColumns(10);

		lblNewLabel_4 = new JLabel("Horas");
		lblNewLabel_4.setBounds(409, 21, 46, 14);
		panel_1.add(lblNewLabel_4);

		txtHoras = new JTextField();
		txtHoras.setEditable(false);
		txtHoras.setBounds(465, 18, 78, 20);
		panel_1.add(txtHoras);
		txtHoras.setColumns(10);

		btnBuscarCurso = new JButton("Buscar");
		btnBuscarCurso.addActionListener(this);
		btnBuscarCurso.setBounds(149, 17, 79, 23);
		panel_1.add(btnBuscarCurso);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(10, 418, 89, 23);
		contentPane.add(btnNuevo);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 274, 553, 133);
		contentPane.add(scrollPane);

		tblMatricula = new JTable();
		tblMatricula.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblMatricula);
		// Establecer columnas
		model.addColumn("Número");
		model.addColumn("Cod-Alumno");
		model.addColumn("Cod-Curso");
		model.addColumn("Fecha");
		model.addColumn("Hora");

		tblMatricula.setModel(model);

		lblNewLabel_5 = new JLabel("Fecha");
		lblNewLabel_5.setBounds(10, 64, 46, 14);
		contentPane.add(lblNewLabel_5);

		txtFecha = new JTextField();
		txtFecha.setBounds(53, 61, 86, 20);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);

		lblNewLabel_6 = new JLabel("Hora");
		lblNewLabel_6.setBounds(162, 64, 46, 14);
		contentPane.add(lblNewLabel_6);

		txtHora = new JTextField();
		txtHora.setBounds(202, 61, 86, 20);
		contentPane.add(txtHora);
		txtHora.setColumns(10);

		// Imprimir fecha
		txtFecha.setText(sdf.format(fecha));
		txtHora.setText(sdfHora.format(fecha));

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(109, 418, 89, 23);
		contentPane.add(btnAdicionar);

		listar();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdicionar) {
			do_btnAdicionar_actionPerformed(e);
		}
		if (e.getSource() == btnNuevo) {
			do_btnNuevo_actionPerformed(e);
		}
		if (e.getSource() == btnBuscarCurso) {
			do_btnBuscarCurso_actionPerformed(e);
		}
		if (e.getSource() == btnBuscarAlumno) {
			do_btnBuscarAlumno_actionPerformed(e);
		}
	}

	protected void do_btnBuscarAlumno_actionPerformed(ActionEvent e) {
		FrmBuscarAlumno al = new FrmBuscarAlumno();
		al.setVisible(true);
		al.setLocationRelativeTo(this);
	}

	protected void do_btnBuscarCurso_actionPerformed(ActionEvent e) {
		FrmBuscarCurso c = new FrmBuscarCurso();
		c.setVisible(true);
		c.setLocationRelativeTo(this);
	}

	protected void do_btnNuevo_actionPerformed(ActionEvent e) {
		nuevaMatricula();
	}

	private void nuevaMatricula() {
		txtNumeroMatricula.setText("" + arregloMat.generarCodigo());
		txtCodigo.setText("");
		txtNombreAlumno.setText("");
		txtApellidos.setText("");
		txtEdad.setText("");
		txtDni.setText("");
		txtCodigoCurso.setText("");
		txtAsignatura.setText("");
		txtCiclo.setText("");
		txtCreditos.setText("");
		txtHoras.setText("");

	}

	protected void do_btnAdicionar_actionPerformed(ActionEvent e) {
		try {
			adicionar();
		} catch (Exception x) {
			mensajeError("Error de ingreso");
		}
	}

	private void adicionar() {
		String hora, fecha;
		int numMat, codAl, codCurs;

		numMat = getNumeroMatricula();
		codAl = getCodigoAlumno();
		codCurs = getCodigoCurso();
		hora = getHora();
		fecha = getFecha();

		// Ventana de confirmación
		int opcion;
		opcion = JOptionPane.showConfirmDialog(this, "Seguro de matricular", "Sistema", JOptionPane.YES_NO_OPTION);

		if (opcion == 0) {
			// Crear un objeto
			Matricula m = new Matricula(numMat, codAl, codCurs, fecha, hora);

			arregloMat.adicionar(m);
			arregloMat.guardarMatricula();
			listar();
		}

	}

	private void mensajeError(String mensj) {
		JOptionPane.showMessageDialog(this, mensj, "Error", 0);
	}

	private String getFecha() {
		return sdf.format(fecha);
	}

	private String getHora() {
		return sdfHora.format(fecha);
	}

	private int getCodigoCurso() {
		return Integer.parseInt(txtCodigoCurso.getText());
	}

	private int getCodigoAlumno() {
		return Integer.parseInt(txtCodigo.getText());
	}

	private int getNumeroMatricula() {
		return Integer.parseInt(txtNumeroMatricula.getText());
	}

	void listar() {
		// Paso 1: Limpiar la tabla
		model.setRowCount(0);
		// Paso 2: Bucle
		for (int i = 0; i < arregloMat.tamanio(); i++) {
			Object fila[] = { arregloMat.obtener(i).getNumMatricula(), arregloMat.obtener(i).getCodAlumno(),
					arregloMat.obtener(i).getCodCurso(), arregloMat.obtener(i).getFecha(),
					arregloMat.obtener(i).getHora(), };
			model.addRow(fila);
		}
	}

}
