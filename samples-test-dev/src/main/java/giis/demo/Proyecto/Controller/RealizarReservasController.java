package giis.demo.Proyecto.Controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import giis.demo.Proyecto.DTO.ActividadDTO;
import giis.demo.Proyecto.DTO.ReservaDTO;
import giis.demo.Proyecto.Model.RealizarReservasModel;
import giis.demo.Proyecto.View.RealizarReservasView;
import giis.demo.util.SwingUtil;
import giis.demo.util.Util;

public class RealizarReservasController {

	private RealizarReservasView view;
	private RealizarReservasModel model;


	public RealizarReservasController(RealizarReservasView view, RealizarReservasModel model) {

		this.view = view;
		this.model = model;
		this.initView();
	}

	public void initView() {
		view.getFrmRealizarReserva().setVisible(true); 

	}


	public void initController() throws ParseException{

		this.view.getFrmRealizarReserva().setVisible(true);

		this.view.getBtnCrearReserva().addActionListener(e -> SwingUtil.exceptionWrapper(() -> generarReserva()));


		this.view.getBtnBorrar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> borrar()));
		this.view.getBtnActualizar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> actualizarTabla()));
		this.view.getBtnActualizaActividades().addActionListener(e -> SwingUtil.exceptionWrapper(() -> actualizarTablaActividades()));



	}


	private void actualizarTablaActividades() {

		List<ActividadDTO> listaActividades= null;
		listaActividades = model.getListaActividades();

		if(listaActividades.isEmpty()) {

			SwingUtil.showMessage("No existen actividades en la BD todavía", "Error", 0);
		}

		else {

			TableModel tmodel=SwingUtil.getTableModelFromPojos(listaActividades, new String[] { 
					"nombre", "tipo", "fechaInicio",  "fechaFin" },
					new String[] { 
							"Nombre"  , "Tipo" , "Fecha (ini.)" , "Fecha (fin)" });


			// Asigna a la tabla de la vista el modelo generado
			view.getTableActividades().setModel(tmodel);
			SwingUtil.autoAdjustColumns(view.getTableActividades());


		}



	}

	private void actualizarTabla() {


		int diaIni, mesIni, anoIni;
		String fecha;
		diaIni = this.view.getCbDiaIni().getSelectedIndex() +1;
		mesIni = this.view.getCbMesIni().getSelectedIndex()+1;
		anoIni = Integer.parseInt(this.view.getCbAnoIni().getModel().getElementAt(this.view.getCbAnoIni().getSelectedIndex()).toString());


		fecha = Integer.toString(anoIni) + "-" + mesIni + "-" + diaIni;


		List<ReservaDTO> listReservas= null;

		listReservas = model.getListaReservas(Util.dateToIsoString(Util.isoStringToDate(fecha)));

		if(listReservas.isEmpty()) {

			SwingUtil.showMessage("No hay reservas para la fecha inicial indicada!", "Error", 1);
		}
		else {

			//Generamos el modelo de tabla y lo cargamos con los datos de la BD
			TableModel tmodel=SwingUtil.getTableModelFromPojos(listReservas, new String[] { 
					"fecha"  , "horaInicio" , "horaFin" },
					new String[] { 
							"Fecha"  , "Hora de Inicio" , "Hora de Fin" });


			// Asigna a la tabla de la vista el modelo generado
			view.getTableAnteriores().setModel(tmodel);
			SwingUtil.autoAdjustColumns(view.getTableAnteriores());
		}




	}


	private void borrar() {

		this.view.getCbAnoFin().setSelectedIndex(0);
		this.view.getCbDiaFin().setSelectedIndex(0);
		this.view.getCbMesFin().setSelectedIndex(0);
		this.view.getCbAnoIni().setSelectedIndex(0);
		this.view.getCbMesIni().setSelectedIndex(0);
		this.view.getCbDiaIni().setSelectedIndex(0);
		this.view.getComboBoxInstalacion().setSelectedIndex(0);





		DefaultTableModel dm = (DefaultTableModel) this.view.getTableAnteriores().getModel();
		int rowCount = dm.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			dm.removeRow(i);
		}

	}


	public boolean camposLlenos(){

		int diaFin, diaIni, mesFin, mesIni , anoFin , anoIni; 
		String fechaIni,fechaFin; 
		diaIni = this.view.getCbDiaIni().getSelectedIndex() +1;
		mesIni = this.view.getCbMesIni().getSelectedIndex() +1;
		anoIni = Integer.parseInt(this.view.getCbAnoIni().getModel().getElementAt(this.view.getCbAnoIni().getSelectedIndex()).toString());

		diaFin = this.view.getCbDiaFin().getSelectedIndex() +1;
		mesFin = this.view.getCbMesFin().getSelectedIndex()+1;
		anoFin = Integer.parseInt(this.view.getCbAnoFin().getModel().getElementAt(this.view.getCbAnoFin().getSelectedIndex()).toString());


		fechaIni = Integer.toString(anoIni) + "-" + mesIni + "-" + diaIni; 

		fechaFin = Integer.toString(anoFin) + "-" + mesFin + "-" + diaFin; 

		Date fechaIniD = Util.isoStringToDate(fechaIni);
		Date fechaFinD = Util.isoStringToDate(fechaFin);



		if( this.view.getTableActividades().getSelectedRowCount() <= 0
				||
				this.view.getTableActividades().getSelectedRowCount() >=2
				||
				fechaIniD.after(fechaFinD) 
				||

				(

						(this.view.getTextFieldIniL().getText().isBlank()
								|| 
								this.view.getTextFieldFinL().getText().isBlank())

						&&

						(this.view.getTextFieldIniM().getText().isBlank()
								||
								this.view.getTextFieldFinM().getText().isBlank())

						&&



						(this.view.getTextFieldIniX().getText().isBlank()
								||
								this.view.getTextFieldFinX().getText().isBlank())

						&& 

						(this.view.getTextFieldIniJ().getText().isBlank()
								||
								this.view.getTextFieldFinJ().getText().isBlank())

						&&


						(this.view.getTextFieldIniV().getText().isBlank()
								||
								this.view.getTextFieldFinV().getText().isBlank())

						&&


						(this.view.getTextFieldIniS().getText().isBlank()
								||
								this.view.getTextFieldFinS().getText().isBlank())

						&&

						(this.view.getTextFieldIniD().getText().isBlank()
								|| 
								this.view.getTextFieldFinD().getText().isBlank())

						))
		{

			return false;
		}

		else{

			return true;
		}

	}


	public boolean alreadyReserved(int idInstalacion, String fecha, double horaInicio ){


		List<ReservaDTO> reservas = model.getListaReservas(Util.dateToIsoString(Util.isoStringToDate(fecha)));
		boolean reserved = false;

		for(int i = 0; i<reservas.size(); i++){


			if(     Util.isoStringToDate(reservas.get(i).getFecha()).equals(Util.isoStringToDate(fecha)) && 
					reservas.get(i).getIdInstalacion() == idInstalacion &&
					reservas.get(i).getHoraInicio() == (float) horaInicio
					){

				reserved = true;
			}


		}

		return reserved;

	}


	private static int getRandomNumberInRange(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}


	@SuppressWarnings("null")
	public void generarReserva() {


		// Valida Campos
		if(!camposLlenos()){

			JOptionPane.showMessageDialog(
					null, 
					"Hay algún error con los datos introducidos.", 
					"Error",
					JOptionPane.WARNING_MESSAGE);

		} //end no Campos Llenos situation

		else{

			// ESTÁN TODOS LOS CAMPOS LLENOS

			//Toma los datos de la pantalla
			@SuppressWarnings("unused")
			int diaIni, mesIni, anoIni, diaFin, mesFin, anoFin;
			String fechaIni,fechaFin;
			int idActividad, idInstalacion ;

			idActividad = this.view.getTableActividades().getSelectedRow() +1 ;
			idInstalacion = model.getInstalacion(idActividad).get(0).getIdInstalacion();

			diaIni = this.view.getCbDiaIni().getSelectedIndex() +1;
			diaFin = this.view.getCbDiaFin().getSelectedIndex()+1;
			mesIni = this.view.getCbMesIni().getSelectedIndex()+1;
			mesFin = this.view.getCbMesFin().getSelectedIndex()+1;
			anoIni = Integer.parseInt(this.view.getCbAnoIni().getModel().getElementAt(this.view.getCbAnoIni().getSelectedIndex()).toString());
			anoFin = Integer.parseInt(this.view.getCbAnoIni().getModel().getElementAt(this.view.getCbAnoFin().getSelectedIndex()).toString());

			fechaIni = Integer.toString(anoIni) + "-" + mesIni + "-" + diaIni;
			fechaFin = Integer.toString(anoFin) + "-" + mesFin + "-" + diaFin;

			Date fechaIniDate = Util.isoStringToDate(fechaIni);
			Date fechaFinDate = Util.isoStringToDate(fechaFin);


			List<Integer> dias = new ArrayList<Integer>();
			
			
			// Insertar los índices de días seleccionados 
			/*
			 * Lunes = 2 
			 * Martes = 3 
			 *   .
			 *   .
			 *   .
			 *  Domingo = 1
			 */
			if(!this.view.getTextFieldIniL().getText().isBlank()) {

				dias.add(2);

			}

			if(!this.view.getTextFieldIniM().getText().isBlank()) {

				dias.add(3);

			}

			if(!this.view.getTextFieldIniX().getText().isBlank()) {
				dias.add(4);

			}

			if(!this.view.getTextFieldIniJ().getText().isBlank()) {

				dias.add(5);
			}

			if(!this.view.getTextFieldIniV().getText().isBlank()) {

				dias.add(6);
			}

			if(!this.view.getTextFieldIniS().getText().isBlank()) {

				dias.add(7);
			}

			if(!this.view.getTextFieldIniD().getText().isBlank()) {
				dias.add(1);

			}

			List<Double> horasIni = new ArrayList<Double>();
			List<Double> horasFin = new ArrayList<Double>();
	
			
			//Insertar las horas indicadas en la estructura de datos
			for(int i=0 ; i<dias.size() ; i++) {

				switch(dias.get(i)) {
				case 2:
					horasIni.add(i, Double.parseDouble(this.view.getTextFieldIniL().getText()));
					horasFin.add(i, Double.parseDouble(this.view.getTextFieldFinL().getText()));
					break;
					

				case 3:
					horasIni.add(i, Double.parseDouble(this.view.getTextFieldIniM().getText()));
					horasFin.add(i, Double.parseDouble(this.view.getTextFieldFinM().getText()));
					break;
					


				case 4:
					horasIni.add(i, Double.parseDouble(this.view.getTextFieldIniX().getText()));
					horasFin.add(i, Double.parseDouble(this.view.getTextFieldFinX().getText()));
					break;
					

				case 5:
					horasIni.add(i, Double.parseDouble(this.view.getTextFieldIniJ().getText()));
					horasFin.add(i, Double.parseDouble(this.view.getTextFieldFinJ().getText()));
					break;
					


				case 6:
					horasIni.add(i, Double.parseDouble(this.view.getTextFieldIniV().getText()));
					horasFin.add(i, Double.parseDouble(this.view.getTextFieldFinV().getText()));
					break;
					


				case 7:
					horasIni.add(i, Double.parseDouble(this.view.getTextFieldIniS().getText()));
					horasFin.add(i, Double.parseDouble(this.view.getTextFieldFinS().getText()));
					break;
					


				case 1:
					horasIni.add(i, Double.parseDouble(this.view.getTextFieldIniD().getText()));
					horasFin.add(i, Double.parseDouble(this.view.getTextFieldFinD().getText()));
					break;
					


				default:
					System.err.println("Default en Switch (RealizarReservasController:340)");
					break;

				}




			}

			Calendar cal = Calendar.getInstance();
			for( Date f = fechaIniDate   ; f.before(fechaFinDate) || f.equals(fechaFinDate)   ; f.setTime(f.getTime() + (1000 * 60 * 60 * 24))) {
				cal.setTime(f);
				for(int i = 0 ; i < dias.size() ; i++) {
					if(cal.get(Calendar.DAY_OF_WEEK) == dias.get(i)) {

						if(!alreadyReserved(idInstalacion , Util.dateToIsoString(f) , horasIni.get(i))) {

							model.crearReserva(getRandomNumberInRange(1000,10000) , Util.dateToIsoString(f) , 
									horasIni.get(i) , horasFin.get(i) , idInstalacion , idActividad, 0 ,1 );

						}
						else {
							JOptionPane.showMessageDialog(
									null, 
									"Instalación " + Integer.toString(idInstalacion) + " ya reservada!\n" + 
											"Fecha: " + Util.dateToIsoString(f) + "\n" + 
											"Hora: " + Double.toString(horasIni.get(i)) ,										
											"Error",
											JOptionPane.ERROR_MESSAGE ); 	

						}



					}
				} // end for - Recorre todas las filas de horarios que tenga la actividad

			} //end for - Recorre el tiempo dia a dia

			JOptionPane.showMessageDialog(
					null, 
					"Reservas creada con éxito! ", 
					"Éxito",
					JOptionPane.INFORMATION_MESSAGE ); 	


		}

	}



}










