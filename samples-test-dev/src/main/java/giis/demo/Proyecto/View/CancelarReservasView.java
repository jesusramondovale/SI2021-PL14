package giis.demo.Proyecto.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CancelarReservasView {

	private JFrame frmCancelarReserva;
	private JTextField textFieldSocio;
	private JTable tableReservas;
	private JButton btnActualizar;
	private JScrollPane scrollPaneReservas;
	private JButton btnBorrar;
	private JButton btnReservar;
	private JLabel lblNewLabel;
	
	


	public JFrame getFrmCancelarReserva() {
		return frmCancelarReserva;
	}

	public void setFrmCancelarReserva(JFrame frmCancelarReserva) {
		this.frmCancelarReserva = frmCancelarReserva;
	}

	public JTextField getTextFieldSocio() {
		return textFieldSocio;
	}

	public void setTextFieldSocio(JTextField textFieldSocio) {
		this.textFieldSocio = textFieldSocio;
	}

	public JTable getTableReservas() {
		return tableReservas;
	}

	public void setTableReservas(JTable tableReservas) {
		this.tableReservas = tableReservas;
	}

	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	public void setBtnActualizar(JButton btnActualizar) {
		this.btnActualizar = btnActualizar;
	}

	public JScrollPane getScrollPaneReservas() {
		return scrollPaneReservas;
	}

	public void setScrollPaneReservas(JScrollPane scrollPaneReservas) {
		this.scrollPaneReservas = scrollPaneReservas;
	}

	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	public void setBtnBorrar(JButton btnBorrar) {
		this.btnBorrar = btnBorrar;
	}

	public JButton getBtnReservar() {
		return btnReservar;
	}

	public void setBtnReservar(JButton btnReservar) {
		this.btnReservar = btnReservar;
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}

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
		frmCancelarReserva.setBounds(100, 100, 451, 309);
		frmCancelarReserva.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Introduzca el #ID de Socio: ");
		lblNewLabel.setBounds(14, 15, 162, 14);
		frmCancelarReserva.getContentPane().add(lblNewLabel);
		
		textFieldSocio = new JTextField();
		textFieldSocio.setBounds(171, 12, 58, 20);
		frmCancelarReserva.getContentPane().add(textFieldSocio);
		textFieldSocio.setColumns(10);
		
		btnActualizar = new JButton("Ver Reservas");
		btnActualizar.setBounds(282, 11, 145, 23);
		frmCancelarReserva.getContentPane().add(btnActualizar);
		
		scrollPaneReservas = new JScrollPane();
		scrollPaneReservas.setBounds(14, 40, 413, 184);
		frmCancelarReserva.getContentPane().add(scrollPaneReservas);
		
		tableReservas = new JTable();
		scrollPaneReservas.setViewportView(tableReservas);
		
		btnBorrar = new JButton("Limpiar");
		btnBorrar.setBounds(14, 235, 89, 23);
		frmCancelarReserva.getContentPane().add(btnBorrar);
		
		btnReservar = new JButton("Cancelar Reserva");
		btnReservar.setBounds(298, 235, 129, 23);
		frmCancelarReserva.getContentPane().add(btnReservar);
	}
}
