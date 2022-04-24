package giis.demo.Proyecto.Controller;

import java.util.Date;
import java.util.List;

import giis.demo.Proyecto.DTO.ReservaDTO;
import giis.demo.Proyecto.Model.InformeSociosModel;
import giis.demo.Proyecto.View.InformeSociosView;
import giis.demo.util.SwingUtil;

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



	private void dispatcher() {

		if (this.view.getTextFieldSocio().getText().isBlank() && this.view.getChckbxHistorico().isSelected())
		{
			informeHistoricoSocios();
		}
		else if (this.view.getTextFieldSocio().getText().isBlank()) {

			informeFechasSocios(this.view.getDateChooserInicio().getDate(),this.view.getDateChooserFinal().getDate());

		}
		else if ( !(this.view.getTextFieldSocio().getText().isBlank())   &&   this.view.getChckbxHistorico().isSelected()    ){

			informeHistoricoSocio( Integer.parseInt(this.view.getTextFieldSocio().getText())); 
		}

		else if ( !(this.view.getTextFieldSocio().getText().isBlank())   &&   !(this.view.getChckbxHistorico().isSelected())    ){

			informeFechasSocio(Integer.parseInt(this.view.getTextFieldSocio().getText()) , this.view.getDateChooserInicio().getDate(),this.view.getDateChooserFinal().getDate());

		}
		else {
			SwingUtil.showMessage("Error en dispatcher()", "Error" , 0);
		}



	}


	/*
	 * Genera un informe HISTÓRICO en TXT 
	 * sobre todos los Socios existentes en la 
	 * BD del centro
	 */
	private void informeHistoricoSocios() {

		// Si no hay nada seleccionado, no se puede hacer el informe
		if(  !(this.view.getCheckBoxActividades().isSelected()   )     
				&&    
				!(this.view.getCheckBoxReservas().isSelected()  )  ) {

			SwingUtil.showMessage("Error! Seleccione al menos una opción de los CheckBox (Reservas o Actividades)", "Vaya...", 0);
		}

		//Hay al menos una opción seleccionada
		else {



			//Opción A + B
			if(this.view.getCheckBoxActividades().isSelected() && this.view.getCheckBoxReservas().isSelected()) {

				List<ReservaDTO> listReserv = model.getReservas();
				List<ReservaDTO> listActiv = model.getActividades();

				System.out.println("-------- INFORME HISTÓRICO  (RESERVAS+ACTIVIDADES) (TODOS LOS SOCIOS)---------");
				System.out.println("");

			}//end Opción A+B








			// Opción A
			else if(this.view.getCheckBoxReservas().isSelected()) {


				List<ReservaDTO> listReserv = model.getReservas();

				System.out.println("-------- INFORME HISTÓRICO  (RESERVAS) (TODOS LOS SOCIOS)---------");
				System.out.println("");

			}//end Opción A








			// Opción B
			else if (this.view.getCheckBoxActividades().isSelected()) {

				List<ReservaDTO> listActiv = model.getActividades();

				System.out.println("-------- INFORME HISTÓRICO  (ACTIVIDADES) (TODOS LOS SOCIOS)---------");
				System.out.println("");

			}//end Opción B




		}// end else (al menos una opción seleccionada)





	}





	/*
	 * Genera un informe  en TXT 
	 * sobre el socio indicado como parámetro,
	 * pero únicamente sobre sus actividades
	 * realizadas entre las fechas indicadas
	 */
	private void informeFechasSocio(int idSocio, Date ini, Date fin) {


	}




	/*
	 * Genera un informe HISTÓRICO en TXT 
	 * sobre el Socio indicado como parámetro
	 */
	private void informeHistoricoSocio(int idSocio) {


	}




	/*
	 * Genera un informe  en TXT 
	 * sobre todos los Socios existentes en 
	 * la BD del centro, pero únicamente sobre sus actividades
	 * realizadas entre las fechas indicadas como parámetro
	 */
	private void informeFechasSocios(Date ini, Date fin) {



	}



}
