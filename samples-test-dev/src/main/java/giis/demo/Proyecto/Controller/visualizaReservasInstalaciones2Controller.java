package giis.demo.Proyecto.Controller;


import java.util.Calendar;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.table.DefaultTableModel;


import giis.demo.Proyecto.DTO.SociosDisplayDTO;
import giis.demo.Proyecto.DTO.estadoReservaDTO;
import giis.demo.Proyecto.Model.visualizaReservasInstalaciones2Model;
import giis.demo.Proyecto.View.*;
import giis.demo.util.SwingUtil;


public class visualizaReservasInstalaciones2Controller {


	private visualizaReservasInstalaciones2Model model;
	private visualizaReservasInstalaciones2View view;
	private LoginView viewIntro;

	private int puntero = 0;



	public visualizaReservasInstalaciones2Controller(visualizaReservasInstalaciones2Model model,
			LoginView view2,visualizaReservasInstalaciones2View view) {
		this.model = model;
		this.viewIntro = view2;
		this.view = view;
		this.initView();
	}


	public void initController() {

		viewIntro.getBtnLogear().addActionListener(e -> SwingUtil.exceptionWrapper(() -> mostrarPantalla()));
		view.getBtnSiguiente().addActionListener(e -> SwingUtil.exceptionWrapper(() -> fechaSiguiente()));
		view.getBtnAnterior().addActionListener(e -> SwingUtil.exceptionWrapper(() -> fechaAnterior()));
		view.getBtnComprobarReservsa().addActionListener(e -> SwingUtil.exceptionWrapper(() -> getListaReservas()));

	}

	public void initView() {
		muestraInstalaciones();
		view.setTxtFecha(fecha(0));
		view.getFrame().setVisible(false);
		viewIntro.getFrame().setVisible(true);
		view.getBtnAnterior().setEnabled(false);
	}


	public void mostrarPantalla() {
		if(viewIntro.getTxtId().getText().isEmpty()) {
			SwingUtil.showMessage("Tienes que introducir un socio", "Error", 0);
		}else {

			if(compruebaId()) {
				viewIntro.getFrame().setVisible(false);
				view.getFrame().setVisible(true);
			}
		}
	}

	public void muestraInstalaciones(){//Muestra las instalaciones en el comboBox
		List<Object[]> instalaciones = model.getListaInstalaciones();
		ComboBoxModel<Object> lmodel=SwingUtil.getComboModelFromList(instalaciones);
		view.getComboBox_instalacion().setModel(lmodel);
	}
	
	public boolean compruebaId() {
		
		try {
			
			List<SociosDisplayDTO> idSocio = model.getInfoSocio(Integer.parseInt(viewIntro.getTxtId().getText() ));
			if(!idSocio.isEmpty())
				return true;
			else {
				SwingUtil.showMessage("El socio no existe en la BBDD!", "Error", 0);
				return false;
			}
		}
		catch (NumberFormatException e) {
			SwingUtil.showMessage("El socio debe ser un número!", "Error", 0);
			return false;
		}
		
	}


	public void getListaReservas() {
			
				String nombreInstalacion= view.getComboBox_instalacion().getSelectedItem().toString();
				System.out.println("Instalacion " + nombreInstalacion);
		
		
				Object[][] elementos= new Object[16][4];
				double k;
				int i,h;
		
				for( k=(double) 6.00,i=0,h=6;k < (double) 22.00;k++, i++, h++) {
					List<estadoReservaDTO> estadoReserva = model.getEstadoReserva(nombreInstalacion, view.getTxtFecha(),k);
					List<SociosDisplayDTO> dniSocioReserva = model.getDniSociosReserva(nombreInstalacion, k, view.getTxtFecha());
					int hor=h+1;
					String hora=(h+":00-"+hor+":00");
		
					if(!estadoReserva.isEmpty()) {
						Object estado = estadoReserva.get(0).getEstadoReserva();
		
						if(!dniSocioReserva.isEmpty()) {//reserva para socio
							for(int socio = 0; socio < dniSocioReserva.size(); socio++) {
								Object dniSocio = dniSocioReserva.get(socio).getIdSocio();
								if ((Integer)dniSocio == Integer.parseInt(viewIntro.getTxtId().getText())) {
				
									elementos[i][0]=hora;
									elementos[i][1]="Ocupado";
									elementos[i][2]=dniSocio;	
									elementos[i][3]="---";
			
			
									System.out.println(estado);
									System.out.println("Estado dni: " + dniSocio);
								}else {
									elementos[i][0]=hora;
									elementos[i][1]="Ocupado";
									elementos[i][2]="Reservado";	
									elementos[i][3]="---";
			
								}
							}
		
						}else {//reserva para actividad
		
							if(dniSocioReserva.isEmpty() && !estadoReserva.isEmpty()) {
								elementos[i][0]=hora;
								elementos[i][1]="Ocupado";
								elementos[i][2]="---";
								elementos[i][3]=estado;
								System.out.println("Estado dni vacío");
							}else {
								elementos[i][0]=hora;
								elementos[i][1]="Ocupado";
								elementos[i][2]="---";
								elementos[i][3]="---";
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



	public static String fechaMax() {

		Calendar c2 = Calendar.getInstance();
		c2.add(Calendar.DAY_OF_YEAR, 30);
		int d = (c2.get(Calendar.DATE));
		int m = (c2.get(Calendar.MONTH)+1);
		int a = (c2.get(Calendar.YEAR));

		String dia=""+d;
		String mes=""+m;

		if(d<10) {
			dia="0"+d;
		}
		if(m<10) {
			mes="0"+m;
		}

		String fechaMax=a+"-"+mes+"-"+ dia;

		return fechaMax;	
	}


	public static String fecha(int constante){

		Calendar c1 = Calendar.getInstance();

		//Fecha actualizada al pulsar botones
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
		puntero++;
		if(fecha(puntero).equals(fechaMax())) {
			SwingUtil.bloqueaBoton(view.getBtnSiguiente());
		}
		if(fecha(0).equals(fecha(puntero))) {
			SwingUtil.bloqueaBoton(view.getBtnAnterior());
		}
		if(!fecha(0).equals(fecha(puntero))) {
			SwingUtil.activaBoton(view.getBtnAnterior());
		}

		view.setTxtFecha(fecha(puntero));
		getListaReservas();

	}

	public void fechaAnterior() {
		puntero--;
		if(fecha(puntero).equals(fechaMax())) {
			SwingUtil.bloqueaBoton(view.getBtnSiguiente());
		}
		if(!fecha(puntero).equals(fechaMax())) {
			SwingUtil.activaBoton(view.getBtnSiguiente());
		}
		if(fecha(0).equals(fecha(puntero))) {
			SwingUtil.bloqueaBoton(view.getBtnAnterior());
		}
		view.setTxtFecha(fecha(puntero));
		getListaReservas();
	}


}