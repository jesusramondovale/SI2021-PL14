package giis.demo.Proyecto.Controller;

import giis.demo.Proyecto.Model.CancelarReservasSociosModel;
import giis.demo.Proyecto.View.CancelarReservasSociosView;
import giis.demo.Proyecto.View.LoginView;
import giis.demo.util.SwingUtil;

public class CancelarReservasSociosController {

	private CancelarReservasSociosModel model;
	private CancelarReservasSociosView view;
	private LoginView login;
	private String idSocio;

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
				
				//Coge el DNI del Socio y le muestra su nombre en la pantalla
				this.view.setTextFieldNombre(this.model.getSocio(idSocio));
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
	
	private void actualizarInstalaciones() {


		List<ReservaDTO> list= null;


		list = model.getInstalaciones(Integer.parseInt(idSocio));

		if(list.isEmpty()) {
			SwingUtil.showMessage("No existen reservas en la BD todavía!", "Error", 0);
		}
		else {
			//Generamos el modelo de tabla y lo cargamos con los datos de la BD
			TableModel tmodel=SwingUtil.getTableModelFromPojos(list, new String[] { 
					"idInstalacion", "fecha", "precioHora", "estado" },
					new String[] { 
							"Instalación"  , "Fecha" , "Precio (€)" , "Estado" });


			// Asigna a la tabla de la vista el modelo generado
			view.getTableInstalaciones().setModel(tmodel);
			SwingUtil.autoAdjustColumns(view.getTableInstalaciones());


		}

	}

}
