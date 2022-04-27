package giis.demo.Proyecto.Controller;

import javax.swing.JOptionPane;

import giis.demo.Proyecto.Model.CrearPeriodoModel;
import giis.demo.Proyecto.View.CrearPeriodoView;
import giis.demo.util.SwingUtil;

public class CrearPeriodoController {

	private CrearPeriodoModel model;
	private CrearPeriodoView view;

	public CrearPeriodoController(CrearPeriodoModel modelo, CrearPeriodoView vista) {
		this.model = modelo;
		this.view =vista;
		this.initView();
	}

	public void initView() {
		view.getFrame().setVisible(true); 
	}
	public void initController() {
		view.getBotonCrearPeriodo().addActionListener(e ->CrearPeriodo());
	}

	public void CrearPeriodo() {
		//Comprobamos campos no vacios
		if( view.getNombrePeriodo().getText().equals("")||view.getFechaInicioPeriodo().getDate()==null||view.getFechaFinPeriodo().getDate()==null||view.getFechaFinPeriodoNoSocio().getDate()==null){
			SwingUtil.showMessage("Hay algun campo vacio ", "ERROR", JOptionPane.ERROR_MESSAGE);
			
		}
		//comprobamos las fechas
		else if(view.getFechaInicioPeriodo().getDate().after(view.getFechaFinPeriodo().getDate())){
			SwingUtil.showMessage("La fecha 'Fin de periodo' es antes que la de inicio ", "ERROR", JOptionPane.ERROR_MESSAGE);
			
		}
		else if(view.getFechaFinPeriodo().getDate().after(view.getFechaFinPeriodoNoSocio().getDate())){
			SwingUtil.showMessage("La fecha 'Fin no socios' es antes que la de fin de socios", "ERROR", JOptionPane.ERROR_MESSAGE);
		
		}
	
		//Si todo esta correcto se puede crear dicho periodo
		else
			model.insertaPeriodo(view.getNombrePeriodo().getText(), view.getFechaInicioPeriodo().getDate(),  view.getFechaFinPeriodo().getDate(), view.getFechaFinPeriodoNoSocio().getDate());
   
	}
	


}
