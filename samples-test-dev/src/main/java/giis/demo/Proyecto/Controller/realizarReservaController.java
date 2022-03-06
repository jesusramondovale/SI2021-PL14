package giis.demo.Proyecto.Controller;

import java.util.List;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.NoSuchElementException;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import org.apache.commons.beanutils.PropertyUtils;

import giis.demo.Proyecto.DTO.InstalacionesDisplayDTO;
import giis.demo.Proyecto.model.realizarReservasModel;
import giis.demo.Proyecto.view.realizarReservaView;
import giis.demo.Proyecto.view.resguardoView;
import giis.demo.util.ApplicationException;
import giis.demo.util.SwingUtil;
import giis.demo.util.UnexpectedException;
import giis.demo.util.Util;

public class realizarReservaController {

	private realizarReservasModel model;
	private realizarReservaView view;
	private resguardoView viewResg;
	private int select;
	private int numSocio;
	java.sql.Date sqlDate;

	public realizarReservaController(realizarReservasModel m, realizarReservaView reservaV, resguardoView resguardoV) {
		this.model = m;
		this.view = reservaV;
		this.viewResg = resguardoV;

	}

	/**
	 * Inicializacion del controlador: anyade los manejadores de eventos a los objetos del UI.
	 * Cada manejador de eventos se instancia de la misma forma, para que invoque un metodo privado
	 * de este controlador, encerrado en un manejador de excepciones generico para mostrar ventanas
	 * emergentes cuando ocurra algun problema o excepcion controlada.
	 */
	public void initController() {
		this.initView();
		//Boton para controlar que no hagan reservas con mas de 7 días de antelación
		view.getBtnDispo().addActionListener(e -> getFechaCorrect());
		view.getBtnDispo().addActionListener(e -> getListaInstalaciones());		
		//Boton para rellenar los DATOS de una Reserva
		view.getBtnReserva().addActionListener(e -> rellenaReservaInstalacion());
		//Boton para generar el resguardo
		view.getBtnResguardo().addActionListener(e -> generarResguardo());
		viewResg.getBtnImprimir().addActionListener(e -> System.exit(0));
	}  

	

	public void initView() {
		//Inicializa la fecha de hoy a un valor que permitira mostrar carreras en diferentes fases 
		//y actualiza los datos de la vista
		java.util.Date fecha= new java.util.Date();
		long lnMilisegundos = fecha.getTime();
		sqlDate = new java.sql.Date(lnMilisegundos);
		view.setTxtFecha(sqlDate.toString());
		//Metodos para inicializar el contenido de los comboBox
		añadeInstCB();
		//Inicializacion de ventana
		view.getFrame().setVisible(true);

	}
	/**
	 * Metodo para cargar de la BD las instalaciones en el ComboBox
	 */
	public void añadeInstCB() {
		List<Object []> instalaciones=model.getInstalacion();
		ComboBoxModel<Object> l=SwingUtil.getComboModelFromList(instalaciones);
		view.getComboBox_instalacion().setModel(l);
	}

	/**
	 * Metodo que añade al comboBox los elemntos de busqueda sql
	 * @param pojos
	 * @param comboBox
	 * @param nombre
	 */
	@SuppressWarnings("unchecked")
	public static <E> void añedeItemComboBox(List<E> pojos, JComboBox<String> comboBox,String nombre) {
		for (int i=0;i<pojos.size();i++) {
			try {
				Object pojo=pojos.get(i);
				Object val= PropertyUtils.getSimpleProperty(pojo, nombre);
				comboBox.addItem((String) val);
			}catch(IllegalAccessException | InvocationTargetException|NoSuchElementException | NoSuchMethodException e) {
				throw new UnexpectedException(e);
			}			
		}
	} 

	
	@SuppressWarnings("unchecked")
	public void getListaInstalaciones() {

		this.select=getSelectedIndex(view.getComboBox_instalacion());
		String fecha=getText(view.getTxtFecha());
		float horaInicio= (float)Double.parseDouble(getSelectedItem(view.getComboBox_HoraC()));
		float horaFin=(float)Double.parseDouble(getSelectedItem(view.getComboBox_HoraF()));

		List<InstalacionesDisplayDTO> instalacion = model.getListaInstalacionesArray(select,Util.isoStringToDate(fecha),horaInicio,horaFin);
		TableModel tmodel=SwingUtil.getTableModelFromPojos(instalacion, new String[] {"idInstalacion", "nombreInstalacion", "fechaReserva","horaInicioReserva",
				"horaFinReserva","estado"});
		
	}
	
	public static java.util.Date controlReserva(java.util.Date fecha, int dias) {
		Calendar calendario= Calendar.getInstance();
		calendario.setTime(fecha);
		calendario.add(Calendar.DAY_OF_YEAR, dias);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String fechaNueva= formatter.format(calendario.getTime());
		java.util.Date result=Util.isoStringToDate(fechaNueva);
		return result;
	}
	
	public void getFechaCorrect() {
		//Para parametrizar la fecha que no puedas reservas con mas de X dias, en este caso 7
		java.util.Date todayDate= Util.isoStringToDate(view.getTxtFecha());
		//Para parametrizar las horas, que no puedas reservar una instalacion mas de 2 horas
		float horaInicio=(float) Double.parseDouble(getSelectedItem(view.getComboBox_HoraC()));
		float horaFin=(float) Double.parseDouble(getSelectedItem(view.getComboBox_HoraF()));
		String fecha=getText(view.getTxtFecha());

		List<Object[]> compHora=model.getFechasReservas(Util.isoStringToDate(fecha), horaInicio, horaFin);
		if (compHora.isEmpty() && horaFin-horaInicio<=(float)2.0 && todayDate.compareTo(controlReserva(sqlDate, 15))<=0) {
			System.out.println("Entro aqui 1");
			rellenaDatos();
			view.getBtnReserva().setEnabled(true);
			
		}
		else if(compHora.isEmpty()&& horaFin-horaInicio>(float)2.0) {
			System.out.println("Entro aqui 2");
			JOptionPane pane = new JOptionPane("No puede reservar más de 3 horas.",JOptionPane.INFORMATION_MESSAGE);
			pane.setOptions(new Object[] {"ACEPTAR"}); 
			JDialog x = pane.createDialog(pane, "Error");
			x.setVisible(true);
			view.getBtnReserva().setEnabled(false);
		}
		else if((todayDate.compareTo(controlReserva(sqlDate, 15))<=0 && !(compHora.get(0)[0].equals(fecha)) && horaFin-horaInicio<=(float)2.0)) {
			System.out.println("Entro aqui 3");
			view.getBtnReserva().setEnabled(true);
		}
		else if(horaFin-horaInicio>(float)2.0||todayDate.compareTo(controlReserva(sqlDate, 15))>0 || 
				(compHora.get(0)[0].equals(fecha) && (((float)Double.parseDouble(compHora.get(0)[1].toString())==horaInicio) || ((float)Double.parseDouble(compHora.get(0)[2].toString())==horaFin)))) {	
			JOptionPane pane = new JOptionPane("No puede rearlizar esta reserva, ya está ocupada.",JOptionPane.INFORMATION_MESSAGE);
			pane.setOptions(new Object[] {"ACEPTAR"}); 
			JDialog x = pane.createDialog(pane, "Error");
			x.setVisible(true);
			System.out.println("Entro aqui 4");
			view.getBtnReserva().setEnabled(false);
		}
		else {
			System.out.println("Entro aqui 5");
			view.getBtnReserva().setEnabled(true);
		}

	}
	
	public void rellenaDatos() {
		List<Object[]> info=model.getInfoSocio(1);
		view.setTxtSocio("1");
		view.setTxtNombre("Javier");
		view.setTxtApellidos("Santos" + " "+"Menendez");
		view.setTxtReserva("3");
		view.setTxtPrecio("20");
		view.getRdBtnFinal().setSelected(true);
		
		
		  int estado = 0;
		  
		  try{ String fecha=view.getTxtFecha();
		  if(view.getRdBtnEfectivo().isSelected()) estado = 0;
		  if(view.getRdBtnFinal().isSelected()) estado = 1;
		  model.realizarReserva(numSocio, 0, getSelectedIndex(view.getCbInstalacion()),
		  Util.isoStringToDate(fecha), (float)
		  Double.parseDouble(getSelectedItem(view.getComboBox_HoraC())), (float)
		  Double.parseDouble(getSelectedItem(view.getComboBox_HoraF())), estado);
		  System.out.println("Reserva Instalación Realizada");}
		  catch(NullPointerException e){ JOptionPane pane = new
		  JOptionPane("Falta un campo por rellenar.",JOptionPane.INFORMATION_MESSAGE);
		  pane.setOptions(new Object[] {"ACEPTAR"});  
		  JDialog d = pane.createDialog(pane, "Error");
		  d.setVisible(true);
		  
		  } catch(ApplicationException e){ JOptionPane pane = new
		  JOptionPane("Falta un campo por rellenar.",JOptionPane.INFORMATION_MESSAGE);
		  pane.setOptions(new Object[] {"ACEPTAR"}); //fijar este valor 
		  JDialog d = pane.createDialog(pane, "Error");
		  d.setVisible(true); }catch(NumberFormatException e){ JOptionPane pane = new
		  JOptionPane("Un valor introducido no tiene el formato correcto.",JOptionPane.
		  INFORMATION_MESSAGE); pane.setOptions(new Object[] {"ACEPTAR"}); 
		  JDialog d = pane.createDialog(pane,
		  "Error"); d.setVisible(true); }
		 
		
	}
	
	public void rellenaReservaInstalacion() {
		int estado = 0;
		String fecha=view.getTxtFecha();
			if(view.getRdBtnFinal().isSelected()) estado = 1;
			if(view.getRdBtnEfectivo().isSelected()) estado = 0;
			model.realizarReserva(numSocio, 0, getSelectedIndex(view.getComboBox_instalacion()), 
					Util.isoStringToDate(fecha),
					(float) Double.parseDouble(getSelectedItem(view.getComboBox_HoraC())),
					(float) Double.parseDouble(getSelectedItem(view.getComboBox_HoraF())), estado);
		view.getBtnResguardo().setEnabled(true);
		System.out.println("Reserva Instalación Realizada");
	}
				
		
	public static int getSelectedIndex(JComboBox<Object> cbInstalacion) {

		int periodo;
		periodo= cbInstalacion.getSelectedIndex();
		return periodo;
	}
	public static void escribeTextoField(JTextField area, String string) {
		area.setText(string);
	}
	public static String getSelectedItem(JComboBox<Object> cbInstalacion) {
		String select;
		select=(String) cbInstalacion.getSelectedItem();
		return select;
	}

	public static String getText(String Fecha) {
		return Fecha;
	}
		
	public void btngrupo() {
		if(view.getRdBtnFinal().isSelected())
			viewResg.setTxtPagoR("Pago al final del mes");
		else
			viewResg.setTxtPagoR("Pago en efectivo");
	}
	public void generarResguardo() {
		try{
		btngrupo();	
		escribeTextoField(viewResg.getTxtSocioR(),(view.getTxtSocio()));
		escribeTextoField(viewResg.getTxtFecha(),(view.getTxtFecha()));
		viewResg.setTxtHora1R(view.getComboBox_HoraC().getSelectedItem().toString());
		viewResg.setTxtHora2R(view.getComboBox_HoraF().getSelectedItem().toString());
		viewResg.setTxtInstalacionR(view.getComboBox_instalacion().getSelectedItem().toString());
		escribeTextoField(viewResg.getTxtNombreR(),(view.getTxtNombre()));
		escribeTextoField(viewResg.getTxtApellidosR(),(view.getTxtApellidos()));
		escribeTextoField(viewResg.getTxtReservaR(),(view.getTxtReserva()));
		escribeTextoField(viewResg.getTxtPrecioR(),(view.getTxtPrecio()));
		
		viewResg.getFrame().setVisible(true);
		JOptionPane pane = new JOptionPane("Reserva realizada.",JOptionPane.INFORMATION_MESSAGE);
		pane.setOptions(new Object[] {"ACEPTAR"}); 
		JDialog d = pane.createDialog(pane, "Confirmacion reserva");
		d.setLocation(200,200);
		d.setVisible(true);}
		catch(NullPointerException e){
			JOptionPane pane = new JOptionPane("Hay algun campo vacio.",JOptionPane.INFORMATION_MESSAGE);
			pane.setOptions(new Object[] {"ACEPTAR"}); 
			JDialog d = pane.createDialog(pane, "Reviselo");
			d.setVisible(true);
		}catch(NumberFormatException e){
			JOptionPane pane = new JOptionPane("Hay algun campo que no coincide con el formato que se pide.",JOptionPane.INFORMATION_MESSAGE);
			pane.setOptions(new Object[] {"ACEPTAR"});
			JDialog d = pane.createDialog(pane, "Reviselo");
			d.setVisible(true);
		}
	}

}
