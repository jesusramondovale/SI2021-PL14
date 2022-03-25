package giis.demo.Proyecto.Controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;


import giis.demo.Proyecto.DTO.InstalacionesDisplayDTO;
import giis.demo.Proyecto.DTO.SociosDisplayDTO;
import giis.demo.Proyecto.DTO.reservasDisplayDTO;
import giis.demo.Proyecto.Model.realizarReservasSocioFechaConcretaModel;
import giis.demo.Proyecto.View.*;
import giis.demo.util.SwingUtil;
import giis.demo.util.Util;

public class realizarReservaSocioFechaConcretaController {

	private realizarReservasSocioFechaConcretaModel model;
	private realizarReservaSocioFechaConcretaView view;
	private introducirIdSocioRealizaReservaView introView;
	private int select;
	java.sql.Date sqlDate;
	private int siguiente,anterior,pos;
	private String actividadS,SocioS,instalacionS,horaInicioS,horaFinS,precioS;

	public realizarReservaSocioFechaConcretaController( introducirIdSocioRealizaReservaView intro,
			realizarReservaSocioFechaConcretaView reservaV,
			realizarReservasSocioFechaConcretaModel m) {
		this.introView = intro;
		this.model = m;
		this.view = reservaV;
		this.initView();

	}

	/**
	 * Inicializacion del controlador: anyade los manejadores de eventos a los objetos del UI.
	 * Cada manejador de eventos se instancia de la misma forma, para que invoque un metodo privado
	 * de este controlador, encerrado en un manejador de excepciones generico para mostrar ventanas
	 * emergentes cuando ocurra algun problema o excepcion controlada.
	 */
	public void initController() {
		this.initView();
		introView.getBtnLogear().addActionListener(e -> SwingUtil.exceptionWrapper(() -> mostrarPantalla()));
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
	} 
	
	public void mostrarPantalla() {
		if(introView.getTxtId().getText().isEmpty()) {
			SwingUtil.showMessage("Tienes que introducir un socio", "Error", 0);
		}else {

			if(compruebaId()) {
				introView.getFrame().setVisible(false);
				view.getFrame().setVisible(true);
			}
		}
	}
	
	public boolean compruebaId() {
		List<SociosDisplayDTO> idSocio = model.getInfoSocio(Integer.parseInt(introView.getTxtId().getText()));
			if(!idSocio.isEmpty()) {
				view.getTxtSocio().setText(introView.getTxtId().getText());
				actualizarNombres();
				return true;
			}
			else {
				SwingUtil.showMessage("El socio no existe en la BBDD", "Error", 0);
				return false;
			}
	}
	
	private void comprobarReservas() {
		List<reservasDisplayDTO> reservas = model.obtenerHorarioReserva();
		List <reservasDisplayDTO> idReserva = model.obtenerReserva();
		boolean estaReservado = false;
		float horaI = (float) view.getComboBox_HoraC().getSelectedIndex() +9;
		float horaF = (float) view.getComboBox_HoraF().getSelectedIndex()+10;
		String fecha = view.getTextFecha().getText();
		int instalacion = view.getComboBox_instalacion().getSelectedIndex()+1;
		int ultimo= 0;
		for (int i =0; i <= idReserva.size();i++)
			ultimo++;
		if(actualizarPrecios()) {
			if(!reservas.isEmpty()) {
				for (int i =0 ; i < reservas.size();i++){
					if((reservas.get(i).getFecha().equals(fecha)) && 
							((reservas.get(i).getHoraInicio() == horaI) || ((reservas.get(i).getHoraInicio() -1 )== horaF)) &&
							((Integer.parseInt(reservas.get(i).getIdInstalacion())) == instalacion)) 
						estaReservado = true;
				}
				if(estaReservado) {
					SwingUtil.showMessage("Ya se ha realizado una reserva con esos valores", "Error", 1);
					view.getTxtSocio().setEditable(false);
					view.getActividadesCB().setEnabled(false);
					view.getBtnReserva().setEnabled(false);
					view.getBtnResguardo().setEnabled(false);
				}
				else {
					System.out.println("Se puede realizar la reserva.\n");
					view.getActividadesCB().setEnabled(true);
					view.getTxtReserva().setText(String.valueOf(ultimo));
					view.getRdBtnFinal().setSelected(true);
					view.getBtnReserva().setEnabled(true);
				}
			}else {
				System.out.print("Se puede realizar la reserva.\n");
				view.getActividadesCB().setEnabled(true);;
				view.getTxtReserva().setText(String.valueOf(ultimo));
				view.getRdBtnFinal().setSelected(true);
				view.getBtnReserva().setEnabled(true);
			}
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
		view.getBtnReserva().setEnabled(false);
		view.getBtnResguardo().setEnabled(false);

		//Metodos para inicializar el contenido de los comboBox
		añadeInstCB();
		añadeActividadesCB();
		//Inicializacion de ventana
		introView.getFrame().setVisible(true);

	}


	private boolean actualizarPrecios() {

		List<InstalacionesDisplayDTO> instalaciones=model.getInstalacion();
		int horaC = (int) view.getComboBox_HoraC().getSelectedIndex();
		int horaF = (int)view.getComboBox_HoraF().getSelectedIndex();

		if((horaF -horaC) == 0) {
		view.getTxtPrecio().setText(
				Float.toString(instalaciones.get(view.getComboBox_instalacion().getSelectedIndex()).getPrecioHora())); 
		return true;
		}
		else if((horaF -horaC) == 1) {
			view.getTxtPrecio().setText(
					Float.toString(instalaciones.get(view.getComboBox_instalacion().getSelectedIndex()).getPrecioHora() * 2));
			return true;
		}
		else if((horaF -horaC) == 2) {
			view.getTxtPrecio().setText(
					Float.toString(instalaciones.get(view.getComboBox_instalacion().getSelectedIndex()).getPrecioHora() * 3));
			return true;
		}
		else if(horaC > horaF) {
			SwingUtil.showMessage("Introduzca un rango de horas válido", "Error", 1);
			return false;
		}
		else {
			SwingUtil.showMessage("No se puede realizar una reserva de mas de 3 horas", "Error", 1);
			return false;
		}

	}


	/**
	 * Metodo para cargar de la BD en ComboBoxs
	 */
	public void añadeInstCB() {
		List<Object[]> instalaciones=model.getInstalacion2();	
		ComboBoxModel<Object> l=SwingUtil.getComboModelFromList(instalaciones);
		view.getComboBox_instalacion().setModel(l);
	}
	
	public void añadeActividadesCB() {
		List<Object[]> actividades = model.getActividad2();
		ComboBoxModel<Object> l=SwingUtil.getComboModelFromList(actividades);
		view.getActividadesCB().setModel(l);
	}


	public boolean CamposLlenos() {
		if(view.getTxtSocio().getText().isEmpty()||
				view.getTxtReserva().getText().isEmpty()||
				view.getTxtPrecio().getText().isEmpty())
			return false;
		else
			return true;
	}


	@SuppressWarnings("unchecked")
	public void realizarReservaInstalacion() {
		List <reservasDisplayDTO> idReserva = model.obtenerReserva();
		boolean existeReserva= false;

		if(!CamposLlenos()){
			SwingUtil.showMessage("Rellene todos los campos", "Error", 1);
		}
		else if(!idReserva.isEmpty()) {
			for(int i=0; i < idReserva.size();i++) {
				if(view.getTxtReserva().getText().equals(idReserva.get(i).getIdReserva()))
					existeReserva = true;
			}
			if(existeReserva)
				SwingUtil.showMessage("Nº de reserva ya utilizado", "Error", 1);
			else {
				List <SociosDisplayDTO> socio = model.getInfoSocio(Integer.parseInt(view.getTxtSocio().getText()));

				if(!socio.isEmpty()){

					int estado = 1;


					model.realizarReserva(Integer.parseInt(view.getTxtReserva().getText()),
							Integer.parseInt(view.getTxtSocio().getText()),
							(view.getActividadesCB().getSelectedIndex()+1),
							getSelectedIndex(view.getComboBox_instalacion()) +1, 
							Util.dateToIsoString(Util.isoStringToDate(view.getTextFecha().getText())),
							(float) Double.parseDouble(getSelectedItem(view.getComboBox_HoraC())),
							(float) Double.parseDouble(getSelectedItem(view.getComboBox_HoraF())), 
							estado);



					view.getTxtNombre().setText(socio.get(0).getNombre());
					view.getTxtApellidos().setText(socio.get(0).getApellido1() + " " + socio.get(0).getApellido2());
					this.actividadS = (String)view.getActividadesCB().getSelectedItem();
					this.SocioS = view.getTxtSocio().getText();
					this.horaInicioS =(String) view.getComboBox_HoraC().getSelectedItem();
					this.horaFinS = (String) view.getComboBox_HoraF().getSelectedItem();
					this.instalacionS = (String) view.getComboBox_instalacion().getSelectedItem();
					this.precioS = (String) view.getTxtPrecio().getText();
					view.getBtnResguardo().setEnabled(true);
				}
			}
		}
		else {
			List <SociosDisplayDTO> socio = model.getInfoSocio(Integer.parseInt(view.getTxtSocio().getText()));

			if(!socio.isEmpty()){

				int estado = 1;


				model.realizarReserva(Integer.parseInt(view.getTxtReserva().getText()),
						Integer.parseInt(view.getTxtSocio().getText()),
						(view.getActividadesCB().getSelectedIndex()+1),
						getSelectedIndex(view.getComboBox_instalacion()) +1, 
						Util.dateToIsoString(Util.isoStringToDate(view.getTextFecha().getText())),
						(float) Double.parseDouble(getSelectedItem(view.getComboBox_HoraC())),
						(float) Double.parseDouble(getSelectedItem(view.getComboBox_HoraF())), 
						estado);



				view.getTxtNombre().setText(socio.get(0).getNombre());
				view.getTxtApellidos().setText(socio.get(0).getApellido1() + " " + socio.get(0).getApellido2());
				this.actividadS = (String)view.getActividadesCB().getSelectedItem();
				this.SocioS = view.getTxtSocio().getText();
				this.horaInicioS =(String) view.getComboBox_HoraC().getSelectedItem();
				this.horaFinS = (String) view.getComboBox_HoraF().getSelectedItem();
				this.instalacionS = (String) view.getComboBox_instalacion().getSelectedItem();
				this.precioS = (String) view.getTxtPrecio().getText();
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

				try{
					String ruta = "./resguardo.txt";
		            String contenido = "RESGUARDO DE LA RESERVA DE LA INSTALACIÓN\n";
		            File file = new File(ruta);
		            // Si el archivo no existe es creado
		            if (!file.exists()) {
		                file.createNewFile();
		            }
		            FileWriter fw = new FileWriter(file);
		            BufferedWriter bw = new BufferedWriter(fw);
		            bw.write(contenido);
		            bw.write("\nNombre: " + view.getTxtNombre().getText() + "				" + "Apellidos: " + view.getTxtApellidos().getText());
		            bw.write("\nNº Reserva: " + view.getTxtReserva().getText());
		            bw.write("\nNº Socio: " + this.SocioS);
		            bw.write("\nNº Instalación: " + this.instalacionS
		            		+ "		Nº Actividad: "+ this.actividadS);
		            bw.write("\nForma de pago: " + (view.getRdBtnEfectivo().isSelected() ?
									"En efectivo" : "A final de mes"));
		            bw.write("           Fecha: " + view.getTextFecha().getText());
		            bw.write("\nIntervalo de horas: " + this.horaInicioS + ":00 - " 
		            		+ this.horaFinS + ":00");
		            bw.write("        Precio reserva: " + this.precioS + "€");
		            bw.close();
			
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

				} catch (IOException e) {
					e.printStackTrace();
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
