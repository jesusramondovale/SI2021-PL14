package giis.demo.Proyecto.Controller;

import java.util.List;

import javax.swing.table.TableModel;

import giis.demo.Proyecto.DTO.ReservaDTO;
import giis.demo.Proyecto.Model.CancelarReservasModel;
import giis.demo.Proyecto.View.CancelarReservasView;
import giis.demo.util.SwingUtil;

public class CancelarReservasController {

	private CancelarReservasModel model;
	private CancelarReservasView view;



	public CancelarReservasController(CancelarReservasModel model, CancelarReservasView view) {
		this.model = model;
		this.view = view;

		this.initView();

	}



	private void initView() {

		this.view.getFrmCancelarReserva().setVisible(true); 

	} 

	public void initController() {	

		this.initView();
		view.getFrmCancelarReserva().setVisible(true);
		System.out.println("OK1");

		view.getBtnActualizar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> actualizarReservas()));
		view.getBtnBorrar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> borrarReservas()));

	}



	private void borrarReservas() {

		this.view.getTextFieldSocio().setText("");

		List<ReservaDTO> reservas = null; 

		TableModel tmodel=SwingUtil.getTableModelFromPojos(reservas, new String[] { 
				"idSocio" , "nombre" , "apellido1" , "apellido2" , "idInstalacion" , "fecha" , "horaInicio"  },
				new String[] { 

						"#ID", "Nombre" ,"Apellido 1", "Apellido 2", "Instalación", "Fecha" , "Hora (Inicio)" });


		// Asigna a la tabla VACÍA de la vista el modelo generado VACIO
		view.getTableReservas().setModel(tmodel);
		SwingUtil.autoAdjustColumns(view.getTableReservas());



	}



	private void actualizarReservas() {

		//Obtiene el ID de socio introducido 
		int idSocio = 0;
		if(this.view.getTextFieldSocio().getText().isBlank()) {

			SwingUtil.showMessage("¡Introduzca un ID de socio primero!", "Error", 0);

		}
		else {

			try {
				idSocio = Integer.parseInt(this.view.getTextFieldSocio().getText());
			}
			catch (Exception e) {

				SwingUtil.showMessage("idSocio no parseable", "Error", 0);
			}

			//Delega en el modelo 

			// Comprueba si el socio introducido existe en la BD 

			if(idSocio != 0 && model.isSocio(idSocio)) {

				List<ReservaDTO> reservas = model.getReservas(idSocio);

				if (reservas.isEmpty()) {

					SwingUtil.showMessage("El socio no tiene reservas en vigor", "Vaya!", 1);

				} // end el socio no tiene reservas

				else { 

					TableModel tmodel=SwingUtil.getTableModelFromPojos(reservas, new String[] { 
							"idSocio" , "nombre" , "apellido1" , "apellido2" , "idInstalacion" , "fecha" , "horaInicio"  },
							new String[] { 

									"#ID", "Nombre" ,"Apellido 1", "Apellido 2", "Instalación", "Fecha" , "Hora (Inicio)" });

					view.getTableReservas().setModel(tmodel);
					SwingUtil.autoAdjustColumns(view.getTableReservas());
				}



			} // end el socio existe en la BD

			else {

				SwingUtil.showMessage("El Socio introducido no existe en al BD", "Error", 0);

			}


		}



	}



}
