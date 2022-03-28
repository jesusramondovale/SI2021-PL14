package giis.demo.Proyecto.Controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.TableModel;

import com.opencsv.CSVWriter;

import giis.demo.Proyecto.DTO.reservasDisplayDTO;
import giis.demo.Proyecto.Model.CancelarReservasSociosModel;
import giis.demo.Proyecto.View.CancelarReservasSociosView;
import giis.demo.Proyecto.View.LoginView;
import giis.demo.util.SwingUtil;
import giis.demo.util.Util;

public class CancelarReservasSociosController {

	private CancelarReservasSociosModel model;
	private CancelarReservasSociosView view;
	private LoginView login;
	private String idSocio;

	public CancelarReservasSociosController(CancelarReservasSociosModel model, CancelarReservasSociosView view, LoginView login) {
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
		
		login.getBtnLogear().addActionListener(e -> SwingUtil.exceptionWrapper(() -> login()));
		view.getBtnComprobarReservas().addActionListener(e -> SwingUtil.exceptionWrapper(() -> getReservas()));
		view.getBtnCancelarReservas().addActionListener(e -> SwingUtil.exceptionWrapper(() -> CancelarReservas()));
		
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
				String nombrecompleto="";
				nombrecompleto.concat(this.model.getSocio(idSocio).get(0).getNombre());
				nombrecompleto.concat(" ");
				nombrecompleto.concat(this.model.getSocio(idSocio).get(0).getApellido1());
				nombrecompleto.concat(" ");
				nombrecompleto.concat(this.model.getSocio(idSocio).get(0).getApellido2());

				this.view.getTextFieldNombre().setText(nombrecompleto);

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

	private void getReservas() {
		List<reservasDisplayDTO> list= null;

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
	
	
	private void CancelarReservas() {

		// Comprueba si hay 1 reserva seleccionada en la tabla

		if(this.view.getTable().getSelectedRowCount() != 1) {

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

					System.out.println("------------------- RECIBO --------------------");
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

					System.out.println("Fecha de Cancelación (AAAA-MM-DD): " + Util.dateToIsoString(new Date()));
					System.out.println("----------------------------------------------");


					File recibosCSV = new File("C://Users/Usuario/Desktop/recibos.csv");
					try {



						FileWriter fw = new FileWriter(recibosCSV);



						CSVWriter writer = new CSVWriter(fw, ';',
								CSVWriter.NO_QUOTE_CHARACTER,
								CSVWriter.DEFAULT_ESCAPE_CHARACTER,
								CSVWriter.DEFAULT_LINE_END);

						// create a List which contains String array
						List<String[]> data = new ArrayList<String[]>();
						String[] cabecera = {" #N Reserva " , " #ID Socio ", " Nombre " , "Instalacion" , "Fecha de reserva" , "Fecha de Cancelacion" , "Importe (euros)"};


						data.add(new String [] { Integer.toString(idReserva)  ,  
								this.view.getTextFieldSocio().getText() , 

								(String) this.view.getTableReservas().getModel().getValueAt(
										this.view.getTableReservas().getSelectedRow() , 1) + " " + 
										this.view.getTableReservas().getModel().getValueAt(
												this.view.getTableReservas().getSelectedRow() , 2) 
										,

										this.view.getTableReservas().getModel().getValueAt(
												this.view.getTableReservas().getSelectedRow() , 3).toString()
										,

										this.view.getTableReservas().getModel().getValueAt(
												this.view.getTableReservas().getSelectedRow() , 4).toString()
										,

										Util.dateToIsoString(new Date())
										,

										Integer.toString(model.getImporte(idReserva)) +" euros"

						});

						writer.writeNext(cabecera);
						writer.writeAll(data);


						writer.close();

					} catch (IOException e) 
					{
						e.printStackTrace();
						SwingUtil.showMessage("Error creando el fichero CSV", "Error", 0);
					}





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


	
	
	
	
}
