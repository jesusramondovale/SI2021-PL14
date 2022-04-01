package giis.demo.Proyecto.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class realizarReservaAdministradorView {

	private JFrame frame;
	private JTextField txtSocio;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtReserva;
	private JTextField txtPrecio;
	private JComboBox comboBox_HoraC;
	private JComboBox comboBox_HoraF;
	private JComboBox <Object> comboBox_instalacion;
	private JRadioButton rdBtnEfectivo;
	private JRadioButton rdBtnFinal;
	private final ButtonGroup grupo = new ButtonGroup();
	private JButton btnReserva;
	private JButton btnResguardo;
	private JTextField textFecha;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JButton btnComprobar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					realizarReservaAdministradorView window = new realizarReservaAdministradorView();
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
	public realizarReservaAdministradorView() {
		initialize();
	}

	public void actualizaPrecios(){
		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 698, 458);
		
		JLabel lblTitulo = new JLabel("RESERVA DE INSTALACIONES");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblInstalacion = new JLabel("Instalación");
		
		comboBox_instalacion = new JComboBox();
		comboBox_instalacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actualizaPrecios();
				
			}

			
		});
		comboBox_instalacion.setModel(new DefaultComboBoxModel(new String[] {"pista de pádel"}));
		
		JLabel lblFecha = new JLabel("Fecha");
		
		JLabel lblHoraC = new JLabel("Hora comienzo");
		
		comboBox_HoraC = new JComboBox();
		comboBox_HoraC.setModel(new DefaultComboBoxModel(new String[] {"9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21"}));
		
		JLabel lblHoraF = new JLabel("Hora fin");
		
		comboBox_HoraF = new JComboBox();
		comboBox_HoraF.setModel(new DefaultComboBoxModel(new String[] {"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22"}));
		
		JLabel lblNewLabel = new JLabel("----------------------------------------------------------------------------------------------------------");
		
		JLabel lblSocio = new JLabel("Nº Socio");
		
		txtSocio = new JTextField();
		txtSocio.setEditable(false);
		txtSocio.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		
		txtApellidos = new JTextField();
		txtApellidos.setEditable(false);
		txtApellidos.setColumns(10);
		
		JLabel lblReserva = new JLabel("Nº Reserva");
		
		txtReserva = new JTextField();
		txtReserva.setEditable(false);
		txtReserva.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio Reserva\r\n");
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("euros");
		
		JLabel lblNewLabel_2 = new JLabel("Forma de pago");
		
		rdBtnEfectivo = new JRadioButton("Pagar en efectivo");
		rdBtnFinal = new JRadioButton("Pagar al final del mes");
		
		grupo.add(rdBtnEfectivo);
		grupo.add(rdBtnFinal);
		frame.getContentPane().add(rdBtnEfectivo);
		frame.getContentPane().add(rdBtnFinal);
		
		btnReserva = new JButton("Reservar");
		
		btnResguardo = new JButton("Generar resguardo");
		
		 btnAnterior = new JButton("<-");
		
		textFecha = new JTextField();
		textFecha.setEditable(false);
		textFecha.setColumns(10);
		
		 btnSiguiente = new JButton("->");
		
		btnComprobar = new JButton("COMPROBAR");
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTitulo, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblHoraC)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(comboBox_HoraC, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
									.addGap(51)
									.addComponent(lblHoraF, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblInstalacion, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox_instalacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblFecha)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnAnterior))
								.addComponent(comboBox_HoraF, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textFecha, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnSiguiente))
								.addComponent(btnComprobar))))
					.addContainerGap(53, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblReserva)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtReserva, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(614))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
								.addContainerGap())
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblSocio)
								.addGap(45)
								.addComponent(txtSocio, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
								.addGap(29)
								.addComponent(lblNombre)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(lblApellidos)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblPrecio)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtPrecio, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblNewLabel_1)
								.addGap(107)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel_2)
									.addComponent(rdBtnEfectivo)
									.addComponent(rdBtnFinal))
								.addGap(65)))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(353)
					.addComponent(btnReserva)
					.addGap(37)
					.addComponent(btnResguardo)
					.addContainerGap(223, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitulo)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblInstalacion)
						.addComponent(comboBox_instalacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFecha)
						.addComponent(btnAnterior)
						.addComponent(textFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSiguiente))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHoraC)
						.addComponent(comboBox_HoraC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHoraF)
						.addComponent(comboBox_HoraF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnComprobar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSocio)
						.addComponent(txtSocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombre)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblApellidos)
						.addComponent(txtApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblReserva)
						.addComponent(txtReserva, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(txtPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_1))
								.addComponent(lblPrecio)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(rdBtnEfectivo)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdBtnFinal)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnReserva)
						.addComponent(btnResguardo))
					.addContainerGap(80, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getTxtSocio() {
		return txtSocio;
	}

	public JTextField getTxtApellidos() {
		return txtApellidos;
	}

	public void setTxtApellidos(String txtApellidos) {
		this.txtApellidos.setText(txtApellidos);;
	}

	public JTextField getTxtReserva() {
		return txtReserva;
	}

	public void setTxtReserva(String txtReserva) {
		this.txtReserva.setText(txtReserva);
	}

	public JComboBox getComboBox_HoraC() {
		return comboBox_HoraC;
	}

	public void setComboBox_HoraC(JComboBox comboBox_HoraC) {
		this.comboBox_HoraC = comboBox_HoraC;
	}

	public JComboBox getComboBox_HoraF() {
		return comboBox_HoraF;
	}

	public void setComboBox_HoraF(JComboBox comboBox_HoraF) {
		this.comboBox_HoraF = comboBox_HoraF;
	}

	

	public JComboBox<Object> getCbInstalacion() {return comboBox_instalacion;}
	
	public JComboBox<Object> getComboBox_instalacion() {
		return comboBox_instalacion;
	}

	public void setComboBox_instalacion(JComboBox<Object> comboBox_instalacion) {
		this.comboBox_instalacion = comboBox_instalacion;
	}


	public void setTxtSocio(JTextField txtSocio) {
		this.txtSocio = txtSocio;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public void setTxtApellidos(JTextField txtApellidos) {
		this.txtApellidos = txtApellidos;
	}

	public void setTxtReserva(JTextField txtReserva) {
		this.txtReserva = txtReserva;
	}

	public void setTxtPrecio(JTextField txtPrecio) {
		this.txtPrecio = txtPrecio;
	}

	public JRadioButton getRdBtnEfectivo() {
		return rdBtnEfectivo;
	}

	public void setRdBtnEfectivo(JRadioButton rdBtnEfectivo) {
		this.rdBtnEfectivo = rdBtnEfectivo;
	}

	public JRadioButton getRdBtnFinal() {
		return rdBtnFinal;
	}

	public void setRdBtnFinal(JRadioButton rdBtnFinal) {
		this.rdBtnFinal = rdBtnFinal;
	}

	public JButton getBtnReserva() {
		return btnReserva;
	}

	public void setBtnReserva(JButton btnReserva) {
		this.btnReserva = btnReserva;
	}

	public JButton getBtnResguardo() {
		return btnResguardo;
	}

	public void setBtnResguardo(JButton btnResguardo) {
		this.btnResguardo = btnResguardo;
	}

	public ButtonGroup getGrupo() {
		return grupo;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(String txtNombre) {
		this.txtNombre.setText(txtNombre);;
	}

	public JTextField getTxtPrecio() {
		return txtPrecio;
	}

	public void setTxtPrecio(String txtPrecio) {
		this.txtPrecio.setText(txtPrecio);;
	}

	public JTextField getTextFecha() {
		return textFecha;
	}

	public void setTextFecha(JTextField textFecha) {
		this.textFecha = textFecha;
	}

	public JButton getBtnAnterior() {
		return btnAnterior;
	}

	public void setBtnAnterior(JButton btnAnterior) {
		this.btnAnterior = btnAnterior;
	}

	public JButton getBtnSiguiente() {
		return btnSiguiente;
	}

	public void setBtnSiguiente(JButton btnSiguiente) {
		this.btnSiguiente = btnSiguiente;
	}

	public JButton getBtnComprobar() {
		return btnComprobar;
	}

	public void setBtnComprobar(JButton btnComprobar) {
		this.btnComprobar = btnComprobar;
	}
	
	
}