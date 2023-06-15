package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ArregloAlumno;
import entidad.Alumno;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class FrmMantenimientoAlumno extends JFrame implements ActionListener, MouseListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblMantenimientoAlumno;
	private JLabel lblCodigo;
	private JTextField txtCodigo;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblApellido;
	private JTextField txtApellido;
	private JLabel lblDNI;
	private JTextField txtDni;
	private JLabel lblEdad;
	private JTextField txtEdad;
	private JLabel lblCelular;
	private JTextField txtCelular;
	private JLabel lblEstado;
	private JComboBox<Object> cboEstado;
	private JTable tblAlumnos;
	private JScrollPane scrollPane;
	
	//Clase para asignar un modelo a la tabla
	DefaultTableModel model = new DefaultTableModel();
	private JButton btnNuevo;

	//Instanciar objeto
	ArregloAlumno arregloAl = new ArregloAlumno();
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JPanel panel;
	private JRadioButton rdbtnDNI;
	private JRadioButton rdbtnApellidos;
	private JTextField txtBuscar;
	private JButton btnConsultar;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMantenimientoAlumno frame = new FrmMantenimientoAlumno();
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
	public FrmMantenimientoAlumno() {
		setResizable(false);
		setTitle("Mantenimiento | Alumno");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 623, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblMantenimientoAlumno = new JLabel("Mantenimiento de Alumno");
		lblMantenimientoAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantenimientoAlumno.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblMantenimientoAlumno.setForeground(Color.WHITE);
		lblMantenimientoAlumno.setBackground(Color.BLACK);
		lblMantenimientoAlumno.setOpaque(true);
		lblMantenimientoAlumno.setBounds(10, 11, 597, 58);
		contentPane.add(lblMantenimientoAlumno);
		
		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setBounds(437, 79, 55, 14);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(508, 80, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 79, 46, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(this);
		txtNombre.setBounds(66, 80, 113, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(220, 80, 46, 14);
		contentPane.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.addKeyListener(this);
		txtApellido.setColumns(10);
		txtApellido.setBounds(276, 80, 113, 20);
		contentPane.add(txtApellido);
		
		lblDNI = new JLabel("DNI");
		lblDNI.setBounds(447, 107, 25, 14);
		contentPane.add(lblDNI);
		
		txtDni = new JTextField();
		txtDni.addKeyListener(this);
		txtDni.setColumns(10);
		txtDni.setBounds(508, 104, 86, 20);
		contentPane.add(txtDni);
		
		lblEdad = new JLabel("Edad");
		lblEdad.setBounds(10, 107, 46, 14);
		contentPane.add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.addKeyListener(this);
		txtEdad.setColumns(10);
		txtEdad.setBounds(66, 104, 55, 20);
		contentPane.add(txtEdad);
		
		lblCelular = new JLabel("Celular");
		lblCelular.setBounds(220, 107, 46, 14);
		contentPane.add(lblCelular);
		
		txtCelular = new JTextField();
		txtCelular.addKeyListener(this);
		txtCelular.setColumns(10);
		txtCelular.setBounds(276, 104, 113, 20);
		contentPane.add(txtCelular);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(446, 132, 46, 14);
		contentPane.add(lblEstado);
		
		cboEstado = new JComboBox<Object>();
		cboEstado.setModel(new DefaultComboBoxModel<Object>(new String[] {"Registrado", "Matriculado", "Retirado"}));
		cboEstado.setBounds(491, 128, 103, 22);
		contentPane.add(cboEstado);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 278, 597, 223);
		contentPane.add(scrollPane);
		
		tblAlumnos = new JTable();
		tblAlumnos.addKeyListener(this);
		tblAlumnos.addMouseListener(this);
		tblAlumnos.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblAlumnos);
		//Agregar columnas a la tabla
		model.addColumn("Código");
		model.addColumn("Nombre");
		model.addColumn("Apellidos");
		model.addColumn("DNI");
		model.addColumn("Edad");
		model.addColumn("Celular");
		model.addColumn("Estado");
		//Asignar el modelo a la tabla
		tblAlumnos.setModel(model);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(10, 512, 89, 23);
		contentPane.add(btnNuevo);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(109, 512, 89, 23);
		contentPane.add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(208, 512, 89, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(518, 512, 89, 23);
		contentPane.add(btnEliminar);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Consultar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 157, 597, 110);
		contentPane.add(panel);
		panel.setLayout(null);
		
		rdbtnDNI = new JRadioButton("DNI");
		buttonGroup.add(rdbtnDNI);
		rdbtnDNI.setBounds(25, 35, 109, 23);
		panel.add(rdbtnDNI);
		
		rdbtnApellidos = new JRadioButton("Apellidos");
		buttonGroup.add(rdbtnApellidos);
		rdbtnApellidos.setBounds(136, 35, 109, 23);
		panel.add(rdbtnApellidos);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(251, 36, 206, 20);
		panel.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(498, 35, 89, 23);
		panel.add(btnConsultar);
	
		listar();
		
		//MOSTRAR DATA EN LAS CAJAS DE TEXTO
		mostrarDatos(0);
	}
	
	//Método listar
	void listar() {
		//Paso 1: Limpiar la tabla
		model.setRowCount(0);
		//Paso 2: Bucle
		for (int i = 0; i < arregloAl.tamanio(); i++) {
			Object fila [] = {arregloAl.obtener(i).getCodAlumno(),
							  arregloAl.obtener(i).getNombres(),
							  arregloAl.obtener(i).getApellidos(),
							  arregloAl.obtener(i).getDni(),
							  arregloAl.obtener(i).getEdad(),
							  arregloAl.obtener(i).getCelular(),
							  arregloAl.obtener(i).nombreEstado(),
			};
			model.addRow(fila);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultar) {
			do_btnConsultar_actionPerformed(e);
		}
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(e);
		}
		if (e.getSource() == btnModificar) {
			do_btnModificar_actionPerformed(e);
		}
		if (e.getSource() == btnAdicionar) {
			do_btnAdicionar_actionPerformed(e);
		}
		if (e.getSource() == btnNuevo) {
			do_btnNuevo_actionPerformed(e);
		}
	}
	
	protected void do_btnNuevo_actionPerformed(ActionEvent e) {
		nuevoAlumno();
	}
	
	private void nuevoAlumno() {
		txtNombre.setText("");
		txtApellido.setText("");
		txtDni.setText("");
		txtEdad.setText("");
		txtCelular.setText("");
		//Mostrar codigo
		txtCodigo.setText("" + arregloAl.generarCodigo());
		txtNombre.requestFocus();
		cboEstado.setSelectedIndex(0);
		cboEstado.setEnabled(false);
		txtDni.setEnabled(true);
	}
	
	protected void do_btnAdicionar_actionPerformed(ActionEvent e) {
		try {
			adicionarNuevoAlumno();
		}
		catch (Exception x) {
			mensajeError("Error de ingreso");
		}
	}
	
	private void adicionarNuevoAlumno() {
		//Paso 1: Declarar variables para almacenar los  valores ingresados en la GUI
		int codigo, edad, celular, estado;
		String nombre, apellido, dni;
		//Paso 2: Obtener los valores
		codigo = getCodigo();
		nombre = getNombre();
		apellido = getApellido();
		dni = getDni();
		edad = getEdad();
		celular = getCelular();
		estado = getEstado();
		//Validar 
		if(nombre == null || apellido == null || codigo ==-1 || dni == null || edad == -1 || celular == -1 || estado == -1) {
			//mensajeError("No se realizó registro");
		} else {	
			//Mostrar ventana de confirmación
			int opcion;
			opcion = JOptionPane.showConfirmDialog(this, "Seguro de adicionar", "Sistema", JOptionPane.YES_NO_OPTION);
			if(opcion == 0) { //Si
			//Validar si el DNI existe en el arreglo
			Alumno bean = arregloAl.buscarDni(dni);
			if(bean == null) { //El DNI no existe
			//Paso 3: Crear un objeto de la clase "Alumno" con los valores obtenidos
			Alumno a = new Alumno(codigo, nombre, apellido, dni, edad, celular, estado);
			//Paso 4: Invocar al método ADICIONAR y enviar el objeto "a"
			arregloAl.adicionar(a);
			arregloAl.guardarAlumno();
			//paso 5: Mostrar la info en la tabla
			listar();
			}  else {
				//DNI si existe
				mensajeError("Error DNI ya está registrado");
				}
			}		
		}
	}

	private int getEstado() {
		return cboEstado.getSelectedIndex();
	}

	private int getCelular() {
		int cel = -1;
		cel = Integer.parseInt(txtCelular.getText());
		if(txtCelular.getText().length() == 0)
			mensajeError("Ingresa celular");
		else {
			cel = Integer.parseInt(txtCelular.getText());
		}
		return cel;
	}

	private int getEdad() {
		int edad = -1;
		edad = Integer.parseInt(txtEdad.getText());
		return edad;
	}

	private String getDni() {
		String dni = null;
		dni = txtDni.getText();
		//Validar campo vacío
		if(txtDni.getText().length() == 0)
			mensajeError("Ingresar el DNI");
		else {
			dni = txtDni.getText();
				}	
		return dni;
	}

	private String getApellido() {
		String ape = null;
		ape = txtApellido.getText();
		//Validar campo vacío
		if(txtApellido.getText().length() == 0)
			mensajeError("Ingresar el apellido");
		else {
			ape = txtApellido.getText();
				}	
		return ape;
	}

	private String getNombre() {
		String nomb = null;
		nomb = txtNombre.getText();
		//Validar campo vacío
		if(txtNombre.getText().length() == 0)
			mensajeError("Ingresar el nombre");
		else {
			nomb = txtNombre.getText();
		}	
		return nomb;
	}

	private void mensajeError(String mensj) {
		JOptionPane.showMessageDialog(this, mensj, "Error", 0);	
	}

	private int getCodigo() {
		int cod = -1;
		cod = Integer.parseInt(txtCodigo.getText());
		return cod;
	}
	
	void mostrarDatos(int fila) {
		if(fila != -1) {
		//Paso 1: Declarar variables
		String cod, nomb, apell, dni, edad, celular, estado;
		//Obtener los valores de la fila seleccionada
		//getValueAt(row, colum)
		//Paso 2: Obtener los valores de la tabla
		cod = tblAlumnos.getValueAt(fila, 0).toString(); //0 REPRESENTA a la columna código
		nomb = tblAlumnos.getValueAt(fila, 1).toString(); //1 REPRESENTA a la columna nombre
		apell = tblAlumnos.getValueAt(fila, 2).toString(); //2 REPRESENTA a la columna apellido
		dni = tblAlumnos.getValueAt(fila, 3).toString(); //3 REPRESENTA a la columna dni
		edad = tblAlumnos.getValueAt(fila, 4).toString(); //4 REPRESENTA a la columna edad
		celular = tblAlumnos.getValueAt(fila, 5).toString(); //5 REPRESENTA a la columna celular
		estado = tblAlumnos.getValueAt(fila, 6).toString(); //6 REPRESENTA a la columna estado
		
		//Paso 3: Mostrar los datos obtenidos de la tabla en las cajas de texto
		txtCodigo.setText(cod);
		txtNombre.setText(nomb);
		txtApellido.setText(apell);
		txtDni.setText(dni);
		txtEdad.setText(edad);
		txtCelular.setText(celular);
		cboEstado.setSelectedItem(estado);
		
		txtDni.setEnabled(false);
		}
	}

	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
		if (e.getSource() == tblAlumnos) {
			do_tblAlumnos_mouseReleased(e);
		}
	}
	
	protected void do_tblAlumnos_mouseReleased(MouseEvent e) {
		int fila; 
		fila = tblAlumnos.getSelectedRow();
		mostrarDatos(fila);
	}

	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tblAlumnos) {
			do_tblAlumnos_keyReleased(e);
		}
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtDni) {
			do_txtDni_keyTyped(e);
		}
		if (e.getSource() == txtCelular) {
			do_txtCelular_keyTyped(e);
		}
		if (e.getSource() == txtEdad) {
			do_txtEdad_keyTyped(e);
		}
		if (e.getSource() == txtNombre) {
			do_txtNombre_keyTyped(e);
		}
		if (e.getSource() == txtApellido) {
			do_txtApellido_keyTyped(e);
		}
	}
	
	protected void do_tblAlumnos_keyReleased(KeyEvent e) {
		int fila;
		fila = tblAlumnos.getSelectedRow();
		mostrarDatos(fila);
	}
	
	protected void do_btnModificar_actionPerformed(ActionEvent e) {
		try {
			actualizarAlumno();
		}
		catch (Exception x) {
			mensajeError("No modificado");
		}
		
	}

	private void actualizarAlumno() {
		//Paso 1: Declarar variables para almacenar los  valores ingresados en la GUI
		int codigo, edad, celular, estado;
		String nombre, apellido, dni;
		//Paso 2: Obtener los valores
		codigo = getCodigo();
		nombre = getNombre();
		apellido = getApellido();
		dni = getDni();
		edad = getEdad();
		celular = getCelular();
		estado = getEstado();
		//Validar 
		if(nombre == null || apellido == null || codigo ==-1 || dni == null || edad == -1 || celular == -1 || estado == -1) {
			//mensajeError("No se realizó registro");
			} else {
				//Actualizar => Buscar al alumno por código
				Alumno bean = arregloAl.buscar(codigo);
				//Validar si el alumno existe
				if(bean != null) { //El alumno existe por su código
				//Mostrar ventana de confirmación
				int opcion;
				opcion = JOptionPane.showConfirmDialog(this, "Seguro de actualizar", "Sistema", JOptionPane.YES_NO_OPTION);
				if(opcion == 0) { //Si										
				//Paso 3: Setear los atributos del objeto alumno
				bean.setNombres(nombre);
				bean.setApellidos(apellido);
				bean.setDni(dni);
				bean.setEdad(edad);
				bean.setCelular(celular);
				bean.setEstado(estado);
				//paso 4 : Mostrar la info en la tabla
				listar();					
				}				
			} else {
				mensajeError("Código del alumno no existe");
			}
		}			
	}
	
	protected void do_txtApellido_keyTyped(KeyEvent e) {
		bloquearNumeros(e);
	}
	protected void do_txtNombre_keyTyped(KeyEvent e) {
		bloquearNumeros(e);
	}
	protected void do_txtEdad_keyTyped(KeyEvent e) {
		bloquearLetras(e);
		tresDigitos(e);
	}
	protected void do_txtCelular_keyTyped(KeyEvent e) {
		bloquearLetras(e);
		nueveDigitos(e);
	}
	protected void do_txtDni_keyTyped(KeyEvent e) {
		bloquearLetras(e);
		ochoDigitos(e);
	}
	//Método para bloquear números
	void bloquearNumeros(KeyEvent xarg0) {
		char num = xarg0.getKeyChar();
		if(Character.isDigit(num)) {
			getToolkit().beep();
			xarg0.consume();
			mensajeError("Ingresar solo letras");
		}
	}
	
	void bloquearLetras(KeyEvent xarg0) {
		char c = xarg0.getKeyChar();
		if(!Character.isDigit(c)) {
			getToolkit().beep();
			xarg0.consume();
		}
	}
	
	void nueveDigitos(KeyEvent xarg0) {
		if(txtCelular.getText().length() >= 9) { 
			getToolkit().beep();
			xarg0.consume();
		}
	}
	
	void ochoDigitos(KeyEvent xarg0) {
		if(txtDni.getText().length() >= 8) { 
			getToolkit().beep();
			xarg0.consume();
		}
	}
	
	void tresDigitos(KeyEvent xarg0) {
		if(txtEdad.getText().length() >= 3) { 
			getToolkit().beep();
			xarg0.consume();
		}
	}
	
	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		eliminarAlumno();
	}

	private void eliminarAlumno() {
		//Validar si el estado es 0
		if(getEstado() == 0) {//Estado es REGISTRADO
		//Paso 1: Buscar al alumno por código
		Alumno a = arregloAl.buscar(getCodigo());
		//Paso 2: Validar si el alumno existe
		if(a != null) {//El alumno existe
			//Mostrar una ventana de confirmación
			int opcion = JOptionPane.showConfirmDialog(this, "Seguro de eliminar", "Sistema", JOptionPane.YES_NO_OPTION);
			
			if(opcion == 0) {//Opción 0 = yes --Si
				arregloAl.eliminar(a);	
				//Actualizar la tabla
				listar();
			}
		} else {
			mensajeError("Código de alumno no existe");
			}
		} else {
			mensajeError("No se puede eliminar porque el estado es diferente a REGISTRADO");
		}
	} 
	
	protected void do_btnConsultar_actionPerformed(ActionEvent e) {
		//VARIABLES
		int tipoConsulta = 0;
		String datoBuscar;
		//Validar la selección del radio
		if(rdbtnDNI.isSelected() == true)
			tipoConsulta = 1;
		if(rdbtnApellidos.isSelected() == true)
			tipoConsulta = 2;
		
		//Obtener dato a buscar en consulta
		datoBuscar = getDatoBuscar();
		
		//Invocar al método de consulta
		consultar(tipoConsulta, datoBuscar);
	}
	
	private String getDatoBuscar() {	
		return txtBuscar.getText();
	}

	//Método para consultar
	public void consultar(int tipoConsulta, String datoBuscar) {
		//Limpiar la tabla
		model.setRowCount(0);
		//Bucle
		for (int i = 0; i < arregloAl.tamanio(); i++) {
			Alumno a = arregloAl.obtener(i);
			//Realizar la consulta (Según sea DNI/APELLIDOS
			if(tipoConsulta == 1) {//DNI
				if(a.getDni().startsWith(datoBuscar)) {
					Object fila [] = { a.getCodAlumno(),
									   a.getNombres(),
									   a.getApellidos(),
									   a.getDni(),
									   a.getEdad(),
									   a.getCelular(),
									   a.nombreEstado(),							
									};
					model.addRow(fila);
				}
			} else {//APELLIDO
				if(a.getApellidos().startsWith(datoBuscar)) {
					Object fila [] = { a.getCodAlumno(),
									   a.getNombres(),
									   a.getApellidos(),
									   a.getDni(),
									   a.getEdad(),
									   a.getCelular(),
									   a.nombreEstado(),							
									};
					model.addRow(fila);
				}
			}
		}
	}	
	
}
