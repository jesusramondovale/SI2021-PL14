package giis.demo.Proyecto.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

public class ContabilidadMensualSociosView {

	private JFrame frmContabilidadMensualDe;
	private JButton btnContabilidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContabilidadMensualSociosView window = new ContabilidadMensualSociosView();
					window.frmContabilidadMensualDe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ContabilidadMensualSociosView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmContabilidadMensualDe = new JFrame();
		frmContabilidadMensualDe.setTitle("Contabilidad Mensual de los Socios");
		frmContabilidadMensualDe.setBounds(100, 100, 403, 200);
		frmContabilidadMensualDe.getContentPane().setLayout(null);
		
		btnContabilidad = new JButton("Realizar Contabilidad");
		btnContabilidad.setBounds(116, 74, 146, 21);
		frmContabilidadMensualDe.getContentPane().add(btnContabilidad);
	}
}
