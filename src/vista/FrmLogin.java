package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmLogin extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblLogin;
	private JLabel lblUsuario;
	private JLabel lblContraseña;
	private JTextField txtUser;
	private JPasswordField txtPassword;
	private JButton btnIngresar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin frame = new FrmLogin();
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
	public FrmLogin() {
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("Sistema");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 293, 201);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Broadway", Font.BOLD, 16));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(10, 11, 257, 31);
		contentPane.add(lblLogin);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(10, 56, 60, 14);
		contentPane.add(lblUsuario);
		
		lblContraseña = new JLabel("Contrase\u00F1a:");
		lblContraseña.setBounds(10, 99, 73, 14);
		contentPane.add(lblContraseña);
		
		txtUser = new JTextField();
		txtUser.setBounds(93, 53, 174, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setToolTipText("");
		txtPassword.setBounds(93, 96, 174, 20);
		contentPane.add(txtPassword);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setForeground(Color.WHITE);
		btnIngresar.setBackground(Color.BLUE);
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(10, 127, 257, 24);
		contentPane.add(btnIngresar);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(e);
		}
	}
	
	protected void actionPerformedBtnIngresar(ActionEvent e) {
		char[] clave = txtPassword.getPassword();
		String claveFinal = new String(clave);
		
		if(txtUser.getText().equals("Administrador") && claveFinal.equals("123456")) {
			dispose();
			JOptionPane.showMessageDialog(null, "Bienvenido al Sistema", "INGRESASTE", JOptionPane.INFORMATION_MESSAGE);
			FrmPrincipal p = new FrmPrincipal();
			p.setVisible(true);
		} else {			
			JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrectos", "ERROR", JOptionPane.ERROR_MESSAGE);
			txtUser.setText("");
			txtPassword.setText("");
			txtUser.requestFocus();;
		}
	}
}
