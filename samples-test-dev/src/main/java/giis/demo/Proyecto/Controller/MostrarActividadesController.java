package giis.demo.Proyecto.Controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import giis.demo.Proyecto.DTO.MostrarActividadesDTO;
import giis.demo.Proyecto.Model.MostrarActividadesModel;
import giis.demo.Proyecto.View.MostrarActividadesView;
import giis.demo.util.SwingUtil;

public class MostrarActividadesController {

	private MostrarActividadesView view;
	private MostrarActividadesModel model;


	public MostrarActividadesController(MostrarActividadesView view, MostrarActividadesModel model) {

		this.view = view;
		this.model = model;

		this.initView();
	}


	public void initView() {

		this.view.getFrame().setVisible(true);

	}

	public void initController(){


		this.initView();
		view.getFrame().setVisible(true);

		System.out.println("OK1");

		view.getBtnLimpiar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> reseteaListaActividades()));
		view.getBtnBuscar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> getListaActividades()));



	}


	//Imprime la pantalla con la información solicitada por el usuario
	public void getListaActividades() {


		List<MostrarActividadesDTO> listActividades= null;

		int periodo = 0;
		String nombrePeriodo  ;
		//Tomamos el periodo seleccionado en la vista
		periodo = (view.getComboBoxPeriodo().getSelectedIndex() <= 0 ? 
				1 : 
					view.getComboBoxPeriodo().getSelectedIndex() + 1);



		switch (periodo) {
		case 1:
			nombrePeriodo =  "Enero"; 
			break;
		case 2:
			nombrePeriodo =  "Junio"; 
			break;
		case 3:
			nombrePeriodo =  "Septiembre"; 
			break;
		default:
			nombrePeriodo =  "ANY"; 
			SwingUtil.showMessage("Error en Switch nombrePeriodo", "Error", 0);
			break;
		}

		//Delegamos en el modelo 
		listActividades = model.getListaActividades(nombrePeriodo);


		//Comprueba si la consulta retornada está vacía 
		if (listActividades.isEmpty()){

			JOptionPane.showMessageDialog(null,
					"No se encontraron resultados!",
					"Vacío",
					JOptionPane.INFORMATION_MESSAGE);
		}


		//Generamos el modelo de tabla y lo cargamos con los datos de la BD
		TableModel tmodel=SwingUtil.getTableModelFromPojos(listActividades, new String[] { 
				"idActividad", "fechaInicio" ,"horaInicio", "horaFin", "plazas", "precioSocio" , "precioNoSocio" },
				new String[] { 
						"Nº Actividad", "Fecha de Inicio" ,"Hora de Inicio", "Hora de Fin", "Nº Plazas", "Precio (Socios)" , "Precio (No Socios)" });


		// Asigna a la tabla de la vista el modelo generado
		view.getTable().setModel(tmodel);
		SwingUtil.autoAdjustColumns(view.getTable());


	}



	public void reseteaListaActividades() {

		List<MostrarActividadesDTO> listActividades= null;

		//Delegamos en el modelo 
		//List <MostrarActividadesDTO> listActividades = new List<MostrarActividadesDTO>();

		TableModel tmodel=SwingUtil.getTableModelFromPojos(listActividades, new String[] { 
				"nombre", "fecha" ,"horaInicio", "horaFin", "plazas", "precioSocio" , "precioNoSocio" },
				new String[] { 
						"Nombre", "Fesdgcha de Inicio" ,"Hora de Inicio", "Hora de Fin", "Nº Plazas", "Precio (Socios)" , "Precio (No Socios)" });


		// Asigna a la tabla VACÍA de la vista el modelo generado VACIO
		view.getTable().setModel(tmodel);
		SwingUtil.autoAdjustColumns(view.getTable());


	}

}
