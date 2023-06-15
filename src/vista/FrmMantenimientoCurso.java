package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ArregloCurso;
import entidad.Curso;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class FrmMantenimientoCurso extends JFrame implements ActionListener, MouseListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblCodigoCurso;
	private JLabel lblAsignatura;
	private JTextField txtCodigo;
	private JTextField txtAsignatura;
	private JLabel lblCreditos;
	private JLabel lblHoras;
	private JTextField txtCreditos;
	private JTextField txtHoras;
	private JLabel lblCiclo;
	private JComboBox<Object> cboCiclo;
	private JPanel panel;
	private JButton btnConsultar;
	private JTable tblCurso;
	private JScrollPane scrollPane;
	private JButton btnNuevo;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	
	//Clase para asignar un modelo a la tabla
	DefaultTableModel model = new DefaultTableModel();
	//Instanciar objeto
	ArregloCurso arregloCur = new ArregloCurso();
	private JLabel lblAsig;
	private JTextField txtBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMantenimientoCurso frame = new FrmMantenimientoCurso();
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
	public FrmMantenimientoCurso() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 792, 643);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Mantenimiento de Curso");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 756, 58);
		contentPane.add(lblNewLabel);
		
		lblCodigoCurso = new JLabel("C\u00F3digo");
		lblCodigoCurso.setBounds(10, 80, 64, 14);
		contentPane.add(lblCodigoCurso);
		
		lblAsignatura = new JLabel("Asignatura");
		lblAsignatura.setBounds(10, 105, 64, 14);
		contentPane.add(lblAsignatura);
		
		txtCodigo = new JTextField();
		txtCodigo.addKeyListener(this);
		txtCodigo.setBounds(84, 77, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtAsignatura = new JTextField();
		txtAsignatura.addKeyListener(this);
		txtAsignatura.setBounds(84, 102, 293, 20);
		contentPane.add(txtAsignatura);
		txtAsignatura.setColumns(10);
		
		lblCreditos = new JLabel("Cr\u00E9ditos");
		lblCreditos.setBounds(387, 80, 64, 14);
		contentPane.add(lblCreditos);
		
		lblHoras = new JLabel("Horas");
		lblHoras.setBounds(387, 105, 64, 14);
		contentPane.add(lblHoras);
		
		txtCreditos = new JTextField();
		txtCreditos.addKeyListener(this);
		txtCreditos.setBounds(461, 77, 86, 20);
		contentPane.add(txtCreditos);
		txtCreditos.setColumns(10);
		
		txtHoras = new JTextField();
		txtHoras.addKeyListener(this);
		txtHoras.setBounds(461, 102, 86, 20);
		contentPane.add(txtHoras);
		txtHoras.setColumns(10);
		
		lblCiclo = new JLabel("Ciclo");
		lblCiclo.setBounds(599, 80, 46, 14);
		contentPane.add(lblCiclo);
		
		cboCiclo = new JComboBox<Object>();
		cboCiclo.setModel(new DefaultComboBoxModel<Object>(new String[] {"Primer ciclo", "Segundo ciclo", "Tercer ciclo", "Cuarto ciclo", "Quinto ciclo", "Sexto ciclo"}));
		cboCiclo.setBounds(655, 76, 111, 22);
		contentPane.add(cboCiclo);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Consultar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 130, 756, 89);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(530, 35, 216, 23);
		panel.add(btnConsultar);
		
		lblAsig = new JLabel("Asignatura");
		lblAsig.setBounds(122, 39, 62, 14);
		panel.add(lblAsig);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(194, 35, 241, 22);
		panel.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 230, 756, 266);
		contentPane.add(scrollPane);
		
		tblCurso = new JTable();
		tblCurso.addKeyListener(this);
		tblCurso.addMouseListener(this);
		tblCurso.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblCurso);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(10, 570, 89, 23);
		contentPane.add(btnNuevo);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(109, 570, 89, 23);
		contentPane.add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(207, 570, 89, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(677, 570, 89, 23);
		contentPane.add(btnEliminar);
		
		//Agregar columnas a la tabla
		model.addColumn("Código");
		model.addColumn("Asignatura");
		model.addColumn("Ciclo");
		model.addColumn("Créditos");
		model.addColumn("Horas");
		//Asignar el modelo a la tabla
		tblCurso.setModel(model);
		
		listar();
		
		mostrarDatos(0);
	}

	void listar() {
		model.setRowCount(0);
		for (int i = 0; i < arregloCur.tamanio(); i++) {
			Object fila [] = {arregloCur.obtener(i).getCodCurso(),
							  arregloCur.obtener(i).getAsignatura(),
							  arregloCur.obtener(i).nombreCiclo(),
							  arregloCur.obtener(i).getCreditos(),
							  arregloCur.obtener(i).getHoras(),		  
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
		nuevoCurso();
	}
	
	private void nuevoCurso() {
		txtCodigo.setText("");
		txtAsignatura.setText("");
		cboCiclo.setSelectedIndex(0);
		txtCreditos.setText("");
		txtHoras.setText("");
		txtCodigo.requestFocus();
		txtCodigo.setEnabled(true);
	}
	
	protected void do_btnAdicionar_actionPerformed(ActionEvent e) {
		try {
			adicionarNuevoCurso();
		}
		catch (Exception x) {
			mensajeError("Error de ingreso");
		}
	}
	
	private void adicionarNuevoCurso() {
		int codigo, ciclo, creditos, horas;
		String asignatura;
		codigo = getCodCurso();
		asignatura = getAsignatura();
		ciclo = getCiclo();
		creditos = getCreditos();
		horas = getHoras();
		if(codigo == -1 || asignatura == null || ciclo == -1 || creditos == -1 || horas == -1) {		
		} else {
			int opcion;
			opcion = JOptionPane.showConfirmDialog(this, "Seguro de adicionar", "Sistema", JOptionPane.YES_NO_OPTION);
			if(opcion == 0) {
			Curso bean = arregloCur.buscar(codigo);
			if(bean == null) {
			Curso c = new Curso(codigo, asignatura, ciclo, creditos, horas);
			arregloCur.adicionar(c);
			arregloCur.guardarCurso();
			listar();
			} else {
				mensajeError("Error, el código ya está registrado");
				}
			}
		}
		
	}

	private void mensajeError(String mensj) {
		JOptionPane.showMessageDialog(this, mensj, "Error", 0);
		
	}

	private int getHoras() {
		int horas = -1;
		horas = Integer.parseInt(txtHoras.getText());
		return horas;
	}

	private int getCreditos() {
		int cred = -1;
		cred = Integer.parseInt(txtCreditos.getText());
		return cred;
	}

	private int getCiclo() {
		return cboCiclo.getSelectedIndex();
	}

	private String getAsignatura() {
		String asig = null;
		asig = txtAsignatura.getText();
		if(txtAsignatura.getText().length() == 0)
			mensajeError("Ingrese asignatura");
		else {

		}
		return asig;
	}

	private int getCodCurso() {
		int codcur = -1;
		codcur = Integer.parseInt(txtCodigo.getText());
		return codcur;
	}
	
	void mostrarDatos(int fila) {
		if(fila != -1) {
		String cod, asig, ciclo, cred, horas;
		cod = tblCurso.getValueAt(fila, 0).toString();
		asig = tblCurso.getValueAt(fila, 1).toString();
		ciclo = tblCurso.getValueAt(fila, 2).toString();	
		cred = tblCurso.getValueAt(fila, 3).toString();
		horas = tblCurso.getValueAt(fila, 4).toString();
		txtCodigo.setText(cod);
		txtAsignatura.setText(asig);
		cboCiclo.setSelectedItem(ciclo);
		txtCreditos.setText(cred);
		txtHoras.setText(horas);	
		txtCodigo.setEnabled(false);
		}
	}
	
	/*
	*/
	
	protected void do_btnModificar_actionPerformed(ActionEvent e) {
		actualizarCurso();
	}
	
	private void actualizarCurso() {
		int codigo, creditos, horas, ciclo;
		String asignatura;
		codigo = getCodCurso();
		asignatura = getAsignatura();
		ciclo = getCiclo();
		creditos = getCreditos();
		horas = getHoras();	
		if(codigo == -1 || asignatura == null || ciclo == -1 || creditos == -1 || horas == -1 ) {
			
		} else {
			Curso bean = arregloCur.buscar(codigo);
			if(bean != null) {
			int opcion;
			opcion = JOptionPane.showConfirmDialog(this, "Seguro de actualizar", "Sistema", JOptionPane.YES_NO_OPTION);
			if(opcion == 0) {
			bean.setCodCurso(codigo);
			bean.setAsignatura(asignatura);
			bean.setCreditos(creditos);
			bean.setHoras(horas);
			bean.setCiclo(ciclo);
			listar();
			}
		}	else {
			mensajeError("Código del curso no existe");
			}
		}
	}

	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		eliminarCurso();
	}

	private void eliminarCurso() {
		if(getCiclo() == 0) {
			Curso c = arregloCur.buscar(getCodCurso());
			if(c != null) {
				int opcion = JOptionPane.showConfirmDialog(this, "Seguro de eliminar", "Sistema", JOptionPane.YES_NO_OPTION);
				if(opcion == 0) {
					arregloCur.eliminar(c);
					listar();
				}
			} else {
				mensajeError("Código del curso no existe");
			}
		} else {
			mensajeError("No se puede eliminar");
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
		if (e.getSource() == tblCurso) {
			do_tblCurso_mouseReleased(e);
		}
	}
	protected void do_tblCurso_mouseReleased(MouseEvent e) {
		int fila;
		fila = tblCurso.getSelectedRow();
		mostrarDatos(fila);
		}
		
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tblCurso) {
			do_tblCurso_keyReleased(e);
		}
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtHoras) {
			do_txtHoras_keyTyped(e);
		}
		if (e.getSource() == txtCreditos) {
			do_txtCreditos_keyTyped(e);
		}
		if (e.getSource() == txtAsignatura) {
			do_txtAsignatura_keyTyped(e);
		}
		if (e.getSource() == txtCodigo) {
			do_txtCodigo_keyTyped(e);
		}
	}
	protected void do_tblCurso_keyReleased(KeyEvent e) {
		int fila;
		fila = tblCurso.getSelectedRow();
		mostrarDatos(fila);
	}
	
	protected void do_txtCodigo_keyTyped(KeyEvent e) {
		bloquearLetras(e);
		cuatroDigitos(e);
	}
	
	protected void do_txtAsignatura_keyTyped(KeyEvent e) {
		bloquearNumeros(e);
	}
	
	protected void do_txtCreditos_keyTyped(KeyEvent e) {
		bloquearLetras(e);
	}
	
	protected void do_txtHoras_keyTyped(KeyEvent e) {
		bloquearLetras(e);
	}
	
	void bloquearLetras(KeyEvent xarg0) {
		char c = xarg0.getKeyChar();
		if(!Character.isDigit(c)) {
			getToolkit().beep();
			xarg0.consume();
		}
	}
	
	void cuatroDigitos(KeyEvent xarg0) {
		if(txtCodigo.getText().length() >= 4) { 
			getToolkit().beep();
			xarg0.consume();
		}
	}
	
	void bloquearNumeros(KeyEvent xarg0) {
		char c = xarg0.getKeyChar();
		if(Character.isDigit(c)) {
			getToolkit().beep();
			xarg0.consume();
		}
	}
	
	protected void do_btnConsultar_actionPerformed(ActionEvent e) {
		String datoBuscar;
		datoBuscar = getDatoBuscar();
		consultar(0, datoBuscar);
	}
	
	private String getDatoBuscar() {
		return txtBuscar.getText();
	}
	
	public void consultar(int tipoConsulta, String datoBuscar) {
		model.setRowCount(0);
		for (int i = 0; i < arregloCur.tamanio(); i++) {
			Curso c = arregloCur.obtener(i);
				if(c.getAsignatura().startsWith(datoBuscar)) {
					Object fila [] = { c.getCodCurso(),
									   c.getAsignatura(),
									   c.nombreCiclo(),
									   c.getCreditos(),
									   c.getHoras(),
									};
					model.addRow(fila);
				}
		}
	}
}
