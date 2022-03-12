package giis.demo.Proyecto.Controller;

import java.text.ParseException;
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
			
			SwingUtil.showMessage("No hay reservas para la fecha inicial indicada!", "Error", 0);
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

			
			int [] dias = this.view.getTableSemanal().getSelectedRows();
			
			int [] diasArreglo = dias; 


			for(int i = 0 ; i < dias.length ; i++){

				if(dias[i] >= 2 && dias[i] <= 5) {
					diasArreglo[i] = dias[i] + 2;
				}

			}


			double [] horasIni = {0,0,0,0,0,0,0};
			double [] horasFin = {0,0,0,0,0,0,0};
			
			for(int i=0 ; i<this.view.getTableSemanal().getSelectedRowCount() ; i++) {

				switch(diasArreglo[i]) {
				case 2:
					horasIni[i] = Integer.parseInt(this.view.getTextFieldIniL().getText());
					horasFin[i] = Integer.parseInt(this.view.getTextFieldFinL().getText());

				case 3:
					horasIni[i] = Integer.parseInt(this.view.getTextFieldIniM().getText());
					horasFin[i] = Integer.parseInt(this.view.getTextFieldFinM().getText());


				case 4:
					horasIni[i] = Integer.parseInt(this.view.getTextFieldIniX().getText());
					horasFin[i] = Integer.parseInt(this.view.getTextFieldFinX().getText());


				case 5:
					horasIni[i] = Integer.parseInt(this.view.getTextFieldIniJ().getText());
					horasFin[i] = Integer.parseInt(this.view.getTextFieldFinJ().getText());


				case 6:
					horasIni[i] = Integer.parseInt(this.view.getTextFieldIniV().getText());
					horasFin[i] = Integer.parseInt(this.view.getTextFieldFinV().getText());


				case 7:
					horasIni[i] = Integer.parseInt(this.view.getTextFieldIniS().getText());
					horasFin[i] = Integer.parseInt(this.view.getTextFieldFinS().getText());


				case 1:
					horasIni[i] = Integer.parseInt(this.view.getTextFieldIniD().getText());
					horasFin[i] = Integer.parseInt(this.view.getTextFieldFinD().getText());


				default:
					System.err.println("Default en Switch (RealizarReservasController:340)");
				}




			}

			Calendar cal = Calendar.getInstance();
			for( Date f = fechaIniDate   ; f.before(fechaFinDate) || f.equals(fechaFinDate)   ; f.setTime(f.getTime() + (1000 * 60 * 60 * 24))) {
				cal.setTime(f);
				for(int i = 0 ; i < diasArreglo.length ; i++) {
					if(cal.get(Calendar.DAY_OF_WEEK) == diasArreglo[i]) {

						if(!alreadyReserved(idInstalacion , Util.dateToIsoString(f) , horasIni[i])) {
							
							model.crearReserva(getRandomNumberInRange(1000,10000) , Util.dateToIsoString(f) , 
									     horasIni[i] , horasFin[i] , idInstalacion , idActividad, 0 ,1 );

						}
						else {
							JOptionPane.showMessageDialog(
									null, 
									"Instalación " + Integer.toString(idInstalacion) + " ya reservada!\n" + 
											"Fecha: " + Util.dateToIsoString(f) + "\n" + 
											"Hora: " + Double.toString(horasIni[i]) ,										
											"Error",
											JOptionPane.ERROR_MESSAGE ); 	

						}



					}
				} // end for - Recorre todas las filas de horarios que tenga la actividad
				
			} //end for - Recorre el tiempo dia a dia

			JOptionPane.showMessageDialog(
					null, 
					"Reserva creada con éxito! ", 
					"Éxito",
					JOptionPane.INFORMATION_MESSAGE ); 	


		}

	}



}










