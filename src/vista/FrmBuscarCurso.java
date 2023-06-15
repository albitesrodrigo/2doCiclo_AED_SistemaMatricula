package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ArregloCurso;
import entidad.Curso;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class FrmBuscarCurso extends JFrame implements KeyListener, ActionListener, ItemListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnEnviarDatos;
	private JTable tblCurso;
	private JScrollPane scrollPane;
	
	//Clase para asignar un modelo a la tabla
	DefaultTableModel model = new DefaultTableModel();
	//Instanciar objeto
	ArregloCurso arregloCur = new ArregloCurso();
	private JComboBox<Object> cboCiclo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmBuscarCurso frame = new FrmBuscarCurso();
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
	public FrmBuscarCurso() {
		setTitle("Buscar Curso");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 570, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("BUSCAR CURSO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel.setBackground(SystemColor.desktop);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 534, 27);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Ciclo :");
		lblNewLabel_1.setBounds(10, 49, 55, 14);
		contentPane.add(lblNewLabel_1);
		
		btnEnviarDatos = new JButton("Enviar Datos");
		btnEnviarDatos.addActionListener(this);
		btnEnviarDatos.setBounds(430, 45, 114, 23);
		contentPane.add(btnEnviarDatos);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 74, 534, 176);
		contentPane.add(scrollPane);
		
		tblCurso = new JTable();
		tblCurso.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblCurso);
		//Agregar columnas a la tabla
			model.addColumn("Código");
			model.addColumn("Asignatura");
			model.addColumn("Ciclo");
			model.addColumn("Créditos");
			model.addColumn("Horas");
		//Asignar el modelo a la tabla
			tblCurso.setModel(model);
			
			cboCiclo = new JComboBox<Object>();
			cboCiclo.addItemListener(this);
			cboCiclo.setModel(new DefaultComboBoxModel<Object>(new String[] {"Seleccionar ciclo", "Primer ciclo", "Segundo ciclo", "Tercer ciclo", "Cuarto ciclo", "Quinto ciclo", "Sexto ciclo"}));
			cboCiclo.setBounds(47, 45, 224, 18);
			contentPane.add(cboCiclo);
	}
	
	public void consultar(int ciclo) {
		//Limpiar la tabla
		model.setRowCount(0);
		//Bucle
		for (int i = 0; i < arregloCur.tamanio(); i++) {
			Curso c = arregloCur.obtener(i);			
				if(c.getCiclo() == ciclo - 1) {
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
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEnviarDatos) {
			do_btnEnviarDatos_actionPerformed(e);
		}
	}
	
	protected void do_btnEnviarDatos_actionPerformed(ActionEvent e) {
		//Variable
		int fila;
		String cod, asig, ciclo, cred, horas;
		//Obtener la posición de la fila seleccionada
		fila = tblCurso.getSelectedRow();
		//Obtener los valores de la fila seleccionada
		cod = tblCurso.getValueAt(fila, 0).toString();
		asig = tblCurso.getValueAt(fila, 1).toString();
		ciclo = tblCurso.getValueAt(fila, 2).toString();
		cred = tblCurso.getValueAt(fila, 3).toString();
		horas = tblCurso.getValueAt(fila, 4).toString();
		//Mostrar los valores en las cajas de texto
		FrmMatricula.txtCodigoCurso.setText(cod);
		FrmMatricula.txtAsignatura.setText(asig);
		FrmMatricula.txtCiclo.setText(ciclo);
		FrmMatricula.txtCreditos.setText(cred);
		FrmMatricula.txtHoras.setText(horas);
		//Cerrar ventana
		dispose();
		
	}
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboCiclo) {
			do_cboCiclo_itemStateChanged(e);
		}
	}
	
	protected void do_cboCiclo_itemStateChanged(ItemEvent e) {
		consultar(cboCiclo.getSelectedIndex());
	}
}
