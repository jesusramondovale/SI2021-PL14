package giis.demo.Proyecto.Controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import giis.demo.Proyecto.DTO.MostrarActividadesDTO;
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
		view.getBtn_CancelarActividad().addActionListener(e -> SwingUtil.exceptionWrapper(() -> eliminaActividades()));
		

	}

	private Object eliminaActividades() {
		// TODO Auto-generated method stub
		return null;
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
				"idActividad", "nombre", "tipo", "precioSocio", "precioNoSocio", "fechaInicio", "fechaFin", "plazas" },
				new String[] { 
						"Nº Actividad", "Nombre", "Tipo de Actividad", "Precio Socio", "Precio No Socio", "Fecha de Inicio", "Fecha Fin", "Nº Plazas" });	
		
		
		
		// Asigna a la tabla de la vista el modelo generado
		view.getTable().setModel(tmodel);
		SwingUtil.autoAdjustColumns(view.getTable());


	}
}
