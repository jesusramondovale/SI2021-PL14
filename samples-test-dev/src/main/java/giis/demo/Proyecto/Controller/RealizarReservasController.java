package giis.demo.Proyecto.Controller;

import javax.swing.JOptionPane;

import giis.demo.Proyecto.Model.RealizarReservasModel;
import giis.demo.Proyecto.View.RealizarReservasView;
import giis.demo.util.SwingUtil;

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

	public void initController(){
		
		this.view.getFrmRealizarReserva().setVisible(true);
		this.view.getBtnCrearReserva().addActionListener(e -> SwingUtil.exceptionWrapper(() -> generarReserva()));

		
		
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
	

	
	public void generarReserva() {
		
		if(!camposLlenos()){
			
			JOptionPane.showMessageDialog(
				    null, 
				    "Rellene todos los campos primero.", 
				    "Error",
				    JOptionPane.WARNING_MESSAGE);
			
		}
		
		else{
			
		//Toma los datos de la pantalla
		@SuppressWarnings("unused")
		int instalacion, deporte, diaIni, mesIni, anoIni, diaFin, mesFin, anoFin;
		String fecha;
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
		
		fecha = Integer.toString(anoIni) + "-" + mesIni + "-" + diaIni;
		
		
		hIni1 = Float.parseFloat(this.view.getTextFieldHorasIni().getText());
		hIni2 = Float.parseFloat(this.view.getTextFieldMinIni().getText());
		hFin1 = Float.parseFloat(this.view.getTextFieldHorasFin().getText());
		hFin2 = Float.parseFloat(this.view.getTextFieldMinFin().getText());

		horaInicio = (hIni1 % 24) + (hIni2 / 100.00);
		horaFinal = (hFin1 % 24) + (hFin2 / 100.00);

		idReserva = Integer.parseInt(this.view.getTextFieldActividad().getText());
		idSocio = Integer.parseInt(this.view.getTextFieldSocio().getText());

		//Delega en el modelo
			
		model.crearReserva(idReserva, fecha, horaInicio, horaFinal, instalacion, deporte, idSocio, 1);
								
		}

	}
	
	
	
	
}
