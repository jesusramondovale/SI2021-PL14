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

public class InformeSociosView {

	private JFrame frmGenerarInformesSobre;
	private JTextField textFieldSocio;
	private JDateChooser dateChooserInicio;
	private JDateChooser dateChooserFinal;
	private JButton btnLimpiar;
	private JButton btnGenerar;
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
					InformeSociosView window = new InformeSociosView();
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
	public InformeSociosView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGenerarInformesSobre = new JFrame();
		frmGenerarInformesSobre.setTitle("Generar Informes sobre Socios");
		frmGenerarInformesSobre.setBounds(100, 100, 424, 208);
		frmGenerarInformesSobre.getContentPane().setLayout(null);

		JLabel lblSocio = new JLabel("#ID de Socio");
		lblSocio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSocio.setBounds(24, 22, 106, 16);
		frmGenerarInformesSobre.getContentPane().add(lblSocio);

		JLabel lblPeriodoTemporal = new JLabel("Periodo Temporal");
		lblPeriodoTemporal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPeriodoTemporal.setBounds(24, 48, 128, 16);
		frmGenerarInformesSobre.getContentPane().add(lblPeriodoTemporal);

		JLabel lblIncluirDatosSobre = new JLabel("Incluir Datos sobre Reservas");
		lblIncluirDatosSobre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIncluirDatosSobre.setBounds(24, 78, 217, 16);
		frmGenerarInformesSobre.getContentPane().add(lblIncluirDatosSobre);

		JLabel lblIncluirDatosSobre_2 = new JLabel("Incluir Datos sobre Actividades");
		lblIncluirDatosSobre_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIncluirDatosSobre_2.setBounds(24, 105, 217, 16);
		frmGenerarInformesSobre.getContentPane().add(lblIncluirDatosSobre_2);

		textFieldSocio = new JTextField();
		textFieldSocio.setBounds(156, 23, 96, 19);
		frmGenerarInformesSobre.getContentPane().add(textFieldSocio);
		textFieldSocio.setColumns(10);

		dateChooserInicio = new JDateChooser();
		dateChooserInicio.setBounds(148, 48, 93, 19);
		frmGenerarInformesSobre.getContentPane().add(dateChooserInicio);

		JLabel lbl = new JLabel("<->");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl.setBounds(246, 50, 36, 13);
		frmGenerarInformesSobre.getContentPane().add(lbl);

		dateChooserFinal = new JDateChooser();
		dateChooserFinal.setBounds(279, 49, 106, 19);
		frmGenerarInformesSobre.getContentPane().add(dateChooserFinal);

		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setBounds(34, 132, 85, 21);
		frmGenerarInformesSobre.getContentPane().add(btnLimpiar);

		btnGenerar = new JButton("GENERAR");
		btnGenerar.setBounds(246, 132, 104, 21);
		frmGenerarInformesSobre.getContentPane().add(btnGenerar);
		
		rdbtnReservas = new JRadioButton("");
		rdbtnReservas.setSelected(true);
		buttonGroup.add(rdbtnReservas);
		rdbtnReservas.setBounds(239, 77, 111, 23);
		frmGenerarInformesSobre.getContentPane().add(rdbtnReservas);
		
		rdbtnActividades = new JRadioButton("");
		buttonGroup.add(rdbtnActividades);
		rdbtnActividades.setBounds(239, 104, 111, 23);
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

	public JFrame getFrmGenerarInformesSobre() {
		return frmGenerarInformesSobre;
	}

	public void setFrmGenerarInformesSobre(JFrame frmGenerarInformesSobre) {
		this.frmGenerarInformesSobre = frmGenerarInformesSobre;
	}

	public JTextField getTextFieldSocio() {
		return textFieldSocio;
	}

	public void setTextFieldSocio(JTextField textFieldSocio) {
		this.textFieldSocio = textFieldSocio;
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