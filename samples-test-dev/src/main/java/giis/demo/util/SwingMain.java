package giis.demo.util;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;

import java.awt.event.ActionEvent;


import giis.demo.Proyecto.Controller.*;
import giis.demo.Proyecto.Model.*;
import giis.demo.Proyecto.View.*;

import giis.demo.tkrun.*;
import java.awt.FlowLayout;

/**
 * Punto de entrada principal que incluye botones para la ejecucion de las pantallas 
 * de las aplicaciones de ejemplo
 * y acciones de inicializacion de la base de datos.
 * No sigue MVC pues es solamente temporal para que durante el desarrollo se tenga posibilidad
 * de realizar acciones de inicializacion
 */
public class SwingMain {

	private JFrame frmGestr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { //NOSONAR codigo autogenerado
			public void run() {
				try {
					SwingMain window = new SwingMain();
					window.frmGestr.setVisible(true);
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
		frmGestr = new JFrame();
		frmGestr.setTitle("Gestión Centro Deportivo");
		frmGestr.setBounds(0, 0, 590, 366);
		frmGestr.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		JButton btnEjecutarTkrun = new JButton("Ejecutar giis.demo.tkrun");
		btnEjecutarTkrun.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				CarrerasController controller=new CarrerasController(new CarrerasModel(), new CarrerasView());
				controller.initController();
			}
		});
		frmGestr.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		frmGestr.getContentPane().add(btnEjecutarTkrun);


		JButton btnInicializarBaseDeDatos = new JButton("Inicializar Base de Datos en Blanco");
		btnInicializarBaseDeDatos.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				Database db=new Database();
				db.createDatabase(false);
			}
		});
		frmGestr.getContentPane().add(btnInicializarBaseDeDatos);

		JButton btnCargarDatosIniciales = new JButton("Cargar Datos Iniciales para Pruebas");
		btnCargarDatosIniciales.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				Database db=new Database();
				db.createDatabase(false);
				db.loadDatabase();
			}
		});
		frmGestr.getContentPane().add(btnCargarDatosIniciales);

		JButton btnMostrarActividades = new JButton("Mostrar Actividades");
		btnMostrarActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MostrarActividadesController controller=new MostrarActividadesController(new MostrarActividadesView() , new MostrarActividadesModel());
				controller.initController();
			}
		});
		frmGestr.getContentPane().add(btnMostrarActividades);


		JButton boton_CrearActividad = new JButton("Crear Actividad");
		boton_CrearActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearActividadController controller = new CrearActividadController(new CrearActividadModel(), new CrearActividadView());
				controller.initController();
			}
		});
		frmGestr.getContentPane().add(boton_CrearActividad);

		JButton btnNewButton = new JButton("Crear Periodo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearPeriodoController controller = new CrearPeriodoController(new CrearPeriodoModel(), new CrearPeriodoView());
				controller.initController();
			}
		});
		frmGestr.getContentPane().add(btnNewButton);

		JButton btnVisualizarReservas = new JButton("Visualizar Reservas (Admin)");
		btnVisualizarReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				visualizarReservasInstalacionesController controller = new visualizarReservasInstalacionesController(new visualizarReservasInstalacionesModel()
						,new visualizaReservasInstalacionesView());

				controller.initController();
			}
		});
		frmGestr.getContentPane().add(btnVisualizarReservas);


		JButton btnReservar = new JButton("Realizar Reserva (Admin)");
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				realizarReservaAdministradorController controller=new realizarReservaAdministradorController(new realizarReservasAdministradorModel() , new realizarReservaAdministradorView());
				controller.initController();
			}
		});
		frmGestr.getContentPane().add(btnReservar);

		JButton btnRealizarReservaPersonalizada = new JButton("Realizar Reserva (Actividad)");
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
		frmGestr.getContentPane().add(btnRealizarReservaPersonalizada);

		JButton btnReservaAuto = new JButton("Reserva de Actividades AUTO");
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
		frmGestr.getContentPane().add(btnReservaAuto);

		JButton btnCancelarReservas = new JButton("Cancelar Reserva (Admin)");
		btnCancelarReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CancelarReservasController controller = new CancelarReservasController(new CancelarReservasModel() , new CancelarReservasView());
				controller.initController();
			}
		});
		frmGestr.getContentPane().add(btnCancelarReservas);

		JButton btnContabilidad = new JButton("Estado Cuentas (Socio)");
		btnContabilidad.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				EstadoCuentasController controller = new EstadoCuentasController (new LoginView() , new EstadoCuentasView() , new EstadoCuentasModel());
				try {
					controller.initController();
				} catch (ParseException e1) {

					e1.printStackTrace();
				}
			}
		});



		frmGestr.getContentPane().add(btnContabilidad);

		JButton btnCancelarReservasSocios = new JButton("Cancelar Reservas (Socio)");
		btnCancelarReservasSocios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CancelarReservasSociosController controller = new CancelarReservasSociosController(new CancelarReservasSociosModel() , new CancelarReservasSociosView(), new LoginView());
				controller.initController();
			}
		});
		frmGestr.getContentPane().add(btnCancelarReservasSocios);

		JButton btnVisualizarReservas2 = new JButton("Visualizar Disponibilidad (Socio)");
		btnVisualizarReservas2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				visualizaReservasInstalaciones2Controller controller = 
						new visualizaReservasInstalaciones2Controller(
								new visualizaReservasInstalaciones2Model()
								,new LoginView()
								,new visualizaReservasInstalaciones2View());

				controller.initController();
			}
		});
		frmGestr.getContentPane().add(btnVisualizarReservas2);

		JButton btnRealizarReserva = new JButton("Realizar Reserva (Socio)");
		btnRealizarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				realizarReservaSocioFechaConcretaController controller=new realizarReservaSocioFechaConcretaController(
						new LoginView(),
						new realizarReservaSocioFechaConcretaView() , new realizarReservasSocioFechaConcretaModel());
				controller.initController();

			}
		});
		frmGestr.getContentPane().add(btnRealizarReserva);


		JButton btnVisualizarReservasSocios = new JButton("Visualizar Reservas (Socio)");
		btnVisualizarReservasSocios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VisualizarReservasSociosController controller = new VisualizarReservasSociosController(new VisualizarReservasSociosModel() , new VisualizarReservasSociosView(), new LoginView());
				try {
					controller.initController();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		frmGestr.getContentPane().add(btnVisualizarReservasSocios);
		
		JButton btnInformesSocios = new JButton("Generar Informe (Socios)");
		btnInformesSocios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InformeSociosController controller=new InformeSociosController(
						new InformeSociosView() , new InformeSociosModel());
				controller.initController();
					
			}
		});
		
		frmGestr.getContentPane().add(btnInformesSocios);


		JButton btnInformeInstalaciones = new JButton("Generar Informe (Instalaciones)");
		btnInformeInstalaciones.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				InformeInstalacionesController controller = new InformeInstalacionesController(new InformeInstalacionesView() , new InformeInstalacionesModel());
				controller.initController();

			}

		});

		frmGestr.getContentPane().add(btnInformeInstalaciones);
		
		JButton btnInscribir = new JButton("Inscribir Clientes");
		btnInscribir.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				
				
				InscribirClientesController controller=new InscribirClientesController(new InscribirClientesModel() , new InscribirClientesView());
				try {
					controller.initController();
				} catch (ParseException e1) {

					e1.printStackTrace();
				}
				
						
				
			}
		});
		frmGestr.getContentPane().add(btnInscribir);
		
		JButton btnGestionListaEspera = new JButton("Gestionar Listas de espera");
		btnGestionListaEspera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 gestionListasEsperaController controller=new gestionListasEsperaController(new gestionListasEsperaModel() , new gestionListasEsperaView());
	                controller.initController();
			}
		});
		frmGestr.getContentPane().add(btnGestionListaEspera);
		
		JButton btngeneraInformeActividad = new JButton("Generar Informe (Actividades)");
		btngeneraInformeActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 generarInformeActividadesController controller=new generarInformeActividadesController(new generarInformeActividadesModel() , new generarInformeActividadesView());
	                controller.initController();
			}
		});
		frmGestr.getContentPane().add(btngeneraInformeActividad);
		
		JButton btnContabilidadSocios = new JButton("Contabilidad de Socios");
		btnContabilidadSocios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ContabilidadMensualSociosController controller = new ContabilidadMensualSociosController(new ContabilidadMensualSociosModel(), new ContabilidadMensualSociosView());
				controller.initController();
			}
		});
		frmGestr.getContentPane().add(btnContabilidadSocios);
		
		JButton btnCancelarActividades = new JButton("Cancelar Actividades (Admin.)");
		btnCancelarActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CancelarActividadesController controller=new CancelarActividadesController(new CancelarActividadesView() , new CancelarActividadesModel());
				controller.initController();
				
			}
		});
		frmGestr.getContentPane().add(btnCancelarActividades);
	}

	public JFrame getFrame() { return this.frmGestr; }

}