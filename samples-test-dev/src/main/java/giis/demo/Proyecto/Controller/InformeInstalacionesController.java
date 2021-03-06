package giis.demo.Proyecto.Controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import giis.demo.Proyecto.DTO.InstalacionesDisplayDTO;
import giis.demo.Proyecto.DTO.ReservaDTO;
import giis.demo.Proyecto.Model.InformeInstalacionesModel;
import giis.demo.Proyecto.View.InformeInstalacionesView;
import giis.demo.util.SwingUtil;
import giis.demo.util.Util;

public class InformeInstalacionesController {


	private InformeInstalacionesModel model; 
	private InformeInstalacionesView view;


	public InformeInstalacionesController(InformeInstalacionesView view, InformeInstalacionesModel model) {

		this.model = model;
		this.view = view;
	} 

	public void initView() {

		this.view.getFrmGenerarInformesSobre().setVisible(true); 

	}

	public void initController() {	

		this.initView();
		view.getFrmGenerarInformesSobre().setVisible(true);
		view.getBtnGenerar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> dispatcher()));
		view.getBtnLimpiar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> limpiar()));


	}

	/*
	 * Resetea los valores de la vista
	 */
	private void limpiar() {

		this.view.getDateChooserFinal().setDate(null);
		this.view.getDateChooserInicio().setDate(null);
		this.view.getTextFieldInstalacion().setText("");

	}

	/*
	 * Retorna cierto si las fechas en la vista 
	 * tienen sentido
	 */
	private boolean fechasOK() {

		if(this.view.getDateChooserInicio().getDate().after(this.view.getDateChooserFinal().getDate())) {

			return false;

		}   else return true;

	}


	/* 
	 * Despachador de funciones para el botón generar
	 * en función de la situación de los campos de la vista,
	 * llama a la generación de un tipo de informe u otro
	 */
	private void dispatcher() {


		// Si no se ha introducido un ID de instalacion, se realizará un informe con todas ellas
		if(this.view.getTextFieldInstalacion().getText().isBlank()) {

			// Si se ha seleccionado una fecha
			if (this.view.getDateChooserFinal().getDate() != null 
					&& this.view.getDateChooserInicio().getDate() != null) {

				if(!fechasOK()) {

					SwingUtil.showMessage("Revise las fechas introducidas", "Vaya...", 0);
					return;
				}

				else {

					if(this.view.getRdbtnReservas().isSelected()) { 

						// R E S E R V A S  --->  S I N    I D  --->  T E M P
						ReservasGeneralTemp(this.view.getDateChooserInicio().getDate() , 
								this.view.getDateChooserFinal().getDate());

					}


					else if(this.view.getRdbtnActividades().isSelected()) {

						// A C T I V I D A D E S  --->  S I N    I D  --->  T E M P
						ActividadesGeneralTemp(this.view.getDateChooserInicio().getDate() , 
								this.view.getDateChooserFinal().getDate());
					}

				}

			} //END - SÍ SE HAN SELECCIONADO FECHAS



			// No se han seleccionado fechas -> se elabora un informe histórico del centro
			else {


				if(this.view.getRdbtnReservas().isSelected()) { 

					// R E S E R V A S  --->  S I N    I D  --->  H I S T O R I C O
					ReservasGeneralHist();

				}


				else if(this.view.getRdbtnActividades().isSelected()) {

					// A C T I V I D A D E S  --->  S I N    I D  ---> H I S T O R I C O
					ActividadesGeneralHist();
				}

			} // END - NO SE HAN SELECCIONADO FECHAS

		} // END - NO SE HA INDICADO ID DE INSTALACION



		// Sí se ha indicado un ID de instalación
		else {


			// Si se ha seleccionado una fecha
			if (this.view.getDateChooserFinal().getDate() != null 
					&& this.view.getDateChooserInicio().getDate() != null) {

				if(!fechasOK()) {

					SwingUtil.showMessage("Revise las fechas introducidas", "Vaya...", 0);
					return;
				}

				else {

					if(this.view.getRdbtnReservas().isSelected()) { 

						try {
							int id = Integer.parseInt(this.view.getTextFieldInstalacion().getText());

							// R E S E R V A S  --->  C O N    I D  --->  T E M P
							ReservasTempID(id , this.view.getDateChooserInicio().getDate() , 
									this.view.getDateChooserFinal().getDate());

						}
						catch (NumberFormatException e ) {

							SwingUtil.showMessage("El #ID de Instalación debe ser numérico", "Vaya...", 0);
							return;
						}




					}


					else if(this.view.getRdbtnActividades().isSelected()) {

						try {
							int id = Integer.parseInt(this.view.getTextFieldInstalacion().getText());
							// A C T I V I D A D E S  --->  C O N    I D  --->  T E M P
							ActividadesTempID(id, this.view.getDateChooserInicio().getDate() , 
									this.view.getDateChooserFinal().getDate());

						}
						catch (NumberFormatException e) {

							SwingUtil.showMessage("El #ID de Instalación debe ser numérico", "Vaya...", 0);
							return;

						}

					}

				}

			} //END - SÍ SE HAN SELECCIONADO FECHAS



			// No se han seleccionado fechas -> se elabora un informe histórico del centro
			else {


				if(this.view.getRdbtnReservas().isSelected()) { 

					try {

						int id = Integer.parseInt(this.view.getTextFieldInstalacion().getText());

						// R E S E R V A S  --->  C O N    I D  --->  H I S T O R I C O
						ReservasHistID(id);

					}
					catch (NumberFormatException e) {

						SwingUtil.showMessage("El #ID de Instalación debe ser numérico", "Vaya...", 0);
						return;

					}



				}


				else if(this.view.getRdbtnActividades().isSelected()) {

					try {

						int id = Integer.parseInt(this.view.getTextFieldInstalacion().getText());

						// A C T I V I D A D E S  --->  C O N    I D  --->  H I S T O R I C O
						ActividadesHistID(id);

					}
					catch (NumberFormatException e) {

						SwingUtil.showMessage("El #ID de Instalación debe ser numérico", "Vaya...", 0);
						return;

					}
				}

			} // END - NO SE HAN SELECCIONADO FECHAS


		} //END - SI SE HA INDICADO ID DE INSTALACION


	} //END METHOD


	// -----------------------------// -----------------------------//-----------------------------//-----------------------------
	// ------------------------------ G E N E R A C I Ó N     D E       I N F O R M E S ---------------------------------------------
	// -----------------------------// -----------------------------//-----------------------------//-----------------------------


	/* Genera un informe de ACTIVIDADES HISTÓRICO sobre 
	 * la INSTALACIÓN pasada como argumento 
	 */
	private void ActividadesHistID(int id) {

		List<InstalacionesDisplayDTO> listInstalaciones = model.getInstalacion(id);

		List<ReservaDTO> listActividades = model.getActividades(id);

		int horasTotales = 0; 

		for(ReservaDTO actividad : listActividades) {

			horasTotales += actividad.getHoraFin() - actividad.getHoraInicio();

		}

		File fichero = new File (".","InformeInstalaciones.txt");
		String texto = "Instalación #" + id 
				+ "\nNombre: " + listInstalaciones.get(0).getNombre()
				+ "\nPrecio/hora: " + listInstalaciones.get(0).getPrecioHora() + "€"
				+ "\nUso Total: " + horasTotales + " (horas)";
		
		try {
			fichero.createNewFile();
			FileWriter fw = new FileWriter(fichero);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(texto);

			bw.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Instalación #" + id 
				+ "\nNombre: " + listInstalaciones.get(0).getNombre()
				+ "\nPrecio/hora: " + listInstalaciones.get(0).getPrecioHora() + "€"
				+ "\nUso Total: " + horasTotales + " (horas)" 

				);


	}

	/* Genera un informe de RESERVAS HISTÓRICO sobre 
	 * la INSTALACIÓN pasada como argumento 
	 */
	private void ReservasHistID(int id) {

		List<InstalacionesDisplayDTO> listInstalaciones = model.getInstalacion(id);

		List<ReservaDTO> listReservas = model.getReservas(id);

		int horasTotales = 0; 

		for(ReservaDTO reserva : listReservas) {

			horasTotales += reserva.getHoraFin() - reserva.getHoraInicio();

		}

		File fichero = new File (".","InformeInstalaciones.txt");
		String texto = "Instalación #" + id 
				+ "\nNombre: " + listInstalaciones.get(0).getNombre()
				+ "\nPrecio/hora: " + listInstalaciones.get(0).getPrecioHora() + "€"
				+ "\nUso Total: " + horasTotales + " (horas)" 
				+ "\nFacturación Total: " + horasTotales*listInstalaciones.get(0).getPrecioHora() +"€";
		
		try {
			fichero.createNewFile();
			FileWriter fw = new FileWriter(fichero);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(texto);

			bw.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		
		System.out.println("Instalación #" + id 
				+ "\nNombre: " + listInstalaciones.get(0).getNombre()
				+ "\nPrecio/hora: " + listInstalaciones.get(0).getPrecioHora() + "€"
				+ "\nUso Total: " + horasTotales + " (horas)" 
				+ "\nFacturación Total: " + horasTotales*listInstalaciones.get(0).getPrecioHora() +"€"
				);



	}


	/* Genera un informe de ACTIVIDADES TEMPORAL sobre 
	 * la INSTALACIÓN pasada como argumento 
	 */
	private void ActividadesTempID(int id, Date date, Date date2) {

		List<InstalacionesDisplayDTO> listInstalaciones = model.getInstalacion(id);

		List<ReservaDTO> listActividades = model.getActividadesTempID(id, date,date2);

		double horasTotales = 0; 

		double diasFull = (date2.getTime() - date.getTime())/ (1000*3600*24); 
		double horasFull = diasFull * 14;

		for(ReservaDTO actividad : listActividades) {

			horasTotales += actividad.getHoraFin() - actividad.getHoraInicio();

		}

		double porcentaje = (horasTotales/horasFull)*100;

		File fichero = new File (".","InformeInstalaciones.txt");
		String texto = "Instalación #" + id 
				+ "\nNombre: " + listInstalaciones.get(0).getNombre()
				+ "\nPrecio/hora: " + listInstalaciones.get(0).getPrecioHora() + "€"
				+ "\nFecha de Inicio: " + Util.dateToIsoString(date)
				+ "\nFecha Final: " + Util.dateToIsoString(date2)
				+ "\nUso Total: " + horasTotales + " (horas)" 
				+ "\nPorcentaje de Uso: " + String.format("%.2f", porcentaje) + "%";
		
		try {
			fichero.createNewFile();
			FileWriter fw = new FileWriter(fichero);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(texto);

			bw.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Instalación #" + id 
				+ "\nNombre: " + listInstalaciones.get(0).getNombre()
				+ "\nPrecio/hora: " + listInstalaciones.get(0).getPrecioHora() + "€"
				+ "\nFecha de Inicio: " + Util.dateToIsoString(date)
				+ "\nFecha Final: " + Util.dateToIsoString(date2)
				+ "\nUso Total: " + horasTotales + " (horas)" 
				+ "\nPorcentaje de Uso: " + String.format("%.2f", porcentaje) + "%" );


	}

	/* Genera un informe de RESERVAS TEMPORAL sobre 
	 * la INSTALACIÓN pasada como argumento 
	 */
	private void ReservasTempID(int id, Date date, Date date2) {


		List<InstalacionesDisplayDTO> listInstalaciones = model.getInstalacion(id);

		List<ReservaDTO> listReservas = model.getReservasTempID(id,date,date2);

		double horasTotales = 0; 

		double diasFull = date2.getTime() - date.getTime() / (1000*3600*24); 
		double horasFull = diasFull * 14;

		for(ReservaDTO actividad : listReservas) {

			horasTotales += actividad.getHoraFin() - actividad.getHoraInicio();

		}

		double porcentaje = (horasTotales/horasFull)*100;

		File fichero = new File (".","InformeInstalaciones.txt");
		String texto = "Instalación #" + id 
				+ "\nNombre: " + listInstalaciones.get(0).getNombre()
				+ "\nPrecio/hora: " + listInstalaciones.get(0).getPrecioHora() + "€"
				+ "\nFecha de Inicio: " + Util.dateToIsoString(date)
				+ "\nFecha Final: " + Util.dateToIsoString(date2)
				+ "\nUso Total: " + horasTotales + " (horas)" 
				+ "\nPorcentaje de Uso: " + String.format("%.2f", porcentaje) + "%" 
				+ "\nFacturación Total: " + horasTotales*listInstalaciones.get(0).getPrecioHora() +"€";
		
		try {
			fichero.createNewFile();
			FileWriter fw = new FileWriter(fichero);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(texto);

			bw.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("Instalación #" + id 
				+ "\nNombre: " + listInstalaciones.get(0).getNombre()
				+ "\nPrecio/hora: " + listInstalaciones.get(0).getPrecioHora() + "€"
				+ "\nFecha de Inicio: " + Util.dateToIsoString(date)
				+ "\nFecha Final: " + Util.dateToIsoString(date2)
				+ "\nUso Total: " + horasTotales + " (horas)" 
				+ "\nPorcentaje de Uso: " + String.format("%.2f", porcentaje) + "%" 
				+ "\nFacturación Total: " + horasTotales*listInstalaciones.get(0).getPrecioHora() +"€"
				);

	}


	/* Genera un informe de ACTIVIDADES HISTÓRICO sobre 
	 * TODAS LAS INSTALACIONES del centro
	 */
	private void ActividadesGeneralHist() {


		List<InstalacionesDisplayDTO> listInstalaciones = model.getInstalaciones();

		File fichero = new File (".","InformeInstalaciones.txt");
		String texto = "------- INFORME DE INSTALACIONES GENERAL (ACTIVIDADES) ------";
		
		for(InstalacionesDisplayDTO instalacion : listInstalaciones) {

			int horasTotales = 0; 

			List<ReservaDTO> listActividades = model.getActividades(instalacion.getIdInstalacion());

			for(ReservaDTO actividad : listActividades) {

				horasTotales += actividad.getHoraFin() - actividad.getHoraInicio();

			}

			texto = texto.concat("\n");
			texto = texto.concat("----------------------------------"
					+ "\nInstalación #" + instalacion.getIdInstalacion() 
					+ "\nNombre: " + instalacion.getNombre()
					+ "\nPrecio/hora: " + instalacion.getPrecioHora() + "€"
					+ "\nUso Total: " + horasTotales + " (horas)");

			
			System.out.println("----------------------------------"
					+ "\nInstalación #" + instalacion.getIdInstalacion() 
					+ "\nNombre: " + instalacion.getNombre()
					+ "\nPrecio/hora: " + instalacion.getPrecioHora() + "€"
					+ "\nUso Total: " + horasTotales + " (horas)" 

					);


		}
		
	
		try {
			fichero.createNewFile();
			FileWriter fw = new FileWriter(fichero);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(texto);

			bw.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	/* Genera un informe de RESERVAS HISTÓRICO sobre 
	 * TODAS LAS INSTALACIONES del centro
	 */
	private void ReservasGeneralHist() {


		List<InstalacionesDisplayDTO> listInstalaciones = model.getInstalaciones();
		
		File fichero = new File (".","InformeInstalaciones.txt");
		String texto = "------- INFORME DE INSTALACIONES GENERAL (RESERVAS) ------";


		for(InstalacionesDisplayDTO instalacion : listInstalaciones) {

			int horasTotales = 0; 

			List<ReservaDTO> listReservas = model.getReservas(instalacion.getIdInstalacion());

			for(ReservaDTO reserva : listReservas) {

				horasTotales += reserva.getHoraFin() - reserva.getHoraInicio();

			}

			texto = texto.concat("\n");
			texto = texto.concat("----------------------------------"
					+ "\nInstalación #" + instalacion.getIdInstalacion() 
					+ "\nNombre: " + instalacion.getNombre()
					+ "\nPrecio/hora: " + instalacion.getPrecioHora() + "€"
					+ "\nUso Total: " + horasTotales + " (horas)" 
					+ "\nFacturación Total: " + horasTotales*instalacion.getPrecioHora() +"€");
			
			
			System.out.println("----------------------------------"
					+ "\nInstalación #" + instalacion.getIdInstalacion() 
					+ "\nNombre: " + instalacion.getNombre()
					+ "\nPrecio/hora: " + instalacion.getPrecioHora() + "€"
					+ "\nUso Total: " + horasTotales + " (horas)" 
					+ "\nFacturación Total: " + horasTotales*instalacion.getPrecioHora() +"€"

					);


		}

		
		try {
			fichero.createNewFile();
			FileWriter fw = new FileWriter(fichero);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(texto);

			bw.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	/* Genera un informe de ACTIVIDADES TEMPORAL sobre 
	 * TODAS LAS INSTALACIONES del centro
	 */
	private void ActividadesGeneralTemp(Date date, Date date2) {



		List<InstalacionesDisplayDTO> listInstalaciones = model.getInstalaciones();

		File fichero = new File (".","InformeInstalaciones.txt");
		String texto = "------- INFORME DE INSTALACIONES TEMPORAL (ACTIVIDADES) ------";


		for(InstalacionesDisplayDTO instalacion : listInstalaciones) {

			int horasTotales = 0; 

			List<ReservaDTO> listActividades = model.getActividadesTemp(instalacion.getIdInstalacion(),date,date2);

			for(ReservaDTO actividad : listActividades) {

				horasTotales += actividad.getHoraFin() - actividad.getHoraInicio();

			}

			texto = texto.concat("\n");
			
			texto = texto.concat("----------------------------------"
					+ "\nInstalación #" + instalacion.getIdInstalacion() 
					+ "\nNombre: " + instalacion.getNombre()
					+ "\nPrecio/hora: " + instalacion.getPrecioHora() + "€"
					+ "\nUso Total: " + horasTotales + " (horas)" );

			System.out.println("----------------------------------"
					+ "\nInstalación #" + instalacion.getIdInstalacion() 
					+ "\nNombre: " + instalacion.getNombre()
					+ "\nPrecio/hora: " + instalacion.getPrecioHora() + "€"
					+ "\nUso Total: " + horasTotales + " (horas)" 

					);


		}
		
		try {
			fichero.createNewFile();
			FileWriter fw = new FileWriter(fichero);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(texto);

			bw.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}





	}


	/* Genera un informe de RESERVAS TEMPORAL sobre 
	 * TODAS LAS INSTALACIONES del centro
	 */
	private void ReservasGeneralTemp(Date date, Date date2) {


		List<InstalacionesDisplayDTO> listInstalaciones = model.getInstalaciones();


		File fichero = new File (".","InformeInstalaciones.txt");
		String texto = "------- INFORME DE INSTALACIONES TEMPORAL (RESERVAS) ------";

		for(InstalacionesDisplayDTO instalacion : listInstalaciones) {

			int horasTotales = 0; 

			List<ReservaDTO> listActividades = model.getReservasTemp(instalacion.getIdInstalacion(),date,date2);

			for(ReservaDTO actividad : listActividades) {

				horasTotales += actividad.getHoraFin() - actividad.getHoraInicio();

			}

			
			texto = texto.concat("\n");
			texto = texto.concat("----------------------------------"
					+ "\nInstalación #" + instalacion.getIdInstalacion() 
					+ "\nNombre: " + instalacion.getNombre()
					+ "\nPrecio/hora: " + instalacion.getPrecioHora() + "€"
					+ "\nUso Total: " + horasTotales + " (horas)");

			System.out.println("----------------------------------"
					+ "\nInstalación #" + instalacion.getIdInstalacion() 
					+ "\nNombre: " + instalacion.getNombre()
					+ "\nPrecio/hora: " + instalacion.getPrecioHora() + "€"
					+ "\nUso Total: " + horasTotales + " (horas)" 

					);


		}
		
		
		try {
			fichero.createNewFile();
			FileWriter fw = new FileWriter(fichero);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(texto);

			bw.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}



	}


}