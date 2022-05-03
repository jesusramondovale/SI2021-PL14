package giis.demo.Proyecto.Controller;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import giis.demo.Proyecto.DTO.InformeActividadDTO;
import giis.demo.Proyecto.DTO.InstalacionesDisplayDTO;
import giis.demo.Proyecto.DTO.actividadesDisplayDTO;
import giis.demo.Proyecto.DTO.inscripcionesDisplayDTO;
import giis.demo.Proyecto.DTO.listaEsperaNoSociosDisplayDTO;
import giis.demo.Proyecto.DTO.listaEsperaSociosDisplayDTO;
import giis.demo.Proyecto.Model.generarInformeActividadesModel;
import giis.demo.Proyecto.View.*;
import giis.demo.util.SwingUtil;

public class generarInformeActividadesController {

	private generarInformeActividadesModel model;
	private generarInformeActividadesView view;
	public static final String DEST = "./InformeActividades.pdf";

	public generarInformeActividadesController( generarInformeActividadesModel m,
			generarInformeActividadesView reservaV) {
		this.model = m;
		this.view = reservaV;
	}

	/**
	 * Inicializacion del controlador: anyade los manejadores de eventos a los objetos del UI.
	 * Cada manejador de eventos se instancia de la misma forma, para que invoque un metodo privado
	 * de este controlador, encerrado en un manejador de excepciones generico para mostrar ventanas
	 * emergentes cuando ocurra algun problema o excepcion controlada.
	 */
	public void initController() {
		this.initView();
		view.getBtnMostrar().addActionListener(e -> SwingUtil.exceptionWrapper (()-> vistaPrevia()));
		view.getBtnGenerarInforme().addActionListener(e -> SwingUtil.exceptionWrapper (()-> generarInforme()));
	} 
	

	public void initView() {
		view.getFrame().setVisible(true);
		view.getBtnGenerarInforme().setEnabled(false);
	}
	
	public Date convertirFecha(String s) {
		Date fecha = null;
		SimpleDateFormat formato =new SimpleDateFormat("yyyy-MM-dd");  
		try {
			 fecha = formato.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return fecha;	
	}
	
	public String vistaPrevia() {

		StringBuilder sb = new StringBuilder();

		if(camposVacios()) {
			Date inicio = view.getFechaIni().getDate();
			Date ayer = new Date (inicio.getTime() - 86400000);
			Date fin = view.getFechaFin().getDate();
			String instalacion = " ";
			int socios = 0;
			int noSocios = 0;
			Date fechaInicio = null;
			Date fechaFin = null;
			int esperaSocios = 0;
			int esperaNoSocios = 0;
			String fechaIniString,fechaFinString = null;

			List<InformeActividadDTO> datosInforme = model.getInformacionInforme();
			List<actividadesDisplayDTO> datosActividad = model.obtenerfechasActividades();
			List<InstalacionesDisplayDTO> datoInstalacion = model.obtenerInstalacion();
			List<inscripcionesDisplayDTO> datoInscripcion = model.obtenerInscripciones();
			List<listaEsperaSociosDisplayDTO> listaSocios = model.obtenerSocios();
			List<listaEsperaNoSociosDisplayDTO>listaNoSocios = model.obtenerNoSocios();
			sb.append("CENTRO DEPORTIVO: Informe Actividades").append("\n").append("-----------------------------------------------------------").append("\n");
			for(int i=0; i < datosInforme.size(); i++) {
				fechaInicio = convertirFecha( datosActividad.get(i).getFechaInicio());
				fechaFin = convertirFecha(datosActividad.get(i).getFechaFin());		
				fechaIniString = datosActividad.get(i).getFechaInicio();
				fechaFinString = datosActividad.get(i).getFechaFin();
				
				if(ayer.before(fechaInicio) && fechaFin.before(fin)) {
					for (int ins = 0; ins < datoInscripcion.size(); ins++) {
						if(Integer.parseInt(datoInscripcion.get(ins).getIdActividad()) == i+1) {
							if(datoInscripcion.get(ins).getIdNoSocio() == null)
								++socios;
							else
								++noSocios;
						}
					}
					if(!listaSocios.isEmpty()) {
						for (int socio = 0; socio < listaSocios.size(); socio++) {
							if(listaSocios.get(socio).getIdActividad() == i+1)
								esperaSocios++;
						}
					}
					if(!listaNoSocios.isEmpty()) {
						for (int socio = 0; socio < listaNoSocios.size(); socio++) {
							if(listaNoSocios.get(socio).getIdActividad() == i+1)
								esperaNoSocios++;
						}
					}
					for(int a = 0; a < datoInstalacion.size(); a ++) {
						if (datoInstalacion.get(a).getIdInstalacion() == datosInforme.get(i).getIdInstalacion()) {
							switch (datoInstalacion.get(a).getIdInstalacion())
							{
							case 1: instalacion = "pista de pádel";
									break;
							case 2: instalacion = "campo de futbol";
									break;
							case 3: instalacion = "cancha de baloncesto";
									break;
							case 4: instalacion = "salón de yoga";
									break;
							case 5: instalacion = "cancha de balonmano";
									break;
							default: instalacion = "piscina";
							}
						}
					}
					double porcentajeOcupacion =Math.round(100.0 * (datosInforme.get(i).getInscritos() / ((double)(datosInforme.get(i).getPlazas() + datosInforme.get(i).getInscritos())) * 100) ) / 100.0 ;
					double porcentajeSocios = Math.round(100.0 * (socios)/(socios + noSocios));
					double porcentajeNoSocios = Math.round(100.0 * (noSocios)/(socios + noSocios));
					sb.append("Nombre actividad: ").append(datosInforme.get(i).getNombre())
					.append("\n")
					.append("Instalación: ")
					.append(instalacion).append("\n")
					.append("Fecha inicio: ").append(fechaIniString).append("\t")
					.append("Fecha Fin: ").append(fechaFinString)
					.append("\n").append("Nº plazas: ").append(datosInforme.get(i).getInscritos() + datosInforme.get(i).getPlazas()).append("\n")
					.append("Nº inscritos: ").append(datosInforme.get(i).getInscritos()).append("\n")
					.append("Porcentaje de ocupación: ")
					.append(porcentajeOcupacion).append("%").append("\n")
					.append("Inscripcion de socios: ")
					.append(socios).append("\t").append("Precio socio: ").append(datosInforme.get(i).getPrecioSocio()).append("€\n")
					.append("Inscripcion de no socios: ")
					.append(noSocios).append("\tPrecio no socio: ").append(datosInforme.get(i).getPrecioNoSocio()).append("€\n")
					.append("Porcentaje de ocupación de los socios: ")
					.append(porcentajeSocios).append("%").append("\n")
					.append("Porcentaje de ocupación de los no socios: ")
					.append(porcentajeNoSocios).append("%").append("\n")
					.append("Nº de gente en la lista de espera de socios: ")
					.append(esperaSocios).append("\n")
					.append("Nº de gente en la lista de espera de no socios: ")
					.append(esperaNoSocios).append("\n")
					.append("---------------------------------------------").append("\n");
					
					socios = 0;
					noSocios = 0;
					esperaSocios = 0;
					esperaNoSocios = 0;
				}else {
					socios = 0;
					noSocios = 0;
					esperaSocios = 0;
					esperaNoSocios = 0;
				}

			}
			view.getBtnGenerarInforme().setEnabled(true);
		}

			view.getTextArea().setText(sb.toString());

		return sb.toString();

	}
	
	public void generarInforme() {

		String texto = vistaPrevia();

		File fichero = new File (".","InformeActividades.txt");

		try {
			fichero.createNewFile();
			FileWriter fw = new FileWriter(fichero);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(texto);

			bw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}
	
	public boolean camposVacios() {
		if(view.getFechaIni().getDate() == null) {
			JOptionPane.showMessageDialog(null, "Debes seleccionar una fecha de inicio","Error",JOptionPane.ERROR_MESSAGE);
			view.getBtnGenerarInforme().setEnabled(false);
			return false;
		}

		if(view.getFechaFin().getDate() == null) {
			JOptionPane.showMessageDialog(null, "Debes seleccionar una fecha de fin","Error",JOptionPane.ERROR_MESSAGE);
			view.getBtnGenerarInforme().setEnabled(false);
			return false;
		}
		if(!intervalo()) {
			return false;
		}else
			return true;

	}
	
	public boolean intervalo() {
		if (view.getFechaIni().getDate().after(view.getFechaFin().getDate())) {
			JOptionPane.showMessageDialog(null, "Rango del periodo seleccionado incorrecto","Error",JOptionPane.ERROR_MESSAGE);
			view.getBtnGenerarInforme().setEnabled(false);
			return false;
		}else
			return true;
	}
}