package giis.demo.Proyecto.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

public class resguardoView {

	private JFrame frame;
	private JTextField txtSocioR;
	private JTextField txtNombreR;
	private JTextField txtApellidosR;
	private JTextField txtReservaR;
	private JTextField txtInstalacionR;
	private JTextField txtPagoR;
	private JTextField txtPrecioR;
	private JTextField txtHora1R;
	private JTextField txtHora2R;
	private JTextField txtFecha;
	private JButton btnImprimir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					resguardoView window = new resguardoView();
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
	public resguardoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 561, 374);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblTitulo = new JLabel("RESGUARDO DE LA RESERVA DE LA INSTALACIÓN");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel = new JLabel("Nº Socio");
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos\r\n");
		
		JLabel lblNewLabel_3 = new JLabel("Nº Reserva");
		
		JLabel lblNewLabel_4 = new JLabel("Instalación");
		
		JLabel lblNewLabel_5 = new JLabel("Forma de pago");
		
		JLabel lblNewLabel_6 = new JLabel("Precio reserva");
		
		JLabel lblNewLabel_7 = new JLabel("Fecha");
		
		JLabel lblNewLabel_8 = new JLabel("Intervalo de horas");
		
		txtSocioR = new JTextField();
		txtSocioR.setEditable(false);
		txtSocioR.setColumns(10);
		
		txtNombreR = new JTextField();
		txtNombreR.setEditable(false);
		txtNombreR.setColumns(10);
		
		txtApellidosR = new JTextField();
		txtApellidosR.setEditable(false);
		txtApellidosR.setColumns(10);
		
		txtReservaR = new JTextField();
		txtReservaR.setEditable(false);
		txtReservaR.setColumns(10);
		
		txtInstalacionR = new JTextField();
		txtInstalacionR.setEditable(false);
		txtInstalacionR.setColumns(10);
		
		txtPagoR = new JTextField();
		txtPagoR.setEditable(false);
		txtPagoR.setColumns(10);
		
		txtPrecioR = new JTextField();
		txtPrecioR.setEditable(false);
		txtPrecioR.setColumns(10);
		
		txtHora1R = new JTextField();
		txtHora1R.setEditable(false);
		txtHora1R.setColumns(10);
		
		txtHora2R = new JTextField();
		txtHora2R.setEditable(false);
		txtHora2R.setColumns(10);
		
		btnImprimir = new JButton("IMPRIMIR");
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_7)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_8)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(txtHora1R, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
											.addComponent(txtHora2R, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
											.addGap(77))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_5)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtPagoR, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
											.addGap(74)
											.addComponent(lblNewLabel_6)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(txtPrecioR, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnImprimir)))
								.addComponent(lblTitulo))
							.addGap(51))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel)
								.addGap(26)
								.addComponent(txtSocioR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel_1)
									.addComponent(lblNewLabel_2))
								.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(txtNombreR, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtApellidosR, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtInstalacionR, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtReservaR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitulo)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtSocioR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(txtNombreR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(txtApellidosR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(txtReservaR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(txtInstalacionR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_5)
								.addComponent(lblNewLabel_6)
								.addComponent(txtPrecioR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_7)
								.addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(txtPagoR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_8)
								.addComponent(txtHora1R, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtHora2R, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(38, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnImprimir)
							.addContainerGap())))
		);
		frame.getContentPane().setLayout(groupLayout);
		
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getTxtSocioR() {
		return txtSocioR;
	}

	public void setTxtSocioR(JTextField txtSocioR) {
		this.txtSocioR = txtSocioR;
	}

	public JTextField getTxtNombreR() {
		return txtNombreR;
	}

	public void setTxtNombreR(JTextField txtNombreR) {
		this.txtNombreR = txtNombreR;
	}

	public JTextField getTxtApellidosR() {
		return txtApellidosR;
	}

	public void setTxtApellidosR(JTextField txtApellidosR) {
		this.txtApellidosR = txtApellidosR;
	}

	public JTextField getTxtReservaR() {
		return txtReservaR;
	}

	public void setTxtReservaR(JTextField txtReservaR) {
		this.txtReservaR = txtReservaR;
	}

	public String getTxtInstalacionR() {
		return txtInstalacionR.getText();
	}

	public void setTxtInstalacionR(String string) {
		this.txtInstalacionR.setText(string);;
	}

	public String getTxtPagoR() {
		return txtPagoR.getText();
	}

	public void setTxtPagoR(String txtPagoR) {
		this.txtPagoR.setText(txtPagoR);
	}

	public JTextField getTxtPrecioR() {
		return txtPrecioR;
	}

	public void setTxtPrecioR(JTextField txtPrecioR) {
		this.txtPrecioR = txtPrecioR;
	}

	public String getTxtHora1R() {
		return txtHora1R.getText();
	}

	public void setTxtHora1R(String txtHora1R) {
		this.txtHora1R.setText(txtHora1R);;
	}

	public String getTxtHora2R() {
		return txtHora2R.getText();
	}

	public void setTxtHora2R(String txtHora2R) {
		this.txtHora2R.setText(txtHora2R);
	}

	public JTextField getTxtFecha() {
		return txtFecha;
	}

	public void setTxtFecha(String txtFecha) {
		this.txtFecha.setText(txtFecha);;
	}

	public JButton getBtnImprimir() {
		return btnImprimir;
	}

	public void setBtnImprimir(JButton btnImprimir) {
		this.btnImprimir = btnImprimir;
	}

}
