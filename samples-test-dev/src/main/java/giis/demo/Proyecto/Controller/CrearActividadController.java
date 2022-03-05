package giis.demo.Proyecto.Controller;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;

import giis.demo.Proyecto.DTO.PeriodoIncripcionDTO;
import giis.demo.Proyecto.Model.CrearActividadModel;
import giis.demo.Proyecto.View.CrearActividadView;
import giis.demo.util.Dia;
import giis.demo.util.SwingUtil;
import giis.demo.util.Util;

public class CrearActividadController {

	private CrearActividadModel model;
	private CrearActividadView view;
	private String lastSelectedKeyI=""; //recuerda la ultima fila seleccionada para restaurarla cuando cambie la tabla de carreras
	private String lastSelectedKeyD[];
	private LinkedList<Dia> dias;

	public CrearActividadController(CrearActividadModel model,  CrearActividadView view ) {
		this.model = model;
		this.view = view;

		dias =new LinkedList<Dia>();
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
		view.getBoton_CrearActividad().addActionListener(e ->CrearActividad());

	}

	public void initView() {

		//Abre la ventana (sustituye al main generado por WindowBuilder)
		view.getFrame().setVisible(true); 

	}


	public void CrearActividad(){
		//Que las cuotas son correctas
		try{
			if(Integer.parseInt(view.getLblPrecioSocio().getText())<0){
				SwingUtil.showMessage("La cuota  de socios es negativa ", "ERROR", JOptionPane.ERROR_MESSAGE);
				return;
			}

		}

		catch (NumberFormatException e) {
			SwingUtil.showMessage("La cuota  de socios no es un numero ", "ERROR", JOptionPane.ERROR_MESSAGE);
			return;
		}

		try{
			if(Integer.parseInt(view.getLblPrecioNoSocio().getText())<0){
				SwingUtil.showMessage("La cuota  de no socios es negativa ", "ERROR", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		catch (NumberFormatException e) {
			SwingUtil.showMessage("La cuota de no socios no es un numero ", "ERROR", JOptionPane.ERROR_MESSAGE);
			return;
		}

		//Que todo esta selaccioniado 
		if(view.getTextArea_Nombre().getText().equals("")||view.getTipo_deporte().getText().equals("")||view.getFechaInicio().getDate()==null||view.getFechaFin().getDate()==null){
			System.out.println("aaa");
			SwingUtil.showMessage("Hay por los menos un campo vacio ", "ERROR", JOptionPane.ERROR_MESSAGE);
			return;

		}
		else if(SwingUtil.getSelectedKey(view.getTableDias()).equals("")){
			SwingUtil.showMessage("Hay que selccinar un dia ", "ERROR", JOptionPane.ERROR_MESSAGE);

		}
		else if(SwingUtil.getSelectedKey(view.getComboBox_periodoIncripcion()).equals("")){
		SwingUtil.showMessage("Hay que seleccinar un periodo ", "ERROR", JOptionPane.ERROR_MESSAGE);



		else if(view.getFechaInicio().getDate().after(view.getFechaFin().getDate())){
			SwingUtil.showMessage("la fecha de fin es antes que la de inicio ", "ERROR", JOptionPane.ERROR_MESSAGE);

		}
		else{	

			//Se crea la actividad en la tabala ativadad y en activdad_horario
			//int id= model.insertaActividad(view.gettFNombre().getText(),view.getsAforo().getValue().toString(),view.gettFSocios().getText(),view.gettFNosocios().getText(),view.gettFtipo().getText(),  view.getdCini().getDate(), view.getdCfin().getDate(),SwingUtil.getSelectedKey(view.gettPeriodo()));
			for(Dia i:dias){
				System.out.printf(" %s   %s   %s\n ",i.getDia(),i.getIni(),i.getFin());
			}
			model.insertaActividad(view.getTextArea_Nombre(), view.getTipo_deporte(), view.getPrecioSocio(), view.getPrecioNoSocio(),
					view.getFechaInicio(), view.getFechaFin(),view.getComboBox_periodoIncripcion(), 1, view.getComboBox_Plazas());

			System.out.println("Insert Actividad");

		}
	}

	/**
	 * Metodo para cargar de la BD los periodos en el ComboBox
	 */
	@SuppressWarnings("unchecked")
	public void muestraPeriodos() {
		List<Object []> periodos=model.getPeriodos();
		ComboBoxModel<Object> l=SwingUtil.getComboModelFromList(periodos);
		view.getComboBox_periodoIncripcion().setModel(l);
	}
	/*
	  public void añadePeriodos() {
	        List<Object[]> periodos =model.getPeriodos();
	        ComboBoxModel<Object> l=SwingUtil.getComboModelFromList(periodos);
	        view.getCombobox_periodoIncripcion().setModel(l);
	    }*/


}
