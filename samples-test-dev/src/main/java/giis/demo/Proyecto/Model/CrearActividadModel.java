package giis.demo.Proyecto.Model;


import java.util.*;


import giis.demo.util.Util;
import giis.demo.util.Database;

import giis.demo.util.Dia;
import giis.demo.util.SwingUtil;
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
	private String sql= "Insert into actividades(idActividad,nombre,tipo,"
			+ "precioSocio,precioNoSocio,"
			+ "fechaInicio,fechaFin,"
			+ "idPeriodoInscripcion,estado,"
			+ "plazas,idInstalacion) values (?,?,?,?,?,?,?,?,?,?,?)";
	private String sql2= "Insert into horarioActividad(idActividad,idHorarios) values (?,?)";
	private String sql3 = "Insert into horarios(idHorarios,dia,horaInicio,horaFin) values (?,?,?,?)";


	//inserta la activdad en la base de  datos y returna el id de la actividad
	public void insertaActividad(int idActividad , String nombre,String tipo, int precioSocio,int precioNoSocio,Date fechaInicio,Date fechaFin,
			String periodo, int estado, int plazas, int idInstalacion){
		System.out.println(Util.dateToIsoString(fechaInicio));
		
		
		try {
			db.executeUpdate(sql,idActividad, nombre, tipo, precioSocio, precioNoSocio,Util.dateToIsoString(fechaInicio),Util.dateToIsoString(fechaFin),periodo,estado, plazas, idInstalacion);
			SwingUtil.showMessage("Actividad creada con éxito!", "Éxito", 1);
			
			
			
			
		}catch (UnexpectedException e) {
			//Como el de arriba pero de error
			SwingUtil.showMessage("Error SQL en INSERT into ACTIVIDADES!", "Error", 0);

		}
		


	}
	public void insertaHorariosActividad (int idActividad, int idHorarios) {
		db.executeUpdate(sql2,idActividad, idHorarios);
	}
	
	public void insertHorarios(int idActividad, String dia, String horaInicio, String horaFin) {
		db.executeUpdate(sql3, idActividad,dia,horaInicio,horaFin);
	}
	
	
/*
	public void insertaHoras(int idActividad , String dia_sem, String string, String string2) {

		db.executeUpdate(sql2,idActividad , dia_sem,Float.parseFloat(string),Float.parseFloat(string2));
		
		
	}*/

	public List<Object[]> getPeriodos() {
		String sql= "SELECT nombre from periodos";
		return db.executeQueryArray(sql);

	}
/*
	//inserta los dias y hora en ela activada con el id especificado  
	public void inserta_hora(List<Dia> a,int id){

		String insert = "Insert into actividad_horario values(?,?,?,?) ";
		for(Dia i:a){
			db.executeUpdate(insert,id,i.getDia(),i.getIni(),i.getFin());
		}
	}*/

}
