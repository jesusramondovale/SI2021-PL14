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
	 * Inscribe en la Actividad Seleccionada de la tabla
	 * al Cliente con el ID escrito en el TextField de la vista
	 */
	private void inscribir() {

		if(this.view.getTableActividades().getSelectedRows().length != 1) {

			SwingUtil.showMessage("Seleccione una Actividad de la Tabla!", "Vaya..", 0);


		}

		else {

			int idActividad = (int) this.view.getTableActividades().getModel().getValueAt(
					this.view.getTableActividades().getSelectedRow(), 0);

			int idCliente = Integer.parseInt(this.view.getTfIDCliente().getText());



			if(model.isSocio(idCliente)) {

				if(model.yaInscrito(idCliente, idActividad)) {
					SwingUtil.showMessage("El Socio #" + idCliente +" ya está inscrito en la Actividad #" + idActividad , "Vaya!", 1);

				}
				else {

					model.InscribeSocio(idActividad, idCliente);			
					SwingUtil.showMessage("El Socio #" + idCliente +" fué inscrito correctamente en la Actividad #" + idActividad , "Éxito!", 1);

				}


			}

			else if (model.isNoSocio(idCliente)){

				if(model.yaInscrito(idCliente, idActividad)) {

					SwingUtil.showMessage("El No-Socio #" + idCliente +" ya está inscrito en la Actividad #" + idActividad , "Vaya!", 1);


				}

				else {

					model.InscribeNoSocios(idActividad, idCliente);
					SwingUtil.showMessage("El No-Socio #" + idCliente +" fué inscrito correctamente en la Actividad #" + idActividad , "Éxito!", 1);
				}


			}

		}

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
							"idActividad" , "nombre" , "inicioInscrSocios" , "finInscrNoSocios"  },
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

		this.view.getTfIDCliente().setText("");

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
