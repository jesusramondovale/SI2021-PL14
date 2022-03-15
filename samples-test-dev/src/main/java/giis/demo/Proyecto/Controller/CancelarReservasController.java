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

		view.getBtnActualizar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> actualizarReservas()));
		view.getBtnBorrar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> borrarReservas()));
		view.getBtnReservar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> reservar()));



	}



	private void reservar() {

		// Comprueba si hay 1 reserva seleccionada en la tabla

		if(this.view.getTableReservas().getSelectedRowCount() != 1) {

			SwingUtil.showMessage("Seleccione una reserva de la tabla, por favor", "Vaya ...", 1);

		}

		else { // Hay exactamente 1 fila seleccionada en la tabla

			int idReserva = (int) this.view.getTableReservas().getModel().getValueAt(this.view.getTableReservas().getSelectedRow(), 0);
			
			boolean yaPagada =  model.yaPagada(idReserva);
			
			
			if(!model.enFecha(idReserva)) {

				SwingUtil.showMessage("La reserva seleccionada ya ha pasado o se encuentra en uso!", "Error", 0);			

			} // end fecha ya pasada 

			
			else { // La reserva no ha pasado todavía

				
				
				
				try {
					model.cancelarReserva(idReserva);
					SwingUtil.showMessage("La reserva " + idReserva +" fue cancelada con éxito!", "Éxito", 1);

				}
				catch(Exception e) {

					SwingUtil.showMessage("Error SQL en cancelarReserva!", "Error", 0);
				}

				
				
				if(yaPagada) {

					System.out.println("------------- RECIBO ---------------");
					System.out.println("#Número de reserva: " + idReserva);
					System.out.print("#Número de socio: " + this.view.getTextFieldSocio().getText());
					
					System.out.print(" (" + 
				
						this.view.getTableReservas().getModel().getValueAt(
						this.view.getTableReservas().getSelectedRow() , 1) + " " +
								
						this.view.getTableReservas().getModel().getValueAt(
						this.view.getTableReservas().getSelectedRow() , 2) + ")\n");
					
					System.out.println("Fecha de la Reserva (AAAA-MM-DD): " + 
					        this.view.getTableReservas().getModel().getValueAt(
					        	this.view.getTableReservas().getSelectedRow() , 4));
					
					System.out.println("-----------------------------------");
					


					/*
					 *  POR IMPLEMENTAR 
					 * 
					 *  Código para generar el output a 
					 *  envíar al departamento de contabilidad 
					 *  para que efectúen el reembolso correspondiente
					 * 
					 */


				} // end yaPagada situation 


			} // end else - (Fecha de reserva no había pasado)


		} // end else - (Condicion 1 fila seleccionada)


	} // end reservar() 


	

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

				SwingUtil.showMessage("El #ID de Socio debe ser un número!", "Error", 0);
				return;
			}

			//Delega en el modelo 

			// Comprueba si el socio introducido existe en la BD 

			if(idSocio != 0 && model.isSocio(idSocio)) {

				List<ReservaDTO> reservas = model.getReservas(idSocio);

				if (reservas.isEmpty()) {

					SwingUtil.showMessage("El socio #" + idSocio + " no tiene reservas en vigor", "Vaya!", 1);

				} // end el socio no tiene reservas

				else { 

					TableModel tmodel=SwingUtil.getTableModelFromPojos(reservas, new String[] { 
						
							"idReserva" , "nombre" , "apellido1" ,  "idInstalacion" , "fecha" , "horaInicio" , "estado" },
							new String[] { 

									"#", "Nombre" ,"Apellido", "Instalación", "Fecha" , "Hora" , "Estado" });

					view.getTableReservas().setModel(tmodel);
					SwingUtil.autoAdjustColumns(view.getTableReservas());
				}



			} // end el socio existe en la BD

			else {

				SwingUtil.showMessage("El Socio introducido no existe en la BD", "Error", 0);

			}


		}



	}






}
