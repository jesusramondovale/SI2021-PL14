package giis.demo.Proyecto.Controller;

import giis.demo.Proyecto.Model.CancelarReservasSociosModel;
import giis.demo.Proyecto.View.CancelarReservasSociosView;
import giis.demo.Proyecto.View.LoginView;
import giis.demo.util.SwingUtil;

public class CancelarReservasSociosController {

	private CancelarReservasSociosModel model;
	private CancelarReservasSociosView view;
	private LoginView login;

	public CancelarReservasSociosController(CancelarReservasSociosModel model, CancelarReservasSociosView view) {
		this.login = login;
		this.model = model;
		this.view = view;
		this.initView();
	}

	public void initView() {
		view.getframe().setVisible(false); 
		this.login.getFrame().setVisible(true);
	}

	public void initController() {
		// TODO Auto-generated method stub

	}


	// Código que se ejecuta al pulsar en el botón Login en LoginView

	private void login() {

		//Extrae el Socio introducido en la vista del login
		String idSocio = this.login.getTxtId().getText();

		try {
			//Delega en el model para saber si ese socio existe
			if (model.isSocio(Integer.parseInt(idSocio))) {

				//Si el socio existe, hace invisible la pantalla de login y hace visible la pantalla de estado de contabilidad
				this.idSocio = idSocio;
				this.login.getFrame().setVisible(false);
				this.view.getframe().setVisible(true);
				SwingUtil.showMessage("Bienvenido! Socio #" + idSocio, "Saludos de nuevo", 2);

			}
			else {

				//Si no existe el socio ...
				SwingUtil.showMessage("El Socio #" + idSocio + " no existe en la BD!", "Vaya...", 0);

			}
		}
		catch (NumberFormatException e){

			SwingUtil.showMessage("Error! Introduzca un #ID de Socio válido (numérico)", "Vaya...", 0);


		}


	}

}
