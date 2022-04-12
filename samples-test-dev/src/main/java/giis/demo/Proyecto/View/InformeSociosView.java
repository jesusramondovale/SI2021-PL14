package giis.demo.Proyecto.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;

public class InformeSociosView {

	private JFrame frmGenerarInformesSobre;
	private JTextField textFieldSocio;
	private JDateChooser dateChooserInicio;
	private JDateChooser dateChooserFinal;
	private JButton btnLimpiar;
	private JButton btnGenerar;
	private JCheckBox checkBoxReservas;
	private JCheckBox checkBoxActividades;

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
		frmGenerarInformesSobre.setBounds(100, 100, 376, 219);
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
		lblIncluirDatosSobre.setBounds(24, 74, 217, 16);
		frmGenerarInformesSobre.getContentPane().add(lblIncluirDatosSobre);

		JLabel lblIncluirDatosSobre_2 = new JLabel("Incluir Datos sobre Actividades");
		lblIncluirDatosSobre_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIncluirDatosSobre_2.setBounds(24, 104, 217, 16);
		frmGenerarInformesSobre.getContentPane().add(lblIncluirDatosSobre_2);

		checkBoxReservas = new JCheckBox("");
		checkBoxReservas.setSelected(true);
		checkBoxReservas.setBounds(231, 74, 93, 21);
		frmGenerarInformesSobre.getContentPane().add(checkBoxReservas);

		checkBoxActividades = new JCheckBox("");
		checkBoxActividades.setFont(new Font("Tahoma", Font.PLAIN, 12));
		checkBoxActividades.setSelected(true);
		checkBoxActividades.setBounds(231, 104, 93, 21);
		frmGenerarInformesSobre.getContentPane().add(checkBoxActividades);

		textFieldSocio = new JTextField();
		textFieldSocio.setBounds(156, 23, 96, 19);
		frmGenerarInformesSobre.getContentPane().add(textFieldSocio);
		textFieldSocio.setColumns(10);

		dateChooserInicio = new JDateChooser();
		dateChooserInicio.setBounds(148, 48, 70, 19);
		frmGenerarInformesSobre.getContentPane().add(dateChooserInicio);

		JLabel lbl = new JLabel("<->");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl.setBounds(225, 52, 45, 13);
		frmGenerarInformesSobre.getContentPane().add(lbl);

		dateChooserFinal = new JDateChooser();
		dateChooserFinal.setBounds(260, 48, 70, 19);
		frmGenerarInformesSobre.getContentPane().add(dateChooserFinal);

		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setBounds(24, 142, 85, 21);
		frmGenerarInformesSobre.getContentPane().add(btnLimpiar);

		btnGenerar = new JButton("GENERAR");
		btnGenerar.setBounds(239, 142, 85, 21);
		frmGenerarInformesSobre.getContentPane().add(btnGenerar);
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

	public JCheckBox getCheckBoxReservas() {
		return checkBoxReservas;
	}

	public void setCheckBoxReservas(JCheckBox checkBoxReservas) {
		this.checkBoxReservas = checkBoxReservas;
	}

	public JCheckBox getCheckBoxActividades() {
		return checkBoxActividades;
	}

	public void setCheckBoxActividades(JCheckBox checkBoxActividades) {
		this.checkBoxActividades = checkBoxActividades;
	}







}
