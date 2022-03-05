package giis.demo.Proyecto.Controller;

import java.util.Iterator;
import java.util.LinkedList;
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
		view.getBoton_CrearActividad().addActionListener(e ->CrearActividad());
		
	}
	
	public void initView() {
		
		//Abre la ventana (sustituye al main generado por WindowBuilder)
		view.getFrame().setVisible(true); 
	
	}

	
	public void CrearActividad(){
		//Que las cuotas son correctas
		try{
			if(Integer.parseInt(view.get().getText())<0){
				SwingUtil.showMessage("La cuota  de socios es negativa ", "ERROR", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
		}
		
			catch (NumberFormatException e) {
				SwingUtil.showMessage("La cuota  de socios no es un numero ", "ERROR", JOptionPane.ERROR_MESSAGE);
				return;
			}
		
			try{
				if(Integer.parseInt(view.gettFNosocios().getText())<0){
					SwingUtil.showMessage("La cuota  de no socios es negativa ", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
				catch (NumberFormatException e) {
					SwingUtil.showMessage("La cuota de no socios no es un numero ", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
			
		//Que todo esta selaccioniado 
		if(view.gettFNombre().getText().equals("")||view.gettFtipo().getText().equals("")||view.getdCini().getDate()==null||view.getdCfin().getDate()==null){
			System.out.println("aaa");
			SwingUtil.showMessage("Hay por los menos un campo vacio ", "ERROR", JOptionPane.ERROR_MESSAGE);
			//return;
		}
		
		else if(SwingUtil.getSelectedKey(view.gettInstalacion()).equals("")){
			SwingUtil.showMessage("Hay que selccinar una instalacion ", "ERROR", JOptionPane.ERROR_MESSAGE);
			
		}
		else if(SwingUtil.getSelectedKey(view.gettDias()).equals("")){
			SwingUtil.showMessage("Hay que selccinar un dia ", "ERROR", JOptionPane.ERROR_MESSAGE);
			
		}
		else if(SwingUtil.getSelectedKey(view.gettPeriodo()).equals("")){
			SwingUtil.showMessage("Hay que selccinar un periodo ", "ERROR", JOptionPane.ERROR_MESSAGE);
			
		}
		
		
		else if(view.getdCini().getDate().after(view.getdCfin().getDate())){
				SwingUtil.showMessage("la fecha de fin es antes que la de inicio ", "ERROR", JOptionPane.ERROR_MESSAGE);
				
			}
		else{	
				
			//Se crea la actividad en la tabala ativadad y en activdad_horario
			//int id= model.insertaActividad(view.gettFNombre().getText(),view.getsAforo().getValue().toString(),view.gettFSocios().getText(),view.gettFNosocios().getText(),view.gettFtipo().getText(),  view.getdCini().getDate(), view.getdCfin().getDate(),SwingUtil.getSelectedKey(view.gettPeriodo()));
			//model.inserta_hora(losDias, id);
			for(Dia i:losDias){
				System.out.printf(" %s   %s   %s\n ",i.getDia(),i.getIni(),i.getFin());
			}
			
			ReserPeriodoAdminC r = new ReserPeriodoAdminC(view.gettFNombre().getText(),lastSelectedKeyI,this.losDias, Util.dateToIsoString(view.getdCini().getDate()),Util.dateToIsoString(view.getdCfin().getDate()),view.getsAforo().getValue().toString(),
					view.gettFtipo().getText()	,view.gettFSocios().getText(),view.gettFNosocios().getText(),SwingUtil.getSelectedKey(view.gettPeriodo()));
			
			System.out.println("Insert Actividad");

		}
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
