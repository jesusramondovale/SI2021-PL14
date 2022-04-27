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
	private JTextField Tipo_deporte;
	private JTextArea textArea_Precio;
	private JTextField textFieldIdActividad;
	private JLabel lblHorario;
	private JTextField textField_ILunes;
	private JTextField textField_FLunes;
	private JTextField textField_IMartes;
	private JTextField textField_FMartes;
	private JTextField textField_IMiercoles;
	private JTextField textField_FMiercoles;
	private JTextField textField_IJueves;
	private JLabel lblNewLabel_5;
	private JTextField textField_FJueves;
	private JLabel lblNewLabel_6;
	private JTextField textField_IViernes;
	private JLabel lblNewLabel_7;
	private JTextField textField_FViernes;
	private JLabel lblNewLabel_8;
	private JTextField textField_ISabado;
	private JLabel lblNewLabel_9;
	private JTextField textField_FSabado;
	private JLabel lblNewLabel_10;
	private JTextField textField_IDomingo;
	private JLabel lblNewLabel_11;
	private JTextField textField_FDomingo;
	private JLabel lblNewLabel_12;

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

	
	public JTextField getTextFieldIdActividad() {
		return textFieldIdActividad;
	}

	public void setTextFieldIdActividad(JTextField textFieldIdActividad) {
		this.textFieldIdActividad = textFieldIdActividad;
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
		frame.setBounds(100, 100, 528, 487);

		lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(34, 56, 67, 14);


		lblFechaInicio = new JLabel("Fecha Inicio:");

		lblFechaFin = new JLabel("Fecha Fin:");

		lblPlazas = new JLabel("Plazas:");

		lblPrecioSocio = new JLabel("Precio Socio:");

		textArea_Nombre = new JTextArea();

		PrecioSocio = new JTextArea();
		PrecioSocio.setBounds(292, 229, 93, 22);

		lblNewLabel_2 = new JLabel("€");

		list = new JList();

		comboBox_Plazas = new JComboBox();

		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		
		JLabel lblFechaInicio = new JLabel("Fecha Inicio:");
		lblFechaInicio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFechaInicio.setBounds(178, 308, 187, 14);
		
		JLabel lblFechaFin = new JLabel("Fecha Fin:");
		lblFechaFin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFechaFin.setBounds(178, 333, 187, 14);
		
		JLabel lblPlazas = new JLabel("Plazas:");
		lblPlazas.setBounds(34, 106, 82, 14);
		
		JLabel lblPrecioSocio = new JLabel("Precio Socio:");
		lblPrecioSocio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrecioSocio.setBounds(178, 233, 187, 14);
		
		
		JLabel lblNmeroDeSesiones = new JLabel("Número de sesiones:");
		
		textArea_Nombre_1 = new JTextArea();
		textArea_Nombre_1.setBounds(144, 51, 100, 22);
		
		textArea_Descripcion = new JTextArea();
		
		textArea_Precio = new JTextArea();
		
		JLabel lblNewLabel_2 = new JLabel("€");
		lblNewLabel_2.setBounds(395, 237, 48, 14);
		
		JList list = new JList();
		list.setBounds(127, 308, 1, 1);
		
		comboBox_Plazas_1 = new JComboBox();
		comboBox_Plazas_1.setBounds(197, 100, 47, 26);
		comboBox_Plazas_1.setModel(new DefaultComboBoxModel(new String[] {"5", "10", "15", "20", "25", "30"}));

		lblPeriodoIncripcin = new JLabel("Periodo Incripción");
		lblPeriodoIncripcin.setBounds(34, 131, 114, 14);



		comboBox_periodoIncripcion = new JComboBox();


		lblInstalacion = new JLabel("Instalacion");

		comboBox_Instalacion = new JComboBox();
		comboBox_Instalacion.setModel(new DefaultComboBoxModel(new String[] {"pista de pádel", "campo de futbito", "cancha de baloncesto", "salon de yoga", "cancha de balonmano", "piscina"}));

		boton_CrearActividad = new JButton("Crear Actividad");

		lblNewLabel_3 = new JLabel("Días y horas de las sesiones");

		
		//AQUI
		
		comboBox_periodoIncripcion_1 = new JComboBox();
		comboBox_periodoIncripcion_1.setBounds(158, 125, 86, 26);
		comboBox_periodoIncripcion_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		JLabel lblDeporte = new JLabel("Deporte");
		
		JLabel lblInstalacion = new JLabel("Instalacion");
		lblInstalacion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInstalacion.setBounds(178, 258, 187, 14);
		
		comboBox_Deporte = new JComboBox();
		comboBox_Deporte.setModel(new DefaultComboBoxModel(new String[] {"Tenis", "Padel", "Yoga", "Spinning", "Natación"}));
		
		comboBox_Instalacion_1 = new JComboBox();
		comboBox_Instalacion_1.setBounds(292, 258, 148, 26);
		comboBox_Instalacion_1.setModel(new DefaultComboBoxModel(new String[] {"pista de pádel", "campo de futbito", "cancha de baloncesto", "salon de yoga", "cancha de balonmano", "piscina"}));
		
		boton_LimpiarValores = new JButton("Limpiar valores");
		
		boton_CrearActividad_1 = new JButton("Crear Actividad");
		boton_CrearActividad_1.setBounds(310, 383, 130, 23);

		FechaInicio = new JDateChooser();
		FechaInicio.setBounds(292, 302, 139, 20);

		FechaFin = new JDateChooser();
		FechaFin.setBounds(292, 333, 134, 20);

		lblPrecioNoSocio = new JLabel("Precio No Socio:");
		lblPrecioNoSocio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrecioNoSocio.setBounds(178, 203, 187, 14);

		PrecioNoSocio = new JTextArea();
		PrecioNoSocio.setBounds(292, 195, 94, 22);

		lblNewLabel_2_1 = new JLabel("€");
		lblNewLabel_2_1.setBounds(396, 204, 21, 14);

		Tipo = new JLabel("Tipo");
		Tipo.setBounds(34, 81, 57, 14);

		Tipo_deporte = new JTextField();
		Tipo_deporte.setBounds(148, 78, 96, 20);

		Tipo_deporte.setColumns(10);
		
		JLabel lblId = new JLabel("ID: ");
		lblId.setBounds(34, 31, 43, 14);
		
		textFieldIdActividad = new JTextField();
		textFieldIdActividad.setBounds(148, 28, 96, 20);
		textFieldIdActividad.setColumns(10);
		
		lblHorario = new JLabel("HORARIO");
		lblHorario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHorario.setBounds(56, 175, 72, 14);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(list);
		frame.getContentPane().add(lblPeriodoIncripcin);
		frame.getContentPane().add(comboBox_periodoIncripcion_1);
		frame.getContentPane().add(lblHorario);
		frame.getContentPane().add(lblId);
		frame.getContentPane().add(lblPlazas);
		frame.getContentPane().add(Tipo);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(textArea_Nombre_1);
		frame.getContentPane().add(textFieldIdActividad);
		frame.getContentPane().add(Tipo_deporte);
		frame.getContentPane().add(comboBox_Plazas_1);
		frame.getContentPane().add(lblFechaInicio);
		frame.getContentPane().add(lblPrecioNoSocio);
		frame.getContentPane().add(lblPrecioSocio);
		frame.getContentPane().add(lblInstalacion);
		frame.getContentPane().add(lblFechaFin);
		frame.getContentPane().add(PrecioNoSocio);
		frame.getContentPane().add(PrecioSocio);
		frame.getContentPane().add(lblNewLabel_2);
		frame.getContentPane().add(lblNewLabel_2_1);
		frame.getContentPane().add(comboBox_Instalacion_1);
		frame.getContentPane().add(FechaInicio);
		frame.getContentPane().add(boton_CrearActividad_1);
		frame.getContentPane().add(FechaFin);
		
		textField_ILunes = new JTextField();
		textField_ILunes.setBounds(34, 200, 27, 20);
		frame.getContentPane().add(textField_ILunes);
		textField_ILunes.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("a");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(66, 200, 19, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_FLunes = new JTextField();
		textField_FLunes.setColumns(10);
		textField_FLunes.setBounds(76, 200, 27, 20);
		frame.getContentPane().add(textField_FLunes);
		
		JLabel lblNewLabel_4 = new JLabel("L");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(109, 201, 19, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_IMartes = new JTextField();
		textField_IMartes.setColumns(10);
		textField_IMartes.setBounds(34, 230, 27, 20);
		frame.getContentPane().add(textField_IMartes);
		
		JLabel lblNewLabel_1_1 = new JLabel("a");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(66, 230, 19, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		textField_FMartes = new JTextField();
		textField_FMartes.setColumns(10);
		textField_FMartes.setBounds(76, 230, 27, 20);
		frame.getContentPane().add(textField_FMartes);
		
		JLabel lblNewLabel_4_1 = new JLabel("M");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4_1.setBounds(111, 231, 19, 14);
		frame.getContentPane().add(lblNewLabel_4_1);
		
		textField_IMiercoles = new JTextField();
		textField_IMiercoles.setColumns(10);
		textField_IMiercoles.setBounds(34, 261, 27, 20);
		frame.getContentPane().add(textField_IMiercoles);
		
		JLabel lblNewLabel_1_2 = new JLabel("a");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(66, 263, 19, 14);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		textField_FMiercoles = new JTextField();
		textField_FMiercoles.setColumns(10);
		textField_FMiercoles.setBounds(76, 263, 27, 20);
		frame.getContentPane().add(textField_FMiercoles);
		
		JLabel lblNewLabel_4_2 = new JLabel("X");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4_2.setBounds(111, 262, 19, 14);
		frame.getContentPane().add(lblNewLabel_4_2);
		
		textField_IJueves = new JTextField();
		textField_IJueves.setColumns(10);
		textField_IJueves.setBounds(34, 289, 27, 20);
		frame.getContentPane().add(textField_IJueves);
		
		lblNewLabel_5 = new JLabel("a");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(66, 299, 19, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField_FJueves = new JTextField();
		textField_FJueves.setColumns(10);
		textField_FJueves.setBounds(76, 293, 27, 20);
		frame.getContentPane().add(textField_FJueves);
		
		lblNewLabel_6 = new JLabel("J");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(111, 299, 19, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		textField_IViernes = new JTextField();
		textField_IViernes.setColumns(10);
		textField_IViernes.setBounds(34, 324, 27, 20);
		frame.getContentPane().add(textField_IViernes);
		
		lblNewLabel_7 = new JLabel("a");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(66, 330, 19, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		textField_FViernes = new JTextField();
		textField_FViernes.setColumns(10);
		textField_FViernes.setBounds(76, 324, 27, 20);
		frame.getContentPane().add(textField_FViernes);
		
		lblNewLabel_8 = new JLabel("V");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8.setBounds(111, 324, 19, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		textField_ISabado = new JTextField();
		textField_ISabado.setColumns(10);
		textField_ISabado.setBounds(34, 355, 27, 20);
		frame.getContentPane().add(textField_ISabado);
		
		lblNewLabel_9 = new JLabel("a");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9.setBounds(66, 357, 19, 14);
		frame.getContentPane().add(lblNewLabel_9);
		
		textField_FSabado = new JTextField();
		textField_FSabado.setColumns(10);
		textField_FSabado.setBounds(76, 356, 27, 20);
		frame.getContentPane().add(textField_FSabado);
		
		lblNewLabel_10 = new JLabel("S");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_10.setBounds(109, 356, 19, 14);
		frame.getContentPane().add(lblNewLabel_10);
		
		textField_IDomingo = new JTextField();
		textField_IDomingo.setColumns(10);
		textField_IDomingo.setBounds(34, 386, 27, 20);
		frame.getContentPane().add(textField_IDomingo);
		
		lblNewLabel_11 = new JLabel("a");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_11.setBounds(66, 388, 19, 14);
		frame.getContentPane().add(lblNewLabel_11);
		
		textField_FDomingo = new JTextField();
		textField_FDomingo.setColumns(10);
		textField_FDomingo.setBounds(76, 387, 27, 20);
		frame.getContentPane().add(textField_FDomingo);
		
		lblNewLabel_12 = new JLabel("D");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_12.setBounds(111, 387, 19, 14);
		frame.getContentPane().add(lblNewLabel_12);
	}

	public JTextArea getTextArea_Nombre_1() {
		return textArea_Nombre_1;
	}

	public void setTextArea_Nombre_1(JTextArea textArea_Nombre_1) {
		this.textArea_Nombre_1 = textArea_Nombre_1;
	}

	public JComboBox getComboBox_Plazas_1() {
		return comboBox_Plazas_1;
	}

	public void setComboBox_Plazas_1(JComboBox comboBox_Plazas_1) {
		this.comboBox_Plazas_1 = comboBox_Plazas_1;
	}

	public JComboBox getComboBox_periodoIncripcion_1() {
		return comboBox_periodoIncripcion_1;
	}

	public void setComboBox_periodoIncripcion_1(JComboBox comboBox_periodoIncripcion_1) {
		this.comboBox_periodoIncripcion_1 = comboBox_periodoIncripcion_1;
	}

	public JComboBox getComboBox_Instalacion_1() {
		return comboBox_Instalacion_1;
	}

	public void setComboBox_Instalacion_1(JComboBox comboBox_Instalacion_1) {
		this.comboBox_Instalacion_1 = comboBox_Instalacion_1;
	}

	public JButton getBoton_CrearActividad_1() {
		return boton_CrearActividad_1;
	}

	public void setBoton_CrearActividad_1(JButton boton_CrearActividad_1) {
		this.boton_CrearActividad_1 = boton_CrearActividad_1;
	}

	public JLabel getLblHorario() {
		return lblHorario;
	}

	public void setLblHorario(JLabel lblHorario) {
		this.lblHorario = lblHorario;
	}

	public JTextField getTextField_ILunes() {
		return textField_ILunes;
	}

	public void setTextField_ILunes(JTextField textField_ILunes) {
		this.textField_ILunes = textField_ILunes;
	}

	public JTextField getTextField_FLunes() {
		return textField_FLunes;
	}

	public void setTextField_FLunes(JTextField textField_FLunes) {
		this.textField_FLunes = textField_FLunes;
	}

	public JTextField getTextField_IMartes() {
		return textField_IMartes;
	}

	public void setTextField_IMartes(JTextField textField_IMartes) {
		this.textField_IMartes = textField_IMartes;
	}

	public JTextField getTextField_FMartes() {
		return textField_FMartes;
	}

	public void setTextField_FMartes(JTextField textField_FMartes) {
		this.textField_FMartes = textField_FMartes;
	}

	public JTextField getTextField_IMiercoles() {
		return textField_IMiercoles;
	}

	public void setTextField_IMiercoles(JTextField textField_IMiercoles) {
		this.textField_IMiercoles = textField_IMiercoles;
	}

	public JTextField getTextField_FMiercoles() {
		return textField_FMiercoles;
	}

	public void setTextField_FMiercoles(JTextField textField_FMiercoles) {
		this.textField_FMiercoles = textField_FMiercoles;
	}

	public JTextField getTextField_IJueves() {
		return textField_IJueves;
	}

	public void setTextField_IJueves(JTextField textField_IJueves) {
		this.textField_IJueves = textField_IJueves;
	}

	public JLabel getLblNewLabel_5() {
		return lblNewLabel_5;
	}

	public void setLblNewLabel_5(JLabel lblNewLabel_5) {
		this.lblNewLabel_5 = lblNewLabel_5;
	}

	public JTextField getTextField_FJueves() {
		return textField_FJueves;
	}

	public void setTextField_FJueves(JTextField textField_FJueves) {
		this.textField_FJueves = textField_FJueves;
	}

	public JLabel getLblNewLabel_6() {
		return lblNewLabel_6;
	}

	public void setLblNewLabel_6(JLabel lblNewLabel_6) {
		this.lblNewLabel_6 = lblNewLabel_6;
	}

	public JTextField getTextField_IViernes() {
		return textField_IViernes;
	}

	public void setTextField_IViernes(JTextField textField_IViernes) {
		this.textField_IViernes = textField_IViernes;
	}

	public JLabel getLblNewLabel_7() {
		return lblNewLabel_7;
	}

	public void setLblNewLabel_7(JLabel lblNewLabel_7) {
		this.lblNewLabel_7 = lblNewLabel_7;
	}

	public JTextField getTextField_FViernes() {
		return textField_FViernes;
	}

	public void setTextField_FViernes(JTextField textField_FViernes) {
		this.textField_FViernes = textField_FViernes;
	}

	public JLabel getLblNewLabel_8() {
		return lblNewLabel_8;
	}

	public void setLblNewLabel_8(JLabel lblNewLabel_8) {
		this.lblNewLabel_8 = lblNewLabel_8;
	}

	public JTextField getTextField_ISabado() {
		return textField_ISabado;
	}

	public void setTextField_ISabado(JTextField textField_ISabado) {
		this.textField_ISabado = textField_ISabado;
	}

	public JLabel getLblNewLabel_9() {
		return lblNewLabel_9;
	}

	public void setLblNewLabel_9(JLabel lblNewLabel_9) {
		this.lblNewLabel_9 = lblNewLabel_9;
	}

	public JTextField getTextField_FSabado() {
		return textField_FSabado;
	}

	public void setTextField_FSabado(JTextField textField_FSabado) {
		this.textField_FSabado = textField_FSabado;
	}

	public JLabel getLblNewLabel_10() {
		return lblNewLabel_10;
	}

	public void setLblNewLabel_10(JLabel lblNewLabel_10) {
		this.lblNewLabel_10 = lblNewLabel_10;
	}

	public JTextField getTextField_IDomingo() {
		return textField_IDomingo;
	}

	public void setTextField_IDomingo(JTextField textField_IDomingo) {
		this.textField_IDomingo = textField_IDomingo;
	}

	public JLabel getLblNewLabel_11() {
		return lblNewLabel_11;
	}

	public void setLblNewLabel_11(JLabel lblNewLabel_11) {
		this.lblNewLabel_11 = lblNewLabel_11;
	}

	public JTextField getTextField_FDomingo() {
		return textField_FDomingo;
	}

	public void setTextField_FDomingo(JTextField textField_FDomingo) {
		this.textField_FDomingo = textField_FDomingo;
	}

	public JLabel getLblNewLabel_12() {
		return lblNewLabel_12;
	}

	public void setLblNewLabel_12(JLabel lblNewLabel_12) {
		this.lblNewLabel_12 = lblNewLabel_12;
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