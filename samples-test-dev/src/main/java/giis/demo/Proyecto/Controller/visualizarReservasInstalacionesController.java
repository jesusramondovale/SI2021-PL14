package giis.demo.Proyecto.Controller;
import giis.demo.Proyecto.DTO.*;
import giis.demo.Proyecto.model.*;
import giis.demo.Proyecto.view.*;
import giis.demo.util.SwingUtil;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.time.LocalDate;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.commons.beanutils.PropertyUtils;

public class visualizarReservasInstalacionesController {
	
	private visualizarReservasInstalacionesModel model;
	private visualizaReservasInstalacionesView view;
	private int siguiente,anterior,pos;
	
	public visualizarReservasInstalacionesController(visualizarReservasInstalacionesModel model, visualizaReservasInstalacionesView view) {
		this.model = model;
		this.view = view;
		this.initView();
	}
	
	public void initController() {

		view.getBtnSiguiente().addActionListener(e -> SwingUtil.exceptionWrapper(() -> fechaSiguiente()));
		view.getBtnAnterior().addActionListener(e -> SwingUtil.exceptionWrapper(() -> fechaAnterior()));
		view.getBtnComprobarReservsa().addActionListener(e -> SwingUtil.exceptionWrapper(() -> getListaReservas()));
	}
	
	public void initView() {
		muestraInstalaciones();	
		view.getFrame().setVisible(true);
		view.setTxtFecha(fecha(0));
	}
	
	public void muestraInstalaciones(){
		List<Object[]> instalaciones = model.getListaInstalaciones();
		ComboBoxModel<Object> lmodel=SwingUtil.getComboModelFromList(instalaciones);
		view.getComboBox_instalacion().setModel(lmodel);
	}
	
	public static String fecha(int constante){

		Calendar c1 = Calendar.getInstance();

		c1.add(Calendar.DAY_OF_YEAR, constante);

		int dia = (c1.get(Calendar.DATE));
		int mes = (c1.get(Calendar.MONTH)+1);
		int año = (c1.get(Calendar.YEAR));

		String d=""+dia;
		String m=""+mes;

		if(dia<10) {
			d="0"+dia;
		}
		if(mes<10) {
			m="0"+mes;
		}


		String fechaHoy=año+"-"+m+"-"+d;

		return fechaHoy;
	}
	
	public void fechaSiguiente() {
		pos++;
		if(pos == 30) {
			SwingUtil.bloqueaBoton(view.getBtnSiguiente());
		}
		if(fecha(0).equals(fecha(pos))) {
			SwingUtil.bloqueaBoton(view.getBtnAnterior());
		}
		if(!fecha(0).equals(fecha(pos))) {
			SwingUtil.activaBoton(view.getBtnAnterior());
		}

		view.setTxtFecha(fecha(pos));
		getListaReservas();

	}
	
	public void fechaAnterior() {
		pos--;
		if(pos == 30) {
			SwingUtil.bloqueaBoton(view.getBtnSiguiente());
		}
		if(!(pos == 30)) {
			SwingUtil.activaBoton(view.getBtnSiguiente());
		}
		if(fecha(0).equals(fecha(pos))) {
			SwingUtil.bloqueaBoton(view.getBtnAnterior());
		}
		view.setTxtFecha(fecha(pos));
		getListaReservas();
	}
	
	public void getListaReservas() {
		String nombreInstalacion= view.getComboBox_instalacion().getSelectedItem().toString();
		System.out.println("Instalacion escogida: " + nombreInstalacion);


		Object[][] elementos= new Object[16][4];
		double k;
		int i,h;

		for( k=(double) 6.00,i=0,h=6;k <= (double) 23.00;k++, i++, h++) {
			List<estadoReservaDTO> estadoReserva = model.getEstadoReserva(nombreInstalacion, view.getTxtFecha(),k);
			List<SociosDisplayDTO> SocioReserva = model.getDniSociosReserva(nombreInstalacion, k, view.getTxtFecha());
			List<actividadReservaInstalacionDTO> actividadReserva = model.getListaInstalacionParaActividades(k,nombreInstalacion,view.getTxtFecha());
			String hora=(h+":00-"+(h+1)+":00");

			if(!estadoReserva.get(i).getEstadoReserva()) {
				Object estado = estadoReserva.get(0).getEstadoReserva();

				 if(!SocioReserva.isEmpty()) {
					Object socio = SocioReserva.get(0).getIdSocio();					
					
					elementos[i][0]=hora;
					elementos[i][1]=estado;
					elementos[i][2]=socio;	
					elementos[i][3]=" ";

					System.out.println("Disponibilidad: " + estado);
					System.out.println("Socio: " + socio);
			

				}
				 else if(!actividadReserva.isEmpty()) {
					 Object actividad = actividadReserva.get(0).getActividad();					
						
						elementos[i][0]=hora;
						elementos[i][1]=estado;
						elementos[i][2]=" ";	
						elementos[i][3]=actividad;

						System.out.println("Disponibilidad: " + estado);
						System.out.println("Actividad: " + actividad);
				 }	 
				 else {

					if(SocioReserva.isEmpty() && actividadReserva.isEmpty() && (!estadoReserva.get(i).getEstadoReserva())) {
						elementos[i][0]=hora;
						elementos[i][1]=estado;
						elementos[i][2]=" ";
						elementos[i][3] = "";
						System.out.println(estado);
						
					}
				}
				
			}else {
				elementos[i][0]=hora;
				elementos[i][1]=false;
				elementos[i][2]=" ";
				elementos[i][3]=" ";
			}


			DefaultTableModel dmodel= new DefaultTableModel(elementos,new String [] {"Hora","Disponibilidad","Socio","Actividad"});
			view.getTabla_disponibilidad().setModel(dmodel);
		}


	}

}
