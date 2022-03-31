package giis.demo.util;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;

import java.awt.event.ActionEvent;


import giis.demo.Proyecto.Controller.*;
import giis.demo.Proyecto.Model.*;
import giis.demo.Proyecto.View.*;

import giis.demo.tkrun.*;

/**
 * Punto de entrada principal que incluye botones para la ejecucion de las pantallas 
 * de las aplicaciones de ejemplo
 * y acciones de inicializacion de la base de datos.
 * No sigue MVC pues es solamente temporal para que durante el desarrollo se tenga posibilidad
 * de realizar acciones de inicializacion
 */
public class SwingMain {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { //NOSONAR codigo autogenerado
			public void run() {
				try {
					SwingMain window = new SwingMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace(); //NOSONAR codigo autogenerado
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SwingMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Main");
		frame.setBounds(0, 0, 415, 497);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		JButton btnEjecutarTkrun = new JButton("Ejecutar giis.demo.tkrun");
		btnEjecutarTkrun.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				CarrerasController controller=new CarrerasController(new CarrerasModel(), new CarrerasView());
				controller.initController();
			}
		});
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().add(btnEjecutarTkrun);
		
			
		JButton btnInicializarBaseDeDatos = new JButton("Inicializar Base de Datos en Blanco");
		btnInicializarBaseDeDatos.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				Database db=new Database();
				db.createDatabase(false);
			}
		});
		frame.getContentPane().add(btnInicializarBaseDeDatos);
			
		JButton btnCargarDatosIniciales = new JButton("Cargar Datos Iniciales para Pruebas");
		btnCargarDatosIniciales.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				Database db=new Database();
				db.createDatabase(false);
				db.loadDatabase();
			}
		});
		frame.getContentPane().add(btnCargarDatosIniciales);
		
		JButton btnMostrarActividades = new JButton("Mostrar Actividades");
		btnMostrarActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MostrarActividadesController controller=new MostrarActividadesController(new MostrarActividadesView() , new MostrarActividadesModel());
				controller.initController();
			}
		});
		frame.getContentPane().add(btnMostrarActividades);
		
		
		JButton boton_CrearActividad = new JButton("Crear Actividad");
		boton_CrearActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearActividadController controller = new CrearActividadController(new CrearActividadModel(), new CrearActividadView());
				controller.initController();
			}
		});
		frame.getContentPane().add(boton_CrearActividad);
		
		JButton btnNewButton = new JButton("Crear Periodo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearPeriodoController controller = new CrearPeriodoController(new CrearPeriodoModel(), new CrearPeriodoView());
				controller.initController();
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnVisualizarReservas = new JButton("Visualizar reservas de las instalaciones");
		btnVisualizarReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				visualizarReservasInstalacionesController controller = 
						new visualizarReservasInstalacionesController(
								 new visualizarReservasInstalacionesModel()
								,new visualizaReservasInstalacionesView());
				
				controller.initController();
			}
		});
		frame.getContentPane().add(btnVisualizarReservas);
		
		
		JButton btnReservar = new JButton("Realizar reserva");
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 realizarReservaController controller=new realizarReservaController(new RealizarReservasModel() , new realizarReservaView(), new resguardoView());
	                controller.initController();
			}
		});
		frame.getContentPane().add(btnReservar);
		
		JButton btnRealizarReservaPersonalizada = new JButton("Realizar Reserva Personalizada");
		btnRealizarReservaPersonalizada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ReservaPersonalizadaController controller=new ReservaPersonalizadaController(new ReservaPersonalizadaView() , new ReservaPersonalizadaModel());
				try {
					controller.initController();
				} catch (ParseException e1) {
					
					e1.printStackTrace();
				}
				
							
			}
		});
		frame.getContentPane().add(btnRealizarReservaPersonalizada);
		
		JButton btnReservaAuto = new JButton("Realizar Reserva AUTO");
		btnReservaAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AutoReservaController controller=new AutoReservaController(new AutoReservaView() , new AutoReservaModel());
				try {
					controller.initController();
				} catch (ParseException e1) {
					
					e1.printStackTrace();
				}
				
							
			}
		});
		frame.getContentPane().add(btnReservaAuto);

	}

	public JFrame getFrame() { return this.frame; }
	
}
