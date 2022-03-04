package giis.demo.Proyecto.view;

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
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class realizarReservaView {

	private JFrame frame;
	private JTextField txtFecha;
	private JTextField txtSocio;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtReserva;
	private JTextField txtPrecio;
	private JComboBox comboBox_HoraC;
	private JComboBox comboBox_HoraF;
	private JButton btnDispo;
	private JComboBox comboBox_instalacion;
	private JRadioButton rdBtnEfectivo;
	private JRadioButton rdBtnFinal;
	private final ButtonGroup grupo = new ButtonGroup();
	private JButton btnReserva;
	private JButton btnResguardo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					realizarReservaView window = new realizarReservaView();
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
	public realizarReservaView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 657, 492);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblTitulo = new JLabel("RESERVA DE INSTALACIONES");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblInstalacion = new JLabel("Instalación");
		
		comboBox_instalacion = new JComboBox();
		comboBox_instalacion.setModel(new DefaultComboBoxModel(new String[] {"--Instalación--"}));
		
		JLabel lblFecha = new JLabel("Fecha");
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		
		JLabel lblHoraC = new JLabel("Hora comienzo");
		
		comboBox_HoraC = new JComboBox();
		
		JLabel lblHoraF = new JLabel("Hora fin");
		
		comboBox_HoraF = new JComboBox();
		
		JLabel lblDisponible = new JLabel("Disponibilidad");
		
		btnDispo = new JButton("");
		
		JLabel lblNewLabel = new JLabel("----------------------------------------------------------------------------------------------------------");
		
		JLabel lblSocio = new JLabel("Nº Socio");
		
		txtSocio = new JTextField();
		txtSocio.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		
		JLabel lblReserva = new JLabel("Nº Reserva");
		
		txtReserva = new JTextField();
		txtReserva.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio Reserva\r\n");
		
		txtPrecio = new JTextField();
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
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblHoraC)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBox_HoraC, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
							.addGap(51)
							.addComponent(lblHoraF, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox_HoraF, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblDisponible)
							.addGap(18)
							.addComponent(btnDispo))
						.addComponent(lblTitulo, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblInstalacion, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox_instalacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(72)
							.addComponent(lblFecha)
							.addGap(26)
							.addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
				.addComponent(lblNewLabel)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPrecio)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtPrecio, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSocio)
							.addPreferredGap(ComponentPlacement.RELATED)
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
							.addComponent(lblReserva)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtReserva, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(62)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(rdBtnFinal)
										.addComponent(rdBtnEfectivo)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnReserva)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnResguardo))))))
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
						.addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnDispo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblHoraC)
							.addComponent(comboBox_HoraC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblHoraF)
							.addComponent(comboBox_HoraF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblDisponible)))
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
					.addGap(48)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblReserva)
						.addComponent(txtReserva, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(37)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPrecio)
								.addComponent(txtPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1)))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdBtnEfectivo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdBtnFinal)))
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnReserva)
						.addComponent(btnResguardo))
					.addGap(26))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public String getTxtSocio() {
		return txtSocio.getText();
	}

	public void setTxtSocio(String txtSocio) {
		this.txtSocio.setText(txtSocio);
	}


	public String getTxtApellidos() {
		return txtApellidos.getText();
	}

	public void setTxtApellidos(String txtApellidos) {
		this.txtApellidos.setText(txtApellidos);;
	}

	public String getTxtReserva() {
		return txtReserva.getText();
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

	public JButton getBtnDispo() {
		return btnDispo;
	}

	public void setBtnDispo(JButton btnDispo) {
		this.btnDispo = btnDispo;
	}

	public JComboBox getComboBox_instalacion() {
		return comboBox_instalacion;
	}

	public void setComboBox_instalacion(JComboBox comboBox_instalacion) {
		this.comboBox_instalacion = comboBox_instalacion;
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

	public String getTxtFecha() {
		return txtFecha.getText();
	}

	public void setTxtFecha(String string) {
		this.txtFecha.setText(string);;
	}

	public String getTxtNombre() {
		return txtNombre.getText();
	}

	public void setTxtNombre(String txtNombre) {
		this.txtNombre.setText(txtNombre);;
	}

	public String getTxtPrecio() {
		return txtPrecio.getText();
	}

	public void setTxtPrecio(String txtPrecio) {
		this.txtPrecio.setText(txtPrecio);;
	}
	
	
}
