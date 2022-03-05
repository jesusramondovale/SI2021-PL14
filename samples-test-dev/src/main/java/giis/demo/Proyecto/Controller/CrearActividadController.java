package giis.demo.Proyecto.Controller;

import java.util.Iterator;
import java.util.List;

import javax.swing.ComboBoxModel;

import giis.demo.Proyecto.DTO.PeriodoIncripcionDTO;
import giis.demo.Proyecto.Model.CrearActividadModel;
import giis.demo.Proyecto.View.CrearActividadView;
import giis.demo.util.SwingUtil;

public class CrearActividadController {

	private CrearActividadModel model;
	private CrearActividadView view;
	private String lastSelectedKeyI=""; //recuerda la ultima fila seleccionada para restaurarla cuando cambie la tabla de carreras
	private String lastSelectedKeyD[];
	
	public CrearActividadController(CrearActividadModel model,  CrearActividadView view ) {
		this.model = model;
		this.view = view;
		//no hay inicializacion especifica del modelo, solo de la vista
		this.initView();
	}
	/**
	 * Inicializacion del controlador: anyade los manejadores de eventos a los objetos del UI.
	 * Cada manejador de eventos se instancia de la misma forma, para que invoque un metodo privado
	 * de este controlador, encerrado en un manejador de excepciones generico para mostrar ventanas
	 * emergentes cuando ocurra algun problema o excepcion controlada.
	 */
	public void initController() {
		
		//Algo falla con view
		view.get.addActionListener(e ->CrearActividad());
		
	}
	
	public void initView() {
		
		//Abre la ventana (sustituye al main generado por WindowBuilder)
		view.getFrame().setVisible(true); 
	
	}

	
	public void CrearActividad() {
		
	}
	private void VerPeriodos() {
		List<PeriodoIncripcionDTO> lista=model.getListaInstalaciones();
		String[] listaformateada=new String[lista.size()];
		Iterator<PeriodoIncripcionDTO> itr= lista.iterator();
		int i=0;
		while(itr.hasNext()) {
			listaformateada[i]=itr.next().getNombre_periodo();
			i++;
		}
		view.setPeriodos(listaformateada);
		
	}
	/*
	  public void añadePeriodos() {
	        List<Object[]> periodos =model.getPeriodos();
	        ComboBoxModel<Object> l=SwingUtil.getComboModelFromList(periodos);
	        view.getCombobox_periodoIncripcion().setModel(l);
	    }*/
}
