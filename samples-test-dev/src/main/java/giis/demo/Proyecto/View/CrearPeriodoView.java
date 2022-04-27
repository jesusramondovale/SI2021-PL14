package giis.demo.Proyecto.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CrearPeriodoView {

	private JFrame frame;
	private JTextField nombrePeriodo;

	private JLabel lblNewLabel;

	private JLabel lblNewLabel_1 ;

	private JLabel lblNewLabel_1_1 ;

	private JLabel lblNewLabel_1_2 ;

	private JLabel lblNewLabel_1_3 ;

	private JDateChooser fechaInicioPeriodo ;

	private JDateChooser fechaFinPeriodo ;

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getNombrePeriodo() {
		return nombrePeriodo;
	}

	public void setNombrePeriodo(JTextField nombrePeriodo) {
		this.nombrePeriodo = nombrePeriodo;
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}

	public JLabel getLblNewLabel_1() {
		return lblNewLabel_1;
	}

	public void setLblNewLabel_1(JLabel lblNewLabel_1) {
		this.lblNewLabel_1 = lblNewLabel_1;
	}

	public JLabel getLblNewLabel_1_1() {
		return lblNewLabel_1_1;
	}

	public void setLblNewLabel_1_1(JLabel lblNewLabel_1_1) {
		this.lblNewLabel_1_1 = lblNewLabel_1_1;
	}

	public JLabel getLblNewLabel_1_2() {
		return lblNewLabel_1_2;
	}

	public void setLblNewLabel_1_2(JLabel lblNewLabel_1_2) {
		this.lblNewLabel_1_2 = lblNewLabel_1_2;
	}

	public JLabel getLblNewLabel_1_3() {
		return lblNewLabel_1_3;
	}

	public void setLblNewLabel_1_3(JLabel lblNewLabel_1_3) {
		this.lblNewLabel_1_3 = lblNewLabel_1_3;
	}

	public JDateChooser getFechaInicioPeriodo() {
		return fechaInicioPeriodo;
	}

	public void setFechaInicioPeriodo(JDateChooser fechaInicioPeriodo) {
		this.fechaInicioPeriodo = fechaInicioPeriodo;
	}

	public JDateChooser getFechaFinPeriodo() {
		return fechaFinPeriodo;
	}

	public void setFechaFinPeriodo(JDateChooser fechaFinPeriodo) {
		this.fechaFinPeriodo = fechaFinPeriodo;
	}

	public JDateChooser getFechaFinPeriodoNoSocio() {
		return fechaFinPeriodoNoSocio;
	}

	public void setFechaFinPeriodoNoSocio(JDateChooser fechaFinPeriodoNoSocio) {
		this.fechaFinPeriodoNoSocio = fechaFinPeriodoNoSocio;
	}

	public JButton getBotonCrearPeriodo() {
		return botonCrearPeriodo;
	}

	public void setBotonCrearPeriodo(JButton botonCrearPeriodo) {
		this.botonCrearPeriodo = botonCrearPeriodo;
	}

	private JDateChooser fechaFinPeriodoNoSocio ;

	private JButton botonCrearPeriodo ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearPeriodoView window = new CrearPeriodoView();
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
	public CrearPeriodoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 608, 313);

		lblNewLabel = new JLabel("CREAR PERIODO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

		lblNewLabel_1 = new JLabel("Nombre");

		lblNewLabel_1_1 = new JLabel("Fecha Inicio");

		lblNewLabel_1_2 = new JLabel("Fecha Fin");

		lblNewLabel_1_3 = new JLabel("Fecha Fin no socios");

		fechaInicioPeriodo = new JDateChooser();

		fechaFinPeriodo = new JDateChooser();

		fechaFinPeriodoNoSocio = new JDateChooser();

		nombrePeriodo = new JTextField();
		nombrePeriodo.setColumns(10);

		botonCrearPeriodo = new JButton("Crear Periodo");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(221)
						.addComponent(lblNewLabel)
						.addGap(223))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
						.addContainerGap(249, Short.MAX_VALUE)
						.addComponent(botonCrearPeriodo)
						.addGap(244))
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
														.addGap(38))
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.UNRELATED)))
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(fechaInicioPeriodo, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
												.addComponent(fechaFinPeriodo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(nombrePeriodo, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
										.addGap(33)
										.addComponent(lblNewLabel_1_3)))
						.addGap(18)
						.addComponent(fechaFinPeriodoNoSocio, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
						.addGap(62))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblNewLabel)
						.addGap(58)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1)
								.addComponent(nombrePeriodo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1_1)
								.addComponent(fechaInicioPeriodo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(fechaFinPeriodo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(fechaFinPeriodoNoSocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_1_3)))
								.addComponent(lblNewLabel_1_2))
						.addGap(37)
						.addComponent(botonCrearPeriodo)
						.addContainerGap(99, Short.MAX_VALUE))
				);
		frame.getContentPane().setLayout(groupLayout);
	}
}
