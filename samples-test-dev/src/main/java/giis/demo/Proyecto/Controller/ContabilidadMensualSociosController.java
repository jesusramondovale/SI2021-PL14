package giis.demo.Proyecto.Controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import com.opencsv.CSVWriter;

import giis.demo.Proyecto.DTO.pagosDisplayDTO;
import giis.demo.Proyecto.Model.ContabilidadMensualSociosModel;
import giis.demo.Proyecto.View.ContabilidadMensualSociosView;
import giis.demo.util.SwingUtil;

public class ContabilidadMensualSociosController {

	private ContabilidadMensualSociosModel model;
	private ContabilidadMensualSociosView view;

	public ContabilidadMensualSociosController(ContabilidadMensualSociosModel model, ContabilidadMensualSociosView view){
		this.model = model;
		this.view = view;
		this.initView();
	}

	public void initView() {
		view.getFrmContabilidadMensualDe().setVisible(true); 
	}

	public void initController() {

		view.getBtnMostrarContabilidad().addActionListener(e -> SwingUtil.exceptionWrapper(() -> mostrarContabilidad()));
		view.getBtnPasarAFichero().addActionListener(e -> SwingUtil.exceptionWrapper(() -> pasarAFichero()));
	}

	@SuppressWarnings({ "deprecation", "null" })
	private void pasarAFichero() {

		Date fecha_hoy= new Date();
		Date fecha_inicial = new Date();
		fecha_inicial.setDate(25);
		if(fecha_hoy.getDate()>=25) {
			fecha_inicial.setMonth(fecha_hoy.getMonth());
		}else
			fecha_inicial.setMonth(fecha_hoy.getMonth()-1);

		if(fecha_hoy.getMonth()==0) {
			fecha_inicial.setYear(fecha_hoy.getYear()-1);
		}else
			fecha_inicial.setYear(fecha_hoy.getYear());

		List<pagosDisplayDTO> listActividades= null;
		listActividades = model.getPagosRealizados(fecha_inicial,fecha_hoy);
		
		List<String[]> data = new ArrayList<String[]>();
		//Delegamos en el modelo 

		for(pagosDisplayDTO actividad : listActividades) {
			data.add(new String [] {
					actividad.getIdSocio(), 
					actividad.getIdActividad(), 
					actividad.getIdReserva(),
					String.valueOf(actividad.getImporte()),
			});

		}

		File recibosCSV = new File("./ContabilidadSocios.csv");
		try {

			FileWriter fw = new FileWriter(recibosCSV);


			CSVWriter writer = new CSVWriter(fw, ';',
					CSVWriter.NO_QUOTE_CHARACTER,
					CSVWriter.DEFAULT_ESCAPE_CHARACTER,
					CSVWriter.DEFAULT_LINE_END);

			// create a List which contains String array
			String[] cabecera = {" ID Socio " , " Total Actividades", " Total Reservas " , "Importe Total"};


			writer.writeNext(cabecera);
			writer.writeAll(data);


			writer.close();

		} catch (IOException e) 
		{
			e.printStackTrace();
			SwingUtil.showMessage("Error creando el fichero CSV", "Error", 0);
		}
	}




	@SuppressWarnings("deprecation")
	private void mostrarContabilidad() {

		List<pagosDisplayDTO> listActividades= null;
		Date fecha_hoy= new Date();
		Date fecha_inicial = new Date();
		fecha_inicial.setDate(25);
		if(fecha_hoy.getDate()>=25) {
			fecha_inicial.setMonth(fecha_hoy.getMonth());
		}else
			fecha_inicial.setMonth(fecha_hoy.getMonth()-1);

		if(fecha_hoy.getMonth()==0) {
			fecha_inicial.setYear(fecha_hoy.getYear()-1);
		}else
			fecha_inicial.setYear(fecha_hoy.getYear());

		//Delegamos en el modelo 
		listActividades = model.getPagosRealizados(fecha_inicial,fecha_hoy);


		//Comprueba si la consulta retornada está vacía 
		if (listActividades.isEmpty()){

			JOptionPane.showMessageDialog(null,
					"No se encontraron resultados!",
					"Vacío",
					JOptionPane.INFORMATION_MESSAGE);
		}


		//Generamos el modelo de tabla y lo cargamos con los datos de la BD
		TableModel tmodel=SwingUtil.getTableModelFromPojos(listActividades, new String[] { 
				"idSocio", "idActividad", "idReserva", "importe"},
				new String[] { 
						"Nº Socio", "Actividades totales", "Resevas total", "Importe total"});	



		// Asigna a la tabla de la vista el modelo generado
		view.getTable().setModel(tmodel);
		SwingUtil.autoAdjustColumns(view.getTable());


	}
}