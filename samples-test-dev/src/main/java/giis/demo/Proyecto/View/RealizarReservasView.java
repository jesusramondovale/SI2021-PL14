package giis.demo.Proyecto.View;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JButton;
import javax.swing.JLabel;
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
	private JTextField textFieldActividad;
	private JTextField textFieldHorasL;
	private JLabel label;
	private JTextField textFieldMinL;
	private JTextField textFieldHorasM;
	private JTextField textFieldMinM;
	private JTextField textFieldHorasX;
	private JTextField textFieldMinX;
	private JTextField textFieldHorasJ;
	private JTextField textFieldMinJ;
	private JTextField textFieldHorasV;
	private JTextField textFieldMinV;
	private JTextField textFieldHorasS;
	private JTextField textFieldMinS;
	private JTextField textFieldHorasD;
	private JTextField textFieldMinD;
	private JLabel lblNewLabel;
	private JLabel lblM;
	private JLabel lblX;
	private JLabel lblJ;
	private JLabel lblV;
	private JLabel lblS;
	private JLabel lblD;
	
	
	
	
	



	public JTextField getTextFieldActividad() {
		return textFieldActividad;
	}

	public void setTextFieldActividad(JTextField textFieldActividad) {
		this.textFieldActividad = textFieldActividad;
	}

	public JTextField getTextFieldHorasIni() {
		return textFieldHorasL;
	}

	public void setTextFieldHorasIni(JTextField textFieldHorasIni) {
		this.textFieldHorasL = textFieldHorasIni;
	}



	public JTextField getTextFieldMinIni() {
		return textFieldMinL;
	}

	public void setTextFieldMinIni(JTextField textFieldMinIni) {
		this.textFieldMinL = textFieldMinIni;
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
		frmRealizarReserva.setBounds(100, 100, 656, 369);
		
		btnCrearReserva = new JButton("Crear Reserva");
		btnCrearReserva.setBounds(509, 283, 103, 23);
		btnCrearReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(411, 283, 63, 23);
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		 cbDiaFin = new JComboBox();
		 cbDiaFin.setBounds(190, 65, 38, 20);
		cbDiaFin.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		
		 cbMesFin = new JComboBox();
		 cbMesFin.setBounds(238, 66, 82, 20);
		cbMesFin.setModel(new DefaultComboBoxModel(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
		
		cbAnoFin = new JComboBox();
		cbAnoFin.setBounds(330, 67, 67, 20);
		cbAnoFin.setModel(new DefaultComboBoxModel(new String[] {"2022", "2023", "2024", "2025"}));
		
		JLabel lblActividad = new JLabel("Actividad:");
		lblActividad.setBounds(249, 109, 71, 19);
		lblActividad.setFont(new Font("Tahoma", Font.ITALIC, 15));
		
		JScrollPane scrollPaneAnteriores = new JScrollPane();
		scrollPaneAnteriores.setBounds(407, 44, 205, 211);
		
		JLabel lblAntreiores = new JLabel("Reservas Anteriores");
		lblAntreiores.setBounds(413, 24, 135, 14);
		
		btnActualizar = new JButton("Actualizar Tabla");
		btnActualizar.setBounds(281, 141, 116, 23);
		
		textFieldActividad = new JTextField();
		textFieldActividad.setBounds(327, 110, 53, 20);
		textFieldActividad.setToolTipText("Indique el #ID de la nueva actividad a crear.");
		textFieldActividad.setText("Nº");
		textFieldActividad.setColumns(10);
		
		textFieldHorasL = new JTextField();
		textFieldHorasL.setBounds(71, 132, 32, 20);
		textFieldHorasL.setColumns(10);
		
		label = new JLabel(":");
		label.setBounds(113, 129, 16, 21);
		label.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		textFieldMinL = new JTextField();
		textFieldMinL.setBounds(124, 132, 32, 20);
		textFieldMinL.setColumns(10);
		
		JLabel lblHorario = new JLabel("HORARIO");
		lblHorario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHorario.setBounds(81, 110, 103, 17);
		
		tableAnteriores = new JTable();
		tableAnteriores.setSize(scrollPaneAnteriores.getSize());
		
		scrollPaneAnteriores.setViewportView(tableAnteriores);
		frmRealizarReserva.getContentPane().setLayout(null);
		
		JLabel lblInicioDeReserva = new JLabel("Inicio de reserva :");
		lblInicioDeReserva.setBounds(40, 35, 205, 19);
		lblInicioDeReserva.setFont(new Font("Tahoma", Font.ITALIC, 15));
		frmRealizarReserva.getContentPane().add(lblInicioDeReserva);
		
		 cbDiaIni = new JComboBox();
		 cbDiaIni.setBounds(190, 36, 38, 20);
		 cbDiaIni.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		 frmRealizarReserva.getContentPane().add(cbDiaIni);
		
		 cbMesIni = new JComboBox();
		 cbMesIni.setBounds(238, 36, 82, 20);
		 cbMesIni.setModel(new DefaultComboBoxModel(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
		 frmRealizarReserva.getContentPane().add(cbMesIni);
		
		 cbAnoIni = new JComboBox();
		 cbAnoIni.setBounds(330, 36, 67, 20);
		 cbAnoIni.setModel(new DefaultComboBoxModel(new String[] {"2022", "2023", "2024", "2025"}));
		 frmRealizarReserva.getContentPane().add(cbAnoIni);
		
		JLabel lblFinalDeReserva = new JLabel("Final de reserva :");
		lblFinalDeReserva.setBounds(40, 65, 116, 19);
		lblFinalDeReserva.setFont(new Font("Tahoma", Font.ITALIC, 15));
		frmRealizarReserva.getContentPane().add(lblFinalDeReserva);
		frmRealizarReserva.getContentPane().add(lblAntreiores);
		frmRealizarReserva.getContentPane().add(lblHorario);
		frmRealizarReserva.getContentPane().add(lblActividad);
		frmRealizarReserva.getContentPane().add(textFieldActividad);
		frmRealizarReserva.getContentPane().add(scrollPaneAnteriores);
		frmRealizarReserva.getContentPane().add(btnActualizar);
		frmRealizarReserva.getContentPane().add(btnBorrar);
		frmRealizarReserva.getContentPane().add(btnCrearReserva);
		frmRealizarReserva.getContentPane().add(cbDiaFin);
		frmRealizarReserva.getContentPane().add(cbMesFin);
		frmRealizarReserva.getContentPane().add(cbAnoFin);
		frmRealizarReserva.getContentPane().add(textFieldHorasL);
		frmRealizarReserva.getContentPane().add(label);
		frmRealizarReserva.getContentPane().add(textFieldMinL);
		
		textFieldHorasM = new JTextField();
		textFieldHorasM.setColumns(10);
		textFieldHorasM.setBounds(71, 158, 32, 20);
		frmRealizarReserva.getContentPane().add(textFieldHorasM);
		
		JLabel label_1 = new JLabel(":");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_1.setBounds(113, 155, 16, 21);
		frmRealizarReserva.getContentPane().add(label_1);
		
		textFieldMinM = new JTextField();
		textFieldMinM.setColumns(10);
		textFieldMinM.setBounds(124, 158, 32, 20);
		frmRealizarReserva.getContentPane().add(textFieldMinM);
		
		textFieldHorasX = new JTextField();
		textFieldHorasX.setColumns(10);
		textFieldHorasX.setBounds(71, 186, 32, 20);
		frmRealizarReserva.getContentPane().add(textFieldHorasX);
		
		JLabel label_2 = new JLabel(":");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_2.setBounds(113, 183, 16, 21);
		frmRealizarReserva.getContentPane().add(label_2);
		
		textFieldMinX = new JTextField();
		textFieldMinX.setColumns(10);
		textFieldMinX.setBounds(124, 186, 32, 20);
		frmRealizarReserva.getContentPane().add(textFieldMinX);
		
		textFieldHorasJ = new JTextField();
		textFieldHorasJ.setColumns(10);
		textFieldHorasJ.setBounds(71, 210, 32, 20);
		frmRealizarReserva.getContentPane().add(textFieldHorasJ);
		
		JLabel label_2_1 = new JLabel(":");
		label_2_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_2_1.setBounds(113, 207, 16, 21);
		frmRealizarReserva.getContentPane().add(label_2_1);
		
		textFieldMinJ = new JTextField();
		textFieldMinJ.setColumns(10);
		textFieldMinJ.setBounds(124, 210, 32, 20);
		frmRealizarReserva.getContentPane().add(textFieldMinJ);
		
		textFieldHorasV = new JTextField();
		textFieldHorasV.setColumns(10);
		textFieldHorasV.setBounds(71, 235, 32, 20);
		frmRealizarReserva.getContentPane().add(textFieldHorasV);
		
		JLabel label_2_2 = new JLabel(":");
		label_2_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_2_2.setBounds(113, 232, 16, 21);
		frmRealizarReserva.getContentPane().add(label_2_2);
		
		textFieldMinV = new JTextField();
		textFieldMinV.setColumns(10);
		textFieldMinV.setBounds(124, 235, 32, 20);
		frmRealizarReserva.getContentPane().add(textFieldMinV);
		
		textFieldHorasS = new JTextField();
		textFieldHorasS.setColumns(10);
		textFieldHorasS.setBounds(71, 258, 32, 20);
		frmRealizarReserva.getContentPane().add(textFieldHorasS);
		
		JLabel label_2_3 = new JLabel(":");
		label_2_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_2_3.setBounds(113, 255, 16, 21);
		frmRealizarReserva.getContentPane().add(label_2_3);
		
		textFieldMinS = new JTextField();
		textFieldMinS.setColumns(10);
		textFieldMinS.setBounds(124, 258, 32, 20);
		frmRealizarReserva.getContentPane().add(textFieldMinS);
		
		textFieldHorasD = new JTextField();
		textFieldHorasD.setColumns(10);
		textFieldHorasD.setBounds(71, 284, 32, 20);
		frmRealizarReserva.getContentPane().add(textFieldHorasD);
		
		JLabel label_2_4 = new JLabel(":");
		label_2_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_2_4.setBounds(113, 281, 16, 21);
		frmRealizarReserva.getContentPane().add(label_2_4);
		
		textFieldMinD = new JTextField();
		textFieldMinD.setColumns(10);
		textFieldMinD.setBounds(124, 284, 32, 20);
		frmRealizarReserva.getContentPane().add(textFieldMinD);
		
		lblNewLabel = new JLabel("L");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(39, 131, 32, 19);
		frmRealizarReserva.getContentPane().add(lblNewLabel);
		
		lblM = new JLabel("M");
		lblM.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblM.setBounds(40, 159, 32, 19);
		frmRealizarReserva.getContentPane().add(lblM);
		
		lblX = new JLabel("X");
		lblX.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblX.setBounds(39, 189, 32, 19);
		frmRealizarReserva.getContentPane().add(lblX);
		
		lblJ = new JLabel("J");
		lblJ.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblJ.setBounds(40, 213, 32, 19);
		frmRealizarReserva.getContentPane().add(lblJ);
		
		lblV = new JLabel("V");
		lblV.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblV.setBounds(40, 238, 32, 19);
		frmRealizarReserva.getContentPane().add(lblV);
		
		lblS = new JLabel("S");
		lblS.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblS.setBounds(39, 261, 32, 19);
		frmRealizarReserva.getContentPane().add(lblS);
		
		lblD = new JLabel("D");
		lblD.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblD.setBounds(39, 283, 32, 19);
		frmRealizarReserva.getContentPane().add(lblD);
	}
}
