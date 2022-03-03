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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import java.awt.Dimension;
import com.toedter.calendar.JDateChooser;

public class CrearActividadView extends JFrame{

	private JFrame frame;
	private JTable tableDias;
	private JLabel lblNewLabel;
	
	private JLabel lblNewLabel_1;
	
	private JLabel lblDescripcion; 
	
	private JLabel lblFechaInicio; 
	
	private JLabel lblFechaFin ;
	
	private JLabel lblPlazas ;
	
	private JLabel lblPrecio ;
	
	private JLabel lblNmeroDeSesiones; 
	
	private JTextArea textArea_Nombre ;
	
	private JTextArea textArea_Descripcion;
	private JTextArea textArea_Precio ;
	private JLabel lblNewLabel_2;
	private JList list;
	private JComboBox comboBox_Plazas;
	private JComboBox comboBox_NumeroSesiones ;
	
	private JLabel lblPeriodoIncripcin ;
	
	private JComboBox comboBox_periodoIncripcion ;
	
	private JLabel lblPrecioNoSocio;
	
	private JTextArea textArea_Precio_1;
	
	private JLabel lblDeporte ;
	
	private JLabel lblInstalacion;
	
	private JComboBox comboBox_Deporte ;
	
	private JComboBox comboBox_Instalacion ;
	
	private JButton boton_LimpiarValores ;
	
	private JButton boton_CrearActividad;
	
	private JLabel lblNewLabel_3;
	
	private JDateChooser FechaInicio ;
	
	private JDateChooser FechaFin ;
	
	private JSpinner ILunes ;
	private JSpinner IDomingo ;
	private JSpinner IMartes ;
	private JSpinner IMiercoles ;
	private JSpinner IJueves ;
	private JSpinner ISabado ;
	private JSpinner IViernes ;

	private JSpinner FJueves ;
	private JSpinner FDomingo ;
	private JSpinner FViernes ;
	private JSpinner FSabado ;
	private JSpinner FMiercoles ;
	private JSpinner FLunes ;
	private JSpinner FMartes ;

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
		frame.setBounds(100, 100, 974, 754);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		
		JLabel lblNewLabel_1 = new JLabel("CREAR ACTIVIDAD");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		
		JLabel lblFechaInicio = new JLabel("Fecha Inicio:");
		
		JLabel lblFechaFin = new JLabel("Fecha Fin:");
		
		JLabel lblPlazas = new JLabel("Plazas:");
		
		JLabel lblPrecioSocio = new JLabel("Precio Socio:");
		
		JLabel lblNmeroDeSesiones = new JLabel("Número de sesiones:");
		
		JTextArea textArea_Nombre = new JTextArea();
		
		JTextArea textArea_Descripcion = new JTextArea();
		
		JTextArea textArea_Precio = new JTextArea();
		
		JLabel lblNewLabel_2 = new JLabel("€");
		
		JList list = new JList();
		
		JComboBox comboBox_Plazas = new JComboBox();
		comboBox_Plazas.setModel(new DefaultComboBoxModel(new String[] {"5", "10", "15", "20", "25", "30"}));
		
		JComboBox comboBox_NumeroSesiones = new JComboBox();
		comboBox_NumeroSesiones.setModel(new DefaultComboBoxModel(new String[] {"2", "4", "6", "8", "10", "12", "14", "16", "18", "20"}));
		
		lblPeriodoIncripcin = new JLabel("Periodo Incripción");
		
		JComboBox comboBox_periodoIncripcion = new JComboBox();
		comboBox_periodoIncripcion.setModel(new DefaultComboBoxModel(new String[] {"Verano", "Invierno", "Otoño", "Primavera", "Semana Santa"}));
		
		JLabel lblDeporte = new JLabel("Deporte");
		
		JLabel lblInstalacion = new JLabel("Instalacion");
		
		JComboBox comboBox_Deporte = new JComboBox();
		comboBox_Deporte.setModel(new DefaultComboBoxModel(new String[] {"Tenis", "Padel", "Yoga", "Spinning", "Natación"}));
		
		JComboBox comboBox_Instalacion = new JComboBox();
		comboBox_Instalacion.setModel(new DefaultComboBoxModel(new String[] {"Pista de Tenis 1", "Pista de Tenis 2", "Pista de Tenis 3", "Pista de Padel 1", "Pista de Padel 2", "Pista de Padel 3", "Piscina 1", "Piscina 2", "Sala de Spinning 1", "Sala de Spinning 2"}));
		
		JButton boton_LimpiarValores = new JButton("Limpiar valores");
		
		JButton boton_CrearActividad = new JButton("Crear Actividad");
		
		JLabel lblNewLabel_3 = new JLabel("Días y horas de las sesiones");
		
		tableDias = new JTable();
		tableDias.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableDias.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{"Lunes"},
				{"Martes"},
				{"Mi\u00E9rcoles"},
				{"Jueves"},
				{"Viernes"},
				{"Sabado"},
				{"Domingo"},
			},
			new String[] {
				"New column"
			}
		));
		
		JSpinner ILunes = new JSpinner();
		ILunes.setPreferredSize(new Dimension(26, 18));
		ILunes.setMinimumSize(new Dimension(26, 18));
		ILunes.setModel(new SpinnerListModel(new String[] {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		
		JSpinner IDomingo = new JSpinner();
		IDomingo.setModel(new SpinnerListModel(new String[] {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		IDomingo.setMinimumSize(new Dimension(26, 18));
		
		JSpinner IMartes = new JSpinner();
		IMartes.setModel(new SpinnerListModel(new String[] {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		IMartes.setPreferredSize(new Dimension(26, 18));
		IMartes.setMinimumSize(new Dimension(26, 18));
		
		JSpinner IMiercoles = new JSpinner();
		IMiercoles.setModel(new SpinnerListModel(new String[] {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		IMiercoles.setPreferredSize(new Dimension(26, 18));
		IMiercoles.setMinimumSize(new Dimension(26, 18));
		
		JSpinner IJueves = new JSpinner();
		IJueves.setModel(new SpinnerListModel(new String[] {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		IJueves.setPreferredSize(new Dimension(26, 18));
		IJueves.setMinimumSize(new Dimension(26, 18));
		
		JSpinner ISabado = new JSpinner();
		ISabado.setModel(new SpinnerListModel(new String[] {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		ISabado.setPreferredSize(new Dimension(26, 18));
		ISabado.setMinimumSize(new Dimension(26, 18));
		
		JSpinner IViernes = new JSpinner();
		IViernes.setModel(new SpinnerListModel(new String[] {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		IViernes.setPreferredSize(new Dimension(26, 18));
		IViernes.setMinimumSize(new Dimension(26, 18));
		
		JSpinner FJueves = new JSpinner();
		FJueves.setModel(new SpinnerListModel(new String[] {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		FJueves.setPreferredSize(new Dimension(26, 18));
		FJueves.setMinimumSize(new Dimension(26, 18));
		
		JSpinner FDomingo = new JSpinner();
		FDomingo.setModel(new SpinnerListModel(new String[] {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		FDomingo.setMinimumSize(new Dimension(26, 18));
		
		JSpinner FViernes = new JSpinner();
		FViernes.setModel(new SpinnerListModel(new String[] {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		FViernes.setPreferredSize(new Dimension(26, 18));
		FViernes.setMinimumSize(new Dimension(26, 18));
		
		JSpinner FSabado = new JSpinner();
		FSabado.setModel(new SpinnerListModel(new String[] {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		FSabado.setPreferredSize(new Dimension(26, 18));
		FSabado.setMinimumSize(new Dimension(26, 18));
		
		JSpinner FMiercoles = new JSpinner();
		FMiercoles.setModel(new SpinnerListModel(new String[] {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		FMiercoles.setPreferredSize(new Dimension(26, 18));
		FMiercoles.setMinimumSize(new Dimension(26, 18));
		
		JSpinner FLunes = new JSpinner();
		FLunes.setModel(new SpinnerListModel(new String[] {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		FLunes.setPreferredSize(new Dimension(26, 18));
		FLunes.setMinimumSize(new Dimension(26, 18));
		
		JSpinner FMartes = new JSpinner();
		FMartes.setModel(new SpinnerListModel(new String[] {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		FMartes.setPreferredSize(new Dimension(26, 18));
		FMartes.setMinimumSize(new Dimension(26, 18));
		
		JDateChooser FechaInicio = new JDateChooser();
		
		JDateChooser FechaFin = new JDateChooser();
		
		JLabel lblPrecioNoSocio = new JLabel("Precio No Socio:");
		
		JTextArea textArea_Precio_1 = new JTextArea();
		
		JLabel lblNewLabel_2_1 = new JLabel("€");
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(69)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel)
						.addComponent(lblDescripcion)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(textArea_Nombre, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(58)
									.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
								.addComponent(textArea_Descripcion, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(9)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblPlazas, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(comboBox_Plazas, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
									.addComponent(lblNmeroDeSesiones)
									.addGap(18)
									.addComponent(comboBox_NumeroSesiones, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblPeriodoIncripcin)
									.addGap(18)
									.addComponent(comboBox_periodoIncripcion, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_3))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(225)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addComponent(lblPrecioNoSocio, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblPrecioSocio, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblDeporte, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblInstalacion, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(comboBox_Instalacion, 0, 0, Short.MAX_VALUE)
										.addComponent(comboBox_Deporte, 0, 148, Short.MAX_VALUE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(textArea_Precio_1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(textArea_Precio, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblFechaInicio, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblFechaFin))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(FechaFin, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
										.addComponent(FechaInicio, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))))
							.addGap(130))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(157)
							.addComponent(boton_LimpiarValores)
							.addGap(31)
							.addComponent(boton_CrearActividad, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(90)
					.addComponent(tableDias, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(IMiercoles, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(ILunes, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(IMartes, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(IJueves, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(IDomingo, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(IViernes, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(ISabado, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(FLunes, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(FMartes, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(FMiercoles, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(FJueves, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(FViernes, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(FSabado, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(FDomingo, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(704, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(421)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(441, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel_1)
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textArea_Nombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDescripcion)
								.addComponent(textArea_Precio_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2_1)
								.addComponent(lblPrecioNoSocio))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textArea_Descripcion, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addGap(65))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(82)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(textArea_Precio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_2))
								.addComponent(lblPrecioSocio))
							.addPreferredGap(ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDeporte)
								.addComponent(comboBox_Deporte, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addComponent(comboBox_Instalacion, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPlazas)
								.addComponent(comboBox_Plazas, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNmeroDeSesiones)
								.addComponent(comboBox_NumeroSesiones, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(27)
									.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(comboBox_periodoIncripcion, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPeriodoIncripcin))))
							.addGap(49)
							.addComponent(lblNewLabel_3)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(tableDias, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(3)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createSequentialGroup()
												.addGap(18)
												.addComponent(IMartes, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
												.addGap(1)
												.addComponent(IMiercoles, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
											.addComponent(ILunes, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
										.addGap(3)
										.addComponent(IJueves, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(IViernes, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
										.addGap(1)
										.addComponent(ISabado, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
										.addGap(1)
										.addComponent(IDomingo, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
										.addGap(3)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(FLunes, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
									.addGap(2)
									.addComponent(FMartes, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
									.addGap(1)
									.addComponent(FMiercoles, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
									.addGap(3)
									.addComponent(FJueves, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(FViernes, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
									.addGap(1)
									.addComponent(FSabado, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
									.addGap(1)
									.addComponent(FDomingo, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblInstalacion)
									.addGap(99)
									.addComponent(lblFechaInicio))
								.addComponent(FechaInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblFechaFin)
								.addComponent(FechaFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(138)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(boton_CrearActividad)
								.addComponent(boton_LimpiarValores))))
					.addGap(97))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
