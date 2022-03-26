package giis.demo.Proyecto.Controller;

import java.text.ParseException;
import java.util.List;

import javax.swing.table.TableModel;

import giis.demo.Proyecto.DTO.ActividadDTO;
import giis.demo.Proyecto.DTO.ReservaDTO;
import giis.demo.Proyecto.Model.EstadoCuentasModel;
import giis.demo.Proyecto.View.EstadoCuentasView;
import giis.demo.Proyecto.View.LoginView;
import giis.demo.util.SwingUtil;

public class EstadoCuentasController {

	// Declaramos una ventana de tipo LoginView
	private LoginView login;
	private EstadoCuentasView view;
	private EstadoCuentasModel model;
	private String idSocio; 


	//En el constructor, necesitaremos pasar como argumento una ventana de Login
	public EstadoCuentasController(LoginView login , EstadoCuentasView view, EstadoCuentasModel model) {

		this.login = login;
		this.view = view;
		this.model = model;
		this.initView();
	}

	// Pone como invisible la ventana de la H.U , y hace visible solamente la ventana de login
	public void initView() {
		view.getFrmEstadoDeLas().setVisible(false); 
		this.login.getFrame().setVisible(true);

	}




	public void initController() throws ParseException{


		//Aquí se asigna la función del método login() al botón de login del LoginView
		this.login.getBtnLogear().addActionListener(e -> SwingUtil.exceptionWrapper(() -> login()));


		this.view.getBtnActualizarActividades().addActionListener(e -> SwingUtil.exceptionWrapper(() -> actualizarActividades()));
		this.view.getBtnActualizarInstalaciones().addActionListener(e -> SwingUtil.exceptionWrapper(() -> actualizarInstalaciones()));

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
				this.view.getFrmEstadoDeLas().setVisible(true);
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

	private void actualizarActividades() {


		List<ActividadDTO> list= null;


		list = model.getActividades(Integer.parseInt(idSocio));

		if(list.isEmpty()) {
			SwingUtil.showMessage("No existen actividades en la BD todavía!", "Error", 0);
		}
		else {
			//Generamos el modelo de tabla y lo cargamos con los datos de la BD
			TableModel tmodel=SwingUtil.getTableModelFromPojos(list, new String[] { 
					"nombre", "fechaInicio", "precioSocio", "estado" },
					new String[] { 
							"Actividad"  , "Fecha" , "Precio (€)" , "Estado" });


			// Asigna a la tabla de la vista el modelo generado
			view.getTableActividades().setModel(tmodel);
			SwingUtil.autoAdjustColumns(view.getTableActividades());


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
