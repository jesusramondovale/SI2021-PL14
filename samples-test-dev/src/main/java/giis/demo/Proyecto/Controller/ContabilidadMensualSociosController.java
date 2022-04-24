package giis.demo.Proyecto.Controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
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
import giis.demo.util.Util;

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

	private void pasarAFichero() {
		
		File recibosCSV = new File("./ContabilidadSocios.csv");
		try {

			FileWriter fw = new FileWriter(recibosCSV);


			CSVWriter writer = new CSVWriter(fw, ';',
					CSVWriter.NO_QUOTE_CHARACTER,
					CSVWriter.DEFAULT_ESCAPE_CHARACTER,
					CSVWriter.DEFAULT_LINE_END);

			// create a List which contains String array
			List<String[]> data = new ArrayList<String[]>();
			String[] cabecera = {" #N Reserva " , " #ID Socio ", " Nombre " , "Instalacion" , "Fecha de reserva" , "Fecha de Cancelacion" , "Importe (euros)"};


			data.add(new String [] { 

					(String) this.view.getTable().getModel().getValueAt(
							this.view.getTable().getSelectedRow() , 1) + " " + 
							this.view.getTable().getModel().getValueAt(
									this.view.getTable().getSelectedRow() , 2) 
							,

							this.view.getTable().getModel().getValueAt(
									this.view.getTable().getSelectedRow() , 3).toString()
							,

							this.view.getTable().getModel().getValueAt(
									this.view.getTable().getSelectedRow() , 4).toString()
							,

			});

			writer.writeNext(cabecera);
			writer.writeAll(data);


			writer.close();

		} catch (IOException e) 
		{
			e.printStackTrace();
			SwingUtil.showMessage("Error creando el fichero CSV", "Error", 0);
		}
	}
	/*
	private void getContabilidad() {
		List<Object[]> pagosPendientes = null;
		List<Object[]> pagosRealizados = null;
		
		pagosPendientes=model.getPagosPendientes();
		pagosRealizados=model.getPagosRealizados();
		
		List socios = (List) model.getSocios();
		
		for(int i=0; i<socios.size();i++) {
			int dia=fechaActual();
			if(fechaActual()>=25) //Entonces hacemos la contabilidad desde el 25 de este mes, al anterior
			{
				
			}else //Hacemos la contabilidad hasta el día en el que estemos
			{
				
			}
				
		}
	
	}*/
	
	private int fechaActual() {
		int fecha= LocalDateTime.now().getDayOfYear();
		return fecha;
		
	}
	
	private void mostrarContabilidad() {

		List<pagosDisplayDTO> listActividades= null;

		//Delegamos en el modelo 
		listActividades = model.getPagosPendientes();


		//Comprueba si la consulta retornada está vacía 
		if (listActividades.isEmpty()){

			JOptionPane.showMessageDialog(null,
					"No se encontraron resultados!",
					"Vacío",
					JOptionPane.INFORMATION_MESSAGE);
		}


		//Generamos el modelo de tabla y lo cargamos con los datos de la BD
		TableModel tmodel=SwingUtil.getTableModelFromPojos(listActividades, new String[] { 
				"idSocio", "idActividad", "idReserva", "importe" , "estado" },
				new String[] { 
						"Nº Socio", "Nº Actividad", "Nº Reserva", "Importe" , "Estado"});	



		// Asigna a la tabla de la vista el modelo generado
		view.getTable().setModel(tmodel);
		SwingUtil.autoAdjustColumns(view.getTable());


	}
}
