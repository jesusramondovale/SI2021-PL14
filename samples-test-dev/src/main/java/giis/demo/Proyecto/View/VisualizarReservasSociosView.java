package giis.demo.Proyecto.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.toedter.calendar.JDayChooser;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class VisualizarReservasSociosView {

	private JFrame frmVisualizarReservasSocios;
	private JTable table;

	public JFrame getFrmVisualizarReservasSocios() {
		return frmVisualizarReservasSocios;
	}

	public void setFrmVisualizarReservasSocios(JFrame frmVisualizarReservasSocios) {
		this.frmVisualizarReservasSocios = frmVisualizarReservasSocios;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}

	public JComboBox getComboBox_Instalacion() {
		return comboBox_Instalacion;
	}

	public void setComboBox_Instalacion(JComboBox comboBox_Instalacion) {
		this.comboBox_Instalacion = comboBox_Instalacion;
	}

	public JDateChooser getDateChooser_FechaInicio() {
		return dateChooser_FechaInicio;
	}

	public void setDateChooser_FechaInicio(JDateChooser dateChooser_FechaInicio) {
		this.dateChooser_FechaInicio = dateChooser_FechaInicio;
	}

	public JLabel getLblNewLabel_1() {
		return lblNewLabel_1;
	}

	public void setLblNewLabel_1(JLabel lblNewLabel_1) {
		this.lblNewLabel_1 = lblNewLabel_1;
	}

	public JLabel getLblNewLabel_2() {
		return lblNewLabel_2;
	}

	public void setLblNewLabel_2(JLabel lblNewLabel_2) {
		this.lblNewLabel_2 = lblNewLabel_2;
	}

	public JDateChooser getDateChooser_FechaFin() {
		return dateChooser_FechaFin;
	}

	public void setDateChooser_FechaFin(JDateChooser dateChooser_FechaFin) {
		this.dateChooser_FechaFin = dateChooser_FechaFin;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JButton getBtnNewButton_MostrarReservas() {
		return btnNewButton_MostrarReservas;
	}

	public void setBtnNewButton_MostrarReservas(JButton btnNewButton_MostrarReservas) {
		this.btnNewButton_MostrarReservas = btnNewButton_MostrarReservas;
	}

	public JTextField getTextField_Nombre_Completo() {
		return textField_Nombre_Completo;
	}

	public void setTextField_Nombre_Completo(JTextField textField_Nombre_Completo) {
		this.textField_Nombre_Completo = textField_Nombre_Completo;
	}

	public JLabel getLblNewLabel_3() {
		return lblNewLabel_3;
	}

	public void setLblNewLabel_3(JLabel lblNewLabel_3) {
		this.lblNewLabel_3 = lblNewLabel_3;
	}

	private JLabel lblNewLabel ;

	private JComboBox comboBox_Instalacion ;

	private JDateChooser dateChooser_FechaInicio;

	private JLabel lblNewLabel_1 ;

	private JLabel lblNewLabel_2 ;

	private JDateChooser dateChooser_FechaFin ;

	private JScrollPane scrollPane ;
	private JButton btnNewButton_MostrarReservas;
	private JTextField textField_Nombre_Completo;
	private JLabel lblNewLabel_3 ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizarReservasSociosView window = new VisualizarReservasSociosView();
					window.frmVisualizarReservasSocios.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VisualizarReservasSociosView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVisualizarReservasSocios = new JFrame();
		frmVisualizarReservasSocios.setTitle("Visualizar Reservas Socios");
		frmVisualizarReservasSocios.setBounds(100, 100, 801, 398);
		frmVisualizarReservasSocios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		lblNewLabel = new JLabel("Instalacion");

		comboBox_Instalacion = new JComboBox();

		dateChooser_FechaInicio = new JDateChooser();

		lblNewLabel_1 = new JLabel("Fecha Inicio");

		lblNewLabel_2 = new JLabel("Fecha Fin");

		dateChooser_FechaFin = new JDateChooser();

		scrollPane = new JScrollPane();

		btnNewButton_MostrarReservas = new JButton("Mostrar Reservas");
		
		JLabel lblNewLabel_3 = new JLabel("Nombre:");
		
		textField_Nombre_Completo = new JTextField();
		textField_Nombre_Completo.setEditable(false);
		textField_Nombre_Completo.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frmVisualizarReservasSocios.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_MostrarReservas)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(lblNewLabel_1)
											.addComponent(lblNewLabel_2))
										.addGap(18)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(dateChooser_FechaFin, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
											.addComponent(dateChooser_FechaInicio, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
									.addComponent(textField_Nombre_Completo, Alignment.TRAILING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel)
										.addGap(18)
										.addComponent(comboBox_Instalacion, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)))
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
							.addGap(49)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 436, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(87, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(47)
							.addComponent(lblNewLabel_3)
							.addGap(18)
							.addComponent(textField_Nombre_Completo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(comboBox_Instalacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(42)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1)
								.addComponent(dateChooser_FechaInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(39)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_2)
								.addComponent(dateChooser_FechaFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(34)
							.addComponent(btnNewButton_MostrarReservas))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(45)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(33, Short.MAX_VALUE))
		);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID Reserva", "Instalacion", "Precio por Hora", "Pagado"
			}
		));
		scrollPane.setViewportView(table);
		frmVisualizarReservasSocios.getContentPane().setLayout(groupLayout);
	}
}
