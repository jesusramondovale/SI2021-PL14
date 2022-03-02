package giis.demo.Proyecto.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class CrearActividadView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearActividadView window = new CrearActividadView();
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
	public CrearActividadView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 593, 607);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		
		JLabel lblNewLabel_1 = new JLabel("CREAR ACTIVIDAD");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		
		JLabel lblFechaInicio = new JLabel("Fecha Inicio:");
		
		JLabel lblFechaFin = new JLabel("Fecha Fin:");
		
		JLabel lblPlazas = new JLabel("Plazas:");
		
		JLabel lblPrecio = new JLabel("Precio:");
		
		JLabel lblNmeroDeSesiones = new JLabel("Número de sesiones:");
		
		JTextArea textArea = new JTextArea();
		
		JTextArea textArea_1 = new JTextArea();
		
		JTextArea textArea_3 = new JTextArea();
		
		JLabel lblNewLabel_2 = new JLabel("€");
		
		JList list = new JList();
		
		JComboBox comboBox = new JComboBox();
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"5", "10", "15", "20", "25", "30"}));
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"2", "4", "6", "8", "10", "12", "14", "16", "18", "20"}));
		
		JComboBox comboBox_1 = new JComboBox();
		
		JLabel lblPeriodoIncripcin = new JLabel("Periodo Incripción");
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Verano", "Invierno", "Otoño", "Primavera", "Semana Santa"}));
		
		JButton btnNewButton = new JButton("Crear Periodo Incripción");
		
		JLabel lblDeporte = new JLabel("Deporte");
		
		JLabel lblInstalacion = new JLabel("Instalacion");
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"Tenis", "Padel", "Yoga", "Spinning", "Natación"}));
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"Pista de Tenis 1", "Pista de Tenis 2", "Pista de Tenis 3", "Pista de Padel 1", "Pista de Padel 2", "Pista de Padel 3", "Piscina 1", "Piscina 2", "Sala de Spinning 1", "Sala de Spinning 2"}));
		
		JButton btnNewButton_1 = new JButton("Limpiar valores");
		
		JButton btnNewButton_1_1 = new JButton("Crear Actividad");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(222, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
					.addGap(182))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(15)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel)
										.addComponent(lblDescripcion))
									.addGap(3)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(17)
											.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(211)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(btnNewButton_1)
												.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)))))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblPeriodoIncripcin)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblFechaInicio, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblFechaFin))
									.addGap(14)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
										.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))))))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblPlazas, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblPrecio, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textArea_3, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNmeroDeSesiones)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblDeporte, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblInstalacion, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(comboBox_6, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
										.addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel_1)
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblPlazas)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(lblDescripcion)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPrecio)
								.addComponent(textArea_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2))
							.addGap(43)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDeporte)
								.addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblInstalacion)
								.addComponent(comboBox_6, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNmeroDeSesiones)
								.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
							.addGap(79))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(40)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPeriodoIncripcin)
								.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton)
							.addGap(146)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFechaInicio)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFechaFin)
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_1)
								.addComponent(btnNewButton_1_1))
							.addContainerGap())))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
