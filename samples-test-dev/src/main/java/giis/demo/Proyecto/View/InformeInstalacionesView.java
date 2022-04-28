package giis.demo.Proyecto.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class InformeInstalacionesView {

	private JFrame frmGenerarInformesSobre;
	private JDateChooser dateChooserInicio;
	private JDateChooser dateChooserFinal;
	private JButton btnLimpiar;
	private JButton btnGenerar;
	private JTextField textFieldInstalacion;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnReservas;
	private JRadioButton rdbtnActividades;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformeInstalacionesView window = new InformeInstalacionesView();
					window.frmGenerarInformesSobre.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InformeInstalacionesView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGenerarInformesSobre = new JFrame();
		frmGenerarInformesSobre.setTitle("Generar Informes sobre Instalaciones");
		frmGenerarInformesSobre.setBounds(100, 100, 415, 230);
		frmGenerarInformesSobre.getContentPane().setLayout(null);

		JLabel lblSocio = new JLabel("#ID Instalación");
		lblSocio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSocio.setBounds(24, 22, 106, 16);
		frmGenerarInformesSobre.getContentPane().add(lblSocio);

		JLabel lblPeriodoTemporal = new JLabel("Periodo Temporal");
		lblPeriodoTemporal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPeriodoTemporal.setBounds(24, 48, 128, 16);
		frmGenerarInformesSobre.getContentPane().add(lblPeriodoTemporal);

		JLabel lblIncluirDatosSobre = new JLabel("Incluir Datos sobre Reservas");
		lblIncluirDatosSobre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIncluirDatosSobre.setBounds(24, 74, 217, 16);
		frmGenerarInformesSobre.getContentPane().add(lblIncluirDatosSobre);

		JLabel lblIncluirDatosSobre_2 = new JLabel("Incluir Datos sobre Actividades");
		lblIncluirDatosSobre_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIncluirDatosSobre_2.setBounds(24, 104, 217, 16);
		frmGenerarInformesSobre.getContentPane().add(lblIncluirDatosSobre_2);

		dateChooserInicio = new JDateChooser();
		dateChooserInicio.setBounds(148, 48, 93, 19);
		frmGenerarInformesSobre.getContentPane().add(dateChooserInicio);

		JLabel lbl = new JLabel("<->");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl.setBounds(246, 50, 36, 13);
		frmGenerarInformesSobre.getContentPane().add(lbl);

		dateChooserFinal = new JDateChooser();
		dateChooserFinal.setBounds(279, 49, 96, 19);
		frmGenerarInformesSobre.getContentPane().add(dateChooserFinal);

		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setBounds(24, 154, 85, 21);
		frmGenerarInformesSobre.getContentPane().add(btnLimpiar);

		btnGenerar = new JButton("GENERAR");
		btnGenerar.setBounds(246, 154, 118, 21);
		frmGenerarInformesSobre.getContentPane().add(btnGenerar);
		
		textFieldInstalacion = new JTextField();
		textFieldInstalacion.setBounds(145, 22, 96, 20);
		frmGenerarInformesSobre.getContentPane().add(textFieldInstalacion);
		textFieldInstalacion.setColumns(10);
		
		rdbtnReservas = new JRadioButton("");
		buttonGroup.add(rdbtnReservas);
		rdbtnReservas.setSelected(true);
		rdbtnReservas.setBounds(233, 74, 111, 23);
		frmGenerarInformesSobre.getContentPane().add(rdbtnReservas);
		
		rdbtnActividades = new JRadioButton("");
		buttonGroup.add(rdbtnActividades);
		rdbtnActividades.setBounds(233, 97, 111, 23);
		frmGenerarInformesSobre.getContentPane().add(rdbtnActividades);
	}

	
	
	
	
	

	public JRadioButton getRdbtnReservas() {
		return rdbtnReservas;
	}

	public void setRdbtnReservas(JRadioButton rdbtnReservas) {
		this.rdbtnReservas = rdbtnReservas;
	}

	public JRadioButton getRdbtnActividades() {
		return rdbtnActividades;
	}

	public void setRdbtnActividades(JRadioButton rdbtnActividades) {
		this.rdbtnActividades = rdbtnActividades;
	}

	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}

	public JTextField getTextFieldInstalacion() {
		return textFieldInstalacion;
	}

	public void setTextFieldInstalacion(JTextField textFieldInstalacion) {
		this.textFieldInstalacion = textFieldInstalacion;
	}

	public JFrame getFrmGenerarInformesSobre() {
		return frmGenerarInformesSobre;
	}

	public void setFrmGenerarInformesSobre(JFrame frmGenerarInformesSobre) {
		this.frmGenerarInformesSobre = frmGenerarInformesSobre;
	}

	

	public JDateChooser getDateChooserInicio() {
		return dateChooserInicio;
	}

	public void setDateChooserInicio(JDateChooser dateChooserInicio) {
		this.dateChooserInicio = dateChooserInicio;
	}

	public JDateChooser getDateChooserFinal() {
		return dateChooserFinal;
	}

	public void setDateChooserFinal(JDateChooser dateChooserFinal) {
		this.dateChooserFinal = dateChooserFinal;
	}

	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}

	public void setBtnLimpiar(JButton btnLimpiar) {
		this.btnLimpiar = btnLimpiar;
	}

	public JButton getBtnGenerar() {
		return btnGenerar;
	}

	public void setBtnGenerar(JButton btnGenerar) {
		this.btnGenerar = btnGenerar;
	}
}
