package giis.demo.Proyecto.Controller;

import giis.demo.Proyecto.Model.CrearActividadModel;
import giis.demo.Proyecto.View.CrearActividadView;

public class CrearActividadController {

	private CrearActividadModel model;
	private CrearActividadView view;
	private String lastSelectedKeyI=""; //recuerda la ultima fila seleccionada para restaurarla cuando cambie la tabla de carreras
	private String lastSelectedKeyD[];
	
	public CrearActividadController(CrearActividadModel m,  CrearActividadView v ) {
		this.model = m;
		this.view = v;
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
		
		view.get().addActionListener(e ->CrearActividad());
		//Boton cerar peridodo
		
		//view.getBtnCrear(.addActionListener(e -> SwingUtil.exceptionWrapper(() -> getListaCarreras()));
		
		
		//En el caso del mouse listener (para detectar seleccion de una fila) no es un interfaz funcional puesto que tiene varios metodos
		//ver discusion: https://stackoverflow.com/questions/21833537/java-8-lambda-expressions-what-about-multiple-methods-in-nested-class
		view.gettInstalacion().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//no usa mouseClicked porque al establecer seleccion simple en la tabla de carreras
				//el usuario podria arrastrar el raton por varias filas e interesa solo la ultima
				SwingUtil.exceptionWrapper(() -> updateDetail(true));
			}
		});
		view.gettDias().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//no usa mouseClicked porque al establecer seleccion simple en la tabla de carreras
				//el usuario podria arrastrar el raton por varias filas e interesa solo la ultima
				SwingUtil.exceptionWrapper(() -> updateDetail(false));
			}
		});
		
		
	}
	
	public void initView() {
		//Inicializa la fecha de hoy a un valor que permitira mostrar carreras en diferentes fases 
		//y actualiza los datos de la vista
		
		this.getPeriodo();
		this.getInstalaciones();
		
		//Abre la ventana (sustituye al main generado por WindowBuilder)
		view.getFrame().setVisible(true); 
	
	}

	
	  public void añadeInstCB() {
	        List<Object []> instalaciones=model.getInstalacion();
	        ComboBoxModel<Object> l=SwingUtil.getComboModelFromList(instalaciones);
	        view.getComboBox_instalacion().setModel(l);
	    }
}
