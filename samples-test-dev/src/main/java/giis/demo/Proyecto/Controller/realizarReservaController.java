package giis.demo.Proyecto.Controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;


import giis.demo.Proyecto.DTO.InstalacionesDisplayDTO;
import giis.demo.Proyecto.DTO.SociosDisplayDTO;
import giis.demo.Proyecto.DTO.reservasDisplayDTO;
import giis.demo.Proyecto.model.realizarReservasModel;
import giis.demo.Proyecto.view.realizarReservaView;
import giis.demo.Proyecto.view.resguardoView;
import giis.demo.util.SwingUtil;
import giis.demo.util.Util;

public class realizarReservaController {

	private realizarReservasModel model;
	private realizarReservaView view;
	private resguardoView viewResg;
	private int select;
	java.sql.Date sqlDate;
	private int siguiente,anterior,pos;

	public realizarReservaController(realizarReservasModel m, realizarReservaView reservaV, resguardoView resguardoV) {
		this.model = m;
		this.view = reservaV;
		this.viewResg = resguardoV;

	}

	/**
	 * Inicializacion del controlador: anyade los manejadores de eventos a los objetos del UI.
	 * Cada manejador de eventos se instancia de la misma forma, para que invoque un metodo privado
	 * de este controlador, encerrado en un manejador de excepciones generico para mostrar ventanas
	 * emergentes cuando ocurra algun problema o excepcion controlada.
	 */
	public void initController() {
		this.initView();
		view.getComboBox_instalacion().addActionListener(e -> actualizarPrecios());
		view.getTxtSocio().addActionListener(e -> actualizarNombres());
		//Boton para controlar que no hagan reservas con mas de 7 días de antelación
		view.getBtnSiguiente().addActionListener(e -> SwingUtil.exceptionWrapper(() -> fechaSiguiente()));
		view.getBtnAnterior().addActionListener(e -> SwingUtil.exceptionWrapper(() -> fechaAnterior()));
		view.getBtnComprobar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> comprobarReservas()));
		//Boton para rellenar los DATOS de una Reserva
		view.getBtnReserva().addActionListener(e -> realizarReservaInstalacion());
		//Boton para generar el resguardo
		view.getBtnResguardo().addActionListener(e -> generarResguardo());
		viewResg.getBtnImprimir().addActionListener(e -> System.exit(0));
	}  
	
	private void comprobarReservas() {
		List<Object[]> reservas = model.getFechasReservas(Util.isoStringToDate(view.getTextFecha().getText()),
				(int)view.getComboBox_HoraC().getSelectedItem(), (int)view.getComboBox_HoraF().getSelectedItem());
		List <reservasDisplayDTO> idReserva = model.obtenerReserva();
		int ultimo= 0;
		for (int i =0; i <= idReserva.size();i++)
			ultimo++;
		
		if(!reservas.isEmpty()) {
			SwingUtil.showMessage("Ya se ha realizado una reserva con esos valores", "Error", 1);
		}
		else {
			actualizarPrecios();
			System.out.print("Se puede realizar la reserva.\n");
			view.getTxtSocio().setEditable(true);
			view.getTextActividad().setEditable(true);
			view.getTxtReserva().setText(String.valueOf(ultimo));
			view.getRdBtnFinal().setSelected(true);
		}
	}

	private void actualizarNombres() {

		List<SociosDisplayDTO> socios = model.getInfoSocio(Integer.parseInt(view.getTxtSocio().getText()));

		if(!socios.isEmpty()){

			view.getTxtNombre().setText(socios.get(0).getNombre());

			String apellidos = socios.get(0).getApellido1() + " " + socios.get(0).getApellido2();

			view.getTxtApellidos().setText(apellidos);	
		}

	}

	public void initView() {
		//Inicializa la fecha de hoy a un valor que permitira mostrar carreras en diferentes fases 
		//y actualiza los datos de la vista
		java.util.Date fecha= new java.util.Date();
		long lnMilisegundos = fecha.getTime();
		sqlDate = new java.sql.Date(lnMilisegundos);
		view.getTextFecha().setText(fecha(0));
		view.getBtnAnterior().setEnabled(false);

		//Metodos para inicializar el contenido de los comboBox
		añadeInstCB();
		//Inicializacion de ventana
		view.getFrame().setVisible(true);

	}




	private void actualizarPrecios() {

		List<InstalacionesDisplayDTO> instalaciones=model.getInstalacion();
		int horaC = (int) view.getComboBox_HoraC().getSelectedIndex();
		int horaF = (int)view.getComboBox_HoraF().getSelectedIndex();

		if((horaF -horaC) == 0)
		view.getTxtPrecio().setText(
				Float.toString(instalaciones.get(view.getComboBox_instalacion().getSelectedIndex()).getPrecioHora()));
		else if((horaF -horaC) == 1) {
			view.getTxtPrecio().setText(
					Float.toString(instalaciones.get(view.getComboBox_instalacion().getSelectedIndex()).getPrecioHora() * 2));
		}
		else if((horaF -horaC) == 2) {
			view.getTxtPrecio().setText(
					Float.toString(instalaciones.get(view.getComboBox_instalacion().getSelectedIndex()).getPrecioHora() * 3));
		}
		else if(horaC > horaF) {
			SwingUtil.showMessage("Introduzca un rango de horas válido", "Error", 1);
		}
		else
			SwingUtil.showMessage("No se puede realizar una reserva de mas de 3 horas", "Error", 1);

	}


	/**
	 * Metodo para cargar de la BD las instalaciones en el ComboBox
	 */
	public void añadeInstCB() {
		List<Object[]> instalaciones=model.getInstalacion2();	
		ComboBoxModel<Object> l=SwingUtil.getComboModelFromList(instalaciones);
		view.getComboBox_instalacion().setModel(l);
	}



	/**
	 * Metodo que añade al comboBox los elemntos de busqueda sql
	 * @param pojos
	 * @param comboBox
	 * @param nombre
	 */


	@SuppressWarnings({ "unchecked", "unused" })
	public void getListaInstalaciones() {

		this.select=getSelectedIndex(view.getComboBox_instalacion());
		float horaInicio= (float)Double.parseDouble(getSelectedItem(view.getComboBox_HoraC()));
		float horaFin=(float)Double.parseDouble(getSelectedItem(view.getComboBox_HoraF()));
		String fecha = view.getTextFecha().getText();

		List<InstalacionesDisplayDTO> instalacion = model.getListaInstalacionesArray(select,Util.isoStringToDate(fecha),horaInicio,horaFin);
		TableModel tmodel=SwingUtil.getTableModelFromPojos(instalacion, new String[] {"idInstalacion", "nombreInstalacion", "fechaReserva","horaInicioReserva",
				"horaFinReserva","estado"});

	}

	public boolean CamposLlenos() {
		if(view.getTxtSocio().getText().isEmpty()||
				view.getTextActividad().getText().isEmpty()||
				view.getTxtReserva().getText().isEmpty()||
				view.getTxtPrecio().getText().isEmpty())
			return false;
		else
			return true;
	}


	@SuppressWarnings("unchecked")
	public void realizarReservaInstalacion() {

		if(!CamposLlenos()){
			SwingUtil.showMessage("Rellene todos los campos", "Error", 1);
		}
		else {



			List <SociosDisplayDTO> socio = model.getInfoSocio(Integer.parseInt(view.getTxtSocio().getText()));

			if(!socio.isEmpty()){

				int estado = 1;


				model.realizarReserva(Integer.parseInt(view.getTxtReserva().getText()),
						Integer.parseInt(view.getTxtSocio().getText()),
						Integer.parseInt(view.getTextActividad().getText()),
						getSelectedIndex(view.getComboBox_instalacion()) +1, 
						Util.dateToIsoString(Util.isoStringToDate(view.getTextFecha().getText())),
						(float) Double.parseDouble(getSelectedItem(view.getComboBox_HoraC())),
						(float) Double.parseDouble(getSelectedItem(view.getComboBox_HoraF())), 
						estado);



				view.getTxtNombre().setText(socio.get(0).getNombre());
				view.getTxtApellidos().setText(socio.get(0).getApellido1() + " " + socio.get(0).getApellido2());
				view.getBtnResguardo().setEnabled(true);
				
			}

			else{
				SwingUtil.showMessage("El socio no existe en la BBDD", "Error", 0);
			}
		}
	}





	public static int getSelectedIndex(JComboBox<Object> cbInstalacion) {

		int periodo;
		periodo= cbInstalacion.getSelectedIndex();
		return periodo;
	}

	public static String getSelectedItem(JComboBox<Object> cbInstalacion) {
		String select;
		select=(String) cbInstalacion.getSelectedItem();
		return select;
	}






	public void generarResguardo() {

		if(!CamposLlenos()){
			SwingUtil.showMessage("Rellene todos los campos", "Error", 1);
		}

		else {



			List<SociosDisplayDTO> socios = model.getInfoSocio(Integer.parseInt(view.getTxtSocio().getText()));
			if(socios.isEmpty()){
				SwingUtil.showMessage("El socio no existe en la BD", "Error", 0);
			}
			else{




				try{

					viewResg.getTxtSocioR().setText(view.getTxtSocio().getText());
					viewResg.getTxtNombreR().setText(socios.get(0).getNombre());
					viewResg.getTxtApellidosR().setText(socios.get(0).getApellido1() + " " + socios.get(0).getApellido2());
					viewResg.getTxtReservaR().setText(view.getTxtReserva().getText());
					viewResg.getTxtInstalacionR().setText(view.getComboBox_instalacion().getModel().getElementAt(view.getCbInstalacion().getSelectedIndex()).toString());
					viewResg.getTextActividadR().setText(view.getTextActividad().getText());
					viewResg.getTxtHora1R().setText(Integer.toString(view.getComboBox_HoraC().getSelectedIndex()+9));
					viewResg.getTxtHora2R().setText(Integer.toString(view.getComboBox_HoraF().getSelectedIndex()+10));
					viewResg.getTxtPrecioR().setText(view.getTxtPrecio().getText());

					view.getTxtNombre().setText(socios.get(0).getNombre());
					view.getTxtApellidos().setText(socios.get(0).getApellido1() + " " + socios.get(0).getApellido2());

					viewResg.setTxtSocioR(view.getTxtSocio());
					viewResg.getLabel_1().setText(view.getTxtPrecio().getText());


					viewResg.getTxtPagoR().setText(
							view.getRdBtnEfectivo().isSelected() ?
									"En efectivo" : "A final de mes" );


					viewResg.getFrame().setVisible(true);
				}


				catch(NullPointerException e)
				{
					JOptionPane pane = new JOptionPane("Hay algun campo vacio.",JOptionPane.INFORMATION_MESSAGE);
					pane.setOptions(new Object[] {"ACEPTAR"}); 
					JDialog d = pane.createDialog(pane, "Reviselo");
					d.setVisible(true);


				}
				catch(NumberFormatException e){

					JOptionPane pane = new JOptionPane("Hay algun campo que no coincide con el formato que se pide.",JOptionPane.INFORMATION_MESSAGE);
					pane.setOptions(new Object[] {"ACEPTAR"});
					JDialog d = pane.createDialog(pane, "Reviselo");
					d.setVisible(true);

				}
			}
		}
	}
	
	public static String fecha(int constante){

		Calendar c1 = Calendar.getInstance();

		c1.add(Calendar.DAY_OF_YEAR, constante);

		int dia = (c1.get(Calendar.DATE));
		int mes = (c1.get(Calendar.MONTH)+1);
		int año = (c1.get(Calendar.YEAR));

		String d=""+dia;
		String m=""+mes;

		if(dia<10) {
			d="0"+dia;
		}
		if(mes<10) {
			m="0"+mes;
		}


		String fechaHoy=año+"-"+m+"-"+d;

		return fechaHoy;
	}
	
	public void fechaSiguiente() {
		pos++;
		if(pos == 7) {
			SwingUtil.bloqueaBoton(view.getBtnSiguiente());
		}
		if(fecha(0).equals(fecha(pos))) {
			SwingUtil.bloqueaBoton(view.getBtnAnterior());
		}
		if(!fecha(0).equals(fecha(pos))) {
			SwingUtil.activaBoton(view.getBtnAnterior());
		}

		view.getTextFecha().setText(fecha(pos));

	}
	
	public void fechaAnterior() {
		pos--;
		if(pos == 7) {
			SwingUtil.bloqueaBoton(view.getBtnSiguiente());
		}
		if(!(pos == 30)) {
			SwingUtil.activaBoton(view.getBtnSiguiente());
		}
		if(fecha(0).equals(fecha(pos))) {
			SwingUtil.bloqueaBoton(view.getBtnAnterior());
		}
		view.getTextFecha().setText(fecha(pos));
	}

}
