package giis.demo.Proyecto.Controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import giis.demo.Proyecto.DTO.ReservaDTO;
import giis.demo.Proyecto.DTO.SociosDisplayDTO;
import giis.demo.Proyecto.Model.InformeSociosModel;
import giis.demo.Proyecto.View.InformeSociosView;
import giis.demo.util.SwingUtil;
import giis.demo.util.Util;

public class InformeSociosController {


	private InformeSociosModel model; 
	private InformeSociosView view;


	public InformeSociosController(InformeSociosView view, InformeSociosModel model) {

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
		this.view.getTextFieldSocio().setText(" ");


	}

	private boolean fechasOK() {


		if(this.view.getDateChooserInicio().getDate().after(this.view.getDateChooserFinal().getDate())) {

			return false;
		}


		else return true;

	}



	/* 
	 * Llama a la función correspondiente para generar
	 * el informe deseado, en función de cómo se encuentren
	 * los campos de la vista, hayan sido modificados o no 
	 * por el administrador
	 */
	private void dispatcher() {


		// Si no se ha introducido un ID de socio, se realizará un informe con todas ellas
		if(this.view.getTextFieldSocio().getText().isBlank()) {

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

		} // END - NO SE HA INDICADO ID DE socio



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
							int id = Integer.parseInt(this.view.getTextFieldSocio().getText());

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
							int id = Integer.parseInt(this.view.getTextFieldSocio().getText());
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

						int id = Integer.parseInt(this.view.getTextFieldSocio().getText());

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

						int id = Integer.parseInt(this.view.getTextFieldSocio().getText());

						// A C T I V I D A D E S  --->  C O N    I D  --->  H I S T O R I C O
						ActividadesHistID(id);

					}
					catch (NumberFormatException e) {

						SwingUtil.showMessage("El #ID de Instalación debe ser numérico", "Vaya...", 0);
						return;

					}
				}

			} // END - NO SE HAN SELECCIONADO FECHAS


		} //END - SI SE HA INDICADO ID DE socio



	}



	// -----------------------------// -----------------------------//-----------------------------//-----------------------------
	// ------------------------------ G E N E R A C I Ó N     D E       I N F O R M E S ---------------------------------------------
	// -----------------------------// -----------------------------//-----------------------------//-----------------------------





	private void ActividadesHistID(int id) {

		List<SociosDisplayDTO> listSocios = model.getSocio(id);

		List<ReservaDTO> listActividades = model.getActividades(id);

		int horasTotales = 0; 

		for(ReservaDTO actividad : listActividades) {

			horasTotales += actividad.getHoraFin() - actividad.getHoraInicio();

		}

		File fichero = new File (".","InformeSocios.txt");
		String texto = "Socio #" + id 
				+ "\nNombre: " + listSocios.get(0).getNombre() + " " + listSocios.get(0).getApellido1() + " " + listSocios.get(0).getApellido2()
				+ "\nNúmero de Reservas: " + listActividades.size() 
				+ "\nUso Total de Instalaciones: " + horasTotales + " (horas)"
				+ "\nCuota: " + listSocios.get(0).getCuota() + "€"
				+ "\nCorriente de Pago: " + (listSocios.get(0).getCorrientePago().equals("si")  ? "Sí" : "No" );


		try {
			fichero.createNewFile();
			FileWriter fw = new FileWriter(fichero);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(texto);

			bw.close();


		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Socio #" + id 
				+ "\nNombre: " + listSocios.get(0).getNombre() + " " + listSocios.get(0).getApellido1() + " " + listSocios.get(0).getApellido2()
				+ "\nNúmero de Reservas: " + listActividades.size() 
				+ "\nUso Total de Instalaciones: " + horasTotales + " (horas)"
				+ "\nCuota: " + listSocios.get(0).getCuota() + "€"
				+ "\nCorriente de Pago: " + (listSocios.get(0).getCorrientePago().equals("si")   ? "Sí" : "No" ));


	}


	private void ReservasHistID(int id) {


		List<SociosDisplayDTO> listSocios = model.getSocio(id);

		List<ReservaDTO> listReservas = model.getReservas(id);

		int horasTotales = 0; 

		for(ReservaDTO actividad : listReservas) {

			horasTotales += actividad.getHoraFin() - actividad.getHoraInicio();

		}

		File fichero = new File (".","InformeSocios.txt");
		String texto = "Socio #" + id 
				+ "\nNombre: " + listSocios.get(0).getNombre() + " " + listSocios.get(0).getApellido1() + " " + listSocios.get(0).getApellido2()
				+ "\nNúmero de Reservas: " + listReservas.size() 
				+ "\nUso Total de Instalaciones: " + horasTotales + " (horas)"
				+ "\nCuota: " + listSocios.get(0).getCuota() + "€"
				+ "\nCorriente de Pago: " + (listSocios.get(0).getCorrientePago().equals("si")  ? "Sí" : "No" );


		try {
			fichero.createNewFile();
			FileWriter fw = new FileWriter(fichero);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(texto);

			bw.close();


		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Socio #" + id 
				+ "\nNombre: " + listSocios.get(0).getNombre() + " " + listSocios.get(0).getApellido1() + " " + listSocios.get(0).getApellido2()
				+ "\nNúmero de Reservas: " + listReservas.size() 
				+ "\nUso Total de Instalaciones: " + horasTotales + " (horas)"
				+ "\nCuota: " + listSocios.get(0).getCuota() + "€"
				+ "\nCorriente de Pago: " + (listSocios.get(0).getCorrientePago().equals("si")   ? "Sí" : "No" ));


	}


	private void ActividadesTempID(int id, Date date, Date date2) {


		List<SociosDisplayDTO> listSocios = model.getSocio(id);

		List<ReservaDTO> listActividades = model.getActividadesTemp(id, date,date2);

		double horasTotales = 0; 

		double diasFull = (date2.getTime() - date.getTime())/ (1000*3600*24); 
		double horasFull = diasFull * 14;

		for(ReservaDTO actividad : listActividades) {

			horasTotales += actividad.getHoraFin() - actividad.getHoraInicio();

		}

		double porcentaje = (horasTotales/horasFull)*100;

		File fichero = new File (".","InformeSocios.txt");
		String texto = "Socio #" + id 
				+ "\nNombre: " + listSocios.get(0).getNombre() + " " + listSocios.get(0).getApellido1() + " " + listSocios.get(0).getApellido2()
				+ "\nNúmero de Reservas: " + listActividades.size() 
				+ "\nUso Total de Instalaciones: " + horasTotales + " (horas)"
				+ "\nFecha de Inicio: " + Util.dateToIsoString(date)
				+ "\nFecha Final: " + Util.dateToIsoString(date2)
				+ "\nUso Total: " + horasTotales + " (horas)" 
				+ "\nCuota: " + listSocios.get(0).getCuota() + "€"
				+ "\nPorcentaje de Uso: " + String.format("%.2f", porcentaje) + "%"
				+ "\nCorriente de Pago: " + (listSocios.get(0).getCorrientePago().equals("si")   ? "Sí" : "No" )
				;
				

				try {
					fichero.createNewFile();
					FileWriter fw = new FileWriter(fichero);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(texto);

					bw.close();


				} catch (IOException e) {
					e.printStackTrace();
				}

				System.out.println("Socio #" + id 
						+ "\nNombre: " + listSocios.get(0).getNombre() + " " + listSocios.get(0).getApellido1() + " " + listSocios.get(0).getApellido2()
						+ "\nNúmero de Reservas: " + listActividades.size() 
						+ "\nUso Total de Instalaciones: " + horasTotales + " (horas)"
						+ "\nFecha de Inicio: " + Util.dateToIsoString(date)
						+ "\nFecha Final: " + Util.dateToIsoString(date2)
						+ "\nUso Total: " + horasTotales + " (horas)" 
						+ "\nCuota: " + listSocios.get(0).getCuota() + "€"
						+ "\nPorcentaje de Uso: " + String.format("%.2f", porcentaje) + "%"
						+ "\nCorriente de Pago: " + (listSocios.get(0).getCorrientePago().equals("si")   ? "Sí" : "No") );



	}


	private void ReservasTempID(int id, Date date, Date date2) {

		
		List<SociosDisplayDTO> listSocios = model.getSocio(id);

		List<ReservaDTO> listReservas = model.getReservasTemp(id, date,date2);

		double horasTotales = 0; 

		double diasFull = (date2.getTime() - date.getTime())/ (1000*3600*24); 
		double horasFull = diasFull * 14;

		for(ReservaDTO actividad : listReservas) {

			horasTotales += actividad.getHoraFin() - actividad.getHoraInicio();

		}

		double porcentaje = (horasTotales/horasFull)*100;

		File fichero = new File (".","InformeSocios.txt");
		String texto = "Socio #" + id 
				+ "\nNombre: " + listSocios.get(0).getNombre() + " " + listSocios.get(0).getApellido1() + " " + listSocios.get(0).getApellido2()
				+ "\nNúmero de Reservas: " + listReservas.size() 
				+ "\nUso Total de Instalaciones: " + horasTotales + " (horas)"
				+ "\nFecha de Inicio: " + Util.dateToIsoString(date)
				+ "\nFecha Final: " + Util.dateToIsoString(date2)
				+ "\nUso Total: " + horasTotales + " (horas)" 
				+ "\nCuota: " + listSocios.get(0).getCuota() + "€"
				+ "\nPorcentaje de Uso: " + String.format("%.2f", porcentaje) + "%"
				+ "\nCorriente de Pago: " + (listSocios.get(0).getCorrientePago().equals("si")   ? "Sí" : "No" )
				;
				

				try {
					fichero.createNewFile();
					FileWriter fw = new FileWriter(fichero);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(texto);

					bw.close();


				} catch (IOException e) {
					e.printStackTrace();
				}

				System.out.println("Socio #" + id 
						+ "\nNombre: " + listSocios.get(0).getNombre() + " " + listSocios.get(0).getApellido1() + " " + listSocios.get(0).getApellido2()
						+ "\nNúmero de Reservas: " + listReservas.size() 
						+ "\nUso Total de Instalaciones: " + horasTotales + " (horas)"
						+ "\nFecha de Inicio: " + Util.dateToIsoString(date)
						+ "\nFecha Final: " + Util.dateToIsoString(date2)
						+ "\nUso Total: " + horasTotales + " (horas)" 
						+ "\nCuota: " + listSocios.get(0).getCuota() + "€"
						+ "\nPorcentaje de Uso: " + String.format("%.2f", porcentaje) + "%"
						+ "\nCorriente de Pago: " + (listSocios.get(0).getCorrientePago().equals("si")   ? "Sí" : "No") );


	}


	private void ActividadesGeneralHist() {

		
		List<SociosDisplayDTO> listSocios = model.getSocios();

		File fichero = new File (".","InformeSocios.txt");
		String texto = "------- INFORME DE SOCIOS GENERAL (ACTIVIDADES) ------";
		
		for(SociosDisplayDTO socio : listSocios) {

			int horasTotales = 0; 

			List<ReservaDTO> listActividades = model.getActividades(socio.getIdSocio());

			for(ReservaDTO actividad : listActividades) {

				horasTotales += actividad.getHoraFin() - actividad.getHoraInicio();

			}

			texto = texto.concat("\n");
			texto = texto.concat("----------------------------------"
					+ "\nSocio #" + socio.getIdSocio()
					+ "\nNombre: " + socio.getNombre() + " " + socio.getApellido1() + " " + socio.getApellido2()
					+ "\nNúmero de Reservas: " + listActividades.size() 
					+ "\nUso Total de Instalaciones: " + horasTotales + " (horas)"
					+ "\nCuota: " + socio.getCuota() + "€"
					+ "\nCorriente de Pago: " + (socio.getCorrientePago().equals("si")   ? "Sí" : "No" ));

			
			System.out.println("----------------------------------"
					+ "\nSocio #" + socio.getIdSocio()
					+ "\nNombre: " + socio.getNombre() + " " + socio.getApellido1() + " " + socio.getApellido2()
					+ "\nNúmero de Reservas: " + listActividades.size() 
					+ "\nUso Total de Instalaciones: " + horasTotales + " (horas)"
					+ "\nCuota: " + socio.getCuota() + "€"
					+ "\nCorriente de Pago: " + (socio.getCorrientePago().equals("si")   ? "Sí" : "No" )
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


	private void ReservasGeneralHist() {

		List<SociosDisplayDTO> listSocios = model.getSocios();

		File fichero = new File (".","InformeSocios.txt");
		String texto = "------- INFORME DE SOCIOS GENERAL (RESERVAS) ------";
		
		for(SociosDisplayDTO socio : listSocios) {

			int horasTotales = 0; 

			List<ReservaDTO> listReservas = model.getReservas(socio.getIdSocio());

			for(ReservaDTO actividad : listReservas) {

				horasTotales += actividad.getHoraFin() - actividad.getHoraInicio();

			}

			texto = texto.concat("\n");
			texto = texto.concat("----------------------------------"
					+ "\nSocio #" + socio.getIdSocio()
					+ "\nNombre: " + socio.getNombre() + " " + socio.getApellido1() + " " + socio.getApellido2()
					+ "\nNúmero de Reservas: " + listReservas.size() 
					+ "\nUso Total de Instalaciones: " + horasTotales + " (horas)"
					+ "\nCuota: " + socio.getCuota() + "€"
					+ "\nCorriente de Pago: " + (socio.getCorrientePago().equals("si")   ? "Sí" : "No" ));

			
			System.out.println("----------------------------------"
					+ "\nSocio #" + socio.getIdSocio()
					+ "\nNombre: " + socio.getNombre() + " " + socio.getApellido1() + " " + socio.getApellido2()
					+ "\nNúmero de Reservas: " + listReservas.size() 
					+ "\nUso Total de Instalaciones: " + horasTotales + " (horas)"
					+ "\nCuota: " + socio.getCuota() + "€"
					+ "\nCorriente de Pago: " + (socio.getCorrientePago().equals("si")   ? "Sí" : "No" )
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


	private void ActividadesGeneralTemp(Date date, Date date2) {

		
		List<SociosDisplayDTO> listSocios = model.getSocios();

		File fichero = new File (".","InformeSocios.txt");
		String texto = "------- INFORME DE SOCIOS TEMPORAL (ACTIVIDADES) ------";


		for(SociosDisplayDTO socio : listSocios) {

			int horasTotales = 0; 

			List<ReservaDTO> listActividades = model.getActividadesTemp(socio.getIdSocio(),date,date2);

			for(ReservaDTO actividad : listActividades) {

				horasTotales += actividad.getHoraFin() - actividad.getHoraInicio();

			}

			texto = texto.concat("\n");
			
			texto = texto.concat("----------------------------------"
					+ "\nSocio #" + socio.getIdSocio()
					+ "\nNombre: " + socio.getNombre() + " " + socio.getApellido1() + " " + socio.getApellido2()
					+ "\nFecha de Inicio: " + Util.dateToIsoString(date)
					+ "\nFecha Final: " + Util.dateToIsoString(date2)
					+ "\nNúmero de Reservas: " + listActividades.size() 
					+ "\nUso Total de Instalaciones: " + horasTotales + " (horas)"
					+ "\nCuota: " + socio.getCuota() + "€"
					+ "\nCorriente de Pago: " + (socio.getCorrientePago().equals("si")   ? "Sí" : "No" ));

			System.out.println("----------------------------------"
					+ "\nSocio #" + socio.getIdSocio()
					+ "\nNombre: " + socio.getNombre() + " " + socio.getApellido1() + " " + socio.getApellido2()
					+ "\nFecha de Inicio: " + Util.dateToIsoString(date)
					+ "\nFecha Final: " + Util.dateToIsoString(date2)
					+ "\nNúmero de Reservas: " + listActividades.size() 
					+ "\nUso Total de Instalaciones: " + horasTotales + " (horas)"
					+ "\nCuota: " + socio.getCuota() + "€"
					+ "\nCorriente de Pago: " + (socio.getCorrientePago().equals("si")   ? "Sí" : "No" ));

					


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


	private void ReservasGeneralTemp(Date date, Date date2) {

		List<SociosDisplayDTO> listSocios = model.getSocios();

		File fichero = new File (".","InformeSocios.txt");
		String texto = "------- INFORME DE SOCIOS TEMPORAL (RESERVAS) ------";


		for(SociosDisplayDTO socio : listSocios) {

			int horasTotales = 0; 

			List<ReservaDTO> listReservas = model.getActividadesTemp(socio.getIdSocio(),date,date2);

			for(ReservaDTO actividad : listReservas) {

				horasTotales += actividad.getHoraFin() - actividad.getHoraInicio();

			}

			texto = texto.concat("\n");
			
			texto = texto.concat("----------------------------------"
					+ "\nSocio #" + socio.getIdSocio()
					+ "\nNombre: " + socio.getNombre() + " " + socio.getApellido1() + " " + socio.getApellido2()
					+ "\nFecha de Inicio: " + Util.dateToIsoString(date)
					+ "\nFecha Final: " + Util.dateToIsoString(date2)
					+ "\nNúmero de Reservas: " + listReservas.size() 
					+ "\nUso Total de Instalaciones: " + horasTotales + " (horas)"
					+ "\nCuota: " + socio.getCuota() + "€"
					+ "\nCorriente de Pago: " + (socio.getCorrientePago().equals("si")   ? "Sí" : "No" ));

			System.out.println("----------------------------------"
					+ "\nSocio #" + socio.getIdSocio()
					+ "\nNombre: " + socio.getNombre() + " " + socio.getApellido1() + " " + socio.getApellido2()
					+ "\nFecha de Inicio: " + Util.dateToIsoString(date)
					+ "\nFecha Final: " + Util.dateToIsoString(date2)
					+ "\nNúmero de Reservas: " + listReservas.size() 
					+ "\nUso Total de Instalaciones: " + horasTotales + " (horas)"
					+ "\nCuota: " + socio.getCuota() + "€"
					+ "\nCorriente de Pago: " + (socio.getCorrientePago().equals("si")   ? "Sí" : "No" ));

					


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













} //end Class Controller
