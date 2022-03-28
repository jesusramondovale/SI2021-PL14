package giis.demo.Proyecto.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class visualizaReservasInstalacionesView {

	private JFrame frame;
	private JTable tabla_disponibilidad;
	private JLabel Titulo;
	private JComboBox comboBox_instalacion;
	private JLabel label_instalacion;
	private JComboBox comboBox_fecha;
	private JButton btnComprobarReservsa;
	private JLabel lblFecha;	
	private JTextField txtFecha;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JTextField txtDNI;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					visualizaReservasInstalacionesView window = new visualizaReservasInstalacionesView();
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
	public visualizaReservasInstalacionesView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 546, 462);
		
		 Titulo = new JLabel("RESERVAS DE LAS INSTALACIONES EN LA ACTUALIDAD");
		Titulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		 label_instalacion = new JLabel("INSTALACIÓN");
		label_instalacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		 lblFecha = new JLabel("FECHA");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		comboBox_instalacion = new JComboBox();
		comboBox_instalacion.setModel(new DefaultComboBoxModel(new String[] {"--Instalación--"}));
		comboBox_instalacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JScrollPane scrollPane = new JScrollPane();
		
		btnComprobarReservsa = new JButton("Comprobar");
		btnComprobarReservsa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		txtFecha = new JTextField();
		txtFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFecha.setEnabled(false);
		txtFecha.setEditable(false);
		txtFecha.setColumns(10);
		
		btnAnterior = new JButton("<-");
		btnAnterior.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		btnSiguiente = new JButton("->");
		btnSiguiente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblNewLabel = new JLabel("Introduzca su DNI");
		
		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(Titulo, GroupLayout.PREFERRED_SIZE, 520, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_instalacion, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(comboBox_instalacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
							.addComponent(btnAnterior)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSiguiente, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnComprobarReservsa))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addComponent(lblFecha)))
					.addGap(27))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtDNI, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(318, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(Titulo)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_instalacion)
						.addComponent(lblFecha))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox_instalacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnComprobarReservsa)
						.addComponent(btnSiguiente, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAnterior))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
		);
		
		tabla_disponibilidad = new JTable();
		tabla_disponibilidad.setEnabled(false);
		tabla_disponibilidad.setModel(new DefaultTableModel(
			new Object[][] {
				{"6:00 - 7:00", null, "", null},
				{"7:00 - 8:00", null, null, null},
				{"8:00 - 9:00", null, null, null},
				{"9:00 - 10:00", null, null, ""},
				{"10:00 - 11:00", null, null, ""},
				{"11:00 - 12:00", null, null, null},
				{"12:00 - 13:00", null, null, null},
				{"13:00 - 14:00", null, null, null},
				{"14:00 - 15:00", null, null, null},
				{"15:00 - 16:00", null, null, null},
				{"16:00 - 17:00", null, null, null},
				{"17:00 - 18:00", null, null, null},
				{"18:00 - 19:00", null, null, null},
				{"19:00 - 20:00", null, null, null},
				{"20:00 - 21:00", null, null, null},
				{"21:00 - 22:00", null, null, null},
			},
			new String[] {
				"Hora", "Disponibilidad", "Socio", "Actividad"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				String.class, String.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(tabla_disponibilidad);
		frame.getContentPane().setLayout(groupLayout);
	}

	public String getTxtDNI() {
		return txtDNI.getText();
	}

	public void setTxtDNI(String txtDNI) {
		this.txtDNI.setText(txtDNI);
	}

	public void setTxtFecha(JTextField txtFecha) {
		this.txtFecha = txtFecha;
	}

	public String getTxtFecha() {
		return txtFecha.getText();
	}

	public void setTxtFecha(String txtFecha) {
		this.txtFecha.setText(txtFecha);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTable getTabla_disponibilidad() {
		return tabla_disponibilidad;
	}

	public void setTabla_disponibilidad(JTable tabla_disponibilidad) {
		this.tabla_disponibilidad = tabla_disponibilidad;
	}

	public JLabel getTitulo() {
		return Titulo;
	}

	public void setTitulo(JLabel titulo) {
		Titulo = titulo;
	}

	public JComboBox getComboBox_instalacion() {
		return comboBox_instalacion;
	}

	public void setComboBox_instalacion(JComboBox comboBox_instalacion) {
		this.comboBox_instalacion = comboBox_instalacion;
	}

	public JLabel getLabel_instalacion() {
		return label_instalacion;
	}

	public void setLabel_instalacion(JLabel label_instalacion) {
		this.label_instalacion = label_instalacion;
	}

	public JComboBox getComboBox_fecha() {
		return comboBox_fecha;
	}

	public void setComboBox_fecha(JComboBox comboBox_fecha) {
		this.comboBox_fecha = comboBox_fecha;
	}

	public JButton getBtnComprobarReservsa() {
		return btnComprobarReservsa;
	}

	public void setBtnComprobarReservsa(JButton btnComprobarReservsa) {
		this.btnComprobarReservsa = btnComprobarReservsa;
	}

	public JLabel getLblFecha() {
		return lblFecha;
	}

	public void setLblFecha(JLabel lblFecha) {
		this.lblFecha = lblFecha;
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
}
