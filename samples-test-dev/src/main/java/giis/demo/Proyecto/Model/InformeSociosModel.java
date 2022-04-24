package giis.demo.Proyecto.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import giis.demo.Proyecto.DTO.ReservaDTO;
import giis.demo.util.Database;
import giis.demo.util.UnexpectedException;
import giis.demo.util.Util;

public class InformeSociosModel {

	public Database db=new Database();

	
	/*
	 * Obtiene un listado de todas las RESERVAS HISTÓRICAS
	 * DE INSTALACIONES SUELTAS (NO RELACIONADAS CON ACTIVIDADES)
	 * (es decir, con idActividad = NULL)
	 * de todos los socios existentes en BD  
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
	 * CORRESPONDIENTES A ACTIVIDADES 
	 * de todos los Socios existentes en BD  
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
	 * DE INSTALACIONES SUELTAS (NO RELACIONADAS CON ACTIVIDADES)
	 * (es decir, con idActividad = NULL)
	 * del Socio con el id indicado como parámetro  
	 */
	public List<ReservaDTO> getReservas(int idSocio) {

		String SQL = "SELECT idReserva , fecha , horaInicio , horaFin , idInstalacion , "
				+ "idActividad , idSocio , estado "
				+ "FROM reservas "
				+ "WHERE idSocio = ? "
				+ "AND idActividad IS NULL " ; 

		try {
			return db.executeQueryPojo(ReservaDTO.class, SQL, idSocio);

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
	 * del Socio con el id indicado como parámetro  
	 */
	public List<ReservaDTO> getReservasTemp(int idSocio , Date ini , Date fin) {

		String SQL = "SELECT idReserva , fecha , horaInicio , horaFin , idInstalacion , "
				+ "idActividad , idSocio , estado "
				+ "FROM reservas "
				+ "WHERE idSocio = ? "
				+ "AND idActividad IS NULL " ; 

		try {
			//Extraemos la lista HISTÓRICA
			List<ReservaDTO> listFull = db.executeQueryPojo(ReservaDTO.class, SQL, idSocio);

			List<ReservaDTO> list = new ArrayList<ReservaDTO>();

			//Recorremos la lista HISTÓRICA 
			for (ReservaDTO r : listFull ) {

				Date f = Util.isoStringToDate(r.getFecha()); 

				//Si la fecha del elemento está entre las indicadas como parámetro, se añade
				if (f.before(fin) && f.after(ini)) {

					list.add(r); 

				}

			}

			return list;
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
	 * del Socio con el id indicado como parámetro  
	 */
	public List<ReservaDTO> getActividades(int idSocio) {

		String SQL = "SELECT idReserva , fecha , horaInicio , horaFin , idInstalacion , "
				+ "idActividad , idSocio , estado "
				+ "FROM reservas "
				+ "WHERE idSocio = ? "
				+ "AND idActividad IS NOT NULL " ; 

		try {
			return db.executeQueryPojo(ReservaDTO.class, SQL, idSocio);

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
	 * del Socio con el id indicado como parámetro  
	 */
	public List<ReservaDTO> getActividadesTemp(int idSocio , Date ini , Date fin) {

		String SQL = "SELECT idReserva , fecha , horaInicio , horaFin , idInstalacion , "
				+ "idActividad , idSocio , estado "
				+ "FROM reservas "
				+ "WHERE idSocio = ? "
				+ "AND idActividad IS NOT NULL " ; 

		try {
			//Extraemos la lista HISTÓRICA
			List<ReservaDTO> listFull = db.executeQueryPojo(ReservaDTO.class, SQL, idSocio);

			List<ReservaDTO> list = new ArrayList<ReservaDTO>();

			//Recorremos la lista HISTÓRICA 
			for (ReservaDTO r : listFull ) {

				Date f = Util.isoStringToDate(r.getFecha()); 

				//Si la fecha del elemento está entre las indicadas como parámetro, se añade
				if (f.before(fin) && f.after(ini)) {

					list.add(r); 

				}

			}

			return list;
		}

		catch(UnexpectedException e) {

			JOptionPane.showMessageDialog(null, "Error SQL en getActividadesTemp() ","Error",
					JOptionPane.WARNING_MESSAGE);
			return null; 

		}
	}

}
