package giis.demo.Proyecto.Controller;

import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.table.DefaultTableModel;

import giis.demo.Proyecto.DTO.SociosDisplayDTO;
import giis.demo.Proyecto.DTO.actividadesDisplayDTO;
import giis.demo.Proyecto.DTO.listaEsperaNoSociosDisplayDTO;
import giis.demo.Proyecto.DTO.listaEsperaSociosDisplayDTO;
import giis.demo.Proyecto.Model.gestionListasEsperaModel;
import giis.demo.Proyecto.View.gestionListasEsperaView;
import giis.demo.util.SwingUtil;


public class gestionListasEsperaController {

	private gestionListasEsperaModel model;
	private gestionListasEsperaView view;
	java.sql.Date sqlDate;
	DefaultTableModel tabla;

	public gestionListasEsperaController(gestionListasEsperaModel m, gestionListasEsperaView reservaV) {
		this.model = m;
		this.view = reservaV;
		this.initView();

	}

	/**
	 * Inicializacion del controlador: anyade los manejadores de eventos a los objetos del UI.
	 * Cada manejador de eventos se instancia de la misma forma, para que invoque un metodo privado
	 * de este controlador, encerrado en un manejador de excepciones generico para mostrar ventanas
	 * emergentes cuando ocurra algun problema o excepcion controlada.
	 */
	public void initController() {
		this.initView();
		view.getBtnComprobar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> comprobarPlazas()));
		view.getBtnInscribir().addActionListener(e -> SwingUtil.exceptionWrapper(() -> eliminarFila()));
		view.getBtnNoInscribir().addActionListener(e -> SwingUtil.exceptionWrapper(() -> eliminaFila2()));
		view.getBtnActualizar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> actualiza()));
	}  
	
	public void initView() {
		//Metodos para inicializar el contenido de los comboBox
		añadeActividadCB();
		//Inicializacion de ventana
		view.getFrame().setVisible(true);
		tabla = (DefaultTableModel) view.getTable().getModel();

	}

	public void añadeActividadCB() {
		List<Object[]> actividad =model.getActividad2();	
		ComboBoxModel<Object> l=SwingUtil.getComboModelFromList(actividad);
		view.getComboBox_actividad().setModel(l);
	}

	private boolean comprobarPlazas() {
		tabla.getDataVector().removeAllElements();
		List<actividadesDisplayDTO> actividad = model.obtenerActividad();
		List<listaEsperaSociosDisplayDTO> listaSocios = model.obtenerSocios();
		List<listaEsperaNoSociosDisplayDTO> listaNoSocios = model.obtenerNoSocios();
		String actividadComboBox = (String) view.getComboBox_actividad().getSelectedItem();
		boolean hayPlaza = false;
		Object[] elemento = new Object[3];
		int pos = 1;

		for (int i = 0; i < actividad.size(); i++) {
			if (actividad.get(i).getNombre().equals(actividadComboBox)) {
				if (actividad.get(i).getEstado().equals("Cancelada")) {
					SwingUtil.showMessage("Esta actividad ha sido cancelada", "Error", 1);
				} else {
					if (actividad.get(i).getPlazas() > 0) {
						for (int socio = 0; socio < listaSocios.size(); socio++) {
							if (actividad.get(i).getIdActividad() == listaSocios.get(socio).getIdActividad()) {
								view.getTxtLibre().setText("Sí");
								view.getBtnInscribir().setEnabled(true);
								view.getBtnNoInscribir().setEnabled(true);
								hayPlaza = true;
								elemento[0] = listaSocios.get(socio).getIdSocio();
								elemento[1] = "Sí";
								elemento[2] = pos;
								tabla.addRow(elemento);
								pos++;
							}
						}

						for (int Nsocio = 0; Nsocio < listaNoSocios.size(); Nsocio++) {
							if (actividad.get(i).getIdActividad() == listaNoSocios.get(Nsocio).getIdActividad()) {
								view.getTxtLibre().setText("Sí");
								view.getBtnInscribir().setEnabled(true);
								view.getBtnNoInscribir().setEnabled(true);
								hayPlaza = true;
								elemento[0] = " - ";
								elemento[1] = "No";
								elemento[2] = pos;
								tabla.addRow(elemento);
								pos++;
							}
						}
					} else {
						SwingUtil.showMessage("No hay plazas disponibles para esta actividad", "Error", 1);
						//tabla.getDataVector().removeAllElements();
					}
				}
			}
		}
		if (!hayPlaza) {
			elemento[0] = "-";
			elemento[1] = "-";
			elemento[2] = "-";
			tabla.addRow(elemento);
			view.getTxtLibre().setText("No");
			view.getBtnInscribir().setEnabled(false);
			view.getBtnNoInscribir().setEnabled(false);
		}
		return hayPlaza;
	}

	private void eliminarFila() {
		List<actividadesDisplayDTO> actividad = model.obtenerActividad();
		List<listaEsperaSociosDisplayDTO> listaSocios = model.obtenerSocios();
		List<listaEsperaNoSociosDisplayDTO> listaNoSocios = model.obtenerNoSocios();
		List<SociosDisplayDTO> cuotaSocios = model.obtenerCuotaSocios();
		String actividadComboBox = (String) view.getComboBox_actividad().getSelectedItem();
		boolean socioFuera = false;

		for (int i = 0; i < actividad.size(); i++) {
			if (actividad.get(i).getNombre().equals(actividadComboBox)) {
				for (int socio = 0; socio < listaSocios.size(); socio++) {
					if (actividad.get(i).getIdActividad() == listaSocios.get(socio).getIdActividad()) {
						int cuotaActividad = (int) actividad.get(i).getPrecioSocio();
						int idCuota = listaSocios.get(socio).getIdSocio();
						int cuotaSocio = cuotaSocios.get(idCuota).getCuota();
						model.actualizarCuota(listaSocios.get(socio).getIdSocio(), cuotaActividad + cuotaSocio);
						model.eliminaSocio(actividad.get(i).getIdActividad(), 1);
						socioFuera = true;
						List<listaEsperaSociosDisplayDTO> listaSocios2 = model.obtenerSocios();
						if (!listaSocios2.isEmpty()) {
							for (int act = 0; act < listaSocios2.size(); act++) {
								model.actualizaSocio(act, actividad.get(i).getIdActividad());
								model.actualizarPlazas(actividad.get(i).getIdActividad(), actividad.get(i).getPlazas() -1);
							}
							break;
						}
					}
				}
				if (!socioFuera) {
					for (int Nsocio = 0; Nsocio < listaNoSocios.size(); Nsocio++) {
						if (actividad.get(i).getIdActividad() == listaNoSocios.get(Nsocio).getIdActividad()) {
							model.eliminaNoSocio(actividad.get(i).getIdActividad(), 1);
							List<listaEsperaNoSociosDisplayDTO> listaSocios2 = model.obtenerNoSocios();
							if (!listaSocios2.isEmpty()) {
								for (int act = 0; act < listaSocios2.size(); act++) {
									model.actualizaNoSocio(act, actividad.get(i).getIdActividad());
									model.actualizarPlazas(actividad.get(i).getIdActividad(), actividad.get(i).getPlazas() -1);
								}
								break;
							}
						}
					}
				}
			}
		}
		
		view.getBtnInscribir().setEnabled(false);
		view.getBtnNoInscribir().setEnabled(false);
		view.getBtnActualizar().setEnabled(true);
		view.getBtnComprobar().setEnabled(false);
	}

	private void eliminaFila2() {
		List<actividadesDisplayDTO> actividad = model.obtenerActividad();
		List<listaEsperaSociosDisplayDTO> listaSocios = model.obtenerSocios();
		List<listaEsperaNoSociosDisplayDTO> listaNoSocios = model.obtenerNoSocios();
		String actividadComboBox = (String) view.getComboBox_actividad().getSelectedItem();
		boolean socioFuera = false;

		for (int i = 0; i < actividad.size(); i++) {
			if (actividad.get(i).getNombre().equals(actividadComboBox)) {
				for (int socio = 0; socio < listaSocios.size(); socio++) {
					if (actividad.get(i).getIdActividad() == listaSocios.get(socio).getIdActividad()) {
						model.eliminaSocio(actividad.get(i).getIdActividad(), 1);
						socioFuera = true;
						List<listaEsperaSociosDisplayDTO> listaSocios2 = model.obtenerSocios();
						if (!listaSocios2.isEmpty()) {
							for (int act = 0; act < listaSocios2.size(); act++) {
								model.actualizaSocio(act, actividad.get(i).getIdActividad());
								//model.actualizarPlazas(actividad.get(i).getIdActividad(), actividad.get(i).getPlazas() -1);
							}
							break;
						}
					}
				}
				if (!socioFuera) {
					for (int Nsocio = 0; Nsocio < listaNoSocios.size(); Nsocio++) {
						if (actividad.get(i).getIdActividad() == listaNoSocios.get(Nsocio).getIdActividad()) {
							model.eliminaNoSocio(actividad.get(i).getIdActividad(), 1);
							List<listaEsperaNoSociosDisplayDTO> listaSocios2 = model.obtenerNoSocios();
							if (!listaSocios2.isEmpty()) {
								for (int act = 0; act < listaSocios2.size(); act++) {
									model.actualizaNoSocio(act, actividad.get(i).getIdActividad());
									//model.actualizarPlazas(actividad.get(i).getIdActividad(), actividad.get(i).getPlazas() -1);
								}
								break;
							}
						}
					}
				}
			}
		}
		
		view.getBtnInscribir().setEnabled(false);
		view.getBtnNoInscribir().setEnabled(false);
		view.getBtnActualizar().setEnabled(true);
		view.getBtnComprobar().setEnabled(false);
	}
	
	private boolean actualiza() {
		tabla.getDataVector().removeAllElements();
		List<actividadesDisplayDTO> actividad = model.obtenerActividad();
		List<listaEsperaSociosDisplayDTO> listaSocios = model.obtenerSocios();
		List<listaEsperaNoSociosDisplayDTO> listaNoSocios = model.obtenerNoSocios();
		String actividadComboBox = (String) view.getComboBox_actividad().getSelectedItem();
		boolean hayPlaza = false;
		Object[] elemento = new Object[3];
		int pos = 1;

		for (int i = 0; i < actividad.size(); i++) {
			if (actividad.get(i).getNombre().equals(actividadComboBox)) {
				for (int socio = 0; socio < listaSocios.size(); socio++) {
					if (actividad.get(i).getIdActividad() == listaSocios.get(socio).getIdActividad()) {
						hayPlaza = true;
						elemento[0] = listaSocios.get(socio).getIdSocio();
						elemento[1] = "Sí";
						elemento[2] = pos;
						tabla.addRow(elemento);
						pos++;
					}
				}

				for (int Nsocio = 0; Nsocio < listaNoSocios.size(); Nsocio++) {
					if (actividad.get(i).getIdActividad() == listaNoSocios.get(Nsocio).getIdActividad()) {
						hayPlaza = true;
						elemento[0] = " - ";
						elemento[1] = "No";
						elemento[2] = pos;
						tabla.addRow(elemento);
						pos++;
					}
				}
			}
		}
		if (!hayPlaza) {
			view.getBtnInscribir().setEnabled(false);
			view.getBtnNoInscribir().setEnabled(false);
		}
		view.getBtnComprobar().setEnabled(true);
		view.getBtnActualizar().setEnabled(false);
		return hayPlaza;
	}
}
