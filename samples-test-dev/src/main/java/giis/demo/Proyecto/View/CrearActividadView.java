package giis.demo.Proyecto.View;

import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings({ "serial", "unused" })
public class CrearActividadView extends JFrame{

	private String [] periodos;
	private JFrame frame;
	private JTable tableDias;
	private JLabel lblNewLabel;

	private JLabel lblDescripcion; 

	private JLabel lblFechaInicio; 

	private JLabel lblFechaFin ;

	private JLabel lblPlazas ;

	private JLabel lblPrecio ;

	private JTextArea textArea_Nombre ;
	private JTextArea textArea_Nombre_1;

	private JTextArea textArea_Descripcion;
	private JTextArea PrecioSocio ;
	private JLabel lblNewLabel_2;
	@SuppressWarnings("rawtypes")
	private JList list;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_Plazas;
	private JComboBox comboBox_Plazas_1;

	private JLabel lblPeriodoIncripcin ;

	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_periodoIncripcion ;
	private JComboBox comboBox_periodoIncripcion_1;

	private JLabel lblPrecioNoSocio;

	private JLabel lblPrecioSocio;

	private JTextArea PrecioNoSocio;

	private JLabel lblDeporte ;

	private JLabel lblInstalacion;

	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_Deporte ;

	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_Instalacion ;
	private JComboBox comboBox_Instalacion_1;

	private JButton boton_LimpiarValores ;

	private JButton boton_CrearActividad;
	private JButton boton_CrearActividad_1;
	private JLabel lblNewLabel_2_1 ;

	private JLabel lblNewLabel_3;
	private JLabel Tipo;

	private JDateChooser FechaInicio ;

	private JDateChooser FechaFin ;

	private JSpinner ILunes ;
	private JSpinner FLunes ;
	private JTextField Tipo_deporte;
	private JTextArea textArea_Precio;
	private JTextField textFieldIdActividad;
	private JLabel lblHorario;

	/**
	 * Launch the application.
	 */
	/*
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
	}*/

	/**
	 * Create the application.
	 */

	public CrearActividadView() {
		this.initialize();
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTable getTableDias() {
		return tableDias;
	}

	public void setTableDias(JTable tableDias) {
		this.tableDias = tableDias;
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}


	public JLabel getLblDescripcion() {
		return lblDescripcion;
	}

	public void setLblDescripcion(JLabel lblDescripcion) {
		this.lblDescripcion = lblDescripcion;
	}

	public JLabel getLblFechaInicio() {
		return lblFechaInicio;
	}

	public void setLblFechaInicio(JLabel lblFechaInicio) {
		this.lblFechaInicio = lblFechaInicio;
	}



	public JTextArea getPrecioSocio() {
		return PrecioSocio;
	}

	public void setPrecioSocio(JTextArea precioSocio) {
		PrecioSocio = precioSocio;
	}

	public JTextArea getPrecioNoSocio() {
		return PrecioNoSocio;
	}

	public void setPrecioNoSocio(JTextArea precioNoSocio) {
		PrecioNoSocio = precioNoSocio;
	}

	public JLabel getTipo() {
		return Tipo;
	}

	public void setTipo(JLabel tipo) {
		Tipo = tipo;
	}

	public JTextField getTipo_deporte() {
		return Tipo_deporte;
	}

	public void setTipo_deporte(JTextField tipo_deporte) {
		Tipo_deporte = tipo_deporte;
	}

	public JLabel getLblFechaFin() {
		return lblFechaFin;
	}

	public void setLblFechaFin(JLabel lblFechaFin) {
		this.lblFechaFin = lblFechaFin;
	}

	public JLabel getLblPlazas() {
		return lblPlazas;
	}

	public void setLblPlazas(JLabel lblPlazas) {
		this.lblPlazas = lblPlazas;
	}

	public JLabel getLblPrecio() {
		return lblPrecio;
	}

	public void setLblPrecio(JLabel lblPrecio) {
		this.lblPrecio = lblPrecio;
	}

	public JTextArea getTextArea_Nombre() {
		return textArea_Nombre_1;
	}

	public void setTextArea_Nombre(JTextArea textArea_Nombre) {
		this.textArea_Nombre_1 = textArea_Nombre;
	}

	public JTextArea getTextArea_Descripcion() {
		return textArea_Descripcion;
	}

	public void setTextArea_Descripcion(JTextArea textArea_Descripcion) {
		this.textArea_Descripcion = textArea_Descripcion;
	}

	public JTextArea getTextArea_Precio() {
		return PrecioSocio;
	}

	public void setTextArea_Precio(JTextArea textArea_Precio) {
		this.PrecioSocio = textArea_Precio;
	}

	public JLabel getLblNewLabel_2() {
		return lblNewLabel_2;
	}

	public void setLblNewLabel_2(JLabel lblNewLabel_2) {
		this.lblNewLabel_2 = lblNewLabel_2;
	}

	@SuppressWarnings("rawtypes")
	public JList getList() {
		return list;
	}

	@SuppressWarnings("rawtypes")
	public void setList(JList list) {
		this.list = list;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getComboBox_Plazas() {
		return comboBox_Plazas_1;
	}

	@SuppressWarnings("rawtypes")
	public void setComboBox_Plazas(JComboBox comboBox_Plazas) {
		this.comboBox_Plazas_1 = comboBox_Plazas;
	}

	public JLabel getLblPeriodoIncripcin() {
		return lblPeriodoIncripcin;
	}

	public void setLblPeriodoIncripcin(JLabel lblPeriodoIncripcin) {
		this.lblPeriodoIncripcin = lblPeriodoIncripcin;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getComboBox_periodoIncripcion() {
		return comboBox_periodoIncripcion_1;
	}

	@SuppressWarnings("rawtypes")
	public void setComboBox_periodoIncripcion(JComboBox comboBox_periodoIncripcion) {
		this.comboBox_periodoIncripcion_1 = comboBox_periodoIncripcion;
	}

	public JLabel getLblPrecioNoSocio() {
		return lblPrecioNoSocio;
	}

	public void setLblPrecioNoSocio(JLabel lblPrecioNoSocio) {
		this.lblPrecioNoSocio = lblPrecioNoSocio;
	}

	public JLabel getLblPrecioSocio() {
		return lblPrecioSocio;
	}

	public void setLblPrecioSocio(JLabel lblPrecioSocio) {
		this.lblPrecioSocio = lblPrecioSocio;
	}

	public JTextArea getTextArea_Precio_1() {
		return PrecioNoSocio;
	}

	public void setTextArea_Precio_1(JTextArea textArea_Precio_1) {
		this.PrecioNoSocio = textArea_Precio_1;
	}

	public JLabel getLblDeporte() {
		return lblDeporte;
	}

	public void setLblDeporte(JLabel lblDeporte) {
		this.lblDeporte = lblDeporte;
	}

	public JLabel getLblInstalacion() {
		return lblInstalacion;
	}

	public void setLblInstalacion(JLabel lblInstalacion) {
		this.lblInstalacion = lblInstalacion;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getComboBox_Deporte() {
		return comboBox_Deporte;
	}

	@SuppressWarnings("rawtypes")
	public void setComboBox_Deporte(JComboBox comboBox_Deporte) {
		this.comboBox_Deporte = comboBox_Deporte;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getComboBox_Instalacion() {
		return comboBox_Instalacion_1;
	}

	@SuppressWarnings("rawtypes")
	public void setComboBox_Instalacion(JComboBox comboBox_Instalacion) {
		this.comboBox_Instalacion_1 = comboBox_Instalacion;
	}

	public JButton getBoton_LimpiarValores() {
		return boton_LimpiarValores;
	}

	public void setBoton_LimpiarValores(JButton boton_LimpiarValores) {
		this.boton_LimpiarValores = boton_LimpiarValores;
	}

	public JButton getBoton_CrearActividad() {
		return boton_CrearActividad_1;
	}

	public void setBoton_CrearActividad(JButton boton_CrearActividad) {
		this.boton_CrearActividad_1 = boton_CrearActividad;
	}

	public JLabel getLblNewLabel_2_1() {
		return lblNewLabel_2_1;
	}

	public void setLblNewLabel_2_1(JLabel lblNewLabel_2_1) {
		this.lblNewLabel_2_1 = lblNewLabel_2_1;
	}

	public JLabel getLblNewLabel_3() {
		return lblNewLabel_3;
	}

	public void setLblNewLabel_3(JLabel lblNewLabel_3) {
		this.lblNewLabel_3 = lblNewLabel_3;
	}

	public JDateChooser getFechaInicio() {
		return FechaInicio;
	}

	public void setFechaInicio(JDateChooser fechaInicio) {
		FechaInicio = fechaInicio;
	}

	public JDateChooser getFechaFin() {
		return FechaFin;
	}

	public void setFechaFin(JDateChooser fechaFin) {
		FechaFin = fechaFin;
	}

	public JSpinner getILunes() {
		return ILunes;
	}

	public void setILunes(JSpinner iLunes) {
		ILunes = iLunes;
	}

	
	public JTextField getTextFieldIdActividad() {
		return textFieldIdActividad;
	}

	public void setTextFieldIdActividad(JTextField textFieldIdActividad) {
		this.textFieldIdActividad = textFieldIdActividad;
	}






	public JSpinner getFLunes() {
		return FLunes;
	}

	public void setFLunes(JSpinner fLunes) {
		FLunes = fLunes;
	}

	

	public String[] getPeriodos() {
		return periodos;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frame = new JFrame("Crear Actividad");
		frame.setBounds(100, 100, 800, 511);

		lblNewLabel = new JLabel("Nombre:");


		lblFechaInicio = new JLabel("Fecha Inicio:");

		lblFechaFin = new JLabel("Fecha Fin:");

		lblPlazas = new JLabel("Plazas:");

		lblPrecioSocio = new JLabel("Precio Socio:");

		textArea_Nombre = new JTextArea();

		PrecioSocio = new JTextArea();

		lblNewLabel_2 = new JLabel("€");

		list = new JList();

		comboBox_Plazas = new JComboBox();

		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		
		JLabel lblFechaInicio = new JLabel("Fecha Inicio:");
		
		JLabel lblFechaFin = new JLabel("Fecha Fin:");
		
		JLabel lblPlazas = new JLabel("Plazas:");
		
		JLabel lblPrecioSocio = new JLabel("Precio Socio:");
		
		
		JLabel lblNmeroDeSesiones = new JLabel("Número de sesiones:");
		
		textArea_Nombre_1 = new JTextArea();
		
		textArea_Descripcion = new JTextArea();
		
		textArea_Precio = new JTextArea();
		
		JLabel lblNewLabel_2 = new JLabel("€");
		
		JList list = new JList();
		
		comboBox_Plazas_1 = new JComboBox();
		comboBox_Plazas_1.setModel(new DefaultComboBoxModel(new String[] {"5", "10", "15", "20", "25", "30"}));

		lblPeriodoIncripcin = new JLabel("Periodo Incripción");



		comboBox_periodoIncripcion = new JComboBox();


		lblInstalacion = new JLabel("Instalacion");

		comboBox_Instalacion = new JComboBox();
		comboBox_Instalacion.setModel(new DefaultComboBoxModel(new String[] {"pista de pádel", "campo de futbito", "cancha de baloncesto", "salon de yoga", "cancha de balonmano", "piscina"}));

		boton_CrearActividad = new JButton("Crear Actividad");

		lblNewLabel_3 = new JLabel("Días y horas de las sesiones");

		
		//AQUI
		
		comboBox_periodoIncripcion_1 = new JComboBox();
		comboBox_periodoIncripcion_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		JLabel lblDeporte = new JLabel("Deporte");
		
		JLabel lblInstalacion = new JLabel("Instalacion");
		
		comboBox_Deporte = new JComboBox();
		comboBox_Deporte.setModel(new DefaultComboBoxModel(new String[] {"Tenis", "Padel", "Yoga", "Spinning", "Natación"}));
		
		comboBox_Instalacion_1 = new JComboBox();
		comboBox_Instalacion_1.setModel(new DefaultComboBoxModel(new String[] {"pista de pádel", "campo de futbito", "cancha de baloncesto", "salon de yoga", "cancha de balonmano", "piscina"}));
		
		boton_LimpiarValores = new JButton("Limpiar valores");
		
		boton_CrearActividad_1 = new JButton("Crear Actividad");
			
		
		
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

		ILunes = new JSpinner();
		ILunes.setPreferredSize(new Dimension(26, 18));
		ILunes.setMinimumSize(new Dimension(26, 18));
		ILunes.setModel(new SpinnerListModel(new String[] {"9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21"}));

		FLunes = new JSpinner();
		FLunes.setModel(new SpinnerListModel(new String[] {"9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21"}));
		FLunes.setPreferredSize(new Dimension(26, 18));
		FLunes.setMinimumSize(new Dimension(26, 18));

		FechaInicio = new JDateChooser();

		FechaFin = new JDateChooser();

		lblPrecioNoSocio = new JLabel("Precio No Socio:");

		PrecioNoSocio = new JTextArea();

		lblNewLabel_2_1 = new JLabel("€");

		Tipo = new JLabel("Tipo");

		Tipo_deporte = new JTextField();

		Tipo_deporte.setColumns(10);
		
		JLabel lblId = new JLabel("ID: ");
		
		textFieldIdActividad = new JTextField();
		textFieldIdActividad.setColumns(10);
		
		lblHorario = new JLabel("HORARIO");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(127)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(650, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(69)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPeriodoIncripcin)
							.addGap(36)
							.addComponent(comboBox_periodoIncripcion_1, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(12)
									.addComponent(tableDias, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(ILunes, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(FLunes, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblHorario)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblId)
										.addComponent(lblPlazas, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(Tipo, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
											.addGap(10))
										.addComponent(lblNewLabel))
									.addGap(32)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textArea_Nombre_1, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
										.addComponent(textFieldIdActividad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(Tipo_deporte)
											.addComponent(comboBox_Plazas_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)))))
							.addPreferredGap(ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(lblFechaInicio, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblPrecioNoSocio, GroupLayout.PREFERRED_SIZE, 91, Short.MAX_VALUE)
											.addComponent(lblPrecioSocio, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblInstalacion, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblFechaFin))
									.addGap(10)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(FechaFin, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(PrecioNoSocio, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(PrecioSocio, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)))
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addGap(12)
													.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup()
													.addGap(14)
													.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))))
										.addComponent(comboBox_Instalacion_1, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
										.addComponent(FechaInicio, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(boton_CrearActividad_1)
									.addGap(65)))))
					.addGap(100))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblId)
								.addComponent(textFieldIdActividad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPrecioNoSocio)
								.addComponent(PrecioNoSocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(3))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel_2_1)
							.addGap(4)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textArea_Nombre_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(Tipo_deporte, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox_Plazas_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPlazas))
							.addGap(39)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPeriodoIncripcin)
								.addComponent(comboBox_periodoIncripcion_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
							.addComponent(lblNewLabel_3))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPrecioSocio)
								.addComponent(Tipo)
								.addComponent(PrecioSocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2))
							.addGap(45)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblInstalacion)
								.addComponent(comboBox_Instalacion_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
							.addGap(51)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFechaInicio)
								.addComponent(FechaInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(6)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tableDias, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblHorario)
									.addGap(6)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(ILunes, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
										.addComponent(FLunes, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblFechaFin))
									.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
									.addComponent(boton_CrearActividad_1)
									.addGap(20))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(40)
							.addComponent(FechaFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addGap(240))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setPeriodos(String[] value) {
		periodos=value;
		comboBox_periodoIncripcion_1.setModel(new DefaultComboBoxModel(periodos));

	}
	public String[] getListainstalacion() {
		return periodos;
	}
}
