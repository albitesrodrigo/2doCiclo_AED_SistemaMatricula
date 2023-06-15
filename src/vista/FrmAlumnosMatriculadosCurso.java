package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ArregloAlumno;
import controlador.ArregloCurso;
import controlador.ArregloMatricula;
import entidad.Matricula;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmAlumnosMatriculadosCurso extends JFrame implements ActionListener {

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
	public FrmAlumnosMatriculadosCurso() {
		setAlwaysOnTop(true);
		setTitle("Reporte | Alumnos Matriculados por Curso");
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
	ArregloCurso arCurso = new ArregloCurso();
	ArregloMatricula arMatricula = new ArregloMatricula();
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReporte) {
			actionPerformedBtnReporte(e);
		}
	}

	protected void actionPerformedBtnReporte(ActionEvent e) {
		txtReporte.setText("");
	for (int i = 0; i < arCurso.tamanio(); i++) {
		boolean x = false;
		imprimir(" " + arCurso.obtener(i).getAsignatura());
		imprimir("");
		int CodCurso = arCurso.obtener(i).getCodCurso();
		for (int j = 0; j < arMatricula.tamanio(); j++) {
			Matricula m = arMatricula.obtener(j);
			if (m.getCodCurso() == CodCurso) {
				int estado = arAlu.buscar(m.getCodAlumno()).getEstado();
				if (estado == 1) {
					if (!x) x = true;
					imprimir(" * ALUMNO : " + arAlu.buscar(m.getCodAlumno()).getNombres() +
							" " + arAlu.buscar(m.getCodAlumno()).getApellidos());
				}
			}
		}
		if (!x) 
			imprimir(" NO EXISTEN ALUMNOS MATRICULADOS EN ESTE CURSO");
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