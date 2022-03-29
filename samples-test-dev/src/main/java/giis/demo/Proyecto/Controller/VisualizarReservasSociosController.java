package giis.demo.Proyecto.Controller;

import java.text.ParseException;
import java.util.List;

import javax.swing.table.TableModel;

import giis.demo.Proyecto.DTO.reservasDisplayDTO;
import giis.demo.Proyecto.Model.VisualizarReservasSociosModel;
import giis.demo.Proyecto.View.LoginView;
import giis.demo.Proyecto.View.VisualizarReservasSociosView;
import giis.demo.util.SwingUtil;

public class VisualizarReservasSociosController {

	// Declaramos una ventana de tipo LoginView
	private LoginView login;
	private VisualizarReservasSociosView view;
	private VisualizarReservasSociosModel model;
	private String idSocio; 


	//En el constructor, necesitaremos pasar como argumento una ventana de Login
	public VisualizarReservasSociosController(VisualizarReservasSociosModel model, VisualizarReservasSociosView view, LoginView login) {

		this.login = login;
		this.view = view;
		this.model = model;
		this.initView();
	}

	// Pone como invisible la ventana de la H.U , y hace visible solamente la ventana de login
	public void initView() {
		view.getFrmVisualizarReservasSocios().setVisible(false); 
		this.login.getFrame().setVisible(true);

	}


	public void initController() throws ParseException{


		//Aquí se asigna la función del método login() al botón de login del LoginView
		this.login.getBtnLogear().addActionListener(e -> SwingUtil.exceptionWrapper(() -> login()));


		//this.view.getBtnActualizarActividades().addActionListener(e -> SwingUtil.exceptionWrapper(() -> actualizarActividades()));
		//this.view.getBtnActualizarInstalaciones().addActionListener(e -> SwingUtil.exceptionWrapper(() -> actualizarInstalaciones()));

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
				this.view.getFrmVisualizarReservasSocios().setVisible(true);
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
	
	
	@SuppressWarnings("unused")
	private void getReservas() {
		List<reservasDisplayDTO> list= null;

		//Coge el DNI del Socio y le muestra su nombre en la pantalla
		String nombrecompleto = new String();
		
		nombrecompleto = nombrecompleto.concat(this.model.getSocio(idSocio).get(0).getNombre());
		nombrecompleto = nombrecompleto.concat(" ");
		nombrecompleto = nombrecompleto.concat(this.model.getSocio(idSocio).get(0).getApellido1());
		nombrecompleto = nombrecompleto.concat(" ");
		nombrecompleto = nombrecompleto.concat(this.model.getSocio(idSocio).get(0).getApellido2());

		this.view.getTextField_Nombre_Completo().setText(nombrecompleto);
		list = model.getReservas(idSocio);
		if(list.isEmpty()) {
			SwingUtil.showMessage("No existen reservas en la BD todavía!", "Error", 0);
		}
		else {
			//Generamos el modelo de tabla y lo cargamos con los datos de la BD
			TableModel tmodel=SwingUtil.getTableModelFromPojos(list, new String[] { 
					"idReserva" , "nombre" , "fecha" , "horaInicio" , "horaFin" , "estado" },
					new String[] { 
							"Id Reserva"  , "Instalacion" , "Fecha" , "Hora Inicio" ,"HoraFin", "Pagado" });


			// Asigna a la tabla de la vista el modelo generado
			view.getTable().setModel(tmodel);
			SwingUtil.autoAdjustColumns(view.getTable());

		}

	}
	
	
	
	
}
