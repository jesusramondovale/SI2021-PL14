package giis.demo.Proyecto.Controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;

import giis.demo.Proyecto.Model.CrearActividadModel;
import giis.demo.Proyecto.View.CrearActividadView;
import giis.demo.util.Dia;
import giis.demo.util.SwingUtil;

public class CrearActividadController {

	private CrearActividadModel model;
	private CrearActividadView view;
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


	public void initView() {

		//Abre la ventana (sustituye al main generado por WindowBuilder)
		this.view.getFrame().setVisible(true); 
		muestraPeriodos();

	}


	public void initController() {	

		this.initView();
		view.getFrame().setVisible(true);
		System.out.println("OK1");

		//Algo falla con view
		view.getBoton_CrearActividad().addActionListener(e -> SwingUtil.exceptionWrapper(() -> CrearActividad()));

	}



	public void CrearActividad(){

		System.out.println("crearActividad()");

		//Que las cuotas son correctas
		try{

			if(Integer.parseInt(view.getPrecioSocio().getText())<0){
				SwingUtil.showMessage("La cuota  de socios es negativa ", "ERROR", JOptionPane.ERROR_MESSAGE);
				System.out.println("parseInt() 1 ...");
			}

		}

		catch (NumberFormatException e) {
			SwingUtil.showMessage("La cuota  de socios no es un numero ", "ERROR", JOptionPane.ERROR_MESSAGE);
			System.out.println("NumberFormatException ...");
		}

		try{
			if(Integer.parseInt(view.getPrecioNoSocio().getText())<0){
				SwingUtil.showMessage("La cuota  de no socios es negativa ", "ERROR", JOptionPane.ERROR_MESSAGE);
				System.out.println("ParseInt() 2...");
			}
		}
		catch (NumberFormatException e) {
			SwingUtil.showMessage("La cuota de no socios no es un numero ", "ERROR", JOptionPane.ERROR_MESSAGE);
			System.out.println("NumberFormatException 2...");
		}

		//Que todo esta selaccioniado 
		if(view.getTextArea_Nombre().getText().equals("")||view.getTipo_deporte().getText().equals("")||view.getFechaInicio().getDate()==null||view.getFechaFin().getDate()==null){
			System.out.println("aaa");
			SwingUtil.showMessage("Hay por los menos un campo vacio ", "ERROR", JOptionPane.ERROR_MESSAGE);
			System.out.println("Hay por los menos un campo vacio...");

		}
		/*
		else if(SwingUtil.getSelectedKey(view.getTableDias()).equals("")){
			SwingUtil.showMessage("Hay que selccinar un dia ", "ERROR", JOptionPane.ERROR_MESSAGE);
			System.out.println("Hay que selccinar un dia...");
		}*/

		else if(view.getFechaInicio().getDate().after(view.getFechaFin().getDate())){
			SwingUtil.showMessage("la fecha de fin es antes que la de inicio ", "ERROR", JOptionPane.ERROR_MESSAGE);
			System.out.println("la fecha de fin es antes que la de inicio...");
		}
		else{	

			System.out.println("LINE 108");

			//Se crea la actividad en la tabala ativadad y en activdad_horario
			//int id= model.insertaActividad(view.gettFNombre().getText(),view.getsAforo().getValue().toString(),view.gettFSocios().getText(),view.gettFNosocios().getText(),view.gettFtipo().getText(),  view.getdCini().getDate(), view.getdCfin().getDate(),SwingUtil.getSelectedKey(view.gettPeriodo()));
			for(Dia i:dias){
				System.out.printf(" %s   %s   %s\n ",i.getDia(),i.getIni(),i.getFin());
			}
			int id_PeriodoIncripcion=this.view.getComboBox_periodoIncripcion().getSelectedIndex();
			String periodo_escogido;
			if(id_PeriodoIncripcion ==-1) {
				periodo_escogido="1";
			}
			else {
				periodo_escogido= String.valueOf(id_PeriodoIncripcion +1);
			}
			int idInstalacion=view.getComboBox_Instalacion().getSelectedIndex()+1;

			int numPlazas =  ( view.getComboBox_Plazas().getSelectedIndex() <=0         ?  
					5        : 
						( view.getComboBox_Plazas().getSelectedIndex() + 1) * 5);

			model.insertaActividad(Integer.parseInt(view.getTextFieldIdActividad().getText()),
					view.getTextArea_Nombre().getText(), 
					view.getTipo_deporte().getText(), 
					Integer.parseInt(view.getPrecioSocio().getText()), 
					Integer.parseInt(view.getPrecioNoSocio().getText()),
					view.getFechaInicio().getDate(), view.getFechaFin().getDate(),
					periodo_escogido,1, numPlazas, idInstalacion);


			List<String> dias = new ArrayList<String>();


			// Insertar los índices de días seleccionados 
			/*
			 * Lunes = 2 
			 * Martes = 3 
			 *   .
			 *   .
			 *   .
			 *  Domingo = 1
			 */
			if(!this.view.getTextField_ILunes().getText().isBlank()) {

				dias.add("L");

			}

			if(!this.view.getTextField_IMartes().getText().isBlank()) {

				dias.add("M");

			}

			if(!this.view.getTextField_IMiercoles().getText().isBlank()) {
				dias.add("X");

			}

			if(!this.view.getTextField_IJueves().getText().isBlank()) {

				dias.add("J");
			}

			if(!this.view.getTextField_IViernes().getText().isBlank()) {

				dias.add("V");
			}

			if(!this.view.getTextField_ISabado().getText().isBlank()) {

				dias.add("S");
			}

			if(!this.view.getTextField_IDomingo().getText().isBlank()) {
				dias.add("D");

			}

			List<Double> horasIni = new ArrayList<Double>();
			List<Double> horasFin = new ArrayList<Double>();


			//Insertar las horas indicadas en la estructura de datos
			for(int i=0 ; i<dias.size() ; i++) {

				switch(dias.get(i)) {
				case "L":
					horasIni.add(i, Double.parseDouble(this.view.getTextField_ILunes().getText()));
					horasFin.add(i, Double.parseDouble(this.view.getTextField_FLunes().getText()));
					break;


				case "M":
					horasIni.add(i, Double.parseDouble(this.view.getTextField_IMartes().getText()));
					horasFin.add(i, Double.parseDouble(this.view.getTextField_FMartes().getText()));
					break;



				case "X":
					horasIni.add(i, Double.parseDouble(this.view.getTextField_IMiercoles().getText()));
					horasFin.add(i, Double.parseDouble(this.view.getTextField_FMiercoles().getText()));
					break;


				case "J":
					horasIni.add(i, Double.parseDouble(this.view.getTextField_IJueves().getText()));
					horasFin.add(i, Double.parseDouble(this.view.getTextField_FJueves().getText()));
					break;



				case "V":
					horasIni.add(i, Double.parseDouble(this.view.getTextField_IViernes().getText()));
					horasFin.add(i, Double.parseDouble(this.view.getTextField_FViernes().getText()));
					break;



				case "S":
					horasIni.add(i, Double.parseDouble(this.view.getTextField_ISabado().getText()));
					horasFin.add(i, Double.parseDouble(this.view.getTextField_FSabado().getText()));
					break;



				case "D":
					horasIni.add(i, Double.parseDouble(this.view.getTextField_IDomingo().getText()));
					horasFin.add(i, Double.parseDouble(this.view.getTextField_FDomingo().getText()));
					break;

				default:
					System.err.println("Default en Switch (RealizarReservasController:340)");
					break;

				}

			}


				/*
			//llamar al otro model
			String dias_selecccionados="";
			String lunes ="L";
			String martes ="M";
			String miercoles="X";
			String jueves ="J";
			String viernes ="V";
			String sabado ="S";
			String domingo ="D";

			System.out.println("LINE 136");

			for(int i=0; i<view.getTableDias().getSelectedRows().length;i++) {



				switch (view.getTableDias().getSelectedRows()[i]) {
				case 1:
					dias_selecccionados+=lunes;
					break;
				case 2:

					dias_selecccionados+=martes;
					break;
				case 3:

					dias_selecccionados+=miercoles;
					break;
				case 4:

					dias_selecccionados+=jueves;
					break;
				case 5:

					dias_selecccionados+=viernes;
					break;
				case 6:

					dias_selecccionados+=sabado;
					break;
				case 7:
					dias_selecccionados+=domingo;
					break;

				default:
					break;


				}
			}


			for(int i2=0; i2<view.getTableDias().getSelectedRows().length;i2++) {
				System.out.println(view.getTableDias().getSelectedRows()[i2]);
			}
			System.out.println(dias_selecccionados);

			model.insertaHoras(Integer.parseInt(view.getTextFieldIdActividad().getText()),dias_selecccionados, view.getILunes().getValue().toString(), view.getFLunes().getValue().toString());
			System.out.println("Insert Actividad");
				 */
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
