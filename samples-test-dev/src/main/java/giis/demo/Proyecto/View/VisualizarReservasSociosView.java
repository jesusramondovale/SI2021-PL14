package giis.demo.Proyecto.View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
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
		frmVisualizarReservasSocios.setBounds(100, 100, 718, 276);

		dateChooser_FechaInicio = new JDateChooser();
		dateChooser_FechaInicio.setBounds(126, 76, 106, 20);

		lblNewLabel_1 = new JLabel("Fecha Inicio");
		lblNewLabel_1.setBounds(33, 76, 83, 14);

		lblNewLabel_2 = new JLabel("Fecha Fin");
		lblNewLabel_2.setBounds(33, 101, 83, 14);

		dateChooser_FechaFin = new JDateChooser();
		dateChooser_FechaFin.setBounds(126, 95, 106, 20);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(263, 47, 412, 170);

		btnNewButton_MostrarReservas = new JButton("Mostrar Reservas");
		btnNewButton_MostrarReservas.setBounds(70, 126, 163, 23);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre:");
		lblNewLabel_3.setBounds(33, 24, 83, 14);
		
		textField_Nombre_Completo = new JTextField();
		textField_Nombre_Completo.setBounds(33, 45, 200, 20);
		textField_Nombre_Completo.setEditable(false);
		textField_Nombre_Completo.setColumns(10);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"", "", "", "", "", ""
			}
		));
		scrollPane.setViewportView(table);
		frmVisualizarReservasSocios.getContentPane().setLayout(null);
		frmVisualizarReservasSocios.getContentPane().add(btnNewButton_MostrarReservas);
		frmVisualizarReservasSocios.getContentPane().add(lblNewLabel_1);
		frmVisualizarReservasSocios.getContentPane().add(lblNewLabel_2);
		frmVisualizarReservasSocios.getContentPane().add(dateChooser_FechaFin);
		frmVisualizarReservasSocios.getContentPane().add(dateChooser_FechaInicio);
		frmVisualizarReservasSocios.getContentPane().add(textField_Nombre_Completo);
		frmVisualizarReservasSocios.getContentPane().add(lblNewLabel_3);
		frmVisualizarReservasSocios.getContentPane().add(scrollPane);
	}
}