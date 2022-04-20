package giis.demo.Proyecto.View;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoginView {

	private JFrame frmLogin;
	private JTextField txtId;
	private JButton btnLogear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 305, 198);
		
		btnLogear = new JButton("LOGIN");
		btnLogear.setBounds(129, 100, 85, 31);
		btnLogear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel = new JLabel("Introduzca su #ID de Socio");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(34, 30, 203, 20);
		
		txtId = new JTextField();
		txtId.setBounds(119, 68, 96, 20);
		txtId.setColumns(10);
		frmLogin.getContentPane().setLayout(null);
		frmLogin.getContentPane().add(btnLogear);
		frmLogin.getContentPane().add(lblNewLabel);
		frmLogin.getContentPane().add(txtId);
	}

	public JFrame getFrame() {
		return frmLogin;
	}

	public void setFrame(JFrame frame) {
		this.frmLogin = frame;
	}

	public JTextField getTxtId() {
		return txtId;
	}

	public void setTxtId(JTextField txtId) {
		this.txtId = txtId;
	}

	public JButton getBtnLogear() {
		return btnLogear;
	}

	public void setBtnLogear(JButton btnLogear) {
		this.btnLogear = btnLogear;
	}
	
	

}