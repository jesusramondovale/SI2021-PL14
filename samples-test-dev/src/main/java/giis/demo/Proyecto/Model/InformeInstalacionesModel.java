package giis.demo.Proyecto.Model;

import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import giis.demo.Proyecto.DTO.ReservaDTO;
import giis.demo.util.Database;
import giis.demo.util.UnexpectedException;
import giis.demo.util.Util;

public class InformeInstalacionesModel {

	public Database db=new Database();


	/*
	 * Obtiene un listado de todas las RESERVAS HISTÓRICAS
	 * DE INSTALACIONES SUELTAS (NO RELACIONADAS CON ACTIVIDADES)
	 * (es decir, con idActividad = NULL)
	 * de CUALQUIER Instalación del centro
	 */
	public List<ReservaDTO> getReservas() {

		String SQL = "SELECT idReserva , fecha , horaInicio , horaFin , idInstalacion , "
				+ "idActividad , idSocio , estado "
				+ "FROM reservas "
				+ "WHERE idActividad IS NULL " ; 

		try {
			return db.executeQueryPojo(ReservaDTO.class, SQL);

		}

		catch(UnexpectedException e) {

			JOptionPane.showMessageDialog(null, "Error SQL en getReservas() ","Error",
					JOptionPane.WARNING_MESSAGE);
			return null; 

		}
	}
	
	
	/*
	 * Obtiene un listado de todas las RESERVAS HISTÓRICAS
	 * DE INSTALACIONES SUELTAS (NO RELACIONADAS CON ACTIVIDADES)
	 * (es decir, con idActividad = NULL)
	 * de CUALQUIER Instalación del centro
	 * PARA EL CLIENTE INDICADO
	 */
	public List<ReservaDTO> getReservasCliente(int id) {

		String SQL = "SELECT idReserva , fecha , horaInicio , horaFin , idInstalacion , "
				+ "idActividad , idSocio , estado "
				+ "FROM reservas "
				+ "WHERE idActividad IS NULL "
				+ "AND idSocio = ? " ; 

		try {
			return db.executeQueryPojo(ReservaDTO.class, SQL, id);

		}

		catch(UnexpectedException e) {

			JOptionPane.showMessageDialog(null, "Error SQL en getReservas() ","Error",
					JOptionPane.WARNING_MESSAGE);
			return null; 

		}
	}
	
	
	
	
	/*
	 * Obtiene un listado de todas las RESERVAS HISTÓRICAS
	 * DE INSTALACIONES SUELTAS (NO RELACIONADAS CON ACTIVIDADES)
	 * (es decir, con idActividad = NULL)
	 * de CUALQUIER Instalación del centro
	 */
	public List<ReservaDTO> getReservasTemp(Date ini , Date fin) {

		String SQL = "SELECT idReserva , fecha , horaInicio , horaFin , idInstalacion , "
				+ "idActividad , idSocio , estado "
				+ "FROM reservas "
				+ "WHERE idActividad IS NULL "
				+ "AND fecha > ? AND fecha <= ? " ; 

		try {
			return db.executeQueryPojo(ReservaDTO.class, SQL , Util.dateToIsoString(ini) , Util.dateToIsoString(fin));

		}

		catch(UnexpectedException e) {

			JOptionPane.showMessageDialog(null, "Error SQL en getReservas() ","Error",
					JOptionPane.WARNING_MESSAGE);
			return null; 

		}
	}
	
	
	
	/*
	 * Obtiene un listado de todas las RESERVAS HISTÓRICAS
	 * DE INSTALACIONES SUELTAS (NO RELACIONADAS CON ACTIVIDADES)
	 * (es decir, con idActividad = NULL)
	 * de CUALQUIER Instalación del centro
	 * para el CLIENTE indicado
	 */
	public List<ReservaDTO> getReservasTempCliente(int id , Date ini , Date fin) {

		String SQL = "SELECT idReserva , fecha , horaInicio , horaFin , idInstalacion , "
				+ "idActividad , idSocio , estado "
				+ "FROM reservas "
				+ "WHERE idActividad IS NULL "
				+ "AND idSocio = ? "
				+ "AND fecha > ? AND fecha <= ? " ; 

		try {
			return db.executeQueryPojo(ReservaDTO.class, SQL , id , Util.dateToIsoString(ini) , Util.dateToIsoString(fin));

		}

		catch(UnexpectedException e) {

			JOptionPane.showMessageDialog(null, "Error SQL en getReservas() ","Error",
					JOptionPane.WARNING_MESSAGE);
			return null; 

		}
	}
	
	
	
	/*
	 * Obtiene un listado de todas las RESERVAS HISTÓRICAS
	 * DE INSTALACIONES SUELTAS (NO RELACIONADAS CON ACTIVIDADES)
	 * (es decir, con idActividad = NULL)
	 * de la instalacion con el id indicado como parámetro  
	 */
	public List<ReservaDTO> getReservas(int id) {

		String SQL = "SELECT idReserva , fecha , horaInicio , horaFin , idInstalacion , "
				+ "idActividad , idSocio , estado "
				+ "FROM reservas "
				+ "WHERE idInstalacion = ? "
				+ "AND idActividad IS NULL " ; 

		try {
			return db.executeQueryPojo(ReservaDTO.class, SQL, id);

		}

		catch(UnexpectedException e) {

			JOptionPane.showMessageDialog(null, "Error SQL en getReservas() ","Error",
					JOptionPane.WARNING_MESSAGE);
			return null; 

		}
	}

	
	/*
	 * Obtiene un listado de todas las RESERVAS HISTÓRICAS
	 * DE INSTALACIONES SUELTAS (NO RELACIONADAS CON ACTIVIDADES)
	 * (es decir, con idActividad = NULL)
	 * de la instalacion con el id indicado como parámetro 
	 * para el CLIENTE indicado 
	 */
	public List<ReservaDTO> getReservasCliente(int idInstalacion , int idCliente) {

		String SQL = "SELECT idReserva , fecha , horaInicio , horaFin , idInstalacion , "
				+ "idActividad , idSocio , estado "
				+ "FROM reservas "
				+ "WHERE idInstalacion = ? "
				+ "AND idSocio = ? "
				+ "AND idActividad IS NULL " ; 

		try {
			return db.executeQueryPojo(ReservaDTO.class, SQL, idInstalacion , idCliente);

		}

		catch(UnexpectedException e) {

			JOptionPane.showMessageDialog(null, "Error SQL en getReservas() ","Error",
					JOptionPane.WARNING_MESSAGE);
			return null; 

		}
	}


	/*
	 * Obtiene un listado de todas las RESERVAS 
	 * comprendidas entre las dos fechas pasadas como parámetro
	 * DE INSTALACIONES SUELTAS (NO RELACIONADAS CON ACTIVIDADES)
	 * (es decir, con idActividad = NULL)
	 * de la instalacion con el id indicado como parámetro  
	 */
	public List<ReservaDTO> getReservasTemp(int id , Date ini , Date fin) {

		String SQL = "SELECT idReserva , fecha , horaInicio , horaFin , idInstalacion , "
				+ "idActividad , idSocio , estado "
				+ "FROM reservas "
				+ "WHERE idInstalacion = ? "
				+ "AND idActividad IS NULL "
				+ "AND fecha > ? AND fecha <= ? " ; 

		try {
			//Extraemos la lista HISTÓRICA
			return db.executeQueryPojo(ReservaDTO.class, SQL, id , Util.dateToIsoString(ini), Util.dateToIsoString(fin));

			
		}

		catch(UnexpectedException e) {

			JOptionPane.showMessageDialog(null, "Error SQL en getReservasTemp() ","Error",
					JOptionPane.WARNING_MESSAGE);
			return null; 

		}
	}


	/*
	 * Obtiene un listado de todas las RESERVAS 
	 * comprendidas entre las dos fechas pasadas como parámetro
	 * DE INSTALACIONES SUELTAS (NO RELACIONADAS CON ACTIVIDADES)
	 * (es decir, con idActividad = NULL)
	 * de la instalacion con el id indicado como parámetro  
	 * para el CLIENTE indicado
	 */
	public List<ReservaDTO> getReservasTempCliente(int idInstalacion , int idCliente , Date ini , Date fin) {

		String SQL = "SELECT idReserva , fecha , horaInicio , horaFin , idInstalacion , "
				+ "idActividad , idSocio , estado "
				+ "FROM reservas "
				+ "WHERE idInstalacion = ? "
				+ "AND idSocio = ? "
				+ "AND idActividad IS NULL "
				+ "AND fecha > ? AND fecha <= ? " ; 

		try {
			//Extraemos la lista HISTÓRICA
			return db.executeQueryPojo(ReservaDTO.class, SQL, idInstalacion , idCliente , Util.dateToIsoString(ini), Util.dateToIsoString(fin));

			
		}

		catch(UnexpectedException e) {

			JOptionPane.showMessageDialog(null, "Error SQL en getReservasTemp() ","Error",
					JOptionPane.WARNING_MESSAGE);
			return null; 

		}
	}
	

	/*
	 * Obtiene un listado de todas las RESERVAS HISTÓRICAS
	 * CORRESPONDIENTES A ACTIVIDADES 
	 * de CUALQUIER instalación del centro
	 */
	public List<ReservaDTO> getActividades() {

		String SQL = "SELECT idReserva , fecha , horaInicio , horaFin , idInstalacion , "
				+ "idActividad , idSocio , estado "
				+ "FROM reservas "
				+ "WHERE idActividad IS NOT NULL " ; 

		try {
			return db.executeQueryPojo(ReservaDTO.class, SQL);

		}

		catch(UnexpectedException e) {

			JOptionPane.showMessageDialog(null, "Error SQL en getActividades() ","Error",
					JOptionPane.WARNING_MESSAGE);
			return null; 

		}
	}

	
	/*
	 * Obtiene un listado de todas las RESERVAS HISTÓRICAS
	 * CORRESPONDIENTES A ACTIVIDADES 
	 * de CUALQUIER instalación del centro
	 * para el CLIENTE indicado
	 */
	public List<ReservaDTO> getActividadesCliente(int id) {

		String SQL = "SELECT idReserva , fecha , horaInicio , horaFin , idInstalacion , "
				+ "idActividad , idSocio , estado "
				+ "FROM reservas "
				+ "WHERE idActividad IS NOT NULL "
				+ "AND idSocio = ? " ; 

		try {
			return db.executeQueryPojo(ReservaDTO.class, SQL , id);

		}

		catch(UnexpectedException e) {

			JOptionPane.showMessageDialog(null, "Error SQL en getActividades() ","Error",
					JOptionPane.WARNING_MESSAGE);
			return null; 

		}
	}

	
	/*
	 * Obtiene un listado de todas las RESERVAS 
	 * CORRESPONDIENTES A ACTIVIDADES 
	 * de CUALQUIER instalación del centro
	 * entre las fechas indicadas
	 */
	public List<ReservaDTO> getActividadesTemp(Date ini, Date fin) {

		String SQL = "SELECT idReserva , fecha , horaInicio , horaFin , idInstalacion , "
				+ "idActividad , idSocio , estado "
				+ "FROM reservas "
				+ "WHERE idActividad IS NOT NULL "
				+ "AND fecha > ? AND fecha <= ? " ; 

		try {
			return db.executeQueryPojo(ReservaDTO.class, SQL , Util.dateToIsoString(ini) , Util.dateToIsoString(fin));

		}

		catch(UnexpectedException e) {

			JOptionPane.showMessageDialog(null, "Error SQL en getActividades() ","Error",
					JOptionPane.WARNING_MESSAGE);
			return null; 

		}
	}

	
	/*
	 * Obtiene un listado de todas las RESERVAS 
	 * CORRESPONDIENTES A ACTIVIDADES 
	 * de CUALQUIER instalación del centro
	 * entre las fechas indicadas
	 * para el CLIENTE indicado
	 */
	public List<ReservaDTO> getActividadesTempCliente(int id , Date ini, Date fin) {

		String SQL = "SELECT idReserva , fecha , horaInicio , horaFin , idInstalacion , "
				+ "idActividad , idSocio , estado "
				+ "FROM reservas "
				+ "WHERE idActividad IS NOT NULL "
				+ "AND idSocio = ? "
				+ "AND fecha > ? AND fecha <= ? " ; 

		try {
			return db.executeQueryPojo(ReservaDTO.class, SQL ,id,  Util.dateToIsoString(ini) , Util.dateToIsoString(fin));

		}

		catch(UnexpectedException e) {

			JOptionPane.showMessageDialog(null, "Error SQL en getActividades() ","Error",
					JOptionPane.WARNING_MESSAGE);
			return null; 

		}
	}

	/*
	 * Obtiene un listado de todas las RESERVAS HISTÓRICAS
	 * CORRESPONDIENTES A ACTIVIDADES 
	 * de la instalacion con el id indicado como parámetro  
	 */
	public List<ReservaDTO> getActividades(int id) {

		String SQL = "SELECT idReserva , fecha , horaInicio , horaFin , idInstalacion , "
				+ "idActividad , idSocio , estado "
				+ "FROM reservas "
				+ "WHERE idInstalacion = ? "
				+ "AND idActividad IS NOT NULL " ; 

		try {
			return db.executeQueryPojo(ReservaDTO.class, SQL, id);

		}

		catch(UnexpectedException e) {

			JOptionPane.showMessageDialog(null, "Error SQL en getActividades() ","Error",
					JOptionPane.WARNING_MESSAGE);
			return null; 

		}
	}


	/*
	 * Obtiene un listado de todas las RESERVAS HISTÓRICAS
	 * CORRESPONDIENTES A ACTIVIDADES 
	 * de la instalacion con el id indicado como parámetro 
	 * para el CLIENTE indicado 
	 */
	public List<ReservaDTO> getActividadesCliente(int idInstalacion , int idCliente) {

		String SQL = "SELECT idReserva , fecha , horaInicio , horaFin , idInstalacion , "
				+ "idActividad , idSocio , estado "
				+ "FROM reservas "
				+ "WHERE idInstalacion = ? "
				+ "AND idSocio = ? "
				+ "AND idActividad IS NOT NULL " ; 

		try {
			return db.executeQueryPojo(ReservaDTO.class, SQL, idInstalacion , idCliente);

		}

		catch(UnexpectedException e) {

			JOptionPane.showMessageDialog(null, "Error SQL en getActividades() ","Error",
					JOptionPane.WARNING_MESSAGE);
			return null; 

		}
	}


	/*
	 * Obtiene un listado de todas las RESERVAS 
	 * comprendidas entre las fechas indicadas como parámetro
	 * CORRESPONDIENTES A ACTIVIDADES 
	 * de la instalacion con el id indicado como parámetro  
	 */
	public List<ReservaDTO> getActividadesTemp(int id , Date ini , Date fin) {

		String SQL = "SELECT idReserva , fecha , horaInicio , horaFin , idInstalacion , "
				+ "idActividad , idSocio , estado "
				+ "FROM reservas "
				+ "WHERE idInstalacion = ? "
				+ "AND idActividad IS NOT NULL "
				+ "AND fecha > ? AND fecha <= ? " ; 

		try {
			//Extraemos la lista HISTÓRICA
			return db.executeQueryPojo(ReservaDTO.class, SQL, id , Util.dateToIsoString(ini) , Util.dateToIsoString(fin));

			
		}

		catch(UnexpectedException e) {

			JOptionPane.showMessageDialog(null, "Error SQL en getActividadesTemp() ","Error",
					JOptionPane.WARNING_MESSAGE);
			return null; 

		}
	}

	
	
	/*
	 * Obtiene un listado de todas las RESERVAS 
	 * comprendidas entre las fechas indicadas como parámetro
	 * CORRESPONDIENTES A ACTIVIDADES 
	 * de la instalacion con el id indicado como parámetro 
	 * para el CLIENTE indicado 
	 */
	public List<ReservaDTO> getActividadesTempCliente(int idInstalacion , int idCliente , Date ini , Date fin) {

		String SQL = "SELECT idReserva , fecha , horaInicio , horaFin , idInstalacion , "
				+ "idActividad , idSocio , estado "
				+ "FROM reservas "
				+ "WHERE idInstalacion = ? "
				+ "AND idSocio = ? "
				+ "AND idActividad IS NOT NULL "
				+ "AND fecha > ? AND fecha <= ? " ; 

		try {
			//Extraemos la lista HISTÓRICA
			return db.executeQueryPojo(ReservaDTO.class, SQL, idInstalacion , idCliente , Util.dateToIsoString(ini) , Util.dateToIsoString(fin));

			
		}

		catch(UnexpectedException e) {

			JOptionPane.showMessageDialog(null, "Error SQL en getActividadesTemp() ","Error",
					JOptionPane.WARNING_MESSAGE);
			return null; 

		}
	}
	
	
	
	
	
}
