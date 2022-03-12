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
	private JTextField textFieldIniL;
	private JLabel lblA;
	private JTextField textFieldFinL;
	private JTextField textFieldIniM;
	private JTextField textFieldFinM;
	private JTextField textFieldIniX;
	private JTextField textFieldFinX;
	private JTextField textFieldIniJ;
	private JTextField textFieldFinJ;
	private JTextField textFieldIniV;
	private JTextField textFieldFinV;
	private JTextField textFieldIniS;
	private JTextField textFieldFinS;
	private JTextField textFieldIniD;
	private JTextField textFieldFinD;
	private JScrollPane scrollPaneActividades;
	private JTable tableActividades;
	private JLabel lblNewLabel;
	private JLabel lblM;
	private JLabel lblX;
	private JLabel lblJ;
	private JLabel lblV;
	private JLabel lblS;
	private JLabel lblD;
	private JButton btnActualizaActividades;
	
	


public JButton getBtnActualizaActividades() {
		return btnActualizaActividades;
	}

	public void setBtnActualizaActividades(JButton btnActualizaActividades) {
		this.btnActualizaActividades = btnActualizaActividades;
	}


	

	public JTextField getTextFieldIniL() {
		return textFieldIniL;
	}

	public void setTextFieldIniL(JTextField textFieldIniL) {
		this.textFieldIniL = textFieldIniL;
	}

	public JTextField getTextFieldFinL() {
		return textFieldFinL;
	}

	public void setTextFieldFinL(JTextField textFieldFinL) {
		this.textFieldFinL = textFieldFinL;
	}

	public JTextField getTextFieldIniM() {
		return textFieldIniM;
	}

	public void setTextFieldIniM(JTextField textFieldIniM) {
		this.textFieldIniM = textFieldIniM;
	}

	public JTextField getTextFieldFinM() {
		return textFieldFinM;
	}

	public void setTextFieldFinM(JTextField textFieldFinM) {
		this.textFieldFinM = textFieldFinM;
	}

	public JTextField getTextFieldIniX() {
		return textFieldIniX;
	}

	public void setTextFieldIniX(JTextField textFieldIniX) {
		this.textFieldIniX = textFieldIniX;
	}

	public JTextField getTextFieldFinX() {
		return textFieldFinX;
	}

	public void setTextFieldFinX(JTextField textFieldFinX) {
		this.textFieldFinX = textFieldFinX;
	}

	public JTextField getTextFieldIniJ() {
		return textFieldIniJ;
	}

	public void setTextFieldIniJ(JTextField textFieldIniJ) {
		this.textFieldIniJ = textFieldIniJ;
	}

	public JTextField getTextFieldFinJ() {
		return textFieldFinJ;
	}

	public void setTextFieldFinJ(JTextField textFieldFinJ) {
		this.textFieldFinJ = textFieldFinJ;
	}

	public JTextField getTextFieldIniV() {
		return textFieldIniV;
	}

	public void setTextFieldIniV(JTextField textFieldIniV) {
		this.textFieldIniV = textFieldIniV;
	}

	public JTextField getTextFieldFinV() {
		return textFieldFinV;
	}

	public void setTextFieldFinV(JTextField textFieldFinV) {
		this.textFieldFinV = textFieldFinV;
	}

	public JTextField getTextFieldIniS() {
		return textFieldIniS;
	}

	public void setTextFieldIniS(JTextField textFieldIniS) {
		this.textFieldIniS = textFieldIniS;
	}

	public JTextField getTextFieldFinS() {
		return textFieldFinS;
	}

	public void setTextFieldFinS(JTextField textFieldFinS) {
		this.textFieldFinS = textFieldFinS;
	}

	public JTextField getTextFieldIniD() {
		return textFieldIniD;
	}

	public void setTextFieldIniD(JTextField textFieldIniD) {
		this.textFieldIniD = textFieldIniD;
	}

	public JTextField getTextFieldFinD() {
		return textFieldFinD;
	}

	public void setTextFieldFinD(JTextField textFieldFinD) {
		this.textFieldFinD = textFieldFinD;
	}

	public JScrollPane getScrollPaneActividades() {
		return scrollPaneActividades;
	}

	public void setScrollPaneActividades(JScrollPane scrollPaneActividades) {
		this.scrollPaneActividades = scrollPaneActividades;
	}

	public JTable getTableActividades() {
		return tableActividades;
	}

	public void setTableActividades(JTable tableActividades) {
		this.tableActividades = tableActividades;
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
	@SuppressWarnings("serial")
	private void initialize() {
		frmRealizarReserva = new JFrame();
		frmRealizarReserva.setTitle("Realizar Reserva");
		frmRealizarReserva.setBounds(100, 100, 692, 359);
		
		btnCrearReserva = new JButton("Crear Reserva");
		btnCrearReserva.setBounds(511, 283, 130, 23);
		btnCrearReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(411, 283, 82, 23);
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
		
		JLabel lblActividad = new JLabel("Seleccione la Actividad:");
		lblActividad.setBounds(201, 120, 168, 19);
		lblActividad.setFont(new Font("Tahoma", Font.ITALIC, 15));
		
		JScrollPane scrollPaneAnteriores = new JScrollPane();
		scrollPaneAnteriores.setBounds(413, 61, 228, 211);
		
		JLabel lblAntreiores = new JLabel("Reservas Anteriores");
		lblAntreiores.setBounds(415, 39, 135, 14);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(540, 35, 103, 23);
		
		textFieldIniL = new JTextField();
		textFieldIniL.setBounds(40, 116, 32, 20);
		textFieldIniL.setColumns(10);
		
		lblA = new JLabel("a");
		lblA.setBounds(79, 115, 16, 21);
		lblA.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		textFieldFinL = new JTextField();
		textFieldFinL.setBounds(93, 116, 32, 20);
		textFieldFinL.setColumns(10);
		
		JLabel lblHorario = new JLabel("HORARIO");
		lblHorario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHorario.setBounds(58, 100, 103, 17);
		
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
		frmRealizarReserva.getContentPane().add(scrollPaneAnteriores);
		frmRealizarReserva.getContentPane().add(btnActualizar);
		frmRealizarReserva.getContentPane().add(btnBorrar);
		frmRealizarReserva.getContentPane().add(btnCrearReserva);
		frmRealizarReserva.getContentPane().add(cbDiaFin);
		frmRealizarReserva.getContentPane().add(cbMesFin);
		frmRealizarReserva.getContentPane().add(cbAnoFin);
		frmRealizarReserva.getContentPane().add(textFieldIniL);
		frmRealizarReserva.getContentPane().add(lblA);
		frmRealizarReserva.getContentPane().add(textFieldFinL);
		
		textFieldIniM = new JTextField();
		textFieldIniM.setColumns(10);
		textFieldIniM.setBounds(40, 142, 32, 20);
		frmRealizarReserva.getContentPane().add(textFieldIniM);
		
		JLabel lblA_1 = new JLabel("a");
		lblA_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblA_1.setBounds(79, 141, 16, 21);
		frmRealizarReserva.getContentPane().add(lblA_1);
		
		textFieldFinM = new JTextField();
		textFieldFinM.setColumns(10);
		textFieldFinM.setBounds(93, 142, 32, 20);
		frmRealizarReserva.getContentPane().add(textFieldFinM);
		
		textFieldIniX = new JTextField();
		textFieldIniX.setColumns(10);
		textFieldIniX.setBounds(40, 170, 32, 20);
		frmRealizarReserva.getContentPane().add(textFieldIniX);
		
		JLabel lblA_2 = new JLabel("a");
		lblA_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblA_2.setBounds(79, 169, 16, 21);
		frmRealizarReserva.getContentPane().add(lblA_2);
		
		textFieldFinX = new JTextField();
		textFieldFinX.setColumns(10);
		textFieldFinX.setBounds(93, 170, 32, 20);
		frmRealizarReserva.getContentPane().add(textFieldFinX);
		
		textFieldIniJ = new JTextField();
		textFieldIniJ.setColumns(10);
		textFieldIniJ.setBounds(40, 194, 32, 20);
		frmRealizarReserva.getContentPane().add(textFieldIniJ);
		
		JLabel lblA_3 = new JLabel("a");
		lblA_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblA_3.setBounds(79, 193, 16, 21);
		frmRealizarReserva.getContentPane().add(lblA_3);
		
		textFieldFinJ = new JTextField();
		textFieldFinJ.setColumns(10);
		textFieldFinJ.setBounds(93, 194, 32, 20);
		frmRealizarReserva.getContentPane().add(textFieldFinJ);
		
		textFieldIniV = new JTextField();
		textFieldIniV.setColumns(10);
		textFieldIniV.setBounds(40, 219, 32, 20);
		frmRealizarReserva.getContentPane().add(textFieldIniV);
		
		JLabel lblA_4 = new JLabel("a");
		lblA_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblA_4.setBounds(79, 218, 16, 21);
		frmRealizarReserva.getContentPane().add(lblA_4);
		
		textFieldFinV = new JTextField();
		textFieldFinV.setColumns(10);
		textFieldFinV.setBounds(93, 219, 32, 20);
		frmRealizarReserva.getContentPane().add(textFieldFinV);
		
		textFieldIniS = new JTextField();
		textFieldIniS.setColumns(10);
		textFieldIniS.setBounds(40, 242, 32, 20);
		frmRealizarReserva.getContentPane().add(textFieldIniS);
		
		JLabel lblA_5 = new JLabel("a");
		lblA_5.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblA_5.setBounds(79, 241, 16, 21);
		frmRealizarReserva.getContentPane().add(lblA_5);
		
		textFieldFinS = new JTextField();
		textFieldFinS.setColumns(10);
		textFieldFinS.setBounds(93, 242, 32, 20);
		frmRealizarReserva.getContentPane().add(textFieldFinS);
		
		textFieldIniD = new JTextField();
		textFieldIniD.setColumns(10);
		textFieldIniD.setBounds(40, 268, 32, 20);
		frmRealizarReserva.getContentPane().add(textFieldIniD);
		
		JLabel lblA_6 = new JLabel("a");
		lblA_6.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblA_6.setBounds(79, 267, 16, 21);
		frmRealizarReserva.getContentPane().add(lblA_6);
		
		textFieldFinD = new JTextField();
		textFieldFinD.setColumns(10);
		textFieldFinD.setBounds(93, 268, 32, 20);
		frmRealizarReserva.getContentPane().add(textFieldFinD);
		
		scrollPaneActividades = new JScrollPane();
		scrollPaneActividades.setBounds(201, 139, 196, 129);
		frmRealizarReserva.getContentPane().add(scrollPaneActividades);
		
		tableActividades = new JTable();
		scrollPaneActividades.setViewportView(tableActividades);
		
		lblNewLabel = new JLabel("L");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(135, 115, 26, 19);
		frmRealizarReserva.getContentPane().add(lblNewLabel);
		
		lblM = new JLabel("M");
		lblM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblM.setBounds(134, 142, 26, 19);
		frmRealizarReserva.getContentPane().add(lblM);
		
		lblX = new JLabel("X");
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblX.setBounds(135, 171, 26, 19);
		frmRealizarReserva.getContentPane().add(lblX);
		
		lblJ = new JLabel("J");
		lblJ.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblJ.setBounds(134, 194, 26, 19);
		frmRealizarReserva.getContentPane().add(lblJ);
		
		lblV = new JLabel("V");
		lblV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblV.setBounds(135, 218, 26, 19);
		frmRealizarReserva.getContentPane().add(lblV);
		
		lblS = new JLabel("S");
		lblS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblS.setBounds(135, 243, 26, 19);
		frmRealizarReserva.getContentPane().add(lblS);
		
		lblD = new JLabel("D");
		lblD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblD.setBounds(135, 267, 26, 19);
		frmRealizarReserva.getContentPane().add(lblD);
		
		btnActualizaActividades = new JButton("Actualizar");
		btnActualizaActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnActualizaActividades.setBounds(308, 279, 89, 23);
		frmRealizarReserva.getContentPane().add(btnActualizaActividades);
	}
}
