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
import javax.swing.JOptionPane;
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
	
	public boolean compruebaDNI() {
		String letraM = "";
		if(view.getTxtDNI().length() != 9 || Character.isLetter(view.getTxtDNI().charAt(8)) == false) {
			JOptionPane.showMessageDialog(null, "Debes introducir un DNI","Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		letraM = (view.getTxtDNI().substring(8)).toUpperCase();
		
		if(numeros())
			return true;
		else{
			JOptionPane.showMessageDialog(null, "Formato mal introducido","Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	private boolean numeros() {
		int i,j=0;
		String numero="";
		String DNI="";
		String[] nums = {"0","1","2","3","4","5","6","7","8","9"};
		
		for(i = 0;i < view.getTxtDNI().length() -1;i++) {
			numero = view.getTxtDNI().substring(i,i+1);
			
			for(j=0; j < nums.length;j++) {
				if(numero.equals(nums[j]))
					DNI+=nums[j];
			}
		}
		
		if(DNI.length() !=8)
			return false;
		else
			return true;
	}
	
	/*
	 * private String letra() { int DNI =
	 * Integer.parseInt(view.getTxtDNI().substring(0,8)); int resto = 8; String
	 * miLetra= ""; String [] letra =
	 * {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H",
	 * "L","C","K","E"};
	 * 
	 * resto = DNI %23; miLetra = letra[resto];
	 * 
	 * return miLetra; }
	 */
	
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
		if(compruebaDNI()) {
			
			String nombreInstalacion= view.getComboBox_instalacion().getSelectedItem().toString();
			System.out.println("Instalacion " + nombreInstalacion);


			Object[][] elementos= new Object[16][4];
			double k;
			int i,h;

			for( k=(double) 6.00,i=0,h=6;k < (double) 22.00;k++, i++, h++) {
				List<estadoReservaDTO> estadoReserva = model.getEstadoReserva(nombreInstalacion, view.getTxtFecha(),k);
				List<SociosDisplayDTO> dniSocioReserva = model.getDniSociosReserva(nombreInstalacion, k, view.getTxtFecha());
				//List<actividadReservaInstalacionDTO> actividadReserva = model.getListaInstalacionParaActividades(k, nombreInstalacion, view.getTxtFecha());
				int hor=h+1;
				String hora=(h+":00-"+hor+":00");

				if(!estadoReserva.isEmpty()) {
					Object estado = estadoReserva.get(0).getEstadoReserva();

					if(!dniSocioReserva.isEmpty()) {//reserva para socio
						Object dniSocio = dniSocioReserva.get(0).getIdSocio();
						String dniVista = view.getTxtDNI();


						if(dniSocio.equals(dniVista)) {
							dniSocio = "Mi Reserva";
						}
						elementos[i][0]=hora;
						elementos[i][1]="Ocupado";
						elementos[i][2]=dniSocio;	
						elementos[i][3]="---";


						System.out.println(estado);
						System.out.println("Estado dni: " + dniSocio);

					}else {//reserva para actividad

						if(dniSocioReserva.isEmpty() && !estadoReserva.isEmpty()) {
							elementos[i][0]=hora;
							elementos[i][1]="Ocupado";
							elementos[i][2]="---";
							elementos[i][3]=estado;
							System.out.println("Estado dni vacío");
						}
					}
					
				}else {
					elementos[i][0]=hora;
					elementos[i][1]="Libre";
					elementos[i][2]="---";
					elementos[i][3]="---";
				}


				DefaultTableModel dmodel= new DefaultTableModel(elementos,new String [] {"Hora","Disponibilidad","Socio","Actividad"});
				view.getTabla_disponibilidad().setModel(dmodel);
			}
			

			
		}


	}

}
