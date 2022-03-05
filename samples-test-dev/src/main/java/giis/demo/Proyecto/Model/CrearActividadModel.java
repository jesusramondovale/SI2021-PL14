package giis.demo.Proyecto.Model;


import java.util.*;

import javax.swing.JOptionPane;

import giis.demo.util.Util;
import giis.demo.Proyecto.DTO.PeriodoIncripcionDTO;
import giis.demo.util.ApplicationException;
import giis.demo.util.Database;
import giis.demo.util.Dia;
import giis.demo.util.UnexpectedException;
/**
 * Acceso a los datos de carreras e inscripciones, 
 * utilizado como modelo para el ejemplo de swing y para las pruebas unitarias y de interfaz de usuario.
 * 
 * <br/>En los metodos de este ejemplo toda la logica de negocio se realiza mediante una unica query sql por lo que siempre
 * se utilizan los metodos de utilidad en la clase Database que usan apache commons-dbutils y controlan la conexion. 
 * En caso de que en un mismo metodo se realicen diferentes queries se deberia controlar la conexion desde esta clase 
 * (ver como ejemplo la implementacion en Database).
 * 
 * <br/>Si utilizase algún otro framework para manejar la persistencia, la funcionalidad proporcionada por esta clase sería la asignada
 * a los Servicios, Repositorios y DAOs.
 * 
 **/

public class CrearActividadModel {

	private Database db=new Database();
	private String sql= "Insert into actividad(nombre,tipo,precioSocio,precioNoSocio,fechaInicio,fechaFin,idPeriodoInscripcion,estado,plazas) values (?,?,?,?,?,?,?,?)";


	//inserta la activdad en la base de  datos y returna el id de la actividad
	public void insertaActividad(String nombre,String tipo, Integer precioSocio,Integer precioNoSocio,Date fechaInicio,Date fechaFin,
			Integer idPeriodoInscripcion, Integer estado, Integer plazas){
		System.out.println(Util.dateToIsoString(fechaInicio));

		try {
			db.executeUpdate(sql, nombre, tipo, precioSocio, precioNoSocio,Util.dateToIsoString(fechaInicio),Util.dateToIsoString(fechaFin),idPeriodoInscripcion,estado, plazas);
			JOptionPane.showMessageDialog(
					null, 
					"Actividad creada con exito", 
					"OK",
					JOptionPane.INFORMATION_MESSAGE); 
		}catch (UnexpectedException e) {
			//Como el de arriba pero de error
			JOptionPane.showMessageDialog(
					null, 
					"No se ha podido crear la actividad, problema con sql", 
					"Error",
					JOptionPane.ERROR_MESSAGE); 
		}

	}

	public List<Object[]> getPeriodos() {
		String sql= "SELECT nombre from periodos";
		return db.executeQueryArray(sql);

	}

	//inserta los dias y hora en ela activada con el id especificado  
	public void inserta_hora(List<Dia> a,int id){

		String insert = "Insert into actividad_horario values(?,?,?,?) ";
		for(Dia i:a){
			db.executeUpdate(insert,id,i.getDia(),i.getIni(),i.getFin());
		}
	}

	}
