package giis.demo.Proyecto.Controller;

import java.util.List;


import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;


import giis.demo.Proyecto.DTO.InstalacionesDisplayDTO;
import giis.demo.Proyecto.DTO.SociosDisplayDTO;
import giis.demo.Proyecto.Model.RealizarReservasModel;
import giis.demo.Proyecto.View.realizarReservaView;
import giis.demo.Proyecto.View.resguardoView;
import giis.demo.util.SwingUtil;
import giis.demo.util.Util;

public class realizarReservaController {

	private RealizarReservasModel model;
	private realizarReservaView view;
	private resguardoView viewResg;
	private int select;
	java.sql.Date sqlDate;

	public realizarReservaController(RealizarReservasModel m, realizarReservaView reservaV, resguardoView resguardoV) {
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

		//Boton para rellenar los DATOS de una Reserva
		view.getBtnReserva().addActionListener(e -> realizarReservaInstalacion());
		//Boton para generar el resguardo
		view.getBtnResguardo().addActionListener(e -> generarResguardo());
		viewResg.getBtnImprimir().addActionListener(e -> System.exit(0));
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

		//Metodos para inicializar el contenido de los comboBox
		añadeInstCB();
		//Inicializacion de ventana
		view.getFrame().setVisible(true);

	}




	private void actualizarPrecios() {

		List<InstalacionesDisplayDTO> instalaciones=model.getInstalacion();

		view.getTxtPrecio().setText(
				Float.toString(instalaciones.get(view.getComboBox_instalacion().getSelectedIndex()).getPrecioHora()));

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
		int diaIni = this.view.getComboBox_dia().getSelectedIndex() +1;
		int mesIni = this.view.getComboBox_mes().getSelectedIndex()+1;
		int anoIni = Integer.parseInt(this.view.getComboBox_ano().getModel().getElementAt(this.view.getComboBox_ano().getSelectedIndex()).toString());
		float horaInicio= (float)Double.parseDouble(getSelectedItem(view.getComboBox_HoraC()));
		float horaFin=(float)Double.parseDouble(getSelectedItem(view.getComboBox_HoraF()));
		String fecha = Integer.toString(anoIni) + "-" + mesIni + "-" + diaIni;

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

				int diaIni = this.view.getComboBox_dia().getSelectedIndex() +1;
				int mesIni = this.view.getComboBox_mes().getSelectedIndex()+1;
				int anoIni = Integer.parseInt(this.view.getComboBox_ano().getModel().getElementAt(this.view.getComboBox_ano().getSelectedIndex()).toString());
				String fecha = Integer.toString(anoIni) + "-" + mesIni + "-" + diaIni;

				model.realizarReserva(Integer.parseInt(view.getTxtReserva().getText()),
						Integer.parseInt(view.getTxtSocio().getText()),
						Integer.parseInt(view.getTextActividad().getText()),
						getSelectedIndex(view.getComboBox_instalacion()) +1, 
						Util.dateToIsoString(Util.isoStringToDate(fecha)),
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


					int diaIni = this.view.getComboBox_dia().getSelectedIndex() +1;
					int mesIni = this.view.getComboBox_mes().getSelectedIndex()+1;
					int anoIni = Integer.parseInt(this.view.getComboBox_ano().getModel().getElementAt(this.view.getComboBox_ano().getSelectedIndex()).toString());
					String fecha = Integer.toString(anoIni) + "-" + mesIni + "-" + diaIni;
					viewResg.getTxtFecha().setText(Util.dateToIsoString(Util.isoStringToDate(fecha)));	
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


}
