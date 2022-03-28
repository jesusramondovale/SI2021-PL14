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

import giis.demo.Proyecto.DTO.*;
import giis.demo.Proyecto.Model.*;
import giis.demo.Proyecto.View.*;
import giis.demo.util.SwingUtil;
import giis.demo.util.Util;

public class AutoReservaController {

	private AutoReservaView view;
	private AutoReservaModel model;


	public AutoReservaController(AutoReservaView view, AutoReservaModel model) {

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



	}


	private void actualizarTabla() {





		List<ActividadDTO> list= null;

		list = model.getListaActividades();

		if(list.isEmpty()) {
			SwingUtil.showMessage("No existen actividades en la BD todavía!", "Error", 0);
		}
		else {
			//Generamos el modelo de tabla y lo cargamos con los datos de la BD
			TableModel tmodel=SwingUtil.getTableModelFromPojos(list, new String[] { 
					"nombre", "tipo", "fechaInicio", "fechaFin" },
					new String[] { 
							"Actividad"  , "Tipo" , "Fecha (ini.)" , "Fecha (fin)" });


			// Asigna a la tabla de la vista el modelo generado
			view.getTableAnteriores().setModel(tmodel);
			SwingUtil.autoAdjustColumns(view.getTableAnteriores());



		}

	}


	private void borrar() {


		DefaultTableModel dm = (DefaultTableModel) this.view.getTableAnteriores().getModel();
		int rowCount = dm.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			dm.removeRow(i);
		}

	}


	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}




	@SuppressWarnings("deprecation")
	public void generarReserva() {


		int [] actividadSelecc = this.view.getTableAnteriores().getSelectedRows();
		if (actividadSelecc.length == 0 || actividadSelecc.length > 1)	{

			SwingUtil.showMessage("Seleccione una actividad", "Atención!", 0);
		}


		else {

			boolean ok = true;
			int idActividad = actividadSelecc[0] + 1;

			List <ActividadHorariosDTO> actividadHorariosDTO = model.getActividad(idActividad);


			String fechaInicio = actividadHorariosDTO.get(0).getFechaInicio();
			String fechaFinal = actividadHorariosDTO.get(0).getFechaFin();

			Date fechaIni = Util.isoStringToDate(fechaInicio);
			Date fechaFin = Util.isoStringToDate(fechaFinal);

			int idInstalacion = actividadHorariosDTO.get(0).getIdInstalacion();

			List<String> dias = new ArrayList();
			List<Integer> horasIni = new ArrayList();
			List<Integer> horasFin = new ArrayList();

			for  (ActividadHorariosDTO act : actividadHorariosDTO){

				dias.add(act.getDia());
				horasIni.add(act.getHoraInicio());
				horasFin.add(act.getHoraFin());


			}

			List<Integer> diasINT = new ArrayList();
			for(String d : dias) {

				switch(d) {
				case "L":
					diasINT.add(2);
					break;
				case "M":
					diasINT.add(3);
					break;

				case "X":
					diasINT.add(4);
					break;

				case "J":
					diasINT.add(5);
					break;

				case "V":
					diasINT.add(6);
					break;

				case "S":
					diasINT.add(7);
					break;

				case "D":
					diasINT.add(1);
					break;


				default:
					System.err.println("ERROR: default case en Switch (RealizarReservasController: 159)");
					break;

				}
			}

			Calendar cal = Calendar.getInstance();
			for( Date f = fechaIni   ; f.before(fechaFin) || f.equals(fechaFin)   ; f.setTime(f.getTime() + (1000 * 60 * 60 * 24))) {

				cal.setTime(f);

				for(int i = 0 ; i < diasINT.size() ; i++) {

					if(cal.get(Calendar.DAY_OF_WEEK) == diasINT.get(i)) {

						if(!alreadyReserved(idInstalacion , Util.dateToIsoString(f) , horasIni.get(i))) {


							model.crearReserva(getRandomNumberInRange(100000,1000000) , Util.dateToIsoString(f) , horasIni.get(i) , horasFin.get(i) , idInstalacion , idActividad );


						}
						else {
							SwingUtil.showMessage("La instalación #"+ idInstalacion +" ya se encuentra reservada (" +f.getDate()+"/"+(f.getMonth()+1)+"/"+(1900+f.getYear())+ ") - (" +horasIni.get(i)+"h00)", "Vaya..", 1);
							ok = false;
						}


					}

				} // end for - Recorre todas las filas de horarios que tenga la actividad

			} //end for - Recorre el tiempo dia a dia

			if(ok) {
				JOptionPane.showMessageDialog(
						null, 
						"Reserva creada con éxito! ", 
						"Éxito",
						JOptionPane.INFORMATION_MESSAGE ); 	
			}
			else {
				JOptionPane.showMessageDialog(
						null, 
						"Finalizado! "
						+ "Algunas Reservas no fueron creadas", 
						"Aviso",
						JOptionPane.INFORMATION_MESSAGE ); 	
			}

		}


	}


	/*
	 * Comprueba si una instalación se encuentra reservada para una fecha y horas concretas
	 * Retorna true/false
	 */
	public boolean alreadyReserved(int idInstalacion, String fecha, int horaInicio ){


		List<ReservaDTO> reservas = model.getListaReservas(Util.dateToIsoString(Util.isoStringToDate(fecha)) , 
				idInstalacion ,  horaInicio  );
		if(reservas.size() == 0) { return false ;}
		else return true;


	}

}







