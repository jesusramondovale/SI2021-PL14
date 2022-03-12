package giis.demo.Proyecto.View;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class CancelarReservasView {

	private JFrame frmCancelarReserva;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CancelarReservasView window = new CancelarReservasView();
					window.frmCancelarReserva.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CancelarReservasView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCancelarReserva = new JFrame();
		frmCancelarReserva.setTitle("Cancelar Reserva");
		frmCancelarReserva.setBounds(100, 100, 450, 300);
	}

}
