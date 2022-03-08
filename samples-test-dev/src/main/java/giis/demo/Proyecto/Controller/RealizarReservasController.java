package giis.demo.Proyecto.Controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import giis.demo.Proyecto.DTO.*;
import giis.demo.Proyecto.Model.*;
import giis.demo.Proyecto.View.*;
import giis.demo.util.SwingUtil;
import giis.demo.util.Util;

public class RealizarReservasController {

	private RealizarReservasView view;
	private RealizaReservaModel model;


	public RealizarReservasController(RealizarReservasView view, RealizaReservaModel model) {

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
		this.view.getBtnActualizar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> actualizarTablas()));



	}


	private void actualizarTablas() {


		int diaIni, mesIni, anoIni;
		String fecha;
		diaIni = this.view.getCbDiaIni().getSelectedIndex() +1;
		mesIni = this.view.getCbMesIni().getSelectedIndex()+1;
		anoIni = Integer.parseInt(this.view.getCbAnoIni().getModel().getElementAt(this.view.getCbAnoIni().getSelectedIndex()).toString());

		fecha = Integer.toString(anoIni) + "-" + mesIni + "-" + diaIni;


		List<ReservaDTO> listReservas= null;

		listReservas = model.getListaReservas(Util.dateToIsoString(Util.isoStringToDate(fecha)));



		//Generamos el modelo de tabla y lo cargamos con los datos de la BD
		TableModel tmodel=SwingUtil.getTableModelFromPojos(listReservas, new String[] { 
				"fecha"  , "horaInicio" , "horaFin" },
				new String[] { 
						"Fecha"  , "Hora de Inicio" , "Hora de Fin" });


		// Asigna a la tabla de la vista el modelo generado
		view.getTableAnteriores().setModel(tmodel);
		SwingUtil.autoAdjustColumns(view.getTableAnteriores());


	}


	private void borrar() {

		this.view.getCbAnoFin().setSelectedIndex(0);
		this.view.getCbDiaFin().setSelectedIndex(0);
		this.view.getCbMesFin().setSelectedIndex(0);
		this.view.getCbAnoIni().setSelectedIndex(0);
		this.view.getCbMesIni().setSelectedIndex(0);
		this.view.getCbDiaIni().setSelectedIndex(0);
		this.view.getComboBoxInstalacion().setSelectedIndex(0);
		this.view.getComboBoxActividad().setSelectedIndex(0);


		this.view.getTextFieldHorasIni().setText("");
		this.view.getTextFieldHorasFin().setText("");
		this.view.getTextFieldMinIni().setText("");
		this.view.getTextFieldMinFin().setText("");

		this.view.getTextFieldActividad().setText("Nº");
		this.view.getTextFieldSocio().setText("# ID de Socio");

		DefaultTableModel dm = (DefaultTableModel) this.view.getTableAnteriores().getModel();
		int rowCount = dm.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			dm.removeRow(i);
		}

	}


	public boolean camposLlenos(){

		if((this.view.getTextFieldActividad().getText().isEmpty())

				||
				(this.view.getTextFieldActividad().getText().equals("Nº"))	

				||

				(this.view.getTextFieldSocio().getText().isEmpty())
				||

				(this.view.getTextFieldSocio().getText().contains("#"))

				||

				(this.view.getTextFieldHorasIni().getText().isEmpty())	

				||

				(this.view.getTextFieldHorasFin().getText().isEmpty())	

				||

				(this.view.getTextFieldMinIni().getText().isEmpty())	

				||

				(this.view.getTextFieldMinFin().getText().isEmpty())	

				){

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


	public void generarReserva() {

		// Valida Campos
		if(!camposLlenos()){

			JOptionPane.showMessageDialog(
					null, 
					"Rellene todos los campos primero.", 
					"Error",
					JOptionPane.WARNING_MESSAGE);

		} //end no Campos Llenos situation

		else{

			// ESTÁN TODOS LOS CAMPOS LLENOS

			//Toma los datos de la pantalla
			@SuppressWarnings("unused")
			int instalacion, deporte, diaIni, mesIni, anoIni, diaFin, mesFin, anoFin;
			String fechaIni,fechaFin;
			float hIni1,hIni2,hFin1,hFin2;
			double horaInicio;
			double horaFinal;
			int idReserva;
			int idSocio;

			instalacion = this.view.getComboBoxInstalacion().getSelectedIndex() +1;
			deporte = this.view.getComboBoxActividad().getSelectedIndex() +1 ;
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

			if(fechaIniDate.before(fechaFinDate) || fechaIniDate.equals(fechaFinDate)) {


				//LAS FECHAS ESTÁN BIEN 
				//System.out.println("fechaIniDate.before(fechaFinDate) = true");


				hIni1 = Float.parseFloat(this.view.getTextFieldHorasIni().getText());
				hIni2 = Float.parseFloat(this.view.getTextFieldMinIni().getText());
				hFin1 = Float.parseFloat(this.view.getTextFieldHorasFin().getText());
				hFin2 = Float.parseFloat(this.view.getTextFieldMinFin().getText());

				horaInicio = (hIni1 % 24) + (hIni2 / 100.00);
				horaFinal = (hFin1 % 24) + (hFin2 / 100.00);

				idReserva = Integer.parseInt(this.view.getTextFieldActividad().getText());
				idSocio = Integer.parseInt(this.view.getTextFieldSocio().getText());

				//Delega en el modelo

				if(model.isSocio(idSocio)){

					//Si el socio existe
					if(!alreadyReserved(instalacion, fechaIni, horaInicio)){

						System.out.println("alreadyReserved = false");
						//SI no está reservado
						model.crearReserva(idReserva, 
								Util.dateToIsoString(Util.isoStringToDate(fechaIni)), 
								horaInicio, horaFinal, instalacion, deporte, idSocio, 1);

					} //end no Reservado situation

					else{ SwingUtil.showMessage("La instalación ya está reservada!", "Error", 0);
					System.out.println("alreadyReserved = false");
					}

				} //end socio existe situation 

				else { SwingUtil.showMessage("El socio no existe en la BBDD", "Error", 0);  }


			}//end fechas Válidas Situation

			else { SwingUtil.showMessage("Revise las fechas introducidas", "Error", 2); }


		} //end camposLlenos situation


	}//end generarReserva
}







