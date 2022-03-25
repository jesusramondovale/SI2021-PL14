package giis.demo.Proyecto.View;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class EstadoCuentasView {

	private JFrame frmEstadoDeLas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstadoCuentasView window = new EstadoCuentasView();
					window.frmEstadoDeLas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EstadoCuentasView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEstadoDeLas = new JFrame();
		frmEstadoDeLas.setTitle("Estado de las Cuentas");
		frmEstadoDeLas.setBounds(100, 100, 450, 300);
	}

}
