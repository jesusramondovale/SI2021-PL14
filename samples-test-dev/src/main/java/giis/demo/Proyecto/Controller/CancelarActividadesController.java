package giis.demo.Proyecto.Controller;


import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;


import giis.demo.Proyecto.DTO.MostrarActividadesDTO;
import giis.demo.Proyecto.DTO.reservasDisplayDTO;
import giis.demo.Proyecto.Model.CancelarActividadesModel;
import giis.demo.Proyecto.View.CancelarActividadesView;
import giis.demo.util.SwingUtil;

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
			String NombreActividad =this.view.getTable().getModel().getValueAt(this.view.getTable().getSelectedRow(), 1).toString();
			//boolean yaPagada =  model.yaPagada(idActividad);

			/*
			try {
				model.CancelarActividad(idActividad);
				SwingUtil.showMessage("La Actividad " + idActividad +" fue cancelada con éxito!", "Éxito", 1);
				
				liberaReservas(idActividad);
				avisaSocios(NombreActividad);
				listaSocios(NombreActividad, idActividad);

			}
			catch(Exception e) {

				SwingUtil.showMessage("Error SQL en cancelarActividad!", "Error", 0);
			}*/
			
			model.CancelarActividad(idActividad);
			SwingUtil.showMessage("La Actividad " + idActividad +" fue cancelada con éxito!", "Éxito", 1);
			
			liberaReservas(idActividad);
			avisaSocios(NombreActividad);
			listaSocios(NombreActividad, idActividad);
		}
	}

	private void liberaReservas(int idActividad) {
		//Recorremos las reservas, si el idActividad de una reserva es igual a mi idActividad
		//llamo a model.LiberaReservas
		List<reservasDisplayDTO> listaReservas = model.getReservas(idActividad);
		for(reservasDisplayDTO reserva : listaReservas) {
			model.LiberaResevas(Integer.parseInt(reserva.getIdActividad()));
		}
		
	}
	private void avisaSocios(String NombreActividad) {
		try {
            PrintWriter writer = new PrintWriter("./avisa.txt", "UTF-8");
            writer.println("Buenos días, lamentamos avisarle que la actividad '"+ NombreActividad +"' a la que estaba apuntado se ha cancelado.");
            writer.println("Un cordial saludo,");
            writer.println("Direccion del Centro Deportivo.");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	private void listaSocios(String NombreActividad , int idActividad) {
		try {
            PrintWriter writer = new PrintWriter("./listaSocios.txt", "UTF-8");
            writer.println("Los socios que estaban inscritos en la actividad '"+ NombreActividad +"' son:");
            writer.println(model.getSocios(idActividad));
            writer.println("");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	

	private void getListaActividades() {

		List<MostrarActividadesDTO> listActividades= new ArrayList<MostrarActividadesDTO>();

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