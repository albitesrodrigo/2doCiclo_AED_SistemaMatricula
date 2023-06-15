package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class FrmPrincipal extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenuItem mntmAlumno;
	private JMenu mnRegistro;
	private JMenu mnConsulta;
	private JMenu mnReporte;
	private JMenuItem mnuCurso;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmRetiro;
	private JMenuItem mntmAlumnosCursos;
	private JMenuItem mntmMatriculasRetiros;
	private JMenuItem mntmAlumnosMatrículaPendiente;
	private JMenuItem mntmAlumnosMatrículaVigente;
	private JMenuItem mntmAlumnosMatriculadosCurso;
	private JMenuItem mntmSalir;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
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
	public FrmPrincipal() {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		setTitle("SISTEMA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 450);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmAlumno = new JMenuItem("Alumno");
		mntmAlumno.addActionListener(this);
		mntmAlumno.setHorizontalAlignment(SwingConstants.LEFT);
		mnMantenimiento.add(mntmAlumno);
		
		mnuCurso = new JMenuItem("Curso");
		mnuCurso.addActionListener(this);
		mnuCurso.setHorizontalAlignment(SwingConstants.LEFT);
		mnMantenimiento.add(mnuCurso);
		
		mnRegistro = new JMenu("Registro");
		menuBar.add(mnRegistro);
		
		mntmNewMenuItem = new JMenuItem("Matr\u00EDcula");
		mntmNewMenuItem.addActionListener(this);
		mnRegistro.add(mntmNewMenuItem);
		
		mntmRetiro = new JMenuItem("Retiro");
		mntmRetiro.addActionListener(this);
		mnRegistro.add(mntmRetiro);
		
		mnConsulta = new JMenu("Consulta");
		menuBar.add(mnConsulta);
		
		mntmAlumnosCursos = new JMenuItem("Alumnos y Cursos ");
		mntmAlumnosCursos.addActionListener(this);
		mnConsulta.add(mntmAlumnosCursos);
		
		mntmMatriculasRetiros = new JMenuItem("Matr\u00EDculas y Retiros");
		mntmMatriculasRetiros.addActionListener(this);
		mnConsulta.add(mntmMatriculasRetiros);
		
		mnReporte = new JMenu("Reporte");
		menuBar.add(mnReporte);
		
		mntmAlumnosMatrículaPendiente = new JMenuItem("Alumnos con Matr\u00EDcula Pendiente");
		mntmAlumnosMatrículaPendiente.addActionListener(this);
		mnReporte.add(mntmAlumnosMatrículaPendiente);
		
		mntmAlumnosMatrículaVigente = new JMenuItem("Alumnos con Matr\u00EDcula Vigente");
		mntmAlumnosMatrículaVigente.addActionListener(this);
		mnReporte.add(mntmAlumnosMatrículaVigente);
		
		mntmAlumnosMatriculadosCurso = new JMenuItem("Alumnos Matriculados por Curso");
		mntmAlumnosMatriculadosCurso.addActionListener(this);
		mnReporte.add(mntmAlumnosMatriculadosCurso);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\CARLOS\\Desktop\\Nueva carpeta\\Proyecto Algoritmia - Ciclo 2\\pngtree-computer-computing-server-cpu-abstract-flat-color-icon-templa-png-image_1696187.jpg"));
		lblNewLabel.setBounds(72, 0, 360, 388);
		contentPane.add(lblNewLabel);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmSalir) {
			do_mntmSalir_actionPerformed(e);
		}
		if (e.getSource() == mntmAlumno) {
			do_mntmAlumno_actionPerformed(e);
		}
		if (e.getSource() == mntmAlumnosMatriculadosCurso) {
			do_mntmAlumnosMatriculadosCurso_actionPerformed(e);
		}
		if (e.getSource() == mntmAlumnosMatrículaVigente) {
			do_mntmAlumnosMatrículaVigente_actionPerformed(e);
		}
		if (e.getSource() == mntmAlumnosMatrículaPendiente) {
			do_mntmAlumnosMatrículaPendiente_actionPerformed(e);
		}
		if (e.getSource() == mntmMatriculasRetiros) {
			do_mntmMatriculasRetiros_actionPerformed(e);
		}
		if (e.getSource() == mntmAlumnosCursos) {
			do_mntmAlumnosCursos_actionPerformed(e);
		}
		if (e.getSource() == mntmRetiro) {
			do_mntmRetiro_actionPerformed(e);
		}
		if (e.getSource() == mntmNewMenuItem) {
			do_mntmNewMenuItem_actionPerformed(e);
		}
		if (e.getSource() == mnuCurso) {
			do_mnuCurso_actionPerformed(e);
		}
	}
	
	protected void do_mntmSalir_actionPerformed(ActionEvent e) {
		// Accion Salir
				System.exit(0);		  
	}
	
	protected void do_mntmAlumno_actionPerformed(ActionEvent e) {
		FrmMantenimientoAlumno d;
		d = new FrmMantenimientoAlumno();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
    
	protected void do_mnuCurso_actionPerformed(ActionEvent e) {
		
	// Declarer an variable reference par controller el objeto FrmAlumnosCursos
       FrmMantenimientoCurso d;
    // Crear el Objeto FrmAlumnosCursos y asignar el control a la variable referencia
       d = new FrmMantenimientoCurso ();
    // Centrar la caja de Curso
       d.setLocationRelativeTo(this);
    // Hacer visible
       d.setVisible(true);	      
	}
	
	protected void do_mntmNewMenuItem_actionPerformed(ActionEvent e) {
		
		// Declarer an variable reference par controller el objeto FrmMatricula
		   FrmMatricula d;
	    // Crear el Objeto FrmMatricula y asignar el control a la variable referencia
	       d = new FrmMatricula ();
	    // Centrar la caja de Curso
	       d.setLocationRelativeTo(this);
	    // Hacer visible
	       d.setVisible(true);		
	}
	
	protected void do_mntmRetiro_actionPerformed(ActionEvent e) {
		
		// Declarer an variable reference par controller el objeto FrmRetiro
		   FrmRetiro d;
	    // Crear el Objeto FrmRetiro y asignar el control a la variable referencia
	       d = new FrmRetiro ();
	    // Centrar la caja de Curso
	       d.setLocationRelativeTo(this);
	    // Hacer visible
	       d.setVisible(true);		
	}
	
	protected void do_mntmAlumnosCursos_actionPerformed(ActionEvent e) {
		
		// Declarer an variable reference par controller el objeto FrmAlumnosCursos
		   FrmAlumnosCursos d;
	    // Crear el Objeto FrmAlumnosCursos y asignar el control a la variable referencia
	       d = new FrmAlumnosCursos ();
	    // Centrar la caja de Curso
	       d.setLocationRelativeTo(this);
	    // Hacer visible
	       d.setVisible(true);		
	}
	
	protected void do_mntmMatriculasRetiros_actionPerformed(ActionEvent e) {
		
		// Declarer an variable reference par controller el objeto FrmMatriculasRetiros
		   FrmMatriculasRetiros d;
	    // Crear el Objeto FrmMatriculasRetiros y asignar el control a la variable referencia
	       d = new FrmMatriculasRetiros ();
	    // Centrar la caja de Curso
	       d.setLocationRelativeTo(this);
	    // Hacer visible
	       d.setVisible(true);		
	}
	
	protected void do_mntmAlumnosMatrículaPendiente_actionPerformed(ActionEvent e) {
		
		// Declarer an variable reference par controller el objeto FrmAlumnosMatriculaPendiente
		   FrmAlumnosMatriculaPendiente d;
	    // Crear el Objeto FrmAlumnosMatriculaPendiente y asignar el control a la variable referencia
	       d = new FrmAlumnosMatriculaPendiente ();
	    // Centrar la caja de Curso
	       d.setLocationRelativeTo(this);
	    // Hacer visible
	       d.setVisible(true);	
	}
	
	protected void do_mntmAlumnosMatrículaVigente_actionPerformed(ActionEvent e) {
		
		// Declarer an variable reference par controller el objeto FrmAlumnosMatriculaPendiente
		   FrmAlumnosMatriculaVigente d;
	    // Crear el Objeto FrmAlumnosMatriculaPendiente y asignar el control a la variable referencia
	       d = new FrmAlumnosMatriculaVigente ();
	    // Centrar la caja de Curso
	       d.setLocationRelativeTo(this);
	    // Hacer visible
	       d.setVisible(true);
	}
	
	protected void do_mntmAlumnosMatriculadosCurso_actionPerformed(ActionEvent e) {
		
		// Declarer an variable reference par controller el objeto FrmAlumnosMatriculadosCurso
		   FrmAlumnosMatriculadosCurso d;
	    // Crear el Objeto FrmAlumnosMatriculadosCurso y asignar el control a la variable referencia
	       d = new FrmAlumnosMatriculadosCurso ();
	    // Centrar la caja de Curso
	       d.setLocationRelativeTo(this);
	    // Hacer visible
	       d.setVisible(true);		
	}
}
