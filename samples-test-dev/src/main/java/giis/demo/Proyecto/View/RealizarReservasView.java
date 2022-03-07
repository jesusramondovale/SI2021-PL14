package giis.demo.Proyecto.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RealizarReservasView {

	private JFrame frmRealizarReserva;
	private JTable tableAnteriores;
	

	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxInstalacion = new JComboBox();
	private JComboBox cbDiaIni;
	private JComboBox cbMesIni;
	private JComboBox cbAnoIni;
	private JComboBox cbDiaFin;	
	private JComboBox cbMesFin;	
	private JComboBox cbAnoFin;
	
	private JButton btnBorrar;
	private JButton btnCrearReserva;
	private JButton btnActualizar;	
	private JScrollPane scrollPaneAnteriores ;
	private JScrollPane scrollPanePosteriores;
	private JLabel lblSocio;
	private JTextField textFieldSocio;
	private JComboBox comboBoxActividad;
	private JTextField textFieldActividad;
	private JTextField textFieldHorasIni;
	private JTextField textFieldHorasFin;
	private JLabel label;
	private JTextField textFieldMinIni;
	private JTextField textFieldMinFin;
	
	
	
	
	

	public JComboBox getComboBoxActividad() {
		return comboBoxActividad;
	}

	public void setComboBoxActividad(JComboBox comboBoxActividad) {
		this.comboBoxActividad = comboBoxActividad;
	}

	public JTextField getTextFieldActividad() {
		return textFieldActividad;
	}

	public void setTextFieldActividad(JTextField textFieldActividad) {
		this.textFieldActividad = textFieldActividad;
	}

	public JTextField getTextFieldHorasIni() {
		return textFieldHorasIni;
	}

	public void setTextFieldHorasIni(JTextField textFieldHorasIni) {
		this.textFieldHorasIni = textFieldHorasIni;
	}

	public JTextField getTextFieldHorasFin() {
		return textFieldHorasFin;
	}

	public void setTextFieldHorasFin(JTextField textFieldHorasFin) {
		this.textFieldHorasFin = textFieldHorasFin;
	}

	public JTextField getTextFieldMinIni() {
		return textFieldMinIni;
	}

	public void setTextFieldMinIni(JTextField textFieldMinIni) {
		this.textFieldMinIni = textFieldMinIni;
	}

	public JTextField getTextFieldMinFin() {
		return textFieldMinFin;
	}

	public void setTextFieldMinFin(JTextField textFieldMinFin) {
		this.textFieldMinFin = textFieldMinFin;
	}

	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	public void setBtnActualizar(JButton btnActualizar) {
		this.btnActualizar = btnActualizar;
	}

	public JFrame getFrmRealizarReserva() {
		return frmRealizarReserva;
	}

	public void setFrmRealizarReserva(JFrame frmRealizarReserva) {
		this.frmRealizarReserva = frmRealizarReserva;
	}

	

	public JTable getTableAnteriores() {
		return tableAnteriores;
	}

	public void setTableAnteriores(JTable tableAnteriores) {
		this.tableAnteriores = tableAnteriores;
	}

	public JComboBox getComboBoxInstalacion() {
		return comboBoxInstalacion;
	}

	public void setComboBoxInstalacion(JComboBox comboBoxInstalacion) {
		this.comboBoxInstalacion = comboBoxInstalacion;
	}

	public JComboBox getCbDiaIni() {
		return cbDiaIni;
	}

	public void setCbDiaIni(JComboBox cbDiaIni) {
		this.cbDiaIni = cbDiaIni;
	}

	public JComboBox getCbMesIni() {
		return cbMesIni;
	}

	public void setCbMesIni(JComboBox cbMesIni) {
		this.cbMesIni = cbMesIni;
	}

	public JComboBox getCbAnoIni() {
		return cbAnoIni;
	}

	public void setCbAnoIni(JComboBox cbAnoIni) {
		this.cbAnoIni = cbAnoIni;
	}

	public JComboBox getCbDiaFin() {
		return cbDiaFin;
	}

	public void setCbDiaFin(JComboBox cbDiaFin) {
		this.cbDiaFin = cbDiaFin;
	}

	public JComboBox getCbMesFin() {
		return cbMesFin;
	}

	public void setCbMesFin(JComboBox cbMesFin) {
		this.cbMesFin = cbMesFin;
	}

	public JComboBox getCbAnoFin() {
		return cbAnoFin;
	}

	public void setCbAnoFin(JComboBox cbAnoFin) {
		this.cbAnoFin = cbAnoFin;
	}

	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	public void setBtnBorrar(JButton btnBorrar) {
		this.btnBorrar = btnBorrar;
	}

	public JButton getBtnCrearReserva() {
		return btnCrearReserva;
	}

	public void setBtnCrearReserva(JButton btnCrearReserva) {
		this.btnCrearReserva = btnCrearReserva;
	}

	public JScrollPane getScrollPaneAnteriores() {
		return scrollPaneAnteriores;
	}

	public void setScrollPaneAnteriores(JScrollPane scrollPaneAnteriores) {
		this.scrollPaneAnteriores = scrollPaneAnteriores;
	}

	public JScrollPane getScrollPanePosteriores() {
		return scrollPanePosteriores;
	}

	public void setScrollPanePosteriores(JScrollPane scrollPanePosteriores) {
		this.scrollPanePosteriores = scrollPanePosteriores;
	}

	
	
	
	public JTextField getTextFieldSocio() {
		return textFieldSocio;
	}

	public void setTextFieldSocio(JTextField textFieldSocio) {
		this.textFieldSocio = textFieldSocio;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RealizarReservasView window = new RealizarReservasView();
					window.frmRealizarReserva.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RealizarReservasView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRealizarReserva = new JFrame();
		frmRealizarReserva.setTitle("Realizar Reserva");
		frmRealizarReserva.setBounds(100, 100, 571, 397);
		
		btnCrearReserva = new JButton("Crear Reserva");
		btnCrearReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel lblSeleccione = new JLabel("Seleccione la instalación");
		lblSeleccione.setFont(new Font("Tahoma", Font.ITALIC, 15));
		
		JLabel lblInicioDeReserva = new JLabel("Inicio de reserva :");
		lblInicioDeReserva.setFont(new Font("Tahoma", Font.ITALIC, 15));
		
		JLabel lblFinalDeReserva = new JLabel("Final de reserva :");
		lblFinalDeReserva.setFont(new Font("Tahoma", Font.ITALIC, 15));
		
		 comboBoxInstalacion = new JComboBox();
		 comboBoxInstalacion.setToolTipText("Seleccione la instalación a reservar.");
		comboBoxInstalacion.setModel(new DefaultComboBoxModel(new String[] {"pista de pádel", "campo de futbito", "cancha de baloncesto", "salon de yoga", "cancha de balonmano", "piscina"}));
		
		 cbDiaIni = new JComboBox();
		cbDiaIni.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		
		 cbMesIni = new JComboBox();
		cbMesIni.setModel(new DefaultComboBoxModel(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
		
		 cbAnoIni = new JComboBox();
		cbAnoIni.setModel(new DefaultComboBoxModel(new String[] {"2022", "2023", "2024", "2025"}));
		
		 cbDiaFin = new JComboBox();
		cbDiaFin.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		
		 cbMesFin = new JComboBox();
		cbMesFin.setModel(new DefaultComboBoxModel(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
		
		cbAnoFin = new JComboBox();
		cbAnoFin.setModel(new DefaultComboBoxModel(new String[] {"2022", "2023", "2024", "2025"}));
		
		JLabel lblActividad = new JLabel("Actividad:");
		lblActividad.setFont(new Font("Tahoma", Font.ITALIC, 15));
		
		JScrollPane scrollPaneAnteriores = new JScrollPane();
		
		JLabel lblAntreiores = new JLabel("Reservas Anteriores");
		
		lblSocio = new JLabel("Socio: ");
		
		textFieldSocio = new JTextField();
		textFieldSocio.setToolTipText("Indique el número de carnet de socio. ");
		textFieldSocio.setText("# ID de Socio");
		textFieldSocio.setColumns(10);
		
		btnActualizar = new JButton("Actualizar");
		
		comboBoxActividad = new JComboBox();
		comboBoxActividad.setModel(new DefaultComboBoxModel(new String[] {"Tenis ", "Natación", "Futbol"}));
		
		textFieldActividad = new JTextField();
		textFieldActividad.setToolTipText("Indique el #ID de la nueva actividad a crear.");
		textFieldActividad.setText("Nº");
		textFieldActividad.setColumns(10);
		
		textFieldHorasIni = new JTextField();
		textFieldHorasIni.setColumns(10);
		
		textFieldHorasFin = new JTextField();
		textFieldHorasFin.setColumns(10);
		
		JLabel label_1 = new JLabel(":");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		label = new JLabel(":");
		label.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		textFieldMinIni = new JTextField();
		textFieldMinIni.setColumns(10);
		
		textFieldMinFin = new JTextField();
		textFieldMinFin.setColumns(10);
		
		JLabel lblHorario = new JLabel("HORARIO");
		GroupLayout groupLayout = new GroupLayout(frmRealizarReserva.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblAntreiores)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblSeleccione, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(comboBoxInstalacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
									.addComponent(lblHorario)
									.addGap(11))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(lblFinalDeReserva, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
													.addGap(21)
													.addComponent(cbDiaFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addGap(18)
													.addComponent(cbMesFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(cbAnoFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(lblActividad, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(textFieldActividad, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
													.addGap(18)
													.addComponent(comboBoxActividad, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(btnActualizar)
														.addGroup(groupLayout.createSequentialGroup()
															.addComponent(lblSocio)
															.addGap(3)
															.addComponent(textFieldSocio, 0, 0, Short.MAX_VALUE))
														.addComponent(btnBorrar)
														.addComponent(btnCrearReserva))))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textFieldHorasFin, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblInicioDeReserva, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
											.addGap(15)
											.addComponent(cbDiaIni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(cbMesIni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(15)
											.addComponent(cbAnoIni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textFieldHorasIni, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textFieldMinFin, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textFieldMinIni, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGap(190))
						.addComponent(scrollPaneAnteriores, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSeleccione, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxInstalacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(10))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblHorario)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblInicioDeReserva, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(cbDiaIni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbMesIni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(cbAnoIni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(textFieldHorasIni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addComponent(textFieldMinIni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblFinalDeReserva, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(cbDiaFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(cbMesFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(cbAnoFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(textFieldHorasFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_1)
							.addComponent(textFieldMinFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblActividad, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldActividad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxActividad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSocio)
						.addComponent(textFieldSocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblAntreiores)
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(scrollPaneAnteriores, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnActualizar)
							.addGap(16)
							.addComponent(btnBorrar)
							.addGap(16)
							.addComponent(btnCrearReserva)))
					.addGap(35))
		);
		
		tableAnteriores = new JTable();
		tableAnteriores.setSize(scrollPaneAnteriores.getSize());
		
		scrollPaneAnteriores.setViewportView(tableAnteriores);
		frmRealizarReserva.getContentPane().setLayout(groupLayout);
	}
}