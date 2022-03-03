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
	private JTextField textFieldActividad;
	private JTable tableAnteriores;
	private JTable tablePosteriores;
	

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

	public JTextField getTextFieldActividad() {
		return textFieldActividad;
	}

	public void setTextFieldActividad(JTextField textFieldActividad) {
		this.textFieldActividad = textFieldActividad;
	}

	public JTable getTableAnteriores() {
		return tableAnteriores;
	}

	public void setTableAnteriores(JTable tableAnteriores) {
		this.tableAnteriores = tableAnteriores;
	}

	public JTable getTablePosteriores() {
		return tablePosteriores;
	}

	public void setTablePosteriores(JTable tablePosteriores) {
		this.tablePosteriores = tablePosteriores;
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
		frmRealizarReserva.setBounds(100, 100, 497, 674);
		frmRealizarReserva.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnCrearReserva = new JButton("Crear Reserva");
		btnCrearReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnBorrar = new JButton("Borrar");
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
		comboBoxInstalacion.setModel(new DefaultComboBoxModel(new String[] {"pista de pádel", "campo de futbito", "cancha de baloncesto", "salon de yoga", "cancha de balonmano", "piscina"}));
		
		 cbDiaIni = new JComboBox();
		cbDiaIni.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		
		 cbMesIni = new JComboBox();
		cbMesIni.setModel(new DefaultComboBoxModel(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
		
		 cbAnoIni = new JComboBox();
		cbAnoIni.setModel(new DefaultComboBoxModel(new String[] {"2022", "2023", "2024", "2025"}));
		
		 cbDiaFin = new JComboBox();
		cbDiaFin.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		
		 cbMesFin = new JComboBox();
		cbMesFin.setModel(new DefaultComboBoxModel(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
		
		cbAnoFin = new JComboBox();
		cbAnoFin.setModel(new DefaultComboBoxModel(new String[] {"2022", "2023", "2024", "2025"}));
		
		JLabel lblActividad = new JLabel("Actividad:");
		lblActividad.setFont(new Font("Tahoma", Font.ITALIC, 15));
		
		textFieldActividad = new JTextField();
		textFieldActividad.setColumns(10);
		
		JScrollPane scrollPaneAnteriores = new JScrollPane();
		
		JScrollPane scrollPanePosteriores = new JScrollPane();
		
		JLabel lblAntreiores = new JLabel("Anteriores");
		
		JLabel lblPosteriores = new JLabel("Posteriores");
		
		lblSocio = new JLabel("Socio: ");
		
		textFieldSocio = new JTextField();
		textFieldSocio.setColumns(10);
		
		btnActualizar = new JButton("Actualizar");
		GroupLayout groupLayout = new GroupLayout(frmRealizarReserva.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnBorrar)
							.addGap(96)
							.addComponent(btnActualizar)
							.addGap(18)
							.addComponent(btnCrearReserva)
							.addGap(21))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblSeleccione, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
									.addGap(15)
									.addComponent(comboBoxInstalacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblInicioDeReserva, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
									.addGap(15)
									.addComponent(cbDiaIni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(cbMesIni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(15)
									.addComponent(cbAnoIni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblFinalDeReserva, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
									.addGap(21)
									.addComponent(cbDiaFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(cbMesFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(15)
									.addComponent(cbAnoFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblAntreiores)
								.addComponent(lblPosteriores, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblActividad, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
									.addGap(15)
									.addComponent(textFieldActividad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(25)
									.addComponent(lblSocio)
									.addGap(18)
									.addComponent(textFieldSocio, 0, 0, Short.MAX_VALUE))
								.addComponent(scrollPaneAnteriores, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
								.addComponent(scrollPanePosteriores, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
							.addContainerGap(32, GroupLayout.PREFERRED_SIZE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblSeleccione, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(comboBoxInstalacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblInicioDeReserva, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(cbDiaIni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbMesIni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbAnoIni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblFinalDeReserva, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(cbDiaFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbMesFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbAnoFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(13)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblActividad, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldActividad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblAntreiores))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(15)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSocio)
								.addComponent(textFieldSocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(4)
					.addComponent(scrollPaneAnteriores, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(lblPosteriores)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPanePosteriores, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBorrar)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnCrearReserva)
							.addComponent(btnActualizar)))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		
		tablePosteriores = new JTable();
		scrollPanePosteriores.setColumnHeaderView(tablePosteriores);
		
		tableAnteriores = new JTable();
		scrollPaneAnteriores.setColumnHeaderView(tableAnteriores);
		frmRealizarReserva.getContentPane().setLayout(groupLayout);
	}
}
