package vista;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import controlador.ControladorVentanas;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class VLogin_Main extends JFrame {
	private static final long serialVersionUID = -8099949889278258203L;
	private JTextField txtField;
	private JPasswordField pwdField;
	private JButton btnLogin;

	// constructor
	public VLogin_Main() {
		super("Appetizer Login");
		System.out.println("Github es la clave");
		System.out.println("miguel");
		init();
	}

	// metodos
	//MAIN
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable(){
			public void run(){
				// definicion de ventanas y paneles
				VLogin_Main ventanaLogin = new VLogin_Main();
				VPrincipalAppetizer ventanaPrincipal = new VPrincipalAppetizer();
				ControladorVentanas control = new ControladorVentanas(ventanaLogin, ventanaPrincipal);
				PnlConsultaPincho panelConsultaPinchos = new PnlConsultaPincho();
				PnlAñadirPincho panelAddPincho = new PnlAñadirPincho();
				
				// funcionalidad de ventanas y paneles
				ventanaLogin.setControlador(control);
				ventanaPrincipal.setControlador(control);
				
				control.setPanelConsultarPincho(panelConsultaPinchos);
				control.setPanelAddPincho(panelAddPincho);
				panelConsultaPinchos.setControlador(control);
				panelAddPincho.setControlador(control);
				
				ventanaLogin.hacerVisible();
			}
		});
	}
	
	public void init(){
		setPreferredSize(new Dimension(730, 600));
		getContentPane().setLayout(null);
		
		JLabel lblNombreDeUsuario = new JLabel("Usuario:");
		lblNombreDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNombreDeUsuario.setBounds(100, 143, 129, 60);
		getContentPane().add(lblNombreDeUsuario);
		
		txtField = new JTextField();
		txtField.setFont(new Font("Tahoma", Font.PLAIN, 35));
		txtField.setBounds(241, 155, 435, 37);
		getContentPane().add(txtField);
		txtField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblContrasea.setBounds(42, 239, 187, 93);
		getContentPane().add(lblContrasea);
		
		pwdField = new JPasswordField();
		pwdField.setFont(new Font("Tahoma", Font.PLAIN, 35));
		pwdField.setBounds(241, 267, 435, 37);
		getContentPane().add(pwdField);
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 35));
		btnLogin.setBounds(262, 409, 208, 69);
		getContentPane().add(btnLogin);
	}
	
	// añade un actionListener al boton
	// añade un keyListener al txtField y al pwdField
	public void setControlador(ControladorVentanas control){
		btnLogin.addActionListener(control);
		txtField.addKeyListener(control);
		pwdField.addKeyListener(control);
	}
	
	
	public void hacerVisible(){
		this.pack();
		this.setVisible(true);
	}
	
	public String[] getDatosLogin(){
		String[] datos = new String[2];
		
		String nombreUsr = txtField.getText().toUpperCase();
		@SuppressWarnings("deprecation")
		String password = pwdField.getText();
		
		datos[0] = nombreUsr;
		datos[1] = password;
		
		return datos;
	}
	
	public JButton getBotonLogin(){
		return btnLogin;
	}
	
	public void mostrarMsgCierre(){
		JOptionPane.showMessageDialog(this, "Numero de intentos alcanzado. La ventana se cerrará", "Cierre de programa", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void mostratrMsgError(){
		JOptionPane.showMessageDialog(this, "Usuario/Contraseña incorrectos. Vuelve a intentarlo", "Usuario/Contraseña incorrecto", JOptionPane.ERROR_MESSAGE);
	}
}
