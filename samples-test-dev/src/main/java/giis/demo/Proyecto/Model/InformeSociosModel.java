package giis.demo.Proyecto.Model;

import java.util.List;

import javax.swing.JOptionPane;

import giis.demo.Proyecto.DTO.ReservaDTO;
import giis.demo.util.Database;
import giis.demo.util.UnexpectedException;

public class InformeSociosModel {

	public Database db=new Database();

	
	/*
	 * Obtiene un listado de todas las RESERVAS 
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

}
