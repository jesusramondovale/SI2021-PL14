package giis.demo.Proyecto.View;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class CancelarReservasSociosView {

	private JFrame frame;
	private JTextField textFieldNombre;
	
	public JTextField getTextFieldNombre() {
		return textFieldNombre;
	}

	public void setTextFieldNombre(JTextField textFieldNombre) {
		this.textFieldNombre = textFieldNombre;
	}
	
	//private JButton btnNewButton;
	
	private JScrollPane scrollPane;
	
	public JFrame getframe() {
		return frame;
	}

	public void setframe(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getTextField() {
		return textFieldNombre;
	}

	public void setTextField(JTextField textField) {
		this.textFieldNombre = textField;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}

	public JButton getBtnComprobarReservas() {
		return btnComprobarReservas;
	}

	public void setBtnComprobarReservas(JButton btnComprobarReservas) {
		this.btnComprobarReservas = btnComprobarReservas;
	}

	public JButton getBtnCancelarReservas() {
		return btnCancelarReservas;
	}

	public void setBtnCancelarReservas(JButton btnCancelarReservas) {
		this.btnCancelarReservas = btnCancelarReservas;
	}

	private JLabel lblNewLabel;
	
	private JButton btnCancelarReservas ;
	private JTable table;
	private JButton btnComprobarReservas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CancelarReservasSociosView window = new CancelarReservasSociosView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CancelarReservasSociosView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Cancelar Reservas Socios");
		frame.setBounds(100, 100, 483, 311);
		
		 lblNewLabel = new JLabel("Socio");
		 lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		 lblNewLabel.setBounds(22, 14, 65, 14);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(85, 12, 181, 20);
		textFieldNombre.setEditable(false);
		textFieldNombre.setColumns(10);
		
		 scrollPane = new JScrollPane();
		 scrollPane.setBounds(32, 45, 412, 179);
		
		btnCancelarReservas = new JButton("Cancelar Reserva");
		btnCancelarReservas.setBounds(304, 235, 140, 23);
		btnCancelarReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		table = new JTable();
		scrollPane.setViewportView(table);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(textFieldNombre);
		frame.getContentPane().add(btnCancelarReservas);
		frame.getContentPane().add(scrollPane);
		
		btnComprobarReservas = new JButton("Comprobar Reservas");
		btnComprobarReservas.setBounds(276, 11, 168, 23);
		frame.getContentPane().add(btnComprobarReservas);
	}
}
