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

public class CrearActividadView extends JFrame{

	private String [] periodos;
	private JFrame frame;
	private JTable tableDias;
	private JLabel lblNewLabel;

	private JLabel lblNewLabel_1;

	private JLabel lblDescripcion; 

	private JLabel lblFechaInicio; 

	private JLabel lblFechaFin ;

	private JLabel lblPlazas ;

	private JLabel lblPrecio ;

	private JTextArea textArea_Nombre ;

	private JTextArea textArea_Descripcion;
	private JTextArea PrecioSocio ;
	private JLabel lblNewLabel_2;
	private JList list;
	private JComboBox comboBox_Plazas;

	private JLabel lblPeriodoIncripcin ;

	private JComboBox comboBox_periodoIncripcion ;

	private JLabel lblPrecioNoSocio;

	private JLabel lblPrecioSocio;

	private JTextArea PrecioNoSocio;

	private JLabel lblDeporte ;

	private JLabel lblInstalacion;

	private JComboBox comboBox_Deporte ;

	private JComboBox comboBox_Instalacion ;

	private JButton boton_LimpiarValores ;

	private JButton boton_CrearActividad;
	private JLabel lblNewLabel_2_1 ;

	private JLabel lblNewLabel_3;
	private JLabel Tipo;

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
	private JTextField Tipo_deporte;

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

	public JLabel getLblNewLabel_1() {
		return lblNewLabel_1;
	}

	public void setLblNewLabel_1(JLabel lblNewLabel_1) {
		this.lblNewLabel_1 = lblNewLabel_1;
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
		return textArea_Nombre;
	}

	public void setTextArea_Nombre(JTextArea textArea_Nombre) {
		this.textArea_Nombre = textArea_Nombre;
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

	public JList getList() {
		return list;
	}

	public void setList(JList list) {
		this.list = list;
	}

	public JComboBox getComboBox_Plazas() {
		return comboBox_Plazas;
	}

	public void setComboBox_Plazas(JComboBox comboBox_Plazas) {
		this.comboBox_Plazas = comboBox_Plazas;
	}

	public JLabel getLblPeriodoIncripcin() {
		return lblPeriodoIncripcin;
	}

	public void setLblPeriodoIncripcin(JLabel lblPeriodoIncripcin) {
		this.lblPeriodoIncripcin = lblPeriodoIncripcin;
	}

	public JComboBox getComboBox_periodoIncripcion() {
		return comboBox_periodoIncripcion;
	}

	public void setComboBox_periodoIncripcion(JComboBox comboBox_periodoIncripcion) {
		this.comboBox_periodoIncripcion = comboBox_periodoIncripcion;
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

	public JComboBox getComboBox_Deporte() {
		return comboBox_Deporte;
	}

	public void setComboBox_Deporte(JComboBox comboBox_Deporte) {
		this.comboBox_Deporte = comboBox_Deporte;
	}

	public JComboBox getComboBox_Instalacion() {
		return comboBox_Instalacion;
	}

	public void setComboBox_Instalacion(JComboBox comboBox_Instalacion) {
		this.comboBox_Instalacion = comboBox_Instalacion;
	}

	public JButton getBoton_LimpiarValores() {
		return boton_LimpiarValores;
	}

	public void setBoton_LimpiarValores(JButton boton_LimpiarValores) {
		this.boton_LimpiarValores = boton_LimpiarValores;
	}

	public JButton getBoton_CrearActividad() {
		return boton_CrearActividad;
	}

	public void setBoton_CrearActividad(JButton boton_CrearActividad) {
		this.boton_CrearActividad = boton_CrearActividad;
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

	public JSpinner getIDomingo() {
		return IDomingo;
	}

	public void setIDomingo(JSpinner iDomingo) {
		IDomingo = iDomingo;
	}

	public JSpinner getIMartes() {
		return IMartes;
	}

	public void setIMartes(JSpinner iMartes) {
		IMartes = iMartes;
	}

	public JSpinner getIMiercoles() {
		return IMiercoles;
	}

	public void setIMiercoles(JSpinner iMiercoles) {
		IMiercoles = iMiercoles;
	}

	public JSpinner getIJueves() {
		return IJueves;
	}

	public void setIJueves(JSpinner iJueves) {
		IJueves = iJueves;
	}

	public JSpinner getISabado() {
		return ISabado;
	}

	public void setISabado(JSpinner iSabado) {
		ISabado = iSabado;
	}

	public JSpinner getIViernes() {
		return IViernes;
	}

	public void setIViernes(JSpinner iViernes) {
		IViernes = iViernes;
	}

	public JSpinner getFJueves() {
		return FJueves;
	}

	public void setFJueves(JSpinner fJueves) {
		FJueves = fJueves;
	}

	public JSpinner getFDomingo() {
		return FDomingo;
	}

	public void setFDomingo(JSpinner fDomingo) {
		FDomingo = fDomingo;
	}

	public JSpinner getFViernes() {
		return FViernes;
	}

	public void setFViernes(JSpinner fViernes) {
		FViernes = fViernes;
	}

	public JSpinner getFSabado() {
		return FSabado;
	}

	public void setFSabado(JSpinner fSabado) {
		FSabado = fSabado;
	}

	public JSpinner getFMiercoles() {
		return FMiercoles;
	}

	public void setFMiercoles(JSpinner fMiercoles) {
		FMiercoles = fMiercoles;
	}

	public JSpinner getFLunes() {
		return FLunes;
	}

	public void setFLunes(JSpinner fLunes) {
		FLunes = fLunes;
	}

	public JSpinner getFMartes() {
		return FMartes;
	}

	public void setFMartes(JSpinner fMartes) {
		FMartes = fMartes;
	}

	public String[] getPeriodos() {
		return periodos;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Crear Actividad");
		frame.setBounds(100, 100, 906, 549);

		lblNewLabel = new JLabel("Nombre:");

		lblNewLabel_1 = new JLabel("CREAR ACTIVIDAD");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

		lblFechaInicio = new JLabel("Fecha Inicio:");

		lblFechaFin = new JLabel("Fecha Fin:");

		lblPlazas = new JLabel("Plazas:");

		lblPrecioSocio = new JLabel("Precio Socio:");

		textArea_Nombre = new JTextArea();

		PrecioSocio = new JTextArea();

		lblNewLabel_2 = new JLabel("€");

		list = new JList();

		comboBox_Plazas = new JComboBox();
		comboBox_Plazas.setModel(new DefaultComboBoxModel(new String[] {"5", "10", "15", "20", "25", "30"}));

		lblPeriodoIncripcin = new JLabel("Periodo Incripción");



		comboBox_periodoIncripcion = new JComboBox();


		lblInstalacion = new JLabel("Instalacion");

		comboBox_Instalacion = new JComboBox();
		comboBox_Instalacion.setModel(new DefaultComboBoxModel(new String[] {"Pista de Tenis 1", "Piscina 1", "Pista de baloncesto 1"}));

		boton_CrearActividad = new JButton("Crear Actividad");

		lblNewLabel_3 = new JLabel("Días y horas de las sesiones");

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
		ILunes.setModel(new SpinnerListModel(new String[] {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));

		IDomingo = new JSpinner();
		IDomingo.setModel(new SpinnerListModel(new String[] {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		IDomingo.setMinimumSize(new Dimension(26, 18));

		IMartes = new JSpinner();
		IMartes.setModel(new SpinnerListModel(new String[] {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		IMartes.setPreferredSize(new Dimension(26, 18));
		IMartes.setMinimumSize(new Dimension(26, 18));

		IMiercoles = new JSpinner();
		IMiercoles.setModel(new SpinnerListModel(new String[] {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		IMiercoles.setPreferredSize(new Dimension(26, 18));
		IMiercoles.setMinimumSize(new Dimension(26, 18));

		IJueves = new JSpinner();
		IJueves.setModel(new SpinnerListModel(new String[] {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		IJueves.setPreferredSize(new Dimension(26, 18));
		IJueves.setMinimumSize(new Dimension(26, 18));

		ISabado = new JSpinner();
		ISabado.setModel(new SpinnerListModel(new String[] {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		ISabado.setPreferredSize(new Dimension(26, 18));
		ISabado.setMinimumSize(new Dimension(26, 18));

		IViernes = new JSpinner();
		IViernes.setModel(new SpinnerListModel(new String[] {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		IViernes.setPreferredSize(new Dimension(26, 18));
		IViernes.setMinimumSize(new Dimension(26, 18));

		FJueves = new JSpinner();
		FJueves.setModel(new SpinnerListModel(new String[] {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		FJueves.setPreferredSize(new Dimension(26, 18));
		FJueves.setMinimumSize(new Dimension(26, 18));

		FDomingo = new JSpinner();
		FDomingo.setModel(new SpinnerListModel(new String[] {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		FDomingo.setMinimumSize(new Dimension(26, 18));

		FViernes = new JSpinner();
		FViernes.setModel(new SpinnerListModel(new String[] {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		FViernes.setPreferredSize(new Dimension(26, 18));
		FViernes.setMinimumSize(new Dimension(26, 18));

		FSabado = new JSpinner();
		FSabado.setModel(new SpinnerListModel(new String[] {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		FSabado.setPreferredSize(new Dimension(26, 18));
		FSabado.setMinimumSize(new Dimension(26, 18));

		FMiercoles = new JSpinner();
		FMiercoles.setModel(new SpinnerListModel(new String[] {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		FMiercoles.setPreferredSize(new Dimension(26, 18));
		FMiercoles.setMinimumSize(new Dimension(26, 18));

		FLunes = new JSpinner();
		FLunes.setModel(new SpinnerListModel(new String[] {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		FLunes.setPreferredSize(new Dimension(26, 18));
		FLunes.setMinimumSize(new Dimension(26, 18));

		FMartes = new JSpinner();
		FMartes.setModel(new SpinnerListModel(new String[] {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		FMartes.setPreferredSize(new Dimension(26, 18));
		FMartes.setMinimumSize(new Dimension(26, 18));

		FechaInicio = new JDateChooser();

		FechaFin = new JDateChooser();

		lblPrecioNoSocio = new JLabel("Precio No Socio:");

		PrecioNoSocio = new JTextArea();

		lblNewLabel_2_1 = new JLabel("€");

		Tipo = new JLabel("Tipo");

		Tipo_deporte = new JTextField();

		Tipo_deporte.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(127)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 506, Short.MAX_VALUE)
					.addComponent(boton_CrearActividad)
					.addGap(151))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(405, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
					.addGap(310))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(69)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPeriodoIncripcin)
							.addGap(36)
							.addComponent(comboBox_periodoIncripcion, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(12)
									.addComponent(tableDias, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(ILunes, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
										.addComponent(IMartes, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
										.addComponent(IMiercoles, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
										.addComponent(IJueves, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
										.addComponent(IViernes, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
										.addComponent(ISabado, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
										.addComponent(IDomingo, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
									.addGap(29)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(FLunes, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
										.addComponent(FMartes, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
										.addComponent(FMiercoles, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
										.addComponent(FJueves, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
										.addComponent(FViernes, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
										.addComponent(FSabado, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
										.addComponent(FDomingo, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(lblPlazas, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
											.addComponent(Tipo, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
									.addGap(32)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(Tipo_deporte)
										.addComponent(textArea_Nombre, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
										.addComponent(comboBox_Plazas, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))))
							.addGap(142)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblFechaInicio, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFechaFin)
								.addComponent(lblInstalacion, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPrecioNoSocio, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
								.addComponent(lblPrecioSocio, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(PrecioSocio)
										.addComponent(PrecioNoSocio, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(12)
											.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))))
								.addComponent(comboBox_Instalacion, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
								.addComponent(FechaFin, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
								.addComponent(FechaInicio, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))))
					.addGap(100))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel_1)
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textArea_Nombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPrecioNoSocio)
						.addComponent(PrecioNoSocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_1))
					.addGap(3)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
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
								.addComponent(comboBox_Instalacion, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
							.addGap(51)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFechaInicio)
								.addComponent(FechaInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblFechaFin)
								.addComponent(FechaFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addComponent(Tipo_deporte, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox_Plazas, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPlazas))
							.addGap(39)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPeriodoIncripcin)
								.addComponent(comboBox_periodoIncripcion, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(tableDias, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(ILunes, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
									.addGap(2)
									.addComponent(IMartes, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
									.addGap(1)
									.addComponent(IMiercoles, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
									.addGap(3)
									.addComponent(IJueves, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(IViernes, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
									.addGap(1)
									.addComponent(ISabado, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
									.addGap(1)
									.addComponent(IDomingo, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
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
									.addComponent(FDomingo, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
						.addComponent(boton_CrearActividad))
					.addGap(240))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	public void setPeriodos(String[] value) {
		periodos=value;
		comboBox_periodoIncripcion.setModel(new DefaultComboBoxModel(periodos));

	}
	public String[] getListainstalacion() {
		return periodos;
	}
}
