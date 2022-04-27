package giis.demo.Proyecto.Controller;

import java.text.ParseException;
import java.util.List;

import javax.swing.table.TableModel;

import giis.demo.util.SwingUtil;
import giis.demo.Proyecto.DTO.ActividadPeriodoDTO;
import giis.demo.Proyecto.Model.InscribirClientesModel;
import giis.demo.Proyecto.View.InscribirClientesView;

public class InscribirClientesController {


	private InscribirClientesView view;
	private InscribirClientesModel model;



	public InscribirClientesController(InscribirClientesModel model, InscribirClientesView view) {

		this.view = view;
		this.model = model;
		this.initView();

	}


	public void initView() {

		view.getFrmInscribirClientesEn().setVisible(true); 

	}


	public void initController() throws ParseException{


		this.view.getBtnInscribir().addActionListener(e -> SwingUtil.exceptionWrapper(() -> inscribir()));
		this.view.getBtnLimpiar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> limpiar()));
		this.view.getBtnRefresh().addActionListener(e -> SwingUtil.exceptionWrapper(() -> refresh()));



	}


	/*
	 * Inscribe al Cliente en la Actividad Seleccionada de la tabla
	 */
	private void inscribir() {




	}



	/*
	 * Actualiza la Tabla de actividades con las actividades disponibles 
	 * para inscribirse, dependiendo de si el ID del Cliente introducido
	 * es un SOCIO o un NO SOCIO
	 */
	private void refresh() {



		if(this.view.getTfIDCliente().getText().isBlank() ) {

			SwingUtil.showMessage("Introduzca un ID primero!", "Vaya..", 0);
		}


		else {

			try {

				int id = Integer.parseInt(this.view.getTfIDCliente().getText());


				// El ID introducido corresponde a un SOCIO
				if(model.isSocio(id)) {

					List<ActividadPeriodoDTO> list = model.getActividadesSocios();



					TableModel tmodel=SwingUtil.getTableModelFromPojos(list, new String[] { 
							"idActividad" , "nombre" , "inicioInscrSocios" , "finInscrSocios"  },
							new String[] { 

									"#ID", "Nombre" ,"Inicio de Inscrip.", "Final de Inscrip." });


					// Asigna a la tabla de la vista el modelo generado 
					view.getTableActividades().setModel(tmodel);
					SwingUtil.autoAdjustColumns(view.getTableActividades());



				}

				// El ID introducido corresponde a un NO SOCIO
				else if (model.isNoSocio(id)) {



					List<ActividadPeriodoDTO> list = model.getActividadesNoSocios();



					TableModel tmodel=SwingUtil.getTableModelFromPojos(list, new String[] { 
							"idActividad" , "nombre" , "inicioInscrNoSocios" , "finInscrNoSocios"  },
							new String[] { 

									"#ID", "Nombre" ,"Inicio de Inscrip.", "Final de Inscrip." });


					// Asigna a la tabla de la vista el modelo generado 
					view.getTableActividades().setModel(tmodel);
					SwingUtil.autoAdjustColumns(view.getTableActividades());


				}

				// El ID introducido no corresponde a ningún CLIENTE
				else {
					SwingUtil.showMessage("El ID introducido no corresponde a ningún cliente del centro!", "Vaya..", 0);

				}



			}

			catch (NumberFormatException e) {

				SwingUtil.showMessage("El #ID del cliente debe ser numérico!", "Vaya.." , 0);
				return;

			}


		}


	}




	/*
	 * Borra la tabla y limpia el TextField del ID de cliente
	 */
	private void limpiar() {

		this.view.getTfIDCliente().setText(" ");

		List<ActividadPeriodoDTO> list = null; 

		TableModel tmodel=SwingUtil.getTableModelFromPojos(list, new String[] { 
				"idActividad" , "nombre" , "inicioInscrSocios" , "finInscrSocios"   },
				new String[] { 

						"#ID", "Nombre" ,"Inicio de Inscrip.", "Fin de Inscrip." });


		// Asigna a la tabla VACÍA de la vista el modelo generado VACIO
		view.getTableActividades().setModel(tmodel);
		SwingUtil.autoAdjustColumns(view.getTableActividades());


	}




}
