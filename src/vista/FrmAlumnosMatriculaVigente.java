package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ArregloAlumno;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmAlumnosMatriculaVigente extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea txtReporte;
	private JScrollPane scrollPane;
	private JButton btnReporte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAlumnosMatriculaPendiente frame = new FrmAlumnosMatriculaPendiente();
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
	public FrmAlumnosMatriculaVigente() {
		setAlwaysOnTop(true);
		setTitle("Reporte | Alumnos con Matricula Vigente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 296);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 44, 414, 206);
		contentPane.add(scrollPane);
		
		txtReporte = new JTextArea();
		scrollPane.setViewportView(txtReporte);
		
		btnReporte = new JButton("Reporte");
		btnReporte.addActionListener(this);
		btnReporte.setBounds(10, 11, 414, 23);
		contentPane.add(btnReporte);
	}
	
	ArregloAlumno arAlu = new ArregloAlumno();

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReporte) {
			actionPerformedBtnReporte(e);
		}
	}
	protected void actionPerformedBtnReporte(ActionEvent e) {
		txtReporte.setText("");
		for(int i = 0; i< arAlu.tamanio(); i++ )
			if(arAlu.obtener(i).getEstado() ==0) {
				imprimir(" CÓDIGO    : " + arAlu.obtener(i).getCodAlumno());
				imprimir(" NOMBRES   : " + arAlu.obtener(i).getNombres());
				imprimir(" APELLIDOS : " + arAlu.obtener(i).getApellidos());
				imprimir(" DNI       : " + arAlu.obtener(i).getDni());
				imprimir(" EDAD      : " + arAlu.obtener(i).getEdad());
				imprimir(" CELULAR   : " + arAlu.obtener(i).getCelular());
				imprimir(" ESTADO    : " + estado(arAlu.obtener(i).getEstado()));
				imprimir("-------------------------------------------------------------------------");			
			}			
	}
	
	String estado(int i) {
		switch (i) {
		case 0: return "REGISTRADO";
		case 1: return "MATRICULADO";
		case 2: return "RETIRADO";
		default: return null;
		}
	}

	private void imprimir(String cad) {
		txtReporte.append(cad + "\n");
		
	}
}
