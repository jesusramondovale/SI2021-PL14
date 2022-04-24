package giis.demo.Proyecto.Controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import com.opencsv.CSVWriter;

import giis.demo.Proyecto.DTO.MostrarActividadesDTO;
import giis.demo.Proyecto.Model.CancelarActividadesModel;
import giis.demo.Proyecto.View.CancelarActividadesView;
import giis.demo.util.SwingUtil;
import giis.demo.util.Util;

public class CancelarActividadesController {

	CancelarActividadesView view;
	CancelarActividadesModel model;

	public CancelarActividadesController(CancelarActividadesView view, CancelarActividadesModel model) {
		this.view = view;
		this.model = model;

		this.initView();
	}

	public void initView() {

		this.view.getFrmCancelarActividades().setVisible(true);

	}

	public void initController(){


		this.initView();
		view.getFrmCancelarActividades().setVisible(true);

		System.out.println("OK1");

		view.getBtn_BuscarActvidad().addActionListener(e -> SwingUtil.exceptionWrapper(() -> getListaActividades()));
		view.getBtn_CancelarActividad().addActionListener(e -> SwingUtil.exceptionWrapper(() -> CancelaActividades()));


	}

	private void CancelaActividades() {
		// Comprueba si hay 1 reserva seleccionada en la tabla

		if(this.view.getTable().getSelectedRowCount() != 1) {

			SwingUtil.showMessage("Seleccione una Actividad de la tabla, por favor", "Vaya ...", 1);

		}

		else { // Hay exactamente 1 fila seleccionada en la tabla

			int idActividad = Integer.parseInt( this.view.getTable().getModel().getValueAt(this.view.getTable().getSelectedRow(), 0).toString());
			
			//boolean yaPagada =  model.yaPagada(idActividad);

			try {
				model.CancelarActividad(idActividad);
				SwingUtil.showMessage("La Actividad " + idActividad +" fue cancelada con éxito!", "Éxito", 1);
				liberaReservas(idActividad);
				avisaSocios(idActividad);

			}
			catch(Exception e) {

				SwingUtil.showMessage("Error SQL en cancelarActividad!", "Error", 0);
			}
		}
		/*
		if(yaPagada) {

			System.out.println("------------------- RECIBO --------------------");
			System.out.println("#Número de reserva: " + idReserva);
			System.out.print("#Número de socio: " + this.login.getTxtId().getText());

			System.out.print(" (" + this.view.getTextFieldNombre().getText() + ")\n");

			System.out.println("Fecha de la Reserva (AAAA-MM-DD): " + 
					this.view.getTable().getModel().getValueAt(
							this.view.getTable().getSelectedRow() , 2));

			System.out.println("Fecha de Cancelación (AAAA-MM-DD): " + Util.dateToIsoString(new Date()));
			System.out.println("----------------------------------------------");


			File recibosCSV = new File("./recibo.csv");
			try {



				FileWriter fw = new FileWriter(recibosCSV);



				CSVWriter writer = new CSVWriter(fw, ';',
						CSVWriter.NO_QUOTE_CHARACTER,
						CSVWriter.DEFAULT_ESCAPE_CHARACTER,
						CSVWriter.DEFAULT_LINE_END);

				// create a List which contains String array
				List<String[]> data = new ArrayList<String[]>();
				String[] cabecera = {" #N Reserva " , " #ID Socio ", " Nombre " , "Instalacion" , "Fecha de reserva" , "Fecha de Cancelacion" , "Importe (euros)"};


				data.add(new String [] { 

						//ID reserva
						Integer.toString(idReserva)  , 

						//ID de socio
						this.login.getTxtId().getText() , 

						// Nombre de Socio
						this.view.getTextFieldNombre().getText()
						,


						this.view.getTable().getModel().getValueAt(
								this.view.getTable().getSelectedRow() , 1).toString()
						,

						this.view.getTable().getModel().getValueAt(
								this.view.getTable().getSelectedRow() , 2).toString()
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

		} // end yaPagada situation 

*/
	}

	private void liberaReservas(int idActividad) {
		//Recorremos las reservas, si el idActividad de una reserva es igual a mi idActividad
		//llamo a model.LiberaReservas
		
		
	}
	private void avisaSocios(int idActividad) {
		
	}

	private void getListaActividades() {

		List<MostrarActividadesDTO> listActividades= null;

		//Delegamos en el modelo 
		listActividades = model.getListaActividades();


		//Comprueba si la consulta retornada está vacía 
		if (listActividades.isEmpty()){

			JOptionPane.showMessageDialog(null,
					"No se encontraron resultados!",
					"Vacío",
					JOptionPane.INFORMATION_MESSAGE);
		}


		//Generamos el modelo de tabla y lo cargamos con los datos de la BD
		TableModel tmodel=SwingUtil.getTableModelFromPojos(listActividades, new String[] { 
				"idActividad", "nombre", "tipo", "precioSocio", "precioNoSocio", "fechaInicio", "fechaFin", "plazas" , "estado" },
				new String[] { 
						"Nº Actividad", "Nombre", "Tipo de Actividad", "Precio Socio", "Precio No Socio", "Fecha de Inicio", "Fecha Fin", "Nº Plazas", "Estado"});	



		// Asigna a la tabla de la vista el modelo generado
		view.getTable().setModel(tmodel);
		SwingUtil.autoAdjustColumns(view.getTable());


	}
}
