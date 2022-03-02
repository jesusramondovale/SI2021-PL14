package giis.demo.Proyecto.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class visualizaReservasInstalacionesView {

	private JFrame frame;
	private JTable tabla_disponibilidad;
	private JLabel Titulo;
	private JComboBox comboBox_instalacion;
	private JLabel label_instalacion;
	private JComboBox comboBox_fecha;
	private JButton btnComprobarReservsa;
	private JLabel lblFecha;	

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
		frame.setBounds(100, 100, 536, 376);
		
		JLabel Titulo = new JLabel("RESERVAS DE LAS INSTALACIONES EN LA ACTUALIDAD");
		Titulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel label_instalacion = new JLabel("INSTALACIÓN");
		label_instalacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblFecha = new JLabel("FECHA");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox comboBox_instalacion = new JComboBox();
		comboBox_instalacion.setModel(new DefaultComboBoxModel(new String[] {"--Instalación--"}));
		comboBox_instalacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JComboBox comboBox_fecha = new JComboBox();
		comboBox_fecha.setMaximumRowCount(30);
		comboBox_fecha.setModel(new DefaultComboBoxModel(new String[] {"02/03/2022", "03/03/2022", "04/03/2022", "05/03/2022", "06/03/2022", "07/03/2022", "08/03/2022", "09/03/2022", "10/03/2022", "11/03/2022", "12/03/2022"}));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnComprobarReservsa = new JButton("Comprobar");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(Titulo, GroupLayout.PREFERRED_SIZE, 520, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(60)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(comboBox_instalacion, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(label_instalacion, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(72)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(comboBox_fecha, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addGap(73)
							.addComponent(btnComprobarReservsa))
						.addComponent(lblFecha))
					.addGap(48))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 519, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
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
						.addComponent(btnComprobarReservsa)
						.addComponent(comboBox_fecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
		);
		
		tabla_disponibilidad = new JTable();
		tabla_disponibilidad.setModel(new DefaultTableModel(
			new Object[][] {
				{"6:00 - 7:00", Boolean.FALSE, "", null},
				{"7:00 - 8:00", null, null, null},
				{"8:00 - 9:00", null, null, null},
				{"9:00 - 10:00", Boolean.FALSE, null, ""},
				{"10:00 - 11:00", Boolean.FALSE, null, ""},
				{"11:00 - 12:00", null, null, null},
				{"12:00 - 13:00", Boolean.FALSE, null, null},
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
			Class[] columnTypes = new Class[] {
				String.class, Boolean.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(tabla_disponibilidad);
		frame.getContentPane().setLayout(groupLayout);
	}
}
